package edu.wis.jtlv.env.core.smv.eval;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class ValueDummyStmt extends ValueStmt {
	public ValueDummyStmt(SMVModule a_context) throws SMVParseException {
		super(a_context);
	}

	@Override
	public ValueBDDStmt toValueBDDStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert dummy value to BDD");
	}

	@Override
	public ValueIntStmt toValueIntStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert dummy"
				+ " value to an integer value.");
	}

	@Override
	public ValueDomStmt toValueDomStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert dummy value to domains");
	}

	@Override
	public ValueConsStmt toValueConsStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert dummy value to cons");
	}

	@Override
	public boolean isValueConsStmt() {
		return false;
	}

	@Override
	public SMVModule getContext() {
		return this.context;
	}

	@Override
	public BDD toBDD() throws SMVParseException {
		return null;
	}

	@Override
	protected AbstractElement duplicate() throws SMVParseException {
		return this;
	}

	@Override
	public String elemToString() {
		return "<Dummy Value>";
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

}
