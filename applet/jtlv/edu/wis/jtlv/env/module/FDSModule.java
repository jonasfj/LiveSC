package edu.wis.jtlv.env.module;

import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;
import edu.wis.jtlv.env.Env;

/**
 * <p>
 * An object which represent an FDS module.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 * @see edu.wis.jtlv.env.Env#loadModule(String)
 */
// FIXME: The could be a mistake here with what is the player name.
public class FDSModule extends ModuleWithWeakFairness {
	private String player_name;
	private String[] var_names;
	private BDD initial;
	private BDD transition;
	private Vector<BDD> winning; // just conditions
	private Vector<ModuleBDDField> all_couples;

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Constructors ///////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The main constructor for this kind of module, which creates an empty
	 * module.
	 * </p>
	 * 
	 * @param player_name
	 *            The player name.
	 */
	public FDSModule(String player_name) {
		this.player_name = player_name;
		this.var_names = new String[0];
		this.initial = Env.TRUE();
		this.transition = Env.TRUE();
		this.winning = new Vector<BDD>(20);
		this.all_couples = new Vector<ModuleBDDField>(20);
	}

	/**
	 * <p>
	 * A constructor which receive an array of variables to be declared with
	 * initiation.
	 * </p>
	 * 
	 * @param player_name
	 *            The player name.
	 * @param var_names
	 *            An array of variables.
	 * @throws ModuleException
	 *             If there is a duplicate variable name.
	 * 
	 * @see edu.wis.jtlv.env.module.FDSModule#FDSModule(String)
	 */
	public FDSModule(String player_name, String[] var_names) {
		this(player_name);
		try {
			addVarList(var_names);
		} catch (ModuleException e) {
			Env.doError(e, e.getMessage());
		}
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Adders and Setters /////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	private void addVarList(String[] new_vars) throws ModuleException {
		ModuleBDDField[] all_bdd_vars = new ModuleBDDField[new_vars.length];
		for (int i = 0; i < all_bdd_vars.length; i++) {
			all_bdd_vars[i] = Env.newVar(this.player_name, new_vars[i]);
		}
		String[] new_var_list = new String[this.var_names.length
				+ new_vars.length];
		for (int i = 0; i < this.var_names.length; i++) {
			new_var_list[i] = this.var_names[i];
		}
		for (int i = 0; i < new_vars.length; i++) {
			new_var_list[this.var_names.length + i] = new_vars[i];
		}
		this.var_names = new_var_list;
		// update once so we won't have to do it every unused of
		// prime/unprime
		setPlayerVar(all_bdd_vars);
	}

	private void setPlayerVar(ModuleBDDField[] couples) {
		for (int i = 0; i < couples.length; i++) {
			this.all_couples.add(couples[i]);
		}
	}

	private void setPlayerVar(ModuleBDDField a_couple) {
		this.all_couples.add(a_couple);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#addVar(java.lang.String)
	 */
	@Override
	public ModuleBDDField addVar(String new_var) throws ModuleException,
			ModuleVariableException {
		ModuleBDDField all_bdd_var = Env.newVar(this.player_name, new_var);
		String[] new_var_list = new String[this.var_names.length + 1];
		for (int i = 0; i < this.var_names.length; i++) {
			new_var_list[i] = this.var_names[i];
		}
		new_var_list[this.var_names.length] = new_var;
		this.var_names = new_var_list;
		// update once so we won't have to do it every unused of
		// prime/unprime
		setPlayerVar(all_bdd_var);
		return all_bdd_var;
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
	public void setAllIniRestrictions(Vector<BDD> toSet) {
		tempIniRestriction = toSet;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#conjunctTrans(net.sf.javabdd.BDD)
	 */
	@Override
	public void conjunctTrans(BDD to_add) throws ModuleException {
		this.transition = this.transition.id().and(to_add.id());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#disjunctTrans(net.sf.javabdd.BDD)
	 */
	@Override
	public void disjunctTrans(BDD to_add) throws ModuleException {
		this.transition = this.transition.id().or(to_add.id());
	}

	private Vector<BDD> tempTransRestriction = new Vector<BDD>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#restrictTrans(net.sf.javabdd.BDD)
	 */
	public int restrictTrans(BDD temp_trans) {
		tempTransRestriction.add(temp_trans);
		return tempTransRestriction.size() - 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#removeTransRestriction(int)
	 */
	public void removeTransRestriction(int id) {
		tempTransRestriction.set(id, Env.TRUE());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#removeAllTransRestrictions()
	 */
	public void removeAllTransRestrictions() {
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
	public void setAllTransRestrictions(Vector<BDD> toSet) {
		tempTransRestriction = toSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.wis.jtlv.env.module.ModuleWeakFairnessI#addJustice(net.sf.javabdd
	 * .BDD)
	 */
	@Override
	public void addJustice(BDD to_add) throws ModuleException {
		this.winning.add(to_add.id());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#popLastJustice()
	 */
	public BDD popLastJustice() {
		return this.winning.remove(this.winning.size() - 1);
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Getters ////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#initial()
	 */
	@Override
	public BDD initial() {
		BDD res = this.initial.id();
		// adding restrictions.
		for (BDD restrictionElement : this.tempIniRestriction) {
			res = res.id().and(restrictionElement);
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 */
	@Override
	public BDD trans() {
		BDD res = this.transition.id();
		// adding restrictions.
		for (BDD restrictionElement : this.tempTransRestriction) {
			res = res.id().and(restrictionElement);
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 */
	@Override
	public BDD idleStep() {
		BDD res = Env.TRUE();
		for (ModuleBDDField f : this.getAllFields()) {
			res = res.id().and(f.getDomain().buildEquals(f.getOtherDomain()));
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWeakFairnessI#justiceNum()
	 */
	@Override
	public int justiceNum() {
		return this.winning.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWeakFairnessI#justiceAt(int)
	 */
	@Override
	public BDD justiceAt(int i) {
		return this.winning.elementAt(i).id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWeakFairnessI#justiceAt(int)
	 */
	@Override
	public BDD[] allJustice() {
		BDD[] res = new BDD[this.winning.size()];
		this.winning.toArray(res);
		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Operations /////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#allFields()
	 */
	@Override
	public ModuleBDDField[] getAllFields() {
		ModuleBDDField[] res = new ModuleBDDField[all_couples.size()];
		all_couples.toArray(res);
		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Strings Facilities /////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#toString()
	 */
	@Override
	public String toString() {
		String res = "";
		res += this.player_name + " Variables are : ";
		for (int i = 0; i < this.var_names.length; i++) {
			res += this.var_names[i];
			if (i < this.var_names.length - 1)
				res += ", ";
		}
		res += "\n";
		res += this.player_name + " Initials are:\n";
		res += "\t" + this.initial().toStringWithDomains(Env.stringer) + "\n";
		res += this.player_name + " Transitions are:\n";
		res += "\t" + this.trans().toStringWithDomains(Env.stringer) + "\n";
		res += this.player_name + " Justice are:";
		if (this.justiceNum() == 0) {
			res += "\n\t" + "<no winning conditions>";
		} else {
			for (int i = 0; i < this.justiceNum(); i++) {
				res += "\n\t[" + i + "] "
						+ this.justiceAt(i).toStringWithDomains(Env.stringer);
			}
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.module.Module#getFullInstName()
	 */
	@Override
	public String getFullInstName() {
		return this.player_name;
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
		return full.substring(0, idx);
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
		return full.substring(idx + 1);
	}

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
		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// unimplemented //////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * This functionality is not implemented for FDSModule yet.
	 * </p>
	 * 
	 * @throws RuntimeException
	 *             Always.
	 *             
	 * @see edu.wis.jtlv.env.module.Module#asyncComposition(edu.wis.jtlv.env.module.Module)
	 */
	@Override
	public void asyncComposition(Module inner) {
		// TODO Auto-generated method stub
		throw new RuntimeException("asyncComposition is not implemented"
				+ "for FDSModule yet.");
	}

	/**
	 * <p>
	 * This functionality is not implemented for FDSModule yet.
	 * </p>
	 * 
	 * @throws RuntimeException
	 *             Always.
	 *             
	 * @see edu.wis.jtlv.env.module.Module#decompose(edu.wis.jtlv.env.module.Module)
	 */
	@Override
	public void decompose(Module inner) {
		// TODO Auto-generated method stub
		throw new RuntimeException("decompose is not implemented"
				+ "for FDSModule yet.");
	}

	/**
	 * <p>
	 * This functionality is not implemented for FDSModule yet.
	 * </p>
	 * 
	 * @throws RuntimeException
	 *             Always.
	 *             
	 * @see edu.wis.jtlv.env.module.Module#syncComposition(edu.wis.jtlv.env.module.Module)
	 */
	@Override
	public void syncComposition(Module inner) {
		// TODO Auto-generated method stub
		throw new RuntimeException("syncComposition is not implemented"
				+ "for FDSModule yet.");
	}
}
