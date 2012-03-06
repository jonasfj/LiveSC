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

