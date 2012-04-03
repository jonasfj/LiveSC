package edu.wis.jtlv.env.core.smv.eval.temporals;

import java.util.Vector;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.ValueStmt;

public class OpCTLPureEBG extends AbstractCTLUnaryWithRangeOperator {

	public OpCTLPureEBG(AbstractElement a_val, Vector<String> a_range)
			throws SMVParseException {
		super(a_val, a_range);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("CTL Operators are not implemented yet.");
	}

	@Override
	public String elemToString() {
		return "EBG";
	}
	
	@Override
	protected OpCTLPureEBG duplicate() throws SMVParseException {
		return new OpCTLPureEBG(this.getVal(), this.range);
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
