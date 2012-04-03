package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public abstract class ValueStmt extends AbstractElement {
	protected SMVModule context;

	public ValueStmt(SMVModule a_context) throws SMVParseException {
		super(new AbstractElement[] {});
		this.context = a_context;
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		return this;
	}
	
	@Override
	protected ValueStmt newEval() throws SMVParseException {
		return this;
	}

//	@Override
//	protected void setChild(int index, AbstractElement to_set)
//			throws IndexOutOfBoundsException {
//		throw new IndexOutOfBoundsException("Operator has no "
//				+ "element.\nCannot access index " + index);
//	}

	@Override
	public String toString() {
		return elemToString();
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	public SMVModule getContext() {
		return this.context;
	}

	public abstract ValueBDDStmt toValueBDDStmt() throws SMVParseException;

	public abstract ValueIntStmt toValueIntStmt() throws SMVParseException;

	public abstract ValueDomStmt toValueDomStmt() throws SMVParseException;

	public abstract ValueConsStmt toValueConsStmt() throws SMVParseException;

//	public abstract ValueConsRangeStmt toValueConsRangeStmt()
//			throws SMVParseException;

	public abstract BDD toBDD() throws SMVParseException;

	public boolean isValueBDDStmt() {
		return false;
	}

	public boolean isValueIntStmt() {
		return false;
	}

	public boolean isValueDomStmt() {
		return false;
	}

	public boolean isValueConsStmt() {
		return false;
	}

//	public boolean isValueConsRangeStmt() {
//		return false;
//	}

	protected boolean stringIsTRUE(String str) {
		if (str == null)
			return false;
		return str.equals("1") | str.equalsIgnoreCase("T")
				| str.equalsIgnoreCase("TRUE");
	}

	protected boolean stringIsFALSE(String str) {
		if (str == null)
			return false;
		return str.equals("0") | str.equalsIgnoreCase("F")
				| str.equalsIgnoreCase("FALSE");
	}

	public static int toStringlength = 10000;

	protected String toNicerString(String str) {
		if (str.length() < ValueStmt.toStringlength - 2)
			return str;
		return str.substring(0, ValueStmt.toStringlength - 2) + "...";
	}
}
