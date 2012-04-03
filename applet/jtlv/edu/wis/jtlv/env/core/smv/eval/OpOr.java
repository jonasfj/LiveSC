package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.core.smv.SMVParseException;

public class OpOr extends AbstractBinaryOperator implements IBoolOperator {

	public OpOr(AbstractElement a_left, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		ValueStmt l = this.getLeft().do_eval();
		ValueStmt r = this.getRight().do_eval();
		BDD l_bdd = l.toBDD();
		BDD r_bdd = r.toBDD();

		return new ValueBDDStmt(l.getContext(), l_bdd.or(r_bdd));
	}

	@Override
	public String elemToString() {
		return "OR";
	}

	@Override
	protected OpOr duplicate() throws SMVParseException {
		return new OpOr(this.getLeft(), this.getRight());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		return new ValueBDDStmt(lv.getContext(), lv.toBDD().or(rv.toBDD()));
	}

}
