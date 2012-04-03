package edu.wis.jtlv.env.module;

import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDDomain;
import net.sf.javabdd.BDDVarSet;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.Env.JTLVBDDToString;
import edu.wis.jtlv.env.core.smv.schema.SMVModuleInfo;

/**
 * <p>
 * An object which represent an SMV module.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 * @see edu.wis.jtlv.env.Env#loadModule(String)
 */
public class SMVModule extends ModuleWithStrongFairness {
	private String player_name;
	private Vector<ModuleBDDField> all_couples;
	private Vector<ModuleBDDDefine> all_defines;
	private ModuleParamHolder[] params_holders;
	private SMVModule holder;
	private SyncStatus is_sync_with_holder;
	private Vector<SMVModule> instances;
	private SMVModuleInfo module_info;

	private static boolean withRunningVar = false;

	// FDS components
	private BDD initial;
	// ////////// new transition scheme. ////////////////////////
	// private BDD transition;
	private Vector<BDD> conjunct_trans;
	// //////////////////////////////////////////////////////////
	private Vector<BDD> justice; // just conditions
	private Vector<BDD> compassion_p; // comp conditions
	private Vector<BDD> compassion_q; // comp conditions

	/**
	 * <p>
	 * Enum class to distinguish between synchronous and asynchronous sub module
	 * composition.
	 * </p>
	 * 
	 * @version {@value edu.wis.jtlv.env.Env#version}
	 * @author yaniv sa'ar.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances(edu.wis.jtlv.env.module.SMVModule.SyncStatus)
	 */
	public enum SyncStatus {
		SYNC, ASYNC, UNDEF
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Constructors ///////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * A constructor for an object representing SMV modules.
	 * </p>
	 * 
	 * @param player_name
	 *            The name of the this instance.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#SMVModule(String, String[],
	 *      String[])
	 * @see edu.wis.jtlv.env.Env#loadModule(String)
	 */
	public SMVModule(String player_name) {
		try {
			init(null, player_name, new String[0], new String[0]);
		} catch (ModuleException e) {
			// cannot really throw this exception since it is for parameters
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * A constructor for an object representing SMV modules. In This constructor
	 * you are allowed to add a set of parameters to the instance, and a
	 * matching set arguments (i.e. their actual values). Please
	 * </p>
	 * 
	 * <p>
	 * <b>NOTE:</b> this type of instantiation is still experimental, and not
	 * fully tested. please check to see that the result are as expected.
	 * </p>
	 * 
	 * @param player_name
	 *            The name of the this instance.
	 * @param params
	 *            The name of the parameter (inside the module)
	 * @param instantiate_str
	 *            The string to instantiate then with (qualified field name)
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#SMVModule(String)
	 * @see edu.wis.jtlv.env.Env#loadModule(String)
	 */
	public SMVModule(String player_name, String[] params,
			String[] instantiate_str) throws ModuleException {
		if (params.length != instantiate_str.length)
			throw new RuntimeException("the size of params and the size of "
					+ "the strings to instantiate then with size must be"
					+ "identical.");
		init(null, player_name, params, instantiate_str);
		___attachParamPointers();
	}

	/**
	 * <p>
	 * A constructor for an object representing SMV modules. You are discourage
	 * from directly instantiating SMV modules using this method. Please see the
	 * reference link.
	 * </p>
	 * 
	 * @param a_module_info
	 *            An abstract info of the module.
	 * @param player_name
	 *            The name of the this instance.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#SMVModule(String)
	 * @see edu.wis.jtlv.env.module.SMVModule#SMVModule(String, String[],
	 *      String[])
	 * @see edu.wis.jtlv.env.Env#loadModule(String)
	 */
	public SMVModule(SMVModuleInfo a_module_info, String player_name) {
		try {
			init(a_module_info, player_name, new String[0], new String[0]);
		} catch (ModuleException e) {
			// cannot really throw this exception since it is for parameters
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * An object representing SMV modules. For now, you are discourage from
	 * directly instantiating SMV modules. Please see the references.
	 * </p>
	 * 
	 * @param a_module_info
	 * @param player_name
	 * @param an_args
	 * @param a_params
	 * @throws ModuleException
	 *             If there was a problem with the parameters declared (i.e.
	 *             duplicate names).
	 */
	public SMVModule(SMVModuleInfo a_module_info, String player_name,
			String[] an_args, String[] a_params) throws ModuleException {
		init(a_module_info, player_name, an_args, a_params);
	}

	private void init(SMVModuleInfo a_module_info, String player_name,
			String[] an_args, String[] a_params) throws ModuleException {
		this.player_name = player_name;
		this.module_info = a_module_info;
		this.all_couples = new Vector<ModuleBDDField>(20);
		this.all_defines = new Vector<ModuleBDDDefine>(20);
		this.params_holders = new ModuleParamHolder[an_args.length];
		for (int i = 0; i < an_args.length; i++) {
			this.params_holders[i] = new ModuleParamHolder(this, an_args[i],
					a_params[i]);
			for (int j = 0; j < i; j++) {
				if (this.params_holders[i].equals(this.params_holders[j])) {
					throw new ModuleException("Cannot declare MODULE "
							+ this.player_name
							+ " with two identical param names "
							+ this.params_holders[i] + ".");
				}
			}
		}
		this.holder = null;
		this.is_sync_with_holder = SyncStatus.UNDEF; // will be set when
		this.instances = new Vector<SMVModule>(20);

		// FDS components
		this.initial = Env.TRUE();
		// ////////// new transition scheme. ////////////////////////
		// this.transition = null;// Env.FALSE();
		this.cacheTrans = null;
		this.conjunct_trans = new Vector<BDD>(10);
		// //////////////////////////////////////////////////////////
		this.justice = new Vector<BDD>(20);
		this.compassion_p = new Vector<BDD>(20);
		this.compassion_q = new Vector<BDD>(20);

		// "main" module has an implicit variable 'running'.
		// other running variable are added by adding an asynchronous inner
		// module.
		if ((this.player_name != null) && (this.player_name.equals("main")))
			if (createRunningVar())
				this.addVar("running");
	}

	/**
	 * <p>
	 * For NuSMV format compatibility, a static option which adds a "running"
	 * variable upon a creation of a new instance.
	 * </p>
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#initModulesWithoutRunningVar()
	 */
	public static void initModulesWithRunningVar() {
		withRunningVar = true;
	}

	/**
	 * <p>
	 * A static option which does not add "running" variable upon a creation of
	 * a new instance.
	 * </p>
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#initModulesWithRunningVar()
	 */
	public static void initModulesWithoutRunningVar() {
		withRunningVar = false;
	}

	private static boolean createRunningVar() {
		return withRunningVar;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Adders and Setters /////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#addVar(java.lang.String)
	 */
	@Override
	public ModuleBDDField addVar(String new_var) throws ModuleException,
			ModuleVariableException {
		return addVar(new_var, 2, null, -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#addInitial(net.sf.javabdd.BDD)
	 */
	@Override
	public void addInitial(BDD to_add) throws ModuleException {
		if (Env.containPrimeVars(to_add)) {
			throw new ModuleException(
					"ERROR: Cannot set initiatial state with primed variables: "
							+ to_add.support().intersect(Env.globalPrimeVars())
									.getDomains() + "\n");
		}
		this.initial = this.initial.id().and(to_add.id());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#setInitial(net.sf.javabdd.BDD)
	 */
	@Override
	public void setInitial(BDD to_add) throws ModuleException {
		if (Env.containPrimeVars(to_add)) {
			throw new ModuleException(
					"ERROR: Cannot set initiatial state with primed variables: "
							+ to_add.support().intersect(Env.globalPrimeVars())
									.getDomains() + "\n");
		}
		this.initial = to_add.id();
	}

	private Vector<BDD> tempIniRestriction = new Vector<BDD>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#restrictIni(net.sf.javabdd.BDD)
	 */
	public int restrictIni(BDD temp_ini) {
		tempIniRestriction.add(temp_ini);
		return tempIniRestriction.size() - 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#removeIniRestriction(int)
	 */
	public void removeIniRestriction(int id) {
		tempIniRestriction.set(id, Env.TRUE());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#removeAllIniRestrictions()
	 */
	public void removeAllIniRestrictions() {
		tempIniRestriction = new Vector<BDD>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#getAllIniRestrictions()
	 */
	@SuppressWarnings("unchecked")
	public Vector<BDD> getAllIniRestrictions() {
		return (Vector<BDD>) tempIniRestriction.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.wis.jtlv.env.module.Module#setAllIniRestrictions(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	public void setAllIniRestrictions(Vector<BDD> toSet) {
		// the clone is needed not to damage the original vector.
		tempIniRestriction = (Vector<BDD>) toSet.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#conjunctTrans(net.sf.javabdd.BDD)
	 */
	@Override
	public void conjunctTrans(BDD to_add) {
		this.cacheTrans = null;
		this.conjunct_trans.add(to_add.id());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#disjunctTrans(net.sf.javabdd.BDD)
	 */
	@Override
	public void disjunctTrans(BDD to_add) {
		this.cacheTrans = null;
		if (this.conjunct_trans.size() == 0) {
			this.conjunct_trans.add(to_add);
			return;
		}
		// else
		for (int i = 0; i < this.conjunct_trans.size(); i++) {
			BDD old = this.conjunct_trans.elementAt(i);
			this.conjunct_trans.set(i, old.id().or(to_add.id()));
		}
	}

	private Vector<BDD> tempTransRestriction = new Vector<BDD>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#restrictTrans(net.sf.javabdd.BDD)
	 */
	public int restrictTrans(BDD temp_trans) {
		this.cacheTrans = null;
		tempTransRestriction.add(temp_trans);
		return tempTransRestriction.size() - 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#removeTransRestriction(int)
	 */
	public void removeTransRestriction(int id) {
		this.cacheTrans = null;
		tempTransRestriction.set(id, Env.TRUE());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#removeAllTransRestrictions()
	 */
	public void removeAllTransRestrictions() {
		this.cacheTrans = null;
		tempTransRestriction = new Vector<BDD>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#getAllTransRestrictions()
	 */
	@SuppressWarnings("unchecked")
	public Vector<BDD> getAllTransRestrictions() {
		return (Vector<BDD>) tempTransRestriction.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.wis.jtlv.env.module.Module#setAllTransRestrictions(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	public void setAllTransRestrictions(Vector<BDD> toSet) {
		this.cacheTrans = null;
		// the clone is needed not to damage the original vector.
		tempTransRestriction = (Vector<BDD>) toSet.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.wis.jtlv.env.module.ModuleFairnessWeakI#addJustice(net.sf.javabdd
	 * .BDD)
	 */
	@Override
	public void addJustice(BDD to_add) throws ModuleException {
		this.justice.add(to_add.id());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#popLastJustice()
	 */
	public BDD popLastJustice() {
		return this.justice.remove(this.justice.size() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.wis.jtlv.env.module.ModuleFairnessStrongI#addCompassion(net.sf.javabdd
	 * .BDD, net.sf.javabdd.BDD)
	 */
	@Override
	public void addCompassion(BDD p, BDD q) throws ModuleException {
		this.compassion_p.add(p.id());
		this.compassion_q.add(q.id());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#popLastCompassion()
	 */
	public BDD[] popLastCompassion() {
		BDD[] res = new BDD[2];
		res[0] = compassion_p.remove(compassion_p.size() - 1);
		res[1] = compassion_q.remove(compassion_q.size() - 1);
		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Getters ////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#primeVars()
	 */
	@Override
	public BDDVarSet modulePrimeVars() {
		BDDVarSet res = Env.getEmptySet();
		for (ModuleBDDField c : this.getAllFields())
			res = res.id().union(
					c.isPrime() ? c.support() : c.prime().support());

		// adding both synchronous and asynchronous primes.
		SMVModule[] all_inst = this.getAllInstances();
		for (int j = 0; j < all_inst.length; j++) {
			res = res.id().union(all_inst[j].modulePrimeVars());
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#unprimeVars()
	 */
	@Override
	public BDDVarSet moduleUnprimeVars() {
		BDDVarSet res = Env.getEmptySet();
		for (ModuleBDDField c : this.getAllFields())
			res = res.id().union(
					c.isPrime() ? c.unprime().support() : c.support());

		// adding both synchronous and asynchronous unprimes.
		SMVModule[] all_inst = this.getAllInstances();
		for (int j = 0; j < all_inst.length; j++) {
			res = res.id().union(all_inst[j].moduleUnprimeVars());
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#getAllFields()
	 */
	@Override
	public ModuleBDDField[] getAllFields() {
		ModuleBDDField[] res = new ModuleBDDField[all_couples.size()];
		all_couples.toArray(res);
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#initial()
	 */
	@Override
	public BDD initial() {
		BDD ini = this.initial.id();
		// conjuncting synchronous and asynchronous initials.
		SMVModule[] all_inst = this.getAllInstances();
		for (int j = 0; j < all_inst.length; j++) {
			ini = ini.id().and(all_inst[j].initial());
		}
		// adding restrictions.
		for (BDD restrictionElement : this.tempIniRestriction) {
			ini = ini.id().and(restrictionElement);
		}
		return ini;
	}

	/**
	 * <p>
	 * caching the transitions. Every change to 'this.conjunct_trans' or to
	 * 'this.instances' must set this variable back to null.
	 * </p>
	 */
	private BDD cacheTrans = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 */
	@Override
	public BDD trans() {
		if (cacheTrans != null)
			return this.cacheTrans;
		SMVModule[] sync_inst = this.getAllInstances(SyncStatus.SYNC);

		// disjuncting my transition list.
		boolean start_with_false = ((conjunct_trans.size() == 0) && (sync_inst.length == 0));
		BDD trans = start_with_false ? Env.FALSE() : Env.TRUE();
		for (BDD elem : this.conjunct_trans) {
			trans = trans.id().and(elem.id());
		}
		// BDD trans = conjunctBDDList(this.conjunct_trans.subList(0,
		// this.conjunct_trans.size()), 10);

		// conjuncting synchronous transitions.
		for (int j = 0; j < sync_inst.length; j++) {
			trans = trans.id().and(sync_inst[j].trans());
		}

		// *** 0. *** preparations for compositional step.
		// if I have running, (not all modules most have running)
		// then setting it to be as next "running".
		ModuleBDDField my_running = this.getVar("running", false);
		if (my_running != null) // setting next(running) to true.
			trans = trans.id().and(my_running.getOtherDomain().ithVar(1));

		// conjuncting asynchronous transitions (either one moves).
		SMVModule[] async_inst = this.getAllInstances(SyncStatus.ASYNC);
		BDD[] inst_trans = new BDD[async_inst.length];
		BDD[] inst_idle = new BDD[async_inst.length];
		for (int j = 0; j < async_inst.length; j++) {
			inst_trans[j] = async_inst[j].trans();

			BDD inst_not_running = Env.TRUE();
			ModuleBDDField inst_running = async_inst[j]
					.getVar("running", false);
			if (inst_running != null) // setting next(running) to true.
				// idle must also set the next(running) to false.
				inst_not_running = inst_running.getOtherDomain().ithVar(0);

			// pres is not good here since I want all his sync and async
			// descendants to freeze. Only when it is his move, he will pick
			// from himself or his descendants.
			// inst_idle[j] = async_inst[j].presStep().and(inst_not_running);
			inst_idle[j] = async_inst[j].idleStep().and(inst_not_running);
		}

		// *** 1. *** first this module transitions.
		BDD others_idle = Env.TRUE();
		for (int i = 0; i < async_inst.length; i++)
			others_idle = others_idle.id().and(inst_idle[i]);
		trans = trans.id().and(others_idle);

		// ////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////
		// POTENTIAL BUG ./////////////////////////////////////////////////////
		// there is a problem with this idle step (or any other),
		// since it can force parameters passed to be idle too...
		// BDD my_idle = this.presStep();
		// if (my_running != null)
		// my_idle = my_running.getOtherDomain().ithVar(0);
		//
		// // *** 2. *** then the others transitions...
		// for (int i = 0; i < async_inst.length; i++) {
		// others_idle = my_idle.id();
		// for (int j = 0; j < async_inst.length; j++)
		// if (i != j)
		// others_idle = others_idle.and(inst_idle[j]);
		// trans = trans.id().or(inst_trans[i].or(others_idle));
		// }

		// for now, the main holding module does not preserve
		// its steps.
		BDD my_idle = Env.TRUE(); // this.idleStep();
		// idle must also set the next(running) to false.
		if (my_running != null)
			my_idle = my_running.getOtherDomain().ithVar(0);

		// *** 2. *** then the others transitions...
		for (int i = 0; i < async_inst.length; i++) {
			others_idle = my_idle.id();
			for (int j = 0; j < async_inst.length; j++)
				if (i != j)
					others_idle = others_idle.and(inst_idle[j]);
			trans = trans.id().or(inst_trans[i].and(others_idle));
		}
		// ////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////

		// finally, adding restrictions.
		for (BDD restrictionElement : this.tempTransRestriction) {
			trans = trans.id().and(restrictionElement);
		}

		this.cacheTrans = trans.id();
		return trans;
	}

	public Vector<BDD> getAllConjunctTransElements() {
		Vector<BDD> res = new Vector<BDD>(10);

		SMVModule[] sync_inst = this.getAllInstances(SyncStatus.SYNC);

		// disjuncting my transition list.
		boolean start_with_false = ((conjunct_trans.size() == 0) && (sync_inst.length == 0));
		res.add(start_with_false ? Env.FALSE() : Env.TRUE());
		for (BDD elem : this.conjunct_trans) {
			res.add(elem.id());
		}
		// BDD trans = conjunctBDDList(this.conjunct_trans.subList(0,
		// this.conjunct_trans.size()), 10);

		// conjuncting synchronous transitions.
		for (int j = 0; j < sync_inst.length; j++) {
			res.addAll(sync_inst[j].getAllConjunctTransElements());
		}

		// *** 0. *** preparations for compositional step.
		// if I have running, (not all modules most have running)
		// then setting it to be as next "running".
		ModuleBDDField my_running = this.getVar("running", false);
		if (my_running != null) // setting next(running) to true.
			res.add(my_running.getOtherDomain().ithVar(1));

		// conjuncting asynchronous transitions (either one moves).
		SMVModule[] async_inst = this.getAllInstances(SyncStatus.ASYNC);
		BDD[] inst_trans = new BDD[async_inst.length];
		BDD[] inst_idle = new BDD[async_inst.length];
		for (int j = 0; j < async_inst.length; j++) {
			inst_trans[j] = async_inst[j].trans();

			BDD inst_not_running = Env.TRUE();
			ModuleBDDField inst_running = async_inst[j]
					.getVar("running", false);
			if (inst_running != null) // setting next(running) to true.
				// idle must also set the next(running) to false.
				inst_not_running = inst_running.getOtherDomain().ithVar(0);

			// pres is not good here since I want all his sync and async
			// descendants to freeze. Only when it is his move, he will pick
			// from himself or his descendants.
			// inst_idle[j] = async_inst[j].presStep().and(inst_not_running);
			inst_idle[j] = async_inst[j].idleStep().and(inst_not_running);
		}

		// *** 1. *** first this module transitions.
		BDD others_idle = Env.TRUE();
		for (int i = 0; i < async_inst.length; i++)
			others_idle = others_idle.id().and(inst_idle[i]);
		res.add(others_idle);

		// for now, the main holding module does not preserve
		// its steps.
		// BDD my_idle = Env.TRUE(); // this.idleStep();
		// // idle must also set the next(running) to false.
		// if (my_running != null)
		// my_idle = my_running.getOtherDomain().ithVar(0);

		// // *** 2. *** then the others transitions...
		// for (int i = 0; i < async_inst.length; i++) {
		// others_idle = my_idle.id();
		// for (int j = 0; j < async_inst.length; j++)
		// if (i != j)
		// others_idle = others_idle.and(inst_idle[j]);
		// trans = trans.id().or(inst_trans[i].and(others_idle));
		// }
		// ////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////

		// finally, adding restrictions.
		for (BDD restrictionElement : this.tempTransRestriction) {
			res.add(restrictionElement);
		}

		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#idleStep()
	 */
	@Override
	public BDD idleStep() {
		BDD res = Env.TRUE();
		for (ModuleBDDField f : this.getAllFields()) {
			res = res.id().and(f.getDomain().buildEquals(f.getOtherDomain()));
		}
		for (SMVModule m : this.getAllInstances()) {
			res = res.id().and(m.idleStep());
		}
		return res;
	}

	/**
	 * <p>
	 * Construct a BDD representing the idle transition of this module and its
	 * synchronous sub modules. If the process has asynchronously inner module,
	 * then it will NOT be included.
	 * </p>
	 * 
	 * @return The idle transition of this module and its synchronous sub
	 *         modules.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#idleStep()
	 */
	public BDD presStep() {
		BDD res = Env.TRUE();
		for (ModuleBDDField f : this.getAllFields()) {
			res = res.id().and(f.getDomain().buildEquals(f.getOtherDomain()));
		}
		for (SMVModule m : this.getAllInstances(SyncStatus.SYNC)) {
			res = res.id().and(m.presStep());
		}
		return res;
	}

	// private BDD conjunctBDDList(List<BDD> to_join, int base) {
	// BDD res = Env.TRUE();
	// if (to_join.size() <= base) {
	// for (BDD b : to_join) {
	// res = res.id().and(b.id());
	// }
	// return res;
	// }
	// int idx = 0; // the start of the next sub chunk.
	// int until = base; // the end of the next sub chunk.
	// while (idx < to_join.size()) {
	// // if until is exceeding...
	// if (!(until <= to_join.size()))
	// until = to_join.size(); // then trimming it.
	// // conjuncting this sub chunk.
	// res = res.id().and(
	// conjunctBDDList(to_join.subList(idx, until), base).id());
	// // advancing.
	// idx = until;
	// until = until + base;
	// }
	// return res;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleFairnessWeakI#justiceNum()
	 */
	@Override
	public int justiceNum() {
		int res = this.justice.size();
		for (SMVModule m : this.getAllInstances(SyncStatus.SYNC))
			res += m.justiceNum();
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleFairnessWeakI#justiceAt(int)
	 */
	@Override
	public BDD justiceAt(int i) {
		int firstIdx = 0; // first index
		int lastIdx = this.justice.size() - 1; // last index
		if (i <= lastIdx)
			return this.justice.elementAt(i).id();

		SMVModule[] subM = this.getAllInstances(SyncStatus.SYNC);
		for (int mIdx = 0; mIdx < subM.length; mIdx++) {
			firstIdx = lastIdx + 1;
			lastIdx += subM[mIdx].justiceNum();
			if (i <= lastIdx)
				return subM[mIdx].justiceAt(i - firstIdx);
		}
		throw new ArrayIndexOutOfBoundsException("No justice at index " + i);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWeakFairnessI#justiceAt(int)
	 */
	@Override
	public BDD[] allJustice() {
		BDD[] res = new BDD[this.justiceNum()];
		for (int i = 0; i < res.length; i++) {
			res[i] = this.justiceAt(i);
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleFairnessStrongI#compassionNum()
	 */
	@Override
	public int compassionNum() {
		int res = this.compassion_p.size();
		for (SMVModule m : this.getAllInstances(SyncStatus.SYNC))
			res += m.compassionNum();
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleFairnessStrongI#pCompassionAt(int)
	 */
	@Override
	public BDD pCompassionAt(int i) {
		int firstIdx = 0; // first index
		int lastIdx = this.compassion_p.size() - 1; // last index
		if (i <= lastIdx)
			return this.compassion_p.elementAt(i).id();

		SMVModule[] subM = this.getAllInstances(SyncStatus.SYNC);
		for (int mIdx = 0; mIdx < subM.length; mIdx++) {
			firstIdx = lastIdx + 1;
			lastIdx += subM[mIdx].compassionNum();
			if (i <= lastIdx)
				return subM[mIdx].pCompassionAt(i - firstIdx);
		}
		throw new ArrayIndexOutOfBoundsException("No compassion_p at index "
				+ i);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleFairnessStrongI#qCompassionAt(int)
	 */
	@Override
	public BDD qCompassionAt(int i) {
		int firstIdx = 0; // first index
		int lastIdx = this.compassion_q.size() - 1; // last index
		if (i <= lastIdx)
			return this.compassion_q.elementAt(i).id();

		SMVModule[] subM = this.getAllInstances(SyncStatus.SYNC);
		for (int mIdx = 0; mIdx < subM.length; mIdx++) {
			firstIdx = lastIdx + 1;
			lastIdx += subM[mIdx].compassionNum();
			if (i <= lastIdx)
				return subM[mIdx].qCompassionAt(i - firstIdx);
		}
		throw new ArrayIndexOutOfBoundsException("No compassion_q at index "
				+ i);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWeakFairnessI#justiceAt(int)
	 */
	@Override
	public BDD[] allPCompassion() {
		BDD[] res = new BDD[this.compassionNum()];
		for (int i = 0; i < res.length; i++) {
			res[i] = this.pCompassionAt(i);
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWeakFairnessI#justiceAt(int)
	 */
	@Override
	public BDD[] allQCompassion() {
		BDD[] res = new BDD[this.compassionNum()];
		for (int i = 0; i < res.length; i++) {
			res[i] = this.qCompassionAt(i);
		}
		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Other Non Module API Facilities ////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Setters and Adders Facilities //////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Add a set of values variable to this module.
	 * </p>
	 * 
	 * @param new_var
	 *            The new variable name.
	 * @param val_names
	 *            The set of values that this variable can be assigned with.
	 * @return The newly created field.
	 * @throws ModuleException
	 *             If an illegal manipulation to the module had been done. e.g.
	 *             duplicate variable names.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String)
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, int, int)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVar(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVar(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVarArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVarArray(String, boolean)
	 */
	public ModuleBDDField addVar(String new_var, String[] val_names)
			throws ModuleException {
		return addVar(new_var, val_names.length, val_names, -1);
	}

	/**
	 * <p>
	 * Add a range variable to this module.
	 * </p>
	 * 
	 * @param new_var
	 *            The new variable name.
	 * @param range_start
	 *            The starting range of the variable.
	 * @param range_end
	 *            The ending range of the variable.
	 * @return The newly created field.
	 * @throws ModuleException
	 *             If an illegal manipulation to the module had been done. e.g.
	 *             duplicate variable names.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String)
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, String[])
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVar(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVar(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVarArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVarArray(String, boolean)
	 */
	public ModuleBDDField addVar(String new_var, int range_start, int range_end)
			throws ModuleException {
		return addVar(new_var, (range_end - range_start + 1), null, range_start);
	}

	private ModuleBDDField addVar(String new_var, int values_size,
			String[] val_names, int range_start) throws ModuleException {
		if (new_var == null || new_var.equals(""))
			throw new ModuleException("Couldn't declare a variable with no "
					+ "name.");

		// 1. if it was found since it is a param, then defining this define at
		// the above holder...
		if (this.hasVar(new_var, true) | this.hasDefine(new_var, true)) {
			if (this.hasParam(new_var, true)) {
				ModuleParamHolder par = getParam(new_var, true);
				SMVModule holder = par.getForInstance().getHolder();
				return holder.addVar(par.getInitString());
			}
			throw new ModuleException("Variable " + new_var
					+ " already declared.");
		}

		// 2. if it is a simple define...
		int idx = new_var.lastIndexOf('.');
		if (idx != -1) {
			throw new ModuleException("Couldn't declare a variable with "
					+ "dot product.");
		}

		// if it is a pointer, then just assigning the reference.
		ModuleBDDField bdd_var = Env.newVar(this.getFullInstName(), new_var,
				values_size);
		// register value names
		if (val_names != null) {
			if (values_size != val_names.length)
				throw new ModuleException("Internal error: values list do "
						+ "not match the size");
			Env.stringer.register_domain_module_values(this, bdd_var
					.getDomain(), val_names);
			Env.stringer.register_domain_module_values(this, bdd_var
					.getOtherDomain(), val_names);
		} else if (values_size > 2) {
			// it is a range, only registering the beginning and the length
			Env.stringer.register_domain_module_values(this, bdd_var
					.getDomain(), range_start, values_size);
			Env.stringer.register_domain_module_values(this, bdd_var
					.getOtherDomain(), range_start, values_size);
		} // for two or 1 I'm leaving it as is handled with boolean.

		this.all_couples.add(bdd_var);
		return bdd_var;
	}

	/**
	 * <p>
	 * Add a module instance as a variable to this module.
	 * </p>
	 * 
	 * @param inner
	 *            The inner instance to compose this module with.
	 * @param is_sync
	 *            Is this a synchronous inner instance or asynchronous.
	 * 
	 * @throws ModuleException
	 *             If the name of the module does not fit the naming convention
	 *             for internal modules. i.e. if this module name is not the
	 *             longest prefix of the module to add name.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstanceArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances()
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances(edu.wis.jtlv.env.module.SMVModule.SyncStatus)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstanceArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#removeInstanceVar(SMVModule)
	 */
	public void addInstanceVar(SMVModule inner, boolean is_sync) {
		if (!is_sync)
			// every async module has an implicit variable 'running'
			if (createRunningVar())
				try {
					inner.addVar("running");
				} catch (ModuleVariableException e) {
				} catch (ModuleException e) {
				}

		inner.setHolder(this);
		inner.is_sync_with_holder = is_sync ? SyncStatus.SYNC
				: SyncStatus.ASYNC;
		this.cacheTrans = null;
		this.instances.add(inner);
	}

	/**
	 * <p>
	 * Removes and inner composed module.
	 * </p>
	 * 
	 * @param inner
	 *            The inner module to remove.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addInstanceVar(SMVModule, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstanceArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances()
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances(edu.wis.jtlv.env.module.SMVModule.SyncStatus)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstanceArray(String, boolean)
	 */
	public void removeInstanceVar(SMVModule inner) {
		// if (!this.instances.contains(inner))
		// throw new ModuleException("Cannot remove a non existing inner"
		// + " module");
		if (inner.is_sync_with_holder == SyncStatus.ASYNC)
			removeRunningVar();

		inner.setHolder(null);
		inner.is_sync_with_holder = SyncStatus.UNDEF;
		this.cacheTrans = null;
		this.instances.remove(inner);
	}

	/**
	 * <p>
	 * Remove the "running variable if is there (NuSMV compatibility)
	 * </p>
	 * 
	 */
	public void removeRunningVar() {
		ModuleBDDField running = getVar("running", false);
		if (running != null)
			// removing "running" - if there...
			all_couples.remove(running);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.wis.jtlv.env.module.Module#syncComposition(edu.wis.jtlv.env.module
	 * .Module)
	 */
	public void syncComposition(Module inner) {
		SMVModule smv_inner = (SMVModule) inner; // throw runtime exception
		addInstanceVar(smv_inner, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.wis.jtlv.env.module.Module#asyncComposition(edu.wis.jtlv.env.module
	 * .Module)
	 */
	public void asyncComposition(Module inner) {
		SMVModule smv_inner = (SMVModule) inner; // throw runtime exception
		addInstanceVar(smv_inner, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.wis.jtlv.env.module.Module#decompose(edu.wis.jtlv.env.module.Module)
	 */
	public void decompose(Module inner) {
		SMVModule smv_inner = (SMVModule) inner; // throw runtime exception
		removeInstanceVar(smv_inner);
	}

	private void setHolder(SMVModule h) {
		this.holder = h;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Hasers Facilities //////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Check whether a variable with the given name exists.
	 * </p>
	 * 
	 * @param addr
	 *            The variable full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return true if the variable field exists.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String)
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, String[])
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, int, int)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVar(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVarArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVarArray(String, boolean)
	 */
	public boolean hasVar(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return false;
		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (ModuleBDDField coup : this.getAllFields())
				if (coup.getName().equals(addr))
					return true;
			for (ModuleParamHolder param : this.getAllParams()) {
				// it would of been better to quire for the name first..
				// but I have no choice since I need the couples first.
				if (addr.startsWith(param.getLocalName() + "[")) {
					if (param.isVarArray()) {
						for (ModuleBDDField coup : param.getVarArray())
							if (coup.getName().equals(addr))
								return true;
					}
				}
				// for this case I can quire the name first.
				if (param.getLocalName().equals(addr)) {
					if (param.isVar()) {
						return true;
					}
				}
			}
			return false;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).hasVar(var_name, look_hard);
		return false;
	}

	/**
	 * <p>
	 * Check whether a variable array with the given name exists.
	 * </p>
	 * 
	 * @param addr
	 *            The array full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return true if the variable field array exists.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String)
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, String[])
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, int, int)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVar(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVarArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVar(String, boolean)
	 */
	public boolean hasVarArray(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return false;
		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (ModuleBDDField coup : this.getAllFields())
				if (coup.getSimpleArrayName().equals(addr))
					return true;
			for (ModuleParamHolder param : this.getAllParams())
				if (param.getLocalName().equals(addr))
					if (param.isVarArray())
						return true;
			return false;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).hasVarArray(var_name,
					look_hard);
		return false;
	}

	/**
	 * <p>
	 * Check whether a define with the given name exists.
	 * </p>
	 * 
	 * @param addr
	 *            The define full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return true if the define exists.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#getDefine(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllDefines()
	 */
	public boolean hasDefine(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return false;
		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (ModuleBDDDefine def : this.getAllDefines())
				if (def.getName().equals(addr))
					return true;
			for (ModuleParamHolder param : this.getAllParams())
				if (param.getLocalName().equals(addr))
					if (param.isDefine())
						return true;
			return false;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).hasDefine(var_name, look_hard);
		return false;
	}

	/**
	 * <p>
	 * Check whether an instance with the given name exists.
	 * </p>
	 * 
	 * @param addr
	 *            The instance full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return true if the instance exists.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addInstanceVar(SMVModule, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstanceArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances()
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances(edu.wis.jtlv.env.module.SMVModule.SyncStatus)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstanceArray(String, boolean)
	 */
	public boolean hasInstance(String addr, boolean look_hard) {
		// ////////////////////////////////////////////////////////
		// this could be implemented in s direct query since player_name is
		// unique to each instance...
		// since i want the implementation to be identical to all components,
		// I'm leaving it as such...
		// ////////////////////////////////////////////////////////
		if (addr == null || addr.equals(""))
			return false;
		// special case
		if (addr.equals("self"))
			return true;

		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (SMVModule inst : this.getAllInstances())
				if (inst.getFullInstName().equals(
						this.getFullInstName() + "." + addr))
					return true;
			for (ModuleParamHolder param : this.getAllParams()) {
				// it would of been better to quire for the name first..
				// but I have no choice since I need the couples first.
				if (addr.startsWith(param.getLocalName() + "[")) {
					if (param.isInstanceArray()) {
						for (ModuleBDDField coup : param.getVarArray())
							if (coup.getName().equals(addr))
								return true;
					}
				}
				// for this case I can quire the name first.
				if (param.getLocalName().equals(addr)) {
					if (param.isInstance()) {
						return true;
					}
				}
			}
			return false;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).hasInstance(var_name,
					look_hard);
		return false;
	}

	/**
	 * <p>
	 * Check whether an instance array with the given name exists.
	 * </p>
	 * 
	 * @param addr
	 *            The array full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return true if the instance array exists.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addInstanceVar(SMVModule, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstanceArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstance(String, boolean)
	 */
	public boolean hasInstanceArray(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return false;
		// special case
		if (addr.equals("self"))
			return false;

		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (SMVModule inst : this.getAllInstances())
				if (inst.getSimpleArrayName().equals(
						this.getFullInstName() + "." + addr))
					return true;
			for (ModuleParamHolder param : this.getAllParams())
				if (param.getLocalName().equals(addr))
					if (param.isInstanceArray())
						return true;
			return false;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).hasInstanceArray(var_name,
					look_hard);
		return false;
	}

	private boolean was_here = false;

	/**
	 * <p>
	 * Check whether a value with the given name exists in any of the variables
	 * of the system.
	 * </p>
	 * 
	 * @param name
	 *            The value name.
	 * @return true if the value exists.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#getValue(String)
	 */
	public boolean hasValue(String name) {
		// ////////////////////////////////////////////////////////
		// 0. if a number, then it is a value... only then:
		// 1. first look here
		// 2. then look at the params
		// 3. finally look at lower levels.
		// ////////////////////////////////////////////////////////
		if (name == null || name.equals(""))
			return false;
		// 0.
		try {
			Integer.parseInt(name);
			return true;
		} catch (NumberFormatException nfe) {
			// do nothing and continuing.
		}
		// 1.
		for (ModuleBDDField coup : this.getAllFields())
			if (Env.stringer.domain_has_module_value(this, coup.getDomain(),
					name))
				return true;
		// 2.
		for (ModuleParamHolder param : this.getAllParams()) {
			if (param.isVar()) {
				if (Env.stringer.domain_has_module_value(this.getHolder(),
						param.getVar().getDomain(), name))
					return true;
			} else if (param.isInstance()) {
				this.was_here = true;
				SMVModule inst = param.getInstance();
				if (!inst.was_here)
					if (inst.hasValue(name)) {
						this.was_here = false;
						return true;
					}
				this.was_here = false;
			}
		}
		// 3.
		this.was_here = true;
		for (SMVModule inst : this.getAllInstances())
			if (!inst.was_here)
				if (inst.hasValue(name)) {
					this.was_here = false;
					return true;
				}
		this.was_here = false;

		return false;
	}

	/**
	 * <p>
	 * Check whether a parameter with the given name exists.
	 * </p>
	 * 
	 * @param addr
	 *            The parameter full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return true if the parameter exists.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#getParam(int)
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllParams()
	 */
	public boolean hasParam(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return false;
		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (ModuleParamHolder param : this.getAllParams())
				if (param.getLocalName().equals(addr))
					return true;
			return false;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).hasParam(var_name, look_hard);
		return false;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Getters Facilities /////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Get the variable with the given name.
	 * </p>
	 * 
	 * @param addr
	 *            The variable full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return The variable field.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String)
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, String[])
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, int, int)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVar(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVarArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVarArray(String, boolean)
	 */
	public ModuleBDDField getVar(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return null;
		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (ModuleBDDField coup : this.getAllFields())
				if (coup.getName().equals(addr))
					return coup;
			for (ModuleParamHolder param : this.getAllParams()) {
				// it would of been better to quire for the name first..
				// but I have no choice since I need the couples first.
				if (addr.startsWith(param.getLocalName() + "[")) {
					if (param.isVarArray()) {
						for (ModuleBDDField coup : param.getVarArray())
							if (coup.getName().equals(addr))
								return coup;
					}
				}
				// for this case I can quire the name first.
				if (param.getLocalName().equals(addr)) {
					if (param.isVar()) {
						return param.getVar();
					}
				}
			}
			return null;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).getVar(var_name, look_hard);
		return null;
	}

	/**
	 * <p>
	 * Get the array of variables with the given name. i.e., for an array of
	 * variables, <br>
	 * var_arr : array 0..3 of boolean;<br>
	 * This procedure with the parameter "var_arr", will return all 4 fields of
	 * this array. To get an exact field, for example "var_arr[3]", you can use
	 * {@link edu.wis.jtlv.env.module.SMVModule#getVar(String, boolean)}, with
	 * the parameter "inst_arr[3]".
	 * </p>
	 * 
	 * @param addr
	 *            The array full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return The variable field.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String)
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, String[])
	 * @see edu.wis.jtlv.env.module.SMVModule#addVar(String, int, int)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVar(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasVarArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getVar(String, boolean)
	 */
	public ModuleBDDField[] getVarArray(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return null;
		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			Vector<ModuleBDDField> col = new Vector<ModuleBDDField>(10);
			for (ModuleBDDField coup : this.getAllFields())
				if (coup.getSimpleArrayName().equals(addr))
					col.add(coup);
			if (col.size() > 0) {
				ModuleBDDField[] res = new ModuleBDDField[col.size()];
				col.toArray(res);
				return res;
			}
			for (ModuleParamHolder param : this.getAllParams())
				if (param.getLocalName().equals(addr))
					if (param.isVar())
						return param.getVarArray();
			return null;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).getVarArray(var_name,
					look_hard);
		return null;
	}

	/**
	 * <p>
	 * Removes the define from this module.
	 * </p>
	 * 
	 * @param addr
	 *            the name of the define to remove.
	 */
	public void removeDefine(String addr) {
		int idx = -1; 
		for (int i = 0; i < this.all_defines.size(); i++)
			if(this.all_defines.elementAt(i).getName().equals(addr))
				idx = i;
		if (idx >= 0)
			this.all_defines.remove(idx);
	}

	/**
	 * <p>
	 * Get the define declared in this module with the given name.
	 * </p>
	 * 
	 * @param addr
	 *            The define full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return The instance.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#hasDefine(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllDefines()
	 */
	public ModuleBDDDefine getDefine(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return null;
		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (ModuleBDDDefine def : this.getAllDefines())
				if (def.getName().equals(addr))
					return def;
			for (ModuleParamHolder param : this.getAllParams())
				if (param.getLocalName().equals(addr))
					if (param.isDefine())
						return param.getDefine();
			return null;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).getDefine(var_name, look_hard);
		return null;
	}

	/**
	 * <p>
	 * Get the instances with the given name.
	 * </p>
	 * 
	 * @param addr
	 *            The instance full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return The instance.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addInstanceVar(SMVModule, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstanceArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances()
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances(edu.wis.jtlv.env.module.SMVModule.SyncStatus)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstanceArray(String, boolean)
	 */
	public SMVModule getInstance(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return null;
		// special case
		if (addr.equals("self"))
			return this;

		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (SMVModule inst : this.getAllInstances())
				if (inst.getFullInstName().equals(
						this.getFullInstName() + "." + addr))
					return inst;
			for (ModuleParamHolder param : this.getAllParams()) {
				// it would of been better to quire for the name first..
				// but I have no choice since I need the couples first.
				if (addr.startsWith(param.getLocalName() + "[")) {
					if (param.isInstanceArray()) {
						for (SMVModule inst : param.getInstanceArray())
							// FIXME: !!! this is a bug... I'm only checking
							// the beginning...
							if (addr.startsWith(param.getLocalName()))
								return inst;
					}
				}
				// for this case I can quire the name first.
				if (param.getLocalName().equals(addr)) {
					if (param.isInstance()) {
						return param.getInstance();
					}
				}
			}
			return null;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).getInstance(var_name,
					look_hard);
		return null;
	}

	/**
	 * <p>
	 * Get the array of instances with the given name. i.e., for an array of
	 * instances, <br>
	 * inst_arr : array 0..7 of some_module;<br>
	 * This procedure with the parameter "inst_arr", will return all 8 instances
	 * of this array. To get an exact instance, for example "inst_arr[3]", you
	 * can use
	 * {@link edu.wis.jtlv.env.module.SMVModule#getInstance(String, boolean)},
	 * with the parameter "inst_arr[3]".
	 * </p>
	 * 
	 * @param addr
	 *            The array full name relative to this module.
	 * @param look_hard
	 *            Whether to go into sub modules and keep on looking.
	 * @return The array of instances.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addInstanceVar(SMVModule, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstanceArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstance(String, boolean)
	 */
	public SMVModule[] getInstanceArray(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return null;
		// special case
		if (addr.equals("self"))
			return null;

		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			Vector<SMVModule> col = new Vector<SMVModule>(10);
			for (SMVModule inst : this.getAllInstances())
				if (inst.getSimpleArrayName().equals(
						this.getFullInstName() + "." + addr))
					col.add(inst);
			if (col.size() > 0) {
				SMVModule[] res = new SMVModule[col.size()];
				col.toArray(res);
				return res;
			}
			for (ModuleParamHolder param : this.getAllParams())
				if (param.getLocalName().equals(addr))
					if (param.isInstanceArray())
						return param.getInstanceArray();
			return null;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).getInstanceArray(var_name,
					look_hard);
		return null;
	}

	/**
	 * <p>
	 * Get A BDD for the disjunct of all variables set to the given value. i.e.,
	 * if a variable does not have the given string value, it is set to false.
	 * </p>
	 * 
	 * @param name
	 *            The value name.
	 * @return A BDD with all variables set to the given string value.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#hasValue(String)
	 */
	public BDD getValue(String name) {
		BDD res = Env.FALSE();
		JTLVBDDToString stger = Env.stringer; // just for readability.
		if (name == null || name.equals(""))
			return res;
		// 0.
		try {
			Integer.parseInt(name);
			return res;
		} catch (NumberFormatException nfe) {
			// do nothing and continuing.
		}
		// 1.
		for (ModuleBDDField coup : this.getAllFields()) {
			BDDDomain dom = coup.getDomain();
			if (stger.domain_has_module_value(this, dom, name))
				res = res.id()
						.or(
								dom.ithVar(stger.get_module_value_loc(this,
										dom, name)));
		}
		// 2.
		for (ModuleParamHolder param : this.getAllParams()) {
			if (param.isVar()) {
				BDDDomain dom = param.getVar().getDomain();
				if (stger.domain_has_module_value(this.getHolder(), dom, name))
					res = res.id().or(
							dom.ithVar(stger.get_module_value_loc(this
									.getHolder(), dom, name)));
			} else if (param.isInstance()) {
				if (param.getInstance().hasValue(name))
					res = res.id().or(param.getInstance().getValue(name));
			}
		}
		// 3.
		this.was_here = true;
		for (SMVModule inst : this.getAllInstances())
			if (!inst.was_here)
				if (inst.hasValue(name))
					res = res.id().or(inst.getValue(name));
		this.was_here = false;

		return res;
	}

	/**
	 * <p>
	 * Getter for the declared parameter and the given index, in this module
	 * signature.
	 * </p>
	 * 
	 * @param at_index
	 *            The index of the param to return.
	 * @return The parameter at the given index.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#hasDefine(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllParams()
	 */
	public ModuleParamHolder getParam(int at_index) {
		ModuleParamHolder[] all_par = this.getAllParams();
		if ((at_index < 0) | (at_index >= all_par.length))
			return null;
		return all_par[at_index];
	}

	private ModuleParamHolder getParam(String addr, boolean look_hard) {
		if (addr == null || addr.equals(""))
			return null;
		int idx = addr.indexOf('.');
		if (idx == -1 | !look_hard) {
			for (ModuleParamHolder param : this.getAllParams())
				if (param.getLocalName().equals(addr))
					return param;
			return null;
		}
		String inst_name = addr.substring(0, idx);
		String var_name = addr.substring(idx + 1);
		if (hasInstance(inst_name, false))
			return getInstance(inst_name, false).getParam(var_name, look_hard);
		return null;
	}

	/**
	 * <p>
	 * Getter for all the defines declared in this module.
	 * </p>
	 * 
	 * @return All defines declared in this module.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#hasDefine(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getDefine(String, boolean)
	 */
	public ModuleBDDDefine[] getAllDefines() {
		ModuleBDDDefine[] res = new ModuleBDDDefine[all_defines.size()];
		all_defines.toArray(res);
		return res;
	}

	/**
	 * <p>
	 * Getter for all instances declared in this module.
	 * </p>
	 * 
	 * @return All instances declared in this module.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addInstanceVar(SMVModule, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getHolder()
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances(edu.wis.jtlv.env.module.SMVModule.SyncStatus)
	 */
	public SMVModule[] getAllInstances() {
		SMVModule[] res_internal = new SMVModule[this.instances.size()];
		this.instances.toArray(res_internal);
		return res_internal;
	}

	/**
	 * <p>
	 * Getter for all synchronous or asynchronous instances declared in this
	 * module.
	 * </p>
	 * 
	 * @param status
	 *            The type of modules to fetch.
	 * 
	 * @return All synchronous or asynchronous instances declared in this
	 *         module.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#addInstanceVar(SMVModule, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#hasInstanceArray(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getInstance(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getHolder()
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances()
	 * @see edu.wis.jtlv.env.module.SMVModule.SyncStatus
	 */
	public SMVModule[] getAllInstances(SyncStatus status) {
		// the order return is important for sub getter.
		SMVModule[] all = this.getAllInstances();
		Vector<SMVModule> res = new Vector<SMVModule>(all.length);
		for (SMVModule m : all) {
			if (m.is_sync_with_holder == status)
				res.add(m);
		}
		SMVModule[] res_arr = new SMVModule[res.size()];
		res.toArray(res_arr);
		return res_arr;
	}

	/**
	 * <p>
	 * Getter for all declared parameters in this module signature.
	 * </p>
	 * 
	 * @return All declared parameters in this module signature.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#hasParam(String, boolean)
	 * @see edu.wis.jtlv.env.module.SMVModule#getParam(int)
	 */
	public ModuleParamHolder[] getAllParams() {
		return this.params_holders;
	}

	/**
	 * <p>
	 * Getter for the module instance holds this instance.
	 * </p>
	 * 
	 * @return The module instance holds this instance.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances()
	 * @see edu.wis.jtlv.env.module.SMVModule#getAllInstances(edu.wis.jtlv.env.module.SMVModule.SyncStatus)
	 */
	public SMVModule getHolder() {
		return this.holder;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Strings Facilities /////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	private String getSimpleArrayName() {
		int last_RB = this.getFullInstName().lastIndexOf(']');
		if ((last_RB + 1) != this.getFullInstName().length())
			return "";

		int last_LB = last_RB - 1;
		int count = 1;
		while ((last_LB > 0) & (count > 0)) {
			if (this.getFullInstName().charAt(last_LB) == ']')
				count++;
			if (this.getFullInstName().charAt(last_LB) == '[')
				count--;
			last_LB--;
		}
		return this.getFullInstName().substring(0, last_LB);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#getFullInstName()
	 */
	public String getFullInstName() {
		return this.player_name;
	}

	/**
	 * <p>
	 * Getter for the full instance name with the parameters.
	 * </p>
	 * 
	 * @return The full instance name with the parameters.
	 */
	public String getFullInstNameWithParams() {
		String f_name = this.getFullInstName() + "(";
		ModuleParamHolder[] all = this.getAllParams();
		for (int i = 0; i < all.length; i++) {
			f_name += (i == 0) ? "" : ", ";
			f_name += all[i].getLocalName();
		}
		f_name += ")";
		return f_name;
	}

	private boolean is_full_printing_mode = false;

	/**
	 * <p>
	 * Set the print mode for the toString procedure. If printing mode is set to
	 * full, then all BDDs and winning conditions will also be printed.
	 * </p>
	 * 
	 * @param to_set
	 *            Set or reset the printing mode.
	 */
	public void setFullPrintingMode(boolean to_set) {
		this.is_full_printing_mode = to_set;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#toString()
	 */
	@Override
	public String toString() {
		String res = "MODULE " + getFullInstNameWithParams() + "\n";

		ModuleBDDField[] all_vars = this.getAllFields();
		res += this.getFullInstName() + " Variables are :";
		if (all_vars.length > 0) {
			res += "\n\t";
		}
		for (int i = 0; i < all_vars.length; i++) {
			res += all_vars[i].getName() + ", ";
		}

		SMVModule[] all_inst = this.getAllInstances(SyncStatus.SYNC);
		for (int j = 0; j < all_inst.length; j++) {
			res += "\n\t[[[ SYNC <" + all_inst[j].getFullInstName() + ">.{";
			ModuleBDDField[] all_inst_vars = all_inst[j].getAllFields();
			for (int i = 0; i < all_inst_vars.length; i++) {
				res += all_inst_vars[i].getName();
				if (i < all_inst_vars.length - 1)
					res += ", ";
			}
			res += "} ]]],";
		}

		all_inst = this.getAllInstances(SyncStatus.ASYNC);
		for (int j = 0; j < all_inst.length; j++) {
			res += "\n\t[[[ ASYNC <" + all_inst[j].getFullInstName() + ">.{";
			ModuleBDDField[] all_inst_vars = all_inst[j].getAllFields();
			for (int i = 0; i < all_inst_vars.length; i++) {
				res += all_inst_vars[i].getName();
				if (i < all_inst_vars.length - 1)
					res += ", ";
			}
			res += "} ]]],";
		}
		res += "\n";

		res += this.getFullInstName() + " Define statements are:\n";
		res += "\t";
		for (ModuleBDDDefine def : this.getAllDefines()) {
			if (!hasParam(def.getName(), false)) {
				res += def.getName() + ", ";
			} // for cases that this is a define from param, I'm not printing
			// it....
		}
		res += "\n";

		res += this.getFullInstName() + " Initials are:\n";
		if (this.is_full_printing_mode) {
			res += Env.toNiceString(this, this.initial(), "\t") + "\n";
		} else {
			res += "\t<low printing mode>\n";
		}

		res += this.getFullInstName() + " Transitions are: ";
		res += "(not including compossed sub modules)\n";
		if (this.is_full_printing_mode) {
			if (this.conjunct_trans.size() == 0)
				res += "\tNo Module Conjuncts.\n";
			// res += "\tFALSE\n";
			// else
			for (int i = 0; i < this.conjunct_trans.size(); i++) {
				res += i + ".) ";
				res += Env.toNiceString(this, this.conjunct_trans.elementAt(i),
						"\t");
				res += "\n";
			}
			// res += Env.toNiceString(this, this.trans(), "\t") + "\n";
		} else {
			res += "\t<low printing mode>\n";
		}

		res += this.getFullInstName() + " Justice are:";
		if (this.justiceNum() == 0) {
			res += "\n\t" + "<no winning conditions>";
		} else {
			BDD[] all_just_arr = new BDD[this.justice.size()];
			this.justice.toArray(all_just_arr);
			for (int i = 0; i < all_just_arr.length; i++) {
				res += "\n\t[" + i + "] ";
				if (this.is_full_printing_mode) {
					// res += all_just_arr[i].toStringWithDomains(Env.stringer);
					res += Env.toNiceSignleLineString(this, all_just_arr[i]);
				} else {
					res += "<low printing mode>";
				}
			}
		}
		res += "\n";

		res += this.getFullInstName() + " Compassions are:";
		if (this.compassionNum() == 0) {
			res += "\n\t" + "<no winning conditions>";
		} else {
			BDD[] all_comp_p_arr = new BDD[this.compassion_p.size()];
			BDD[] all_comp_q_arr = new BDD[this.compassion_q.size()];
			this.compassion_p.toArray(all_comp_p_arr);
			this.compassion_q.toArray(all_comp_q_arr);
			for (int i = 0; i < all_comp_p_arr.length; i++) {
				res += "\n\t[" + i + "] ";
				if (this.is_full_printing_mode) {
					// res +=
					// all_comp_p_arr[i].toStringWithDomains(Env.stringer)
					// + "\n\t\t -> "
					// + all_comp_q_arr[i]
					// .toStringWithDomains(Env.stringer);
					res += Env.toNiceSignleLineString(this, all_comp_p_arr[i])
							+ "\n\t\t -> "
							+ Env.toNiceSignleLineString(this,
									all_comp_q_arr[i]);
				} else {
					res += "<low printing mode>";
				}

			}
		}

		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#getName()
	 */
	@Override
	public String getName() {
		String full = this.getFullInstName();
		int idx = full.lastIndexOf('.');
		return (idx == -1) ? full : full.substring(idx + 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#getPath()
	 */
	@Override
	public String getPath() {
		String full = this.getFullInstName();
		int idx = full.lastIndexOf('.');
		return (idx == -1) ? "" : full.substring(0, idx);
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Should be Hidden Functionalities ///////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Add a new define variable to this module. This procedure only creates an
	 * entity and does not attach a value. To attach a value, the user most
	 * obtain the newly created define entity, using
	 * {@link edu.wis.jtlv.env.module.SMVModule#getDefine(String, boolean)} or
	 * {@link edu.wis.jtlv.env.module.SMVModule#getAllDefines()}, and attach a
	 * value using
	 * {@link edu.wis.jtlv.env.module.ModuleBDDDefine#attachStmt(edu.wis.jtlv.env.core.smv.eval.StmtDefineOperator)}
	 * </p>
	 * 
	 * @param addr
	 *            The name for the newly created define entity.
	 * @throws ModuleException
	 *             If an illegal manipulation to the module had been done. e.g.
	 *             duplicate variable names.
	 * @see edu.wis.jtlv.env.module.SMVModule#___addDefineFromParam(String)
	 * 
	 * @deprecated <b>INTERNAL PROCEDURE - will be encapsulated and removed from
	 *             the external API in the following few releases.</b>
	 */
	public void ___addDefine(String addr) throws ModuleException {
		if (addr == null || addr.equals(""))
			throw new ModuleException("Couldn't declare a define with no name.");

		// 1. if it was found since it is a param, then defining this define at
		// the above holder...
		if (this.hasVar(addr, true) | this.hasDefine(addr, true)) {
			if (this.hasParam(addr, true)) {
				ModuleParamHolder par = getParam(addr, true);
				SMVModule holder = par.getForInstance().getHolder();
				holder.___addDefine(par.getInitString());
				return;
			}
			throw new ModuleException("Variable " + addr + " already declared.");
		}

		// 2. if it is a simple define...
		int idx = addr.lastIndexOf('.');
		if (idx == -1) {
			this.all_defines.add(new ModuleBDDDefine(this.getFullInstName(),
					addr));
			return;
		}

		// 3. if it is a define to a lower instance...
		String inst_name = addr.substring(0, idx);
		if (this.hasInstance(inst_name, true)) {
			this.getInstance(inst_name, true).___addDefine(
					addr.substring(idx + 1));
			return;
		}

		throw new ModuleException("Couldn't find instance " + inst_name
				+ " to define " + addr + ".");
		// System.err.println("Couldn't find instance " + inst_name
		// + " to define " + addr + ".");
	}

	/**
	 * <p>
	 * Add a new define variable from a lower instance to this module. This
	 * procedure only creates an entity and does not attach a value. To attach a
	 * value, the user most obtain the newly created define entity, using
	 * {@link edu.wis.jtlv.env.module.SMVModule#getDefine(String, boolean)} or
	 * {@link edu.wis.jtlv.env.module.SMVModule#getAllDefines()}, and attach a
	 * value using
	 * {@link edu.wis.jtlv.env.module.ModuleBDDDefine#attachStmt(edu.wis.jtlv.env.core.smv.eval.StmtDefineOperator)}
	 * </p>
	 * 
	 * @param addr
	 *            The name for the newly created define entity.
	 * @throws ModuleException
	 *             If an illegal manipulation to the module had been done. e.g.
	 *             duplicate variable names.
	 * 
	 * @see edu.wis.jtlv.env.module.SMVModule#___addDefine(String)
	 * 
	 * @deprecated <b>INTERNAL PROCEDURE - will be encapsulated and removed from
	 *             the external API in the following few releases.</b>
	 */
	public void ___addDefineFromParam(String addr) throws ModuleException {
		if (addr == null || addr.equals(""))
			throw new ModuleException("Couldn't declare a define with no name.");

		// 2. if it is a simple define...
		int idx = addr.lastIndexOf('.');
		if (idx == -1) {
			this.all_defines.add(new ModuleBDDDefine(this.getFullInstName(),
					addr));
			return;
		}

		// 3. if it is a define to a lower instance...
		String inst_name = addr.substring(0, idx);
		if (this.hasInstance(inst_name, true)) {
			this.getInstance(inst_name, true).___addDefine(
					addr.substring(idx + 1));
			return;
		}

		throw new ModuleException("Couldn't find instance " + inst_name
				+ " to define " + addr + ".");
		// System.err.println("Couldn't find instance " + inst_name
		// + " to define " + addr + ".");
	}

	/**
	 * <p>
	 * The the module parsing information.
	 * </p>
	 * 
	 * @return Parsing info.
	 * 
	 * @deprecated <b>INTERNAL PROCEDURE - will be encapsulated and removed from
	 *             the external API in the following few releases.</b>
	 */
	public SMVModuleInfo ___getModuleInfo() {
		return this.module_info;
	}

	/**
	 * <p>
	 * Attach the module signature variables to their values.
	 * </p>
	 * 
	 * @throws ModuleException
	 *             If there was a problem evaluating defines.
	 * 
	 * @deprecated <b>INTERNAL PROCEDURE - will be encapsulated and removed from
	 *             the external API in the following few releases.</b>
	 */
	public void ___attachParamPointers() throws ModuleException {
		for (ModuleParamHolder param : this.getAllParams()) {
			param.___attachPointer();
		}
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Deleted ////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	// public boolean isArrayElement() {
	// return ((this.getFullInstName().lastIndexOf(']') + 1) == this
	// .getFullInstName().length());
	// }

}
