package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public abstract class SMVVarInfo extends SMVAbstractElementInfo {

	public SMVVarInfo(String a_name, SMVParsingInfo a_parse_info) throws SMVParseException {
		super(a_name, a_parse_info);
	}

	@Override
	public void mk_fix_names() throws SMVParseException {
		// do nothing
	}

	@Override
	public void mk_modules_skel(SMVModule instance_holder) throws SMVParseException {
		// do nothing
	}

	@Override
	public void mk_defines(SMVModule instance_holder) throws SMVParseException {
		// do nothing
	}

	@Override
	public void mk_module_args(SMVModule instance_holder) throws SMVParseException {
		// do nothing
	}
}
