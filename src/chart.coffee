@LSC ?= {}

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
			yi = @y + 2 * cfg.margin			# Why is there an y here???
			hi = preheight + postheight - cfg.margin * 2
			instance.update(@numberX(instance.number), yi, hi)
		#redraw messages
		for message in @messages
			message.update(@locationY(message.location))
		height = @y + cfg.margin + preheight + postheight + cfg.margin
		@updateSize(@x + 2 * (cfg.margin + cfg.prechart.padding) + width, height)
	#Update paper size for this chart
	updateSize: (width, height) =>
		# Only update width and height if necessary
		if width != @width or height != @height
			@width = width
			@height = height
			@paper.setSize(width, height)
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

