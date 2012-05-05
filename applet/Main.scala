
import edu.wis.jtlv.env._
import edu.wis.jtlv.lib._
import edu.wis.jtlv.env.module._
import edu.wis.jtlv.old_lib.mc._
import net.sf.javabdd._
import io._

object Main extends App {
	val lines = io.Source.fromFile("TS.smv").mkString
	//println(lines)

	// Load Transition systems
	Env.loadSMVModuleFromString(lines)
	// Load Modules
	var main = Env.getModule("main")
	var input = Env.getModule("main.env")
	var output = Env.getModule("main.sys")
	
	/*
	// Display a transition system
	var geek = Env.getModule("main.g");
	println("Module: " + geek.getFullInstName())
	println("Size: " + geek.trans().nodeCount())
	println("Trans: \n" + Env.toNiceString(geek, geek.trans()))
	println("Init: \n" + Env.toNiceString(geek, geek.initial()))
	*/
	
	// Load transition systems
	var env_trans = input.trans()
	var sys_trans = output.trans()
	
	// Variables
	var env_vars = input.moduleVars()
	var sys_vars = output.moduleVars()
	
	var env_pvars = input.modulePrimeVars()
	var sys_pvars = output.modulePrimeVars()
	
	// Find initial conditions
	var env_init = input.initial()
	var sys_init = output.initial()
	
	// Controllable Predecessors
	/*def cpred(q : BDD) : BDD = {
		var as1 = env_trans.imp(sys_trans.and(Env.prime(q))).exist(sys_pvars).forAll(env_pvars)
		var as2 = sys_trans.and(env_trans).and(Env.prime(q)).exist(env_pvars).exist(sys_pvars)
		return as1.and(as2)
	}*/
	def cpred(q : BDD) : BDD = {
		return env_trans.imp(Env.prime(q).and(sys_trans).exist(sys_pvars)).forAll(env_pvars);
	}
	
	// Find Winning States
	def win(q : BDD) : BDD = {
		var z = Env.TRUE()
		var Fz = new FixPoint[BDD]()
		while(Fz.advance(z)){
			var y = Env.FALSE()
			var Fy = new FixPoint[BDD]()
			while(Fy.advance(y)){
				y = cpred(y).or(q.and(cpred(z)))
			}
			z = y
		}
		return z
	}
	
	// Check for realizability
	def checkRealizabtility(q : BDD) : Boolean = {
		var counter = env_init.and(sys_init).and(win(q).not())
		if(!counter.isZero()){
			println("counter-example: \n" + Env.toNiceString(counter))
		}
		return counter.isZero()
	}
	/*
	println("--- test ----")
	println(env_pvars.toString())

	println("Input vars:")
	for(f <- input.getAllFields()){
		println(f.toFullString())
		println("\t" + f.prime().toFullString())
		println("\t" + f.prime().support())
	}
	println("Output vars:")
	for(f <- output.getAllFields()){
		println(f.toFullString())
	}*/

	println("--- Realizability Check ---")
	

	var spec = Env.loadSpecString("SPEC env.gbuchi = 0")(0)
	if(checkRealizabtility(spec.toBDD()))
		println("Realizable")
	else
		println("Not realizable")
	
	/*println("--- Realizability Check (LTL) ---")

	var ltl = "LTLSPEC []<>(i.gbuchi = 0);";
	var ltlspec = Env.loadSpecString(ltl)(0);

	try {
		var checker = new LTLModelChecker(main.asInstanceOf[SMVModule]);
		checker.modelCheck(ltlspec);
	}catch{
		case e: CounterExampleException =>
			e.printStackTrace();
			for(bdd <- e.getPath()){
				println("Print BDD from path")
				println(Env.toNiceString(bdd))
			}
		case e: ModelCheckException => e.printStackTrace();
	}*/
}
