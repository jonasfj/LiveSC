package edu.wis.jtlv.env.module;

import java.util.Vector;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.lib.FixPoint;
import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;

/**
 * <p>
 * A general interface for module with strong fairness (compassion).<br>
 * I.e. for every computation sigma, if sigma contains infinite many p, then it
 * also contains infinite many q states
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public abstract class ModuleWithStrongFairness extends ModuleWithWeakFairness {
	
	/**
	 * <p>
	 * Add strong (compassion) winning condition to the module.
	 * </p>
	 * 
	 * @param p
	 *            The p winning condition to add to the module.
	 * @param q
	 *            The q winning condition to add to the module.
	 * @throws ModuleException
	 *             If there was a problem with adding the condition.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#popLastCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#compassionNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#pCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#qCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allPCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allQCompassion()
	 */
	public abstract void addCompassion(BDD p, BDD q) throws ModuleException;

	/**
	 * <p>
	 * Removes the last compassion added to this module.
	 * </p>
	 * 
	 * @return An array of two BDDs with the removed compassion.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#addCompassion(BDD,
	 *      BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#compassionNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#pCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#qCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allPCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allQCompassion()
	 */
	public abstract BDD[] popLastCompassion();

	/**
	 * <p>
	 * Getter for the number of compassion condition defined in the module.
	 * </p>
	 * 
	 * @return The number of compassion condition defined in the module.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#addCompassion(BDD,
	 *      BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#popLastCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#pCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#qCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allPCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allQCompassion()
	 */
	public abstract int compassionNum();

	/**
	 * <p>
	 * Getter for a P part of the compassion condition defined at the given
	 * index in the module.
	 * </p>
	 * 
	 * @param i
	 *            The index of the compassion condition to return.
	 * @return The P part of the compassion condition defined defined at the
	 *         given index in the module.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#addCompassion(BDD,
	 *      BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#popLastCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#compassionNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#qCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allPCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allQCompassion()
	 */
	public abstract BDD pCompassionAt(int i);

	/**
	 * <p>
	 * Getter for a Q part of the compassion condition defined at the given
	 * index in the module.
	 * </p>
	 * 
	 * @param i
	 *            The index of the compassion condition to return.
	 * @return The Q part of the compassion condition defined defined at the
	 *         given index in the module.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#addCompassion(BDD,
	 *      BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#popLastCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#compassionNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#pCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allPCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allQCompassion()
	 */
	public abstract BDD qCompassionAt(int i);

	/**
	 * <p>
	 * Getter for all the p's, of the compassion requirements of the module.
	 * </p>
	 * 
	 * @return The p's part of the compassion requirements.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#addCompassion(BDD,
	 *      BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#popLastCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#compassionNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#pCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#qCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allQCompassion()
	 */
	public abstract BDD[] allPCompassion();

	/**
	 * <p>
	 * Getter for all the q's, of the compassion requirements of the module.
	 * </p>
	 * 
	 * @return The q's part of the compassion requirements.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#addCompassion(BDD,
	 *      BDD)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#popLastCompassion()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#compassionNum()
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#pCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#qCompassionAt(int)
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#allPCompassion()
	 */
	public abstract BDD[] allQCompassion();

	/**
	 * <p>
	 * This is essentially algorithm "FEASIBLE", from the article: <br>
	 * Yonit Ketsen, Amir Pnueli, Li-on Raviv, Elad Shahar, "Model checking with
	 * strong fairness".
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
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#feasible()
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
		boolean[] has_primed_cp = new boolean[this.compassionNum()];
		boolean[] has_primed_cq = new boolean[this.compassionNum()];
		BDDVarSet primes = Env.globalPrimeVars();
		for (int i = 0; i < has_primed_j.length; i++) {
			has_primed_j[i] = !this.justiceAt(i).biimp(
					this.justiceAt(i).exist(primes)).isUniverse();
		}
		for (int i = 0; i < has_primed_cp.length; i++) {
			has_primed_cp[i] = !this.pCompassionAt(i).biimp(
					this.pCompassionAt(i).exist(primes)).isUniverse();
			has_primed_cq[i] = !this.qCompassionAt(i).biimp(
					this.qCompassionAt(i).exist(primes)).isUniverse();
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

			// Lines 10-11
			// Ensure fulfillment of compassion requirements:
			// Remove from "res" all p-states which are not R^*-successors
			// of some q-state for some (p,q) \in C.
			for (int i = 0; i < this.compassionNum(); i++) {
				BDD localcp = has_primed_cp[i] ? this.hasSuccessorsTo(this
						.pCompassionAt(i), res) : this.pCompassionAt(i);
				BDD localcq = has_primed_cq[i] ? this.hasSuccessorsTo(this
						.qCompassionAt(i), res) : this.qCompassionAt(i);

				res = res.and(localcp.not()).or(this.allPred(res.and(localcq)));
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
	 * @see edu.wis.jtlv.env.module.ModuleWithStrongFairness#feasible()
	 * @see edu.wis.jtlv.env.module.Module#feasible2()
	 * @see edu.wis.jtlv.env.module.ModuleWithWeakFairness#feasible2()
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

		BDD[] cond_p = new BDD[this.compassionNum()];
		BDD[] cond_q = new BDD[this.compassionNum()];
		BDD[] loc_p = new BDD[this.compassionNum()];
		BDD[] loc_q = new BDD[this.compassionNum()];
		for (int i = 0; i < this.compassionNum(); i++) {
			cond_p[i] = pCompassionAt(i).biimp(pCompassionAt(i).exist(primes));
			if (!cond_p[i].isZero())
				loc_p[i] = pCompassionAt(i).and(Total);
			cond_q[i] = qCompassionAt(i).biimp(qCompassionAt(i).exist(primes));
			if (!cond_q[i].isZero())
				loc_q[i] = qCompassionAt(i).and(Total);
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

			for (int i = this.compassionNum() - 1; i >= 0; i--) {
				BDD local_p = this.pCompassionAt(i);
				if (!cond_p[i].isZero())
					local_p = loc_p[i].and(Env.prime(res)).exist(primes);
				BDD local_q = this.qCompassionAt(i);
				if (!cond_q[i].isZero())
					local_q = loc_q[i].and(Env.prime(res)).exist(primes);

				this.restrictTrans(res.id());
				res = res.and(local_p.not()).or(this.allPred(res.and(local_q)));
			}
		}

		// returning to the previous restriction state.
		this.setAllTransRestrictions(trans_restriction);

		return res;
	}
}
