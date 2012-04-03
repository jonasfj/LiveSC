package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;

//not clear what does it implement
public class OpEqual extends AbstractBinaryOperator {

	public OpEqual(AbstractElement a_left, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		ValueStmt l = this.getLeft().do_eval();
		ValueStmt r = this.getRight().do_eval();
		// case both are constants
		if (l.isValueConsStmt() & r.isValueConsStmt()) {
			ValueConsStrStmt lc = l.toValueConsStmt().toValueConsStrStmt();
			ValueConsStrStmt rc = r.toValueConsStmt().toValueConsStrStmt();
			for (String l_str : lc.getValues()) {
				boolean has_match = false;
				for (String r_str : rc.getValues())
					if (l_str.equals(r_str)) {
						has_match = true;
						break;
					}
				if (!has_match)
					return new ValueBDDStmt(l.getContext(), Env.FALSE());
			}
			return new ValueBDDStmt(l.getContext(), Env.TRUE());
		}
		// case one is domain and the other is constant
		boolean d2c = l.isValueDomStmt() & r.isValueConsStmt();
		boolean c2d = l.isValueConsStmt() & r.isValueDomStmt();
		if (d2c | c2d) {
			ValueDomStmt d = d2c ? l.toValueDomStmt() : r.toValueDomStmt();
			ValueConsStrStmt c = d2c ? r.toValueConsStmt().toValueConsStrStmt()
					: l.toValueConsStmt().toValueConsStrStmt();
			return new ValueBDDStmt(l.getContext(), d.strToBDD(c.getValues()));
		}

		boolean ld = l.isValueDomStmt();
		boolean rd = r.isValueDomStmt();
		if (ld & rd) {
			return new ValueBDDStmt(l.getContext(), l.toValueDomStmt()
					.biimpDomain(r.toValueDomStmt()));
		}

		// ///////////////////////////////////////////
		// ///////////////////////////////////////////
		// handling as an integer.
		// if one of the values is constant
		boolean lc = l.isValueConsStmt();
		boolean rc = r.isValueConsStmt();
		if (lc | rc) {
			try {
				String[] vals = lc ? l.toValueConsStmt().toValueConsStrStmt()
						.getValues() : r.toValueConsStmt().toValueConsStrStmt()
						.getValues();
				if (vals.length != 1)
					throw new SMVParseException("Cannot do aritmatic operation"
							+ "on constant with other then single value.");
				Integer int_val = new Integer(vals[0]);
				ValueIntStmt other = lc ? r.toValueIntStmt() : l
						.toValueIntStmt();
				return lc ? ValueIntStmt.EQOpWithCons(int_val, other)
						: ValueIntStmt.EQOpWithCons(other, int_val);
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Caanot do aritmatic operation "
						+ "on string values.");
			}
		}

		// any other variation of domain/integer/bdd is done through int.
		return ValueIntStmt.EQOp(l.toValueIntStmt(), r.toValueIntStmt());
	}

	@Override
	public String elemToString() {
		return "=";
	}

	@Override
	protected OpEqual duplicate() throws SMVParseException {
		return new OpEqual(this.getLeft(), this.getRight());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		// ///////////////////////////////////////////
		// ///////////////////////////////////////////
		// handling as an integer.
		// if one of the values is constant
		boolean lc = lv.isValueConsStmt();
		boolean rc = rv.isValueConsStmt();
		if (lc | rc) {
			try {
				String[] vals = lc ? lv.toValueConsStmt().toValueConsStrStmt()
						.getValues() : rv.toValueConsStmt()
						.toValueConsStrStmt().getValues();
				if (vals.length != 1)
					throw new SMVParseException("Cannot do aritmatic operation"
							+ "on constant with other then single value.");
				Integer int_val = new Integer(vals[0]);
				ValueIntStmt other = lc ? rv.toValueIntStmt() : lv
						.toValueIntStmt();
				return lc ? ValueIntStmt.EQOpWithCons(int_val, other)
						: ValueIntStmt.EQOpWithCons(other, int_val);
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Caanot do aritmatic operation "
						+ "on string values.");
			}
		}

		// any other variation of domain/integer/bdd is done through int.
		return ValueIntStmt.EQOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	}

	@Override
	protected ValueStmt doDom2BDDNode(ValueDomStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		if (lv.isBoolDomain() | lv.isOpBoolDomain()) {
			return new ValueBDDStmt(lv.getContext(), lv.toBDD().id().biimp(
					rv.toBDD().id()));
		}
		return ValueIntStmt.EQOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	}

	@Override
	protected ValueStmt doBDD2DomNode(ValueBDDStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		if (rv.isBoolDomain() | rv.isOpBoolDomain()) {
			return new ValueBDDStmt(lv.getContext(), lv.toBDD().id().biimp(
					rv.toBDD().id()));
		}
		return ValueIntStmt.EQOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	}

	// @Override
	// protected ValueStmt doBDD2BDDNode(ValueBDDStmt lv, ValueBDDStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doBDD2ConsRangeNode(ValueBDDStmt lv,
	// ValueConsRangeStmt rv) throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doBDD2ConsStrNode(ValueBDDStmt lv, ValueConsStrStmt
	// rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }

	// @Override
	// protected ValueStmt doBDD2IntNode(ValueBDDStmt lv, ValueIntStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doConsRange2BDDNode(ValueConsRangeStmt lv,
	// ValueBDDStmt rv) throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doConsRange2IntNode(ValueConsRangeStmt lv,
	// ValueIntStmt rv) throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doConsStr2BDDNode(ValueConsStrStmt lv, ValueBDDStmt
	// rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doConsStr2IntNode(ValueConsStrStmt lv, ValueIntStmt
	// rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doDom2BDDNode(ValueDomStmt lv, ValueBDDStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }

	@Override
	protected ValueStmt doDom2DomNode(ValueDomStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		// new ValueBDDStmt(lv.getContext(), lv
		return new ValueBDDStmt(lv.getContext(), lv.biimpDomain(rv));
	}

	// @Override
	// protected ValueStmt doDom2IntNode(ValueDomStmt lv, ValueIntStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doInt2BDDNode(ValueIntStmt lv, ValueBDDStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doInt2ConsRangeNode(ValueIntStmt lv,
	// ValueConsRangeStmt rv) throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doInt2ConsStrNode(ValueIntStmt lv, ValueConsStrStmt
	// rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doInt2DomNode(ValueIntStmt lv, ValueDomStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doInt2IntNode(ValueIntStmt lv, ValueIntStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.DivOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// all domain to constants...
	@Override
	protected ValueStmt doDom2ConsRangeNode(ValueDomStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		return new ValueBDDStmt(lv.getContext(), lv.aboveEqIntToBDD(
				rv.fromRange().intValue()).and(
				lv.belowEqIntToBDD(rv.toRange().intValue())));
	}

	@Override
	protected ValueStmt doConsStr2DomNode(ValueConsStrStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		return new ValueBDDStmt(lv.getContext(), rv.strToBDD(lv.getValues()));
	}

	@Override
	protected ValueStmt doConsRange2DomNode(ValueConsRangeStmt lv,
			ValueDomStmt rv) throws SMVParseException {
		return new ValueBDDStmt(lv.getContext(), rv.aboveEqIntToBDD(
				lv.fromRange().intValue()).and(
				rv.belowEqIntToBDD(lv.toRange().intValue())));
	}

	@Override
	protected ValueStmt doDom2ConsStrNode(ValueDomStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		return new ValueBDDStmt(lv.getContext(), lv.strToBDD(rv.getValues()));
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// all inter constants...
	@Override
	protected ValueStmt doConsRange2ConsRangeNode(ValueConsRangeStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if ((lv.fromRange() == rv.fromRange())
				&& (lv.toRange() == rv.toRange())) {
			return new ValueBDDStmt(lv.getContext(), Env.TRUE());
		}
		return new ValueBDDStmt(lv.getContext(), Env.FALSE());
	}

	@Override
	protected ValueStmt doConsRange2ConsStrNode(ValueConsRangeStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		try {
			ValueConsRangeStmt rvd = rv.toValueConsRangeStmt();
			if ((lv.fromRange() == rvd.fromRange())
					&& (lv.toRange() == rvd.toRange())) {
				return new ValueBDDStmt(lv.getContext(), Env.TRUE());
			}
		} catch (SMVParseException smp) {
		}
		return new ValueBDDStmt(lv.getContext(), Env.FALSE());
	}

	@Override
	protected ValueStmt doConsStr2ConsRangeNode(ValueConsStrStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		try {
			ValueConsRangeStmt lvd = lv.toValueConsRangeStmt();
			if ((lvd.fromRange() == rv.fromRange())
					&& (lvd.toRange() == rv.toRange())) {
				return new ValueBDDStmt(lv.getContext(), Env.TRUE());
			}
		} catch (SMVParseException smp) {
		}
		return new ValueBDDStmt(lv.getContext(), Env.FALSE());
	}

	@Override
	protected ValueStmt doConsStr2ConsStrNode(ValueConsStrStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		for (String l_str : lv.getValues()) {
			boolean has_match = false;
			for (String r_str : rv.getValues())
				if (l_str.equals(r_str)) {
					has_match = true;
					break;
				}
			if (!has_match)
				return new ValueBDDStmt(lv.getContext(), Env.FALSE());
		}
		return new ValueBDDStmt(lv.getContext(), Env.TRUE());
	}

}
