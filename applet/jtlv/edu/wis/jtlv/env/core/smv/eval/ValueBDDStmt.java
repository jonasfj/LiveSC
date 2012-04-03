package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;
import net.sf.javabdd.BDD.BDDIterator;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class ValueBDDStmt extends ValueStmt {
	private BDD val;

	public ValueBDDStmt(SMVModule a_context, BDD a_val)
			throws SMVParseException {
		super(a_context);
		this.val = a_val;
	}

	@Override
	protected ValueBDDStmt duplicate() throws SMVParseException {
		return new ValueBDDStmt(this.context, this.val);
	}

	@Override
	public ValueBDDStmt toValueBDDStmt() throws SMVParseException {
		return this;
	}

	@Override
	public ValueIntStmt toValueIntStmt() throws SMVParseException {
		BDD bdd2enum = this.toBDD();
		if (bdd2enum.isUniverse()) {
			ValueIntStmt res = new ValueIntStmt(this.getContext(), bdd2enum.support());
			res.addValue(Env.TRUE(), new Integer(1));
			res.addValue(Env.TRUE(), new Integer(0));
			return res;
			//return new ValueConsStrStmt(this.getContext(), new String[] { "1" })
			//		.toValueIntStmt();
		} else if (bdd2enum.isZero()) {
			ValueIntStmt res = new ValueIntStmt(this.getContext(), bdd2enum.support());
			return res;
			//return new ValueConsStrStmt(this.getContext(), new String[] { "0" })
			//		.toValueIntStmt();
		}

		// otherwise enumerating
		BDD not_bdd2enum = bdd2enum.not();
		
		BDDVarSet new_var_set = bdd2enum.support();
		BDDVarSet new_not_var_set = not_bdd2enum.support();
		
		Integer True = new Integer(1);
		Integer False = new Integer(0);

		ValueIntStmt res = new ValueIntStmt(this.getContext(), new_var_set);

		BDDIterator iter = bdd2enum.iterator(new_var_set);
		while (iter.hasNext()) {
			BDD st = iter.nextBDD();
			res.addValue(st, True);
		}
		iter = not_bdd2enum.iterator(new_not_var_set);
		while (iter.hasNext()) {
			BDD st = iter.nextBDD();
			res.addValue(st, False);
		}
		
		return res;
	}

	@Override
	public ValueDomStmt toValueDomStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert BDD value to domains");
	}

	@Override
	public ValueConsStmt toValueConsStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert BDD value to constant");
	}

	@Override
	public BDD toBDD() throws SMVParseException {
		return this.val;
	}

	@Override
	public boolean isValueBDDStmt() {
		return true;
	}

	@Override
	public String elemToString() {
		String res = this.val.toStringWithDomains(Env.stringer);
		return "<B#" + toNicerString(res) + ">";
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
}
