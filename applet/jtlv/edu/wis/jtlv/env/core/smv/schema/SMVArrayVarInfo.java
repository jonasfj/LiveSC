package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVArrayVarInfo extends SMVContainerElementInfo {
	public int from;
	public int to;
	public SMVAbstractElementInfo proto;
	public SMVAbstractElementInfo[] real_list;

	public SMVArrayVarInfo(String a_name, SMVParsingInfo an_info,
			SMVAbstractElementInfo a_proto, int a_size)
			throws SMVParseException {
		this(a_name, an_info, a_proto, 0, a_size);
	}

	public SMVArrayVarInfo(String a_name, SMVParsingInfo an_info,
			SMVAbstractElementInfo a_proto, int a_from, int a_to)
			throws SMVParseException {
		super(a_name, an_info);
		if (a_from > a_to) {
			throw new SMVParseException("Cannot initiate array " + this.name
					+ " with range " + a_from + ".." + a_to + ".", an_info
					.get_input());
		}
		this.proto = a_proto;
		this.from = a_from;
		this.to = a_to;

		this.real_list = new SMVAbstractElementInfo[this.to - this.from + 1];
		for (int i = this.from; i <= this.to; i++) {
			int idx = i - this.from;
			this.real_list[idx] = a_proto.clone_element();
		}
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		return new SMVArrayVarInfo(this.name, this.parse_info, this.proto,
				this.from, this.to);
	}

	@Override
	public String typeString() {
		return "array [" + this.from + ".." + this.to + "] of "
				+ this.proto.typeString();
	}

	// /////////////////////////////////////////////
	@Override
	public void mk_fix_names() throws SMVParseException {
		for (int i = this.from; i <= this.to; i++) {
			int idx = i - this.from;
			this.real_list[idx].name = this.name + "[" + i + "]";
			this.real_list[idx].mk_fix_names();
		}
	}

	@Override
	public void mk_modules_skel(SMVModule instance_holder)
			throws SMVParseException {
		for (int i = this.from; i <= this.to; i++) {
			int idx = i - this.from;
			this.real_list[idx].mk_modules_skel(instance_holder);
		}
	}

	@Override
	public void mk_defines(SMVModule instance_holder) throws SMVParseException {
		for (int i = this.from; i <= this.to; i++) {
			int idx = i - this.from;
			this.real_list[idx].mk_defines(instance_holder);
		}
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		for (int i = this.from; i <= this.to; i++) {
			int idx = i - this.from;
			this.real_list[idx].mk_variables(instance_holder);
		}
	}

	@Override
	public void mk_module_args(SMVModule instance_holder)
			throws SMVParseException {
		for (int i = this.from; i <= this.to; i++) {
			int idx = i - this.from;
			this.real_list[idx].mk_module_args(instance_holder);
		}
	}
}
