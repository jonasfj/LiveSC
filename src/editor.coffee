#### Editor Configuration
# Various constants used in the editor, padding and difference sizes, etc.
# Don't mess with these, most of them are more like constants than configuration
# settings.
@cfg =
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
	opacity:
		selected:			0.6
		hover:				0.2

# Automatically computed contants
@cfg.instance.width = @cfg.instance.head.width + @cfg.instance.padding * 2

# LSC namespace if not already there
@LSC ?= {}

#TODO: Implement this...
class @LSC.Document

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


@LSC.initialize = (paper) =>	# Initialize everything
	@Raphael.el.update = (params) -> @animate params, cfg.animation.speed
	@Raphael.el.moveTo = (x, y) ->
			if @type == "path"
				#Translate position iteratively :(
				@translate(x - @getBBox().x, y - @getBBox().y)
				@translate(x - @getBBox().x, y - @getBBox().y)
				@translate(x - @getBBox().x, y - @getBBox().y)
				@translate(x - @getBBox().x, y - @getBBox().y)
				@translate(x - @getBBox().x, y - @getBBox().y)
			else
				return this.attr({x: x, y: y});
	@scene = paper.rect(0,0,"100%","100%")
	@scene.attr
		fill: 		"#fff"
		opacity:	0
		stroke:		"none"



$ =>
	@paper = @Raphael(0,0,"100%", "100%")
	@LSC.initialize(@paper)
	@log = (msg) => $("#log").append(msg + "<br>")
	@inspect = (object) =>
		str = "{"
		for key, value of object
			str += "#{key}: \"#{value}\", "
		return str + "}"
	toolbar = new @LSC.Toolbar(@paper)
	lsc = new @LSC.Chart("Untitled.lsc", @paper)

	addInstance = =>
		i = new @LSC.Instance("new", lsc.instances.length, @paper, lsc)
		lsc.addInstance(i)
		lsc.update()
		i.edit()
	
	dragOver = (event) =>
		event.stopPropagation()
		event.preventDefault()
		event.dataTransfer.dropEffect = 'copy'
	
	dropFile = (event) =>
		event.stopPropagation()
		event.preventDefault()
		files = event.dataTransfer.files
		for f in files
			alert(escape(f.name))

	# handle file loading
	$("body").on("dragover", dragOver)
	$("body").on("drop", dropFile)
	
	download = =>
		data = lsc.serialize()
		dataurl = "data:application/lsc+json;base64,#{$.base64Encode(data)}"
		window.open(dataurl, "_blank")

	isAddingMessage = false
	addMessage = =>
		isAddingMessage = true
		@scene.toFront()
		@scene.attr
			cursor:		"crosshair"

	loc1 = null
	num1 = null
	@scene.click (event) =>
		lsc.clearSelection()
		if isAddingMessage
			num = lsc.xNumber(event.clientX)
			loc = lsc.GetLocation(event.clientY)
			if num1? and loc1?
				if num1 != num
					lsc.createMessage(num1, num, Math.round((loc + loc1) / 2), "msg()")
				num1 = null
				loc1 = null
				isAddingMessage = false
				@scene.toBack()
				@scene.attr
					cursor:		"default"
			else
				num1 = num
				loc1 = loc

	new @LSC.Button("plus", "Add instance", toolbar).click addInstance
	new @LSC.Button("exchange", "Add message", toolbar).click addMessage
	
	new @LSC.Button("trash", "Delete selection", toolbar).click lsc.deleteSelection
	new @LSC.Button("cloudDown", "Download LSC", toolbar).click download
	
	i0 = new @LSC.Instance("I/O", 0, @paper, lsc)
	lsc.addInstance(i0)
	lsc.update()
	i1 = new @LSC.Instance("Control", 1, @paper, lsc)
	lsc.addInstance(i1)
	lsc.update()
	i2 = new @LSC.Instance("Timer1", 2, @paper, lsc)
	lsc.addInstance(i2)
	lsc.update()
	i3 = new @LSC.Instance("Timer2", 3, @paper, lsc)
	lsc.addInstance(i3)
	lsc.update()
	m = new @LSC.Message("helloWorld()", i0, i1, 0, lsc)
	lsc.addMessage(m)
	lsc.update()
	m = new @LSC.Message("replyMessage()", i1, i0, 0, lsc)
	lsc.addMessage(m)
	lsc.update()
	m = new @LSC.Message("helloWorld2()", i0, i1, 0, lsc)
	lsc.addMessage(m)
	lsc.update()
	m = new @LSC.Message("hest", i1, i2, 0, lsc)
	lsc.addMessage(m)
	lsc.update()
	m = new @LSC.Message("test", i2, i1, 0, lsc)
	lsc.addMessage(m)
	lsc.update()

