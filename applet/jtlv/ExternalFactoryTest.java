import java.io.IOException;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.JFactory;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.ModuleWithWeakFairness;
import edu.wis.jtlv.old_lib.games.GR1Game;
import edu.wis.jtlv.old_lib.games.GameException;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class ExternalFactoryTest {

	/**
	 * main run for the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("bdd_table_size", "1200000");
		System.setProperty("bdd_cache_size", "100000");
		BDDFactory f = JFactory.init(1000, 1000);
		System.out.println(f);
		Env.resetEnv(f);
		
		try {
			// 1. SMV example /////////////////////////////////////////////////
			String input_file = "./testcases/games_tc/arbiter2_with_spec.smv";
			System.out.print("==== Strating synthesis algorithm ========\n");
			Env.loadModule(input_file);
			ModuleWithWeakFairness cx = (ModuleWithWeakFairness) Env
					.getModule("main");
			ModuleWithWeakFairness player1 = (ModuleWithWeakFairness) Env
					.getModule("main.e");
			ModuleWithWeakFairness player2 = (ModuleWithWeakFairness) Env
					.getModule("main.s");

			System.out.print("==== Constructing and playing the game ======\n");
			long time = System.currentTimeMillis();
			GR1Game g = new GR1Game(player1, player2);
			System.out.println("Games time: " + (System.currentTimeMillis() - time));

			BDD all_init = g.getSysPlayer().initial().and(
					g.getEnvPlayer().initial());
			BDD counter_exmple = g.envWinningStates().and(all_init);
			////////////////////// check
			System.out.println(counter_exmple.getFactory());
			//////////////////////
			if (!counter_exmple.isZero()) {
				System.out.print("Specification is unrealizable...\n");
				System.out.print("The env player can win from states:\n\t");
				System.out.print(Env.toNiceString(cx, counter_exmple));
			} else {
				System.out.print("Specification is realizable...\n");
				System.out.print("==== Building an implementation =========\n");
				System.out.print("-----------------------------------------\n");
				g.printWinningStrategy();
				System.out.print("-----------------------------------------\n");
				System.out.println("Strategy time: " + (System.currentTimeMillis() - time));
			}
			System.out.print("===== Done ==================================\n");
		} catch (GameException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
