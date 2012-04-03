package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;

public class OpLT extends AbstractBinaryOperator implements IAritOperator {

	public OpLT(AbstractElement a_left, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		ValueStmt l = this.getLeft().do_eval();
		ValueStmt r = this.getRight().do_eval();
		// case both are constants
		if (l.isValueConsStmt() & r.isValueConsStmt()) {
			ValueConsStmt lc = l.toValueConsStmt();
			ValueConsStmt rc = r.toValueConsStmt();
			String[] l_vals = lc.toValueConsStrStmt().getValues();
			String[] r_vals = rc.toValueConsStrStmt().getValues();
			if ((l_vals.length != 1) | (r_vals.length != 1))
				throw new SMVParseException("Cannot do LT operator for "
						+ "other then a single value.");
			try {
				int l_int_val = Integer.parseInt(l_vals[0]);
				int r_int_val = Integer.parseInt(r_vals[0]);
				if (l_int_val < r_int_val) {
					return new ValueBDDStmt(l.getContext(), Env.TRUE());
				}
				return new ValueBDDStmt(l.getContext(), Env.FALSE());
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Cannot do LT operator for "
						+ "constant which is not an integer.");
			}
		}
		// case one is domain and the other is constant
		boolean d2c = l.isValueDomStmt() & r.isValueConsStmt();
		boolean c2d = l.isValueConsStmt() & r.isValueDomStmt();
		if (d2c | c2d) {
		}

		// if no of the values is constant
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
				return lc ? ValueIntStmt.LTOpWithCons(int_val, other)
						: ValueIntStmt.LTOpWithCons(other, int_val);
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Cannot do aritmatic operation "
						+ "on string values.");
			}
		}

		// any other variation of domain/integer/bdd is done through int.
		return ValueIntStmt.LTOp(l.toValueIntStmt(), r.toValueIntStmt());
	}

	@Override
	public String elemToString() {
		return "<";
	}

	@Override
	protected OpLT duplicate() throws SMVParseException {
		return new OpLT(this.getLeft(), this.getRight());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		// not really used in this operator...
		return ValueIntStmt.LTOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	}

	@Override
	protected ValueStmt doBDD2ConsRangeNode(ValueBDDStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		int val = rv.fromRange().intValue();
		if (val > 1) // all is true
			return new ValueConsRangeStmt(lv.getContext(), 1, 1);
		if (val == 1)
			return new ValueBDDStmt(lv.getContext(), lv.toBDD().not());
		// else all if false
		return new ValueConsRangeStmt(lv.getContext(), 0, 0);
	}

	@Override
	protected ValueStmt doBDD2ConsStrNode(ValueBDDStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			int val = Integer.parseInt(rv.getValues()[0]);
			if (val > 1) // all is true
				return new ValueConsRangeStmt(lv.getContext(), 1, 1);
			if (val == 1)
				return new ValueBDDStmt(lv.getContext(), lv.toBDD().not());
			// else all if false
			return new ValueConsRangeStmt(lv.getContext(), 0, 0);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsRange2BDDNode(ValueConsRangeStmt lv,
			ValueBDDStmt rv) throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		int val = lv.fromRange().intValue();
		if (val < 0) // all is true
			return new ValueConsRangeStmt(lv.getContext(), 1, 1);
		if (val == 0)
			return new ValueBDDStmt(lv.getContext(), rv.toBDD());
		// else all if false
		return new ValueConsRangeStmt(lv.getContext(), 0, 0);
	}

	@Override
	protected ValueStmt doConsRange2ConsRangeNode(ValueConsRangeStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if ((!lv.isSingleValue()) | (!rv.isSingleValue()))
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		boolean bval = lv.fromRange().intValue() < rv.fromRange().intValue();
		if (bval)
			return new ValueConsRangeStmt(lv.getContext(), 1, 1);
		else
			return new ValueConsRangeStmt(lv.getContext(), 0, 0);
	}

	@Override
	protected ValueStmt doConsRange2ConsStrNode(ValueConsRangeStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		if ((!lv.isSingleValue()) | (!rv.isSingleValue()))
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			boolean bval = lv.fromRange().intValue() < new Integer(rv
					.getValues()[0]).intValue();
			if (bval)
				return new ValueConsRangeStmt(lv.getContext(), 1, 1);
			else
				return new ValueConsRangeStmt(lv.getContext(), 0, 0);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsRange2DomNode(ValueConsRangeStmt lv,
			ValueDomStmt rv) throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		int int_val = lv.fromRange().intValue();
		BDD b = rv.aboveIntToBDD(int_val);
		return new ValueBDDStmt(lv.getContext(), b);
	}

	@Override
	protected ValueStmt doConsRange2IntNode(ValueConsRangeStmt lv,
			ValueIntStmt rv) throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		return ValueIntStmt.LTOpWithCons(lv.fromRange(), rv.toValueIntStmt());
	}

	@Override
	protected ValueStmt doConsStr2BDDNode(ValueConsStrStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			int val = Integer.parseInt(lv.getValues()[0]);
			if (val < 0) // all is true
				return new ValueConsRangeStmt(lv.getContext(), 1, 1);
			if (val == 0)
				return new ValueBDDStmt(lv.getContext(), lv.toBDD());
			// else all if false
			return new ValueConsRangeStmt(lv.getContext(), 0, 0);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsStr2ConsRangeNode(ValueConsStrStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if ((!lv.isSingleValue()) | (!rv.isSingleValue()))
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			boolean bval = new Integer(lv.getValues()[0]).intValue() < rv
					.fromRange().intValue();
			if (bval)
				return new ValueConsRangeStmt(lv.getContext(), 1, 1);
			else
				return new ValueConsRangeStmt(lv.getContext(), 0, 0);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsStr2ConsStrNode(ValueConsStrStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		if ((!lv.isSingleValue()) | (!rv.isSingleValue()))
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			boolean bval = new Integer(lv.getValues()[0]).intValue() < new Integer(
					rv.getValues()[0]).intValue();
			if (bval)
				return new ValueConsRangeStmt(lv.getContext(), 1, 1);
			else
				return new ValueConsRangeStmt(lv.getContext(), 0, 0);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsStr2DomNode(ValueConsStrStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		String[] vals = lv.getValues();
		try {
			int int_val = Integer.parseInt(vals[0]);
			BDD res = rv.aboveIntToBDD(int_val);
			return new ValueBDDStmt(lv.getContext(), res);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do LT operator for "
					+ "constant which is not an integer.");
		}
	}

	@Override
	protected ValueStmt doConsStr2IntNode(ValueConsStrStmt lv, ValueIntStmt rv)
			throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			return ValueIntStmt.LTOpWithCons(new Integer(lv.getValues()[0]), rv
					.toValueIntStmt());
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doDom2ConsRangeNode(ValueDomStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		int int_val = rv.fromRange().intValue();
		BDD res = lv.belowIntToBDD(int_val);
		return new ValueBDDStmt(lv.getContext(), res);
	}

	@Override
	protected ValueStmt doDom2ConsStrNode(ValueDomStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		String[] vals = rv.getValues();
		try {
			int int_val = Integer.parseInt(vals[0]);
			BDD res = lv.belowIntToBDD(int_val);
			return new ValueBDDStmt(lv.getContext(), res);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do LT operator for "
					+ "constant which is not an integer.");
		}
	}

	@Override
	protected ValueStmt doInt2ConsRangeNode(ValueIntStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		return ValueIntStmt.LTOpWithCons(lv.toValueIntStmt(), rv.fromRange());
	}

	@Override
	protected ValueStmt doInt2ConsStrNode(ValueIntStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			return ValueIntStmt.LTOpWithCons(lv.toValueIntStmt(), new Integer(
					rv.getValues()[0]));
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do aritmatic operation "
					+ "on string values.");
		}
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doBDD2BDDNode(ValueBDDStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		// better performance then the default...
		BDD res = lv.toBDD().not().and(rv.toBDD());
		return new ValueBDDStmt(lv.getContext(), res);
	}

	@Override
	protected ValueStmt doBDD2DomNode(ValueBDDStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		// better performance then the default...
		BDD res = rv.aboveIntToBDD(1).and(lv.toBDD());
		res = res.or(rv.aboveIntToBDD(0));
		return new ValueBDDStmt(lv.getContext(), res);
	}

	@Override
	protected ValueStmt doBDD2IntNode(ValueBDDStmt lv, ValueIntStmt rv)
			throws SMVParseException {
		// better performance then the default...
		BDD res = rv.aboveIntToBDD(1).and(lv.toBDD());
		res = res.or(rv.aboveIntToBDD(0));
		return new ValueBDDStmt(lv.getContext(), res);
	}

	@Override
	protected ValueStmt doDom2BDDNode(ValueDomStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		// better performance then the default...
		BDD b = lv.belowIntToBDD(1).and(rv.toBDD());
		b = b.or(lv.belowIntToBDD(0));
		return new ValueBDDStmt(lv.getContext(), b);
	}

	@Override
	protected ValueStmt doDom2DomNode(ValueDomStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		String[] vals = rv.getValues();
		try {
			BDD b = Env.FALSE();
			for (int i = 0; i < vals.length; i++) {
				int int_val = Integer.parseInt(vals[i]);
				b = b.or(lv.belowIntToBDD(int_val).and(rv.intToBDD(int_val)));
			}
			return new ValueBDDStmt(lv.getContext(), b);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Cannot do LT operator for "
					+ "constant which is not an integer.");
		}
	}

	@Override
	protected ValueStmt doInt2BDDNode(ValueIntStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		// better performance then the default...
		BDD res = lv.belowIntToBDD(1).and(rv.toBDD());
		res = res.or(lv.belowIntToBDD(0));
		return new ValueBDDStmt(lv.getContext(), res);
	}

	// @Override
	// protected ValueStmt doDom2IntNode(ValueDomStmt lv, ValueIntStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.LTOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doInt2DomNode(ValueIntStmt lv, ValueDomStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.LTOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
	//
	// @Override
	// protected ValueStmt doInt2IntNode(ValueIntStmt lv, ValueIntStmt rv)
	// throws SMVParseException {
	// return ValueIntStmt.LTOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	// }
}
