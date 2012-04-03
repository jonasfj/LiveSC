import java.io.IOException;

import net.sf.javabdd.BDD;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.lib.AlgRunnerThread;
import edu.wis.jtlv.lib.mc.SimpleDeadlockAlg;
import edu.wis.jtlv.lib.mc.SimpleInvarianceAlg;
import edu.wis.jtlv.lib.mc.SimpleTempEntailAlg;
import edu.wis.jtlv.lib.mc.tl.CTLModelCheckAlg;
import edu.wis.jtlv.lib.mc.tl.LTLModelCheckAlg;
import edu.wis.jtlv.lib.mc.tl.LTLValidAlg;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class AlgorithmRunnerMain {
	
	public static void main(String[] args) throws IOException {
		simpleCheckDeadlock();
		Env.resetEnv();
		simpleCheckInvariance();
		Env.resetEnv();
		simpleCheckTempEntail();
		Env.resetEnv();
		simpleCheckReact();
		Env.resetEnv();
		ltlCheck();
		Env.resetEnv();
		ctlCheck();
		System.out.println("DONE");
	}

	public static void simpleCheckDeadlock() throws IOException {
		// System.setProperty("bdd", "buddy");
		SMVModule.initModulesWithoutRunningVar();
		Env.loadModule("testcases/mux-sem.smv");
		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		for (SMVModule m : main.getAllInstances()) {
			m.setFullPrintingMode(true);
		}
		System.out.println("========= DONE Loading Modules ==========");

		AlgRunnerThread runner;
		// ///////////////////////////////////////
		// deadlock test 1 ///////////////////////
		System.out.println("-- Module muxsem with initials.");
		runner = new AlgRunnerThread(new SimpleDeadlockAlg(main));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ///////////////////////////////////////

		// // ///////////////////////////////////////
		// // deadlock test 2 - removing initials ///
		BDD old_initials = null;
		BDD[] old_sub_initials = new BDD[main.getAllInstances().length];
		try {
			old_initials = main.initial().id();
			main.setInitial(Env.TRUE());
			SMVModule[] sub = main.getAllInstances();
			for (int i = 0; i < sub.length; i++) {
				old_sub_initials[i] = sub[i].initial().id();
				sub[i].setInitial(Env.TRUE());
			}
		} catch (ModuleException e) {
		}

		System.out.println("-- Module muxsem without initials.");
		runner = new AlgRunnerThread(new SimpleDeadlockAlg(main));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());

		// returning the initials.
		try {
			main.setInitial(old_initials);
			SMVModule[] sub = main.getAllInstances();
			for (int i = 0; i < sub.length; i++)
				sub[i].setInitial(old_sub_initials[i]);
		} catch (ModuleException e) {
		}

	}

	public static void simpleCheckInvariance() throws IOException {
		// System.setProperty("bdd", "buddy");
		SMVModule.initModulesWithoutRunningVar();
		Env.loadModule("testcases/mux-sem.smv");
		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		for (SMVModule m : main.getAllInstances()) {
			m.setFullPrintingMode(true);
		}
		System.out.println("========= DONE Loading Modules ==========");
		// ///////////////////////////////////////

		// ///////////////////////////////////////
		// invariance tests //////////////////////
		System.out.println("========= Loading Specs =================");
		String to_parse = "";
		to_parse += "SPEC\n" + " !((proc[1].loc = 3) & (proc[2].loc = 3)) \n"; // 0
		to_parse += "SPEC\n" + " !((proc[1].loc = 3) & (proc[2].loc = 2)) \n"; // 1
		Spec[] all_specs = Env.loadSpecString(to_parse);
		System.out.println("========= DONE Loading Specs ============");

		AlgRunnerThread runner;
		// ///////////////////////////////////////
		runner = new AlgRunnerThread(
				new SimpleInvarianceAlg(main, all_specs[0]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());

		// ///////////////////////////////////////
		runner = new AlgRunnerThread(
				new SimpleInvarianceAlg(main, all_specs[1]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ///////////////////////////////////////
	}

	public static void simpleCheckTempEntail() throws IOException {
		// System.setProperty("bdd", "buddy");
		SMVModule.initModulesWithoutRunningVar();
		Env.loadModule("testcases/simple_mc.smv");
		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		for (SMVModule m : main.getAllInstances()) {
			m.setFullPrintingMode(true);
		}
		System.out.println("========= DONE Loading Modules ==========");

		AlgRunnerThread runner;
		// ///////////////////////////////////////
		// ///////////////////////////////////////
		// tempEntail tests //////////////////////

		String to_parse = "";
		to_parse += "LTLSPEC\n" + "[](aa -> <> aa)\n";
		to_parse += "SPEC\n" + "aa\n";
		to_parse += "LTLSPEC\n" + "[](aa -> <> bb)\n";
		to_parse += "SPEC\n" + "bb\n";
		to_parse += "LTLSPEC\n" + "[](aa -> <> !bb)\n";
		to_parse += "SPEC\n" + "!bb\n";
		to_parse += "LTLSPEC\n" + "[](aa -> <> ((!bb) & cc))\n";
		to_parse += "SPEC\n" + "((!bb) & cc)\n";

		Spec[] all_specs = Env.loadSpecString(to_parse);
		System.out.println("========= DONE Loading Specs ============");

		// ///////////////////////////////////////
		runner = new AlgRunnerThread(new LTLModelCheckAlg(main, all_specs[0]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ltl_checker.modelCheckStandardOutput(all_specs[0]);
		runner = new AlgRunnerThread(new SimpleTempEntailAlg(main,
				all_specs[1], all_specs[1]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ///////////////////////////////////////
		runner = new AlgRunnerThread(new LTLModelCheckAlg(main, all_specs[2]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ltl_checker.modelCheckStandardOutput(all_specs[2]);
		runner = new AlgRunnerThread(new SimpleTempEntailAlg(main,
				all_specs[1], all_specs[3]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ///////////////////////////////////////
		runner = new AlgRunnerThread(new LTLModelCheckAlg(main, all_specs[4]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ltl_checker.modelCheckStandardOutput(all_specs[4]);
		runner = new AlgRunnerThread(new SimpleTempEntailAlg(main,
				all_specs[1], all_specs[5]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ///////////////////////////////////////
		runner = new AlgRunnerThread(new LTLModelCheckAlg(main, all_specs[6]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ltl_checker.modelCheckStandardOutput(all_specs[6]);
		runner = new AlgRunnerThread(new SimpleTempEntailAlg(main,
				all_specs[1], all_specs[7]));
		runner.runSequential();
		if (runner.getDoResult() != null)
			System.out.println(runner.getDoResult().resultString());
		if (runner.getDoException() != null)
			System.err.println(runner.getDoException().getMessage());
		// ///////////////////////////////////////
	}

	public static void simpleCheckReact() throws IOException {
		// System.setProperty("bdd", "buddy");
		SMVModule.initModulesWithoutRunningVar();
		Env.loadModule("testcases/simple_mc.smv");
		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		for (SMVModule m : main.getAllInstances()) {
			m.setFullPrintingMode(true);
		}
		System.out.println("========= DONE Loading Modules ==========");

		// SimpleModelChecker checker;
		// try {
		// checker = new SimpleModelChecker(main, true);
		// } catch (ModelCheckException e) {
		// e.printStackTrace();
		// return;
		// }
	}

	public static void ctlCheck() throws IOException {
		// System.setProperty("bdd", "buddy");
		Env.loadModule("testcases/simple_mc.smv");
		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		System.out.println("========= DONE Loading Modules ==========");

		String to_parse = "";
		to_parse += "SPEC\n" + "AF aa -> EF aa\n"; // 0
		to_parse += "SPEC\n" + "(AF (EG aa)) -> EG aa\n"; // 1
		to_parse += "SPEC\n" + "EG aa -> (EX aa & EF aa)\n"; // 2
		to_parse += "SPEC\n" + "EF aa\n"; // 3
		to_parse += "SPEC\n" + "(EG aa & AX aa) -> (EF !aa)\n"; // 4
		to_parse += "SPEC\n" + "AF bb -> EF bb\n"; // 5
		to_parse += "SPEC\n" + "EG bb -> (EX bb & EF bb)\n"; // 6
		to_parse += "SPEC\n" + "EF bb -> AF bb\n"; // 7
		to_parse += "SPEC\n" + "EF bb\n"; // 8
		to_parse += "SPEC\n" + "(EG bb & AX bb) -> (EF !bb)\n"; // 9
		to_parse += "SPEC\n" + "AF cc -> EF cc\n"; // 10
		to_parse += "SPEC\n" + "(AF (EG cc)) -> EG cc\n"; // 11
		to_parse += "SPEC\n" + "EG cc -> (EX cc & EF cc)\n"; // 12
		to_parse += "SPEC\n" + "EF cc -> AF cc\n"; // 13
		to_parse += "SPEC\n" + "EF cc\n"; // 14
		to_parse += "SPEC\n" + "(EG cc & AX cc) -> (EF !cc)\n"; // 15
		to_parse += "SPEC\n" + "EF EG bb\n"; // 16
		to_parse += "SPEC\n" + "EF EG !bb\n"; // 17 fails
		to_parse += "SPEC\n" + "EF aa -> AF aa\n"; // 18 fails
		to_parse += "SPEC\n" + "(AF (EG bb)) -> EG bb\n"; // 19 fails
		to_parse += "SPEC\n" + "EF AG !bb\n"; // 20 fails
		to_parse += "SPEC\n" + "EF AG bb\n"; // 21 fails

		Spec[] all_specs = Env.loadSpecString(to_parse);
		System.out.println("========= DONE Loading Specs ============");

		AlgRunnerThread runner;
		// ///////////////////////////////////////
		// model checking a module
		for (int i = 0; i < all_specs.length; i++) {
			// 17, 18, 19, 20, and 21 fails.
			runner = new AlgRunnerThread(new CTLModelCheckAlg(main,
					all_specs[i]));
			runner.runSequential();
			if (runner.getDoResult() != null)
				System.out.println(runner.getDoResult().resultString());
			if (runner.getDoException() != null)
				System.err.println(runner.getDoException().getMessage());

		}
		// ///////////////////////////////////////
	}

	public static void ltlCheck() throws IOException {
		// System.setProperty("bdd", "buddy");
		Env.loadModule("testcases/simple_mc.smv");
		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		System.out.println("========= DONE Loading Modules ==========");

		String to_parse = "";
		to_parse += "LTLSPEC\n" + "GLOBALLY aa -> FINALLY aa\n";
		to_parse += "LTLSPEC\n" + "([](aa -> ()aa)) -> (<>aa -> <>[]aa)\n";
		to_parse += "LTLSPEC\n" + "[] aa -> () aa\n";
		to_parse += "LTLSPEC\n" + "[] aa -> <> aa\n";
		to_parse += "LTLSPEC\n" + "[] aa\n"; // failure 1
		to_parse += "LTLSPEC\n" + "<>[] aa\n"; // failure 2
		to_parse += "LTLSPEC\n" + "<> aa -> [] aa\n"; // failure 3
		to_parse += "LTLSPEC\n([](aa -> ()aa))->(<>aa -> []aa)\n"; // failure

		Spec[] all_specs = Env.loadSpecString(to_parse);
		System.out.println("========= DONE Loading Specs ============");

		AlgRunnerThread runner;
		// ///////////////////////////////////////
		for (int i = 0; i < all_specs.length; i++) {
			// 4, 5, 6, and 7 fails.
			runner = new AlgRunnerThread(new LTLValidAlg(all_specs[i]));
			runner.runSequential();
			if (runner.getDoResult() != null)
				System.out.println(runner.getDoResult().resultString());
			if (runner.getDoException() != null)
				System.err.println(runner.getDoException().getMessage());

		}
		// ///////////////////////////////////////

		// ///////////////////////////////////////
		// checking valid with a module
		for (int i = 0; i < all_specs.length; i++) {
			// 4, 5, 6, and 7 fails.
			runner = new AlgRunnerThread(new LTLValidAlg(main, all_specs[i]));
			runner.runSequential();
			if (runner.getDoResult() != null)
				System.out.println(runner.getDoResult().resultString());
			if (runner.getDoException() != null)
				System.err.println(runner.getDoException().getMessage());

		}
		// ///////////////////////////////////////

		// ///////////////////////////////////////
		// checking valid with a module
		for (int i = 0; i < all_specs.length; i++) {
			// 4, 5, 6, and 7 fails.
			runner = new AlgRunnerThread(new LTLModelCheckAlg(main,
					all_specs[i]));
			runner.runSequential();
			if (runner.getDoResult() != null)
				System.out.println(runner.getDoResult().resultString());
			if (runner.getDoException() != null)
				System.err.println(runner.getDoException().getMessage());

		}
		// ///////////////////////////////////////
	}

}
