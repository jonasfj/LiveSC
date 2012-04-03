@LSC ?= {}


fromJSONToList = ->
	for instance in chart.instances
		if !(instance in instances)
			@instances.push(instance)
		for message in instance.messages #Bedre metode til at flette lister/køer?
			if !(message in messages)
				@messages.push(message)
		


getInstances = (charts) ->
getMessages = (charts) ->
	messages = {}
	for chart in charts
		for m in chart.messages
			messages["#{m.name}_#{m.target}_#{m.source}"] = []
	for chart in charts
		for m in chart.messages
			messages["#{m.name}_#{m.target}_#{m.source}"].push m
	return messages

msgName = (m) -> "#{m.name}_#{m.target}_#{m.source}"
getAllMsgNames = (charts) ->
	names = []
	for chart in charts
		for m in chart.messages
			names.push "#{m.name}_#{m.target}_#{m.source}"
	return names

locName = (i, c) ->

auxiliaryVariables = (charts) ->
	retval =
		env:
			messages:		[]
			instances: 		[]
		sys:
			messages:		[]
			instances: 		[]
	for chart in charts
		for i in chart.instances
			if i.env
				env.instances.push i.name			if i.name not in env.instances
			else
				sys.instances.push i.name			if i.name not in sys.instances
		for m in chart.messages
			if m.source in env.instances
				env.messages.push msgName(m)		if msgName(m) not in env.messages
			else
				sys.messages.push msgName(m)		if msgName(m) not in sys.messages
	return retval
maxLoc = (chart, instance) ->
	loc = 0
	for m in chart.messages when m.source = instance.name
		if m.location > loc
			loc = m.location
	return "L#{loc}"

maxPreLoc = (chart, instance) ->
	loc = 0
	preloc = chart.lineloc
	for m in chart.messages when m.source = instance.name
		if m.location > loc & m.location < preloc
			loc = m.location
	return "L#{loc}"

# Get SMV given charts as a list of JSON charts
@LSC.fromJSONToSMV = (charts)->
	for chart in charts
		chart.messages.sort (m1, m2) -> m1.location > m2.location

	for chart  in charts
		chart.locations
	instances = getInstances(charts)
	messages = getMessages(charts)
	
	SMVCode = ""
	P = (str) -> SMVCode += str + "\n"
	Pi = (str) -> P "    " + str
	Pii = (str) -> Pi "    " + str
	
	{env, sys} = auxiliaryVariables(charts)
	
	#### Input MODULE
	import_msgs = sys.messages.join(', ')
	import_locs = []
	for chart, j in charts
		for i in chart.instances when !(i.env)
			import_locs.push "loc_#{i.name}_#{j}"
	import_locs = import_locs.join(', ')
	P "MODULE Input (#{import_msgs}, #{import_locs}, current_object)"
	P "VAR"
	for m in env.messages
		P "    #{m} : boolean;"
	P "    gbuchi : 0..2;"
	for chart, i in charts
		Pi "active_#{i} : boolean;"
	Pi "envreq : {#{env.instances.join(', ')}};"
	for chart, j in charts
		for i in chart.instances when i.env
			space = ["L0"]
			for m in chart.messages when m.source = i.name
				space.push "L#{m.location}"
			Pi "loc_#{i.name}_#{j} : {#{space.join(', ')}};"
	
	#### ASSIGN Initial Values
	P "ASSIGN"
	for m in env.messages
		Pi "init(#{m}) := 0;"
	for chart, j in charts
		for i in chart.instances when i.env
			Pi "init(loc_#{i.name}_#{j}) := L0;"
	Pi "init(gbuchi) := 0;"
	for chart, i in charts
		Pi "init(active_#{i}) := 0;"
	Pi "init(envreq) := {#{env.instances.join(', ')}};"
	
	#### ASSIGN Next Value
	ownerInstanceName = (m) ->
		for chart in charts
			for msg in chart.messages when msgName(msg) == m
				return msg.source
	notOthers = (msg) -> ("next(#{m}) = 0" for m in env.messages when m isnt msg).join(' & ')
	for m in env.messages
		Pi "next(#{m}) := case"
		Pii "next(current_object) != #{ownerInstanceName(m)} : 0;"		
		notActive = (i for chart, i in charts when m in (msgName(msg) for msg in chart.messages))
		notActive = ("active_#{i} = 0" for i in notActive).join(' & ')
		Pii "#{notOthers(m)} & #{notActive} : {0, 1};"
		Pii "1 : 0;"
		Pi "esac;"
	Pi "next(gbuchi) := case"
	Pii "gbuchi = 0 : 1;"
	notActive = ("active_#{i} = 0" for chart, i in charts).join(' & ')
	notCurrent = ("current_object != #{i.name}" for i in env.instances).join(' & ')
	Pii "gbuchi = 1 & #{notActive} : 2;"
	Pii "gbuchi = 2 & #{notCurrent} : 0;"
	Pii "1 : gbuchi;"
	Pi "esac;"
	for chart, i in charts
		Pi "next(active_#{i}) := case"
		s = ("next(loc_#{inst.name}_#{i}) = #{maxPreLoc(chart, inst)}" for inst in chart.instances).join(' & ')
		Pii "active_#{i} = 0 & #{s} : 1;"
		s = ("next(loc_#{inst.name}_#{i}) = #{maxLoc(chart, inst)}" for inst in chart.instances).join(' & ')
		Pii "active_#{i} = 1 & #{s} : 0;" #Tager ikke hensyn til ulovlige, universelle LSC'er, der ikke kan få active = 0 igen
		Pii "1 : active_#{i};"
		Pi "esac;" 

	for chart, j in charts
		for i in chart.instances when i.env
			loc_name = "loc_#{i.name}_#{j}"
			Pi "next(loc_#{i.name}_#{j}) := case"
			Pii "active_#{i} = 0 & loc_#{i.name}_#{j} = #{maxLoc(chart,i)} : 0;"
			#Gå igennem alle beskeder og se på både sender og modtager. For hver skal der laves en linje, der siger, om vi rykker en position frem. Hvis vi er modtager og current_object er afsender, skal vi se på next for afsenderen.
			
			prev_loc = "L0"
			for m in chart.messages when m.target = i.name
				curr_loc = "L#{m.location}"
				
				Pii "#{loc_name} = #{prev_loc} & next(#{msgName(m)}) = 1 : #{curr_loc};"
				
				prev_loc = curr_loc
#			m.name
#			m.source
#			m.target
#			m.location
#			msgName(m) in env.messages
			Pii "next(current_object) = #{m.target} & loc_#{m.source}_#{j}=#{m.location} & loc_#{m.target}_#{j}=#{m.location-1} : m.location ;" #sidste er lig loc_#{i.name}_#{j}
		for m in chart.messages when m.source = i.name
			Pii "next(current_object) = #{m.source} & next(#{m.target})=#{m.location} & loc_#{m.target}_#{j}=#{m.location-1} : m.location ;" #sidste er lig loc_#{i.name}_#{j}



	Pi "next(envreq) := {#{env.instances.join(', ')}};"








#####"

	#### Output module
	import_active = ("active_#{i}" for chart, i in charts).join(', ')
	import_msgs = env.messages.join(', ')
	import_locs = []
	for chart, j in charts
		for i in chart.instances when i.env
			import_locs.push "loc_#{i.name}_#{j}"
	import_locs = import_locs.join(', ')
	P "MODULE Output (envreq, gbuchi, #{import_active}, #{import_msgs}, #{import_locs})"
	P "VAR"
	for m in sys.messages
		Pi "#{m} : boolean;"
	for chart, j in charts
		for i in chart.instances when not i.env
			space = ["L0"]
			for m in chart.messages when m.source = i.name
				space.push "L#{m.location}"
			Pi "loc_#{i.name}_#{j} : {#{space.join(', ')}};"
	processes = (i.name for i in env.instance.concat(sys.instances))
	Pi "current_process : {#{processes.join(', ')}};"

	#### ASSIGN Initial Values
	P "ASSIGN"
	for m in sys.messages
		Pi "init(#{m}) := 0;"
	for chart, j in charts
		for i in chart.instances when not i.env
			Pi "init(loc_#{i.name}_#{j}) := 0;"
	Pi "init(current_process) := {envreq, #{(i.name for i in sys.instances).join(', ')}};"
	
	#### ASSIGN Next Value
	for m in sys.messages
		Pi "next(#{m}) := case"
		Pii "next(current_process) != #{ownerInstanceName(m)};"
		notActive = (i for chart, i in charts when m in (msgName(msg) for msg in chart.messages))
		notActive = ("active_#{i} = 0" for i in notActive).join(' & ')
		Pii "#{notOthers} & #{notActive} : {0, 1};"
		Pii "1 : 0;"
		Pi "esac;"
	Pi "next(current_process) := {envreq, #{(i.name for i in sys.instances).join(', ')}};"






















