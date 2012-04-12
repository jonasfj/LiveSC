@LSC ?= {}

class @LSC.Chart
	constructor: (@paper, @x = 0, @y = cfg.toolbar.height) ->
		@name = "Untitled Chart"
		@messages = []
		@instances = []
		@lineloc = 1			#Location between pre- and postchart
		@locations = 3			#number of locations in chart
		@resloc = 2				#Location between post- and restrictchart
		@prechart = @paper.path("")
		@prechart.attr
			"stroke-dasharray": "--"
		@postchart = @paper.path("")
		@restrictchart = @paper.path("") #box for restricted messages
		@isAddingMessage = false
		@addingM = null
		$("#workspace").css("cursor", "default")
		@title = @paper.text(10, 20, @name)
		@title.attr
			"font-size": 			24
			"text-anchor":			'start'
		@title.dblclick(@edit)
	change: (callback) -> #Til sidebar fra editor-klassen
		if callback?
			@changeCallback = callback
		else
			@changeCallback?(@)
	edit: =>
		unless @editor?
			@editor = $("<input type='text' id='input'/>")
			@editor.addClass("editor")
			@editor.css
				left:			'10px'
				top:			'2px'
				width:			"95%"
				"font-size": 	24
			@editor.appendTo("#workspace")
			@title.attr
				text: 		""
				opacity: 	0
			@editor.val(@name).focus().select().blur(@unedit).keypress (event) =>
				@unedit() if event.keyCode == 13
	unedit: (event) =>				#End name edit
		if @editor?
			if @editor.val() == ""
				event.stopPropagation()
				event.preventDefault()
				return
			@name = @editor.val()	# TODO: Ensure unique name with given chart
			@title.attr
				text: 		@name
				opacity: 	1
			@editor.remove()
			@editor = null
			@change()
	update: (instant = false) =>
		LSC.instant() if instant
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
		postheight = 2*cfg.margin + cfg.location.height * (@resloc - @lineloc)
		#redraw body
		@postchart.update
			path: """M #{@x + cfg.margin + cfg.prechart.padding},#{@y + cfg.margin + preheight}
					 h #{width} v #{postheight} h -#{width} z"""

		restrictheight = cfg.location.height * (@locations - @resloc) - cfg.location.height;

		#restricts chart
		@restrictchart.update
			path: """M #{@x + cfg.margin + cfg.prechart.padding},#{@y + cfg.margin + preheight + postheight}
					 h #{width} v #{restrictheight} h -#{width} z"""

		#redraw instances
		for instance in @instances
			yi = @y + 2 * cfg.margin			# Why is there an y here???
			hi = preheight + postheight - cfg.margin * 2
			instance.update(yi, hi)
		#redraw messages
		for message in @messages
			message.update()
		height = @y + cfg.margin + preheight + postheight + cfg.margin + restrictheight
		#redraw title
		@title.attr
			text: @name
		@updateSize(@x + 2 * (cfg.margin + cfg.prechart.padding) + width, height)
		LSC.animate() if instant
	#Update paper size for this chart
	updateSize: (width, height) =>
		# Only update width and height if necessary
		width = Math.max($(window).width() - cfg.sidebar.width - cfg.margin, width)
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
		if @instances.length > 1
			@isAddingMessage = true
			$("#workspace").css("cursor", "crosshair")
			@addingM = null
	mouseDown: (event) =>
		if @isAddingMessage
			event.stopPropagation()
			x = LSC.pageX2RaphaelX(event.pageX)
			s_num = @xNumber(x)
			if @numberX(s_num) > x
				t_num = s_num - 1
				t_num = 1 if t_num < 0
			else
				t_num = s_num + 1
				t_num = s_num - 1 if t_num >= @instances.length
			loc = @GetLocation(LSC.pageY2RaphaelY(event.pageY))
			@addingM = @createMessage(s_num, t_num, loc, "msg()", false)
	mouseMove: (event) =>
		if isNaN event.pageY
			log "pis"
		if isNaN event.pageX
			log "pis!"
		if @isAddingMessage and @addingM?
			event.stopPropagation()
			x = LSC.pageX2RaphaelX(event.pageX)
			t_num = @xNumber(x)
			loc = @GetLocation(LSC.pageY2RaphaelY(event.pageY))
			if t_num == @addingM.source.number
				s_num = @addingM.source.number
				if @numberX(s_num) > x
					t_num = s_num - 1
					t_num = 1 if t_num < 0
				else
					t_num = s_num + 1
					t_num = s_num - 1 if t_num >= @instances.length
			target = i for i in @instances when i.number == t_num
			if @addingM.target != target or loc != @addingM.location
				@addingM.target = target
				if loc != @addingM.location
					@moveMessage(@addingM, loc)
				else
					@addingM.update()
	mouseUp: (event) =>
		if @isAddingMessage
			@mouseMove(event)
			@isAddingMessage = false
			$("#workspace").css("cursor", "default")
			@addingM.edit()
			@addingM = null
	createMessage: (sourceNumber, targetNumber, location, name, edit = true) =>
		target = i for i in @instances when i.number == targetNumber
		source = i for i in @instances when i.number == sourceNumber
		m = new LSC.Message(name, source, target, location, @)
		msg.location += 1 for msg in @messages when msg.location >= location
		@lineloc += 1 if @lineloc >= location
		# update restrict location index.
		@resloc += 1 if location <= @resloc
		@messages.push m
		@locations = @locations + 1
		@update()
		m.edit()		if edit
		return m
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
		#move message down
		if prev < location
			for m in @messages
				if prev <= m.location and m.location <= location
					m.location -= 1
			if prev <= @lineloc and @lineloc <= location
				@lineloc -= 1
			if prev <= @resloc and @resloc <= location
				@resloc -= 1
		#move message up
		if prev > location
			for m in @messages
				if location <= m.location and m.location <= prev
					m.location += 1
			if location <= @lineloc and @lineloc <= prev
				@lineloc += 1
			if location <= @resloc and @resloc <= prev
				@resloc += 1
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
		@resloc -= 1 #TODO: check if this works
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
			name:			@name
			lineloc:		@lineloc
			resloc:			@resloc
			locations:		@locations
			instances:		(i.toJSON() for i in @instances)
			messages:		(m.toJSON() for m in @messages)
	@emptyJSON:
		name: "Untitled Chart"
		lineloc:			1
		resloc:				2
		locations:			3
		instances:			[]
		messages:			[]
	fromJSON: (json) =>
		@name = json.name
		@lineloc = json.lineloc
		@resloc = json.resloc
		@locations = json.locations
		for inst in json.instances
			@instances.push new LSC.Instance(inst.name, inst.number, @paper, @)
		for msg in json.messages
			for i in @instances
				source = i		if i.name == msg.source
				target = i		if i.name == msg.target
			@messages.push new LSC.Message(msg.name, source, target, msg.location, @)
		@update(true)
	serialize: => $.toJSON(@toJSON())
	deserialize: (data) => @fromJSON($.secureEvalJSON(data))

