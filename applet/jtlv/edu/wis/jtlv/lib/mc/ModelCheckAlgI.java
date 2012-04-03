package edu.wis.jtlv.lib.mc;

import java.util.Stack;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.Module;
import edu.wis.jtlv.lib.AlgI;

public abstract class ModelCheckAlgI implements AlgI {
	private Module design;

	protected ModelCheckAlgI() {
		this.design = null;
	}

	protected ModelCheckAlgI(Module des) {
		if (des == null)
			throw new RuntimeException("Cannot instantiate a Model "
					+ "Checker with a null module.");
		this.design = des;
	}

	/**
	 * <p>
	 * Getter for the design to perform model checking for.
	 * </p>
	 * 
	 * @return The design to perform model checking for.
	 */
	protected Module getDesign() {
		return this.design;
	}

	/**
	 *<p>
	 * Model checking safety, using frontier.
	 * </p>
	 * 
	 * @param arg_ceg
	 *            The property to check.
	 * @throws ModelCheckAlgCounterExampleException
	 *             A counter example when failed.
	 */
	protected void inv(BDD arg_ceg) throws ModelCheckAlgCounterExampleException {
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
			ModelCheckAlgCounterExampleException cee = new ModelCheckAlgCounterExampleException(
					"\n*** Property is NOT VALID ***", example);

			throw cee;
		}
	}
}
