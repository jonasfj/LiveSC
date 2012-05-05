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
align = 100 - 5

Module = (name, params) ->
	if params.length > 0
		_c += "MODULE #{name} (#{params.join(', ')})\n\n"
	else
		_c += "MODULE #{name}\n\n"

Var = (declare) ->
	_c += "VAR\n"
	declare()
	_c += "\n"

Declare = (name, type) ->
	if type instanceof Array
		type = "{#{List type}}"
	_c += tab + "#{pad(name, align)} : #{type};\n"

Assign = (assign) ->
	_c += "ASSIGN\n"
	assign()
	_c += "\n"

Define = (definitions) ->
	_c += "DEFINE\n"
	definitions()
	_c += "\n"

Definition = (name, expr) ->
	if expr instanceof Function
		expr = expr()
	_c += tab + "#{pad(name, align)} := #{expr};\n"

Init = (name, expr) ->
	if expr instanceof Function
		expr = expr()
	_c += tab + "init(#{pad(name + ')', align - 5)} := #{expr};\n"

Next = (name, expr) ->
	if expr instanceof Function
		if expr.is_switch is true
			_c += tab + "next(#{name}) := "
			expr()
			_c += "\n"
			return
		else
			expr = expr()
	_c += tab + "next(#{pad(name + ')', align - 5)} := #{expr};\n"

Quite = false

Comment = (comment) ->
	unless Quite
		_c += tab + "-- #{comment}\n"

Switch = (cases) ->
	s = ->
		_c += "case\n"
		cases()
		_c += tab + "esac;"
	s.is_switch = true
	return s

Case = (expr1, expr2) ->
	if expr1 instanceof Function
		expr1 = expr1()
	if expr2 instanceof Function
		expr2 = expr2()
	_c += tab + tab + "#{pad(expr1, align - 4)} : #{expr2};\n"

Op = (val) -> (expr) -> if expr? then Op -> val() + " " + expr() else val()

Or = (expr) -> Op ->
	return (e() for e in expr).join(" | ")  if expr instanceof Array 
	return "| " + expr()
And = (expr) -> Op ->
	return (e() for e in expr).join(" & ")  if expr instanceof Array 
	expr = expr()
	return "& " + expr						if expr isnt ""
	return ""
Eq 	= (expr) -> Op -> "= " + expr()
In 	= (expr) -> Op -> "in " + expr()
Neq = (expr) -> Op -> "!= " + expr()
Geq = (expr) -> Op -> ">= " + expr()
Leq = (expr) -> Op -> "<= " + expr()
Ge 	= (expr) -> Op -> "> " + expr()
Le 	= (expr) -> Op -> "< " + expr()

C = (constant) -> Op -> constant
V = (term) -> Op -> term
N = (term) -> Op -> "next(#{term})"
Set = (list...) -> Op ->
	list = list[0] if list[0] instanceof Array and not list[1]?
	"{#{List ((if expr instanceof Function then expr() else expr) for expr in list)}}"
P = (expr) -> Op -> "(" + expr() + ")"
True = C('1')
False = C('0')


List = (list) -> list.join(', ')

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

# Message variable name
Msg = (m) -> "#{m.name}_#{m.source}_#{m.target}"

@LSC.toSMV = (charts, quite = true) ->
	Quite = quite
	env = instances: [], instanceNames: [], messages: [], messageNames: []
	sys = instances: [], instanceNames: [], messages: [], messageNames: []
	for chart, i in charts
		chart.lineloc += 1
		for m in chart.messages
			m.location += 1
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
			inst.locations = [0, 1]
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
			m.prevSrcLocs = m.prevDstLocs = 0
			for inst in chart.instances
				m.prevSrcLocs = Math.max m.prevSrcLocs, (l for l in inst.locations when l < m.location)...		if inst.name is m.source
				m.prevDstLocs = Math.max m.prevDstLocs, (l for l in inst.locations when l < m.location)...		if inst.name is m.target
				if m.prevSrcLocs is 1
					m.prevSrcLocs = [0, 1]
				if m.prevDstLocs is 1
					m.prevDstLocs = [0, 1]


	return null if not StartSMV()

	Module "main", []
	Var ->
		Declare 'env', "environment(#{List ('sys.' + v for v in [sys.messageNames..., 'current_object'])})"
		Declare 'sys', "system(env.envreq)"

	Module "environment", [sys.messageNames..., "current_object"]

	Var ->
		Declare msg, 				"boolean"										for msg in env.messageNames
		Declare "gbuchi",			[0, 1, 2]
		Declare "envreq",			env.instanceNames
		Declare (Loc inst, chart),	[inst.locations..., inst.maxLoc + 1]			for inst in chart.instances for chart in charts

	Define ->
		active_cond = (chart) -> (And (V(Loc inst, chart) Geq C(inst.maxPreLoc) 	for inst in chart.instances))
		Definition (Active chart),	active_cond(chart)								for chart in charts

	Assign ->
		Init msg,					False											for msg in env.messageNames
		Init (Loc inst, chart),		C(1)											for inst in chart.instances for chart in charts
		Init "envreq",				Set(env.instanceNames)
		Init "gbuchi",				C(0)

		Comment "Object that environment requests as current_object"
		Next "envreq",				Set(env.instanceNames)
		
		Comment "Winning condition, encoded as generalized buchi automata"
		Next "gbuchi", Switch ->
			Case (V('gbuchi') Eq C(0)),																		C(1)
			Case (V('gbuchi') Eq C(1) And (And (V(Active chart) Eq False for chart in charts))), 			C(2)
			Case (V('gbuchi') Eq C(2) And V('current_object') In Set(env.instanceNames)),					C(0)
			Case True,																						V('gbuchi')

		Comment "Message can fire if source is current_object, and other messages doesn't fire"
		not_other_msg = (msg1) -> And (N(msg2) Eq False for msg2 in env.messageNames when msg1 isnt msg2)
		Next (Msg m), (Switch ->
			Case (V('current_object') Eq V(m.source) And not_other_msg(Msg m)),								Set(False, True)
			Case True,																						False
		)	for m in env.messages

		Next (Loc inst, chart), (Switch ->
			Comment "Reset if any other locations in this chart decides to reset"
			does_reset = (i)-> V(Loc i, chart) Neq C(0) And N(Loc i, chart) Eq C(0)
			Case (Or (does_reset(i) for i in chart.instances when i isnt inst)),			C(1)

			# Messages relevant to this instance line
			relevant_msgs = (m for m in chart.messages when inst.name in [m.source, m.target])
			last_msg = (m for m in relevant_msgs when m.location is inst.maxLoc)[0]

			# Helper conditions
			in_mainchart = (m) -> if m.location > chart.lineloc then True else False
			move_msg = (m) -> V(Loc m.source, chart) In Set(m.prevSrcLocs) And V(Loc m.target, chart) In Set(m.prevDstLocs) And V(Msg m) Eq True

			Comment "Reset on last message if others are at end or resetting too"
			at_end = (And (V(Loc i, chart) Eq C(i.maxLoc) for i in chart.instances when i.name not in [last_msg.source, last_msg.target]))
			Case (move_msg(last_msg) And at_end),										C(0)

			Comment "Move forward on each relevant message"
			Case (move_msg(m) And V(Active chart) Eq in_mainchart(m)),					C(m.location)			for m in relevant_msgs

			Comment "If message is relevant and chart inactive reset pre-chart"
			Case (V(Active chart) Eq False And V(Msg m) Eq True), 						C(0) 					for m in relevant_msgs

			Comment "If message is relevant and chart active go to dead location"
			Case (V(Active chart) Eq True And V(Msg m) Eq True), 						C(inst.maxLoc + 1) 		for m in relevant_msgs

			Comment "Clean-up the reset operation, not strictly necessary but nice"
			Case (V(Loc inst, chart) Eq C(0)),											C(1)

			Case True,																	V(Loc inst, chart)
		)	for inst in chart.instances for chart in charts


	Module "system", ["envreq"]
	
	Var ->
		Declare msg, 						"boolean"										for msg in sys.messageNames
		Declare "current_object",			[sys.instanceNames..., env.instanceNames...]
	
	Assign ->
		Init msg,							False											for msg in sys.messageNames
		Init "current_object",				Set("envreq", sys.instanceNames...)

		Next "current_object",				Set("envreq", sys.instanceNames...)

		Comment "Message can fire if source is current_object, and other messages doesn't fire"
		not_other_msg = (msg1) -> And (N(msg2) Eq False for msg2 in sys.messageNames when msg1 isnt msg2)
		Next (Msg m), (Switch ->
			Case (V('current_object') Eq V(m.source) And not_other_msg(Msg m)),								Set(False, True)
			Case True,																						False
		)	for m in sys.messages

	return OutputSMV()

