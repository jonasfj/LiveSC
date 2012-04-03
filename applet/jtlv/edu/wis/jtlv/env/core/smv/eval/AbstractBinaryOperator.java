package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.core.smv.SMVParseException;

public abstract class AbstractBinaryOperator extends AbstractElement {

	public AbstractBinaryOperator(AbstractElement a_left,
			AbstractElement a_right) throws SMVParseException {
		super(new AbstractElement[] { a_left, a_right });
	}

	@Override
	public String toString() {
		return "[" + getLeft().toString() + " " + elemToString() + " "
				+ getRight().toString() + "]";
	}

	public AbstractElement getLeft() {
		return this.nGetChild(0);
	}

	public AbstractElement getRight() {
		return this.nGetChild(1);
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt newEval() throws SMVParseException {
		ValueStmt lres = this.getLeft().newEval();
		ValueStmt rres = this.getRight().newEval();
		if (lres.isValueBDDStmt()) {
			if (rres.isValueBDDStmt())
				return doBDD2BDDNode(lres.toValueBDDStmt(), rres
						.toValueBDDStmt());
			if (rres.isValueIntStmt())
				return doBDD2IntNode(lres.toValueBDDStmt(), rres
						.toValueIntStmt());
			if (rres.isValueDomStmt())
				return doBDD2DomNode(lres.toValueBDDStmt(), rres
						.toValueDomStmt());
			if (rres.isValueConsStmt()) {
				ValueConsStmt c_rres = rres.toValueConsStmt();
				if (c_rres.isValueConsStrStmt())
					return doBDD2ConsStrNode(lres.toValueBDDStmt(), c_rres
							.toValueConsStrStmt());
				if (c_rres.isValueConsRangeStmt())
					return doBDD2ConsRangeNode(lres.toValueBDDStmt(), c_rres
							.toValueConsRangeStmt());
			}
		}

		// /////////////

		if (lres.isValueIntStmt()) {
			if (rres.isValueBDDStmt())
				return doInt2BDDNode(lres.toValueIntStmt(), rres
						.toValueBDDStmt());
			if (rres.isValueIntStmt())
				return doInt2IntNode(lres.toValueIntStmt(), rres
						.toValueIntStmt());
			if (rres.isValueDomStmt())
				return doInt2DomNode(lres.toValueIntStmt(), rres
						.toValueDomStmt());
			if (rres.isValueConsStmt()) {
				ValueConsStmt c_rres = rres.toValueConsStmt();
				if (c_rres.isValueConsStrStmt())
					return doInt2ConsStrNode(lres.toValueIntStmt(), c_rres
							.toValueConsStrStmt());
				if (c_rres.isValueConsRangeStmt())
					return doInt2ConsRangeNode(lres.toValueIntStmt(), c_rres
							.toValueConsRangeStmt());
			}
		}

		// /////////////

		if (lres.isValueDomStmt()) {
			if (rres.isValueBDDStmt())
				return doDom2BDDNode(lres.toValueDomStmt(), rres
						.toValueBDDStmt());
			if (rres.isValueIntStmt())
				return doDom2IntNode(lres.toValueDomStmt(), rres
						.toValueIntStmt());
			if (rres.isValueDomStmt())
				return doDom2DomNode(lres.toValueDomStmt(), rres
						.toValueDomStmt());
			if (rres.isValueConsStmt()) {
				ValueConsStmt c_rres = rres.toValueConsStmt();
				if (c_rres.isValueConsStrStmt())
					return doDom2ConsStrNode(lres.toValueDomStmt(), c_rres
							.toValueConsStrStmt());
				if (c_rres.isValueConsRangeStmt())
					return doDom2ConsRangeNode(lres.toValueDomStmt(), c_rres
							.toValueConsRangeStmt());
			}
		}

		// /////////////

		if (lres.isValueConsStmt()) {
			ValueConsStmt c_lres = lres.toValueConsStmt();
			if (c_lres.isValueConsStrStmt()) {
				if (rres.isValueBDDStmt())
					return doConsStr2BDDNode(c_lres.toValueConsStrStmt(), rres
							.toValueBDDStmt());
				if (rres.isValueIntStmt())
					return doConsStr2IntNode(c_lres.toValueConsStrStmt(), rres
							.toValueIntStmt());
				if (rres.isValueDomStmt())
					return doConsStr2DomNode(c_lres.toValueConsStrStmt(), rres
							.toValueDomStmt());
				if (rres.isValueConsStmt()) {
					ValueConsStmt c_rres = rres.toValueConsStmt();
					if (c_rres.isValueConsStrStmt())
						return doConsStr2ConsStrNode(c_lres
								.toValueConsStrStmt(), c_rres
								.toValueConsStrStmt());
					if (c_rres.isValueConsRangeStmt())
						return doConsStr2ConsRangeNode(c_lres
								.toValueConsStrStmt(), c_rres
								.toValueConsRangeStmt());
				}
			}

			// /////////////

			if (c_lres.isValueConsRangeStmt()) {
				if (rres.isValueBDDStmt())
					return doConsRange2BDDNode(c_lres.toValueConsRangeStmt(),
							rres.toValueBDDStmt());
				if (rres.isValueIntStmt())
					return doConsRange2IntNode(c_lres.toValueConsRangeStmt(),
							rres.toValueIntStmt());
				if (rres.isValueDomStmt())
					return doConsRange2DomNode(c_lres.toValueConsRangeStmt(),
							rres.toValueDomStmt());
				if (rres.isValueConsStmt()) {
					ValueConsStmt c_rres = rres.toValueConsStmt();
					if (c_rres.isValueConsStrStmt())
						return doConsRange2ConsStrNode(c_lres
								.toValueConsRangeStmt(), c_rres
								.toValueConsStrStmt());
					if (c_rres.isValueConsRangeStmt())
						return doConsRange2ConsRangeNode(c_lres
								.toValueConsRangeStmt(), c_rres
								.toValueConsRangeStmt());
				}
			}
		}

		throw new SMVParseException("Failed evaluating node.");
	}

	// by default, this operation will be executed, unless a subtype has
	// overridden a specific kind of arguments.
	protected abstract ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException;

	protected ValueStmt doBDD2BDDNode(ValueBDDStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doInt2BDDNode(ValueIntStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doDom2BDDNode(ValueDomStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsRange2BDDNode(ValueConsRangeStmt lv,
			ValueBDDStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsStr2BDDNode(ValueConsStrStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	// //////////

	protected ValueStmt doBDD2IntNode(ValueBDDStmt lv, ValueIntStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doInt2IntNode(ValueIntStmt lv, ValueIntStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doDom2IntNode(ValueDomStmt lv, ValueIntStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsRange2IntNode(ValueConsRangeStmt lv,
			ValueIntStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsStr2IntNode(ValueConsStrStmt lv, ValueIntStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	// //////////

	protected ValueStmt doBDD2DomNode(ValueBDDStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doInt2DomNode(ValueIntStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doDom2DomNode(ValueDomStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsRange2DomNode(ValueConsRangeStmt lv,
			ValueDomStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsStr2DomNode(ValueConsStrStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	// //////////

	protected ValueStmt doBDD2ConsRangeNode(ValueBDDStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doInt2ConsRangeNode(ValueIntStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doDom2ConsRangeNode(ValueDomStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsRange2ConsRangeNode(ValueConsRangeStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsStr2ConsRangeNode(ValueConsStrStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	// //////////

	protected ValueStmt doBDD2ConsStrNode(ValueBDDStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doInt2ConsStrNode(ValueIntStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doDom2ConsStrNode(ValueDomStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsRange2ConsStrNode(ValueConsRangeStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

	protected ValueStmt doConsStr2ConsStrNode(ValueConsStrStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		return doDefaultNodeOp(lv, rv);
	}

}
