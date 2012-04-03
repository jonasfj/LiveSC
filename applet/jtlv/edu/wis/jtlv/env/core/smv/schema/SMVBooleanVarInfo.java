package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVBooleanVarInfo extends SMVVarInfo {
	public SMVBooleanVarInfo(String a_name, SMVParsingInfo an_info)
			throws SMVParseException {
		super(a_name, an_info);
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		return new SMVBooleanVarInfo(this.name, this.parse_info);
	}

	@Override
	public String typeString() {
		return "Boolean";
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		try {
			instance_holder.addVar(this.name);
		} catch (ModuleException me) {
			throw new SMVParseException(me.getMessage(), parse_info);
		}
	}
}
