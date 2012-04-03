package edu.wis.jtlv.lib.mc.tl;

import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.Module;
import edu.wis.jtlv.env.module.ModuleWithStrongFairness;
import edu.wis.jtlv.env.module.ModuleWithWeakFairness;
import edu.wis.jtlv.env.module.SMVModule;
import edu.wis.jtlv.env.spec.Operator;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.env.spec.SpecExp;
import edu.wis.jtlv.lib.AlgExceptionI;
import edu.wis.jtlv.lib.AlgResultI;
import edu.wis.jtlv.lib.AlgResultPath;
import edu.wis.jtlv.lib.AlgResultString;
import edu.wis.jtlv.lib.mc.ModelCheckAlgI;

/**
 * <p>
 * Check validity of ltl formula on a given design (or without one).
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public class LTLValidAlg extends ModelCheckAlgI {
	private Spec property;
	private LTLTester builder;

	/**
	 * <p>
	 * A constructor for checking a property without a design.
	 * </p>
	 * 
	 * @param property
	 *            The property to check.
	 */
	public LTLValidAlg(Spec property) {
		super();
		this.property = property;
	}

	/**
	 * <p>
	 * A constructor for checking a property on a design.
	 * </p>
	 * 
	 * @param design
	 *            The design to check the property for.
	 * @param property
	 *            The property to check.
	 */
	public LTLValidAlg(SMVModule design, Spec property) {
		super(design);
		this.property = property;
	}

	/**
	 * <p>
	 * Preparing the LTL tester.
	 * </p>
	 * 
	 * @throws AlgExceptionI
	 *             If The specification is not an LTL specification.
	 * 
	 * @return Nothing.
	 * 
	 * @see edu.wis.jtlv.lib.AlgI#preAlgorithm()
	 */
	@Override
	public AlgResultI preAlgorithm() throws AlgExceptionI {
		Spec negp = new SpecExp(Operator.NOT, property);
		builder = new LTLTester(negp, true);
		return null;
	}

	/**
	 * <p>
	 * Check validity for a given LTL property.
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
		System.out.println("checking the validity of: " + property);
		BDD tester_initials = builder.getSpec2BDD(property).not();

		// I'm not sure if this is relevant.
		BDDVarSet visibleVars = getRelevantVars(getDesign(), property);

		return verify(tester_initials, builder.getTester(), visibleVars);
	}

	private static BDDVarSet getRelevantVars(Module m, Spec p) {
		// p.releventVars();
		BDDVarSet vars = Env.getEmptySet();
		if (p != null) {
			vars = vars.id().union(p.releventVars());
		}
		if (m != null) {
			// these are usually too much...
			// vars = vars.id().union(m.moduleUnprimeVars());

			// // removing running
			// ModuleBDDField r = m.getVar("running", false);
			// if (r != null) {
			// BDDVarSet rmR = Env.globalPrimeVarsMinus(r.other().support());
			// BDDVarSet rmPR = Env.globalUnprimeVarsMinus(r.support());
			// vars = Env.intersect(vars, rmR.union(rmPR));
			// }

			// fairness variables are important to illustrate feasibility.
			if (m instanceof ModuleWithWeakFairness) {
				ModuleWithStrongFairness weakM = (ModuleWithStrongFairness) m;
				for (int i = 0; i < weakM.justiceNum(); i++) {
					vars = vars.id().union(weakM.justiceAt(i).support());
				}
			}
			if (m instanceof ModuleWithStrongFairness) {
				ModuleWithStrongFairness strongM = (ModuleWithStrongFairness) m;
				for (int i = 0; i < strongM.compassionNum(); i++) {
					vars = vars.id().union(strongM.pCompassionAt(i).support());
					vars = vars.id().union(strongM.qCompassionAt(i).support());
				}
			}
		}
		return vars;
	}

	/**
	 * <p>
	 * The main procedure for verifying.
	 * </p>
	 * 
	 * @param initial_condition
	 * @param designWithTester
	 * @param relevantVars
	 */
	private static AlgResultI verify(BDD initial_condition,
			Module designWithTester, BDDVarSet relevantVars) {
		// saving to the previous restriction state
		Vector<BDD> ini_restrictions = designWithTester.getAllIniRestrictions();

		designWithTester.restrictIni(initial_condition);
		BDD feas = designWithTester.feasible();
		// the initial_condition seems redundant
		if (!feas.and(designWithTester.initial()).and(initial_condition)
				.isZero()) {

			BDD[] example = extractWithness(feas, designWithTester,
					relevantVars);
			// ModelCheckAlgCounterExampleException cee = new
			// ModelCheckAlgCounterExampleException(
			// "\n*** Property is NOT VALID ***", example);

			// returning to the previous restriction state
			designWithTester.setAllIniRestrictions(ini_restrictions);
			return new AlgResultPath(false, example);
		}

		// returning to the previous restriction state
		designWithTester.setAllIniRestrictions(ini_restrictions);
		return new AlgResultString(true, "*** Property is VALID ***");
	}

	/**
	 * <p>
	 * This is essentially algorithm "Witness", from the article: Yonit Ketsen,
	 * Amir Pnueli, Li-on Raviv, Elad Shahar, "Model checking with strong
	 * fairness".<br>
	 * The line numbers are the line numbers of that algorithm. Read the article
	 * for further details.
	 * </p>
	 * 
	 * @param feasible
	 * @param designWithTester
	 * @return
	 */
	private static BDD[] extractWithness(BDD feasible, Module designWithTester,
			BDDVarSet relevantVars) {
		BDD temp, fulfill;
		// saving to the previous restriction state
		Vector<BDD> trans_restrictions = designWithTester
				.getAllTransRestrictions();

		// Lines 1-2 are handled by the caller. ("verify")

		// Line 3
		designWithTester.restrictTrans(feasible.and(Env.prime(feasible)));

		// Line 4
		BDD s = feasible.satOne(designWithTester.moduleUnprimeVars(), false);
		// BDD s = feasible.satOne();

		// Lines 5-6
		while (true) {
			temp = designWithTester.allSucc(s).and(
					designWithTester.allPred(s).not());
			if (!temp.isZero())
				s = temp.satOne(designWithTester.moduleUnprimeVars(), false);
			// s = temp.satOne();
			else
				break;
		}
		// Lines 5-6 : better version.
		// temp = tester.allSucc(s).and(tester.allPred(s).not());
		// while (!temp.isZero()){
		// s = temp.satOne(tester.moduleUnprimeVars(), false);
		// temp = tester.allSucc(s).and(tester.allPred(s).not());
		// }

		// Line 7: Compute MSCS containing s.
		BDD feas = designWithTester.allSucc(s);

		// Line 9
		// Find prefix - shortest path from initial state to subgraph feas.
		designWithTester.removeAllTransRestrictions();
		Vector<BDD> prefix = new Vector<BDD>();
		BDD[] path = designWithTester.shortestPath(designWithTester.initial(),
				feas);
		for (int i = 0; i < path.length; i++)
			prefix.add(path[i]);

		// //// Calculate "_period".

		// Line 8: This has to come after line 9, because the way TS.tlv
		// implements restriction.
		designWithTester.restrictTrans(feas.and(Env.prime(feas)));

		// Line 10
		Vector<BDD> period = new Vector<BDD>();
		period.add(prefix.lastElement());

		// Since the last item of the prefix is the first item of
		// the period we don't need to print the last item of the prefix.
		temp = prefix.remove(prefix.size() - 1);

		// Lines 11-13
		if (designWithTester instanceof ModuleWithWeakFairness) {
			ModuleWithWeakFairness weakDes = (ModuleWithWeakFairness) designWithTester;
			for (int i = 0; i < weakDes.justiceNum(); i++) {
				// Line 12, check if j[i] already satisfied
				fulfill = Env.FALSE();
				for (int j = 0; j < period.size(); j++) {
					fulfill = period.elementAt(j).and(weakDes.justiceAt(i))
							.satOne(weakDes.moduleUnprimeVars(), false);
					// fulfill =
					// period.elementAt(j).and(design.justiceAt(i)).satOne();
					if (!fulfill.isZero())
						break;
				}
				// Line 13
				if (fulfill.isZero()) {
					BDD from = period.lastElement();
					BDD to = feas.and(weakDes.justiceAt(i));
					path = weakDes.shortestPath(from, to);
					// eliminate the edge since from is already in period
					for (int j = 1; j < path.length; j++)
						period.add(path[j]);
				}
			}
		}
		// Lines 14-16
		if (designWithTester instanceof ModuleWithStrongFairness) {
			ModuleWithStrongFairness strongDes = (ModuleWithStrongFairness) designWithTester;
			for (int i = 0; i < strongDes.compassionNum(); i++) {
				if (!feas.and(strongDes.pCompassionAt(i)).isZero()) {
					// check if C requirement i is already satisfied
					fulfill = Env.FALSE();
					for (int j = 0; j < period.size(); j++) {
						fulfill = period.elementAt(j).and(
								strongDes.qCompassionAt(i)).satOne(
								strongDes.moduleUnprimeVars(), false);
						// fulfill =
						// period.elementAt(j).and(design.qCompassionAt(i)).satOne();
						if (!fulfill.isZero())
							break;
					}

					if (fulfill.isZero()) {
						BDD from = period.lastElement();
						BDD to = feas.and(strongDes.qCompassionAt(i));
						path = strongDes.shortestPath(from, to);
						// eliminate the edge since from is already in period
						for (int j = 1; j < path.length; j++)
							period.add(path[j]);
					}
				}
			}
		}

		//
		// Close cycle
		//

		// A period of length 1 may be fair, but it might be the case that
		// period[1] is not a successor of itself. The routine path
		// will add nothing. To solve this
		// case we add another state to _period, now it will be OK since
		// period[1] and period[n] will not be equal.

		// Line 17, but modified
		if (!period.firstElement().and(period.lastElement()).isZero()) {
			// The first and last states are already equal, so we do not
			// need to extend them to complete a cycle, unless period is
			// a degenerate case of length = 1, which is not a successor of
			// self.
			if (period.size() == 1) {
				// Check if _period[1] is a successor of itself.
				if (period.firstElement().and(
						designWithTester.succ(period.firstElement())).isZero()) {
					// period[1] is not a successor of itself: Add state to
					// period.
					period
							.add(designWithTester
									.succ(period.firstElement())
									.satOne(
											designWithTester
													.moduleUnprimeVars(), false));
					// period.add(design.succ(period.firstElement()).satOne());

					// Close cycle.
					BDD from = period.lastElement();
					BDD to = period.firstElement();
					path = designWithTester.shortestPath(from, to);
					// eliminate the edges since from and to are already in
					// period
					for (int i = 1; i < path.length - 1; i++)
						period.add(path[i]);
				}
			}
		} else {
			BDD from = period.lastElement();
			BDD to = period.firstElement();
			path = designWithTester.shortestPath(from, to);
			// eliminate the edges since from and to are already in period
			for (int i = 1; i < path.length - 1; i++)
				period.add(path[i]);
		}

		// Yaniv - the last one is for closing the cycle. He won't be printed.
		period.add(period.firstElement());

		// There is no need to have the last state of the period
		// in the counterexample since it already appears in _period[1]
		// if (period.size() > 1)
		// temp = period.remove(period.size() -1);

		// Copy prefix and period.
		prefix.addAll(period);
		BDD[] returned_path = new BDD[prefix.size()];
		prefix.toArray(returned_path);

		// Strip auxiliary variables introduced by tester.
		if (relevantVars != null) {
			BDDVarSet extraVars = Env.globalVarsMinus(relevantVars);
			// BDDVarSet extraVars = Env.globalVarsMinus(relevantVars);
			for (int i = 0; i < returned_path.length; i++) {
				returned_path[i] = returned_path[i].satOne(relevantVars, false)
						.exist(extraVars);
			}
		}

		// returning to the previous restriction state
		designWithTester.setAllTransRestrictions(trans_restrictions);

		return returned_path;
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
