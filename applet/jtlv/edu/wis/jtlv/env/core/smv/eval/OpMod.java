package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.core.smv.SMVParseException;

public class OpMod extends AbstractBinaryOperator implements IAritOperator {

	public OpMod(AbstractElement a_left, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		ValueStmt l = this.getLeft().do_eval();
		ValueStmt r = this.getRight().do_eval();

		// if no of the values is constant
		boolean lc = l.isValueConsStmt();
		boolean rc = r.isValueConsStmt();
		if (lc & rc) {
			try {
				String[] l_vals = l.toValueConsStmt().toValueConsStrStmt()
						.getValues();
				String[] r_vals = r.toValueConsStmt().toValueConsStrStmt()
						.getValues();
				if ((l_vals.length != 1) | (r_vals.length != 1))
					throw new SMVParseException("Cannot do aritmatic operation"
							+ "on constant with other then single value.");
				int new_val = Integer.parseInt(l_vals[0])
						% Integer.parseInt(r_vals[0]);
				String val_str = "" + new_val;
				return new ValueConsStrStmt(l.getContext(),
						new String[] { val_str });
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Caanot do aritmatic operation "
						+ "on string values.");
			}
		}

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
				return lc ? ValueIntStmt.ModOpWithCons(int_val, other)
						: ValueIntStmt.ModOpWithCons(other, int_val);
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Caanot do aritmatic operation "
						+ "on string values.");
			}
		}

		return ValueIntStmt.ModOp(l.toValueIntStmt(), r.toValueIntStmt());
	}

	@Override
	public String elemToString() {
		return "%";
	}

	@Override
	protected OpMod duplicate() throws SMVParseException {
		return new OpMod(this.getLeft(), this.getRight());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	
	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		return ValueIntStmt.ModOp(lv.toValueIntStmt(), rv.toValueIntStmt());
	}

	@Override
	protected ValueStmt doBDD2ConsRangeNode(ValueBDDStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		return ValueIntStmt.ModOpWithCons(lv.toValueIntStmt(), rv.fromRange());
	}

	@Override
	protected ValueStmt doBDD2ConsStrNode(ValueBDDStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			return ValueIntStmt.ModOpWithCons(lv.toValueIntStmt(), new Integer(
					rv.getValues()[0]));
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsRange2BDDNode(ValueConsRangeStmt lv,
			ValueBDDStmt rv) throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		return ValueIntStmt.ModOpWithCons(lv.fromRange(), rv.toValueIntStmt());
	}

	@Override
	protected ValueStmt doConsRange2ConsRangeNode(ValueConsRangeStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if ((!lv.isSingleValue()) | (!rv.isSingleValue()))
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		int div_val = lv.fromRange().intValue() % rv.fromRange().intValue();
		return new ValueConsRangeStmt(lv.getContext(), div_val, div_val);
	}

	@Override
	protected ValueStmt doConsRange2ConsStrNode(ValueConsRangeStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		if ((!lv.isSingleValue()) | (!rv.isSingleValue()))
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			int div_val = lv.fromRange().intValue()
					% new Integer(rv.getValues()[0]).intValue();
			return new ValueConsRangeStmt(lv.getContext(), div_val, div_val);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsRange2DomNode(ValueConsRangeStmt lv,
			ValueDomStmt rv) throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		return ValueIntStmt.ModOpWithCons(lv.fromRange(), rv.toValueIntStmt());
	}

	@Override
	protected ValueStmt doConsRange2IntNode(ValueConsRangeStmt lv,
			ValueIntStmt rv) throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		return ValueIntStmt.ModOpWithCons(lv.fromRange(), rv.toValueIntStmt());
	}

	@Override
	protected ValueStmt doConsStr2BDDNode(ValueConsStrStmt lv, ValueBDDStmt rv)
			throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			return ValueIntStmt.ModOpWithCons(new Integer(lv.getValues()[0]),
					rv.toValueIntStmt());
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
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
			int div_val = new Integer(lv.getValues()[0]).intValue()
					% rv.fromRange().intValue();
			return new ValueConsRangeStmt(lv.getContext(), div_val, div_val);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
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
			int div_val = new Integer(lv.getValues()[0]).intValue()
					% new Integer(rv.getValues()[0]).intValue();
			return new ValueConsRangeStmt(lv.getContext(), div_val, div_val);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsStr2DomNode(ValueConsStrStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			return ValueIntStmt.ModOpWithCons(new Integer(lv.getValues()[0]),
					rv.toValueIntStmt());
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doConsStr2IntNode(ValueConsStrStmt lv, ValueIntStmt rv)
			throws SMVParseException {
		if (!lv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			return ValueIntStmt.ModOpWithCons(new Integer(lv.getValues()[0]),
					rv.toValueIntStmt());
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doDom2ConsRangeNode(ValueDomStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		return ValueIntStmt.ModOpWithCons(lv.toValueIntStmt(), rv.fromRange());
	}

	@Override
	protected ValueStmt doDom2ConsStrNode(ValueDomStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			return ValueIntStmt.ModOpWithCons(lv.toValueIntStmt(), new Integer(
					rv.getValues()[0]));
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
					+ "on string values.");
		}
	}

	@Override
	protected ValueStmt doInt2ConsRangeNode(ValueIntStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		return ValueIntStmt.ModOpWithCons(lv.toValueIntStmt(), rv.fromRange());
	}

	@Override
	protected ValueStmt doInt2ConsStrNode(ValueIntStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		if (!rv.isSingleValue())
			throw new SMVParseException("Cannot do aritmatic operation"
					+ "on constant with other then single value.");
		try {
			return ValueIntStmt.ModOpWithCons(lv.toValueIntStmt(), new Integer(
					rv.getValues()[0]));
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
					+ "on string values.");
		}
	}
}
