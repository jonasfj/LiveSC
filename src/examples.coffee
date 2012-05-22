

@LSC ?= {}
@LSC.Examples = Examples = []

LSC.loadExample = (callback) ->
	$("#examples").html("")
	topdiv = $("<div class=\"topdiv\"></div>")
	$("<h1>Pick an Example</h1>").appendTo(topdiv)
	close = $("<span style=\"float:right;\">(Close)</span>")
	close.click ->
		$("#examples").hide(cfg.animation.speed)
	close.appendTo(topdiv)
	topdiv.appendTo("#examples")
	for ex in LSC.Examples
		div = $("<div><img src=\"#{ex.image}\"><h2>#{ex.title}</h2><p>#{ex.description}</p></div>")
		div.click do(ex) -> ->
			callback(ex.json)
			$("#examples").hide(cfg.animation.speed)
		div.appendTo("#examples")
	$("#examples").show(cfg.animation.speed)

Examples.push
	title: "Ping/Pong Example"
	description: "Server always replies with pong, with client pings.<br>Simple and realizable."
	image: "images/pingpong.png"
	json: {"title":"ping.lsc","charts":[{"name":"Ping/Pong","lineloc":2,"resloc":4,"locations":5,"instances":[{"name":"Client","number":0,"env":true},{"name":"Server","number":1,"env":false}],"messages":[{"name":"Ping","location":1,"source":"Client","target":"Server"},{"name":"Pong","location":3,"source":"Server","target":"Client"}]}]}

Examples.push
	title: "Coffee Machine Example"
	description: "Coffee Machine that can take money and serve coffe, without giving back money."
	image: "images/coffee.png"
	json: {"title":"Coffee machine.lsc","charts":[{"name":"prep_coffee","lineloc":2,"resloc":8,"locations":9,"instances":[{"name":"Machine","number":0,"env":false},{"name":"Cup","number":1,"env":false},{"name":"Customer","number":3,"env":true},{"name":"Reservoir","number":2,"env":false}],"messages":[{"name":"prepCoffee","location":1,"source":"Machine","target":"Machine"},{"name":"addCoffee","location":3,"source":"Machine","target":"Cup"},{"name":"getWater","location":4,"source":"Machine","target":"Reservoir"},{"name":"pourWater","location":5,"source":"Reservoir","target":"Cup"},{"name":"serveCoffee","location":6,"source":"Machine","target":"Customer"},{"name":"takeCup","location":7,"source":"Customer","target":"Cup"}]},{"name":"serve_coffee","lineloc":3,"resloc":6,"locations":8,"instances":[{"name":"Machine","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"giveMoney","location":1,"source":"Customer","target":"Machine"},{"name":"askCoffee","location":2,"source":"Customer","target":"Machine"},{"name":"prepCoffee","location":4,"source":"Machine","target":"Machine"},{"name":"serveCoffee","location":5,"source":"Machine","target":"Customer"},{"name":"moneyBack","location":7,"source":"Machine","target":"Customer"}]},{"name":"money_back","lineloc":3,"resloc":5,"locations":7,"instances":[{"name":"Machine","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"giveMoney","location":1,"source":"Customer","target":"Machine"},{"name":"claimMoney","location":2,"source":"Customer","target":"Machine"},{"name":"moneyBack","location":4,"source":"Machine","target":"Customer"},{"name":"serveCoffee","location":6,"source":"Machine","target":"Customer"}]},{"name":"fill_up","lineloc":2,"resloc":5,"locations":6,"instances":[{"name":"Reservoir","number":0,"env":false},{"name":"Cup","number":1,"env":false},{"name":"Janitor","number":2,"env":true}],"messages":[{"name":"pourWater","location":1,"source":"Reservoir","target":"Cup"},{"name":"iAmEmpty","location":3,"source":"Reservoir","target":"Janitor"},{"name":"fill","location":4,"source":"Janitor","target":"Reservoir"}]}]}


