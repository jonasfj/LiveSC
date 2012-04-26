@LSC ?= {}


# A neat little DSL, note this DSL may not be initialized recursively
_c = null
StartSMV = ->
	return false	if _c isnt null
	_c = ""
	return true

tab = "    "
pad = (str, len) ->
	str = str + ""
	str + (" " for i in [0..Math.max(0, len - 1 - str.length)]).join('')
align = 100

Module = (name, params) ->
	_c += "MODULE #{name} (#{params.join(', ')})\n\n"

Var = (declare) ->
	_c += "VAR\n"
	declare()
	_c += "\n"

Declare = (name, type) ->
	if type instanceof Array
		type = "{#{type.join(', ')}}"
	_c += tab + "#{pad(name, align)} : #{type};\n"

Assign = (assign) ->
	_c += "ASSIGN\n"
	assign()
	_c += "\n"

Init = (name, value) ->
	if value instanceof Array
		value = "{#{value.join(', ')}}"
	_c += tab + "init(#{pad(name + ')', align - 5)} := #{value};\n"

Next = (name, value) ->
	unless value instanceof Function
		val = value
		value = -> Case "1", val
	_c += tab + "next(#{name}) := case\n"
	value()
	_c += tab + "esac;\n"

Case = (expr, value) ->
	if value instanceof Array
		value = "{#{value.join(', ')}}"
	if expr instanceof Array
		expr = expr.join(' & ')
	_c += tab + tab + "#{pad(expr, align - 4)} : #{value};\n"

OutputSMV = ->
	retval = _c
	_c = null
	return retval

# Auxiliary Variable name functions

# Location variable
Loc = (inst, chart) ->
	unless typeof inst is 'string'
		inst = inst.name
	return "Loc_#{inst}_#{chart.number}"

# Active Variable
Active = (chart) -> "active_#{chart.number}"

# Location variable value
L = (location) -> "L#{location}"

# Message variable name
Msg = (m) -> "#{m.name}_#{m.target}_#{m.source}"

@LSC.toSMV = (charts) ->
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
			inst.chart = chart
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
			if (Msg m) not in obj.messageNames
				obj.messageNames.push Msg m
				obj.messages.push m
			m.charts = (c for c in charts when (Msg m) in (Msg msg for msg in c.messages))
			m.prevSourceLoc = m.prevTargetLoc = 0
			for inst in chart.instances
				m.prevSourceLoc = Math.max m.prevSourceLoc, (l for l in inst.locations when l < m.location)...			if inst.name is m.source
				m.prevTargetLoc = Math.max m.prevTargetLoc, (l for l in inst.locations when l < m.location)...			if inst.name is m.target

	return null if not StartSMV()

	Module "main", []
	Var ->
		inparams = [(Loc inst, inst.chart for inst in sys.instances)..., sys.messageNames..., 'current_object']
		Declare 'i', "input(#{('o.' + v for v in inparams).join(', ')})"
		outparams = [(Active chart for chart in charts)..., env.messageNames..., 'gbuchi', 'envreq', (Loc inst, inst.chart for inst in env.instances)...]
		Declare 'o', "output(#{('i.' + v for v in outparams).join(', ')})"

	Module "input", [(Loc inst, inst.chart for inst in sys.instances)..., sys.messageNames..., "current_object"]

	Var ->
		Declare msg, 				"boolean"										for msg in env.messageNames
		Declare "gbuchi",			"0..2"
		Declare (Active chart),		"boolean"										for chart in charts
		Declare "envreq",			env.instanceNames
		Declare (Loc inst, chart),	(L loc for loc in inst.locations)				for inst in chart.instances when  inst.env for chart in charts

	Assign ->
		Init msg,					0												for msg in env.messageNames
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

		Next (Msg m), (->
			notActive = ("#{Active chart} = 0" for chart in m.charts)
			notOthers = ("next(#{msg}) = 0" for msg in [env.messageNames..., sys.messageNames...] when msg isnt (Msg m))
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
			Case ["#{Active chart} = 0", "#{Loc inst, chart} = #{L inst.maxLoc}"],	(L 0)
			Case ["#{Loc inst, chart} = #{L m.prevSourceLoc}",
				  "#{Loc m.target, chart} = #{L m.prevTargetLoc}",
				  "next(#{Loc m.target, chart}) = #{L m.location}",
				  "next(#{Msg m}) = 1"],											(L m.location)		for m in chart.messages when m.source is inst.name
			Case ["#{Loc inst, chart} = #{L m.prevTargetLoc}",
				  "#{Loc m.source, chart} = #{L m.prevSourceLoc}",
				  "next(#{Loc m.source, chart}) = #{L m.location}",
				  "next(#{Msg m}) = 1"],											(L m.location)		for m in chart.messages when m.target is inst.name
			cantFire = (m) -> "(#{Loc m.source, chart} != #{L m.prevSourceLoc} | #{Loc m.target, chart} != #{L m.prevTargetLoc})"
			Case ["#{Loc inst, chart} in {#{(L l for l in inst.locations when l < chart.lineloc).join(', ')}}",
				  (cantFire(m) for m in chart.messages when (Msg m) is msg)...,
				  "#{msg} = 1"],													(L 0)				for msg in chart.messageNames
			Case 1,																	(Loc inst, chart)
		)	for inst in chart.instances when inst.env for chart in charts


	Module "output", [(Active chart for chart in charts)..., env.messageNames..., "gbuchi", "envreq", (Loc inst, inst.chart for inst in env.instances)...]
	
	Var ->
		Declare msg, 						"boolean"										for msg in sys.messageNames
		Declare (Loc inst, chart),			(L l for l in inst.locations)					for inst in chart.instances when not inst.env for chart in charts
		Declare "current_object",			[sys.instanceNames..., env.instanceNames...]
	
	Assign ->
		Init msg,							0												for msg in sys.messageNames
		Init "current_object",				["envreq", sys.instanceNames...]
		Init (Loc inst, chart),				(L 0)											for inst in chart.instances when not inst.env for chart in charts
		
		Next "current_object",				["envreq", sys.instanceNames...]

		Next (Msg m), (->
			Case "next(current_object) != #{m.source}",								0
			notOthers = ("next(#{msg}) = 0" for msg in [env.messageNames..., sys.messageNames...] when msg isnt (Msg m))
			canfire = (m) -> ["#{Loc m.source, chart} = #{L m.prevSourceLoc}",
							  "#{Loc m.target, chart} = #{L m.prevTargetLoc}",
							  "next(#{Loc m.source, chart}) = #{L m.location}",
							  "next(#{Loc m.target, chart}) = #{L m.location}"]
			Case [canfire(m2)..., "#{Active chart} = 1", notOthers...],				1	for m2 in chart.messages when (Msg m2) is (Msg m) for chart in m.charts
			Case 1,																	0
		)	for m in sys.messages
	
		Next (Loc inst, chart), (->
			Case ["#{Active chart} = 0", "#{Loc inst, chart} = #{L inst.maxLoc}"],	(L 0)
			Case ["#{Loc inst, chart} = #{L m.prevSourceLoc}",
				  "#{Loc m.target, chart} = #{L m.prevTargetLoc}",
				  "next(#{Loc m.target, chart}) = #{L m.location}",
				  "next(#{Msg m}) = 1"],											(L m.location)		for m in chart.messages when m.source is inst.name
			Case ["#{Loc inst, chart} = #{L m.prevTargetLoc}",
				  "#{Loc m.source, chart} = #{L m.prevSourceLoc}",
				  "next(#{Loc m.source, chart}) = #{L m.location}",
				  "next(#{Msg m}) = 1"],											(L m.location)		for m in chart.messages when m.target is inst.name
			cantFire = (m) -> "(#{Loc m.source, chart} != #{L m.prevSourceLoc} | #{Loc m.target, chart} != #{L m.prevTargetLoc})"
			Case ["#{Loc inst, chart} in {#{(L l for l in inst.locations when l < chart.lineloc).join(', ')}}",
				  (cantFire(m) for m in chart.messages when (Msg m) is msg)...,
				  "#{msg} = 1"],													(L 0)				for msg in chart.messageNames
			Case 1,																	(Loc inst, chart)
		)	for inst in chart.instances when not inst.env for chart in charts
	
	return OutputSMV()



