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
	regex:
		namepattern:		/[A-z]+\w*/g; # Used to sanitize names
	app:
		name:				"LiveSC"

# Automatically computed contants
@cfg.instance.width = @cfg.instance.head.width + @cfg.instance.padding * 2

# LSC namespace if not already there
@LSC ?= {}

# Set page title
@setDocTitle = (title) =>
	document.title = "#{cfg.app.name} - " + title

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

	#### Set default document title
	setDocTitle("Untitled")
	
	#### Create workspace paper
	@paper = @Raphael("workspace", cfg.chart.minwidth, "400")
	@Raphael.el.update = (params) ->
		if instant
			@attr params
		else
			@animate params, cfg.animation.speed
	
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
	@LSC.Toolbar.initialize()

	@LSC.Button
		icon:		"AddChart"
		tooltip:	"Add chart to specification"
		help:		"""
					Adds a <b>new chart</b> to the current specification project.
					Notice that all chart in the project
					must be satisfied by any realization. Typically charts are used to express independent
					senarios or counter examples.
					"""
		action:		 -> addChart()

	@LSC.Button
		icon:		"plus"
		tooltip:	"Add system instance"
		help:		"""
					Adds a system <b>instance to the current chart</b>. You can change the instance type from
					system to environment type later. Remember that instance names are unique within
					a given chart. Instance type must also match type of the same instance in other
					charts.
					"""
		action:		 -> CurrentChart?.createInstance(false)

	@LSC.Button
		icon:		"SwitchType"
		tooltip:	"Toggle instance type (sys/env)"
		help:		"""
					Toggle instance type, ie. convert <b>system instance to environment instances</b>
					and vice versus.
					Notice that the type of instances with same name in other charts will also change.
					"""
		action:		 -> CurrentChart?.changeInstanceType()

	@LSC.Button
		icon:		"exchange"
		tooltip:	"Add message"
		help:		"""
					Add a <b>message exchange</b> to the current chart. Two messages are equal to if they have the
					same name and go from the same sender to the same receiver.
					Messages in the forbidden section, will abort the prefix and are not allowed to occur
					in an execution of the main chart.
					"""
		action:		 -> CurrentChart?.addMessage()

	@LSC.Button
		icon:		"cross"
		tooltip:	"Toggle FALSE main chart"
		help:		"""
					Toggle <b>false main chart</b>, meaning that we consider the main chart impossible to satisfy.
					This is equivalent to requiring that the prechart is never completed.
					Note, any messages in the main chart will be ignored and are of no importance here.
					"""
		action:		 -> CurrentChart?.toggleEnabledness()

	@LSC.Button
		icon:		"trash"
		tooltip:	"Delete selection"
		help:		"""
					<b>Deletes</b> the current select, be it a message or and instance.
					Note that if you delete and instance the associated messages will also be removed.
					"""
		action:		 -> CurrentChart?.deleteSelection()

	@LSC.Separator()

	@LSC.Button
		icon:		"cloudDown"
		tooltip:	"Download project as JSON file"
		help:		"""
					Export <b>project as JSON</b>. The file can be saved to disk and drag 'n' dropped back
					into this editor at any time. Thus, enabling you to save your projects.
					"""
		action:		 download

	@LSC.Button
		icon:		"picture"
		tooltip:	"Export Chart as SVG"
		help:		"""
					Export current <b>chart as SVG</b>. With the ability to open, edit and export these files from
					<a href='http://inkscape.org/'>Inkscape</a> this is quick way to generate high quality
					live sequence charts with annotations.
					"""
		action:		 exportSVG

	@LSC.Button
		icon:		"download"
		tooltip:	"Export SMV code"
		help:		"""
					Export the <b>transistion system</b> of 'repeated reachability' game this project was
					translated to. You can use this to check realizability and synthesize a strategy
					using a commandline version of our engine downloadable from 
					<a href='https://github.com/jopsen/LiveSC' target='_blank'>github</a>.
					"""
		action:		 getSMV

	@LSC.Separator()

	@LSC.Button
		icon:		"arrowright"
		tooltip:	"Check realizability"
		help:		"""
					<b>Check realizability</b> of the current specification project.
					This will lazy load a Java applet and for large projects this will not finish
					any time soon. Consider saving your project before trying this feature.
					"""
		action:		 check

	@LSC.Button
		icon:		"magic"
		tooltip:	"Synthesize a strategy"
		help:		"""
					Check realizability and <b>synthesize a strategy</b> for the system, if the current
					specification project is realizable. At the moment we only inform you about
					the size of the BDD for representation of the transision system.
					"""
		action:		 synthesize

	@LSC.FloatRight()

	@LSC.Button
		icon:		"githubalt"
		tooltip:	"More information about this project on github"
		help:		"""
					This project is hosted at <a href='https://github.com/jopsen/LiveSC' target='_blank'>
					github</a>, sources are available under
					<a href='http://www.gnu.org/licenses/gpl.html' target='_blank'>GNU GPL</a>.<br>
					Feel free to <b>fork and play</b> around if you feel like it.
					"""
		action:		 -> window.open("https://github.com/jopsen/LiveSC", "_blank")

	@LSC.Button
		icon:		"help"
		tooltip:	"Display some helpful instructions"
		help:		"""
					Display these <b>helpful instructions</b>, they will also be shown whenever
					LiveSC is opened. Just click anywhere to make them go away.
					But not yet, please finish reading this list first, the best is saved for last.
					"""
		action:		 -> $("#helpdialog").fadeIn cfg.animation.speed

	@LSC.Button
		icon:		"star3"
		tooltip:	"Load example from gallery"
		help:		"""
					Load example from our very neat <b>example gallery</b>. Each example comes with a
					little explanatory text, that gives your a hit about why this might be important.
					Notice that some of the examples are so large that we can't handle at this point.
					"""
		action:		 examples

	# Add new empty chart
	addChart()

	# Hide welcome dialog on click
	$("#welcomedialog").click -> $("#welcomedialog").fadeOut cfg.animation.speed
	$("#helpdialog").click -> $("#helpdialog").fadeOut cfg.animation.speed
	$("#examplehint").click examples
	$("#helphint").click -> $("#helpdialog").fadeIn cfg.animation.speed

# Initialize editor
$ LSC.initialize

# Add new chart to list, and switch to this chart
addChart = (json = @LSC.Chart.emptyJSON, switchto = true) =>
	@Charts.push(json)
	index = @Charts.length - 1
	@sidebar.addEntry(index, json.name, switchChart, removeChart)
	if switchto
		switchChart(index)

# Switches the current chart
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

# removes the selected chart
removeChart = (index) =>
	if @Charts[index]?
		@CurrentChart = null
		@Charts.splice(index,1)
		if index > 0
			switchChart(index-1)
		else if index == 0
			addChart()

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
		title:			LSC.Toolbar.getTitle()
		charts:			@Charts
	# Open data URL
	dataurl = "data:application/octet-stream;base64,#{$.base64Encode(data)}"
	informDownload()
	window.open(dataurl, "_blank")

# Check if event carries file
hasFile = (event) -> event?.dataTransfer?.types? and "Files" in event?.dataTransfer?.types

# Drag effect state
dragEffect = dragIcon = dragLeftTimeout = null
dragEffectLeaving = false

# Add drag effect, if not already there
dragEffectAdd = (event) ->
	return if event? and not hasFile(event)
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

# Drag file onto document
dragFileOver = (event) ->
	return unless hasFile(event)
	dragEffectAdd()		# Ensure drag effect
	event.stopPropagation()
	event.preventDefault()
	event.dataTransfer.dropEffect = 'copy'

# Drop file onto document
dropFile = (event) =>
	return unless hasFile(event)
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
		LSC.Toolbar.setTitle(data.title)
		setDocTitle(data.title)
		if @Charts.length == 0
			addChart()
		else
			switchChart(0)
	reader.readAsText(file)

# Downloads the SMV code for the specification
getSMV = =>
	if @CurrentChart?
		@Charts[@CurrentIndex] = @CurrentChart.toJSON()
	try
		data = @LSC.toSMV($.secureEvalJSON($.toJSON(@Charts)))
	catch error
		alert "An error occurred during translation.\nPlease provide at least one message."
		return
	dataurl = "data:text/plain;base64,#{$.base64Encode(data)}"
	informDownload()
	window.open(dataurl, "_blank")

# Checks realizability
check = =>
	if @CurrentChart?
		@Charts[@CurrentIndex] = @CurrentChart.toJSON()
	try
		smv = LSC.toSMV($.secureEvalJSON($.toJSON(@Charts)))
	catch error
		alert "An error occurred during translation.\nPlease provide at least one message."
		return
	LSC.Applet.check(smv)

# Synthesizes a controller
synthesize = =>
	if @CurrentChart?
		@Charts[@CurrentIndex] = @CurrentChart.toJSON()
	try
		smv = LSC.toSMV($.secureEvalJSON($.toJSON(@Charts)))
	catch error
		alert "An error occurred during translation.\nPlease provide at least one message."
		return
	LSC.Applet.synthesize(smv)

# Export current chart to SVG file
exportSVG = =>
	if @CurrentChart?
		@CurrentChart.clearSelection()
		data = @CurrentChart.paper.toSVG();
		dataurl = "data:image/svg+xml;base64,#{$.base64Encode(data)}"
		informDownload()
		window.open(dataurl, "_blank")

informDownload = ->
	if navigator.userAgent.indexOf("Chrome/19") >= 0
		alert "You are running Chrome 19.\nThis browser has problems with data-urls,\nsee issue #97108 (chromium), a fix is due in Chrome 20."

# Displays available example systems
# Callback loads the selected example
examples = ->
	LSC.loadExample (json) ->
		@CurrentChart = null
		@CurrentIndex = 0
		@Charts = []
		@paper.clear()
		@sidebar.clear()
		for item in json.charts
			addChart(item, false)
		LSC.Toolbar.setTitle(json.title)
		setDocTitle(json.title)
		if @Charts.length == 0
			addChart()
		else
			switchChart(0)
