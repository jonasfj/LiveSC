package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;

//not clear what does it implement
public class OpIn extends AbstractBinaryOperator {

	public OpIn(AbstractElement a_left, AbstractElement a_right)
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
			for (String r_v : r_vals) {
				boolean has_value = false;
				for (String l_v : l_vals) {
					if (r_v.equals(l_v)) {
						has_value = true;
						break;
					}
				}
				if (!has_value)
					return new ValueBDDStmt(l.getContext(), Env.FALSE());
			}
			return new ValueBDDStmt(l.getContext(), Env.TRUE());
		}

		// case both are domains
		if (l.isValueDomStmt() & r.isValueDomStmt()) {
			ValueDomStmt lc = l.toValueDomStmt();
			ValueDomStmt rc = r.toValueDomStmt();
			return new ValueBDDStmt(l.getContext(), lc.strToBDD(rc.getValues()));
		}

		// case one is domain and the other is constant
		if (l.isValueDomStmt() & r.isValueConsStmt()) {
			String[] vals = r.toValueConsStmt().toValueConsStrStmt()
					.getValues();
			return new ValueBDDStmt(l.getContext(), l.toValueDomStmt()
					.strToBDD(vals));
		}
		if (l.isValueConsStmt() & r.isValueDomStmt()) {
			for (String l_val : l.toValueConsStmt().toValueConsStrStmt()
					.getValues()) {
				boolean found = false;
				for (String r_val : r.toValueDomStmt().getValues()) {
					if (l_val.equals(r_val))
						found = true;
					if (found)
						break;
				}
				if (!found)
					return new ValueBDDStmt(l.getContext(), Env.FALSE());
			}
			return new ValueBDDStmt(l.getContext(), Env.TRUE());
		}

		// now I know that at least on of them is either an integer or a BDD
		// which forces me to do it in an integer way...

		ValueIntStmt l_int = l.toValueIntStmt();
		ValueIntStmt r_int = r.toValueIntStmt();

		BDD res = Env.FALSE().id();
		for (BDD l_single : l_int.getAllBDDAssigned()) {
			for (Integer l_val : l_int.getValue(l_single)) {
				for (BDD r_single : r_int.getAllBDDAssigned()) {
					BDD new_bdd_val = l_single.and(r_single);
					if (!new_bdd_val.isZero()) {
						for (Integer r_val : r_int.getValue(r_single)) {
							if (l_val.intValue() == r_val.intValue())
								res = res.id().or(l_single);
						}
					}
				}
			}
		}
		return new ValueBDDStmt(l.getContext(), res);
	}

	@Override
	public String elemToString() {
		return "IN";
	}

	@Override
	protected OpIn duplicate() throws SMVParseException {
		return new OpIn(this.getLeft(), this.getRight());
	}


	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt lv, ValueStmt rv)
			throws SMVParseException {
		ValueStmt l = lv;
		ValueStmt r = rv;

		// case both are constants
		if (l.isValueConsStmt() & r.isValueConsStmt()) {
			ValueConsStmt lc = l.toValueConsStmt();
			ValueConsStmt rc = r.toValueConsStmt();
			String[] l_vals = lc.toValueConsStrStmt().getValues();
			String[] r_vals = rc.toValueConsStrStmt().getValues();
			for (String r_v : r_vals) {
				boolean has_value = false;
				for (String l_v : l_vals) {
					if (r_v.equals(l_v)) {
						has_value = true;
						break;
					}
				}
				if (!has_value)
					return new ValueBDDStmt(l.getContext(), Env.FALSE());
			}
			return new ValueBDDStmt(l.getContext(), Env.TRUE());
		}

		// case both are domains
		if (l.isValueDomStmt() & r.isValueDomStmt()) {
			ValueDomStmt lc = l.toValueDomStmt();
			ValueDomStmt rc = r.toValueDomStmt();
			return new ValueBDDStmt(l.getContext(), lc.strToBDD(rc.getValues()));
		}

		// case one is domain and the other is constant
		if (l.isValueDomStmt() & r.isValueConsStmt()) {
			String[] vals = r.toValueConsStmt().toValueConsStrStmt()
					.getValues();
			return new ValueBDDStmt(l.getContext(), l.toValueDomStmt()
					.strToBDD(vals));
		}
		if (l.isValueConsStmt() & r.isValueDomStmt()) {
			for (String l_val : l.toValueConsStmt().toValueConsStrStmt()
					.getValues()) {
				boolean found = false;
				for (String r_val : r.toValueDomStmt().getValues()) {
					if (l_val.equals(r_val))
						found = true;
					if (found)
						break;
				}
				if (!found)
					return new ValueBDDStmt(l.getContext(), Env.FALSE());
			}
			return new ValueBDDStmt(l.getContext(), Env.TRUE());
		}

		// now I know that at least on of them is either an integer or a BDD
		// which forces me to do it in an integer way...

		ValueIntStmt l_int = l.toValueIntStmt();
		ValueIntStmt r_int = r.toValueIntStmt();

		BDD res = Env.FALSE().id();
		for (BDD l_single : l_int.getAllBDDAssigned()) {
			for (Integer l_val : l_int.getValue(l_single)) {
				for (BDD r_single : r_int.getAllBDDAssigned()) {
					BDD new_bdd_val = l_single.and(r_single);
					if (!new_bdd_val.isZero()) {
						for (Integer r_val : r_int.getValue(r_single)) {
							if (l_val.intValue() == r_val.intValue())
								res = res.id().or(l_single);
						}
					}
				}
			}
		}
		return new ValueBDDStmt(l.getContext(), res);
	}

	// @Override
	// protected ValueStmt doBDD2ConsRangeNode(ValueBDDStmt lv,
	// ValueConsRangeStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doBDD2ConsStrNode(ValueBDDStmt lv, ValueConsStrStmt
	// rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsRange2BDDNode(ValueConsRangeStmt lv,
	// ValueBDDStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsRange2ConsRangeNode(ValueConsRangeStmt lv,
	// ValueConsRangeStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsRange2ConsStrNode(ValueConsRangeStmt lv,
	// ValueConsStrStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsRange2DomNode(ValueConsRangeStmt lv,
	// ValueDomStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsRange2IntNode(ValueConsRangeStmt lv,
	// ValueIntStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsStr2BDDNode(ValueConsStrStmt lv, ValueBDDStmt
	// rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsStr2ConsRangeNode(ValueConsStrStmt lv,
	// ValueConsRangeStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsStr2ConsStrNode(ValueConsStrStmt lv,
	// ValueConsStrStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsStr2DomNode(ValueConsStrStmt lv, ValueDomStmt
	// rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doConsStr2IntNode(ValueConsStrStmt lv, ValueIntStmt
	// rv)
	// throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doDom2ConsRangeNode(ValueDomStmt lv,
	// ValueConsRangeStmt rv) throws SMVParseException {
	// }
	//
	// @Override
	// protected ValueStmt doDom2ConsStrNode(ValueDomStmt lv, ValueConsStrStmt
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
	// //
	// ////////////////////////////////////////////////////////////////////////
	// //
	// ////////////////////////////////////////////////////////////////////////
	// //
	// ////////////////////////////////////////////////////////////////////////
	//
	// @Override
	// protected ValueStmt doBDD2BDDNode(ValueBDDStmt lv, ValueBDDStmt rv)
	// throws SMVParseException {
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
	// protected ValueStmt doDom2DomNode(ValueDomStmt lv, ValueDomStmt rv)
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
	//	@Override
	//	protected ValueStmt doInt2IntNode(ValueIntStmt lv, ValueIntStmt rv)
	//			throws SMVParseException {
	//	}
}
