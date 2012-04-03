package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;

public class OpNext extends AbstractUnaryOperator {

	public OpNext(AbstractElement a_val) throws SMVParseException {
		super(a_val);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		ValueStmt v = this.getVal().do_eval();
		if (v.isValueDomStmt())
			return new ValueDomStmt(v.getContext(), v.toValueDomStmt()
					.getBDDCouple().prime());
		return new ValueBDDStmt(v.getContext(), Env.prime(v.toBDD()));
		// throw new SMVParseException("Could not prime value which is not a "
		// + "domain");
	}

	@Override
	public String elemToString() {
		return "NEXT";
	}

	@Override
	protected OpNext duplicate() throws SMVParseException {
		return new OpNext(this.getVal());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt v) throws SMVParseException {
		throw new SMVParseException("Internal: Not suppose to be here");
	}

	@Override
	protected ValueStmt doIntNode(ValueIntStmt v) throws SMVParseException {
		return v.toPrimeValueIntStmt();
	}

	@Override
	protected ValueStmt doBDDNode(ValueBDDStmt v) throws SMVParseException {
		return new ValueBDDStmt(v.getContext(), Env.prime(v.toBDD()));
	}

	@Override
	protected ValueStmt doConsRangeNode(ValueConsRangeStmt v)
			throws SMVParseException {
		return v;
		// throw new SMVParseException("Cannot do next opration on a constant");
	}

	@Override
	protected ValueStmt doDomNode(ValueDomStmt v) throws SMVParseException {
		return new ValueDomStmt(v.getContext(), v.getBDDCouple().prime());
	}

	@Override
	protected ValueStmt doConsStrNode(ValueConsStrStmt v)
			throws SMVParseException {
		return v;
		// throw new SMVParseException("Cannot do next opration on a constant");
	}
}
