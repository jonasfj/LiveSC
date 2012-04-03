#### Interface for Applet

@LSC ?= {}
@LSC.Applet = Applet = {}

# Initialize the applet
Applet.checkRealizability = (model) -> document.getElementById("applet").checkRealizability(model)
