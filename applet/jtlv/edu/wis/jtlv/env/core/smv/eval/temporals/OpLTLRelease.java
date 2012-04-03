package edu.wis.jtlv.env.core.smv.eval.temporals;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractBinaryOperator;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.ILTLOperator;
import edu.wis.jtlv.env.core.smv.eval.ValueStmt;

public class OpLTLRelease extends AbstractBinaryOperator implements
		ILTLOperator {

	public OpLTLRelease(AbstractElement a_left, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("LTL Operators are not implemented yet.");
	}

	@Override
	public String elemToString() {
		return "RELEASE";
	}
	
	@Override
	protected OpLTLRelease duplicate() throws SMVParseException {
		return new OpLTLRelease(this.getLeft(), this.getRight());
	}
	
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		throw new SMVParseException("LTL Operators are not implemented yet.");
	}
}
