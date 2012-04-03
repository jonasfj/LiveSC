package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVValueVarInfo extends SMVVarInfo {
	public String[] values;

	public SMVValueVarInfo(String a_name, SMVParsingInfo an_info,
			String[] values) throws SMVParseException {
		super(a_name, an_info);
		this.values = values;
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		return new SMVValueVarInfo(this.name, this.parse_info, this.values);
	}

	@Override
	public String typeString() {
		String res = "[";
		boolean is_first = true;
		for (int i = 0; i < this.values.length; i++) {
			if (!is_first) {
				res += ", ";
			}
			res += this.values[i];
			is_first = false;
		}
		return res + "]";
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		try {
			instance_holder.addVar(this.name, values);
		} catch (ModuleException me) {
			throw new SMVParseException(me.getMessage(), parse_info);
		}
	}
}
