package edu.wis.jtlv.env.core.smv.eval.temporals;

import java.util.Vector;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.ValueStmt;

public class OpCTLPureEE extends AbstractCTLBinaryWithRangeOperator {

	public OpCTLPureEE(AbstractElement a_left, String a_type,
			Vector<String> a_range, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_type, a_range, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("CTL Operators are not implemented yet.");
	}

	@Override
	public String elemToString() {
		return "EE";
	}

	@Override
	protected OpCTLPureEE duplicate() throws SMVParseException {
		return new OpCTLPureEE(this.getLeft(), this.type, this.range, this.getRight());
	}
	
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		throw new SMVParseException("CTL Operators are not implemented yet.");
	}
}
