import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import edu.wis.jtlv.env.Env;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class FileConstructionTest {
	/**
	 * main run for the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("bdd", "java");
		String file_name;
		String[] all_test_names = get_all_test_files();
		file_name = all_test_names[80];

		try {

			// SMVModule.debug_parse_tree = true;
			Env.loadModule(file_name);
			Set<String> all = Env.getModuleNames();
			for (Iterator<String> iter_names = all.iterator(); iter_names
					.hasNext();) {
				String key = iter_names.next();
				System.out
						.println("=============================================");
				System.out.println(Env.getModule(key));
				System.out
						.println("=============================================");

			}
			// System.out.println(Env.get_var("main.pr0", "state0").toBDD());
			// System.out.println(Env.get_var("main", "s0").toBDD());
			// System.out.println(Env.get_var("main.pr0", "state1").toBDD());
			// System.out.println(Env.get_var("main", "s1").toBDD());
			// System.out.println(Env.get_var("main.pr0", "turn").toBDD());
			// System.out.println(Env.get_var("main", "turn").toBDD());
			// System.out.println(Env.get_var("main.pr0", "turn0").toBDD());
			// System.out.println(Env.get_var("main", "s0").toBDD());

			// System.out.println(Env.get_var("main.pr0", "s0"));

			// BDD dom = Env.get_var("main", "rr").getDomain().varRange(3, 5);
			// System.out.println(dom.toStringWithDomains(Env.stringer));
			// dom.printSetWithDomains();

			// BigInteger val = Env.TRUE().scanVar(Env.get_var("main",
			// "rr").getDomain());
			// System.out.println(val + "\n\n\n");
			//			
			// BDD three = Env.get_var("main", "rr").getDomain().ithVar(3);
			// BDD four = Env.get_var("main", "rr").getDomain().ithVar(4);
			// BDD five = Env.get_var("main", "rr").getDomain().ithVar(5);
			// BDD six = Env.get_var("main", "rr").getDomain().ithVar(6);
			// BDD four_and_five = four.or(five);
			// BDD three_and_six = six.or(three);
			// BDD all_n = four_and_five.or(three_and_six);
			// System.out.println(three.toStringWithDomains(Env.stringer));
			// System.out.println(four.toStringWithDomains(Env.stringer));
			// System.out.println(five.toStringWithDomains(Env.stringer));
			// System.out.println(six.toStringWithDomains(Env.stringer));
			// System.out.println(four_and_five.toStringWithDomains(Env.stringer));
			// System.out.println(three_and_six.toStringWithDomains(Env.stringer));
			// System.out.println(all_n.toStringWithDomains(Env.stringer));
			//			
			// BDD v0 = Env.get_var("main.s2r_in", "tag").getDomain().ithVar(0);
			// BDD v1 = Env.get_var("main.s2r_in", "tag").getDomain().ithVar(1);
			// BDD v2 = Env.get_var("main.s2r_in", "tag").getDomain().ithVar(2);
			// BDD v3 = Env.get_var("main.s2r_in", "tag").getDomain().ithVar(3);
			// System.out.println(v0.toStringWithDomains(Env.stringer));
			// System.out.println(v1.toStringWithDomains(Env.stringer));
			// System.out.println(v2.toStringWithDomains(Env.stringer));
			// System.out.println(v3.toStringWithDomains(Env.stringer));
			// BDD v01 = v0.or(v1);
			// BDD v23 = v2.or(v3);
			// BDD v03 = v0.or(v3);
			// BDD v023 = v0.or(v2).or(v3);
			// System.out.println(v01.toStringWithDomains(Env.stringer));
			// System.out.println(v23.toStringWithDomains(Env.stringer));
			// System.out.println(v03.toStringWithDomains(Env.stringer));
			// System.out.println(v023.toStringWithDomains(Env.stringer));
			//			
			// BDD w0 = Env.get_var("main", "w").getDomain().ithVar(0);
			// BDD w1 = Env.get_var("main", "w").getDomain().ithVar(96);
			// BDD w2 = Env.get_var("main", "w").getDomain().ithVar(2);
			// BDD w3 = Env.get_var("main", "w").getDomain().ithVar(255);
			// System.out.println(w0.toStringWithDomains(Env.stringer));
			// System.out.println(w1.toStringWithDomains(Env.stringer));
			// System.out.println(w2.toStringWithDomains(Env.stringer));
			// System.out.println(w3.toStringWithDomains(Env.stringer));
			// BDD w01 = w0.or(w1);
			// BDD w23 = w2.or(w3);
			// BDD w03 = w0.or(w3);
			// BDD w023 = w0.or(w2).or(w3);
			// System.out.println(w01.toStringWithDomains(Env.stringer));
			// System.out.println(w23.toStringWithDomains(Env.stringer));
			// System.out.println(w03.toStringWithDomains(Env.stringer));
			// System.out.println(w023.toStringWithDomains(Env.stringer));
			//			
		} catch (IOException e) {
			// error with reading the file.
			Env.doError(e, e.toString());
			System.exit(0);
		}
	}

	public static String[] get_all_test_files() {
		// file_name = "testcases/legacy/abp/abp10.smv";
		// file_name = "testcases/legacy/abp/abp11.smv";
		// file_name = "testcases/legacy/bmc/counter.smv";
		// file_name = "testcases/legacy/bmc/multiplier.smv";
		// file_name = "testcases/legacy/brp/brp.smv";
		// file_name = "testcases/legacy/deadlock/dartes.smv";
		// file_name = "testcases/legacy/deadlock/ftp3.smv";
		// file_name = "testcases/legacy/example_cmu/gigamax.smv";
		// file_name = "testcases/legacy/example_cmu/ring.smv";
		// file_name = "testcases/legacy/queue/queue.smv";

		String[] file_names = new String[165];
		// file_names[0] = "testcases/legacy/abcd/abcd10.smv";
		// file_names[1] = "testcases/legacy/abcd/abcd12.smv";
		// file_names[2] = "testcases/legacy/abcd/abcd14.smv";
		// file_names[3] = "testcases/legacy/abcd/abcd16.smv";
		// file_names[4] = "testcases/legacy/abcd/abcd18.smv";
		// file_names[5] = "testcases/legacy/abcd/abcd20.smv";
		// file_names[6] = "testcases/legacy/abcd/abcd22.smv";
		// file_names[7] = "testcases/legacy/abcd/abcd24.smv";
		// file_names[8] = "testcases/legacy/abcd/abcd26.smv";
		// file_names[9] = "testcases/legacy/abcd/abcd28.smv";
		// file_names[10] = "testcases/legacy/abcd/abcd30.smv";
		// file_names[11] = "testcases/legacy/abcd/abcd32.smv";
		// file_names[12] = "testcases/legacy/abcd/abcd34.smv";
		// file_names[13] = "testcases/legacy/abcd/abcd36.smv";
		// file_names[14] = "testcases/legacy/abcd/abcd38.smv";
		// file_names[15] = "testcases/legacy/abcd/abcd4.smv";
		// file_names[16] = "testcases/legacy/abcd/abcd40.smv";
		// file_names[17] = "testcases/legacy/abcd/abcd42.smv";
		// file_names[18] = "testcases/legacy/abcd/abcd44.smv";
		// file_names[19] = "testcases/legacy/abcd/abcd46.smv";
		// file_names[20] = "testcases/legacy/abcd/abcd48.smv";
		// file_names[21] = "testcases/legacy/abcd/abcd50.smv";
		// file_names[22] = "testcases/legacy/abcd/abcd52.smv";
		// file_names[23] = "testcases/legacy/abcd/abcd54.smv";
		// file_names[24] = "testcases/legacy/abcd/abcd56.smv";
		// file_names[25] = "testcases/legacy/abcd/abcd58.smv";
		// file_names[26] = "testcases/legacy/abcd/abcd6.smv";
		// file_names[27] = "testcases/legacy/abcd/abcd60.smv";
		// file_names[28] = "testcases/legacy/abcd/abcd62.smv";
		// file_names[29] = "testcases/legacy/abcd/abcd64.smv";
		// file_names[30] = "testcases/legacy/abcd/abcd8.smv";
		// file_names[31] = "testcases/legacy/abcd/abcdN.smv";
		file_names[32] = "testcases/legacy/abp/abp10.smv";
		file_names[33] = "testcases/legacy/abp/abp11.smv";
		file_names[34] = "testcases/legacy/abp/abp16.smv";
		file_names[35] = "testcases/legacy/abp/abp4.smv";
		file_names[36] = "testcases/legacy/abp/abp8.smv";
		file_names[37] = "testcases/legacy/bmc/MCP.smv";
		file_names[38] = "testcases/legacy/bmc/barrel5.smv";
		file_names[39] = "testcases/legacy/bmc/counter.smv";
		file_names[40] = "testcases/legacy/bmc/dme/dme10.smv";
		file_names[41] = "testcases/legacy/bmc/dme/dme11.smv";
		file_names[42] = "testcases/legacy/bmc/dme/dme12.smv";
		file_names[43] = "testcases/legacy/bmc/dme/dme13.smv";
		file_names[44] = "testcases/legacy/bmc/dme/dme14.smv";
		file_names[45] = "testcases/legacy/bmc/dme/dme15.smv";
		file_names[46] = "testcases/legacy/bmc/dme/dme16.smv";
		file_names[47] = "testcases/legacy/bmc/dme/dme17.smv";
		file_names[48] = "testcases/legacy/bmc/dme/dme18.smv";
		file_names[49] = "testcases/legacy/bmc/dme/dme19.smv";
		file_names[50] = "testcases/legacy/bmc/dme/dme20.smv";
		file_names[51] = "testcases/legacy/bmc/dme/dme30.smv";
		file_names[52] = "testcases/legacy/bmc/dme/dme4.smv";
		file_names[53] = "testcases/legacy/bmc/dme/dme40.smv";
		file_names[54] = "testcases/legacy/bmc/dme/dme5.smv";
		file_names[55] = "testcases/legacy/bmc/dme/dme50.smv";
		file_names[56] = "testcases/legacy/bmc/dme/dme6.smv";
		file_names[57] = "testcases/legacy/bmc/dme/dme7.smv";
		file_names[58] = "testcases/legacy/bmc/dme/dme8.smv";
		file_names[59] = "testcases/legacy/bmc/dme/dme9.smv";
		file_names[60] = "testcases/legacy/bmc/multiplier.smv";
		file_names[61] = "testcases/legacy/bmc_tutorial/bmc_tutorial.smv";
		file_names[62] = "testcases/legacy/brp/brp.smv";
		// file_names[63] = "testcases/legacy/calculator/calculator12.smv";
		// file_names[64] = "testcases/legacy/calculator/calculator16.smv";
		// file_names[65] = "testcases/legacy/calculator/calculator20.smv";
		// file_names[66] = "testcases/legacy/calculator/calculator24.smv";
		// file_names[67] = "testcases/legacy/calculator/calculator28.smv";
		// file_names[68] = "testcases/legacy/calculator/calculator32.smv";
		// file_names[69] = "testcases/legacy/calculator/calculator36.smv";
		// file_names[70] = "testcases/legacy/calculator/calculator40.smv";
		// file_names[71] = "testcases/legacy/calculator/calculator44.smv";
		// file_names[72] = "testcases/legacy/calculator/calculator48.smv";
		// file_names[73] = "testcases/legacy/calculator/calculator52.smv";
		// file_names[74] = "testcases/legacy/calculator/calculator56.smv";
		// file_names[75] = "testcases/legacy/calculator/calculator60.smv";
		// file_names[76] = "testcases/legacy/calculator/calculator64.smv";
		// file_names[77] = "testcases/legacy/calculator/calculatorN.smv";
		file_names[78] = "testcases/legacy/ctl-ltl/abp4.smv";
		file_names[79] = "testcases/legacy/ctl-ltl/abp8.smv";
		file_names[80] = "testcases/legacy/ctl-ltl/counter.smv";
		file_names[81] = "testcases/legacy/ctl-ltl/dme2.smv";
		file_names[82] = "testcases/legacy/ctl-ltl/guidance.smv";
		file_names[83] = "testcases/legacy/ctl-ltl/mutex.smv";
		file_names[84] = "testcases/legacy/ctl-ltl/mutex1.smv";
		file_names[85] = "testcases/legacy/ctl-ltl/p-queue.smv";
		file_names[86] = "testcases/legacy/ctl-ltl/periodic.smv";
		file_names[87] = "testcases/legacy/ctl-ltl/prod-cons.smv";
		file_names[88] = "testcases/legacy/ctl-ltl/production-cell.smv";
		file_names[89] = "testcases/legacy/ctl-ltl/queue.smv";
		file_names[90] = "testcases/legacy/ctl-ltl/ring.smv";
		file_names[91] = "testcases/legacy/ctl-ltl/semaphore.smv";
		file_names[92] = "testcases/legacy/ctl-ltl/short.smv";
		file_names[93] = "testcases/legacy/ctl-ltl/syncarb5.smv";
		file_names[94] = "testcases/legacy/deadlock/dartes.smv";
		file_names[95] = "testcases/legacy/deadlock/dpd75.smv";
		file_names[96] = "testcases/legacy/deadlock/dph35.smv";
		file_names[97] = "testcases/legacy/deadlock/ftp3.smv";
		file_names[98] = "testcases/legacy/deadlock/furnace17.smv";
		file_names[99] = "testcases/legacy/deadlock/gas-nq7.smv";
		file_names[100] = "testcases/legacy/deadlock/key10.smv";
		file_names[101] = "testcases/legacy/deadlock/mmgt20.smv";
		file_names[102] = "testcases/legacy/deadlock/over12.smv";
		file_names[103] = "testcases/legacy/example_cmu/counter.smv";
		file_names[104] = "testcases/legacy/example_cmu/dme1.smv";
		file_names[105] = "testcases/legacy/example_cmu/dme2.smv";
		file_names[106] = "testcases/legacy/example_cmu/gigamax.smv";
		file_names[107] = "testcases/legacy/example_cmu/mutex.smv";
		file_names[108] = "testcases/legacy/example_cmu/mutex1.smv";
		file_names[109] = "testcases/legacy/example_cmu/periodic.smv";
		file_names[110] = "testcases/legacy/example_cmu/ring.smv";
		file_names[111] = "testcases/legacy/example_cmu/semaphore.smv";
		file_names[112] = "testcases/legacy/example_cmu/short.smv";
		file_names[113] = "testcases/legacy/example_cmu/syncarb5.smv";
		file_names[114] = "testcases/legacy/example_irst/dme4.smv";
		file_names[115] = "testcases/legacy/example_irst/dme5.smv";
		file_names[116] = "testcases/legacy/example_irst/dme6.smv";
		// file_names[117] =
		file_names[118] = "testcases/legacy/example_irst/gigamax.smv";
		file_names[119] = "testcases/legacy/example_irst/gigamax_ltl.smv";
		file_names[120] = "testcases/legacy/example_irst/periodic.smv";
		file_names[121] = "testcases/legacy/guidance/guidance.smv";
		file_names[122] = "testcases/legacy/m4/modcounter.m4.smv";
		file_names[123] = "testcases/legacy/m4/non_selective.m4.smv";
		file_names[124] = "testcases/legacy/msi/msi_wtrans.smv";
		file_names[125] = "testcases/legacy/mutex1.smv";
		// file_names[126] = "testcases/legacy/p-queue/p-queue.ordnusmv";
		file_names[127] = "testcases/legacy/p-queue/p-queue.smv";
		file_names[128] = "testcases/legacy/pci/pci.smv";
		// file_names[129] = "testcases/legacy/pci/pci.smv".varord;
		// file_names[130] = "testcases/legacy/prod-cons/prod-cons.ordnusmv";
		file_names[131] = "testcases/legacy/prod-cons/prod-cons.smv";
		// file_names[132] =
		// "testcases/legacy/production-cell/production-cell.ordnusmv";
		file_names[133] = "testcases/legacy/production-cell/production-cell.smv";
		file_names[134] = "testcases/legacy/psl-samples/counter.smv";
		file_names[135] = "testcases/legacy/psl-samples/dme2-16.smv";
		file_names[136] = "testcases/legacy/psl-samples/dme2.smv";
		file_names[137] = "testcases/legacy/psl-samples/gigamax.smv";
		file_names[138] = "testcases/legacy/psl-samples/ring.smv";
		file_names[139] = "testcases/legacy/psl-samples/semaphore.smv";
		file_names[140] = "testcases/legacy/psl-samples/short.smv";
		file_names[141] = "testcases/legacy/psl-samples/syncarb10.smv";
		file_names[142] = "testcases/legacy/psl-samples/syncarb5.smv";
		file_names[143] = "testcases/legacy/queue/queue.smv";
		file_names[144] = "testcases/legacy/reactor/base.smv";
		file_names[145] = "testcases/legacy/reactor/idle.smv";
		file_names[146] = "testcases/legacy/smv-dist/counter.smv";
		file_names[147] = "testcases/legacy/smv-dist/dme1-16.smv";
		file_names[148] = "testcases/legacy/smv-dist/dme1.smv";
		file_names[149] = "testcases/legacy/smv-dist/dme2-16.smv";
		file_names[150] = "testcases/legacy/smv-dist/dme2.smv";
		file_names[151] = "testcases/legacy/smv-dist/gigamax.smv";
		file_names[152] = "testcases/legacy/smv-dist/mutex.smv";
		file_names[153] = "testcases/legacy/smv-dist/mutex1.smv";
		file_names[154] = "testcases/legacy/smv-dist/pci3p.smv";
		file_names[155] = "testcases/legacy/smv-dist/pci4p.smv";
		file_names[156] = "testcases/legacy/smv-dist/periodic.smv";
		file_names[157] = "testcases/legacy/smv-dist/ring.smv";
		file_names[158] = "testcases/legacy/smv-dist/robot.smv";
		file_names[159] = "testcases/legacy/smv-dist/semaphore.smv";
		file_names[160] = "testcases/legacy/smv-dist/short.smv";
		file_names[161] = "testcases/legacy/smv-dist/syncarb10.smv";
		file_names[162] = "testcases/legacy/smv-dist/syncarb5.smv";
		file_names[163] = "testcases/legacy/tcas/tcas-t.smv";
		file_names[164] = "testcases/legacy/tcas/tcas.smv";
		return file_names;
	}
}
