package edu.wis.jtlv.env.spec;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;

/**
 * <p>
 * A general interface for all kinds of specifications.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 * @see edu.wis.jtlv.env.Env#loadSpecFile(String)
 * @see edu.wis.jtlv.env.Env#loadSpecString(String)
 * @see edu.wis.jtlv.env.Env#loadSpecInputStream(java.io.InputStream)
 */
public interface Spec {

	// ///////////////////////////////////////////////////////
	// Queries.
	/**
	 * <p>
	 * Is this a first order specification.
	 * </p>
	 * 
	 * @return true, if this a first order specification.
	 */
	public abstract boolean isPropSpec();

	/**
	 * <p>
	 * Is this a CTL specification.
	 * </p>
	 * 
	 * @return true, if this a CTL specification.
	 */
	public abstract boolean isCTLSpec();

	/**
	 * <p>
	 * Is this a Real Time CTL specification.
	 * </p>
	 * 
	 * @return true, if this a Real Time CTL specification.
	 */
	public abstract boolean isRealTimeCTLSpec();

	/**
	 * <p>
	 * Is this a LTL specification.
	 * </p>
	 * 
	 * @return true, if this a LTL specification.
	 */
	public abstract boolean isLTLSpec();

	/**
	 * <p>
	 * Is this a Future LTL specification.
	 * </p>
	 * 
	 * @return true, if this a Future LTL specification.
	 */
	public abstract boolean isFutureLTLSpec();

	/**
	 * <p>
	 * Is this a Past LTL specification.
	 * </p>
	 * 
	 * @return true, if this a Past LTL specification.
	 */
	public abstract boolean isPastLTLSpec();

	/**
	 * <p>
	 * Is this a CTL* specification.
	 * </p>
	 * 
	 * @return true, if this a CTL* specification.
	 */
	public abstract boolean isCTLStarSpec();

	/**
	 * <p>
	 * Does this specification has a temporal operator.
	 * </p>
	 * 
	 * @return true, if this specification has a temporal operator.
	 */
	public abstract boolean hasTemporalOperators();

	/**
	 * <p>
	 * Get the domain of this specification.
	 * </p>
	 * 
	 * @return The BDDVarSet with all the variable in this specification.
	 */
	public abstract BDDVarSet releventVars();

	// ///////////////////////////////////////////////////////
	// String facilities.
	/**
	 * <p>
	 * The usual toString.
	 * </p>
	 * 
	 * @return A string representation of this object.
	 */
	public abstract String toString();

	// ///////////////////////////////////////////////////////
	// facilities for minimizing the types of operators.
	// protected Vector<SpecMacro> all_macros;
	// public abstract Spec executeMacros();
	// public abstract void registerConvertingMacro(SpecMacro sm);
	// public abstract boolean removeConvertingMacro(SpecMacro sm);

	// ///////////////////////////////////////////////////////
	/**
	 * <p>
	 * Implementors are required to provide the equals since two (syntactically)
	 * identical specifications, which are different object will return false to
	 * the usual equals.
	 * </p>
	 * 
	 * @param other
	 *            The other object to check equality with.
	 * @return true, if the given object is identical to the given.
	 */
	public abstract boolean equals(Object other);

	/**
	 * <p>
	 * Get the BDD representing this specification. Note that only first order
	 * specifications can get their toBDD, other kind of specification will
	 * throw an exception.
	 * </p>
	 * 
	 * @return The BDD representing this specification.
	 * @throws SpecException
	 *             When the specification is temporal.
	 */
	public abstract BDD toBDD() throws SpecException;
}
