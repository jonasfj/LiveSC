package edu.wis.jtlv.env.core.smv;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.antlr.runtime.IntStream;

import edu.wis.jtlv.env.core.smv.schema.SMVAbstractElementInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVModuleInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVParsingInfo;

public class StructuralInit {
	public static HashMap<String, SMVModuleInfo> all_modules;

	// singleton instance
	private static StructuralInit single = new StructuralInit();

	private StructuralInit() {
		all_modules = new HashMap<String, SMVModuleInfo>(50);
	}

	public static StructuralInit get_instance() {
		return single;
	}

	public static void resetParser() {
		StructuralInit.get_instance().do_phase_end();
	}

	public void do_phase_end() {
		all_modules.clear();
		all_modules = new HashMap<String, SMVModuleInfo>(50);
	}

	// ///////////////////////////////////////////////////////
	// work with the phases of the the tree walkers...
	// * phase 1 - all modules
	// * phase 2 - all variables.
	// * phase 3 - statements.
	// ///////////////////////////////////////////////////////

	// phase 1 - MODULES!!
	public SMVAbstractElementInfo add_module(String a_name, String[] args,
			IntStream input) throws SMVParseException {
		SMVModuleInfo m = all_modules.get(a_name);
		if (m != null) {
			throw new SMVParseException("MODULE " + a_name + " already exists",
					input);
		}

		m = new SMVModuleInfo(a_name, new SMVParsingInfo(input), args);
		all_modules.put(a_name, m);
		return m;
	}

	// phase 1 - MODULES!!
	public SMVAbstractElementInfo add_module(Vector<String> name_plus_args,
			IntStream input) throws SMVParseException {
		String module_name = "";
		String[] module_arg_list = new String[name_plus_args.size() - 1];
		int module_arg_index = 0;
		boolean is_first = true;
		for (Iterator<String> iter_names = name_plus_args.iterator(); iter_names
				.hasNext();) {
			String a_name = iter_names.next();
			if (is_first) {
				module_name = a_name;
			} else {
				module_arg_list[module_arg_index] = a_name;
				module_arg_index++;
			}
			is_first = false;
		}

		if (module_name.equals("")) {
			throw new SMVParseException("Couldn't find module's name.", input);
		}
		return this.add_module(module_name, module_arg_list, input);
	}

//	// //////////////////////////////////////////////////////////////////////////////
//	// //////////////////////////////////////////////////////////////////////////////
//	// //////////////////////////////////////////////////////////////////////////////
//	// //////////////////////////////////////////////////////////////////////////////
//
//	// phase 2 - boolean !!
//	public SMVAbstractElementInfo mk_boolean_var(String var_name,
//			IntStream input) throws SMVParseException {
//		return new SMVBooleanVarInfo(var_name, new SMVParsingInfo(input));
//	}
//
//	// phase 2 - word !!
//	public SMVAbstractElementInfo mk_word_var(String var_name, String base,
//			String width, IntStream input) throws SMVParseException {
//		return new SMVWordVarInfo(var_name, new SMVParsingInfo(input), Integer
//				.parseInt(base), Integer.parseInt(width));
//	}
//
//	// phase 2 - values !!
//	public SMVAbstractElementInfo mk_values_var(String var_name,
//			Vector<String> type_values, IntStream input)
//			throws SMVParseException {
//		String[] types_arr = new String[type_values.size()];
//		type_values.toArray(types_arr);
//		// TODO: throw a warning if there is a duplicate value
//		return new SMVValueVarInfo(var_name, new SMVParsingInfo(input),
//				types_arr);
//	}
//
//	// phase 2 - range !!
//	public SMVAbstractElementInfo mk_range_var(String var_name, String from,
//			String to, IntStream input) throws SMVParseException {
//		if (Integer.parseInt(to) < Integer.parseInt(from)) {
//			throw new SMVParseException("Invalid variable range " + from + ".."
//					+ to, input);
//		}
//		return new SMVRangeVarInfo(var_name, new SMVParsingInfo(input), Integer
//				.parseInt(from), Integer.parseInt(to));
//	}
//
//	// phase 2 - process !!
//	public SMVAbstractElementInfo mk_process_var(String var_name,
//			String proc_module_name, boolean is_sync, Vector<String> inst_vec,
//			IntStream input) throws SMVParseException {
//		SMVModuleInfo p = get_module(proc_module_name, input);
//		String[] arg_arr = new String[inst_vec.size()];
//		inst_vec.toArray(arg_arr);
//		return new SMVProcVarInfo(var_name, new SMVParsingInfo(input), p,
//				is_sync, arg_arr);
//	}
//
////	// phase 2 - array[size] !!
////	public SMVAbstractElementInfo mk_array_var(String var_name,
////			SMVVarInfo proto, String size, IntStream input)
////			throws SMVParseException {
////		return new SMVArrayVarInfo(var_name, new SMVParsingInfo(input), proto,
////				Integer.parseInt(size));
////	}
//
//	// phase 2 - array[from..to] !!
//	public SMVAbstractElementInfo mk_range_array_var(String var_name,
//			SMVAbstractElementInfo proto, String from, String to,
//			IntStream input) throws SMVParseException {
//		if (Integer.parseInt(to) < Integer.parseInt(from)) {
//			throw new SMVParseException("Invalid array range " + from + ".."
//					+ to, input);
//		}
//		return new SMVArrayVarInfo(var_name, new SMVParsingInfo(input), proto,
//				Integer.parseInt(from), Integer.parseInt(to));
//	}
//
//	// phase 2 - define !!
//	public SMVAbstractElementInfo mk_define_var(String var_name,
//			IntStream input) throws SMVParseException {
//		return new SMVDefineVarInfo(var_name, new SMVParsingInfo(input));
//	}
//
//	// phase 2 - adding the var !!
//	public void add_element(String module_name, SMVAbstractElementInfo var,
//			IntStream input) throws SMVParseException {
//		if (var == null) // in case it was caused by an exception.
//			throw new SMVParseException("Couldn't not add element.", input);
//		SMVModuleInfo m = get_module(module_name, input);
//		m.add_element(var, new SMVParsingInfo(input));
//	}
//
//	public SMVModuleInfo get_module(String module_name, IntStream input)
//			throws SMVParseException {
//		SMVModuleInfo m = all_modules.get(module_name);
//		if (m == null) {
//			throw new SMVParseException("Couldn't find MODULE " + module_name,
//					input);
//		}
//		return m;
//
//	}
//
//	// end of phase 2 !!!!
//	public void do_phase2() throws SMVParseException {
//		// try {
//		// initializing the structure.
//		SMVModuleInfo main_info = get_module("main", null);
//		SMVMainProcVarInfo main_proc_info = new SMVMainProcVarInfo(main_info);
//
//		main_proc_info.mk_fix_names();
//		main_proc_info.mk_modules_skel(null);
//		main_proc_info.mk_defines(null);
//		main_proc_info.mk_variables(null);
//		main_proc_info.mk_module_args(null);
//		// } catch (SMVParseException e) {
//		// Env.do_error(e);
//		// }
//	}

}
