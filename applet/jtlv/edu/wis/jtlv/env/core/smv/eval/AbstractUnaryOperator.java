package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.core.smv.SMVParseException;

public abstract class AbstractUnaryOperator extends AbstractElement {

	public AbstractUnaryOperator(AbstractElement a_val)
			throws SMVParseException {
		super(new AbstractElement[] { a_val });
	}

	@Override
	public String toString() {
		return "[" + elemToString() + " " + getVal().toString() + "]";
	}

	public AbstractElement getVal() {
		return this.nGetChild(0);
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt newEval() throws SMVParseException {
		ValueStmt res = this.getVal().newEval();
		if (res.isValueBDDStmt())
			return doBDDNode(res.toValueBDDStmt());
		if (res.isValueIntStmt())
			return doIntNode(res.toValueIntStmt());
		if (res.isValueDomStmt())
			return doDomNode(res.toValueDomStmt());
		if (res.isValueConsStmt()) {
			ValueConsStmt c_res = res.toValueConsStmt();
			if (c_res.isValueConsStrStmt())
				return doConsStrNode(c_res.toValueConsStrStmt());
			if (c_res.isValueConsRangeStmt())
				return doConsRangeNode(c_res.toValueConsRangeStmt());
		}

		throw new SMVParseException("Failed evaluating node.");
	}

	// by default, this operation will be executed, unless a subtype has
	// overridden a specific kind of arguments.
	protected abstract ValueStmt doDefaultNodeOp(ValueStmt v)
			throws SMVParseException;

	protected ValueStmt doBDDNode(ValueBDDStmt v) throws SMVParseException {
		return doDefaultNodeOp(v);
	}

	protected ValueStmt doIntNode(ValueIntStmt v) throws SMVParseException {
		return doDefaultNodeOp(v);
	}

	protected ValueStmt doDomNode(ValueDomStmt v) throws SMVParseException {
		return doDefaultNodeOp(v);
	}

	protected ValueStmt doConsRangeNode(ValueConsRangeStmt v)
			throws SMVParseException {
		return doDefaultNodeOp(v);
	}

	protected ValueStmt doConsStrNode(ValueConsStrStmt v)
			throws SMVParseException {
		return doDefaultNodeOp(v);
	}
}
