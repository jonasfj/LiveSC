
import javax.swing._
import java.awt.Graphics;
import edu.wis.jtlv.env._
import edu.wis.jtlv.lib._
import edu.wis.jtlv.env.spec._
import net.sf.javabdd._

class Applet extends JApplet{
	override def init() {}
	def checkRealizability(model : String) : String = {
		// Load Transition systems
		Env.loadSMVModuleFromString(model)

		// Load Modules
		var env = Env.getModule("main.env")
		var sys = Env.getModule("main.sys")

		// Load transition systems
		var env_trans = env.trans()
		var sys_trans = sys.trans()

		// Variables
		var env_vars = env.moduleVars()
		var sys_vars = sys.moduleVars()

		var env_pvars = env.modulePrimeVars()
		var sys_pvars = sys.modulePrimeVars()

		// Find initial conditions
		var env_init = env.initial()
		var sys_init = sys.initial()

		// Controllable Predecessors
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
			return counter.isZero()
		}

		var spec = Env.loadSpecString("SPEC env.gbuchi = 0")(0)

		var result = checkRealizabtility(spec.toBDD())

		Env.resetEnv()

		if(result)
			return "Realizable"
		else
			return "Not realizable"
	
	}
}

