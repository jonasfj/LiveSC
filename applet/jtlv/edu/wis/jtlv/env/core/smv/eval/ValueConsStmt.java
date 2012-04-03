package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public abstract class ValueConsStmt extends ValueStmt {
	public ValueConsStmt(SMVModule a_context) throws SMVParseException {
		super(a_context);
	}

	@Override
	public ValueBDDStmt toValueBDDStmt() throws SMVParseException {
		return new ValueBDDStmt(this.getContext(), this.toBDD());
	}

	@Override
	public ValueIntStmt toValueIntStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert constant"
				+ " value to an integer value.");
	}

	@Override
	public ValueDomStmt toValueDomStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert Constant value to domains");
	}

	@Override
	public ValueConsStmt toValueConsStmt() throws SMVParseException {
		return this;
	}

	@Override
	public boolean isValueConsStmt() {
		return true;
	}

	@Override
	public SMVModule getContext() {
		return this.context;
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public abstract ValueConsRangeStmt toValueConsRangeStmt()
			throws SMVParseException;

	public abstract ValueConsStrStmt toValueConsStrStmt()
			throws SMVParseException;

	public abstract boolean isValueConsStrStmt();

	public abstract boolean isValueConsRangeStmt();
	
	public abstract boolean isSingleValue();
}
