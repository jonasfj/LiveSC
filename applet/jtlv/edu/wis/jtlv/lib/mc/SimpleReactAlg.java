package edu.wis.jtlv.lib.mc;

import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.ModuleWithWeakFairness;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.env.spec.SpecException;
import edu.wis.jtlv.lib.AlgExceptionI;
import edu.wis.jtlv.lib.AlgResultI;

/**
 * <p>
 * An algorithm for performing the react check.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class SimpleReactAlg extends SimpleTempEntailAlg {
	private Spec p;
	private Spec[] q;
	private Spec r;

	/**
	 * <p>
	 * A constructor for the react algorithm.
	 * </p>
	 * 
	 * @param design
	 *            The design to check the property for.
	 * @param p
	 *            The first property.
	 * @param q
	 *            An array of mediate properties.
	 * @param r
	 *            The last property.
	 */
	public SimpleReactAlg(ModuleWithWeakFairness design, Spec p, Spec[] q,
			Spec r) {
		super(design, p, r);
		if (q == null)
			throw new RuntimeException("Cannot check react for a null"
					+ " specification.");
		for (int i = 0; i < q.length; i++)
			if (q[i] == null)
				throw new RuntimeException("Cannot check react for a null"
						+ " specification at index " + i + ".");
		this.p = p;
		this.q = q;
		this.r = r;
	}

	/**
	 * <p>
	 * Override the getter, since in this implementation we must have a
	 * ModuleWithWeakFairness.
	 * </p>
	 * 
	 * @return The design to check for.
	 * 
	 * @see edu.wis.jtlv.lib.mc.ModelCheckAlgI#getDesign()
	 */
	protected ModuleWithWeakFairness getDesign() {
		return (ModuleWithWeakFairness) super.getDesign();
	}

	/**
	 * <p>
	 * Does Nothing.
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
	 * Check whether []((p /\_{forall i} []<>q[i]) -> <>q) is valid.
	 * </p>
	 * 
	 * @throws ModelCheckAlgException
	 *             When the checkReact method is initiated with other then
	 *             propositional properties.
	 * @throws ModelCheckAlgCounterExampleException
	 *             When the checkReact fails, a counter example is thrown.
	 * 
	 * @see edu.wis.jtlv.old_lib.mc.SimpleModelChecker#checkReactStrandardOutput(Spec,
	 *      Spec[], Spec)
	 */
	@Override
	public AlgResultI doAlgorithm() throws AlgExceptionI {
		for (int i = 0; i < q.length; i++)
			if (!q[i].isPropSpec())
				throw new ModelCheckAlgException("Cannot check react for a non"
						+ " propositional specification: " + q[i]);
		// the rest will be checked by the super.

		ModuleWithWeakFairness design = this.getDesign();
		String title = "checking react : []((" + this.p.toString();
		for (int i = 0; i < q.length; i++)
			title += " and " + q[i].toString();
		title += ") -> <>(" + this.r.toString() + "))";
		System.out.println(title);

		for (int i = 0; i < q.length; i++)
			if (!q[i].isPropSpec())
				throw new ModelCheckAlgException("Cannot check react for"
						+ " a non propositional specification: " + q[i]);
		// the rest will be checked by the super.

		AlgResultI res;
		int how_many_j = 0;
		try {
			while (how_many_j < q.length) {
				design.addJustice(q[how_many_j].toBDD());
				how_many_j++;
			}

			res = super.doAlgorithm();
		} catch (SpecException e) {
			// throwing this kind of exception.
			throw new ModelCheckAlgException(e.getMessage());
		} catch (ModuleException e) {
			// when the BDD is primed, throwing this kind of exception.
			throw new ModelCheckAlgException("Cannot check react for a "
					+ "primed proposition " + q[how_many_j] + "\n"
					+ e.getMessage());
		} finally { // removing whether an exception was thrown or not.
			for (int j = 0; j < how_many_j; j++)
				design.popLastJustice();
		}
		// else - everything is OK.
		return res;
	}

	/**
	 * <p>
	 * Does Nothing.
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
