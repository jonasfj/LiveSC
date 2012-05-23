#### Interface for Applet

@LSC ?= {}
@LSC.Applet = Applet = {}

initialized = false
initializing = false
nextModel = null

Applet.initialize = -> 
	unless initializing or initialized
		$("body").append('<applet id="applet" style="visibility: hidden; position: absolute;" code="Applet" archive="bin/Applet.jar,bin/jtlv.jar,bin/antlr-runtime-3.0.1.jar,bin/javabdd-2.0.jar,bin/jdd.jar,bin/scala-library.jar" width="1" height="1" mayscript="true" scriptable="true"></applet>')
		initializing = true
		$("#apploading").show(cfg.animation.speed)
		setTimeout(checkAppletReady, 500)
	return initialized

checkAppletReady = ->
	app = document.getElementById("applet")
	if not app.loadSMV
		setTimeout(checkAppletReady, 500)
	else
		$("#apploading").hide(cfg.animation.speed)
		initializing = false
		initialized = true
		executeCheck()

# Initialize the applet
Applet.checkRealizability = (model) ->
	if model?
		nextModel = model
		if Applet.initialize()
			executeCheck()
	else
		log "No model was provided."
executeCheck = ->
	if nextModel?
		app = document.getElementById("applet")
		try
			retval = app.loadSMV(nextModel)
			if retval == ""
				if app.game().realizable()
					alert "Model is realizable!"
				else
					alert "Model is NOT realizable!"
			else
				alert "Model checking failed, error: #{retval}"
		catch error
			alert "Model checking failed, error: #{error}"
		nextModel = null
	else
		log "Failed to find next model"
