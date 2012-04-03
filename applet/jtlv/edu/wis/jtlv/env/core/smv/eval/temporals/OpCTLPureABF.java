package edu.wis.jtlv.env.core.smv.eval.temporals;

import java.util.Vector;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.ValueStmt;

public class OpCTLPureABF extends AbstractCTLUnaryWithRangeOperator {

	public OpCTLPureABF(AbstractElement a_val, Vector<String> a_range)
			throws SMVParseException {
		super(a_val, a_range);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("CTL Operators are not implemented yet.");
	}

	@Override
	public String elemToString() {
		return "ABF";
	}
	
	@Override
	protected OpCTLPureABF duplicate() throws SMVParseException {
		return new OpCTLPureABF(this.getVal(), this.range);
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
