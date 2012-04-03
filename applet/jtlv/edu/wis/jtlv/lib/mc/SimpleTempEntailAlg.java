package edu.wis.jtlv.lib.mc;

import java.util.Stack;
import java.util.Vector;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.Module;
import edu.wis.jtlv.env.module.ModuleWithStrongFairness;
import edu.wis.jtlv.env.module.ModuleWithWeakFairness;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.env.spec.SpecException;
import edu.wis.jtlv.lib.AlgExceptionI;
import edu.wis.jtlv.lib.AlgResultI;
import edu.wis.jtlv.lib.AlgResultPath;
import edu.wis.jtlv.lib.AlgResultString;

/**
 * <p>
 * An algorithm for performing the temp entailment check.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class SimpleTempEntailAlg extends ModelCheckAlgI {
	private Spec p;
	private Spec q;

	/**
	 * <p>
	 * A constructor for the temp entailment algorithm.
	 * <p>
	 * 
	 * @param design
	 *            The design to check the property for.
	 * @param p
	 *            The first property.
	 * @param q
	 *            The second property.
	 */
	public SimpleTempEntailAlg(Module design, Spec p, Spec q) {
		super(design);
		if ((p == null) | (q == null))
			throw new RuntimeException("Cannot check entail for a null"
					+ " specifications.");
		this.p = p;
		this.q = q;
	}

	/**
	 * <p>
	 * Does nothing.
	 * </p>
	 * 
	 * @throws AlgExceptionI
	 *             Never.
	 *             
	 * @return Nothing.
	 * 
	 * @see edu.wis.jtlv.lib.AlgI#preAlgorithm()
	 */
	@Override
	public AlgResultI preAlgorithm() throws AlgExceptionI {
		return null;
	}

	/**
	 * <p>
	 * Verify whether [](p -> <>q) is valid.
	 * </p>
	 * 
	 * @throws AlgExceptionI
	 *             If one of the properties is not a propositional spec, or if
	 *             failed to parse the BDD in the spec.
	 * 
	 * @return A counter example if the algorithm fails (i.e.
	 *         {@link edu.wis.jtlv.lib.AlgResultPath}), or a string with
	 *         "VALID" (i.e. {@link edu.wis.jtlv.lib.AlgResultString}).
	 * 
	 */
	@Override
	public AlgResultI doAlgorithm() throws AlgExceptionI {
		if (!p.isPropSpec())
			throw new ModelCheckAlgException("Cannot check entail for a non"
					+ " propositional specification: " + p);
		if (!q.isPropSpec())
			throw new ModelCheckAlgException("Cannot check entail for a non"
					+ " propositional specification: " + q);

		Module design = super.getDesign();
		System.out.println("checking temporal entailment : []((" + p.toString()
				+ ") -> <>(" + q.toString() + "))");

		Vector<BDD> transRestrictions = design.getAllTransRestrictions();

		BDD ass_p, ass_q;
		try {
			ass_q = q.toBDD();
			ass_p = p.toBDD();
		} catch (SpecException e) {
			// throwing this kind of exception.
			throw new ModelCheckAlgException(e.getMessage());
		}

		BDD reachable = design.reachable();

		// Restrict transition relation such that it cannot reach q.
		design.restrictTrans(ass_q.not().and(Env.prime(ass_q.not())));

		// Find all fair cycles which do not reach q.
		BDD cycles = design.feasible2();

		// Find all reachable p-states from which there is
		// a cycle that never reaches q.

		// Restrict transition relation such that it cannot reach q.
		// design.restrictTrans(ass_q.not().and(Env.prime(ass_q.not())));
		BDD pending = design.allPred(cycles).and(ass_p).and(reachable);
		design.setAllTransRestrictions(transRestrictions);

		if (!pending.isZero()) {
			BDD[] ce = extractTempEntailWithness(pending, ass_q, cycles);
			design.setAllTransRestrictions(transRestrictions);
			return new AlgResultPath(false, ce);
		}

		design.setAllTransRestrictions(transRestrictions);
		// else - everything is OK.
		return new AlgResultString(true, "*** Property is VALID ***");
	}

	private BDD[] extractTempEntailWithness(BDD pending, BDD ass_q, BDD cycles) {
		Module design = this.getDesign();
		Vector<BDD> transRestrictions = design.getAllTransRestrictions();

		// Initialize array.
		Stack<BDD> prefix_path = new Stack<BDD>();

		// Find path from initial state, to a p-state of "pending".
		BDD[] ini2pend = design.shortestPath(design.initial(), pending);
		for (int i = 0; i < ini2pend.length; i++)
			prefix_path.push(ini2pend[i]);

		design.restrictTrans(ass_q.not().and(Env.prime(ass_q.not())));

		// Continue path from the p-state to the start of a fair cycle
		// which never reaches q.
		BDD[] top2cycles = design.shortestPath(prefix_path.peek(), cycles);
		for (int i = 1; i < top2cycles.length; i++)
			prefix_path.push(top2cycles[i]);

		// Limit the transition system to not exit the cycles.
		design.restrictTrans(cycles.and(Env.prime(cycles)));

		// Find state, _s, such that it belongs to a terminal cycle.
		// This cycle is guaranteed to be fair.
		BDD _s = prefix_path.peek();
		BDD temp = design.allSucc(_s).and(design.allPred(_s).not());
		while (!temp.isZero()) {
			_s = temp.satOne(design.moduleUnprimeVars(), false);
			temp = design.allSucc(_s).and(design.allPred(_s).not());
		}

		// Extend path to reach that state.
		BDD[] top2_s = design.shortestPath(prefix_path.peek(), _s);
		for (int i = 1; i < top2_s.length; i++)
			prefix_path.push(top2_s[i]);

		// the last of prefix will be added to the period.
		_s = prefix_path.pop();
		// ////////////////////
		// Find period.
		Stack<BDD> period_path = new Stack<BDD>();
		period_path.push(_s);
		// Vector<BDD> transRestrictions2 = design.getAllTransRestrictions();
		// design.setAllTransRestrictions(transRestrictions);
		BDD _sn = design.succ(_s).satOne(design.moduleUnprimeVars(), false);
		// design.setAllTransRestrictions(transRestrictions2);
		period_path.push(_sn);

		BDD final_loop = design.allSucc(_s);

		if (design instanceof ModuleWithWeakFairness) {
			ModuleWithWeakFairness weakDes = (ModuleWithWeakFairness) design;
			// Thread path through all justice.
			for (int i = 0; i < weakDes.justiceNum(); i++) {
				for (BDD bdd : period_path)
					if (!bdd.and(weakDes.justiceAt(i)).isZero())
						continue; // if found then skipping
				// otherwise adding a path which will path at this justice.
				BDD[] top2FJ = design.shortestPath(period_path.peek(),
						final_loop.and(weakDes.justiceAt(i)));
				for (int j = 1; j < top2FJ.length; j++)
					period_path.push(top2FJ[j]);
			}
		}

		if (design instanceof ModuleWithStrongFairness) {
			ModuleWithStrongFairness strongDes = (ModuleWithStrongFairness) design;
			// Thread path through all compassion.
			for (int i = 0; i < strongDes.compassionNum(); i++) {
				if (!final_loop.and(strongDes.pCompassionAt(i)).isZero()) {
					for (BDD bdd : period_path)
						if (!bdd.and(strongDes.qCompassionAt(i)).isZero())
							continue; // if found then skipping
					// adding a path which will path at this q compassion.
					BDD goal = final_loop.and(strongDes.qCompassionAt(i));
					if (!goal.isZero()) {
						BDD[] top2goal = design.shortestPath(
								period_path.peek(), goal);
						for (int j = 1; j < top2goal.length; j++)
							period_path.push(top2goal[j]);
					}
				}
			}
		}

		// Close cycle
		BDD[] top2_s2 = design.shortestPath(period_path.peek(), _s);
		for (int i = 1; i < top2_s2.length; i++)
			period_path.push(top2_s2[i]);

		design.setAllTransRestrictions(transRestrictions);

		// preparing the result.
		for (int i = 0; i < period_path.size(); i++)
			prefix_path.push(period_path.elementAt(i));

		BDD[] res = new BDD[prefix_path.size()];
		prefix_path.toArray(res);

		return res;
	}

	/**
	 * <p>
	 * Does nothing.
	 * </p>
	 * 
	 * @throws AlgExceptionI
	 *             Never.
	 *             
	 * @return Nothing.
	 * 
	 * @see edu.wis.jtlv.lib.AlgI#postAlgorithm()
	 */
	@Override
	public AlgResultI postAlgorithm() throws AlgExceptionI {
		return null;
	}

}
