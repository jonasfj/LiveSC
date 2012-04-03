package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVRangeVarInfo extends SMVVarInfo {
	public int from;
	public int to;

	public SMVRangeVarInfo(String a_name, SMVParsingInfo an_info, int from,
			int to) throws SMVParseException {
		super(a_name, an_info);
		this.from = from;
		this.to = to;
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		return new SMVRangeVarInfo(this.name, this.parse_info, this.from,
				this.to);
	}

	@Override
	public String typeString() {
		return "[" + this.from + ".." + this.to + "]";
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		String[] names = new String[this.to - this.from + 1];
		for (int i = 0; i < names.length; i++) {
			names[i] = "";
			int val = (i + this.from);
			names[i] += val;
		}
		try {
			instance_holder.addVar(this.name, this.from, this.to);
		} catch (ModuleException me) {
			throw new SMVParseException(me.getMessage(), parse_info);
		}
	}

}
