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
	arrow:
		width:				10
		height:				3
	chart:
		minwidth:			400
	sidebar:
		width:				250
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

# Allow updates to be instant or animated
instant = false
@LSC.instant = -> instant = true
@LSC.animate = -> instant = false

#### Initialize the editor
@LSC.initialize = =>
	# Maintain workspace height
	$(window).resize ->
		$("#workspace").height($(window).height() - cfg.toolbar.height)
		$("#chartlist").height($(window).height() - cfg.toolbar.height)
	$(window).resize()
	
	# Load Applet
	@LSC.Applet.initialize()

	# Create workspace paper
	@paper = @Raphael("workspace", cfg.chart.minwidth, "400")
	@Raphael.el.update = (params) ->
		if instant
			@attr params
		else
			@animate params, cfg.animation.speed
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
	$("#workspace")[0].addEventListener "mousemove", 	((e) -> CurrentChart?.mouseMove(e)), 		true
	$("#workspace")[0].addEventListener "mouseup", 		((e) -> CurrentChart?.mouseUp(e)), 			true
	$("#workspace")[0].addEventListener "mousedown", 	((e) -> CurrentChart?.clearSelection(e)), 	false
	# Notice how `Chart.mouseDown(e)` will `stopPropagation()` when adding message, but otherwise
	# the event will propergate to `Chart.clearSelection(e)`.

	#### Initialize Sidebar
	@sidebar = new @LSC.Sidebar($("#chartlist"))

	#### Initialize toolbar
	@toolbar = new @LSC.Toolbar(@Raphael("toolbar", "100%", cfg.toolbar.height))
	new @LSC.Button("piechart", "Add chart", toolbar).click 			-> addChart()
	new @LSC.Button("plus", "Add instance", toolbar).click 				-> CurrentChart?.createInstance()
	new @LSC.Button("exchange", "Add message", toolbar).click 			-> CurrentChart?.addMessage()
	new @LSC.Button("trash", "Delete selection", toolbar).click 		-> CurrentChart?.deleteSelection()
	new @LSC.Button("cloudDown", "Download project", toolbar).click		download

	# Add new empty chart
	addChart()

# Initialize editor
$ LSC.initialize

# Add new chart to list, and switch to this chart
addChart = (json = @LSC.Chart.emptyJSON, switchto = true) =>
	@Charts.push(json)
	index = @Charts.length - 1
	@sidebar.addEntry(index, json.name, switchChart)
	if switchto
		switchChart(index)

switchChart = (index) =>
	if @Charts[index]?
		# Save old chart if exists
		if @CurrentChart?
			@Charts[@CurrentIndex] = @CurrentChart.toJSON()
		@paper.clear()
		# Load new chart
		@CurrentChart = new @LSC.Chart(@paper)
		@CurrentChart.fromJSON(@Charts[index])
		@CurrentIndex = index
		@CurrentChart.change chartChanged

chartChanged = =>
	if @CurrentChart?
		@sidebar.updateEntry(@CurrentIndex, @CurrentChart.name)

# Download everything
download = =>
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

# Check if event carries file
hasFile = (event) ->
	return true if event?.dataTransfer?.files?.length > 0
	return false

# Drag effect state
dragEffect = dragIcon = dragLeftTimeout = null
dragEffectLeaving = false

# Add drag effect, if not already there
dragEffectAdd = (event) ->
	return if event? and not hasFile(event, "add")
	if dragLeftTimeout?
		clearTimeout(dragLeftTimeout)
		dragLeftTimeout = null
	unless dragEffect?
		$("#effectarea").css("display", "block")
		dragEffect = Raphael("effectarea", "100%", "100%")
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
		# Give dragEffectAdd 100ms to cancel this
		dragLeftTimeout = setTimeout(dragEffectRemove, 100)

# Remove drag effect
dragEffectRemove = ->
	dragEffectLeaving = true
	dragIcon?.animate {opacity: 0}, cfg.animation.speed, ->
		# Cleanup after animation, if this wasn't cancelled
		if dragLeftTimeout?
			$("#effectarea").css("display", "none")
			dragIcon.remove()
			dragEffect.remove()
			dragEffect = dragIcon = dragLeftTimeout = null
			dragEffectLeaving = false

dragFileOver = (event) ->
	return unless hasFile(event, "over")
	dragEffectAdd()		# Ensure drag effect
	event.stopPropagation()
	event.preventDefault()
	event.dataTransfer.dropEffect = 'copy'

dropFile = (event) =>
	return unless hasFile(event, "drop")
	dragEffectLeave()	# Remove drag effect
	event.stopPropagation()
	event.preventDefault()
	file = event.dataTransfer.files[0]
	@CurrentChart = null
	@CurrentIndex = 0
	@Charts = []
	@paper.clear()
	@sidebar.clear()
	reader = new FileReader();
	reader.onload = =>
		data = $.secureEvalJSON(reader.result)
		for item in data.charts
			addChart(item, false)
		@toolbar.setTitle(data.title)
		if @Charts.length == 0
			addChart()
		else
			switchChart(0)
	reader.readAsText(file)
