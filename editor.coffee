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
		if @dragStartNumber?
			dst = @dragStartNumber + Math.round(dx / cfg.instance.width)
			dst = 0 if dst < 0
			dst = @lsc.instances.length - 1 if dst >= @lsc.instances.length
			if dst != @number
				@lsc.moveInstance(@, dst)
	drop: (event) => 				#End drag
		@dragStartNumber = null
class @LSC.LiveSequenceChart
	constructor: (@name, @paper) ->
		@paper.raphael.el.update = (params) -> @animate params, cfg.animation.speed
		@messages = []
		@instances = []
		@conditions = []
		@prelocations = 0		#number of locations in prechart
		@locations = 0			#number of locations in chart (including prechart)
		@prechart = @paper.path("")
		@prechart.attr
			"stroke-dasharray": "-"
		@postchart = @paper.path("")
		@x = @y = 0
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
	numberX: (number) =>
		return @x + cfg.prechart.padding + cfg.margin + cfg.instance.width / 2 + (number * cfg.instance.width)
	locationY: (location) =>
		if location < @prelocations
			return @y + 2 * cfg.margin + cfg.location.height * location
		else
			ym = @y + cfg.margin + cfg.location.height * (@prelocations + 1) + cfg.instance.head.height
			ym += cfg.margin + cfg.location.height * location
			return ym
