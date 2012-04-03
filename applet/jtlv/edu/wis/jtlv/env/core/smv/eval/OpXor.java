package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.core.smv.SMVParseException;

public class OpXor extends AbstractBinaryOperator implements IBoolOperator {

	public OpXor(AbstractElement a_left, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		ValueStmt l = this.getLeft().do_eval();
		ValueStmt r = this.getRight().do_eval();
		BDD l_bdd = l.toBDD();
		BDD r_bdd = r.toBDD();
		return new ValueBDDStmt(l.getContext(), l_bdd.xor(r_bdd));
	}

	@Override
	public String elemToString() {
		return "XOR";
	}

	@Override
	protected OpXor duplicate() throws SMVParseException {
		return new OpXor(this.getLeft(), this.getRight());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv) throws SMVParseException {
		return new ValueBDDStmt(lv.getContext(), lv.toBDD().xor(rv.toBDD()));
	}
}
