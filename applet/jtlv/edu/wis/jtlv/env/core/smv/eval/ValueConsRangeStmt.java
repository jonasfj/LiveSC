package edu.wis.jtlv.env.core.smv.eval;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class ValueConsRangeStmt extends ValueConsStmt {
	private int from;
	private int to;

	public ValueConsRangeStmt(SMVModule a_context, int a_from, int a_to)
			throws SMVParseException {
		super(a_context);
		this.from = a_from;
		this.to = a_to;
	}

	@Override
	protected ValueConsRangeStmt duplicate() throws SMVParseException {
		return new ValueConsRangeStmt(this.context, this.from, this.to);
	}

	@Override
	public ValueBDDStmt toValueBDDStmt() throws SMVParseException {
		return new ValueBDDStmt(this.getContext(), this.toBDD());
	}

	@Override
	public ValueIntStmt toValueIntStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert constant string"
				+ " value to an integer value.");
	}

	@Override
	public ValueDomStmt toValueDomStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert Constant value to domains");
	}

	@Override
	public ValueConsStrStmt toValueConsStrStmt() throws SMVParseException {
		String[] vals = new String[this.to - this.from + 1];
		for (int i = 0; i < vals.length; i++) {
			int a_val = this.from + i;
			vals[i] = "" + a_val;
		}
		return new ValueConsStrStmt(this.context, vals);
	}

	@Override
	public ValueConsRangeStmt toValueConsRangeStmt() throws SMVParseException {
		return this;
	}

	@Override
	public boolean isValueConsStrStmt() {
		return false;
	}

	@Override
	public boolean isValueConsRangeStmt() {
		return true;
	}

	@Override
	public BDD toBDD() throws SMVParseException {
		return this.toValueConsStrStmt().toBDD();
	}

	@Override
	public String elemToString() {
		return "<CR#" + this.from + ".." + this.to + ">";
	}

	@Override
	public SMVModule getContext() {
		return this.context;
	}
	
	public Integer fromRange() {
		return new Integer(this.from);
	}
	public Integer toRange() {
		return new Integer(this.to);
	}
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	private static class IntComparator implements Comparator<Integer> {
		public int compare(Integer arg0, Integer arg1) {
			return (arg0.intValue() - arg1.intValue());
		}
	}

	public static boolean canBeRange(Vector<Integer> vals) {
		Collections.sort(vals, new IntComparator());
		// checking that it is a legit range
		if (vals.isEmpty())
			return false;
		int curr = vals.elementAt(0).intValue();
		for (int i = 0; i < vals.size(); i++) {
			int next = vals.elementAt(i).intValue();
			if ((next != curr) & (next != (curr + 1))) {
				return false;
			}
			curr = next;
		}
		// OK!!
		return true;

	}

	@Override
	public boolean isSingleValue() {
		return (this.from == this.to);
	}

}
