package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVProcVarInfo extends SMVContainerElementInfo {
	public boolean is_sync;
	public SMVModuleInfo proc_desc;
	public String[] params;

	public SMVProcVarInfo(String a_name, SMVParsingInfo an_info,
			SMVModuleInfo proc_desc, boolean is_sync, String[] a_param_list)
			throws SMVParseException {
		super(a_name, an_info);
		this.proc_desc = proc_desc;
		this.is_sync = is_sync;
		// TODO: I still don't know how to work with expressions as a
		// parameter....
		this.params = a_param_list;
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		return new SMVProcVarInfo(this.name, this.parse_info, this.proc_desc,
				this.is_sync, this.params);
	}

	@Override
	public String typeString() {
		String res = this.is_sync ? "sync process " : "async process ";
		res += this.proc_desc.name + "(";
		boolean is_first = true;
		for (int i = 0; i < this.params.length; i++) {
			if (!is_first) {
				res += ", ";
			}
			res += this.params[i];
			is_first = false;
		}
		return res + ")";
	}

	@Override
	public void mk_fix_names() throws SMVParseException {
		// first fix the structure if a variable was defined/declared at
		// a lower element.
		SMVAbstractElementInfo[] args = this.proc_desc.get_arg_elements();
		for (int i = 0; i < args.length; i++) {
			if (args[i] != null) {
				args[i].name = this.params[i];
				this.get_holder().add_element(args[i].clone_element(),
						this.parse_info);
			}
		}
		this.proc_desc.mk_fix_names();
	}

	@Override
	public void mk_modules_skel(SMVModule instance_holder)
			throws SMVParseException {
		try {
			String inst_full_name = instance_holder.getFullInstName() + "."
					+ this.name;
			SMVModule inst = new SMVModule(this.proc_desc, inst_full_name,
					this.proc_desc.arg_list, this.params);
			instance_holder.addInstanceVar(inst, this.is_sync);
			Env.putModule(inst_full_name, inst); // registering
			this.proc_desc.mk_modules_skel(inst);
		} catch (ModuleException me) {
			// will catch, issue an error, and try to recover...
			// Env.do_error(new SMVParseException(me.getMessage(), parse_info));
			// Env.do_parsing_error(this.parse_info, me);
			throw new SMVParseException(me.getMessage(), parse_info);
		}
	}

	@Override
	public void mk_defines(SMVModule instance_holder) throws SMVParseException {
		String inst_full_name = instance_holder.getFullInstName() + "."
				+ this.name;
		SMVModule inst = (SMVModule) Env.getModule(inst_full_name);
		this.proc_desc.mk_defines(inst);
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		String inst_full_name = instance_holder.getFullInstName() + "."
				+ this.name;
		SMVModule inst = (SMVModule) Env.getModule(inst_full_name);
		this.proc_desc.mk_variables(inst);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mk_module_args(SMVModule instance_holder)
			throws SMVParseException {
		String inst_full_name = instance_holder.getFullInstName() + "."
				+ this.name;
		SMVModule inst = (SMVModule) Env.getModule(inst_full_name);
		try {
			inst.___attachParamPointers();
		} catch (ModuleException me) {
			throw new SMVParseException(me.getMessage(), parse_info);
		}
		// for (int i = 0; i < this.params.length; i++) {
		// try {
		// inst.setParams();
		// } catch (ModuleException me) {
		// // will catch, issue an error, and try to recover...
		// // Env.do_error(new SMVParseException(me.getMessage(),
		// // parse_info));
		// // Env.do_parsing_error(this.parse_info, me);
		// throw new SMVParseException(me.getMessage(), parse_info);
		// }
		// }
		this.proc_desc.mk_module_args(inst);
	}
}
