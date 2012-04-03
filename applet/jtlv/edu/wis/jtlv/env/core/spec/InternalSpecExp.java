package edu.wis.jtlv.env.core.spec;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class InternalSpecExp extends InternalSpec {
	private InternalOp theOp;
	private InternalSpec[] elements;

	private InternalSpecExp(String exp_str, InternalOp op, InternalSpec[] el,
			Token start) {
		super(exp_str, start);
		assert (op != null);
		// if (op == null)
		// throw new SpecParseException("Cannot instantiate an expression"
		// + " without an operator.");
		assert (op.numOfOperands() == el.length);
		// if (op.numOfOperands() != el.length)
		// throw new SpecParseException("Operator " + op + " cannot be "
		// + "instantiated with the supplied " + el.length
		// + " operands.");
		for (InternalSpec s : el)
			assert (s != null);
		// for (InternalSpec s : el)
		// if (s == null)
		// throw new SpecParseException("Cannot instantiate an "
		// + "expression with a operand.");
		this.theOp = op;
		this.elements = el;
	}

	public InternalSpecExp(String exp_str, InternalOp op, InternalSpec e1,
			Token start) throws SpecParseException {
		this(exp_str, op, new InternalSpec[] { e1 }, start);
	}

	public InternalSpecExp(InternalOp op, InternalSpec e1, Token start) throws SpecParseException {
		this("", op, new InternalSpec[] { e1 }, start);
	}

	public InternalSpecExp(String exp_str, InternalOp op, InternalSpec e1,
			InternalSpec e2, Token start) throws SpecParseException {
		this(exp_str, op, new InternalSpec[] { e1, e2 }, start);
	}

	public InternalSpecExp(InternalOp op, InternalSpec e1, InternalSpec e2,
			Token start) throws SpecParseException {
		this("", op, new InternalSpec[] { e1, e2 }, start);
	}

	public InternalSpecExp(String exp_str, InternalOp op, InternalSpec e1,
			InternalSpec e2, InternalSpec e3, Token start)
			throws SpecParseException {
		this(exp_str, op, new InternalSpec[] { e1, e2, e3 }, start);
	}

	public InternalSpecExp(InternalOp op, InternalSpec e1, InternalSpec e2,
			InternalSpec e3, Token start) throws SpecParseException {
		this("", op, new InternalSpec[] { e1, e2, e3 }, start);
	}

	// external interface
	public InternalOp getOperator() {
		return theOp;
	};

	public InternalSpec[] getChildren() {
		return this.elements;
	}

	@Override
	public void evalBDDChildrenExp(TokenStream input) throws SpecParseException {
		if (this.areChildrenBDDsEvaluated())
			return;
		// for AU and EU the inner UNTIL will do the evaluation.
//		if ((this.getOperator() != InternalOp.AU)
//				& (this.getOperator() != InternalOp.EU)) {
			for (InternalSpec s : this.getChildren()) {
				s.evalBDDChildrenExp(input);
				if (s instanceof InternalSpecBDD)
					((InternalSpecBDD) s).evalBDDExp(input);
			}
//		}
		this.setChildrenBDDsAsEvaluated(true);
	}

	@Override
	public boolean isCTLSpec() {
		// checking that all children are prop.
		for (InternalSpec s : this.getChildren())
			if (!s.isCTLSpec())
				return false;
		// checking that I'm prop or CTL
		return this.getOperator().isProp() | this.getOperator().isCTLOp();
	}

	@Override
	public boolean isRealTimeCTLSpec() {
		// checking that all children are prop.
		for (InternalSpec s : this.getChildren())
			if (!s.isRealTimeCTLSpec())
				return false;
		// checking that I'm prop, CTL or RealTimeCTL
		return this.getOperator().isProp() | this.getOperator().isCTLOp()
				| this.getOperator().isRealTimeCTLOp();
	}

	@Override
	public boolean isLTLSpec() {
		// checking that all children are prop.
		for (InternalSpec s : this.getChildren())
			if (!s.isLTLSpec())
				return false;
		// checking that I'm prop, FutureLTL or PastLTL
		return this.getOperator().isProp() | this.getOperator().isFutureLTLOp()
				| this.getOperator().isPastLTLOp();
	}

	@Override
	public boolean isFutureLTLSpec() {
		// checking that all children are prop.
		for (InternalSpec s : this.getChildren())
			if (!s.isFutureLTLSpec())
				return false;
		// checking that I'm prop or FutureLTL
		return this.getOperator().isProp() | this.getOperator().isFutureLTLOp();
	}

	@Override
	public boolean isPastLTLSpec() {
		// checking that all children are prop.
		for (InternalSpec s : this.getChildren())
			if (!s.isPastLTLSpec())
				return false;
		// checking that I'm prop or pastLTL
		return this.getOperator().isProp() | this.getOperator().isPastLTLOp();
	}

	@Override
	public boolean isCTLStarSpec() {
		// this is a bit redundant... it suppose to always return true...
		// return true;
		// checking that all children are prop.
		for (InternalSpec s : this.getChildren())
			if (!s.isCTLStarSpec())
				return false;
		// checking that I'm prop, LTL, CTL or RealTimeCTL
		return this.getOperator().isProp() | this.getOperator().isFutureLTLOp()
				| this.getOperator().isPastLTLOp()
				| this.getOperator().isCTLOp()
				| this.getOperator().isRealTimeCTLOp();
	}

	@Override
	public boolean isPropSpec() {
		// checking that all children are prop.
		for (InternalSpec s : this.getChildren())
			if (!s.isPropSpec())
				return false;
		// checking that I'm prop
		return this.getOperator().isProp();
	}

	@Override
	public boolean hasTemporalOperators() {
		// if one of my elements is temporal.
		for (InternalSpec s : this.getChildren())
			if (s.hasTemporalOperators())
				return true;
		// or I'm temporal.
		return this.theOp.isTemporalOp();
	}

	@Override
	public String toString() {
		InternalOp op = this.getOperator();
		InternalSpec[] ch = this.getChildren();

		// special cases
		if (op == InternalOp.AU)
			return "(A[" + ch[0] + " UNTIL " + ch[1] + ")";
		if (op == InternalOp.EU)
			return "(E[" + ch[0] + " UNTIL " + ch[1] + ")";
		if (op == InternalOp.ABF)
			return "(ABF " + ch[0] + " " + ch[1] + ")";
		if (op == InternalOp.EBF)
			return "(EBF " + ch[0] + " " + ch[1] + ")";
		if (op == InternalOp.ABG)
			return "(ABG " + ch[0] + " " + ch[1] + ")";
		if (op == InternalOp.EBG)
			return "(EBG " + ch[0] + " " + ch[1] + ")";
		if (op == InternalOp.ABU)
			return "(A[" + ch[0] + " BUNTIL " + ch[1] + " " + ch[2] + ")";
		if (op == InternalOp.EBU)
			return "(E[" + ch[0] + " BUNTIL " + ch[1] + " " + ch[2] + ")";

		// simple unary
		if (op.isUnary())
			return "(" + op + " " + ch[0] + ")";
		// simple binary
		if (op.isBinary())
			return "(" + ch[0] + " " + op + " " + ch[1] + ")";

		return "[!#$! Cannot Identify Expression]";
	}
}
