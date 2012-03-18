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
		@isAddingMessage = false
		@smd_num = @smd_loc = null
		@update()
		$("#workspace").css("cursor", "default")
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
	addMessage: =>
		@isAddingMessage = true
		$("#workspace").css("cursor", "crosshair")
		@smd_num = @smd_loc = null
	mouseDown: (event) =>
		if @isAddingMessage
			event.stopPropagation()
			@smd_num = @xNumber(LSC.pageX2RaphaelX(event.pageX))
			@smd_loc = @GetLocation(LSC.pageY2RaphaelY(event.pageY))
	mouseUp: (event) =>
		if @isAddingMessage
			@isAddingMessage = false
			$("#workspace").css("cursor", "default")
			event.stopPropagation()
			num = @xNumber(LSC.pageX2RaphaelX(event.pageX))
			loc = @GetLocation(LSC.pageY2RaphaelY(event.pageY))
			if @smd_num? and @smd_loc?
				if @smd_num != num
					@createMessage(@smd_num, num, Math.round((@smd_loc + loc) / 2), "msg()")
				@smd_num = @smd_loc = null
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
	createInstance: =>
		i = new LSC.Instance("New instance", @instances.length, @paper, @)
		@instances.push(i)
		@update()
		i.edit()
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
	clearSelection: (e) =>
		deselected = false	# Stop event propergation if we deselected anything
		for m in @messages when m.selected
			m.unselect()
			deselected = true
		for i in @instances when i.selected
			i.unselect()
			deselected = true
		e?.stopPropagation?()			if deselected
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
	@emptyJSON:
		name: "Untitled Chart"
		lineloc:			1
		locations:			2
		instances:			[]
		messages:			[]
	fromJSON: (json) =>
		@name = json.name
		@lineloc = json.lineloc
		@locations = json.locations
		for inst in json.instances
			@instances.push new LSC.Instance(inst.name, inst.number, @paper, @)
		for msg in json.messages
			for i in @instances
				source = i		if i.number == msg.source
				target = i		if i.number == msg.target
			@messages.push new LSC.Message(msg.name, source, target, msg.location, @)
	serialize: => $.toJSON(@toJSON())
	deserialize: (data) => @fromJSON($.secureEvalJSON(data))

