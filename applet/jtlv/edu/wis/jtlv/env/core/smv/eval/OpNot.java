package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.core.smv.SMVParseException;

public class OpNot extends AbstractUnaryOperator implements IBoolOperator {

	public OpNot(AbstractElement a_val) throws SMVParseException {
		super(a_val);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		ValueStmt v = this.getVal().do_eval();
		BDD v_bdd = v.toBDD();
		return new ValueBDDStmt(v.getContext(), v_bdd.not());
	}

	@Override
	public String elemToString() {
		return "!";
	}

	@Override
	protected OpNot duplicate() throws SMVParseException {
		return new OpNot(this.getVal());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt v) throws SMVParseException {
		return new ValueBDDStmt(v.getContext(), v.toBDD().not());
	}
}
