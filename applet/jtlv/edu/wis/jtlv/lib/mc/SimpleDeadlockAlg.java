package edu.wis.jtlv.lib.mc;

import java.util.Vector;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.Module;
import edu.wis.jtlv.lib.AlgExceptionI;
import edu.wis.jtlv.lib.AlgResultI;
import edu.wis.jtlv.lib.AlgResultPath;
import edu.wis.jtlv.lib.AlgResultString;

/**
 * <p>
 * An algorithm for performing deadlock check.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class SimpleDeadlockAlg extends ModelCheckAlgI {

	/**
	 * <p>
	 * A constructor for the deadlock algorithm.
	 * </p>
	 * 
	 * @param design
	 *            The design to check the property for.
	 */
	public SimpleDeadlockAlg(Module design) {
		super(design);
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
	 * Deadlocked states are those whose only successor is them-self. This
	 * method checks for the absence of deadlocks in the module.
	 * </p>
	 * 
	 * @return A counter example if the algorithm fails (i.e.
	 *         {@link edu.wis.jtlv.lib.AlgResultPath}, or a string with
	 *         "VALID" (i.e. {@link edu.wis.jtlv.lib.AlgResultString})
	 * 
	 * @throws AlgExceptionI
	 *             Never.
	 * 
	 */
	@Override
	public AlgResultI doAlgorithm() throws AlgExceptionI {
		Module des = super.getDesign();
		System.out.println("checking deadlock for module "
				+ des.getFullInstName() + ".");
		try {
			Vector<BDD> transRestrictions = des.getAllTransRestrictions();

			des.restrictTrans(des.idleStep().not());

			// All states without successors.
			BDD dead = des.pred(Env.TRUE()).not();

			// un-restrict
			des.setAllTransRestrictions(transRestrictions);

			super.inv(dead.not());
		} catch (ModelCheckAlgCounterExampleException cee) {
			return new AlgResultPath(false, cee.getPath());
		}
		// else - everything is OK.
		return new AlgResultString(true, "*** Property is VALID ***");
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
