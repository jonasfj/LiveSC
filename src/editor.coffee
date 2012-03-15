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

# Initialize everything
@LSC.initialize = (paper) =>
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

@CurrentChart = null

# Convert PageX, PageY to raphael coordinates
@LSC.pageX2RaphaelX = (x) -> x + $("#workspace").scrollLeft() - $("#workspace").offset().left;
@LSC.pageY2RaphaelY = (y) -> y + $("#workspace").scrollTop() - $("#workspace").offset().top;


#### Initialize the editor
$ =>
	$(window).resize ->
		$("#workspace").height($(window).height() - cfg.toolbar.height)
	$(window).resize()
	
	@paper = @Raphael("workspace", "400", "400")
	@LSC.initialize(@paper)
	@log = (msg) =>
		if console?.log?
			console.log msg
		else
			alert "Provide console.log for log messages"
			@log = (msg) ->
	@inspect = (object) =>
		str = "{"
		for key, value of object
			str += "#{key}: \"#{value}\", "
		return str + "}"

	lsc = new @LSC.Chart("Untitled.lsc", @paper)

	addInstance = =>
		i = new @LSC.Instance("new", lsc.instances.length, @paper, lsc)
		lsc.addInstance(i)
		lsc.update()
		i.edit()
	
	#### jQuery Hack
	# Add dataTransfer to copied attributed for events
	# See: http://weblog.bocoup.com/using-datatransfer-with-jquery-events/
	jQuery.event.props.push('dataTransfer');

	#### File drop support (for loading files)
	# Set dropEffect and display cloudUp icon large
	# if a file is being draged
	#TODO: Try dragenter and dragleave (other something like it) instead
	$("#wrapper").on "dragover", (event) ->
		event.stopPropagation()	#Don't do this is not handled here!
		event.preventDefault()	#Ie. if it's not a file
		#TODO Check if dataTransfer.files is defined, and if it's non-empty
		event.dataTransfer.dropEffect = 'copy'
	# Handle file loading if it's a file
	$("#wrapper").on "drop", (event) ->
		event.stopPropagation()	#Don't do this is not handled here!
		event.preventDefault()	#Ie. if it's not a file
		files = event.dataTransfer.files
		for f in files
			alert(escape(f.name))

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

	deleteSelection = (event) ->
		lsc.deleteSelection
 	

	#### Initialize toolbar
	toolbar = new @LSC.Toolbar(@Raphael("toolbar", "100%", cfg.toolbar.height))
	new @LSC.Button("plus", "Add instance", toolbar).click addInstance
	new @LSC.Button("exchange", "Add message", toolbar).click addMessage
	
	new @LSC.Button("trash", "Delete selection", toolbar).click deleteSelection
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



