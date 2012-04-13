@LSC ?= {}


# A neat little DSL, note this DSL may not be initialized recursively
_c = null
StartSMV = ->
	return false	if _c isnt null
	_c = ""
	return true

Module = (name, params) ->
	_c += "MODULE #{name} (#{params.join(', ')})\n"

Var = (declare) ->
	_c += "VAR\n"
	declare()

Declare = (name, type) ->
	if type instanceof Array
		type = "{#{type.join(', ')}}"
	_c += "\t#{name} : #{type};\n"

Assign = (assign) ->
	_c += "ASSIGN\n"
	assign()

Init = (name, value) ->
	if value instanceof Array
		value = "{#{value.join(', ')}}"
	_c += "\tinit(#{name}) := #{value};\n"

Next = (name, value) ->
	unless value instanceof Function
		val = value
		value = -> Case "1", val
	_c += "\tnext(#{name}) := case\n"
	value()
	_c += "\tesac;\n"

Case = (expr, value) ->
	if value instanceof Array
		value = "{#{value.join(', ')}}"
	if expr instanceof Array
		expr = expr.join(' & ')
	_c += "\t\t#{expr} : #{value};\n"

OutputSMV = ->
	retval = _c
	_c = null
	return retval

# Auxiliary Variable name functions

# Location variable
Loc = (inst, chart) ->
	unless inst instanceof String
		inst = inst.name
	return "Loc_#{inst}_#{chart.number}"

# Active Variable
Active = (chart) -> "active_#{chart.number}"

# Location variable value
L = (location) -> "L#{location}"

# Message variable name
Msg = (m) -> "#{m.name}_#{m.target}_#{m.source}"

@LSC.toSMV = (json) ->
	# Clone json, so we can add arbitrary properties without bad side effects
	charts = $.secureEvalJSON($.toJSON(json))

	env = instances: [], instanceNames: [], messages: [], messageNames: []
	sys = instances: [], instanceNames: [], messages: [], messageNames: []
	for chart, i in charts
		# Assign number to each chart
		chart.number = i
		# Sort messages by locations
		chart.messages.sort (m1, m2) -> m1.location > m2.location
		for inst in chart.instances
			# Add to list of instance names
			obj = if inst.env then env else sys
			if inst.name not in obj.instanceNames
				obj.instanceNames.push inst.name
				obj.instances.push inst
			# Add list of locations in each instance to instances
			inst.locations = [0]
			inst.locations.push m.location				for m in chart.messages when inst.name in [m.source, m.target]
			# Compute maxPreLoc and maxLoc
			inst.maxPreLoc = Math.max (l for l in inst.locations when l < chart.lineloc)...
			inst.maxLoc = Math.max inst.locations...
		chart.messageNames = []
		for m in chart.messages
			chart.messageNames.push Msg m				if Msg m not in chart.messageNames
			obj = if m.source in env.instanceNames then env else sys
			if Msg m not in obj.messagesNames
				obj.messagesNames.push Msg m
				obj.messages.push m
			m.charts = (c for c in charts when Msg m in (Msg msg for msg in c.messages))
			m.prevSourceLoc = Math.max (l for l in inst.locations when l < m.location for inst in chart.instances when inst.name is m.source)...
			m.prevTargetLoc = Math.max (l for l in inst.locations when l < m.location for inst in chart.instances when inst.name is m.target)...

	return null if not StartSMV()


	Module "Input", [(Loc inst, chart for inst in chart.instances when not inst.env for chart in charts)...,
					 sys.messageNames..., "current_object"]

	Var ->
		Declare m, 					"boolean"										for m in env.messagesNames
		Declare "gbuchi",			"0..2"
		Declare (Active chart),		"boolean"										for chart in charts
		Declare "envreq",			env.instanceNames
		Declare (Loc inst, chart),	(L loc for loc in inst.locations)				for inst in chart.instances when  inst.env for chart in charts

	Assign ->
		Init m,						0												for m in env.messagesNames
		Init (Loc inst, chart),		(L 0)											for inst in chart.instances when inst.env for chart in charts
		Init "gbuchi",				0
		Init (Active chart),		0												for chart in charts
		Init "envreq",				env.instanceNames

		Next "gbuchi", ->
			notActive = ("#{Active chart} = 0" for chart in charts)
			notCurrent = ("current_object != #{inst}" for inst in env.instanceNames)
			Case "gbuchi = 0",														1
			Case ["gbuchi = 1", notActive...],										2
			Case ["gbuchi = 2", notCurrent...],										0
			Case 1,																	"gbuchi"

		Next m, (->
			notActive = ("#{Active chart} = 0" for chart in m.charts)
			notOthers = ("next(#{Msg m2}) = 0" for m2 in [env.messages..., sys.messages...] when (Msg m2) isnt (Msg m))
			Case "next(current_object) != #{m.source}",								0
			Case [notOthers..., notActive...],										[0, 1]
			Case 1,																	0
		)	for m in env.messages

		Next (Active chart), (->
			maxPreLoc = ("next(#{Loc inst, chart}) = #{L inst.maxPreLoc}" for inst in chart.instances)
			maxLoc = ("next(#{Loc inst, chart}) = #{L inst.maxLoc}" for inst in chart.instances)
			Case ["#{Active chart} = 0", maxPreLoc...],								1
			Case ["#{Active chart} = 1", maxLoc...],								0
			Case 1,																	Active chart
		)	for chart in charts

		Next (Loc inst, chart), (->
			Case ["#{Active chart} = 0", "#{Loc inst, chart} = #{inst.maxLoc}"],	(L 0)
			Case ["#{Loc inst, chart} = #{L m.prevSourceLoc}",
				  "#{Loc m.target, chart} = #{L m.prevTargetLoc}",
				  "next(#{Loc m.target, chart}) = #{L m.location}",
				  "next(#{Msg m}) = 1"],											(L m.location)		for m in chart.messages when m.source is inst.name
			Case ["#{Loc inst, chart} = #{L m.prevTargetLoc}",
				  "#{Loc m.source, chart} = #{L m.prevSourceLoc}",
				  "next(#{Loc m.source, chart}) = #{L m.location}",
				  "next(#{Msg m}) = 1"],											(L m.location)		for m in chart.messages when m.target is inst.name
			cantFire = (m) -> "(#{Loc m.source, chart} != #{m.prevSourceLoc} | #{Loc m.target, chart} != #{m.prevTargetLoc})"
			Case ["#{Loc inst, chart} in {#{(L l for l in inst.locations when l < chart.lineloc).join(', ')}}",
				  (cantFire(m) for m in chart.messages when (Msg m) is msg)...,
				  "#{msg} = 1"],													(L 0)				for msg in chart.messageNames
			Case 1,																	(Loc inst, chart)
		)	for inst in chart.instances when inst.env for chart in charts


	Module "Output", [(Active chart for chart in charts)...,
					  env.messageNames..., "gbuchi", "envreq",
					  (Loc inst, chart for inst in chart.instances when inst.env for chart in charts)...]
	
	Var ->
		Declare (Msg m), 					"boolean"										for m in sys.messages
		Declare (Loc inst, chart),			(L l for l in inst.locations)					for inst in chart.instances when not inst.env for chart in charts
		Declare "current_process",			[sys.instanceNames..., env.instanceNames...]
	
	Assign ->
		Init (Msg m),						0												for m in sys.messages
		Init "current_process",				["envreq", sys.instanceNames...]
		Init (Loc inst, chart),				(L 0)											for inst in chart.instances when not inst.env for chart in charts
		
		Next "current_process",				["envreq", sys.instanceNames...]

		Next (Msg m), (->
			Case "next(current_object) != #{m.source}",								0
			notOthers = ("next(#{Msg m2}) = 0" for m2 in [env.messages..., sys.messages...] when (Msg m2) isnt (Msg m))
			canfire = (m) -> ["#{Loc m.source, chart} = #{m.prevSourceLoc}",
							  "#{Loc m.target, chart} = #{m.prevTargetLoc}",
							  "next(#{Loc m.source, chart}) = #{m.location}",
							  "next(#{Loc m.target, chart}) = #{m.location}"]
			Case [canfire(m2)..., "#{Active chart} = 1", notOthers...],				1	for m2 in chart.messages when (Msg m2) is (Msg m) for chart in m.charts
			Case 1,																	0
		)	for m in sys.messages
	
		Next (Loc inst, chart), (->
			Case ["#{Active chart} = 0", "#{Loc inst, chart} = #{inst.maxLoc}"],	(L 0)
			Case ["#{Loc inst, chart} = #{L m.prevSourceLoc}",
				  "#{Loc m.target, chart} = #{L m.prevTargetLoc}",
				  "next(#{Loc m.target, chart}) = #{L m.location}",
				  "next(#{Msg m}) = 1"],											(L m.location)		for m in chart.messages when m.source is inst.name
			Case ["#{Loc inst, chart} = #{L m.prevTargetLoc}",
				  "#{Loc m.source, chart} = #{L m.prevSourceLoc}",
				  "next(#{Loc m.source, chart}) = #{L m.location}",
				  "next(#{Msg m}) = 1"],											(L m.location)		for m in chart.messages when m.target is inst.name
			cantFire = (m) -> "(#{Loc m.source, chart} != #{m.prevSourceLoc} | #{Loc m.target, chart} != #{m.prevTargetLoc})"
			Case ["#{Loc inst, chart} in {#{(L l for l in inst.locations when l < chart.lineloc).join(', ')}}",
				  (cantFire(m) for m in chart.messages when (Msg m) is msg)...,
				  "#{msg} = 1"],													(L 0)				for msg in chart.messageNames
			Case 1,																	(Loc inst, chart)
		)	for inst in chart.instances when not inst.env for chart in charts
	
	return OutputSMV()






