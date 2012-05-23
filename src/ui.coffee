# LSC namespace if not already there
@LSC ?= {}
@LSC.Toolbar = Toolbar = {}

toolbar = null
editor = null

Toolbar.initialize = ->
	toolbar = $("<span>Untitled</span>")
	toolbar.addClass("filename")
	toolbar.appendTo("#toolbar")
	raise = -> toolbar.css
			cursor: "text"
			opacity: .50
	lower = -> toolbar.css
			cursor: "arrow"
			opacity: 1.0
	unedit = ->
		name = editor.val()
		return if name == ""
		toolbar.html(name)
		setDocTitle(name)
		toolbar.css
			visibility:		"visible"
		editor.remove()
		editor = null
	edit = ->
		unless editor?
			editor = $("<input type='text'/>")
			editor.css
				left:			cfg.margin
				top:			cfg.margin+2
				width:			toolbar.width()
				background:		"#ccc"
				height:			12
			editor.addClass("editor centered")
			$("body").append(editor)
			text = toolbar.html()
			toolbar.css 
				visibility: "hidden"
			editor.val(text).focus().select().blur(unedit).keypress (event) =>
				unedit() if event.keyCode == 13
	toolbar.hover(raise, lower)
	toolbar.click edit

Toolbar.setTitle = (title) -> toolbar.html(title)
Toolbar.getTitle = -> toolbar.html()

@LSC.Separator = ->
	div = $("<div></div>")
	div.addClass("separator")
	div.appendTo("#toolbar")

floatright = false
@LSC.FloatRight = -> floatright = true

@LSC.Button = (button) ->
	if Icons[button.icon]?
		p = Icons[button.icon]
	else
		p = LSC.Icons[button.icon]
	div = $("<div></div>")
	div.addClass("toolbaritem")
	div.appendTo("#toolbar")
	if floatright
		div.css
			float:		"right"
	paper = Raphael(div[0], 40, 40)
	icon = paper.path(p)
	icon.attr
		fill:				"#777"
		stroke:				"#fff"
		"stroke-opacity": 	0
	icon.translate(4,4)
	rect = paper.rect(0, 0, 40, 40)
	rect.attr
		fill:		"#fff"
		opacity:	0
		title: 		button.tooltip
		cursor: 	"pointer"
	raise = -> icon.animate
				fill: "#333"
				"stroke-opacity": 0
			, 100
	lower = -> icon.animate
				fill: "#777"
				"stroke-opacity": 0
			, 200
	rect.hover(raise, lower)
	rect.click button.action
	
	# Populate the instruction list

	help = $("<div></div>")
	help.addClass("infoitem")
	help.appendTo("#infolist")

	img = $("<div></div>")
	img.addClass("infoicon")
	img.appendTo(help)

	ipaper = Raphael(img[0], 80, 80)
	imgp = ipaper.path(p)
	imgp.translate(16, 16)
	imgp.scale(2.0)
	imgp.attr
		fill:				"#777"
		stroke:				"#fff"
		"stroke-opacity": 	0

	text = $("<div></div>")
	text.html(button.help)
	text.addClass("infotext")
	text.appendTo(help)


















