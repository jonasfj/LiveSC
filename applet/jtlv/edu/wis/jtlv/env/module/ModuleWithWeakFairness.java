package edu.wis.jtlv.env.module;

import java.util.Vector;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.lib.FixPoint;
import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;

/**
 * <p>
 * A general interface for module with weak fairness (justice).<br>
 * I.e. every computation sigma contains infinite many justice states.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public abstract class ModuleWithWeakFairness extends Module {

	/**
	 * <p>
	 * Add weak (justice) winning condition to the module.
	 * </p>
	 * 
	 * @param to_add
	 *            The winning condition to add to the module.
	 * @throws ModuleException
	 *             If there was a problem with adding the condition.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#justiceNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#justiceAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#popLastJustice()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#allJustice()
	 */
	public abstract void addJustice(BDD to_add) throws ModuleException;

	/**
	 * <p>
	 * Removes the last justice added to this module.
	 * </p>
	 * 
	 * @return The removed justice.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#addJustice(BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#justiceNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#justiceAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#allJustice()
	 */
	public abstract BDD popLastJustice();

	/**
	 * <p>
	 * Getter for the number of justice condition defined in the module.
	 * </p>
	 * 
	 * @return The number of justice condition defined in the module.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#addJustice(BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#justiceAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#popLastJustice()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#allJustice()
	 */
	public abstract int justiceNum();

	/**
	 * <p>
	 * Getter for a justice condition defined at the given index in the module.
	 * </p>
	 * 
	 * @param i
	 *            The index of the justice condition to return.
	 * @return The justice condition defined defined at the given index in the
	 *         module.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#addJustice(BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#justiceNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#popLastJustice()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#allJustice()
	 */
	public abstract BDD justiceAt(int i);

	/**
	 * <p>
	 * Getter for all the justice requirements of the module.
	 * </p>
	 * 
	 * @return The justice requirements.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#addJustice(BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#justiceNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#justiceAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#popLastJustice()
	 */
	public abstract BDD[] allJustice();

	/**
	 * <p>
	 * This is essentially algorithm "FEASIBLE", from the article: <br>
	 * Yonit Ketsen, Amir Pnueli, Li-on Raviv, Elad Shahar, "Model checking with
	 * strong fairness". This implementation is reduced to a module with only
	 * weak fairness requirements.
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
	 * @see edu.wis.jtlv.env.module.Module#feasible()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#feasible()
	 */
	public BDD feasible() {
		// saving the previous restriction state.
		Vector<BDD> trans_restriction = this.getAllTransRestrictions();

		// Line 2
		BDD res = this.allSucc(this.initial());
		BDD reachable = res.id();

		// Determine whether fairness conditions refer to primed variables.
		// If so, they are treated differently.
		boolean[] has_primed_j = new boolean[this.justiceNum()];
		BDDVarSet primes = Env.globalPrimeVars();
		for (int i = 0; i < has_primed_j.length; i++) {
			has_primed_j[i] = !this.justiceAt(i).biimp(
					this.justiceAt(i).exist(primes)).isUniverse();
		}

		// Line 3
		this.restrictTrans(res.id());

		// Lines 4-11
		for (FixPoint<BDD> ires = new FixPoint<BDD>(); ires.advance(res);) {
			// Lines 6-7
			// Eliminate states from res which have no successors within res.
			res = this.elimSuccChains(res);
			this.restrictTrans(res.id());

			// Lines 8-9
			// Ensure fulfillment of justice requirements.
			// Remove from "res" all states which are not R^*-successors
			// of some justice state.
			for (int i = this.justiceNum() - 1; i >= 0; i--) {
				BDD localj = has_primed_j[i] ? this.hasSuccessorsTo(this
						.justiceAt(i), res) : this.justiceAt(i);

				res = this.allPred(res.and(localj));
				this.restrictTrans(res.id());
			}
		}
		this.removeAllTransRestrictions();

		// Line 12
		this.restrictTrans(reachable);
		res = this.allPred(res);
		this.removeAllTransRestrictions();

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
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#feasible()
	 * @see edu.wis.jtlv.env.module.Module#feasible2()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#feasible2()
	 */
	public BDD feasible2() {
		// saving the previous restriction state.
		Vector<BDD> trans_restriction = this.getAllTransRestrictions();

		BDD Total = this.trans();

		BDD[] cond_j = new BDD[this.justiceNum()];
		BDD[] loc_j = new BDD[this.justiceNum()];
		BDDVarSet primes = Env.globalPrimeVars();
		for (int i = 0; i < this.justiceNum(); i++) {
			cond_j[i] = justiceAt(i).biimp(justiceAt(i).exist(primes));
			if (!cond_j[i].isZero())
				loc_j[i] = justiceAt(i).and(Total);
		}

		BDD res = Env.TRUE();
		this.restrictTrans(res.id());

		for (FixPoint<BDD> ires = new FixPoint<BDD>(); ires.advance(res);) {
			res = res.and(this.pred(res));
			if (this.justiceNum() == 0)
				res = this.allPred(res.and(Total.and(Env.prime(res)).exist(
						primes)));
			for (int i = this.justiceNum() - 1; i >= 0; i--) {
				BDD local_j = this.justiceAt(i);
				if (!cond_j[i].isZero())
					local_j = loc_j[i].and(Env.prime(res)).exist(primes);
				this.restrictTrans(res.id());
				res = this.allPred(res.and(local_j));
			}
		}

		// returning to the previous restriction state.
		this.setAllTransRestrictions(trans_restriction);

		return res;
	}
}
