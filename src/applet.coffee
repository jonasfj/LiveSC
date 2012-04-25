#### Interface for Applet

@LSC ?= {}
@LSC.Applet = Applet = {}

Applet.initialize = -> 
	$("body").append('<applet id="applet" style="visibility: hidden; position: absolute;" code="Applet" archive="bin/applet.jar,bin/jtlv.jar,bin/antlr-runtime-3.0.1.jar,bin/javabdd-2.0.jar,bin/jdd.jar,bin/scala-library.jar" width="1" height="1" mayscript="true" scriptable="true"></applet>')

# Initialize the applet
Applet.checkRealizability = (model) -> document.getElementById("applet").checkRealizability(model)
