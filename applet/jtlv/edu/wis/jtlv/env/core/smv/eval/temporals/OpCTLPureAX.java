package edu.wis.jtlv.env.core.smv.eval.temporals;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.AbstractUnaryOperator;
import edu.wis.jtlv.env.core.smv.eval.ICTLOperator;
import edu.wis.jtlv.env.core.smv.eval.ValueStmt;

public class OpCTLPureAX extends AbstractUnaryOperator implements ICTLOperator {

	public OpCTLPureAX(AbstractElement a_val) throws SMVParseException {
		super(a_val);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("CTL Operators are not implemented yet.");
	}

	@Override
	public String elemToString() {
		return "AX";
	}
	
	@Override
	protected OpCTLPureAX duplicate() throws SMVParseException {
		return new OpCTLPureAX(this.getVal());
	}
	
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv)
			throws SMVParseException {
		throw new SMVParseException("CTL Operators are not implemented yet.");
	}
}
