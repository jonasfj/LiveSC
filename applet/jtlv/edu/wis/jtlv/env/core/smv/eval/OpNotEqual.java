package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;

//not clear what does it implement
public class OpNotEqual extends AbstractBinaryOperator {

	public OpNotEqual(AbstractElement a_left, AbstractElement a_right)
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
			for (String l_str : lc.toValueConsStrStmt().getValues()) {
				boolean has_match = false;
				for (String r_str : rc.toValueConsStrStmt().getValues())
					if (l_str.equals(r_str)) {
						has_match = true;
						break;
					}
				if (has_match)
					return new ValueBDDStmt(l.getContext(), Env.FALSE());
			}
			return new ValueBDDStmt(l.getContext(), Env.TRUE());
		}
		// case one is domain and the other is constant
		boolean d2c = l.isValueDomStmt() & r.isValueConsStmt();
		boolean c2d = l.isValueConsStmt() & r.isValueDomStmt();
		if (d2c | c2d) {
			ValueDomStmt d = d2c ? l.toValueDomStmt() : r.toValueDomStmt();
			ValueConsStmt c = d2c ? r.toValueConsStmt() : l.toValueConsStmt();
			return new ValueBDDStmt(l.getContext(), d.notStrToBDD(c
					.toValueConsStrStmt().getValues()));
		}

		boolean ld = l.isValueDomStmt();
		boolean rd = r.isValueDomStmt();
		if (ld & rd) {
			return new ValueBDDStmt(l.getContext(), l.toValueDomStmt()
					.biimpDomain(r.toValueDomStmt()).not());
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
				return lc ? ValueIntStmt.NEQOpWithCons(int_val, other)
						: ValueIntStmt.NEQOpWithCons(other, int_val);
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Caanot do aritmatic operation "
						+ "on string values.");
			}
		}

		// any other variation of domain/integer/bdd is done through int.
		return ValueIntStmt.NEQOp(l.toValueIntStmt(), r.toValueIntStmt());
	}

	@Override
	public String elemToString() {
		return "!=";
	}

	@Override
	protected OpNotEqual duplicate() throws SMVParseException {
		return new OpNotEqual(this.getLeft(), this.getRight());
	}

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
			ValueStmt l = lv;
			ValueStmt r = rv;
			// case both are constants
			if (l.isValueConsStmt() & r.isValueConsStmt()) {
				ValueConsStmt lc = l.toValueConsStmt();
				ValueConsStmt rc = r.toValueConsStmt();
				for (String l_str : lc.toValueConsStrStmt().getValues()) {
					boolean has_match = false;
					for (String r_str : rc.toValueConsStrStmt().getValues())
						if (l_str.equals(r_str)) {
							has_match = true;
							break;
						}
					if (has_match)
						return new ValueBDDStmt(l.getContext(), Env.FALSE());
				}
				return new ValueBDDStmt(l.getContext(), Env.TRUE());
			}
			// case one is domain and the other is constant
			boolean d2c = l.isValueDomStmt() & r.isValueConsStmt();
			boolean c2d = l.isValueConsStmt() & r.isValueDomStmt();
			if (d2c | c2d) {
				ValueDomStmt d = d2c ? l.toValueDomStmt() : r.toValueDomStmt();
				ValueConsStmt c = d2c ? r.toValueConsStmt() : l.toValueConsStmt();
				return new ValueBDDStmt(l.getContext(), d.notStrToBDD(c
						.toValueConsStrStmt().getValues()));
			}

			boolean ld = l.isValueDomStmt();
			boolean rd = r.isValueDomStmt();
			if (ld & rd) {
				return new ValueBDDStmt(l.getContext(), l.toValueDomStmt()
						.biimpDomain(r.toValueDomStmt()).not());
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
					return lc ? ValueIntStmt.NEQOpWithCons(int_val, other)
							: ValueIntStmt.NEQOpWithCons(other, int_val);
				} catch (NumberFormatException nfe) {
					throw new SMVParseException("Caanot do aritmatic operation "
							+ "on string values.");
				}
			}

			// any other variation of domain/integer/bdd is done through int.
			return ValueIntStmt.NEQOp(l.toValueIntStmt(), r.toValueIntStmt());
	}
}
