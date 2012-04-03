import java.io.IOException;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.ModuleWithWeakFairness;
import edu.wis.jtlv.old_lib.games.GR1Game;
import edu.wis.jtlv.old_lib.games.GameException;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class GR1GameMain {

	/**
	 * main run for the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setProperty("bdd", "buddy");
			
			System.setProperty("bdd_table_size", "1200000");
			System.setProperty("bdd_cache_size", "100000");
			
			// 1. SMV example /////////////////////////////////////////////////
			String input_file = "./testcases/games_tc/arbiter8_with_spec.smv";
			System.out.print("==== Strating synthesis algorithm ========\n");
			Env.loadModule(input_file);
			ModuleWithWeakFairness cx = (ModuleWithWeakFairness) Env
					.getModule("main");
			ModuleWithWeakFairness player1 = (ModuleWithWeakFairness) Env
					.getModule("main.e");
			ModuleWithWeakFairness player2 = (ModuleWithWeakFairness) Env
					.getModule("main.s");

			// 2. FDS example /////////////////////////////////////////////////
			// String input_file = "./testcases/games_tc/arbiter2_with_spec.fds";
			// System.out.print("==== Strating synthesis algorithm ========\n");
			// Env.loadModule(input_file);
			// ModuleWithWeakFairness cx = null;
			// ModuleWithWeakFairness player1 = (ModuleWithWeakFairness) Env
			// .getModule("env");
			// ModuleWithWeakFairness player2 = (ModuleWithWeakFairness) Env
			// .getModule("sys");
			// ////////////////////////////////////////////////////////////////

			System.out.print("===== Loaded players ========================\n");
			//System.out.print("---------------------------------------------\n");
			//if (player1 instanceof SMVModule)
			//	((SMVModule) player1).setFullPrintingMode(true);
			//System.out.println(player1);
			//System.out.print("---------------------------------------------\n");
			//if (player2 instanceof SMVModule)
			//	((SMVModule) player2).setFullPrintingMode(true);
			//System.out.println(player2);
			//System.out.print("---------------------------------------------\n");

			System.out.print("==== Constructing and playing the game ======\n");
			long time = System.currentTimeMillis();
			GR1Game g = new GR1Game(player1, player2);
			System.out.println("Games time: " + (System.currentTimeMillis() - time));
			//System.out.println("Player sys winning states are:");
			//System.out.println(Env.toNiceString(cx, g.sysWinningStates()));
			//System.out.println("Player env winning states are:");
			//System.out.println(Env.toNiceString(cx, g.envWinningStates()));

			BDD all_init = g.getSysPlayer().initial().and(
					g.getEnvPlayer().initial());
			BDD counter_exmple = g.envWinningStates().and(all_init);
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
			// error in the game...
			e.printStackTrace();
		} catch (IOException e) {
			// error with reading the file...
			e.printStackTrace();
		}
	}
}
