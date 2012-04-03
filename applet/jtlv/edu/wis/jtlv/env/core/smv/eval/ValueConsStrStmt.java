package edu.wis.jtlv.env.core.smv.eval;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class ValueConsStrStmt extends ValueConsStmt {
	private String[] constant;

	public ValueConsStrStmt(SMVModule a_context, String[] a_constant)
			throws SMVParseException {
		super(a_context);
		this.constant = a_constant;
	}

	@Override
	protected ValueConsStrStmt duplicate() throws SMVParseException {
		return new ValueConsStrStmt(this.context, this.constant);
	}

	@Override
	public BDD toBDD() throws SMVParseException {
		String[] vals = this.getValues();
		BDD res;
		if (vals.length == 1) {
			if (this.stringIsFALSE(vals[0]))
				return Env.FALSE().id();
			if (this.stringIsTRUE(vals[0]))
				return Env.TRUE().id();
			if (this.getContext().hasValue(vals[0])) {
				res = this.getContext().getValue(vals[0]);
				return res;
			}
			throw new SMVParseException("Could not find a BDD for"
					+ " the value " + vals[0]);
		}
		res = Env.FALSE().id();
		for (int i = 0; i < vals.length; i++) {
			if (this.getContext().hasValue(vals[i])) {
				res = res.id().or(this.getContext().getValue(vals[i]));
			} else {
				throw new SMVParseException("Could not find a BDD for"
						+ " the value " + vals[i]);
			}
		}
		return res;
	}

	@Override
	public String elemToString() {
		String res = "";
		String[] vals = this.getValues();
		for (int i = 0; i < vals.length; i++) {
			res += ((i + 1) != vals.length) ? vals[i] + "," : vals[i];
		}
		// String pre = "<" + (this.hasCondition() ? "Cond" : "") + "|C#";
		return "<C#" + toNicerString(res) + ">";
	}

	@Override
	public ValueConsRangeStmt toValueConsRangeStmt() throws SMVParseException {
		// first converting to integers
		Vector<Integer> vals = new Vector<Integer>(this.constant.length);
		for (int i = 0; i < this.constant.length; i++) {
			try {
				vals.add(new Integer(this.constant[i]));
			} catch (NumberFormatException nfe) {
				throw new SMVParseException("Cannot convert string constant"
						+ " to an integer constant");
			}
		}
		Collections.sort(vals, new IntComparator());
		// checking that it is a legit range
		if (vals.isEmpty())
			return null;
		int curr = vals.elementAt(0).intValue();
		for (int i = 0; i < vals.size(); i++) {
			int next = vals.elementAt(i).intValue();
			if ((next != curr) & (next != (curr + 1))) {
				throw new SMVParseException("Cannot convert a disjoint set "
						+ "of integers to an inteval.");
			}
			curr = next;
		}
		// OK!!
		return new ValueConsRangeStmt(this.context, vals.elementAt(0)
				.intValue(), vals.elementAt(vals.size() - 1).intValue());
	}

	private class IntComparator implements Comparator<Integer> {
		public int compare(Integer arg0, Integer arg1) {
			return (arg0.intValue() - arg1.intValue());
		}
	}

	@Override
	public ValueConsStrStmt toValueConsStrStmt() throws SMVParseException {
		return this;
	}

	@Override
	public boolean isValueConsStrStmt() {
		return true;
	}

	@Override
	public boolean isValueConsRangeStmt() {
		return false;
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public String[] getValues() {
		return this.constant;
	}

	@Override
	public boolean isSingleValue() {
		return this.constant.length == 1;
	}

}
