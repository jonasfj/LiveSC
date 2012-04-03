package edu.wis.jtlv.env.module;

import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.lib.FixPoint;

/**
 * <p>
 * A general interface for modules. It is advise to load modules and manipulate
 * them through the file itself, and then load it to the environment through
 * Env. However, this is not the only way to create a new module. One can use
 * whole set of manipulating procedures provided by this interface, to create a
 * new module.<br>
 * By default, The initial condition is TRUE, transition relation is TRUE.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 * @see edu.wis.jtlv.env.Env#loadModule(String)
 * @see edu.wis.jtlv.env.Env#getAllModules()
 * @see edu.wis.jtlv.env.Env#getModule(String)
 */
public abstract class Module {

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Adders Facilities //////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Add a variable to the module.
	 * </p>
	 * 
	 * @param new_var
	 *            The name of the new variable to add.
	 * @return The newly created field.
	 * @throws ModuleException
	 *             If there was a problem with adding the variable, e.g. a
	 *             variable with this name already exists.
	 */
	public abstract ModuleBDDField addVar(String new_var)
			throws ModuleException;

	/**
	 * <p>
	 * Conjunct the initial condition with the given condition.
	 * </p>
	 * 
	 * @param to_add
	 *            The condition to add to the module.
	 * @throws ModuleException
	 *             If there was a problem with adding the condition, e.g. a
	 *             there where primed variables in the condition.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#initial()
	 * @see edu.wis.jtlv.env.module.Module#setInitial(BDD)
	 */
	public abstract void addInitial(BDD to_add) throws ModuleException;

	/**
	 * <p>
	 * Set the initial condition with the given condition.
	 * </p>
	 * 
	 * @param to_add
	 *            The condition to set to the module.
	 * @throws ModuleException
	 *             If there was a problem with setting the condition, e.g. a
	 *             there where primed variables in the condition.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#initial()
	 * @see edu.wis.jtlv.env.module.Module#addInitial(BDD)
	 */
	public abstract void setInitial(BDD to_add) throws ModuleException;

	/**
	 * <p>
	 * Conjunct the transition relation with the given condition.
	 * </p>
	 * 
	 * @param to_add
	 *            The transition to conjunct with the module's transitions.
	 * @throws ModuleException
	 *             If there was a problem with adding relation.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 * @see edu.wis.jtlv.env.module.Module#disjunctTrans(BDD)
	 */
	public abstract void conjunctTrans(BDD to_add) throws ModuleException;

	/**
	 * <p>
	 * Disjunct the transition relation with the given condition.
	 * </p>
	 * 
	 * @param to_add
	 *            The transition disjunct with to the module's transitions.
	 * @throws ModuleException
	 *             If there was a problem with adding relation.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 * @see edu.wis.jtlv.env.module.Module#conjunctTrans(BDD)
	 */
	public abstract void disjunctTrans(BDD to_add) throws ModuleException;

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Getters Facilities /////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Getter for all fields declared in this module.
	 * </p>
	 * 
	 * @return All fields declared in this module.
	 */
	public abstract ModuleBDDField[] getAllFields();

	/**
	 * <p>
	 * Getter for the primed variable of this module.
	 * </p>
	 * 
	 * @return The primed variables of this module.
	 */
	public abstract BDDVarSet modulePrimeVars();

	/**
	 * <p>
	 * Getter for the unprimed variable of this module.
	 * </p>
	 * 
	 * @return The unprimed variables of this module.
	 */
	public abstract BDDVarSet moduleUnprimeVars();

	/**
	 * <p>
	 * Getter for all, primed and unprimed variable of this module.
	 * </p>
	 * 
	 * @return The unprimed variables of this module.
	 */
	public BDDVarSet moduleVars() {
		return modulePrimeVars().union(moduleUnprimeVars());
	}

	/**
	 * <p>
	 * Getter for the initial states in the module.
	 * </p>
	 * 
	 * @return The initial states of the module.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#addInitial(BDD)
	 * @see edu.wis.jtlv.env.module.Module#setInitial(BDD)
	 */
	public abstract BDD initial();

	/**
	 * <p>
	 * Getter for the transition relation of the module.
	 * </p>
	 * 
	 * @return The transition relation of the module.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#disjunctTrans(BDD)
	 * @see edu.wis.jtlv.env.module.Module#conjunctTrans(BDD)
	 * @see edu.wis.jtlv.env.module.Module#idleStep()
	 */
	public abstract BDD trans();

	/**
	 * <p>
	 * Construct a BDD representing the idle transition of this module. If the
	 * process has a synchronously composed inner module, then it will also
	 * construct its idle step.
	 * </p>
	 * 
	 * @return the idle transition of this module.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#disjunctTrans(BDD)
	 * @see edu.wis.jtlv.env.module.Module#conjunctTrans(BDD)
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 */
	public abstract BDD idleStep();

	/**
	 * <p>
	 * Given a set of state, this procedure return all states which can lead in
	 * a single module step to these states.
	 * </p>
	 * 
	 * @param to
	 *            The set of state to be reach.
	 * @return The set of states which can lead in a single module step to the
	 *         given states.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#allPred(BDD)
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 * @see edu.wis.jtlv.env.module.Module#succ(BDD)
	 */
	public BDD pred(BDD to) {
		return Env.pred(this.trans(), to);
	}

	/**
	 * <p>
	 * Given a set of state, this procedure return all states which can lead in
	 * any number of module steps to these states.
	 * </p>
	 * 
	 * @param to
	 *            The set of state to be reach.
	 * @return The set of states which can lead in any number of module step to
	 *         the given states.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#pred(BDD)
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 * @see edu.wis.jtlv.env.module.Module#allSucc(BDD)
	 */
	public BDD allPred(BDD to) {
		return Env.allPred(this.trans(), to);
		// BDD res = to.id();
		// for (FixPoint<BDD> iter = new FixPoint<BDD>(); iter.advance(res);)
		// res = res.id().or(this.pred(res));
		// return res;
	}

	/**
	 * <p>
	 * This procedure return all states which the module can reach in a single
	 * step from given a set of state.
	 * </p>
	 * 
	 * @param from
	 *            The set of state to start from.
	 * @return The set of states which the module can reach in a single module
	 *         step from the given states.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#allSucc(BDD)
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 * @see edu.wis.jtlv.env.module.Module#pred(BDD)
	 */
	public BDD succ(BDD from) {
		return Env.succ(from, this.trans());
	}

	/**
	 * <p>
	 * This procedure return all states which the module can reach in any number
	 * of steps from given a set of state.
	 * </p>
	 * 
	 * @param from
	 *            The set of state to start from.
	 * @return The set of states which the module can reach in any number of
	 *         module steps from the given states.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#allPred(BDD)
	 * @see edu.wis.jtlv.env.module.Module#trans()
	 * @see edu.wis.jtlv.env.module.Module#succ(BDD)
	 */
	public BDD allSucc(BDD from) {
		return Env.allSucc(from, this.trans());
		// BDD res = from.id();
		// for (FixPoint<BDD> iter = new FixPoint<BDD>(); iter.advance(res);)
		// res = res.id().or(this.succ(res));
		// return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Composition Facilities /////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	/**
	 * <p>
	 * add synchronous composition to this module.
	 * </p>
	 * 
	 * @param inner
	 *            The module to compose this instance with.
	 */
	public abstract void syncComposition(Module inner);

	/**
	 * <p>
	 * add asynchronous composition to this module.
	 * </p>
	 * 
	 * @param inner
	 *            The module to compose this instance with.
	 */
	public abstract void asyncComposition(Module inner);

	/**
	 * <p>
	 * remove composition from this module.
	 * </p>
	 * 
	 * @param inner
	 *            The module to remove from this instance.
	 */
	public abstract void decompose(Module inner);

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Restrictions Facilities ////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Add a restriction to the initial states.
	 * </p>
	 * 
	 * @param temp_ini
	 *            The BDD to restrict with.
	 * @return The restriction index.
	 */
	public abstract int restrictIni(BDD temp_ini);

	/**
	 * <p>
	 * Remove a restriction from the initial states.
	 * </p>
	 * 
	 * @param id
	 *            The index of restriction to remove.
	 */
	public abstract void removeIniRestriction(int id);

	/**
	 * <p>
	 * Remove all restrictions from the initial states.
	 * </p>
	 * 
	 */
	public abstract void removeAllIniRestrictions();

	/**
	 * <p>
	 * Get all restrictions on the initial states.
	 * </p>
	 * 
	 * @return A vector of BDD restriction.
	 */
	public abstract Vector<BDD> getAllIniRestrictions();

	/**
	 * <p>
	 * Set all restrictions for the initial states.
	 * </p>
	 * 
	 * @param toSet
	 *            A vector of restrictions to set.
	 */
	public abstract void setAllIniRestrictions(Vector<BDD> toSet);

	/**
	 * <p>
	 * Add a restriction to the transitions.
	 * </p>
	 * 
	 * @param temp_trans
	 *            The BDD to restrict with.
	 * @return The restriction index.
	 */
	public abstract int restrictTrans(BDD temp_trans);

	/**
	 * <p>
	 * Remove a restriction from the transitions.
	 * </p>
	 * 
	 * @param id
	 *            The index of restriction to remove.
	 */
	public abstract void removeTransRestriction(int id);

	/**
	 * <p>
	 * Remove all restrictions from the transitions.
	 * </p>
	 * 
	 */
	public abstract void removeAllTransRestrictions();

	/**
	 * <p>
	 * Get all restrictions on the transitions.
	 * </p>
	 * 
	 * @return A vector of BDD restriction.
	 */
	public abstract Vector<BDD> getAllTransRestrictions();

	/**
	 * <p>
	 * Set all restrictions for the transitions.
	 * </p>
	 * 
	 * @param toSet
	 *            A vector of restrictions to set.
	 */
	public abstract void setAllTransRestrictions(Vector<BDD> toSet);

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Other Implementations //////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Calculate all reachable states form the initial states.
	 * </p>
	 * 
	 * @return The reachable states.
	 */
	public BDD reachable() {
		return this.allSucc(this.initial());
	}

	/**
	 * <p>
	 * Compute the shortest path from source to destination. <br>
	 * Algorithm from: Yonit Kesten, Amir Pnueli, Li-on Raviv, Elad Shahar,
	 * "Model Checking with Strong Fairness".
	 * </p>
	 * 
	 * @param source
	 *            The states to start look for path.
	 * @param dest
	 *            The states to reach in the path.
	 * @return An array representing a path, null if the algorithm could not
	 *         find a path.
	 */
	public BDD[] shortestPath(BDD source, BDD dest) {
		BDD statesPassed = Env.FALSE(), last = dest.id();
		Vector<BDD> blurredPath = new Vector<BDD>();
		// blurredPath.add(last);

		while (last.and(source).isZero()) { // found source
			blurredPath.add(last);
			statesPassed = statesPassed.id().or(last);
			last = this.pred(last).and(statesPassed.not());
			if (last.isZero()) // failed to find a path.
				return null;
		}
		blurredPath.add(last);

		BDD[] res = new BDD[blurredPath.size()];

		BDD blurredSt = blurredPath.elementAt(blurredPath.size() - 1);
		res[0] = source.and(blurredSt).satOne(this.moduleUnprimeVars(), false);
		for (int i = 1; i < res.length; i++) {
			blurredSt = blurredPath.elementAt(blurredPath.size() - i - 1);
			res[i] = succ(res[i - 1]).and(blurredSt).satOne(
					this.moduleUnprimeVars(), false);
		}

		return res;
	}

	/**
	 * <p>
	 * This is essentially algorithm "FEASIBLE", from the article: <br>
	 * Yonit Ketsen, Amir Pnueli, Li-on Raviv, Elad Shahar, "Model checking with
	 * strong fairness". This implementation is reduced to a module without any
	 * fairness requirements.
	 * </p>
	 * <p>
	 * The line numbers are the line numbers of that algorithm. Read the article
	 * for further details.
	 * </p>
	 * 
	 * 
	 * @return Returns a set of states which induce a graph which contains all
	 *         the fair SCS's reachable from an initial state.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#feasible()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#feasible()
	 * @see edu.wis.jtlv.env.module.Module#feasible2()
	 * 
	 */
	public BDD feasible() {
		// saving the previous restriction state.
		Vector<BDD> trans_restriction = this.getAllTransRestrictions();

		// Line 2
		BDD res = this.allSucc(this.initial());

		// returning to the previous restriction state.
		this.setAllTransRestrictions(trans_restriction);

		// Line 13
		return res;
	}

	/**
	 * <p>
	 * Version which allows justice and compassion requirement to refer to the
	 * next state.
	 * </p>
	 * 
	 * @return Returns a set of states which induce a graph which contains all
	 *         the fair SCS's reachable from an initial state.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#feasible()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#feasible2()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#feasible2()
	 */
	public BDD feasible2() {
		// saving the previous restriction state.
		Vector<BDD> trans_restriction = this.getAllTransRestrictions();

		BDD Total = this.trans();
		BDDVarSet primes = Env.globalPrimeVars();
		BDD res = Env.TRUE();
		this.restrictTrans(res.id());

		for (FixPoint<BDD> ires = new FixPoint<BDD>(); ires.advance(res);) {
			res = res.and(pred(res));
			res = allPred(res.and(Total.and(Env.prime(res)).exist(primes)));
		}

		// returning to the previous restriction state.
		this.setAllTransRestrictions(trans_restriction);

		return res;
	}

	/**
	 * <p>
	 * A state s in included in the returning result if responder module can
	 * force this module to reach a state in "to".<br>
	 * That is, regardless of how this module will move from the result, the
	 * responder module can choose an appropriate move into "to".
	 * </p>
	 * 
	 * @param responder
	 *            The module which moves (i.e. this is the responder).
	 * @param to
	 *            The states to reach.
	 * @return The states which can be controlled by this module.
	 * 
	 * @see edu.wis.jtlv.env.module.Module#allPred(BDD)
	 */
	public BDD yieldStates(Module responder, BDD to) {
		BDDVarSet responder_prime = responder.modulePrimeVars();
		BDDVarSet this_prime = this.modulePrimeVars();
		BDD exy = Env.prime(to).and(responder.trans()).exist(responder_prime);
		return this.trans().imp(exy).forAll(this_prime);
	}

	/**
	 * <p>
	 * A state s is included in the returning result if the this module can
	 * force the responder to reach a state in "to".<br>
	 * </p>
	 * 
	 * @param responder
	 *            The module to check for.
	 * @param to
	 *            The states to reach.
	 * @return The states which can be controlled by this module.
	 */
	public BDD controlStates(Module responder, BDD to) {
		BDDVarSet responder_prime = responder.modulePrimeVars();
		BDDVarSet this_prime = this.modulePrimeVars();
		BDD exy = Env.prime(to).and(responder.trans()).forAll(responder_prime);
		return this.trans().and(exy).exist(this_prime);
	}

	/**
	 * <p>
	 * Eliminate states from scc which have no successors within scc. scc is
	 * supposed to be a strongly connected component, however, it also contains
	 * chains of states which exit the scc, but are not in it. This procedure
	 * eliminates these chains.
	 * </p>
	 * 
	 * @param scc
	 *            The set of states to find scc for.
	 * @return The scc of the given set of states.
	 */
	public BDD elimSuccChains(BDD scc) {
		BDD res = scc.id();
		for (FixPoint<BDD> iscc = new FixPoint<BDD>(); iscc.advance(res);) {
			res = res.and(this.pred(res));
		}
		return res;
	}

	/**
	 * <p>
	 * Get the subset of states which has successor to the other given set of
	 * states.
	 * </p>
	 * 
	 * @param state
	 *            The first set of states.
	 * @param to
	 *            The second set of states.
	 * @return the subset of "state" which has successors to "to".
	 */
	public BDD hasSuccessorsTo(BDD state, BDD to) {
		return state.and(Env.prime(to)).and(this.trans()).exist(
				Env.globalPrimeVars());
	}

	// /**
	// * <p>
	// * Prime the given BDD with respect to the variable in this module. I.e.
	// * only variable from this module will be switched to their primed
	// version!!
	// * </p>
	// *
	// * @param unprime_set
	// * The BDD to prime.
	// * @return The BDD with the variables from this module switched to their
	// * primed version.
	// * @throws BDDException
	// * If trying to prime primed version of the variable.
	// *
	// * @see edu.wis.jtlv.env.Env#prime(BDD)
	// * @see edu.wis.jtlv.env.Env#prime(BDD, ModuleBDDField[])
	// * @see edu.wis.jtlv.env.module.FDSModule#unprime(BDD)
	// * @see edu.wis.jtlv.env.module.FDSModule#primeVars()
	// */
	// public BDD modulePrime(BDD unprime_set) throws BDDException {
	// return Env.prime(unprime_set, getAllFields());
	// }
	//
	// /**
	// * <p>
	// * Unprime the given BDD with respect to the variable in this module. I.e.
	// * only variable from this module will be switched to their unprimed
	// * version!!
	// * </p>
	// *
	// * @param prime_set
	// * The BDD to unprime.
	// * @return The BDD with the variables from this module switched to their
	// * unprimed version.
	// * @throws BDDException
	// * If trying to unprime unprimed version of the variable.
	// *
	// * @see edu.wis.jtlv.env.Env#unprime(BDD)
	// * @see edu.wis.jtlv.env.Env#unprime(BDD, ModuleBDDField[])
	// * @see edu.wis.jtlv.env.module.FDSModule#prime(BDD)
	// * @see edu.wis.jtlv.env.module.FDSModule#unprimeVars()
	// */
	// public BDD moduleUnprime(BDD prime_set) throws BDDException {
	// return Env.unprime(prime_set, getAllFields());
	// }

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Strings Facilities /////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Prepare a string describing the module, its variables, define, statement,
	 * etc.
	 * </p>
	 * 
	 * @return A string describing the module.
	 */
	@Override
	public abstract String toString();

	/**
	 * <p>
	 * The path leading to this module.
	 * </p>
	 * 
	 * @return The path leading to this module.
	 */
	public abstract String getPath();

	/**
	 * <p>
	 * Getter for the declared field name which holds this instance.
	 * </p>
	 * 
	 * @return The declared field name which holds this instance.
	 */
	public abstract String getName();

	/**
	 * <p>
	 * Getter for the instance string.
	 * </p>
	 * 
	 * @return The instance string.
	 */
	public abstract String getFullInstName();

}