
import java.io.IOException;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.FDSModule;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class FDSFileConstructionTest {
	/**
	 * main run for the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] file_names = new String[8];
		// file_name = args[0];
		file_names[0] = "./testcases/legacy/testcase1.fds";
		file_names[1] = "./testcases/legacy/testcase2.fds";
		file_names[2] = "./testcases/legacy/testcase3.fds";
		file_names[3] = "./testcases/legacy/testcase4.fds";
		file_names[4] = "./testcases/legacy/testcase5.fds";
		file_names[5] = "./testcases/legacy/testcase6.fds";
		file_names[6] = "./testcases/legacy/testcase7.fds";
		file_names[7] = "./testcases/legacy/testcase8.fds";
		for (int i = 0; i < file_names.length; i++) {
			test_main(file_names[i]);
			Env.resetEnv();
		}
	}

	public static void test_main(String args) {
		String file_name;
		file_name = args;
		
		try {
			Env.loadModule(file_name);
			FDSModule player1 = (FDSModule) Env.getModule("sys");
			FDSModule player2 = (FDSModule) Env.getModule("env");

			System.out.print("=============================================\n");
			System.out.println(player1);
			System.out.print("=============================================\n");
			System.out.println(player2);
			System.out.print("=============================================\n");
			System.out.println("");

			BDD step0 = player2.initial();
			BDD step1 = player2.succ(step0);
			BDD step2 = player2.succ(step1);
			BDD step3 = player2.succ(step2);
			BDD step4 = player2.succ(step3);
			BDD pred3 = player2.succ(step4);
			BDD pred2 = player2.succ(pred3);
			BDD pred1 = player2.succ(pred2);
			BDD pred0 = player2.succ(pred1);
			System.out.println(Env.toNiceString(null, step0));
			System.out.println(Env.toNiceString(null, step1));
			System.out.println(Env.toNiceString(null, step2));
			System.out.println(Env.toNiceString(null, step3));
			System.out.println(Env.toNiceString(null, step4));
			System.out.println(Env.toNiceString(null, pred3));
			System.out.println(Env.toNiceString(null, pred2));
			System.out.println(Env.toNiceString(null, pred1));
			System.out.println(Env.toNiceString(null, pred0));
		} catch (IOException e) {
			// error with reading the file.
			e.printStackTrace();
			System.exit(0);
		}
	}
}
