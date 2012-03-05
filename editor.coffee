@cfg =
	margin:					10
	instance:
		head:
			width:			150
			height:			40
		padding:			25				# Padding between two instance lines
		foot:
			height:			3
			width:			100
	location:
		height:				40
	chart:
		minwidth:			400
	arrow:
		width:				10
		height:				3
	animation:
		speed:				300
	prechart:
		padding:			50
	toolbar:
		height:				40
	icon:
		height:				24
	opacity:
		selected:			0.6
		hover:				0.2
# Computed keys
@cfg.instance.width = @cfg.instance.head.width + @cfg.instance.padding * 2

@LSC ?= {}



class @LSC.Message
	constructor: (@name, @source, @target, @location, @lsc) ->
		@selected = false
		@rect = @lsc.paper.rect(0, 0, 0, 0, 5)
		@rect.attr
			stroke: 			"none"
			fill: 				"#999"
			opacity: 			0
			cursor:				"pointer"
		@arrow = @lsc.paper.path("")
		@arrow.attr
			"stroke-width": 	2
			fill: 				"black"
			cursor: 			"pointer"
		@text = @lsc.paper.text(0, 0, @name)
		@arrow.hover(@hoverIn, @hoverOut)
		@text.hover(@hoverIn, @hoverOut)
		@rect.hover(@hoverIn, @hoverOut)
		@arrow.drag(@move, @drag, @drop)
		@rect.drag(@move, @drag, @drop)
		@text.drag(@move, @drag, @drop)
		@text.dblclick(@edit)
	hoverIn: =>
		unless @selected
			@rect.update
				opacity: cfg.opacity.hover
	hoverOut: =>
		unless @selected
			@rect.update
				opacity: 0
	select: =>
		unless @selected
			@lsc.clearSelection()
			@selected = true
			@rect.update
				opacity: cfg.opacity.selected
	unselect: =>
		@selected = false
		@rect.update
			opacity: 0
	update: (@y) =>
		xs = @source.x
		xt = @target.x
		ar_w = cfg.arrow.width
		ar_h = cfg.arrow.height
		if xs < xt
			p = "M #{xs},#{y} h #{xt - xs - ar_w} l 0,#{ar_h} #{ar_w},-#{ar_h} -#{ar_w},-#{ar_h} 0,#{ar_h}"
			tx = xs + cfg.instance.width / 2
		else
			p = "M #{xs},#{y} h -#{xs - xt - ar_w} l 0,#{ar_h} -#{ar_w},-#{ar_h} #{ar_w},-#{ar_h} 0,#{ar_h}"
			tx = xs - cfg.instance.width / 2
		@arrow.update
				path: p
		@text.update
				text: @name
				x: tx
				y: y - cfg.margin
		@rect.update
			x: Math.min(xs, xt) - cfg.margin
			y: y - (cfg.location.height - cfg.margin) / 2 - 10 / 2
			width: Math.abs(xs - xt) + 2 * cfg.margin
			height: cfg.location.height - cfg.margin
	drag: (x, y, event) => 			#Start drag
		@select()
	move: (dx, dy, x, y, event) => 	#Move (during drag)
		dst = @lsc.GetLocation(y)
		if dst != @location
			@lsc.moveMessage(@, dst)
	drop: (event) => 				#End drag
	edit: (event) =>				#Edit name
		unless @editor?
			xs = @source.x
			xt = @target.x
			if xs < xt
				x = xs + cfg.arrow.width
			if xs > xt
				x = xs - cfg.instance.width + cfg.arrow.width
			@editor = $("<input type='text'/>")
			@editor.css
				left:			x
				top:			@y - cfg.margin - 10
				width:			cfg.instance.width - cfg.arrow.width * 2
				height:			12
			@editor.addClass("editor")
			$("body").append(@editor)
			@text.attr
				text: ""
				opacity: 0
			@editor.val(@name).focus().select().blur(@unedit).keypress (event) =>
				@unedit() if event.keyCode == 13
	unedit: (event) =>				#End edit
		if @editor?
			return if @editor.val() == ""
			@name = @editor.val()
			@text.attr
				text: @name
				opacity: 1
			@editor.remove()
			@editor = null
	toJSON: => name: @name, location: @location, source: @source.number, target: @target.number
	remove: =>
		@text.remove()
		@rect.remove()
		@arrow.remove()

class @LSC.Instance
	constructor: (@name, @number, @paper, @lsc) ->
		@selected = false
		@head = @paper.rect(0,0,0,0)
		@head.attr
			cursor:			"pointer"
			fill: 			"#999"
			"fill-opacity": 0
		@head.drag(@move, @drag, @drop)
		@head.hover(@hoverIn, @hoverOut)
		@text = @paper.text(0, 0, @name)
		@head.dblclick(@edit)
		@text.dblclick(@edit)
		@line = @paper.path("")
		@line.attr
			"stroke-dasharray":	"-"
		@foot = @paper.rect(0,0,0,0)
		@foot.attr
			"fill":	"black"
		@width = cfg.instance.width
	update: (@x, @y, height) =>
		pad = cfg.instance.padding
		@head.update
			x: 			x - cfg.instance.head.width / 2
			y: 			y 
			width: 		cfg.instance.head.width
			height: 	cfg.instance.head.height
			r: 5
		@text.update
			text: @name
			x: x
			y: y + cfg.instance.head.height / 2
		lh = height - cfg.instance.foot.height - cfg.instance.head.height
		@line.update
			path: "M #{x},#{y + cfg.instance.head.height} v #{lh}"
		@foot.update
			x: 	x - cfg.instance.foot.width / 2
			y: 	y + cfg.instance.head.height + lh
			width: 		cfg.instance.foot.width
			height: 	cfg.instance.foot.height
	drag: (x, y, event) => 			#Start drag
		@select()
	move: (dx, dy, x, y, event) => 	#Move (during drag)
		dst = @lsc.xNumber(x)
		if dst != @number
			@lsc.moveInstance(@, dst)
	drop: (event) => 				#End drag
	edit: (event) =>				#Edit name
		unless @editor?
			@editor = $("<input type='text'/>")
			@editor.css
				left:			@x - cfg.instance.head.width / 2 + cfg.margin / 2
				top:			@y + cfg.margin / 2
				width:			cfg.instance.head.width - cfg.margin
				height:			cfg.instance.head.height - cfg.margin
			@editor.addClass("editor")
			$("body").append(@editor)
			@text.attr
				text: ""
				opacity: 0
			@editor.val(@name).focus().select().blur(@unedit).keypress (event) =>
				@unedit() if event.keyCode == 13
	unedit: (event) =>				#End name edit
		if @editor?
			return if @editor.val() == ""
			@name = @editor.val()
			@text.attr
				text: @name
				opacity: 1
			@editor.remove()
			@editor = null
	hoverIn: =>
		unless @selected
			@head.update
				"fill-opacity":	cfg.opacity.hover
	hoverOut: =>
		unless @selected
			@head.update
				"fill-opacity":	0
	select: =>
		unless @selected
			@lsc.clearSelection()
			@selected = true
			@head.update
				"fill-opacity":	cfg.opacity.selected
	unselect: =>
		@selected = false
		@head.update
			"fill-opacity":	0
	toJSON: => name: @name, number: @number
	remove: =>
		@head.remove()
		@line.remove()
		@foot.remove()
		@text.remove()


class @LSC.Chart
	constructor: (@name, @paper, @x = 0, @y = cfg.toolbar.height) ->
		@messages = []
		@instances = []
		@lineloc = 1			#Location between pre- and postchart
		@locations = 2			#number of locations in chart
		@prechart = @paper.path("")
		@prechart.attr
			"stroke-dasharray": "--"
		@postchart = @paper.path("")
		@update()
	update: =>
		width = Math.max(cfg.instance.width * @instances.length, cfg.chart.minwidth)
		preheight = cfg.instance.head.height + cfg.margin + cfg.location.height * @lineloc
		#redraw prechart
		@prechart.update
			path: """M #{@x + cfg.margin + cfg.prechart.padding} #{@y + cfg.margin}
					 h #{width}
					 l #{cfg.prechart.padding} #{preheight/2}
					 l -#{cfg.prechart.padding} #{preheight/2}
					 h -#{width}
					 l -#{cfg.prechart.padding} -#{preheight/2} z"""
		postheight = cfg.margin + cfg.location.height * (@locations - @lineloc)
		#redraw body
		@postchart.update
			path: """M #{@x + cfg.margin + cfg.prechart.padding},#{@y + cfg.margin + preheight}
					 h #{width} v #{postheight} h -#{width} z"""
		#redraw instances
		for instance in @instances
			yi = @y + 2 * cfg.margin
			hi = preheight + postheight - cfg.margin * 2
			instance.update(@numberX(instance.number), yi, hi)
		#redraw messages
		for message in @messages
			message.update(@locationY(message.location))
	#moves an instance line
	moveInstance: (instance, number) =>
		prev = instance.number
		if prev < number
			for i in @instances
				if prev <= i.number and i.number <= number
					i.number -= 1
		if prev > number
			for i in @instances
				if number <= i.number and i.number <= prev
					i.number += 1
		instance.number = number
		@update()
	addInstance: (instance) =>
		@instances.push(instance)
		instance.number = @instances.length - 1
		instance.paper = @paper
		instance.lsc = @
	addMessage: (message) =>
		@messages.push(message)
		message.location = @locations
		message.paper = @paper
		@locations = @locations + 1
	createMessage: (sourceNumber, targetNumber, location, name) =>
		target = i for i in @instances when i.number == targetNumber
		source = i for i in @instances when i.number == sourceNumber
		m = new LSC.Message(name, source, target, location, @)
		msg.location += 1 for msg in @messages when msg.location >= location
		@lineloc += 1 if @lineloc >= location
		@messages.push m
		@locations = @locations + 1
		@update()
		m.edit()
	numberX: (number) =>	#Given instance number, get x-value
		offset = cfg.prechart.padding + cfg.margin + cfg.instance.width / 2
		return @x + offset + (number * cfg.instance.width)
	xNumber: (x) =>			#Given x-value for instance, get nearest number
		offset = cfg.prechart.padding + cfg.margin + cfg.instance.width / 2
		n = Math.round((x - @x - offset) / cfg.instance.width)
		n = 0 if n < 0
		n = @instances.length - 1 if n >= @instances.length
		return n
	locationY: (location) =>	#Given atom location get y-value
		return @y + 2 * cfg.margin + cfg.instance.head.height + cfg.location.height * location
	GetLocation: (y) =>			#Given y-value for atom get location
		loc = Math.round((y - @y - 2 * cfg.margin - cfg.instance.head.height) / cfg.location.height)
		if loc < 1
			loc = 1
		if loc >= @locations
			loc = @locations - 1
		return loc
	moveMessage: (message, location) =>		# moves a message
		prev = message.location
		if prev < location
			for m in @messages
				if prev <= m.location and m.location <= location
					m.location -= 1
			if prev <= @lineloc and @lineloc <= location
				@lineloc -= 1
		if prev > location
			for m in @messages
				if location <= m.location and m.location <= prev
					m.location += 1
			if location <= @lineloc and @lineloc <= prev
				@lineloc += 1
		message.location = location
		@update()
	clearSelection: =>
		m.unselect() for m in @messages when m.selected
		i.unselect() for i in @instances when i.selected
	deleteMessage: (m) =>
		for msg in @messages when msg.location > m.location
			msg.location -= 1
		@messages = (msg for msg in @messages when msg != m)
		m.remove()
		@lineloc -= 1 if m.location < @lineloc
		@locations -= 1
		delete m
	deleteInstance: (i) =>
		for inst in @instances when inst.number > i.number
			inst.number -= 1
		@instances = (inst for inst in @instances when inst != i)
		i.remove()
		for m in @messages when m.source == i or m.target == i
			@deleteMessage(m)
		delete i
	deleteSelection: =>
		@deleteMessage(m) for m in @messages when m.selected
		@deleteInstance(i) for i in @instances when i.selected
		@update()
	toJSON: =>
			name:			"Untitled Chart"
			lineloc:		@lineloc
			locations:		@locations
			instances:		(i.toJSON() for i in @instances)
			messages:		(m.toJSON() for m in @messages)
	fromJSON: (json) =>
		#TODO: Load data form json
	serialize: => $.toJSON(@toJSON())
	deserialize: (data) => @fromJSON($.secureEvalJSON(data))

class @LSC.Document
#TODO: Implement this...

class @LSC.Toolbar
	constructor: (@paper) ->
		#draw background
		@bg = @paper.rect(0, 0, "100%", cfg.toolbar.height)
		@bg.attr
			fill:"#aaa"
			"stroke":"none"
		@paper.rect(0, cfg.toolbar.height, "100%", 1).attr({stroke: "none", fill: "#999"})
		#filename
		@title = @paper.text(cfg.margin, cfg.toolbar.height / 2, "Untitled.lsc")
		.attr({"text-anchor":"start",font:"Verdana","font-weight":"bold"})
		@buttons = []
		@title.click(@edit)
		@title.hover(@hoverIn, @hoverOut)
	update: =>
		pad = (cfg.toolbar.height - cfg.icon.height) / 2
		x = y = pad
		x += @title.getBBox().width + pad
		for icon in @buttons
			icon.update(x, y)
			x += icon.rect.getBBox().width + 2 * pad
	addButton: (button) =>
		@buttons.push(button)
		pad = (cfg.toolbar.height - cfg.icon.height) / 2
		y = pad
		x = cfg.margin + @title.getBBox().width + cfg.margin
		x += (cfg.icon.height + 2 * pad) * (@buttons.length - 1)
		button.update(x, y)

	edit: (event) =>				#Edit name
			unless @editor?
				@editor = $("<input type='text'/>")
				@editor.css
					left:			cfg.margin
					top:			cfg.margin+2
					width:			@title.getBBox().width
					background:		"#ccc"
					height:			12
				@editor.addClass("editor")
				$("body").append(@editor)
				text = @title.attr("text")
				@title.attr
					text: ""
					opacity: 0
				@editor.val(text).focus().select().blur(@unedit).keypress (event) =>
					@unedit() if event.keyCode == 13

	unedit: (event) =>				#End edit
		if @editor?
			name = @editor.val()
			return if name == ""
			@title.attr
				text: name
				opacity: 1
			@editor.remove()
			@editor = null
		@update()
	hoverIn: =>
		@title.attr
			cursor: "text"
			opacity: 0.5
	hoverOut: =>
		@title.attr
			cursor: "arrow"
			opacity: 1
	setTitle: (title) =>
		@title.attr
			text: title
		@update()

class @LSC.Button
	constructor: (icon, @tooltip, @toolbar) ->
		@icon = @toolbar.paper.path(Icons[icon])
		@icon.attr
			fill:	"#777"
			stroke:	"#fff"
			"stroke-opacity": 0
		sf = cfg.icon.height / @icon.getBBox().height
		@icon.scale(sf, sf, 0, 0)
		@rect = @toolbar.paper.rect(0, 0, @icon.getBBox().width, cfg.icon.height)
		@rect.attr
			fill:		"#fff"
			opacity:	0
			title: @tooltip
			cursor: "pointer"
		@rect.hover(@hoverIn, @hoverOut)
		@toolbar.addButton(@)
	update: (x,y) ->
		@icon.moveTo x, y
		@rect.moveTo x, y
	hoverIn: =>
		@icon.stop().animate
				fill: "#333"
				"stroke-opacity": 0	#1
			, 100
	hoverOut: =>
		@icon.stop().animate
				fill: "#777"
				"stroke-opacity": 0
			, 200
	click: (action) => 
		@rect.click action


@LSC.initialize = (paper) =>	# Initialize everything
	@Raphael.el.update = (params) -> @animate params, cfg.animation.speed
	@Raphael.el.moveTo = (x, y) ->
			if @type == "path"
				#Translate position iteratively :(
				@translate(x - @getBBox().x, y - @getBBox().y)
				@translate(x - @getBBox().x, y - @getBBox().y)
				@translate(x - @getBBox().x, y - @getBBox().y)
				@translate(x - @getBBox().x, y - @getBBox().y)
				@translate(x - @getBBox().x, y - @getBBox().y)
			else
				return this.attr({x: x, y: y});
	@scene = paper.rect(0,0,"100%","100%")
	@scene.attr
		fill: 		"#fff"
		opacity:	0
		stroke:		"none"


