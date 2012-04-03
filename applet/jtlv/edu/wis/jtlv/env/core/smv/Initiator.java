package edu.wis.jtlv.env.core.smv;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;
import java.util.Map.Entry;

import net.sf.javabdd.BDD;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.OpAnd;
import edu.wis.jtlv.env.core.smv.eval.OpConcat;
import edu.wis.jtlv.env.core.smv.eval.OpCond;
import edu.wis.jtlv.env.core.smv.eval.OpDivide;
import edu.wis.jtlv.env.core.smv.eval.OpEqual;
import edu.wis.jtlv.env.core.smv.eval.OpGE;
import edu.wis.jtlv.env.core.smv.eval.OpGT;
import edu.wis.jtlv.env.core.smv.eval.OpIff;
import edu.wis.jtlv.env.core.smv.eval.OpImplies;
import edu.wis.jtlv.env.core.smv.eval.OpIn;
import edu.wis.jtlv.env.core.smv.eval.OpLE;
import edu.wis.jtlv.env.core.smv.eval.OpLT;
import edu.wis.jtlv.env.core.smv.eval.OpLshift;
import edu.wis.jtlv.env.core.smv.eval.OpMinus;
import edu.wis.jtlv.env.core.smv.eval.OpMod;
import edu.wis.jtlv.env.core.smv.eval.OpNext;
import edu.wis.jtlv.env.core.smv.eval.OpNot;
import edu.wis.jtlv.env.core.smv.eval.OpNotEqual;
import edu.wis.jtlv.env.core.smv.eval.OpOr;
import edu.wis.jtlv.env.core.smv.eval.OpPlus;
import edu.wis.jtlv.env.core.smv.eval.OpRshift;
import edu.wis.jtlv.env.core.smv.eval.OpTimes;
import edu.wis.jtlv.env.core.smv.eval.OpUnaryMinus;
import edu.wis.jtlv.env.core.smv.eval.OpUnion;
import edu.wis.jtlv.env.core.smv.eval.OpXnor;
import edu.wis.jtlv.env.core.smv.eval.OpXor;
import edu.wis.jtlv.env.core.smv.eval.StmtDefineOperator;
import edu.wis.jtlv.env.core.smv.eval.StmtOperator;
import edu.wis.jtlv.env.core.smv.eval.ValueConsRangeStmt;
import edu.wis.jtlv.env.core.smv.eval.ValueConsStmt;
import edu.wis.jtlv.env.core.smv.eval.ValueConsStrStmt;
import edu.wis.jtlv.env.core.smv.eval.ValueDomStmt;
import edu.wis.jtlv.env.core.smv.eval.ValueDummyStmt;
import edu.wis.jtlv.env.core.smv.eval.ValueStmt;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLAnd;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLIff;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLImplies;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLNot;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLOr;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureAA;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureABF;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureABG;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureAF;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureAG;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureAX;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureEBF;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureEBG;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureEE;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureEF;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureEG;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLPureEX;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLXnor;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpCTLXor;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLFuture;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLGlobal;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLHistorical;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLNext;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLNot;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLNotPrecNot;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLOnce;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLPrec;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLRelease;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLSince;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLTriggered;
import edu.wis.jtlv.env.core.smv.eval.temporals.OpLTLUntil;
import edu.wis.jtlv.env.core.smv.schema.SMVAbstractElementInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVArrayVarInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVBooleanVarInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVDefineVarInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVDependentRangeVarInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVMainProcVarInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVModuleInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVParsingInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVProcVarInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVRangeVarInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVValueVarInfo;
import edu.wis.jtlv.env.core.smv.schema.SMVWordVarInfo;
import edu.wis.jtlv.env.module.Module;
import edu.wis.jtlv.env.module.ModuleBDDDefine;
import edu.wis.jtlv.env.module.ModuleBDDField;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.ModuleParamHolder;
import edu.wis.jtlv.env.module.SMVModule;

public class Initiator {
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	// singleton instance
	private static Initiator single = new Initiator();

	private Initiator() {
	}

	public static Initiator get_instance() {
		return single;
	}

	private SMVModule[] module_pool;
	private BDD[] TRANSConjunct;

	@SuppressWarnings( { "deprecation", "unchecked" })
	public void collect_module_inst(String module_name) {
		if (isVarDeclPhase()) // var declare phase
			return;

		endAllDefineScope();

		Vector<SMVModule> pool_vec = new Vector<SMVModule>(10);

		for (String key : Env.getModuleNames()) {
			SMVModule m = (SMVModule) Env.getModule(key);
			if (m.___getModuleInfo().name.equals(module_name)) {
				pool_vec.add(m);
			}
		}
		this.TRANSConjunct = new BDD[pool_vec.size()];
		this.module_pool = new SMVModule[pool_vec.size()];
		pool_vec.toArray(this.module_pool);

		for_loop_scopes = new HashMap[this.module_pool.length];
		for (int i = 0; i < for_loop_scopes.length; i++) {
			for_loop_scopes[i] = new HashMap<String, Integer>();
		}

		startAllDefineScope();
	}

	public int get_module_pool_size() {
		return this.module_pool.length;
	}

	public void finalize_module_inst() {
		if (isVarDeclPhase()) // var declare phase
			return;

		for (int i = 0; i < this.module_pool.length; i++)
			if (this.TRANSConjunct[i] != null)
				this.module_pool[i].conjunctTrans(this.TRANSConjunct[i]);
	}

	// ////////////////////////////////////////////////////////////////////////
	// //////////////////// all phases ////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// 1. var_decl_phase -- creating all variables
	// 2. define_phase -- assign define values
	// -- (can take more then a single walk...)
	// 3. dummy_phase -- extract for loops
	// -- (can be executed during define phase)
	// 4. init_trans_phase - attach statements.

	private boolean var_decl_phase = true;

	public boolean isVarDeclPhase() {
		return this.var_decl_phase;
	}

	@SuppressWarnings("unchecked")
	public void startVarDeclPhase() {
		this.module_pool = new SMVModule[1];
		this.module_pool[0] = null;
		for_loop_scopes = new HashMap[1];
		for_loop_scopes[0] = new HashMap<String, Integer>();
		this.var_decl_phase = true;
	}

	public void endVarDeclPhase() {
		this.module_pool = null;
		for_loop_scopes = null;
		this.var_decl_phase = false;
	}

	// whether we are in the phase of defining defines...
	// to be set by external call when starting the walker
	private boolean define_phase = false;
	private int dummy_phase = 0;

	public boolean isDefinePhase() {
		return this.define_phase;
	}

	public void startDefinePhase() {
		this.define_phase = true;
	}

	public void endDefinePhase() {
		this.define_phase = false;
		try {
			this.attach_dependent_vars();
		} catch (SMVParseException e) {
			e.printStackTrace();
		}
	}

	public void startDummyPhase() {
		this.dummy_phase++;
	}

	public void endDummyPhase() {
		this.dummy_phase--;
	}

	public boolean isDummyPhase() {
		return this.dummy_phase > 0;
	}

	public void startAllDefineScope() {
		this.define_scope.push(mkDefineScope(this.module_pool.length, true));
	}

	public void endAllDefineScope() {
		this.define_scope.pop();
	}

	public void endDefineScope(int at) {
		this.define_scope.peek()[at] = false;
	}

	private boolean init_trans_phase = false;

	public boolean isInitTransPhase() {
		return this.init_trans_phase;
	}

	public void startInitTransPhase() {
		this.init_trans_phase = true;
	}

	public void endInitTransPhase() {
		this.init_trans_phase = false;
	}

	public boolean calcStmt(int at) {
		return (var_decl_phase || (!define_phase | define_scope.peek()[at])
				& !isDummyPhase());
	}

	private Stack<boolean[]> define_scope = initDefineScope();

	private Stack<boolean[]> initDefineScope() {
		Stack<boolean[]> res = new Stack<boolean[]>();
		res.add(mkDefineScope(Env.getAllModules().length, false));
		return res;
	}

	private boolean[] mkDefineScope(int size, boolean initial_value) {
		boolean[] new_scope = new boolean[size];
		for (int i = 0; i < new_scope.length; i++) {
			new_scope[i] = initial_value;
		}
		return new_scope;
	}

	// //////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////

	// make boolean !!
	public SMVAbstractElementInfo mk_boolean_var(StringArrayWA var_name,
			IntStream input) throws SMVParseException {
		if (!isVarDeclPhase())
			return null;

		return new SMVBooleanVarInfo(var_name.arr[0], new SMVParsingInfo(input));
	}

	// make word !!
	public SMVAbstractElementInfo mk_word_var(StringArrayWA var_name,
			String base, String width, IntStream input)
			throws SMVParseException {
		if (!isVarDeclPhase())
			return null;

		return new SMVWordVarInfo(var_name.arr[0], new SMVParsingInfo(input),
				Integer.parseInt(base), Integer.parseInt(width));
	}

	// make values !!
	public SMVAbstractElementInfo mk_values_var(StringArrayWA var_name,
			Vector<String> type_values, IntStream input)
			throws SMVParseException {
		if (!isVarDeclPhase())
			return null;

		String[] types_arr = new String[type_values.size()];
		type_values.toArray(types_arr);
		// TODO: throw a warning if there is a duplicate value
		return new SMVValueVarInfo(var_name.arr[0], new SMVParsingInfo(input),
				types_arr);
	}

	// make range !!
	public SMVAbstractElementInfo mk_range_var(StringArrayWA var_name,
			String from, String to, IntStream input) throws SMVParseException {
		if (!isVarDeclPhase())
			return null;

		try {
			if (Integer.parseInt(to) < Integer.parseInt(from)) {
				throw new SMVParseException("Invalid variable range " + from
						+ ".." + to, input);
			}
		} catch (NumberFormatException nfe) {
			return new SMVDependentRangeVarInfo(var_name.arr[0],
					new SMVParsingInfo(input), from, to);
		}
		return new SMVRangeVarInfo(var_name.arr[0], new SMVParsingInfo(input),
				Integer.parseInt(from), Integer.parseInt(to));
	}

	// make process !!
	public SMVAbstractElementInfo mk_process_var(StringArrayWA var_name,
			String proc_module_name, boolean is_sync,
			Vector<String> inst_vec_str, Vector<StmtValueArrayWA> inst_vec,
			IntStream input) throws SMVParseException {
		if (!isVarDeclPhase())
			return null;

		SMVModuleInfo p = get_module(proc_module_name, input);
		String[] arg_arr = new String[inst_vec_str.size()];
		inst_vec_str.toArray(arg_arr);

		return new SMVProcVarInfo(var_name.arr[0], new SMVParsingInfo(input),
				p, is_sync, arg_arr);
	}

	// make array[from..to] !!
	public SMVAbstractElementInfo mk_range_array_var(StringArrayWA var_name,
			SMVAbstractElementInfo proto, String from, String to,
			IntStream input) throws SMVParseException {
		if (!isVarDeclPhase())
			return null;

		if (Integer.parseInt(to) < Integer.parseInt(from)) {
			throw new SMVParseException("Invalid array range " + from + ".."
					+ to, input);
		}
		return new SMVArrayVarInfo(var_name.arr[0], new SMVParsingInfo(input),
				proto, Integer.parseInt(from), Integer.parseInt(to));
	}

	// make define !!
	public SMVAbstractElementInfo mk_define_var(StringArrayWA var_name,
			IntStream input) throws SMVParseException {
		if (!isVarDeclPhase())
			return null;

		return new SMVDefineVarInfo(var_name.arr[0], new SMVParsingInfo(input));
	}

	// make adding the var !!
	public void add_element(String module_name, SMVAbstractElementInfo var,
			IntStream input) throws SMVParseException {
		if (!isVarDeclPhase())
			return;

		if (var == null) // in case it was caused by an exception.
			throw new SMVParseException("Couldn't not add element.", input);
		SMVModuleInfo m = get_module(module_name, input);
		m.add_element(var, new SMVParsingInfo(input));
	}

	private SMVModuleInfo get_module(String module_name, IntStream input)
			throws SMVParseException {
		// not needed
		// if(!isVarDeclPhase())
		// return null;
		//
		SMVModuleInfo m = StructuralInit.all_modules.get(module_name);
		if (m == null) {
			throw new SMVParseException("Couldn't find MODULE " + module_name,
					input);
		}
		return m;

	}

	// connect the actual variable which were declared !!!!
	public void do_creation() throws SMVParseException {
		// try {
		// initializing the structure.
		SMVModuleInfo main_info = get_module("main", null);
		SMVMainProcVarInfo main_proc_info = new SMVMainProcVarInfo(main_info);

		main_proc_info.mk_fix_names();
		main_proc_info.mk_modules_skel(null);
		main_proc_info.mk_defines(null);
		main_proc_info.mk_variables(null);
		main_proc_info.mk_module_args(null);
		// } catch (SMVParseException e) {
		// Env.do_error(e);
		// }
	}

	private class DependencyEntry {
		private SMVModule instance_holder;
		private SMVDependentRangeVarInfo var;

		public DependencyEntry(SMVModule _instance_holder,
				SMVDependentRangeVarInfo _var) {
			this.instance_holder = _instance_holder;
			this.var = _var;
		}
	}

	private Vector<DependencyEntry> dependent_vars = new Vector<DependencyEntry>();

	public void register_define_dependent_vars(SMVModule instance_holder,
			SMVDependentRangeVarInfo a_var) {
		dependent_vars.add(new DependencyEntry(instance_holder, a_var));
	}

	public int attach_dependent_vars() throws SMVParseException {
		// from the biggest to the least
		for (int i = dependent_vars.size() - 1; i >= 0; i--) {
			DependencyEntry d = dependent_vars.elementAt(i);
			if (d.var.eval_and_assign(d.instance_holder)) {
				dependent_vars.remove(i);
			}
		}
		return dependent_vars.size();
	}

	private boolean has_waiting_dependency(SMVModule m, String var) {
		// from the biggest to the least
		for (int i = dependent_vars.size() - 1; i >= 0; i--) {
			DependencyEntry d = dependent_vars.elementAt(i);
			if (d.instance_holder == m)
				if (d.var.name.equals(var))
					return true;
		}
		return false;
	}

	// ////////////////////////////////////////////////////////////////////////
	// //////////////////// dummy phase (for loops) ///////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public void evalSimpleForLoop(String op, String var, int init_marker,
			int cond_marker, int inc_marker, int expr_marker, int end_marker,
			IntStream input, SMVStmtWalker walker, boolean do_eval)
			throws RecognitionException {
		if (isVarDeclPhase()) // var declare phase
			return;

		if (isDummyPhase()) // for nested loop case
			return;

		// initial value
		input.rewind(init_marker);
		addFORScope(var, walker.simple_expression().ret);

		// condition
		input.rewind(cond_marker);
		boolean[] cond = evalForCond(walker.simple_expression().ret);

		while (hasTrue(cond)) {
			for (int i = 0; i < cond.length; i++) {
				if (!calcStmt(i))
					continue;
				// statement
				input.rewind(expr_marker);
				if (do_eval) {
					if (op.equals("ASSIGN"))
						walker.assign_list();
					else if (op.equals("VAR"))
						walker.var_decl_list();
					else if (op.equals("IVAR"))
						walker.ivar_decl_list();
					else if (op.equals("JUSTICE"))
						walker.justice_list();
					else if (op.equals("COMPASSION"))
						walker.compassion_list();
				} else {
					if (op.equals("DEFINE")) {
						walker.define_list();
					}
				}
			}
			// inc
			input.rewind(inc_marker);
			assignNewValFORScope(var, walker.simple_expression().ret);

			// new condition
			input.rewind(cond_marker);
			cond = evalForCond(cond, walker.simple_expression().ret);
		}

		if (op.equals("DEFINE"))
			remove_define_templates("[" + var + "]");

		input.rewind(end_marker);
		removeFORScope(var);

		input.release(init_marker);
		input.release(cond_marker);
		input.release(inc_marker);
		input.release(expr_marker);
		input.release(end_marker);
	}

	private void remove_define_templates(String template) {
		// not needed
		// if(isVarDeclPhase()) // var declare phase
		// return;
		//
		// otherwise it is an empty loop, and I should look for the temp
		// define myself.
		for (int i = 0; i < this.module_pool.length; i++) {
			ModuleBDDDefine[] all_defs = this.module_pool[i].getAllDefines();
			for (int j = 0; j < all_defs.length; j++) {
				String name = all_defs[j].getName();
				if (name.contains(template)) {
					this.module_pool[i].removeDefine(name);
				}
			}
		}
	}

	public StmtValueArrayWA evalConstructorForLoop(String operator, String var,
			int init_marker, int cond_marker, int inc_marker, int expr_marker,
			int end_marker, IntStream input, SMVStmtWalker walker)
			throws RecognitionException {
		if (isVarDeclPhase()) {// var declare phase
			StmtValueArrayWA res = new StmtValueArrayWA(1);
			res.arr[0] = new ValueDummyStmt(null);
			return res;
		}

		if (isDummyPhase()) // for nested loop case
			return null;

		// initial value
		input.rewind(init_marker);
		addFORScope(var, walker.simple_expression().ret);
		StmtValueArrayWA res = new StmtValueArrayWA(this.module_pool.length);
		if (operator.equals("AND")) {
			for (int i = 0; i < this.module_pool.length; i++)
				res.arr[i] = new ValueConsStrStmt(this.module_pool[i],
						new String[] { "1" });
		} else if (operator.equals("OR")) {
			for (int i = 0; i < this.module_pool.length; i++)
				res.arr[i] = new ValueConsStrStmt(this.module_pool[i],
						new String[] { "0" });
		} else if (operator.equals("PLUS")) {
			for (int i = 0; i < this.module_pool.length; i++)
				res.arr[i] = new ValueConsStrStmt(this.module_pool[i],
						new String[] { "0" });
		}

		// condition
		input.rewind(cond_marker);
		boolean[] cond = evalForCond(walker.simple_expression().ret);

		while (hasTrue(cond)) {
			for (int i = 0; i < cond.length; i++) {
				if (!calcStmt(i))
					continue;
				// statement
				input.rewind(expr_marker);
				StmtValueArrayWA iteration = walker.simple_expression().ret;
				if (cond[i]) {
					if (operator.equals("AND")) {
						res.arr[i] = new OpAnd(res.arr[i], iteration.arr[i]);
					} else if (operator.equals("OR")) {
						res.arr[i] = new OpOr(res.arr[i], iteration.arr[i]);
					} else if (operator.equals("PLUS")) {
						res.arr[i] = new OpPlus(res.arr[i], iteration.arr[i]);
					}
				}
			}
			// inc
			input.rewind(inc_marker);
			assignNewValFORScope(var, walker.simple_expression().ret);

			// new condition
			input.rewind(cond_marker);
			cond = evalForCond(cond, walker.simple_expression().ret);
		}

		input.rewind(end_marker);
		removeFORScope(var);

		input.release(init_marker);
		input.release(cond_marker);
		input.release(inc_marker);
		input.release(expr_marker);
		input.release(end_marker);

		return res;
	}

	private boolean hasTrue(boolean[] vals) {
		// // not needed
		// if (isVarDeclPhase()) // var declare phase
		// return false;
		//
		for (int i = 0; i < vals.length; i++)
			if (vals[i])
				return true;
		return false;
	}

	private HashMap<String, Integer>[] for_loop_scopes;

	private boolean[] evalForCond(StmtValueArrayWA cond_vals)
			throws SMVParseException {
		// not needed
		// if (isVarDeclPhase()) // var declare phase
		// return null;
		//
		ValueStmt single_cond;
		boolean[] res = new boolean[cond_vals.length];
		for (int i = 0; i < this.module_pool.length; i++) {
			single_cond = new StmtOperator(this.module_pool[i],
					cond_vals.arr[i]).eval_stmt();
			BDD b = single_cond.toBDD();
			if (b.isOne())
				res[i] = true;
			else if (b.isZero())
				res[i] = false;
			else {
				// throw new SMVParseException("Cannot evaluate boolean value "
				// + "for condition");
			}
		}
		return res;
	}

	private boolean[] evalForCond(boolean[] old_vals, StmtValueArrayWA cond_vals)
			throws SMVParseException {
		// not needed
		// if (isVarDeclPhase()) // var declare phase
		// return null;
		//
		ValueStmt single_cond;
		boolean[] res = new boolean[cond_vals.length];
		for (int i = 0; i < this.module_pool.length; i++) {
			single_cond = new StmtOperator(this.module_pool[i],
					cond_vals.arr[i]).eval_stmt();
			ValueConsStmt v = single_cond.toValueConsStmt();
			BDD b = v.toValueConsStmt().toBDD();
			if (b.isZero())
				res[i] = false;
			else if (b.isOne())
				res[i] = true;
			else {
				res[i] = false;
				// throw new SMVParseException("Cannot evaluate boolean value "
				// + "for condition");
			}
		}
		return res;
	}

	private void addFORScope(String var_name, StmtValueArrayWA initial_val)
			throws SMVParseException {
		// not needed
		// if (isVarDeclPhase()) // var declare phase
		// return;
		//
		int[] int_vals = quickEvalIntValue(initial_val);
		if (int_vals == null)
			throw new SMVParseException("Cannot evaluate initial value "
					+ "for the for expression");
		for (int i = 0; i < this.module_pool.length; i++)
			for_loop_scopes[i].put(var_name, new Integer(int_vals[i]));
	}

	private void assignNewValFORScope(String var_name, StmtValueArrayWA inc_val)
			throws SMVParseException {
		// not needed
		// if (isVarDeclPhase()) // var declare phase
		// return;
		//
		int[] int_vals = quickEvalIntValue(inc_val);
		if (int_vals == null)
			throw new SMVParseException("Cannot evaluate increment value "
					+ "for the for expression");
		for (int i = 0; i < this.module_pool.length; i++) {
			for_loop_scopes[i].remove(var_name);
			for_loop_scopes[i].put(var_name, new Integer(int_vals[i]));
		}
	}

	private void removeFORScope(String var_name) {
		// not needed
		// if (isVarDeclPhase()) // var declare phase
		// return;
		//
		for (int i = 0; i < this.module_pool.length; i++) {
			for_loop_scopes[i].remove(var_name);
		}
	}

	private String[] replaceAllForScopeArrayes(StringArrayWA str) {
		// if (isVarDeclPhase()) // var declare phase
		// return null;

		String[] res = new String[this.module_pool.length];
		for (int i = 0; i < this.module_pool.length; i++)
			res[i] = replaceForScopeArrayes(str.arr[i], i);
		return res;
	}

	private String replaceForScopeArrayes(String str, int idx) {
		// if (isVarDeclPhase()) // var declare phase
		// return null;

		String res = str;
		for (Entry<String, Integer> e : this.for_loop_scopes[idx].entrySet()) {
			res = res.replace("[" + e.getKey() + "]", "["
					+ e.getValue().intValue() + "]");
		}
		return res;
	}

	public int[] quickEvalIntValue(StmtValueArrayWA vals) {
		if (isVarDeclPhase()) // var declare phase
			return null;

		if (vals == null)
			return null;
		int[] res = new int[vals.length];
		ValueStmt single_val;
		try {
			for (int i = 0; i < vals.length; i++) {
				single_val = new StmtOperator(this.module_pool[i], vals.arr[i])
						.eval_stmt();
				if (single_val.isValueIntStmt()) {
					res[i] = single_val.toValueIntStmt().getAllIntValues()[0];
				} else if (single_val.isValueConsStmt()
						&& (((ValueConsStmt) single_val).isValueConsStrStmt())) {
					res[i] = Integer.parseInt(single_val.toValueConsStmt()
							.toValueConsStrStmt().getValues()[0]);
				} else if (single_val.isValueConsStmt()
						&& (((ValueConsStmt) single_val).isValueConsRangeStmt())
						&& (((ValueConsRangeStmt) single_val).isSingleValue())) {
					res[i] = single_val.toValueConsStmt()
							.toValueConsRangeStmt().fromRange().intValue();
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// //////////////////// define phase //////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	// whether we are now calculating a define...
	// to be set when starting a define in the tree, and reset
	// when ending the define of when this define is depending
	// on another un-prepared define.
	// the scope is per instance
	public void attachParamDefine(StringArrayWA proc_name,
			Vector<StmtValueArrayWA> param_vals) throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;

		// vector of parameters where each is a vector of values depending on
		// the instance.
		for (int j = 0; j < param_vals.size(); j++) {
			for (int i = 0; i < this.module_pool.length; i++) {
				if (!calcStmt(i))
					continue;
				SMVModule inst = this.module_pool[i].getInstance(
						proc_name.arr[i], false);
				if (inst != null) { 
					ModuleParamHolder param = inst.getParam(j);
					if (!param.isDefine())
						continue;
					ModuleBDDDefine def = param.getDefine();
					def.attachStmt(new StmtDefineOperator(this.module_pool[i],
							param_vals.elementAt(j).arr[i]));
				} else { // it could be an array of process.
					SMVModule[] inst_arr = this.module_pool[i]
							.getInstanceArray(proc_name.arr[i], false);
					if (inst_arr != null) {
						for (int k = 0; k < inst_arr.length; k++) {
							ModuleParamHolder param = inst_arr[k].getParam(j);
							if (!param.isDefine())
								continue;
							ModuleBDDDefine def = param.getDefine();
							def.attachStmt(new StmtDefineOperator(
									this.module_pool[i], param_vals
											.elementAt(j).arr[i]));
						}
					}
				}
			}
		}
		this.endAllDefineScope();
	}

	@SuppressWarnings("deprecation")
	public void attachDefine(StringArrayWA def_name, StmtValueArrayWA val)
			throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;

		String[] arrayed_var_names = replaceAllForScopeArrayes(def_name);
		boolean is_for_define = !arrayed_var_names[0].equals(def_name);

		for (int i = 0; i < this.module_pool.length; i++) {
			if (!calcStmt(i))
				continue;

			ModuleBDDDefine def;
			if (!is_for_define) {
				def = this.module_pool[i].getDefine(arrayed_var_names[i], true);
				def.attachStmt(new StmtDefineOperator(this.module_pool[i],
						val.arr[i]));
			} else { // this is a for loop
				def = this.module_pool[i].getDefine(arrayed_var_names[i], true);
				if (def == null) {
					try {
						this.module_pool[i].___addDefine(arrayed_var_names[i]);
					} catch (ModuleException e) {
						throw new SMVParseException(e.getMessage());
					}
					def = this.module_pool[i].getDefine(arrayed_var_names[i],
							true);
				}
				def.attachStmt(new StmtDefineOperator(this.module_pool[i],
						val.arr[i]));
			}
		}
		this.endAllDefineScope();
	}

	public int countAllInitiatedDefines() {
		int res = 0;
		for (Module m : Env.getAllModules())
			if (m instanceof SMVModule)
				for (ModuleBDDDefine def : ((SMVModule) m).getAllDefines())
					if (def.isInitiated())
						res++;
		return res;
	}

	public ModuleBDDDefine[] getAllUninitiatedDefines() {
		Vector<ModuleBDDDefine> res = new Vector<ModuleBDDDefine>(10);
		for (Module m : Env.getAllModules())
			if (SMVModule.class.isInstance(m))
				for (ModuleBDDDefine def : ((SMVModule) m).getAllDefines())
					if (!def.isInitiated())
						res.add(def);
		ModuleBDDDefine[] res_arr = new ModuleBDDDefine[res.size()];
		res.toArray(res_arr);
		return res_arr;
	}

	public int countAllDefines() {
		int res = 0;
		for (Module m : Env.getAllModules())
			if (m instanceof SMVModule)
				res += ((SMVModule) m).getAllDefines().length;
		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// //////////////////// init trans phase //////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	public void attachINIT(StmtValueArrayWA val) throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;
		if (!this.init_trans_phase)
			return;
		for (int i = 0; i < this.module_pool.length; i++) {
			ValueStmt single_val = new StmtOperator(this.module_pool[i],
					val.arr[i]).eval_stmt();
			try {
				this.module_pool[i].addInitial(single_val.toBDD());
			} catch (ModuleException e) {
				throw new SMVParseException(e.getMessage());
				// Env.do_error(e);
			}
		}
	}

	public void attachTRANS(StmtValueArrayWA val) throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;
		if (!this.init_trans_phase)
			return;
		for (int i = 0; i < this.module_pool.length; i++) {
			ValueStmt single_val = new StmtOperator(this.module_pool[i],
					val.arr[i]).eval_stmt();
			// most be conjunct at the end...
			BDD toAdd = single_val.toBDD();
			if (this.TRANSConjunct[i] == null)
				this.TRANSConjunct[i] = toAdd;
			else
				this.TRANSConjunct[i] = this.TRANSConjunct[i].id().and(toAdd);
			// this.module_pool[i].conjunctTrans(single_val.toBDD());
		}
	}

	public void attachASSIGNStmt(StringArrayWA var_name, StmtValueArrayWA val)
			throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;
		if (!this.init_trans_phase)
			return;
		String[] arrayed_var_names = replaceAllForScopeArrayes(var_name);
		for (int i = 0; i < this.module_pool.length; i++) {
			ModuleBDDField coup = this.module_pool[i].getVar(
					arrayed_var_names[i], true);
			ValueDomStmt to_assign = new ValueDomStmt(this.module_pool[i], coup);
			ValueStmt single_val = new StmtOperator(this.module_pool[i],
					new OpEqual(to_assign, val.arr[i])).eval_stmt();
			this.module_pool[i].conjunctTrans(single_val.toBDD());
		}
	}

	public void attachINITStmt(StringArrayWA var_name, StmtValueArrayWA val)
			throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;
		if (!this.init_trans_phase)
			return;
		String[] arrayed_var_names = replaceAllForScopeArrayes(var_name);
		for (int i = 0; i < this.module_pool.length; i++) {
			ModuleBDDField coup = this.module_pool[i].getVar(
					arrayed_var_names[i], true);
			ValueDomStmt to_assign = new ValueDomStmt(this.module_pool[i], coup);
			ValueStmt single_val = new StmtOperator(this.module_pool[i],
					new OpEqual(to_assign, val.arr[i])).eval_stmt();
			try {
				this.module_pool[i].addInitial(single_val.toBDD());
			} catch (ModuleException e) {
				throw new SMVParseException(e.getMessage());
				// Env.do_error(e);
			}
		}
	}

	public void attachNEXTStmt(StringArrayWA var_name, StmtValueArrayWA val)
			throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;
		if (!this.init_trans_phase)
			return;
		String[] arrayed_var_names = replaceAllForScopeArrayes(var_name);
		for (int i = 0; i < this.module_pool.length; i++) {
			ModuleBDDField coup = this.module_pool[i].getVar(
					arrayed_var_names[i], true);
			ModuleBDDField prime_coup = coup.prime();
			ValueDomStmt to_assign = new ValueDomStmt(this.module_pool[i],
					prime_coup);
			ValueStmt single_val = new StmtOperator(this.module_pool[i],
					new OpEqual(to_assign, val.arr[i])).eval_stmt();
			this.module_pool[i].conjunctTrans(single_val.toBDD());
		}
	}

	public void attachJUSTStmt(StmtValueArrayWA val) throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;
		if (!this.init_trans_phase)
			return;
		for (int i = 0; i < this.module_pool.length; i++) {
			ValueStmt just_val = new StmtOperator(this.module_pool[i],
					val.arr[i]).eval_stmt();
			try {
				this.module_pool[i].addJustice(just_val.toBDD());
			} catch (ModuleException e) {
				throw new SMVParseException(e.getMessage());
				// Env.do_error(e);
			}
		}
	}

	public void attachCOMPStmt(StmtValueArrayWA val_p, StmtValueArrayWA val_q)
			throws SMVParseException {
		if (isVarDeclPhase()) // var declare phase
			return;
		if (!this.init_trans_phase)
			return;
		for (int i = 0; i < this.module_pool.length; i++) {
			ValueStmt comp_val_p = new StmtOperator(this.module_pool[i],
					val_p.arr[i]).eval_stmt();
			ValueStmt comp_val_q = new StmtOperator(this.module_pool[i],
					val_q.arr[i]).eval_stmt();
			try {
				this.module_pool[i].addCompassion(comp_val_p.toBDD(),
						comp_val_q.toBDD());
			} catch (ModuleException e) {
				throw new SMVParseException(e.getMessage());
				// Env.do_error(e);
			}
		}
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////// making of leaf elements /////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public StmtValueArrayWA mk_range_val(String module_name,
			Vector<String> a_range, IntStream input) throws SMVParseException {
		if (a_range.size() != 2) {
			throw new SMVParseException(
					"Could not initiate a range with other then 2 values.");
		}
		int range_start, range_end;
		try {
			range_start = Integer.parseInt(a_range.elementAt(0));
			range_end = Integer.parseInt(a_range.elementAt(1));
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Range must be an integer.", input);
		}

		// String[] vals = new String[range_end - range_start + 1];
		// for (int i = 0; i < vals.length; i++) {
		// int val = i + range_start;
		// vals[i] = "" + val;
		// }

		StmtValueArrayWA res = new StmtValueArrayWA(this.module_pool.length);
		for (int i = 0; i < this.module_pool.length; i++) {
			if (!calcStmt(i))
				continue;
			// res.arr[i] = new ValueConsStmt(this.module_pool[i], vals);
			res.arr[i] = new ValueConsRangeStmt(this.module_pool[i],
					range_start, range_end);
		}
		return res;
	}

	public class CaseElement {
		StmtValueArrayWA if_bdd;
		StmtValueArrayWA then_bdd;

		public CaseElement(StmtValueArrayWA an_if_bdd,
				StmtValueArrayWA a_then_bdd) {
			this.if_bdd = an_if_bdd;
			this.then_bdd = a_then_bdd;
		}
	}

	public StmtValueArrayWA mk_case_val(String module_name,
			Vector<CaseElement> elems, IntStream input)
			throws SMVParseException {
		StmtValueArrayWA res = new StmtValueArrayWA(this.module_pool.length);
		for (int i = 0; i < this.module_pool.length; i++) {
			if (!calcStmt(i))
				continue;
			AbstractElement[] cond_elem = new AbstractElement[elems.size()];
			AbstractElement[] then_elem = new AbstractElement[elems.size()];
			for (int j = 0; j < cond_elem.length; j++) {
				cond_elem[j] = elems.elementAt(j).if_bdd.arr[i];
				then_elem[j] = elems.elementAt(j).then_bdd.arr[i];
			}
			res.arr[i] = new OpCond(cond_elem, then_elem);
		}
		return res;
	}

	public StmtValueArrayWA mk_constant_false_val(String module_name,
			IntStream input) throws SMVParseException {
		StmtValueArrayWA res = new StmtValueArrayWA(this.module_pool.length);
		for (int i = 0; i < this.module_pool.length; i++) {
			if (!calcStmt(i))
				continue;
			res.arr[i] = new ValueConsStrStmt(this.module_pool[i],
					new String[] { "0" });
		}
		return res;
	}

	public StmtValueArrayWA mk_constant_true_val(String module_name,
			IntStream input) throws SMVParseException {
		StmtValueArrayWA res = new StmtValueArrayWA(this.module_pool.length);
		for (int i = 0; i < this.module_pool.length; i++) {
			if (!calcStmt(i))
				continue;
			res.arr[i] = new ValueConsStrStmt(this.module_pool[i],
					new String[] { "1" });
		}
		return res;
	}

	public StmtValueArrayWA mk_constant_numeric_val(String module_name,
			String val, IntStream input) throws SMVParseException {
		StmtValueArrayWA res = new StmtValueArrayWA(this.module_pool.length);
		for (int i = 0; i < this.module_pool.length; i++) {
			if (!calcStmt(i))
				continue;
			res.arr[i] = new ValueConsStrStmt(this.module_pool[i],
					new String[] { val });
		}
		return res;
	}

	public StmtValueArrayWA mk_constant_word_val(String module_name,
			String val, IntStream input) throws SMVParseException {
		throw new SMVParseException("Unimplemented Constant value.", input);
	}

	public StmtValueArrayWA mk_ref_val(String module_name, String var,
			StringArrayWA addr, IntStream input) throws SMVParseException {
		StringArrayWA tmp = new StringArrayWA(this, var, null);
		String[] look_for = replaceAllForScopeArrayes(tmp);

		for (int i = 0; i < look_for.length; i++) {
			look_for[i] += replaceForScopeArrayes(addr.arr[i], i);
		}

		StmtValueArrayWA res = new StmtValueArrayWA(this.module_pool.length);
		for (int i = 0; i < this.module_pool.length; i++) {
			if (!calcStmt(i))
				continue;

			if (this.for_loop_scopes[i].containsKey(look_for[i])) {
				res.arr[i] = new ValueConsStrStmt(this.module_pool[i],
						new String[] { ""
								+ this.for_loop_scopes[i].get(look_for[i])
										.intValue() });
			} else if (this.module_pool[i] == null) {
				// FIXME: this is the case when the variable phase is trying to
				// address some reference.
				res.arr[i] = new ValueDummyStmt(null);
			} else if (has_waiting_dependency(this.module_pool[i], look_for[i])) {
				res.arr[i] = new ValueDummyStmt(null);
			} else if (this.module_pool[i].hasDefine(look_for[i], true)) {
				ModuleBDDDefine def = this.module_pool[i].getDefine(
						look_for[i], true);
				// if this define is not initiated, then we are stopping it
				// all... (and wait to the next round of defines...)
				if (!def.isInitiated()) {
					this.endDefineScope(i);
					continue;
				}
				res.arr[i] = def.getStmt();
			} else if (this.module_pool[i].hasInstance(look_for[i], true)) {
				// do nothing... cannot do operations on such kind of ref
				res.arr[i] = null;
			} else if (this.module_pool[i].hasVar(look_for[i], true)) {
				ModuleBDDField coup = this.module_pool[i].getVar(look_for[i],
						true);
				res.arr[i] = new ValueDomStmt(this.module_pool[i], coup);
			} else if ((this.module_pool[i].hasVarArray(look_for[i], true))
					| (this.module_pool[i].hasInstanceArray(look_for[i], true))) {
				// do nothing... cannot do operations on such kind of ref
				res.arr[i] = null;
			} else if (this.module_pool[i].hasValue(look_for[i])) {
				// the following to has bad performance, this is why
				// I'm doing them as a last option...
				res.arr[i] = new ValueConsStrStmt(this.module_pool[i],
						new String[] { look_for[i] });
			} else if ((this.module_pool[i].getHolder() != null)
					&& this.module_pool[i].getHolder().hasValue(look_for[i])) {
				res.arr[i] = new ValueConsStrStmt(this.module_pool[i]
						.getHolder(), new String[] { look_for[i] });
			} else {
				SMVParseException spe = new SMVParseException(
						"Couldn't find value " + look_for[i] + ".", input);
				throw spe;
				// Env.do_error(spe);
				// System.exit(1);
			}
		}
		return res;
	}

	public StmtValueArrayWA mk_self_ref_val(String module_name,
			StringArrayWA addr_from_self, IntStream input)
			throws SMVParseException {
		return mk_ref_val(module_name, "self", addr_from_self, input);
	}

	// public void do_phase3() throws SMVParseException {
	// // do nothing for now.
	// }

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////// making of operator elements /////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public StmtValueArrayWA AND_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpAnd(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CONCAT_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpConcat(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_AA_val(StmtValueArrayWA first, String type,
			Vector<String> range, StmtValueArrayWA other)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureAA(first.arr[i], type, range,
					other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_ABF_val(StmtValueArrayWA first,
			Vector<String> range) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureABF(first.arr[i], range);
		}
		return first;
	}

	public StmtValueArrayWA CTL_ABG_val(StmtValueArrayWA first,
			Vector<String> range) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureABG(first.arr[i], range);
		}
		return first;
	}

	public StmtValueArrayWA CTL_AF_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureAF(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_AG_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureAG(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_AND_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLAnd(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_AX_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureAX(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_EBF_val(StmtValueArrayWA first,
			Vector<String> range) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureEBF(first.arr[i], range);
		}
		return first;
	}

	public StmtValueArrayWA CTL_EBG_val(StmtValueArrayWA first,
			Vector<String> range) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureEBG(first.arr[i], range);
		}
		return first;
	}

	public StmtValueArrayWA CTL_EE_val(StmtValueArrayWA first, String type,
			Vector<String> range, StmtValueArrayWA other)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureEE(first.arr[i], type, range,
					other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_EF_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureEF(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_EG_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureEG(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_EX_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLPureEX(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_IFF_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLIff(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_IMPLIES_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLImplies(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_NOT_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLNot(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_OR_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLOr(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_XNOR_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLXnor(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA CTL_XOR_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpCTLXor(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA DIVIDE_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpDivide(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA EQUAL_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpEqual(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA GE_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpGE(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA GT_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpGT(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA IFF_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpIff(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA IMPLIES_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpImplies(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA IN_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpIn(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA LE_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLE(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA LSHIFT_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLshift(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA LT_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLT(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA LTL_NOT_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLNot(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA MINUS_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpMinus(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA MOD_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpMod(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA NEXT_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpNext(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA NOT_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpNot(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA NOTEQUAL_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpNotEqual(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA OP_FUTURE_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLFuture(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA OP_GLOBAL_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLGlobal(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA OP_HISTORICAL_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLHistorical(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA OP_NEXT_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLNext(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA OP_NOTPRECNOT_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLNotPrecNot(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA OP_ONCE_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLOnce(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA OP_PREC_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLPrec(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA OR_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpOr(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA PLUS_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpPlus(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA RELEASES_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLRelease(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA RSHIFT_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpRshift(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA SINCE_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLSince(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA TIMES_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpTimes(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA TRIGGERED_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLTriggered(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA UNARY_MINUS_val(StmtValueArrayWA first)
			throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpUnaryMinus(first.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA UNION_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpUnion(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA UNTIL_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpLTLUntil(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA XNOR_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpXnor(first.arr[i], other.arr[i]);
		}
		return first;
	}

	public StmtValueArrayWA XOR_val(StmtValueArrayWA first,
			StmtValueArrayWA other) throws SMVParseException {
		for (int i = 0; i < first.length; i++) {
			if (!calcStmt(i))
				continue;
			first.arr[i] = new OpXor(first.arr[i], other.arr[i]);
		}
		return first;
	}

}
