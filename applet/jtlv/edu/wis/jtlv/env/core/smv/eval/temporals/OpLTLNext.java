package edu.wis.jtlv.env.core.smv.eval.temporals;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.AbstractUnaryOperator;
import edu.wis.jtlv.env.core.smv.eval.ILTLOperator;
import edu.wis.jtlv.env.core.smv.eval.ValueStmt;

public class OpLTLNext extends AbstractUnaryOperator implements ILTLOperator {

	public OpLTLNext(AbstractElement a_val) throws SMVParseException {
		super(a_val);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("LTL Operators are not implemented yet.");
	}

	@Override
	public String elemToString() {
		return "NEXT";
	}
	
	@Override
	protected OpLTLNext duplicate() throws SMVParseException {
		return new OpLTLNext(this.getVal());
	}
	
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt v)
			throws SMVParseException {
		throw new SMVParseException("LTL Operators are not implemented yet.");
	}
}
