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
	drag:
		effect:
			opacity:		0.8

# Automatically computed contants
@cfg.instance.width = @cfg.instance.head.width + @cfg.instance.padding * 2

# LSC namespace if not already there
@LSC ?= {}

# Current Chart
@CurrentChart = null
@CurrentIndex = 0
@Charts = []

# Convert PageX, PageY to raphael coordinates
@LSC.pageX2RaphaelX = (x) -> x + $("#workspace").scrollLeft() - $("#workspace").offset().left;
@LSC.pageY2RaphaelY = (y) -> y + $("#workspace").scrollTop() - $("#workspace").offset().top;

# Log messages
@log = (msg) =>
	if console?.log?
		console.log msg
	else
		alert "Provide console.log for log messages"
		@log = (msg) ->
# Utility for inspection for objects
@inspect = (object) => "{" + ("#{key}: \"#{value}\"" for key, value of object).join(", ") + "}"

#### Initialize the editor
@LSC.initialize = =>
	# Maintain workspace height
	$(window).resize ->
		$("#workspace").height($(window).height() - cfg.toolbar.height)
	$(window).resize()
	
	# Create workspace paper
	@paper = @Raphael("workspace", "400", "400")
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
	
	#### Hide text-cursor when dragging in chrome
	# See: http://forum.jquery.com/topic/chrome-text-select-cursor-on-drag
	document.onselectstart = -> false
	
	#### jQuery Hack
	# Add dataTransfer to copied attributed for events
	# See: http://weblog.bocoup.com/using-datatransfer-with-jquery-events/
	jQuery.event.props.push('dataTransfer');

	#### File drop support (for loading files)
	$("body").on "dragenter", 	dragEffectAdd
	$("body").on "dragleave", 	dragEffectLeave
	$("body").on "dragover", 	dragFileOver
	$("body").on "drop", 		dropFile

	#### Event subscriptions for mouse down/up
	# This is used to manage deselection and addMessage state in Chart.
	# Please remember to `stopPropagation()` on any mousedown and mouseup events
	# that shouldn't cause deselection. Ie. this is relevant for editors and stuff.
	$("#workspace")[0].addEventListener "mousedown",	((e) -> CurrentChart?.mouseDown(e)), 		true
	$("#workspace")[0].addEventListener "mouseup", 		((e) -> CurrentChart?.mouseUp(e)), 			true
	$("#workspace")[0].addEventListener "mousedown", 	((e) -> CurrentChart?.clearSelection(e)), 	false
	# Notice how `Chart.mouseDown(e)` will `stopPropagation()` when adding message, but otherwise
	# the event will propergate to `Chart.clearSelection(e)`.

	#### Initialize toolbar
	@toolbar = new @LSC.Toolbar(@Raphael("toolbar", "100%", cfg.toolbar.height))
	new @LSC.Button("piechart", "Add chart", toolbar).click 			addChart
	new @LSC.Button("plus", "Add instance", toolbar).click 				-> CurrentChart?.createInstance()
	new @LSC.Button("exchange", "Add message", toolbar).click 			-> CurrentChart?.addMessage()
	new @LSC.Button("trash", "Delete selection", toolbar).click 		-> CurrentChart?.deleteSelection()
	new @LSC.Button("cloudDown", "Download project", toolbar).click		download

	@CurrentChart = new @LSC.Chart("Untitled.lsc", @paper);

# Initialize editor
$ LSC.initialize

# Create a new chart, add to list, and switch to this chart
addChart = =>
	@Charts.push(@LSC.Chart.emptyJSON)
	switchChart(@Charts.length-1)

switchChart = (index) =>
	if @Charts[index]?
		# Save old chart
		@Charts[@CurrentIndex] = @CurrentChart.toJSON()
		@paper.clear()
		@CurrentChart = new @LSC.Chart("Untitled.lsc", @paper)
		@CurrentChart.fromJSON(@Charts[index])

# Download everything
download = ->
	# Save current chart
	if @CurrentChart?
		@Charts[@CurrentIndex] = @CurrentChart.toJSON()
	# Put everything into JSON
	data = $.toJSON
		title:			@toolbar.getTitle()
		charts:			@Charts
	# Open data URL
	dataurl = "data:application/lsc+json;base64,#{$.base64Encode(data)}"
	window.open(dataurl, "_blank")

# Drag effect state
dragEffect = dragIcon = dragLeftTimeout = null
dragEffectLeaving = false

# Add drag effect, if not already there
dragEffectAdd = (event) ->
	if dragLeftTimeout?
		clearTimeout(dragLeftTimeout)
		dragLeftTimeout = null
	unless dragEffect?
		dragEffect = Raphael(0, 0, "100%", "100%")
		path = Raphael.transformPath(Icons["cloudUp"], "s30")
		path = Raphael.transformPath(path, "t#{$(window).width()/2},#{$(window).height()/2}")
		dragIcon = dragEffect.path(path)
		dragIcon.attr
			opacity:	0
			fill:		"#ccc"
			stroke:		"none"
		dragEffectLeaving = true
	if dragEffectLeaving
		dragIcon.update
			opacity:	cfg.drag.effect.opacity
		dragEffectLeaving = false

# Initiate remove of drag effect
dragEffectLeave = (event) ->
	unless dragLeftTimeout?
		# Given dragEffectAdd 100ms to cancel this
		dragLeftTimeout = setTimeout(dragEffectRemove, 100)

# Remove drag effect
dragEffectRemove = ->
	dragEffectLeaving = true
	dragIcon?.animate {opacity: 0}, cfg.animation.speed, ->
		# Cleanup after animation, if this wasn't cancelled
		if dragLeftTimeout?
			dragIcon.remove()
			dragEffect.remove()
			dragEffect = dragIcon = dragLeftTimeout = null
			dragEffectLeaving = false

dragFileOver = (event) ->
	dragEffectAdd()		# Ensure drag effect
	event.stopPropagation()
	event.preventDefault()
	#TODO Check if dataTransfer.files is defined, and if it's non-empty
	event.dataTransfer.dropEffect = 'copy'

dropFile = (event) ->
	dragEffectLeave()	# Remove drag effect
	event.stopPropagation()	#Don't do this is not handled here!
	event.preventDefault()	#Ie. if it's not a file
	###files = event.dataTransfer.files
	for f in files
		alert(escape(f.name))
	@CurrentChart = null
	@CurrentIndex = 0
	@paper.clear()
	data = @.secureEvalJSON(event.dataTransfer.getData("Text"))
	alert data
	@Charts = []
	for item in data.charts
		@Charts.push(item)
	@toolbar.setTitle(data.title)
	@CurrentChart = new @LSC.Chart("Untitled.lsc", @paper)
	@CurrentChart.fromJSON(@Charts[@CurrentIndex])###
