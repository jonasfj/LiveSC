package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.Initiator;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVDependentRangeVarInfo extends SMVVarInfo {
	public String from;
	public String to;

	public SMVDependentRangeVarInfo(String a_name, SMVParsingInfo an_info,
			String from, String to) throws SMVParseException {
		super(a_name, an_info);
		this.from = from;
		this.to = to;
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		return new SMVDependentRangeVarInfo(this.name, this.parse_info,
				this.from, this.to);
	}

	@Override
	public String typeString() {
		return "[" + this.from + ".." + this.to + "]";
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		Initiator.get_instance().register_define_dependent_vars(
				instance_holder, this);
	}

	public boolean eval_and_assign(SMVModule instance_holder)
			throws SMVParseException {
		int int_from, int_to;
		try {
			int_from = Integer.parseInt(this.from);
		} catch (NumberFormatException nfe) {
			if (instance_holder.hasDefine(from, false)) {
				int_from = instance_holder.getDefine(this.from, false)
						.getIntVals()[0];
			} else {
				return false;
			}
		}
		try {
			int_to = Integer.parseInt(this.to);
		} catch (NumberFormatException nfe) {
			if (instance_holder.hasDefine(this.to, false)) {
				int_to = instance_holder.getDefine(this.to, false).getIntVals()[0];
			} else {
				return false;
			}
		}

		String[] names = new String[int_to - int_from + 1];
		for (int i = 0; i < names.length; i++) {
			names[i] = "";
			int val = (i + int_from);
			names[i] += val;
		}
		try {
			instance_holder.addVar(this.name, int_from, int_to);
		} catch (ModuleException me) {
			throw new SMVParseException(me.getMessage(), parse_info);
		}
		return true;
	}
}
