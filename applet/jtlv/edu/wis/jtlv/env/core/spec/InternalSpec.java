package edu.wis.jtlv.env.core.spec;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public abstract class InternalSpec {
	protected String exp_str;
	
	public Token tstart;
	public Token tend;
	public InternalSpec(String exp_str, Token start) {
		this.exp_str = exp_str;
		this.tstart = start;
	}
	
	public void setEndToken(Token end) {
		this.tend = end;
	}
	

	// should the BDDs be evaluated.
	public static boolean evalBDDs = true;

	// is this node (and its sub nodes) BDD is evaluated.
	private boolean childrenBDDsAreEvaluated = false;

	protected void setChildrenBDDsAsEvaluated(boolean toSet) {
		this.childrenBDDsAreEvaluated = toSet;
	}

	protected boolean areChildrenBDDsEvaluated() {
		return this.childrenBDDsAreEvaluated;
	}

	public abstract void evalBDDChildrenExp(TokenStream input)
			throws SpecParseException;

	// ///////////////////////////////////////////////////////
	// Queries.
	public abstract boolean isPropSpec();

	public abstract boolean isCTLSpec();

	public abstract boolean isRealTimeCTLSpec();

	public abstract boolean isLTLSpec();

	public abstract boolean isFutureLTLSpec();

	public abstract boolean isPastLTLSpec();

	public abstract boolean isCTLStarSpec();

	public abstract boolean hasTemporalOperators();

	// ///////////////////////////////////////////////////////
	// String facilities.
	public abstract String toString();

	// ///////////////////////////////////////////////////////
	// facilities for minimizing the types of operators.
	// protected Vector<SpecMacro> all_macros;
	// public abstract Spec executeMacros();
	// public abstract void registerConvertingMacro(SpecMacro sm);
	// public abstract boolean removeConvertingMacro(SpecMacro sm);

}
