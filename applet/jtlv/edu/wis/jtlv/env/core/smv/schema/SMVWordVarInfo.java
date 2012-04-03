package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVWordVarInfo extends SMVContainerElementInfo {
	public int width;
	public int base;
	private SMVArrayVarInfo arr_instance;

	public SMVWordVarInfo(String a_name, SMVParsingInfo an_info, int a_base,
			int a_width) throws SMVParseException {
		super(a_name, an_info);
		this.base = a_base;
		this.width = a_width;
		if (this.base != 2) {
			throw new SMVParseException(
					"Currentlly only binary word (e.g. base of 2) are supported.");
		}
		this.arr_instance = new SMVArrayVarInfo(this.name, this.parse_info,
				new SMVBooleanVarInfo(this.name, this.parse_info), this.width);
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		return new SMVWordVarInfo(this.name, this.parse_info, this.base,
				this.width);
	}

	@Override
	public String typeString() {
		return "Word" + "[" + this.width + "]";
	}

	@Override
	public void mk_fix_names() throws SMVParseException {
		this.arr_instance.mk_fix_names();
	}

	@Override
	public void mk_modules_skel(SMVModule instance_holder)
			throws SMVParseException {
		// no need, this is a word, which has nothing to do with instances
	}

	@Override
	public void mk_variables(SMVModule instance_holder)
			throws SMVParseException {
		this.arr_instance.mk_variables(instance_holder);
	}

	@Override
	public void mk_defines(SMVModule instance_holder) throws SMVParseException {
		// no need, this is a word, which has nothing to do with defines
	}

	@Override
	public void mk_module_args(SMVModule instance_holder)
			throws SMVParseException {
		// no need, this is a word, which has nothing to do with instances (and
		// thus arguments)
	}
}

// old impl.. //////////////////////////////////////////////

// public class SMVWordVarInfo extends SMVVarInfo {
// public int width;
// public int base;
// private SMVArrayVarInfo arr_instance;
//
// public SMVWordVarInfo(String a_name, SMVParsingInfo an_info, int a_base,
// int a_width) throws SMVParseException {
// super(a_name, an_info);
// this.base = a_base;
// this.width = a_width;
// }
//
// @Override
// public SMVAbstractElementInfo clone_element() throws SMVParseException {
// return new SMVWordVarInfo(this.name, this.parse_info, this.base,
// this.width);
// }
//
// @Override
// public String typeString() {
// return "Word" + "[" + this.width + "]";
// }

// @Override
// public void mk_variables(SMVModule instance_holder)
// throws SMVParseException {
// String[] names = new String[(int) Math.pow(2, this.width)];
// for (int i = 0; i < names.length; i++) {
// names[i] = str_value(i);
// }
// try {
// instance_holder.add_var(this.name, names.length, names);
// } catch (ModuleException me) {
// // will catch, issue an error, and try to recover...
// Env.do_parsing_error(this.parse_info, me);
// }
// }

// private String str_value(int i) {
// String res = "";
// int w = this.width;
// while (w > 0) {
// int curr_digit = (i % this.base);
// i = i / this.base;
// w--;
// switch (curr_digit) {
// case 10:
// res = "A" + res;
// continue;
// case 11:
// res = "B" + res;
// continue;
// case 12:
// res = "C" + res;
// continue;
// case 13:
// res = "D" + res;
// continue;
// case 14:
// res = "E" + res;
// continue;
// case 15:
// res = "F" + res;
// continue;
// default:
// res = curr_digit + res;
// continue;
// }
// }
// switch (this.base) {
// case 2:
// res = "0b" + res;
// break;
// case 8:
// res = "0o" + res;
// break;
// case 10:
// res = "0d" + res;
// break;
// case 16:
// res = "0h" + res;
// break;
// default:
// res = "0x" + res;
// break;
// }
// return res;
// }

