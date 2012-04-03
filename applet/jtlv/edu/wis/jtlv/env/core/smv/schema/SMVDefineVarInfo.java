package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;

/**
 * As the first implementation, define will add a variable just as boolean, and
 * the initial and transition relations will guaranty its correctness.
 * 
 * @author yaniv
 * 
 */
public class SMVDefineVarInfo extends SMVAbstractElementInfo {

	public SMVDefineVarInfo(String a_name, SMVParsingInfo an_info)
			throws SMVParseException {
		super(a_name, an_info);
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		return new SMVDefineVarInfo(this.name, this.parse_info);
	}

	@Override
	public String typeString() {
		return "Define";
	}

	@Override
	public void mk_fix_names() throws SMVParseException {
		// do nothing
	}

	@Override
	public void mk_modules_skel(SMVModule instance_holder)
			throws SMVParseException {
		// do nothing
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mk_defines(SMVModule instance_holder) throws SMVParseException {
		try {
			instance_holder.___addDefine(this.name);
		} catch (ModuleException me) {
			// will catch, issue an error, and try to recover...
			// Env.do_error(new SMVParseException(me.getMessage(), parse_info));
			// Env.do_parsing_error(this.parse_info, me);
			throw new SMVParseException(me.getMessage(), parse_info);
		}
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		// do nothing
	}

	@Override
	public void mk_module_args(SMVModule instance_holder)
			throws SMVParseException {
		// do nothing
	}
}
