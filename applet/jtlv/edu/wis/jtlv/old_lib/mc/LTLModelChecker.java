package edu.wis.jtlv.old_lib.mc;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDException;
import net.sf.javabdd.BDDVarSet;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.ModuleBDDField;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;
import edu.wis.jtlv.env.spec.Operator;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.env.spec.SpecBDD;
import edu.wis.jtlv.env.spec.SpecExp;

/**
 * <p>
 * A wrapper to a SMVModule which knows how to check LTL properties for the
 * given module.
 * </p>
 * 
 * <p>
 * The main interesting routines for EXTERNAL usage are:<br>
 * {@link LTLModelChecker#valid(Spec)} - Check validity of tl formula.<br>
 * 
 * {@link LTLModelChecker#modelCheck(Spec)} - Model check using a temporal
 * formula.<br>
 * 
 * modelCheckSeq(Spec) - Model check sequential program ( halted executions are
 * extended indefinitely by adding the idle transition )<br>
 * 
 * {@link LTLModelChecker#modelCheckTester(SMVModule)} - Model check using a
 * tester which is provided by the user in the<br>
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public class LTLModelChecker extends ModelChecker {

	public LTLModelChecker(SMVModule design) throws ModelCheckException {
		this(design, false);
	}

	public LTLModelChecker(SMVModule design, boolean removeRunningVar)
			throws ModelCheckException {
		super(design, removeRunningVar);
	}

	/**
	 * <p>
	 * Given a specification \phi (as a formula in temporal logic) we want to
	 * decide whether \phi is valid over finite state program P , i.e. whether
	 * all the computations of the design satisfy \phi. This variant of
	 * implementation, prints the results to the standard streams.
	 * </p>
	 * 
	 * @param property
	 *            The property to check.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#modelCheck(Spec)
	 */
	public void modelCheckStandardOutput(Spec property) {
		System.out.println("model checking property: " + property);
		try {
			this.modelCheck(property);
		} catch (ModelCheckException mce) {
			System.err.println(mce.toString());
			return;
		}
		// else - everything is OK.
		System.out.println("*** Property is VALID ***");
	}

	/**
	 * <p>
	 * Given a specification \phi (as a formula in temporal logic) we want to
	 * decide whether \phi is valid over finite state program P , i.e. whether
	 * all the computations of the design satisfy \phi.
	 * </p>
	 * 
	 * @param property
	 *            The property to check.
	 * @throws ModelCheckException
	 *             When the method is initiated with other then LTL property.
	 * @throws CounterExampleException
	 *             When the property is not valid, a counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#modelCheckStandardOutput(Spec)
	 */
	public void modelCheck(Spec property) throws ModelCheckException,
			CounterExampleException {
		Spec negp = new SpecExp(Operator.NOT, property);
		LTLTesterBuilder builder = new LTLTesterBuilder(negp, true);

		BDD tester_initials = builder.getSpec2BDD(property).not();

		BDDVarSet visibleVars = getRelevantVars(getDesign(), property);
		getDesign().syncComposition(builder.getTester());
		try {
			verify(tester_initials, getDesign(), visibleVars);
			// verify(tester_initials, this.design, null);
		} catch (CounterExampleException mce) {
			throw mce;
		} finally {
			// getDesign().weakDecompose(builder.getTester());
			getDesign().decompose(builder.getTester());
		}
	}

	public boolean modelCheckWithNoCounterExample(Spec property) {
		Spec negp = new SpecExp(Operator.NOT, property);
		LTLTesterBuilder builder;
		try {
			builder = new LTLTesterBuilder(negp, true);
			getDesign().syncComposition(builder.getTester());
			boolean res = checkVerify(builder.getSpec2BDD(property).not(),
					getDesign());
			// getDesign().weakDecompose(builder.getTester());
			getDesign().decompose(builder.getTester());
			return res;
		} catch (ModelCheckException e) {
			return false;
		}
	}

	/**
	 * <p>
	 * To compose a tester with the design, and perform model checking. If the
	 * composition is feasible then a counter example is thrown. This variant of
	 * implementation, prints the results to the standard streams.
	 * </p>
	 * 
	 * @param user_tester
	 *            The tester to compose.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#modelCheckTester(SMVModule)
	 */
	public void modelCheckTesterStandardOutput(SMVModule user_tester) {
		System.out.println("model checking using tester "
				+ user_tester.getFullInstName());
		try {
			this.modelCheckTester(user_tester);
		} catch (ModelCheckException mce) {
			System.err.println(mce.toString());
			return;
		}
		// else - everything is OK.
		System.out.println("*** Property is VALID ***");
	}

	/**
	 * <p>
	 * To compose a tester with the design, and perform model checking. If the
	 * composition is feasible then a counter example is thrown.
	 * </p>
	 * 
	 * @param user_tester
	 *            The tester to compose.
	 * @throws CounterExampleException
	 *             When the property is not valid, a counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#modelCheckTesterStandardOutput(SMVModule)
	 */
	public void modelCheckTester(SMVModule user_tester)
			throws CounterExampleException {
		BDD tester_initials = user_tester.initial();
		try {
			user_tester.setInitial(Env.TRUE());
		} catch (ModuleException e) { // cannot be.
			e.printStackTrace();
		}

		BDDVarSet visibleVars = getRelevantVars(getDesign(), null);
		getDesign().syncComposition(user_tester);
		try {
			verify(tester_initials, getDesign(), visibleVars);
		} catch (CounterExampleException mce) {
			throw mce;
		} finally {
			// getDesign().weakDecompose(user_tester);
			getDesign().decompose(user_tester);
			try {
				user_tester.setInitial(tester_initials);
			} catch (ModuleException e) { // cannot be.
				e.printStackTrace();
			}
		}
	}

	/**
	 * <p>
	 * Check validity for a given LTL property. This variant of implementation,
	 * prints the results to the standard streams.
	 * </p>
	 * 
	 * @param property
	 *            The property to check validity for.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#valid(Spec)
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#standAloneValid(Spec)
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#standAloneValidStarndardOutput(Spec)
	 */
	public void validStarndardOutput(Spec property) {
		System.out.println("checking the validity of: " + property);
		try {
			this.valid(property);
		} catch (ModelCheckException mce) {
			System.err.println(mce.toString());
			return;
		}
		// else - everything is OK.
		System.out.println("*** Property is VALID ***");
	}

	/**
	 * <p>
	 * Check validity for a given LTL property.
	 * </p>
	 * 
	 * @param property
	 *            The property to check validity for.
	 * @throws ModelCheckException
	 *             When the method is initiated with other then LTL property.
	 * @throws CounterExampleException
	 *             When the property is not valid, a counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#validStarndardOutput(Spec)
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#standAloneValid(Spec)
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#standAloneValidStarndardOutput(Spec)
	 */
	public void valid(Spec property) throws ModelCheckException {
		Spec negp = new SpecExp(Operator.NOT, property);
		LTLTesterBuilder builder = new LTLTesterBuilder(negp, true);

		BDD tester_initials = builder.getSpec2BDD(property).not();

		// I'm not sure if this is relevant.
		BDDVarSet visibleVars = getRelevantVars(getDesign(), property);
		verify(tester_initials, builder.getTester(), visibleVars);
	}

	/**
	 * <p>
	 * Check validity for a given LTL property without any design attached. This
	 * variant of implementation, prints the results to the standard streams.
	 * </p>
	 * 
	 * @param property
	 *            The property to check validity for.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#valid(Spec)
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#validStarndardOutput(Spec)
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#standAloneValid(Spec)
	 */
	public static void standAloneValidStarndardOutput(Spec property) {
		System.out.println("checking the validity of: " + property);
		try {
			standAloneValid(property);
		} catch (ModelCheckException mce) {
			System.err.println(mce.toString());
			return;
		}
		// else - everything is OK.
		System.out.println("*** Property is VALID ***");
	}

	/**
	 * <p>
	 * Check validity for a given LTL property without any design attached.
	 * </p>
	 * 
	 * @param property
	 *            The property to check validity for.
	 * @throws ModelCheckException
	 *             When the method is initiated with other then LTL property.
	 * @throws CounterExampleException
	 *             When the property is not valid, a counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#valid(Spec)
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#validStarndardOutput(Spec)
	 * @see edu.wis.jtlv.old_lib.mc.LTLModelChecker#standAloneValidStarndardOutput(Spec)
	 */
	public static void standAloneValid(Spec property)
			throws ModelCheckException {
		Spec negp = new SpecExp(Operator.NOT, property);
		LTLTesterBuilder builder = new LTLTesterBuilder(negp, true);
		// /////////////////////////////////////////////////////
		// temporary for debugging.
		// builder.getTester().setFullPrintingMode(true);
		// /////////////////////////////////////////////////////

		BDD tester_initials = builder.getSpec2BDD(property).not();

		BDDVarSet visibleVars = getRelevantVars(null, property);
		verify(tester_initials, builder.getTester(), visibleVars);
	}

	private static BDDVarSet getRelevantVars(SMVModule m, Spec p) {
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
			for (int i = 0; i < m.justiceNum(); i++) {
				vars = vars.id().union(m.justiceAt(i).support());
			}
			for (int i = 0; i < m.compassionNum(); i++) {
				vars = vars.id().union(m.pCompassionAt(i).support());
				vars = vars.id().union(m.qCompassionAt(i).support());
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
	 * @throws ModelCheckException
	 */
	private static void verify(BDD initial_condition,
			SMVModule designWithTester, BDDVarSet relevantVars)
			throws CounterExampleException {
		// saving to the previous restriction state
		Vector<BDD> ini_restrictions = designWithTester.getAllIniRestrictions();

		designWithTester.restrictIni(initial_condition);
		BDD feas = designWithTester.feasible();
		// the initial_condition seems redundant
		if (!feas.and(designWithTester.initial()).and(initial_condition)
				.isZero()) {

			BDD[] example = extractWithness(feas, designWithTester,
					relevantVars);
			CounterExampleException cee = new CounterExampleException(
					"\n*** Property is NOT VALID ***", example);

			// returning to the previous restriction state
			designWithTester.setAllIniRestrictions(ini_restrictions);

			throw cee;
		}

		// returning to the previous restriction state
		designWithTester.setAllIniRestrictions(ini_restrictions);
	}

	private boolean checkVerify(BDD initial_condition,
			SMVModule designWithTester) {
		// saving to the previous restriction state
		Vector<BDD> ini_restrictions = designWithTester.getAllIniRestrictions();

		designWithTester.restrictIni(initial_condition);
		BDD feas = designWithTester.feasible();
		// the initial_condition seems redundant
		if (!feas.and(designWithTester.initial()).and(initial_condition)
				.isZero()) {
			// returning to the previous restriction state
			designWithTester.setAllIniRestrictions(ini_restrictions);
			return false;
		}
		// returning to the previous restriction state
		designWithTester.setAllIniRestrictions(ini_restrictions);
		return true;
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
	private static BDD[] extractWithness(BDD feasible,
			SMVModule designWithTester, BDDVarSet relevantVars) {
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
		for (int i = 0; i < designWithTester.justiceNum(); i++) {
			// Line 12, check if j[i] already satisfied
			fulfill = Env.FALSE();
			for (int j = 0; j < period.size(); j++) {
				fulfill = period.elementAt(j)
						.and(designWithTester.justiceAt(i)).satOne(
								designWithTester.moduleUnprimeVars(), false);
				// fulfill =
				// period.elementAt(j).and(design.justiceAt(i)).satOne();
				if (!fulfill.isZero())
					break;
			}
			// Line 13
			if (fulfill.isZero()) {
				BDD from = period.lastElement();
				BDD to = feas.and(designWithTester.justiceAt(i));
				path = designWithTester.shortestPath(from, to);
				// eliminate the edge since from is already in period
				for (int j = 1; j < path.length; j++)
					period.add(path[j]);
			}
		}

		// Lines 14-16
		for (int i = 0; i < designWithTester.compassionNum(); i++) {
			if (!feas.and(designWithTester.pCompassionAt(i)).isZero()) {
				// check if C requirement i is already satisfied
				fulfill = Env.FALSE();
				for (int j = 0; j < period.size(); j++) {
					fulfill = period.elementAt(j).and(
							designWithTester.qCompassionAt(i)).satOne(
							designWithTester.moduleUnprimeVars(), false);
					// fulfill =
					// period.elementAt(j).and(design.qCompassionAt(i)).satOne();
					if (!fulfill.isZero())
						break;
				}

				if (fulfill.isZero()) {
					BDD from = period.lastElement();
					BDD to = feas.and(designWithTester.qCompassionAt(i));
					path = designWithTester.shortestPath(from, to);
					// eliminate the edge since from is already in period
					for (int j = 1; j < path.length; j++)
						period.add(path[j]);
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

	private static int tester_id = 0;
	private static int field_id = 0;

	public static class LTLTesterBuilder {
		private Spec root;
		private SMVModule tester;
		private HashMap<SpecExp, ModuleBDDField> spec2field = new HashMap<SpecExp, ModuleBDDField>();

		public LTLTesterBuilder(Spec root_spec, boolean isWeak)
				throws ModelCheckException {
			this.root = root_spec;
			if ((root == null) || (!root.isLTLSpec()))
				throw new ModelCheckException("Cannot construct a tester for"
						+ "specification: " + root);

			this.tester = new SMVModule("LTLTester_" + (++tester_id));
			createAuxVariable(root);
			constructModule(root, isWeak);
		}

		public SMVModule getTester() {
			return this.tester;
		}

		public BDD getSpec2BDD(Spec root) throws ModelCheckException {
			if (root instanceof SpecBDD)
				return ((SpecBDD) root).getVal();
			// else it is SpecExp (cannot be a SpecCTLRange)
			SpecExp se = (SpecExp) root;
			Spec[] child = se.getChildren();
			Operator op = se.getOperator();

			if (op == Operator.NOT)
				return getSpec2BDD(child[0]).not();
			if (op == Operator.AND)
				return getSpec2BDD(child[0]).and(getSpec2BDD(child[1]));
			if (op == Operator.OR)
				return getSpec2BDD(child[0]).or(getSpec2BDD(child[1]));
			if (op == Operator.XOR)
				return getSpec2BDD(child[0]).xor(getSpec2BDD(child[1]));
			if (op == Operator.XNOR)
				return getSpec2BDD(child[0]).xor(getSpec2BDD(child[1])).not();
			if (op == Operator.IFF)
				return getSpec2BDD(child[0]).biimp(getSpec2BDD(child[1]));
			if (op == Operator.IMPLIES)
				return getSpec2BDD(child[0]).imp(getSpec2BDD(child[1]));
			if (op.isLTLOp()) {
				ModuleBDDField f = spec2field.get(root);
				if ((f != null) && (f.getDomain().size().intValue() == 2))
					return f.getDomain().ithVar(1);
			}
			// something is wrong
			throw new ModelCheckException("Failed to find corresponding bdd"
					+ " to specification: " + root.toString());
		}

		private void createAuxVariable(Spec s) throws ModelCheckException {
			if (!(s instanceof SpecExp))
				return;
			// else
			SpecExp se = (SpecExp) s;
			if (se.getOperator().isLTLOp()) {
				try {
					// String name = se.getOperator().toString() + "_"
					// + (++field_id);
					String name = "AUX[" + (++field_id) + "]";
					ModuleBDDField f = tester.addVar(name);
					spec2field.put(se, f);
				} catch (ModuleException e) {
					throw new ModelCheckException("Failed naming the extra "
							+ "auxiliary fields");
				}
			}

			Spec[] children = se.getChildren();
			for (int i = 0; i < children.length; i++) {
				createAuxVariable(children[i]);
			}
		}

		private void constructModule(Spec root, boolean isWeak)
				throws ModelCheckException {
			BDD p_c1, p_c2, p_aux;

			Set<SpecExp> specifications = spec2field.keySet();
			for (SpecExp spec : specifications) {
				try {
					Operator op = spec.getOperator();
					Spec[] child = spec.getChildren();
					BDD aux = getSpec2BDD(spec);
					int noo = op.numOfOperands();
					BDD c1 = (noo > 0) ? getSpec2BDD(child[0]) : null;
					BDD c2 = (noo > 1) ? getSpec2BDD(child[1]) : null;
					switch (op) {
					case NEXT:
						p_c1 = Env.prime(c1);
						tester.conjunctTrans(aux.biimp(p_c1));
						break;
					case FINALLY:
						p_aux = Env.prime(aux);
						tester.conjunctTrans(aux.biimp(c1.or(p_aux)));
						tester.addJustice(c1.or(aux.not()));
						break;
					case GLOBALLY:
						p_aux = Env.prime(aux);
						tester.conjunctTrans(aux.biimp(c1.and(p_aux)));
						tester.addJustice(c1.not().or(aux));
						break;
					case PREV:
						p_aux = Env.prime(aux);
						tester.addInitial(aux.not());
						tester.conjunctTrans(p_aux.biimp(c1));
						break;
					// no BEFORE
					case ONCE:
						p_c1 = Env.prime(c1);
						p_aux = Env.prime(aux);
						tester.addInitial(aux.biimp(c1));
						tester.conjunctTrans(p_aux.biimp(aux.or(p_c1)));
						break;
					case HISTORICALLY:
						p_c1 = Env.prime(c1);
						p_aux = Env.prime(aux);
						tester.addInitial(aux.biimp(c1));
						tester.conjunctTrans(p_aux.biimp(aux.and(p_c1)));
						break;
					case UNTIL:
						p_aux = Env.prime(aux);
						tester.conjunctTrans(aux.biimp(c2.or(c1.and(p_aux))));
						tester.addJustice(aux.not());
						break;
					case RELEASES:
						p_aux = Env.prime(aux);
						tester.conjunctTrans(aux.biimp(c2.or(c1.and(p_aux))));
						tester.addJustice(c1.not().and(c2.not()).or(aux));
						break;
					case SINCE:
						p_c1 = Env.prime(c1);
						p_c2 = Env.prime(c2);
						p_aux = Env.prime(aux);
						tester.addInitial(aux.biimp(c2));
						tester.conjunctTrans(p_aux
								.biimp(p_c2.or(p_c1.and(aux))));
						break;
					case TRIGGERED:
						p_c1 = Env.prime(c1);
						p_c2 = Env.prime(c2);
						p_aux = Env.prime(aux);
						tester.addInitial(aux.biimp(c1.or(c2)));
						tester.conjunctTrans(p_aux
								.biimp(p_c2.or(p_c1.and(aux))));
						break;
					// NOT_PREV_NOT,
					default:
						break;
					}
				} catch (ModuleException e) {
					throw new ModelCheckException("Failed to construct BDD "
							+ "assertion for specification: " + spec.toString());
				} catch (BDDException e) {
					throw new ModelCheckException("Failed to prime BDD "
							+ "assertion for specification: " + spec.toString());
				}
			}
			if (!isWeak) {
				try {
					tester.addInitial(getSpec2BDD(root).not());
				} catch (ModuleException e) {
					throw new ModelCheckException(
							"Failed to add roots BDD assertion.");
				}
			}
		}
	}
}
