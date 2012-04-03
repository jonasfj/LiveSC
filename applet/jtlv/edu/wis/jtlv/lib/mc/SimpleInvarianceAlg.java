package edu.wis.jtlv.lib.mc;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.module.Module;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.env.spec.SpecException;
import edu.wis.jtlv.lib.AlgExceptionI;
import edu.wis.jtlv.lib.AlgResultI;
import edu.wis.jtlv.lib.AlgResultPath;
import edu.wis.jtlv.lib.AlgResultString;

/**
 * <p>
 * An algorithm for performing an invariance check.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class SimpleInvarianceAlg extends ModelCheckAlgI {
	private Spec property;

	/**
	 * <p>
	 * A constructor for the invariance algorithm.
	 * </p>
	 * 
	 * @param design
	 *            The design to check the property for.
	 * @param prop
	 *            The property.
	 */
	public SimpleInvarianceAlg(Module design, Spec prop) {
		super(design);
		this.property = prop;
		if (property == null)
			throw new RuntimeException("Cannot check invariance for a null"
					+ " specification.");
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
	 * The invariance procedure check that a property holds on all reachable
	 * states.
	 * </p>
	 * 
	 * @throws AlgExceptionI
	 *             If the property is not a propositional spec, or if failed to
	 *             parse the BDD in the spec.
	 * 
	 * @return A counter example if the algorithm fails (i.e.
	 *         {@link edu.wis.jtlv.lib.AlgResultPath}), or a string with
	 *         "VALID" (i.e. {@link edu.wis.jtlv.lib.AlgResultString}).
	 * 
	 */
	@Override
	public AlgResultI doAlgorithm() throws AlgExceptionI {
		if (!property.isPropSpec())
			throw new ModelCheckAlgException("Cannot check invariance"
					+ " for a non propositional specification: " + property);

		Module des = super.getDesign();
		System.out.println("checking invariance : " + property.toString()
				+ " for module " + des.getFullInstName() + ".");
		try {
			BDD toCheck = property.toBDD();
			super.inv(toCheck);
		} catch (SpecException e) {
			// throwing this kind of exception.
			throw new ModelCheckAlgException(e.getMessage());
		} catch (ModelCheckAlgCounterExampleException mce) {
			return new AlgResultPath(false, mce.getPath());
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
