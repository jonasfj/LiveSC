package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.core.smv.SMVParseException;

public class OpRshift extends AbstractBinaryOperator {

	public OpRshift(AbstractElement a_left, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("RSHIFT Operator is not implemented yet.");
	}

	@Override
	public String elemToString() {
		return ">>";
	}

	@Override
	protected OpRshift duplicate() throws SMVParseException {
		return new OpRshift(this.getLeft(), this.getRight());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		throw new SMVParseException("RSHIFT Operator is not implemented yet.");
	}

}
