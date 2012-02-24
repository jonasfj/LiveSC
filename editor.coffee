cfg =
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
		minheight:			100
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
# Computed keys
cfg.instance.width = cfg.instance.head.width + cfg.instance.padding * 2

@LSC = {}

class @LSC.Message
	constructor: (@name, @source, @target, @location, @paper) ->
		@arrow = @paper.path("")
		@arrow.attr
			"stroke-width": 	2
			fill: 				"black"
			cursor: 			"pointer"
		@text = @paper.text(0, 0, @name)
		@text.attr
			cursor:				"pointer"
		@arrow.hover(@hoverIn, @hoverOut)
	hoverIn: =>
		@aglow = @arrow.glow
					color:"lime"
					opacity:0.75
					width:2
					fill:true
	hoverOut: => 	@aglow.remove() if @aglow?
	update: (@y) =>
		xs = @source.x
		xt = @target.x
		ar_w = cfg.arrow.width
		ar_h = cfg.arrow.height
		if xs < xt
			p = "M #{xs},#{y} h #{xt - xs - ar_w} l 0,#{ar_h} #{ar_w},-#{ar_h} -#{ar_w},-#{ar_h} 0,#{ar_h}"
			xs = xs + cfg.instance.width/2
		else
			p = "M #{xs},#{y} h -#{xs - xt - ar_w} l 0,#{ar_h} -#{ar_w},-#{ar_h} #{ar_w},-#{ar_h} 0,#{ar_h}"
			xs = xs - cfg.instance.width/2
		@arrow.stop().animate
				path: p
			, cfg.animation.speed
		@text.stop().animate
				text: @name
				x: xs
				y: y - cfg.margin
			, cfg.animation.speed

class @LSC.InstanceLine
	constructor: (@name, @number, @paper, @lsc) ->
		@head = @paper.rect(0,0,0,0)
		@head.attr
			cursor: "pointer"
			fill: "white"
		@head.drag(@move, @drag, @drop)
		@text = @paper.text(0, 0, @name)
		@line = @paper.path("")
		@line.attr
			"stroke-dasharray": "-"
		@foot = @paper.rect(0,0,0,0)
		@foot.attr
			"fill":"black"
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
		@dragStartNumber = @number
	move: (dx, dy, x, y, event) => 	#Move (during drag)
		###if @dragStartNumber?
			dst = @dragStartNumber + Math.round(dx / cfg.instance.width)
			dst = 0 if dst < 0
			dst = @lsc.instances.length - 1 if dst >= @lsc.instances.length
			if dst != @number
				@lsc.moveInstance(@, dst)
		###
		dst = @lsc.xNumber(x)
		if dst != @number
			@lsc.moveInstance(@, dst)
	drop: (event) => 				#End drag
		@dragStartNumber = null
class @LSC.LiveSequenceChart
	constructor: (@name, @paper, @x = 0, @y = cfg.toolbar.height) ->
		@paper.raphael.el.update = (params) -> @animate params, cfg.animation.speed
		@messages = []
		@instances = []
		@conditions = []
		@prelocations = 0		#number of locations in prechart
		@locations = 0			#number of locations in chart (including prechart)
		@prechart = @paper.path("")
		@prechart.attr
			"stroke-dasharray": "--"
		@postchart = @paper.path("")
		@update()
	update: =>
		width = Math.max(cfg.instance.width * @instances.length, cfg.chart.minwidth)
		preheight = cfg.location.height * (@prelocations + 1) + cfg.instance.head.height + cfg.margin
		postlocations = @locations - @prelocations
		#redraw prechart
		@prechart.update
			path: """M #{@x + cfg.margin + cfg.prechart.padding} #{@y + cfg.margin}
					 h #{width}
					 l #{cfg.prechart.padding} #{preheight/2}
					 l -#{cfg.prechart.padding} #{preheight/2}
					 h -#{width}
					 l -#{cfg.prechart.padding} -#{preheight/2} z"""
		postheight = Math.max(cfg.location.height * (postlocations + 1), cfg.chart.minheight) + cfg.margin
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
		message.location = @locations + 1
		message.paper = @paper
		@locations = @locations + 1
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
		if location < @prelocations
			return @y + 2 * cfg.margin + cfg.location.height * location
		else
			ym = @y + cfg.margin + cfg.location.height * (@prelocations + 1) + cfg.instance.head.height
			ym += cfg.margin + cfg.location.height * location
			return ym
	yLocation: (y) =>			#Given y-value for atom get location

class @LSC.Toolbar
	constructor: (@paper) ->
		#draw background
		@bg = @paper.rect(0,0,"100%",cfg.toolbar.height)
		@bg.attr
			fill:"#aaa"
			#"fill": [90,"#ccc","#fff"].join("-")
			"stroke":"none"
		@paper.rect(0,cfg.toolbar.height,"100%",1).attr({stroke:"none", fill:"#999"})
		#filename
		@title = @paper.text(cfg.margin, cfg.toolbar.height / 2, "Untitled.lsc")
		.attr({"text-anchor":"start",font:"Verdana","font-weight":"bold"})
		@buttons = []
	update: =>
		pad = (cfg.toolbar.height - cfg.icon.size) / 2
		x = y = pad
		x += @title.getBBox().width + pad
		for icon in @icons
			icon.update(x, y)
			x += icon.rect.getBBox().width + 2 * pad
	addButton: (button) =>
		@buttons.push(button)
		pad = (cfg.toolbar.height - cfg.icon.height) / 2
		y = pad
		x = cfg.margin + @title.getBBox().width + cfg.margin
		x += (cfg.icon.height + 2 * pad) * (@buttons.length - 1)
		button.update(x, y)
	setTitle: (title) ->
		@title.update
			text: title
		@update()

class @LSC.Button
	constructor: (icon, @tooltip, @toolbar) ->
		@icon = @toolbar.paper.path(Icons[icon])
		@icon.attr
			fill: "#777"
			stroke:"#fff"
			"stroke-opacity": 0
		sf = cfg.icon.height / @icon.getBBox().height
		@icon.scale(sf, sf, 0, 0)
		@rect = @toolbar.paper.rect(0, 0, @icon.getBBox().width, cfg.icon.height)
		@rect.attr
			fill: "#fff"
			opacity: 0
			title: @tooltip
			cursor: "pointer"
		@rect.hover(@hoverIn, @hoverOut)
		@toolbar.addButton(@)
	update: (x,y) ->
		#Translate position iteratively :(
		@icon.translate(x - @icon.getBBox().x, y - @icon.getBBox().y)
		@icon.translate(x - @icon.getBBox().x, y - @icon.getBBox().y)
		@icon.translate(x - @icon.getBBox().x, y - @icon.getBBox().y)
		@icon.translate(x - @icon.getBBox().x, y - @icon.getBBox().y)
		@icon.translate(x - @icon.getBBox().x, y - @icon.getBBox().y)
		@rect.attr
			x: x
			y: y
	hoverIn: =>
		@icon.stop().animate
				fill: "#333"
				"stroke-opacity": 1
			, 100
	hoverOut: =>
		@icon.stop().animate
				fill: "#777"
				"stroke-opacity": 0
			, 200
	click: (action) => 
		@rect.click action
