package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public abstract class SMVAbstractElementInfo implements Cloneable {
	protected SMVParsingInfo parse_info;
	public String name;
	protected SMVModuleInfo holder_desc;

	public SMVAbstractElementInfo(String a_name, SMVParsingInfo a_parse_info)
			throws SMVParseException {
		this.name = a_name;
		this.parse_info = a_parse_info;
		this.holder_desc = null;
	}
	
	public void set_holder(SMVModuleInfo an_holder) {
		this.holder_desc = an_holder;
	}
	
	public SMVModuleInfo get_holder() {
		return this.holder_desc;
	}
	
	public String toString() {
		return name + " : " + typeString();
	}

	public abstract SMVAbstractElementInfo clone_element() throws SMVParseException;

	public abstract String typeString();

	// / all phases.
	
	// 0. during construction I need to set the arrays names.
	public abstract void mk_fix_names() throws SMVParseException;

	// 1. only modules.
	public abstract void mk_modules_skel(SMVModule instance_holder)
			throws SMVParseException;

	// 2. add define variables.
	public abstract void mk_defines(SMVModule instance_holder)
			throws SMVParseException;

	// 3. add variables.
	public abstract void mk_variables(SMVModule instance_holder)
			throws SMVParseException;

	// 4. add module args.
	public abstract void mk_module_args(SMVModule instance_holder)
			throws SMVParseException;
}
