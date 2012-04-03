package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.core.smv.SMVParseException;

public class OpUnaryMinus extends AbstractUnaryOperator implements
		IAritOperator {

	public OpUnaryMinus(AbstractElement a_val) throws SMVParseException {
		super(a_val);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		// Could be improved.
		ValueIntStmt int_val = this.getVal().do_eval().toValueIntStmt();
		ValueIntStmt res = new ValueIntStmt(int_val.getContext(), int_val
				.getBDDVarSet());
		for (BDD single : int_val.getAllBDDAssigned()) {
			for (Integer val : int_val.getValue(single)) {
				int op_val = -val.intValue();
				res.addValue(single, new Integer(op_val));
			}
		}
		return res;
	}

	@Override
	public String elemToString() {
		return "-";
	}

	@Override
	protected OpUnaryMinus duplicate() throws SMVParseException {
		return new OpUnaryMinus(this.getVal());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt v) throws SMVParseException {
		// Could be improved.
		ValueIntStmt int_val = v.toValueIntStmt();
		ValueIntStmt res = new ValueIntStmt(int_val.getContext(), int_val
				.getBDDVarSet());
		for (BDD single : int_val.getAllBDDAssigned()) {
			for (Integer val : int_val.getValue(single)) {
				int op_val = -val.intValue();
				res.addValue(single, new Integer(op_val));
			}
		}
		return res;
	}

	protected ValueStmt doConsRangeNode(ValueConsRangeStmt v)
			throws SMVParseException {
		return new ValueConsRangeStmt(v.getContext(), -v.toRange().intValue(),
				-v.fromRange().intValue());
	}

	protected ValueStmt doConsStrNode(ValueConsStrStmt v)
			throws SMVParseException {
		try {
			String[] old_str = v.getValues();
			String[] new_str = new String[old_str.length];
			for (int i = 0; i < new_str.length; i++) {
				int val = Integer.parseInt(old_str[i]);
				val = -val;
				new_str[i] = "" + val;
			}
			return new ValueConsStrStmt(v.getContext(), new_str);
		} catch (NumberFormatException nfe) {
			throw new SMVParseException("Caanot do aritmatic operation "
					+ "on string values.");
		}
	}

}
