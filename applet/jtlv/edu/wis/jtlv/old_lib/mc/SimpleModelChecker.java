package edu.wis.jtlv.old_lib.mc;

import java.util.Stack;
import java.util.Vector;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.env.spec.SpecException;

/**
 * <p>
 * A wrapper to a SMVModule which knows how to check simple properties for the
 * given module.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class SimpleModelChecker extends ModelChecker {

	public SimpleModelChecker(SMVModule design) throws ModelCheckException {
		this(design, false);
	}

	public SimpleModelChecker(SMVModule design, boolean removeRunningVar)
			throws ModelCheckException {
		super(design, removeRunningVar);
	}

	/**
	 * <p>
	 * Deadlocked states are those whose only successor is them-self. This
	 * method variant checks for the absence of deadlocks in the module in
	 * prints the results to the standard streams.
	 * </p>
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkDeadlock()
	 */
	public void checkDeadlockStrandardOutput() {
		System.out.println("checking deadloack for module "
				+ this.getDesign().getFullInstName() + ".");
		try {
			this.checkDeadlock();
		} catch (CounterExampleException cee) {
			System.err.println(cee.toString());
			return;
		}
		// else - everything is OK.
		System.out.println("*** Property is VALID ***");
	}

	/**
	 * <p>
	 * Deadlocked states are those whose only successor is them-self. This
	 * method checks for the absence of deadlocks in the module.
	 * </p>
	 * 
	 * @throws CounterExampleException
	 *             When the property does not hold on some reachable state, a
	 *             counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkDeadlockStrandardOutput()
	 */
	public void checkDeadlock() throws CounterExampleException {
		SMVModule design = this.getDesign();
		Vector<BDD> transRestrictions = design.getAllTransRestrictions();

		design.restrictTrans(design.idleStep().not());

		// All states without successors.
		BDD dead = design.pred(Env.TRUE()).not();

		// un-restrict
		design.setAllTransRestrictions(transRestrictions);

		this.inv(dead.not());
	}

	/**
	 * <p>
	 * The invariance procedure check that a property holds on all reachable
	 * states. This variant of implementation, prints the results to the
	 * standard streams.
	 * </p>
	 * 
	 * @param property
	 *            The property to check invariance for.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkInvariance(Spec)
	 */
	public void checkInvarianceStrandardOutput(Spec property) {
		System.out.println("checking invariance : " + property.toString());
		try {
			this.checkInvariance(property);
		} catch (ModelCheckException mce) {
			System.err.println(mce.toString());
			return;
		}
		// else - everything is OK.
		System.out.println("*** Property is VALID ***");
	}

	/**
	 * <p>
	 * The invariance procedure check that a property holds on all reachable
	 * states.
	 * </p>
	 * 
	 * @param property
	 *            The property to check invariance for.
	 * @throws ModelCheckException
	 *             When the invariance method is initiated with other then
	 *             propositional property.
	 * @throws CounterExampleException
	 *             When the property does not hold on some reachable state, a
	 *             counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkInvarianceStrandardOutput(Spec)
	 */
	public void checkInvariance(Spec property) throws ModelCheckException,
			CounterExampleException {
		if (property == null)
			throw new ModelCheckException("Cannot check invariance for a null"
					+ " specification.");
		if (!property.isPropSpec())
			throw new ModelCheckException("Cannot check invariance for a non"
					+ " propositional specification: " + property);

		BDD toCheck = null;
		try {
			toCheck = property.toBDD();
		} catch (SpecException e) {
			throw new ModelCheckException(e.getMessage());
		}
		this.inv(toCheck);
	}

	/**
	 * <p>
	 * Verify whether [](p -> <>q) is valid. This variant of implementation,
	 * prints the results to the standard streams.
	 * </p>
	 * 
	 * @param p
	 *            The first propositional property.
	 * @param q
	 *            The second propositional property.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkTempEntail(Spec, Spec)
	 */
	public void checkTempEntailStrandardOutput(Spec p, Spec q) {
		System.out.println("checking temporal entailment : []((" + p.toString()
				+ ") -> <>(" + q.toString() + "))");
		try {
			this.checkTempEntail(p, q);
		} catch (ModelCheckException mce) {
			System.err.println(mce.toString());
			return;
		}
		// else - everything is OK.
		System.out.println("*** Property is VALID ***");
	}

	/**
	 * <p>
	 * Verify whether [](p -> <>q) is valid.
	 * </p>
	 * 
	 * @param p
	 *            The first propositional property.
	 * @param q
	 *            The second propositional property.
	 * @throws ModelCheckException
	 *             When the tempEntail method is initiated with other then
	 *             propositional properties.
	 * @throws CounterExampleException
	 *             When the TempEntail fails, a counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkTempEntailStrandardOutput(Spec,
	 *      Spec)
	 */
	public void checkTempEntail(Spec p, Spec q) throws ModelCheckException,
			CounterExampleException {
		if ((p == null) | (q == null))
			throw new ModelCheckException("Cannot check entail for a null"
					+ " specification.");
		if (!p.isPropSpec())
			throw new ModelCheckException("Cannot check entail for a non"
					+ " propositional specification: " + p);
		if (!q.isPropSpec())
			throw new ModelCheckException("Cannot check entail for a non"
					+ " propositional specification: " + q);

		SMVModule design = this.getDesign();
		Vector<BDD> transRestrictions = design.getAllTransRestrictions();

		BDD ass_p, ass_q;
		try {
			ass_q = q.toBDD();
			ass_p = p.toBDD();
		} catch (SpecException e) {
			// cannot be since it is a prop...
			e.printStackTrace();
			return;
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
			throw new CounterExampleException(
					"\n*** Property is NOT VALID ***", ce);
		}

		design.setAllTransRestrictions(transRestrictions);
	}

	/**
	 * <p>
	 * Verify whether []((p /\_{forall i} []<>q[i]) -> <>q) is valid. This
	 * variant of implementation, prints the results to the standard streams.
	 * </p>
	 * 
	 * @param p
	 *            The first propositional property.
	 * @param q
	 *            An array of always eventually properties
	 * @param r
	 *            The second propositional property.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkReact(Spec, Spec[],
	 *      Spec)
	 */
	public void checkReactStrandardOutput(Spec p, Spec[] q, Spec r) {
		String title = "checking react : []((" + p.toString();
		for (int i = 0; i < q.length; i++)
			title += " and " + q[i].toString();
		title += ") -> <>(" + r.toString() + "))";
		System.out.println(title);

		try {
			this.checkReact(p, q, r);
		} catch (ModelCheckException mce) {
			System.err.println(mce.toString());
			return;
		}
		// else - everything is OK.
		System.out.println("*** Property is VALID ***");

	}

	/**
	 * <p>
	 * Verify whether []((p /\_{forall i} []<>q[i]) -> <>q) is valid.
	 * </p>
	 * 
	 * @param p
	 *            The first propositional property.
	 * @param q
	 *            An array of always eventually properties
	 * @param r
	 *            The second propositional property.
	 * @throws ModelCheckException
	 *             When the checkReact method is initiated with other then
	 *             propositional properties.
	 * @throws CounterExampleException
	 *             When the checkReact fails, a counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkReactStrandardOutput(Spec,
	 *      Spec[], Spec)
	 */
	public void checkReact(Spec p, Spec[] q, Spec r)
			throws ModelCheckException, CounterExampleException {
		if ((p == null) || (q == null) || (r == null))
			throw new ModelCheckException("Cannot check react for a null"
					+ " specification.");
		if (!p.isPropSpec())
			throw new ModelCheckException("Cannot check react for a non"
					+ " propositional specification: " + p);
		for (int i = 0; i < q.length; i++)
			if (!q[i].isPropSpec())
				throw new ModelCheckException("Cannot check react for a non"
						+ " propositional specification: " + q[i]);
		if (!r.isPropSpec())
			throw new ModelCheckException("Cannot check react for a non"
					+ " propositional specification: " + r);

		SMVModule design = this.getDesign();

		for (int i = 0; i < q.length; i++) {
			try {
				design.addJustice(q[i].toBDD());
			} catch (SpecException e) {
				// cannot be since it is a prop...
				e.printStackTrace();
				throw new ModelCheckException("Un-clear internal failure with"
						+ " proposition " + q[i]);
			} catch (ModuleException e) {
				// when the BDD is primed.
				throw new ModelCheckException("Cannot check react for a primed"
						+ " proposition " + q[i]);
			}
		}

		try {
			this.checkTempEntail(p, r);
		} finally {
			for (int i = 0; i < q.length; i++)
				design.popLastJustice();
		}
	}

	// Model checking safety, using frontier.
	private void inv(BDD arg_ceg) throws CounterExampleException {

		SMVModule design = this.getDesign();

		BDD bulk = arg_ceg.not().and(design.pred(Env.TRUE()));
		BDD res = bulk.id();

		// Array which remembers the new generated frontiers.
		Stack<BDD> bpath = new Stack<BDD>();
		bpath.push(bulk.id());

		while (!res.isZero()) {
			// Find new frontier.
			res = design.pred(res.id()).and(bulk.not());

			// Remember in frontier array.
			bpath.push(res.id());

			bulk = bulk.id().or(res);

			if (!res.and(design.initial()).isZero())
				res = Env.FALSE();
		}

		if (!bulk.and(design.initial()).isZero()) {
			Stack<BDD> ce = new Stack<BDD>();
			ce.push(bpath.pop().and(design.initial()).satOne(
					design.moduleUnprimeVars(), false));

			while (!bpath.isEmpty()) {
				BDD states = design.succ(ce.peek().id()).and(bpath.pop());
				ce.push(states.satOne(design.moduleUnprimeVars(), false));
			}

			BDD[] example = new BDD[ce.size()];
			ce.toArray(example);
			CounterExampleException cee = new CounterExampleException(
					"\n*** Property is NOT VALID ***", example);

			throw cee;
		}
	}

	private BDD[] extractTempEntailWithness(BDD pending, BDD ass_q, BDD cycles) {
		SMVModule design = this.getDesign();
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

		// Thread path through all justice.
		for (int i = 0; i < design.justiceNum(); i++) {
			for (BDD bdd : period_path)
				if (!bdd.and(design.justiceAt(i)).isZero())
					continue; // if found then skipping
			// otherwise adding a path which will path at this justice.
			BDD[] top2FJ = design.shortestPath(period_path.peek(), final_loop
					.and(design.justiceAt(i)));
			for (int j = 1; j < top2FJ.length; j++)
				period_path.push(top2FJ[j]);
		}

		// Thread path through all compassion.
		for (int i = 0; i < design.compassionNum(); i++) {
			if (!final_loop.and(design.pCompassionAt(i)).isZero()) {
				for (BDD bdd : period_path)
					if (!bdd.and(design.qCompassionAt(i)).isZero())
						continue; // if found then skipping
				// adding a path which will path at this q compassion.
				BDD goal = final_loop.and(design.qCompassionAt(i));
				if (!goal.isZero()) {
					BDD[] top2goal = design.shortestPath(period_path.peek(),
							goal);
					for (int j = 1; j < top2goal.length; j++)
						period_path.push(top2goal[j]);
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

}
