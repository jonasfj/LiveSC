
import edu.wis.jtlv.env._
import edu.wis.jtlv.lib._
import edu.wis.jtlv.env.spec._
import net.sf.javabdd._
import io._

object Main extends App {
	val lines = io.Source.fromFile("TS.smv").mkString
	println(lines)

	// Load Transition systems
	Env.loadSMVModuleFromString(lines)
	// Load Modules
	var input = Env.getModule("main.i")
	var output = Env.getModule("main.o")
	
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
	def cpred(q : BDD) : BDD = {
		var as1 = env_trans.imp(sys_trans.and(Env.prime(q))).exist(sys_pvars).forAll(env_pvars)
		var as2 = sys_trans.and(env_trans).and(Env.prime(q)).exist(env_pvars).exist(sys_pvars)
		return as1.and(as2)
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
	
	var spec = Env.loadSpecString("SPEC i.gbuchi = 0")(0)
	
	println("--- check ---")
	
	println(checkRealizabtility(spec.toBDD()))
	
	println("--- done ---")
}
