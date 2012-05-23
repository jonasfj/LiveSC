@LSC ?= {}

class @LSC.Instance
	constructor: (@name, @number, @env, @paper, @lsc) ->
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
		@head.mousedown(@select)
		@text.mousedown(@select)
		@line = @paper.path("")
		@line.attr
			"stroke-dasharray":	"-"
		@foot = @paper.rect(0,0,0,0)
		@foot.attr
			"fill":	"black"
		@width = cfg.instance.width
	update: (@y, height) =>
		x = @lsc.numberX(@number)
		pad = cfg.instance.padding

		# draw as env or system object
		if @env
			@head.attr
				"stroke-dasharray":"--"
		else
			@head.attr
				"stroke-dasharray":""

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
	move: (dx, dy, x, y, event) => 	#Move (during drag)
		dst = @lsc.xNumber(LSC.pageX2RaphaelX(x))
		if dst != @number
			@lsc.moveInstance(@, dst)
	drop: (event) => 				#End drag
	edit: (event) =>				#Edit name
		unless @editor?
			@editor = $("<input type='text'/>")
			@editor.css
				left:			@lsc.numberX(@number) - cfg.instance.head.width / 2 + cfg.margin / 2
				top:			@y + cfg.margin / 2
				width:			cfg.instance.head.width - cfg.margin
				height:			cfg.instance.head.height - cfg.margin
			@editor.addClass("editor centered")
			@editor.appendTo("#workspace")

			@text.attr
				text: ""
				opacity: 0
			@editor.mousedown (e) -> e.stopPropagation()
			@editor.val(@name).focus().select().blur(@unedit).keypress (event) =>
				@unedit() if event.keyCode == 13
	unedit: (event) =>				# End name edit
		if @editor?
			return if @editor.val() == ""
			
			return if !cfg.regex.namepattern.test(@editor.val())
			
			# Sanity cleanup with regex
			val = @editor.val().trim().match(cfg.regex.namepattern).join('')
			
			# Check if the name conflicts with another instance
			inst = @lsc.getInstanceByName(val)

			if inst? and inst.number != @number
				@editor.val(@name)
				@editor.css("background","yellow").focus()
				return
			@name = val
			@text.attr
				text: @name
				opacity: 1
			@editor.remove()
			@editor = null
			@lsc.change()

			# Ensure that instance conforms to the already specified player
			player = @lsc.getInstanceByNameInAllCharts(val)
			if player?
				@env = player.env
				@lsc.update()
			
	hoverIn: =>
		unless @selected
			@head.update
				"fill-opacity":	cfg.opacity.hover
	hoverOut: =>
		unless @selected
			@head.update
				"fill-opacity":	0
	select: (event) =>
		event?.stopPropagation?()
		unless @selected
			@lsc.clearSelection()
			@selected = true
			@head.update
				"fill-opacity":	cfg.opacity.selected
	unselect: =>
		@selected = false
		@head.update
			"fill-opacity":	0
	toJSON: => name: @name, number: @number, env: @env
	remove: =>
		@head.remove()
		@line.remove()
		@foot.remove()
		@text.remove()
