
import javax.swing._
import java.awt.Graphics;
import edu.wis.jtlv.env._
import edu.wis.jtlv.lib._
import edu.wis.jtlv.env.spec._
import net.sf.javabdd._

class Applet extends JApplet{
	override def init() {
	}
	def greet(name : String) : String = {
		return "Hello " + name + " now check if I work!"
	}
	def checkRealizability(model : String) : String = {
		// Load Transition systems
		Env.loadSMVModuleFromString(model)

		// Load Modules
		var input = Env.getModule("main.i")
		var output = Env.getModule("main.o")

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
			return counter.isZero()
		}

		var spec = Env.loadSpecString("SPEC i.gbuchi = 0")(0)

		var result = checkRealizabtility(spec.toBDD())

		Env.resetEnv()

		if(result)
			return "Realizable"
		else
			return "Not realizable"
	
	}
}

