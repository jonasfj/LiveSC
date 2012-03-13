# LSC namespace if not already there
@LSC ?= {}

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
