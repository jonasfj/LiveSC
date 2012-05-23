# LSC namespace if not already there
@LSC ?= {}

class @LSC.Toolbar
	constructor: (container) ->
		@span = $("<span>Untitled</span>")
		@span.addClass("filename")
		@span.appendTo(container)
		@span.click(@edit)
		@span.hover(@hoverIn, @hoverOut)
	edit: (event) =>				#Edit name
			unless @editor?
				@editor = $("<input type='text'/>")
				@editor.css
					left:			cfg.margin
					top:			cfg.margin+2
					width:			@span.width()
					background:		"#ccc"
					height:			12
				@editor.addClass("editor centered")
				$("body").append(@editor)
				text = @span.html()
				@span.css 
					visibility: "hidden"
				@editor.val(text).focus().select().blur(@unedit).keypress (event) =>
					@unedit() if event.keyCode == 13

	unedit: (event) =>				#End edit
		if @editor?
			name = @editor.val()
			return if name == ""
			@span.html(name)
			setDocTitle(name)
			@span.css
				visibility:"visible"
			@editor.remove()
			@editor = null
	hoverIn: =>
		@span.css
			cursor: "text"
			opacity: .50
	hoverOut: =>
		@span.css
			cursor: "arrow"
			opacity: 1.0
	setTitle: (title) =>
		@span.html(title)
	getTitle: =>
		return @span.html()

class @LSC.Button
	constructor: (icon, @tooltip, @toolbar) ->
		if Icons[icon]?
			p = Icons[icon]
		else
			p = LSC.Icons[icon]
		div = $("<div></div>")
		div.addClass("toolbaritem")
		div.appendTo(@toolbar)
		@paper = Raphael(div[0], 40, 40)
		@icon = @paper.path(p)
		@icon.attr
			fill:	"#777"
			stroke:	"#fff"
			"stroke-opacity": 0
		#sf = cfg.icon.height / @icon.getBBox().height
		#@icon.scale(sf, sf, 0, 0)
		@icon.translate(4,4)
		@rect = @paper.rect(0, 0, 40, 40)
		@rect.attr
			fill:		"#fff"
			opacity:	0
			title: @tooltip
			cursor: "pointer"
		@rect.hover(@hoverIn, @hoverOut)
	hoverIn: =>
		@icon.stop().animate
				fill: "#333"
				"stroke-opacity": 0
			, 100
	hoverOut: =>
		@icon.stop().animate
				fill: "#777"
				"stroke-opacity": 0
			, 200
	click: (action) =>
		@rect.click action
