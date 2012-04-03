package edu.wis.jtlv.env.core.smv.eval;

import java.math.BigInteger;
import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDDomain;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.ModuleBDDField;
import edu.wis.jtlv.env.module.SMVModule;

public class ValueDomStmt extends ValueStmt {
	private ModuleBDDField coup;

	public ValueDomStmt(SMVModule a_context, ModuleBDDField a_coup)
			throws SMVParseException {
		super(a_context);
		this.coup = a_coup;
	}

	@Override
	protected ValueDomStmt duplicate() throws SMVParseException {
		return new ValueDomStmt(this.context, this.coup);
	}

	@Override
	public ValueBDDStmt toValueBDDStmt() throws SMVParseException {
		return new ValueBDDStmt(this.getContext(), this.toBDD());
	}

	@Override
	public ValueIntStmt toValueIntStmt() throws SMVParseException {
		BDDDomain dom = coup.getDomain();
		ValueIntStmt res = new ValueIntStmt(this.getContext(), dom.set());
		int size = dom.size().intValue();
		for (int i = 0; i < size; i++) {
			BigInteger single = new BigInteger("" + i);
			String str_val = Env.stringer.elementName(dom, single);
			try {
				Integer int_val = new Integer(str_val);
				BDD bdd_val = dom.ithVar(single);
				res.addValue(bdd_val, int_val);
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Cannot convert a string value "
						+ "type to an integer value.");
			}
		}
		return res;
	}

	@Override
	public ValueDomStmt toValueDomStmt() throws SMVParseException {
		return this;
	}

	@Override
	public ValueConsStmt toValueConsStmt() throws SMVParseException {
		ValueConsStmt res = new ValueConsStrStmt(this.getContext(), this
				.getValues());
		return res;
	}

	@Override
	public BDD toBDD() throws SMVParseException {
		BDDDomain dom = coup.getDomain();
		BDD res;
		int size = dom.size().intValue();
		if (size != 2)
			throw new SMVParseException("Cannot implicitly convert a domain"
					+ " with more then two values to a BDD.");
		BigInteger big_f = new BigInteger("0");
		BigInteger big_s = new BigInteger("1");
		String str_f = Env.stringer.elementName(dom, big_f);
		String str_s = Env.stringer.elementName(dom, big_s);
		if (stringIsTRUE(str_f) & stringIsFALSE(str_s)) {
			res = dom.ithVar(big_f);
		} else if (stringIsFALSE(str_f) & stringIsTRUE(str_s)) {
			res = dom.ithVar(big_s);
		} else {
			throw new SMVParseException("Cannot convert a string value "
					+ "type to an integer value.");
		}
		return res;
	}

	public boolean isBoolDomain() {
		BDDDomain dom = this.coup.getDomain();
		if (dom.size().intValue() == 2) {
			String str_f = Env.stringer.elementName(dom, new BigInteger("0"));
			String str_s = Env.stringer.elementName(dom, new BigInteger("1"));
			return (stringIsTRUE(str_f) & stringIsFALSE(str_s));
		}
		return false;
	}

	public boolean isOpBoolDomain() {
		BDDDomain dom = this.coup.getDomain();
		if (dom.size().intValue() == 2) {
			String str_f = Env.stringer.elementName(dom, new BigInteger("0"));
			String str_s = Env.stringer.elementName(dom, new BigInteger("1"));
			return (stringIsFALSE(str_f) & stringIsTRUE(str_s));
		}
		return false;
	}

	@Override
	public boolean isValueDomStmt() {
		return true;
	}

	@Override
	public String elemToString() {
		String res = "";
		res += this.getBDDCouple().toString();
		// String pre = "<" + (this.hasCondition() ? "Cond" : "") + "|D#";
		return "<D#" + res + ">";
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	private BDD equals_other_varsion = null;

	public BDD biimpDomain(ValueDomStmt other) {
		BDD res = Env.TRUE();
		// performance improvement in cases where this is the same domain.
		if (this.getBDDCouple().other().equals(other.getBDDCouple())) {
			if (this.equals_other_varsion == null)
				this.equals_other_varsion = this.getBDDCouple().getDomain()
						.buildEquals(other.getBDDCouple().getDomain());
			return this.equals_other_varsion.id();
		}
		// another try to a performance improvement.
		// although this I think is not 100% safe...
		if (this.getBDDCouple().other().comparable(other.getBDDCouple())) {
			return this.getBDDCouple().getDomain().buildEquals(
					other.getBDDCouple().getDomain());
		}

		// otherwise this are just string values, and a name by name biimp
		// is a must.
		for (String str_val : this.getValues()) {
			try {
				res = res.and(this.strToBDD(str_val).biimp(
						other.strToBDD(str_val)));
			} catch (SMVParseException smp) {
				// doing nothing, it won't be bi-implicate...
			}
		}
		return res;
	}

	public ModuleBDDField getBDDCouple() {
		return this.coup;
	}

	public String[] getValues() {
		Vector<String> res = new Vector<String>(5);
		BDDDomain dom = this.coup.getDomain();
		int size = dom.size().intValue();
		BigInteger bigLoc;
		for (int i = 0; i < size; i++) {
			bigLoc = new BigInteger("" + i);
			res.add(Env.stringer.elementName(dom, bigLoc));
		}

		String[] res_arr = new String[res.size()];
		res.toArray(res_arr);
		return res_arr;
	}

	public BDD strToBDD(String[] str_vals) throws SMVParseException {
		BDD res = Env.FALSE().id();
		for (int i = 0; i < str_vals.length; i++) {
			res = res.id().or(strToBDD(str_vals[i]));
		}
		return res;
	}

	public BDD strToBDD(String str_val) throws SMVParseException {
		BDD res = Env.FALSE().id();
		BDDDomain dom = this.coup.getDomain();
		int size = dom.size().intValue();
		BigInteger bigLoc;
		for (int i = 0; i < size; i++) {
			bigLoc = new BigInteger("" + i);
			if (str_val.equals(Env.stringer.elementName(dom, bigLoc))) {
				res = res.id().or(dom.ithVar(bigLoc));
			}
		}
		return res;
	}

	public BDD notStrToBDD(String[] str_vals) throws SMVParseException {
		BDD res = Env.TRUE().id();
		for (int i = 0; i < str_vals.length; i++) {
			res = res.id().and(notStrToBDD(str_vals[i]));
		}
		return res;
	}

	public BDD notStrToBDD(String str_val) throws SMVParseException {
		BDD res = Env.FALSE().id();
		BDDDomain dom = this.coup.getDomain();
		int size = dom.size().intValue();
		BigInteger bigLoc;
		for (int i = 0; i < size; i++) {
			bigLoc = new BigInteger("" + i);
			if (!str_val.equals(Env.stringer.elementName(dom, bigLoc))) {
				res = res.id().or(dom.ithVar(bigLoc));
			}
		}
		return res;
	}

	public BDD intToBDD(int[] vals) throws SMVParseException {
		BDD res = Env.FALSE().id();
		for (int i = 0; i < vals.length; i++) {
			res = res.id().or(intToBDD(vals[i]));
		}
		return res;
	}

	public BDD intToBDD(int val) throws SMVParseException {
		return strToBDD("" + val);
	}

	public BDD belowEqIntToBDD(int val) throws SMVParseException {
		return belowIntToBDD(val).or(intToBDD(val));
	}

	public BDD belowIntToBDD(int val) throws SMVParseException {
		BDD res = Env.FALSE().id();
		BDDDomain dom = this.coup.getDomain();
		int size = dom.size().intValue();
		BigInteger bigLoc;
		for (int i = 0; i < size; i++) {
			bigLoc = new BigInteger("" + i);
			String str_val = Env.stringer.elementName(dom, bigLoc);
			try {
				int int_val = Integer.parseInt(str_val);
				if (int_val < val) {
					res = res.id().or(dom.ithVar(bigLoc));
				}
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Cannot get below values to a"
						+ " domain with non integer values");
			}
		}
		return res;
	}

	public BDD aboveEqIntToBDD(int val) throws SMVParseException {
		return aboveIntToBDD(val).or(intToBDD(val));
	}

	public BDD aboveIntToBDD(int val) throws SMVParseException {
		BDD res = Env.FALSE().id();
		BDDDomain dom = this.coup.getDomain();
		int size = dom.size().intValue();
		BigInteger bigLoc;
		for (int i = 0; i < size; i++) {
			bigLoc = new BigInteger("" + i);
			String str_val = Env.stringer.elementName(dom, bigLoc);
			try {
				int int_val = Integer.parseInt(str_val);
				if (int_val > val) {
					res = res.id().or(dom.ithVar(bigLoc));
				}
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Cannot get above values to a"
						+ " domain with non integer values");
			}
		}
		return res;
	}
}
