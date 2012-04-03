package edu.wis.jtlv.env.core.smv.eval.temporals;

import java.util.Vector;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.ValueStmt;

public class OpCTLPureABG extends AbstractCTLUnaryWithRangeOperator {

	public OpCTLPureABG(AbstractElement a_val, Vector<String> a_range)
			throws SMVParseException {
		super(a_val, a_range);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("CTL Operators are not implemented yet.");
	}

	@Override
	public String elemToString() {
		return "ABG";
	}
	
	@Override
	protected OpCTLPureABG duplicate() throws SMVParseException {
		return new OpCTLPureABG(this.getVal(), this.range);
	}
	
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt v)
			throws SMVParseException {
		throw new SMVParseException("CTL Operators are not implemented yet.");
	}
}
