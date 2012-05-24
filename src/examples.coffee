@LSC ?= {}

# Array of example systems
@LSC.Examples = Examples = []

# Shorthand function to add an example
Example = (e) -> Examples.push e

# Renders the list of examples as an overlay
LSC.loadExample = (callback) ->
	$("#examples").html("")
	topdiv = $("<div class=\"topdiv\"></div>")
	$("<h1>Pick an Example</h1>").appendTo(topdiv)
	close = $("<span style=\"float:right;\">(Close)</span>")
	close.click ->
		$("#examples").fadeOut(cfg.animation.speed)
	close.appendTo(topdiv)
	topdiv.appendTo("#examples")
	for ex in LSC.Examples
		div = $("<div><img src=\"#{ex.image}\"><div><h2>#{ex.title}</h2>#{ex.description}</div></div>")
		div.addClass("example")
		div.click do(ex) -> ->
			callback(ex.json)
			$("#examples").fadeOut(cfg.animation.speed)
		div.appendTo("#examples")
	$("#examples").fadeIn(cfg.animation.speed)

Example
	title: "Bank"
	description: """<b>Example from paper:</b> Illustrates the interaction between a customer and bank.
					   When the customer enters the bank he or she must either deposit or withdraw to get a receipt.
					   This example is realizable as it is not possible to execute the <i>false</i> mainchart in the 'Bank Regulations' scenario.
					   This is because the prechart is aborted, whenever a <i>withdraw</i> or <i>deposit</i> message is seen."""
	image: "images/bank.png"
	json: {"title":"Bank","charts":[{"name":"Bank Regulations","disabled":true,"lineloc":3,"resloc":4,"locations":7,"instances":[{"name":"Bank","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"enter","location":1,"source":"Customer","target":"Bank"},{"name":"getReceipt","location":2,"source":"Bank","target":"Customer"},{"name":"withdraw","location":5,"source":"Customer","target":"Bank"},{"name":"deposit","location":6,"source":"Customer","target":"Bank"}]},{"name":"withdraw","disabled":false,"lineloc":3,"resloc":5,"locations":6,"instances":[{"name":"Bank","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"enter","location":1,"source":"Customer","target":"Bank"},{"name":"withdraw","location":2,"source":"Customer","target":"Bank"},{"name":"getReceipt","location":4,"source":"Bank","target":"Customer"}]},{"name":"deposit","disabled":false,"lineloc":3,"resloc":5,"locations":6,"instances":[{"name":"Bank","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"enter","location":1,"source":"Customer","target":"Bank"},{"name":"deposit","location":2,"source":"Customer","target":"Bank"},{"name":"getReceipt","location":4,"source":"Bank","target":"Customer"}]}]}	

Example
	title: "Bad Bank"
	description: """Same as the bank example, yet this version is not realizable, since we can enter the <i>false</i> mainchart."""
	image: "images/badbank.png"
	json: {"title":"Bad Bank","charts":[{"name":"Bank Regulations","disabled":true,"lineloc":3,"resloc":4,"locations":6,"instances":[{"name":"Bank","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"enter","location":1,"source":"Customer","target":"Bank"},{"name":"getReceipt","location":2,"source":"Bank","target":"Customer"},{"name":"withdraw","location":5,"source":"Customer","target":"Bank"}]},{"name":"withdraw","disabled":false,"lineloc":3,"resloc":5,"locations":6,"instances":[{"name":"Bank","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"enter","location":1,"source":"Customer","target":"Bank"},{"name":"withdraw","location":2,"source":"Customer","target":"Bank"},{"name":"getReceipt","location":4,"source":"Bank","target":"Customer"}]},{"name":"deposit","disabled":false,"lineloc":3,"resloc":5,"locations":6,"instances":[{"name":"Bank","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"enter","location":1,"source":"Customer","target":"Bank"},{"name":"deposit","location":2,"source":"Customer","target":"Bank"},{"name":"getReceipt","location":4,"source":"Bank","target":"Customer"}]}]}
	
Example
	title: "Ping/Pong Example"
	description: "Server always replies with pong, with client pings.<br>Simple and realizable."
	image: "images/pingpong.png"
	json: {"title":"ping.lsc","charts":[{"name":"Ping/Pong","disabled":false,"lineloc":2,"resloc":4,"locations":5,"instances":[{"name":"Client","number":0,"env":true},{"name":"Server","number":1,"env":false}],"messages":[{"name":"Ping","location":1,"source":"Client","target":"Server"},{"name":"Pong","location":3,"source":"Server","target":"Client"}]}]}

Example
	title: "The Pong/Pongo Disagreement"
	description: "Two charts disagree about the order in which the server must reply, pong and pongo.<br>This example shows a simple conflict and is not realizable."
	image: "images/pongo.png"
	json: {"title":"Pongo.lsc","charts":[{"name":"PingPongPongo","disabled":false,"lineloc":2,"resloc":5,"locations":6,"instances":[{"name":"Server","number":1,"env":false},{"name":"Client","number":0,"env":true}],"messages":[{"name":"Ping","location":1,"source":"Client","target":"Server"},{"name":"Pong","location":3,"source":"Server","target":"Client"},{"name":"Pongo","location":4,"source":"Server","target":"Client"}]},{"name":"PingPongoPong","disabled":false,"lineloc":2,"resloc":5,"locations":6,"instances":[{"name":"Server","number":1,"env":false},{"name":"Client","number":0,"env":true}],"messages":[{"name":"Ping","location":1,"source":"Client","target":"Server"},{"name":"Pongo","location":3,"source":"Server","target":"Client"},{"name":"Pong","location":4,"source":"Server","target":"Client"}]}]}


Example
	title: "The Nice Matrix"
	description: "A subset of the specifications for a nice version of The Matrix. In this small world, a man chopping a tree, forces the tree to fall, and a bird to move (expressed independently in two senarios). However, if the bird moves after the tree has fallen, the observer will have seen death. We will not allow the observer to observe death.<br>Now we may wonder if a realization of The Nice Matrix is possible, our tool will answer this question. Click here to load the model and find out for your self."
	image: "images/matrix.png"
	json: {"title":"TheNiceMatrix.lsc","charts":[{"name":"ChopTree => Bird Moves","disabled":false,"lineloc":2,"resloc":4,"locations":5,"instances":[{"name":"Bird","number":0,"env":false},{"name":"Man","number":2,"env":true},{"name":"Observer","number":1,"env":true}],"messages":[{"name":"ChopTree","location":1,"source":"Man","target":"Man"},{"name":"Move","location":3,"source":"Bird","target":"Observer"}]},{"name":"ChopTree => Tree Falls","disabled":false,"lineloc":2,"resloc":4,"locations":5,"instances":[{"name":"Tree","number":0,"env":false},{"name":"Observer","number":1,"env":true},{"name":"Man","number":2,"env":true}],"messages":[{"name":"ChopTree","location":1,"source":"Man","target":"Man"},{"name":"Fall","location":3,"source":"Tree","target":"Observer"}]},{"name":"Tree on Bird => Death","disabled":false,"lineloc":3,"resloc":5,"locations":6,"instances":[{"name":"Tree","number":0,"env":false},{"name":"Bird","number":1,"env":false},{"name":"Observer","number":2,"env":true}],"messages":[{"name":"Fall","location":1,"source":"Tree","target":"Observer"},{"name":"Move","location":2,"source":"Bird","target":"Observer"},{"name":"Death","location":4,"source":"Bird","target":"Observer"}]},{"name":"No observable Death","disabled":true,"lineloc":2,"resloc":3,"locations":4,"instances":[{"name":"Bird","number":0,"env":false},{"name":"Observer","number":1,"env":false}],"messages":[{"name":"Death","location":1,"source":"Bird","target":"Observer"}]}]}


Example
	title: "Coffee Machine Example"
	description: """This example illustrates the specification of a coffee machine, given four scenarios: preparing coffee, serving coffee, 
					giving money back and refilling the reservoir.
					<br/>Source: <i>Relating Inter-Agent and Intra-Agent Specifications, The Case of Live Sequence Charts</i> - Yves Bontemps"""
	image: "images/coffee.png"
	json: {"title":"Coffee machine.lsc","charts":[{"name":"prep_coffee","disabled":false,"lineloc":2,"resloc":8,"locations":9,"instances":[{"name":"Machine","number":0,"env":false},{"name":"Cup","number":1,"env":false},{"name":"Customer","number":3,"env":true},{"name":"Reservoir","number":2,"env":false}],"messages":[{"name":"prepCoffee","location":1,"source":"Machine","target":"Machine"},{"name":"addCoffee","location":3,"source":"Machine","target":"Cup"},{"name":"getWater","location":4,"source":"Machine","target":"Reservoir"},{"name":"pourWater","location":5,"source":"Reservoir","target":"Cup"},{"name":"serveCoffee","location":6,"source":"Machine","target":"Customer"},{"name":"takeCup","location":7,"source":"Customer","target":"Cup"}]},{"name":"serve_coffee","disabled":false,"lineloc":3,"resloc":6,"locations":8,"instances":[{"name":"Machine","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"giveMoney","location":1,"source":"Customer","target":"Machine"},{"name":"askCoffee","location":2,"source":"Customer","target":"Machine"},{"name":"prepCoffee","location":4,"source":"Machine","target":"Machine"},{"name":"serveCoffee","location":5,"source":"Machine","target":"Customer"},{"name":"moneyBack","location":7,"source":"Machine","target":"Customer"}]},{"name":"money_back","disabled":false,"lineloc":3,"resloc":5,"locations":7,"instances":[{"name":"Machine","number":0,"env":false},{"name":"Customer","number":1,"env":true}],"messages":[{"name":"giveMoney","location":1,"source":"Customer","target":"Machine"},{"name":"claimMoney","location":2,"source":"Customer","target":"Machine"},{"name":"moneyBack","location":4,"source":"Machine","target":"Customer"},{"name":"serveCoffee","location":6,"source":"Machine","target":"Customer"}]},{"name":"fill_up","disabled":false,"lineloc":2,"resloc":5,"locations":6,"instances":[{"name":"Reservoir","number":0,"env":false},{"name":"Cup","number":1,"env":false},{"name":"Janitor","number":2,"env":true}],"messages":[{"name":"pourWater","location":1,"source":"Reservoir","target":"Cup"},{"name":"iAmEmpty","location":3,"source":"Reservoir","target":"Janitor"},{"name":"fill","location":4,"source":"Janitor","target":"Reservoir"}]}]}


Example
	title: "Mobile Phone Example"
	description: """This example models the interaction between the environment, a user and a mobile phone through three scenarios: closing the cover, 
					receiving a call and talking in the phone.<br/>
					<strong>Note:</strong> This model is too complicated for model checking using this tool in its current state.
					<br/>Source: <a href='http://www.scm.tees.ac.uk/s.qin/papers/tase07.pdf'>Realizing Live Sequence Charts in SystemVerilog</a>"""	
	image: "images/mobile.png"
	json: {"title":"Phone.lsc","charts":[{"name":"CloseCover","disabled":false,"lineloc":2,"resloc":6,"locations":7,"instances":[{"name":"User","number":0,"env":true},{"name":"Cover","number":1,"env":false},{"name":"Chip","number":2,"env":false},{"name":"Display","number":3,"env":false}],"messages":[{"name":"close","location":1,"source":"User","target":"Cover"},{"name":"coverClosed","location":3,"source":"Cover","target":"Chip"},{"name":"displayTime","location":4,"source":"Chip","target":"Display"},{"name":"setDisplayTime","location":5,"source":"Display","target":"Display"}]},{"name":"Receive","disabled":false,"lineloc":2,"resloc":6,"locations":7,"instances":[{"name":"Env","number":0,"env":true},{"name":"Chip","number":1,"env":false},{"name":"Speaker","number":2,"env":false},{"name":"Display","number":3,"env":false}],"messages":[{"name":"incomingCall","location":1,"source":"Env","target":"Chip"},{"name":"startRing","location":3,"source":"Chip","target":"Speaker"},{"name":"displayCallerID","location":4,"source":"Chip","target":"Display"},{"name":"setDisplayCaller","location":5,"source":"Display","target":"Display"}]},{"name":"Talk","disabled":false,"lineloc":4,"resloc":9,"locations":11,"instances":[{"name":"Env","number":0,"env":true},{"name":"User","number":1,"env":true},{"name":"Cover","number":2,"env":false},{"name":"Chip","number":3,"env":false},{"name":"Speaker","number":4,"env":false},{"name":"Display","number":5,"env":false}],"messages":[{"name":"open","location":1,"source":"User","target":"Cover"},{"name":"coverOpened","location":2,"source":"Cover","target":"Chip"},{"name":"startRing","location":3,"source":"Chip","target":"Speaker"},{"name":"talk","location":8,"source":"User","target":"Env"},{"name":"speakerOff","location":5,"source":"Chip","target":"Speaker"},{"name":"displayTimer","location":6,"source":"Chip","target":"Display"},{"name":"setDisplayTimer","location":7,"source":"Display","target":"Display"},{"name":"close","location":10,"source":"User","target":"Cover"}]}]}


Example
	title: "Don't Kill the Bird"
	description: "A man chops a tree, the tree falls and bird move, but bird must move before the tree falls, so not to kill the bird. This example shows how an ordering of messages can be imposed, indirectly. The example is realizable."
	image: "images/DontKillBird.png"
	json: {"title":"TreeBird.lsc","charts":[{"name":"Noise Required","disabled":true,"lineloc":3,"resloc":4,"locations":6,"instances":[{"name":"Tree","number":0,"env":false},{"name":"Bird","number":1,"env":false}],"messages":[{"name":"Fall","location":1,"source":"Tree","target":"Tree"},{"name":"Bird","location":2,"source":"Bird","target":"Bird"},{"name":"Noise","location":5,"source":"Tree","target":"Bird"}]},{"name":"Dont Kill Bird","disabled":true,"lineloc":4,"resloc":5,"locations":6,"instances":[{"name":"Tree","number":0,"env":false},{"name":"Bird","number":1,"env":false}],"messages":[{"name":"Fall","location":1,"source":"Tree","target":"Tree"},{"name":"Noise","location":2,"source":"Tree","target":"Bird"},{"name":"Move","location":3,"source":"Bird","target":"Bird"}]},{"name":"Timber!","disabled":false,"lineloc":2,"resloc":5,"locations":6,"instances":[{"name":"Tree","number":0,"env":false},{"name":"Bird","number":1,"env":false},{"name":"Man","number":2,"env":true}],"messages":[{"name":"Chop","location":1,"source":"Man","target":"Man"},{"name":"Move","location":3,"source":"Bird","target":"Bird"},{"name":"Fall","location":4,"source":"Tree","target":"Tree"}]}]}


