#### Interface for Applet

@LSC ?= {}
@LSC.Applet = Applet = {}

initialized = false
initializing = false
nextModel = null
synthesize = false

Applet.initialize = -> 
	unless initializing or initialized
		$("body").append('<applet id="applet" style="visibility: hidden; position: absolute;" code="Applet" archive="bin/Applet.jar,bin/jtlv.jar,bin/antlr-runtime-3.0.1.jar,bin/javabdd-2.0.jar,bin/jdd.jar,bin/scala-library.jar" width="1" height="1" mayscript="true" scriptable="true"></applet>')
		initializing = true
		$("#apploading").fadeIn(cfg.animation.speed)
		setTimeout(checkAppletReady, 500)
	return initialized

checkAppletReady = ->
	app = document.getElementById("applet")
	if not app.loadSMV
		setTimeout(checkAppletReady, 500)
	else
		$("#apploading").fadeOut(cfg.animation.speed)
		initializing = false
		initialized = true
		executeCheck()

# Initialize the applet
Applet.check = (model) ->
	if model?
		nextModel = model
		synthesize = false
		if Applet.initialize()
			executeCheck()
	else
		log "No model was provided."

# Initialize the applet
Applet.synthesize = (model) ->
	if model?
		nextModel = model
		synthesize = true
		if Applet.initialize()
			executeCheck()
	else
		log "No model was provided."

executeCheck = ->
	unless nextModel?
		log "Failed to find next model"
		return
	app = document.getElementById("applet")
	
	#Show relevant dialogs
	unspin = spinner("spinner")
	# Clean-up
	exit = ->
		$("#progressdialog").fadeOut cfg.animation.speed, ->
			$("#operation").html("")
			$("#console").html("")
			unspin()
			$("#closeprogress").off('exit')
			$("#closeprogress").hide()
	$("#closeprogress").click exit

	$("#progressdialog").fadeIn(cfg.animation.speed)

	$("#operation").html("Loading Model...")
	try
		if app.loadSMV(nextModel)
			$("#operation").html("Checking Realizability...")
			if app.game() == null
				reportProgress("Failed loading transition system.")
			if app.game().realizable()
				$("#operation").html("Synthesizing Strategy...")
				if synthesize
					result = parseInt(app.game().synthesize()) || -1
					if result >= 0
						$("#operation").html("Strategy Synthesized")
					else
						$("#operation").html("Synthesis Failed")
				else
					$("#operation").html("Model is Realizable")
			else
				$("#operation").html("Model is Not Realizable")
	catch error
		$("#operation").html("Model Checking Failed")
		reportProgress("\nError: " + error)
	$("#closeprogress").show()
	unspin()
	nextModel = null

@reportProgress = (info) ->
	$("#console").html($("#console").html() + info)
	# auto-scroll to bottom of console output
	$("#console").scrollTop	$("#console")[0].scrollHeight


# Progress animation
# Credit due: http://raphaeljs.com/spin-spin-spin.html
spinner = (placeholder) ->
	width = 15
	color = "#000"
	pathParams = {"stroke": color, "stroke-width": width, "stroke-linecap": "round"}
	sectorsCount = 12
	r1 = 35
	r2 = 60
	cx = r2 + width
	cy = r2 + width
	beta = 2 * Math.PI / sectorsCount
	canvas = Raphael(placeholder, r2 * 2 + width * 2, r2 * 2 + width * 2)
	sectors = []
	opacity = []
	Raphael.getColor.reset()
	for i in [0..sectorsCount]
		alpha = beta*(i-Math.PI/2)
		cos = Math.cos(alpha)
		sin = Math.sin(alpha)
		opacity[i] = 1 / sectorsCount * i
		sectors[i] = canvas.path([["M", cx + r1 * cos, cy + r1 * sin], ["L", cx + r2 * cos, cy + r2 * sin]]).attr(pathParams)
	tick = 0
	ticker = ->
		opacity.unshift(opacity.pop())
		for i in [0..sectorsCount]
			sectors[i].attr
				"opacity": opacity[i]
	canvas.safari()
	tick = setInterval(ticker, 1000 / sectorsCount)
	# returns a function to kill it once more
	return ->
		clearInterval(tick)
		canvas.remove()

