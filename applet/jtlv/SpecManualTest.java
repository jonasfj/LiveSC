

import java.io.IOException;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.spec.Spec;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 *
 */
public class SpecManualTest {
	public static void main(String[] args) {
		// System.setProperty("bdd", "buddy");
		String file_name = "testcases/legacy/counter.smv";

		try {
			Env.loadModule(file_name);
			System.out.println("========= DONE Loading Modules ==========");

			/* 
			SPEC //0.
				AG AF bit2.carry_out
			
			SPEC
				AG AF ((bit0.value <-> bit1.value) & bit2.value)
			
			SPEC //2.	// error
				AG AF ((it0.value <-> it1.value) & bit2.value)
			
			SPEC //3.
				AG AF (bit0.value & bit1.value & bit2.value)
			
			SPEC //4.
				AG AF bit2.carry_out
			
			LTLSPEC //5.
				G F bit2.carry_out
			
			SPEC
				AG(!bit2.carry_out);
			
			SPEC //7.
				!AG(!bit2.carry_out)
			
			LTLSPEC /8.
				G (!bit2.carry_out)
			
			SPEC //9.
				A [(!bit2.carry_out) UNTIL (bit2.carry_out)]
			
			SPEC //10.
				A [ bit2.value BU 1..2 bit0.value ] & bit1.value
			
			SPEC //11.	// error
				(!bit2.carry_out) U x;
			
			CTL*SPEC //12.
				A [ !bit2.carry_out UNTIL bit2.carry_out ]
			
			LTLSPEC	//13. // error
				(!bit2.carry_out) U    ;
			
			CTLSPEC // 14.
				A [ bit0.carry_out BU 1..2 bit2.carry_out ] & bit2.carry_out;
			
			LTLSPEC	//15. // error
				U (!bit2.carry_out)
			
			CTL*SPEC //16.
				A [ bit2.value U bit0.carry_out ];
			
			SPEC	//17. // error
				(!bit2.carry_out) U ;
			
			CTLSPEC //18.
				A [ bit0.value BU 1..2 bit2.value ];
			
			CTL*SPEC //19.
				A [ bit0.value BU 1..2 bit2.value  ];
			
			CTLSPEC //20.
				A [ bit0.value U bit2.value ];
			
			CTL*SPEC //21.
				A [ bit0.value U bit2.value  ];
			
			CTLSPEC //22. // error
				A [ bit0.value BU bit2.value ];
			
			CTL*SPEC //23. // error
				A [ bit0.value BU bit2.value  ];
			
			CTLSPEC //24. // error
				A [ bit0.value U 0..2 bit2.value ];
			
			CTL*SPEC //25. // error
				A [ bit0.value U 0..2 bit2.value  ];
			
			LTLSPEC //26.
				G (next(bit2.carry_out))
				
			CTLSPEC //27.-18
				A [ next(bit0.value) BU 1..2 bit2.value ];
			*/

			String to_parse = ""
//					+ "SPEC																\n"
//					+ "	AG AF bit2.carry_out											\n"
//					+ "																	\n"
//					+ "SPEC																\n"
//					+ "	AG AF ((bit0.value <-> bit1.value) & bit2.value)				\n"
//					+ "																	\n"
//					+ "SPEC	// error													\n"
//					+ "	AG AF ((it0.value <-> it1.value) & bit2.value)					\n"
//					+ "																	\n"
//					+ "SPEC																\n"
//					+ "	AG AF (bit0.value & bit1.value & bit2.value)					\n"
//					+ "																	\n"
					+ "SPEC																\n"
					+ "	AG AF bit2.carry_out											\n"
					+ "																	\n"
//					+ "LTLSPEC															\n"
//					+ "	G F bit2.carry_out												\n"
//					+ "																	\n"
//					+ "SPEC																\n"
//					+ "	AG(!bit2.carry_out);											\n"
//					+ "																	\n"
//					+ "SPEC																\n"
//					+ "	!AG(!bit2.carry_out)											\n"
//					+ "																	\n"
//					+ "LTLSPEC															\n"
//					+ "	G (!bit2.carry_out)												\n"
//					+ "																	\n"
//					+ "SPEC																\n"
//					+ "	A [(!bit2.carry_out) UNTIL (bit2.carry_out)]					\n"
//					+ "																	\n"
//					+ "SPEC																\n"
//					+ "	A [ bit2.value BU 1..2 bit0.value ] & bit1.value				\n"
//					+ "																	\n"
//					+ "SPEC	// error													\n"
//					+ "	(!bit2.carry_out) U x;											\n"
//					+ "																	\n"
//					+ "CTL*SPEC															\n"
//					+ "	A [ !bit2.carry_out UNTIL bit2.carry_out ]						\n"
//					+ "																	\n"
//					+ "LTLSPEC	// error												\n"
//					+ "	(!bit2.carry_out) U    ; 										\n"
//					+ "																	\n"
//					+ "CTLSPEC															\n"
//					+ "	A [ bit0.carry_out BU 1..2 bit2.carry_out ] & bit2.carry_out;	\n"
//					+ "																	\n"
//					+ "LTLSPEC	// error												\n"
//					+ "	U (!bit2.carry_out)	 											\n"
//					+ "																	\n"
//					+ "CTL*SPEC															\n" 
//					+ "	A [ bit2.value U bit0.carry_out ];								\n"
//					+ "																	\n"
//					+ "SPEC	// error													\n"
//					+ "	(!bit2.carry_out) U ;											\n"
//					+ "																	\n"
//					+ "CTLSPEC 															\n" 
//					+ " A [ bit0.value BU 1..2 bit2.value ];							\n"
//					+ "																	\n"
//					+ "CTL*SPEC															\n" 
//					+ " A [ bit0.value BU 1..2 bit2.value  ];							\n"
//					+ "																	\n"
//					+ "CTLSPEC 															\n" 
//					+ " A [ bit0.value U bit2.value ];									\n"
//					+ "																	\n"
//					+ "CTL*SPEC															\n" 
//					+ " A [ bit0.value U bit2.value  ];									\n"
//					+ "																	\n"
//					+ "CTLSPEC // error													\n" 
//					+ " A [ bit0.value BU bit2.value ];									\n"
//					+ "																	\n"
//					+ "CTL*SPEC // error												\n" 
//					+ " A [ bit0.value BU bit2.value  ];								\n"
//					+ "																	\n"
//					+ "CTLSPEC // error													\n" 
//					+ " A [ bit0.value U 0..2 bit2.value ];								\n"
//					+ "																	\n"
//					+ "CTL*SPEC // error												\n" 
//					+ " A [ bit0.value U 0..2 bit2.value  ];							\n"
//					+ "																	\n"
//					+ "LTLSPEC															\n"
//					+ "	G (next(bit2.carry_out))										\n"
//					+ "																	\n"
//					+ "CTLSPEC 															\n" 
//					+ " A [ next(bit0.value) BU 1..2 bit2.value ];						\n"
//					+ "																	\n"
					+ "																	\n";
					
//			String to_parse = ""
//					+ "LTLSPEC	// error - NICE TO FIX									\n" 
//					+ "	A [ x.y.z.w U x.z.y ];											\n"
//					+ "																	\n"
//					+ "LTLSPEC // NICE TO HAVE 											\n"
//					+ "	G (bit2.value & bit2.value')									\n"
//					+ "																	\n"
//					+ "																	\n";

			Spec[] ls = Env.loadSpecString(to_parse);
			for (Spec s : ls) {
				System.out.println("=========");
				System.out.println(s);
				if (s == null)
					continue;
				System.out.print("isPropSpec --------------- ");
				System.out.println(s.isPropSpec());
				System.out.print("isCTLSpec ---------------- ");
				System.out.println(s.isCTLSpec());
				System.out.print("isRealTimeCTLSpec -------- ");
				System.out.println(s.isRealTimeCTLSpec());
				System.out.print("isLTLSpec ---------------- ");
				System.out.println(s.isLTLSpec());
				System.out.print("isFutureLTLSpec ---------- ");
				System.out.println(s.isFutureLTLSpec());
				System.out.print("isPastLTLSpec ------------ ");
				System.out.println(s.isPastLTLSpec());
				System.out.print("isCTLStarSpec ------------ ");
				System.out.println(s.isCTLStarSpec());
				System.out.print("hasTemporalOperators ----- ");
				System.out.println(s.hasTemporalOperators());
			}
			System.out.println("========= DONE Loading Specs ============");

		} catch (IOException e) {
			Env.doError(e, e.toString());
			System.exit(0);
		}

	}
}
