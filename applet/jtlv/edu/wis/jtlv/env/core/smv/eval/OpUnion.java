package edu.wis.jtlv.env.core.smv.eval;

import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

//not clear what does it implement
public class OpUnion extends AbstractBinaryOperator {

	public OpUnion(AbstractElement a_left, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		ValueStmt l = this.getLeft().do_eval();
		ValueStmt r = this.getRight().do_eval();

		// case both are constants
		boolean c2c = l.isValueConsStmt() & r.isValueConsStmt();
		// case both are domains
		boolean d2d = l.isValueDomStmt() & r.isValueDomStmt();
		// case one is domain and the other is constant
		boolean d2c = l.isValueDomStmt() & r.isValueConsStmt();
		boolean c2d = l.isValueConsStmt() & r.isValueDomStmt();

		if (c2c | d2d | d2c | c2d) {
			String[] l_vals = (c2c | c2d) ? l.toValueConsStmt()
					.toValueConsStrStmt().getValues() : l.toValueDomStmt()
					.getValues();
			String[] r_vals = (c2c | d2c) ? r.toValueConsStmt()
					.toValueConsStrStmt().getValues() : r.toValueDomStmt()
					.getValues();
			SMVModule m = d2d ? l.toValueDomStmt().getContext() : d2c ? r
					.toValueConsStmt().getContext() : l.toValueConsStmt()
					.getContext();
			Vector<String> new_cons_vals = new Vector<String>(10);
			for (String str : l_vals) {
				new_cons_vals.add(str);
			}
			for (String str : r_vals) {
				new_cons_vals.add(str);
			}
			String[] new_cons_vals_arr = new String[new_cons_vals.size()];
			new_cons_vals.toArray(new_cons_vals_arr);
			return new ValueConsStrStmt(m, new_cons_vals_arr);
		}

		// now I know that at least on of them is either an integer or a BDD
		// which forces me to do it in an integer way...

		ValueIntStmt l_int = l.toValueIntStmt();
		ValueIntStmt r_int = r.toValueIntStmt();

		BDDVarSet new_var_set = l_int.getBDDVarSet()
				.union(r_int.getBDDVarSet());
		ValueIntStmt res = new ValueIntStmt(l.getContext(), new_var_set);
		for (BDD l_single : l_int.getAllBDDAssigned()) {
			for (BDD r_single : r_int.getAllBDDAssigned()) {
				BDD new_bdd_val = l_single.and(r_single);
				if (!new_bdd_val.isZero()) {
					for (Integer val : l_int.getValue(l_single)) {
						res.addValue(new_bdd_val, val);
					}
					for (Integer val : r_int.getValue(r_single)) {
						res.addValue(new_bdd_val, val);
					}
				}
			}
		}
		return res;
	}

	@Override
	public String elemToString() {
		return "UNION";
	}

	@Override
	protected OpUnion duplicate() throws SMVParseException {
		return new OpUnion(this.getLeft(), this.getRight());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// TODO: work on the kind of implementations...

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		ValueIntStmt l_int = lv.toValueIntStmt();
		ValueIntStmt r_int = rv.toValueIntStmt();

		BDDVarSet new_var_set = l_int.getBDDVarSet()
				.union(r_int.getBDDVarSet());
		ValueIntStmt res = new ValueIntStmt(lv.getContext(), new_var_set);
		for (BDD l_single : l_int.getAllBDDAssigned()) {
			for (BDD r_single : r_int.getAllBDDAssigned()) {
				BDD new_bdd_val = l_single.and(r_single);
				if (!new_bdd_val.isZero()) {
					for (Integer val : l_int.getValue(l_single)) {
						res.addValue(new_bdd_val, val);
					}
					for (Integer val : r_int.getValue(r_single)) {
						res.addValue(new_bdd_val, val);
					}
				}
			}
		}
		return res;
		// throw new SMVParseException("Cannot do Union operation on the given"
		// + " operands.");
	}

	@Override
	protected ValueStmt doConsRange2ConsRangeNode(ValueConsRangeStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		int lfrom = lv.fromRange().intValue();
		int lto = lv.toRange().intValue();
		int rfrom = rv.fromRange().intValue();
		int rto = rv.toRange().intValue();
		if (((lfrom <= rfrom) & (lto >= rfrom))
				| ((rfrom <= lfrom) & (rto >= lfrom))) {
			return new ValueConsRangeStmt(lv.getContext(), Math.min(lfrom,
					rfrom), Math.max(lto, rto));
		}
		// Could and should be improve in performance.
		return doConsStr2ConsStrNode(lv.toValueConsStrStmt(), rv
				.toValueConsStrStmt());
	}

	@Override
	protected ValueStmt doConsRange2ConsStrNode(ValueConsRangeStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		try {
			return doConsRange2ConsRangeNode(lv, rv.toValueConsRangeStmt());
		} catch (SMVParseException smp) {
			// cannot convert str to range cons... do nothing... continuing
		}
		return doConsStr2ConsStrNode(lv.toValueConsStrStmt(), rv);
	}

	@Override
	protected ValueStmt doConsStr2ConsRangeNode(ValueConsStrStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		try {
			return doConsRange2ConsRangeNode(lv.toValueConsRangeStmt(), rv);
		} catch (SMVParseException smp) {
			// cannot convert str to range cons... do nothing... continuing
		}
		return doConsStr2ConsStrNode(lv, rv.toValueConsStrStmt());
	}

	@Override
	protected ValueStmt doConsStr2ConsStrNode(ValueConsStrStmt lv,
			ValueConsStrStmt rv) throws SMVParseException {
		Vector<String> all_vals = new Vector<String>(20);
		for (String str : lv.getValues()) {
			all_vals.add(str);
		}
		for (String str : rv.getValues()) {
			all_vals.add(str);
		}
		String[] all_vals_arr = new String[all_vals.size()];
		all_vals.toArray(all_vals_arr);
		return new ValueConsStrStmt(lv.getContext(), all_vals_arr);
	}

	@Override
	protected ValueStmt doConsRange2DomNode(ValueConsRangeStmt lv,
			ValueDomStmt rv) throws SMVParseException {
		return doConsRange2ConsStrNode(lv, rv.toValueConsStmt()
				.toValueConsStrStmt());
	}

	@Override
	protected ValueStmt doDom2ConsRangeNode(ValueDomStmt lv,
			ValueConsRangeStmt rv) throws SMVParseException {
		return doConsStr2ConsRangeNode(lv.toValueConsStmt()
				.toValueConsStrStmt(), rv);
	}

	@Override
	protected ValueStmt doDom2ConsStrNode(ValueDomStmt lv, ValueConsStrStmt rv)
			throws SMVParseException {
		return doConsStr2ConsStrNode(lv.toValueConsStmt().toValueConsStrStmt(),
				rv);
	}

	@Override
	protected ValueStmt doConsStr2DomNode(ValueConsStrStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		return doConsStr2ConsStrNode(lv, rv.toValueConsStmt()
				.toValueConsStrStmt());
	}

	@Override
	protected ValueStmt doDom2DomNode(ValueDomStmt lv, ValueDomStmt rv)
			throws SMVParseException {
		return doConsStr2ConsStrNode(lv.toValueConsStmt().toValueConsStrStmt(),
				rv.toValueConsStmt().toValueConsStrStmt());
	}

	// @Override
	// protected ValueStmt doConsRange2IntNode(ValueConsRangeStmt lv,
	// ValueIntStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsStr2IntNode(ValueConsStrStmt lv, ValueIntStmt
	// rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doInt2ConsRangeNode(ValueIntStmt lv,
	// ValueConsRangeStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doInt2ConsStrNode(ValueIntStmt lv, ValueConsStrStmt
	// rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doBDD2BDDNode(ValueBDDStmt lv, ValueBDDStmt rv)
	// throws SMVParseException {
	// return new ValueBDDStmt(lv.getContext(), lv.toBDD().or(rv.toBDD()));
	// }
	//
	// @Override
	// protected ValueStmt doBDD2DomNode(ValueBDDStmt lv, ValueDomStmt rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doBDD2IntNode(ValueBDDStmt lv, ValueIntStmt rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doDom2BDDNode(ValueDomStmt lv, ValueBDDStmt rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doInt2BDDNode(ValueIntStmt lv, ValueBDDStmt rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doDom2IntNode(ValueDomStmt lv, ValueIntStmt rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doInt2DomNode(ValueIntStmt lv, ValueDomStmt rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doInt2IntNode(ValueIntStmt lv, ValueIntStmt rv)
	// throws SMVParseException {
	// }
}
