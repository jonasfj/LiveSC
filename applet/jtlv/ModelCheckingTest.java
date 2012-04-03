import java.io.IOException;

import net.sf.javabdd.BDD;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.old_lib.mc.CTLModelChecker;
import edu.wis.jtlv.old_lib.mc.LTLModelChecker;
import edu.wis.jtlv.old_lib.mc.ModelCheckException;
import edu.wis.jtlv.old_lib.mc.SimpleModelChecker;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 *
 */
public class ModelCheckingTest {
	public static void main(String[] args) {
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

	public static void simpleCheckDeadlock() {
		// System.setProperty("bdd", "buddy");
		try {
			SMVModule.initModulesWithoutRunningVar();
			Env.loadModule("testcases/mux-sem.smv");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		for (SMVModule m : main.getAllInstances()) {
			m.setFullPrintingMode(true);
		}
		System.out.println("========= DONE Loading Modules ==========");

		SimpleModelChecker checker;
		try {
			checker = new SimpleModelChecker(main, true);
		} catch (ModelCheckException e) {
			e.printStackTrace();
			return;
		}

		// ///////////////////////////////////////
		// deadlock test 1 ///////////////////////
		System.out.println("-- Module muxsem with initials.");
		checker.checkDeadlockStrandardOutput();
		// ///////////////////////////////////////

		// ///////////////////////////////////////
		// deadlock test 2 - removing initials ///
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
		checker.checkDeadlockStrandardOutput();
		// returning the initials.
		try {
			main.setInitial(old_initials);
			SMVModule[] sub = main.getAllInstances();
			for (int i = 0; i < sub.length; i++)
				sub[i].setInitial(old_sub_initials[i]);
		} catch (ModuleException e) {
		}

	}

	public static void simpleCheckInvariance() {
		// System.setProperty("bdd", "buddy");
		try {
			SMVModule.initModulesWithoutRunningVar();
			Env.loadModule("testcases/mux-sem.smv");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		for (SMVModule m : main.getAllInstances()) {
			m.setFullPrintingMode(true);
		}
		System.out.println("========= DONE Loading Modules ==========");
		// ///////////////////////////////////////

		SimpleModelChecker checker;
		try {
			checker = new SimpleModelChecker(main, true);
		} catch (ModelCheckException e) {
			e.printStackTrace();
			return;
		}

		// ///////////////////////////////////////
		// invariance tests //////////////////////
		System.out.println("========= Loading Specs =================");
		String to_parse = "";
		to_parse += "SPEC\n" + " !((proc[1].loc = 3) & (proc[2].loc = 3)) \n"; // 0
		to_parse += "SPEC\n" + " !((proc[1].loc = 3) & (proc[2].loc = 2)) \n"; // 1
		Spec[] all_specs = Env.loadSpecString(to_parse);
		System.out.println("========= DONE Loading Specs ============");

		checker.checkInvarianceStrandardOutput(all_specs[0]);
		checker.checkInvarianceStrandardOutput(all_specs[1]);
		// ///////////////////////////////////////

	}

	public static void simpleCheckTempEntail() {
		// System.setProperty("bdd", "buddy");
		try {
			SMVModule.initModulesWithoutRunningVar();
			Env.loadModule("testcases/simple_mc.smv");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		SMVModule main = (SMVModule) Env.getModule("main");
		main.setFullPrintingMode(true);
		for (SMVModule m : main.getAllInstances()) {
			m.setFullPrintingMode(true);
		}
		System.out.println("========= DONE Loading Modules ==========");

		SimpleModelChecker checker;
		LTLModelChecker ltl_checker;
		try {
			checker = new SimpleModelChecker(main, true);
			ltl_checker = new LTLModelChecker(main, true);
		} catch (ModelCheckException e) {
			e.printStackTrace();
			return;
		}

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

		ltl_checker.modelCheckStandardOutput(all_specs[0]);
		checker.checkTempEntailStrandardOutput(all_specs[1], all_specs[1]);
		ltl_checker.modelCheckStandardOutput(all_specs[2]);
		checker.checkTempEntailStrandardOutput(all_specs[1], all_specs[3]);
		ltl_checker.modelCheckStandardOutput(all_specs[4]);
		checker.checkTempEntailStrandardOutput(all_specs[1], all_specs[5]);
		ltl_checker.modelCheckStandardOutput(all_specs[6]);
		checker.checkTempEntailStrandardOutput(all_specs[1], all_specs[7]);
		// ///////////////////////////////////////
	}

	public static void simpleCheckReact() {
		// System.setProperty("bdd", "buddy");
		try {
			SMVModule.initModulesWithoutRunningVar();
			Env.loadModule("testcases/simple_mc.smv");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

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

	public static void ctlCheck() {
		// System.setProperty("bdd", "buddy");
		try {
			Env.loadModule("testcases/simple_mc.smv");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
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

		CTLModelChecker checker;
		try {
			checker = new CTLModelChecker(main, true);
		} catch (ModelCheckException e) {
			e.printStackTrace();
			return;
		}
		// model checking a module
		checker.modelCheckStandardOutput(all_specs[0]);
		checker.modelCheckStandardOutput(all_specs[1]);
		checker.modelCheckStandardOutput(all_specs[2]);
		checker.modelCheckStandardOutput(all_specs[3]);
		checker.modelCheckStandardOutput(all_specs[4]);
		checker.modelCheckStandardOutput(all_specs[5]);
		checker.modelCheckStandardOutput(all_specs[6]);
		checker.modelCheckStandardOutput(all_specs[7]);
		checker.modelCheckStandardOutput(all_specs[8]);
		checker.modelCheckStandardOutput(all_specs[9]);
		checker.modelCheckStandardOutput(all_specs[10]);
		checker.modelCheckStandardOutput(all_specs[11]);
		checker.modelCheckStandardOutput(all_specs[12]);
		checker.modelCheckStandardOutput(all_specs[13]);
		checker.modelCheckStandardOutput(all_specs[14]);
		checker.modelCheckStandardOutput(all_specs[15]);
		checker.modelCheckStandardOutput(all_specs[16]);
		checker.modelCheckStandardOutput(all_specs[17]); // fails
		checker.modelCheckStandardOutput(all_specs[18]); // fails
		checker.modelCheckStandardOutput(all_specs[19]); // fails
		checker.modelCheckStandardOutput(all_specs[20]); // fails
		checker.modelCheckStandardOutput(all_specs[21]); // fails
	}

	public static void ltlCheck() {
		// System.setProperty("bdd", "buddy");
		try {
			Env.loadModule("testcases/simple_mc.smv");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
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

		LTLModelChecker checker;
		// checking valid without a module
		LTLModelChecker.standAloneValidStarndardOutput(all_specs[0]);
		LTLModelChecker.standAloneValidStarndardOutput(all_specs[1]);
		LTLModelChecker.standAloneValidStarndardOutput(all_specs[2]);
		LTLModelChecker.standAloneValidStarndardOutput(all_specs[3]);
		LTLModelChecker.standAloneValidStarndardOutput(all_specs[4]); // failure 1
		LTLModelChecker.standAloneValidStarndardOutput(all_specs[5]); // failure 2
		LTLModelChecker.standAloneValidStarndardOutput(all_specs[6]); // failure 3
		LTLModelChecker.standAloneValidStarndardOutput(all_specs[7]); // failure 4
		try {
			checker = new LTLModelChecker(main, true);
		} catch (ModelCheckException e) {
			e.printStackTrace();
			return;
		}
		// checking valid with a module
		checker.validStarndardOutput(all_specs[0]);
		checker.validStarndardOutput(all_specs[1]);
		checker.validStarndardOutput(all_specs[2]);
		checker.validStarndardOutput(all_specs[3]);
		checker.validStarndardOutput(all_specs[4]); // failure 1
		checker.validStarndardOutput(all_specs[5]); // failure 2
		checker.validStarndardOutput(all_specs[6]); // failure 3
		checker.validStarndardOutput(all_specs[7]); // failure 4
		// model checking a module
		checker.modelCheckStandardOutput(all_specs[0]);
		checker.modelCheckStandardOutput(all_specs[1]);
		checker.modelCheckStandardOutput(all_specs[2]);
		checker.modelCheckStandardOutput(all_specs[3]);
		checker.modelCheckStandardOutput(all_specs[4]); // failure 1
		checker.modelCheckStandardOutput(all_specs[5]); // failure 2
		checker.modelCheckStandardOutput(all_specs[6]); // failure 3
		checker.modelCheckStandardOutput(all_specs[7]); // failure 4
	}

}
