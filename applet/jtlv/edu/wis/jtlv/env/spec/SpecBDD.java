package edu.wis.jtlv.env.spec;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;
import edu.wis.jtlv.env.Env;

/**
 * <p>
 * First order specification which is parsed as an SMV expression.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class SpecBDD implements Spec {
	private BDD val = null;
	private String identifying_expr = "";

	/**
	 * <p>
	 * A constructor for a leaf BDD specification, with a string representation.
	 * </p>
	 * 
	 * @param identifying_expr
	 *            The string from which this leaf was constructed.
	 * @param v
	 *            The BDD value (if already evaluated).
	 */
	public SpecBDD(String identifying_expr, BDD v) {
		this.identifying_expr = identifying_expr;
		this.val = v;
	}

	/**
	 * <p>
	 * A constructor for a leaf BDD specification, without a string
	 * representation.
	 * </p>
	 * 
	 * @param v
	 *            The evaluated BDD.
	 */
	public SpecBDD(BDD v) {
		this("", v);
	}

	/**
	 * <p>
	 * Getter for the BDD value.
	 * </p>
	 * 
	 * @return The BDD value.
	 * 
	 * @see SpecBDD#toBDD()
	 */
	public BDD getVal() {
		return this.val;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#isCTLSpec()
	 */
	public boolean isCTLSpec() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#isRealTimeCTLSpec()
	 */
	public boolean isRealTimeCTLSpec() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#isCTLStarSpec()
	 */
	public boolean isCTLStarSpec() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#isLTLSpec()
	 */
	public boolean isLTLSpec() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#isFutureLTLSpec()
	 */
	public boolean isFutureLTLSpec() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#isPastLTLSpec()
	 */
	public boolean isPastLTLSpec() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#isPropSpec()
	 */
	public boolean isPropSpec() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#hasTemporalOperators()
	 */
	public boolean hasTemporalOperators() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (this.getVal() == null)
			if (this.identifying_expr != "")
				return "\"" + this.identifying_expr + "\"";
			else
				return "[!$#! Cannot Identify BDD Expression]";
		return "#[" + Env.toNiceSignleLineString(null, this.getVal()) + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (!(other instanceof SpecBDD))
			return false;
		SpecBDD otherBDD = (SpecBDD) other;
		if ((this.val == null) || (otherBDD.val == null))
			return false;
		return this.val.equals(otherBDD.val);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#releventVars()
	 */
	public BDDVarSet releventVars() {
		return this.getVal().support();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.env.spec.Spec#toBDD()
	 */
	public BDD toBDD() throws SpecException {
		return this.getVal();
	}
}
