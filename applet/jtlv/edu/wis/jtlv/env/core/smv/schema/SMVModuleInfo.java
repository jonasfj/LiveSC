package edu.wis.jtlv.env.core.smv.schema;

import java.util.Iterator;
import java.util.Vector;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class SMVModuleInfo extends SMVContainerElementInfo {
	// not to confuse!!! if declared "p : process some_module();"
	// this.module_name is the module name "some_module" and not "p".
	public String[] arg_list;
	public SMVAbstractElementInfo[] arg_elememts;
	private Vector<SMVAbstractElementInfo> sub_elements;

	public SMVModuleInfo(String a_module_name, SMVParsingInfo an_info,
			String[] an_arg_list) throws SMVParseException {
		super(a_module_name, an_info);
		this.sub_elements = new Vector<SMVAbstractElementInfo>(20);

		this.arg_list = an_arg_list;
		this.arg_elememts = new SMVAbstractElementInfo[this.arg_list.length];
		for (int i = 0; i < this.arg_elememts.length; i++) {
			this.arg_elememts[i] = null;
		}
	}

	public void add_element(SMVAbstractElementInfo elem, SMVParsingInfo an_info)
			throws SMVParseException {
		// first checking if it is declared as an argument.
		// (and is not defined already).
		for (int i = 0; i < this.arg_list.length; i++) {
			if (elem.name.equals(this.arg_list[i])) {
				if (this.arg_elememts[i] == null) {
					// "this" won't be the real holder here.
					this.arg_elememts[i] = elem;
					//elem.set_holder(this.get_holder());
					//this.get_holder().add_element(elem, an_info);
					return;
				}
				// Env.do_error(new SMVParseException("Variable " + elem.name
				// + " already exist in MODULE " + this.name, parse_info));
				// Env.do_parsing_error(an_info, new ModuleException(
				// "Variable " + elem.name
				// + " already exist in MODULE " + this.name));
				throw new SMVParseException("Variable " + elem.name
						+ " already exist in MODULE " + this.name, an_info);
			}
		}

		// then check that it does not exists in simple elements
		for (Iterator<SMVAbstractElementInfo> iter_elem = this.sub_elements
				.iterator(); iter_elem.hasNext();) {
			if (elem.name.equals(iter_elem.next().name)) {
				// will catch, issue an error, and try to recover...
				// Env.do_error(new SMVParseException("Variable " + elem.name
				// + " already exist in MODULE " + this.name, parse_info));
				// Env.do_parsing_error(an_info, new ModuleException("Variable "
				// + elem.name + " already exist in MODULE " + this.name));
				throw new SMVParseException("Variable " + elem.name
						+ " already exist in MODULE " + this.name, an_info);
				// return;
			}
		}

		// only now adding to the elements...
		elem.set_holder(this);
		this.sub_elements.add(elem);
	}

	public SMVAbstractElementInfo[] get_arg_elements() {
		return this.arg_elememts;
	}

	public SMVAbstractElementInfo get_element_named(String name) {
		for (Iterator<SMVAbstractElementInfo> iter_elem = this.sub_elements
				.iterator(); iter_elem.hasNext();) {
			SMVAbstractElementInfo elem = iter_elem.next();
			if (elem.name.equals(iter_elem.next().name)) {
				return elem;
			}
		}
		return null;
	}

	@Override
	public SMVAbstractElementInfo clone_element() throws SMVParseException {
		throw new SMVParseException("Cannot clone a MODULE.");
	}

	@Override
	public String typeString() {
		String res = "<type MODULE ";
		res += this.name + "(";
		for (int i = 0; i < this.arg_list.length; i++) {
			res += (i == 0) ? "" : ", ";
			res += this.arg_list;
		}
		return res + ")>";
	}

	@Override
	public void mk_fix_names() throws SMVParseException {
		// since sub_elements could change by this recursion, I need to do it in
		// such a manner.
		int curr_pos = 0;
		while (curr_pos < this.sub_elements.size()) {
			this.sub_elements.elementAt(curr_pos).mk_fix_names();
			curr_pos++;
		}
	}

	@Override
	public void mk_modules_skel(SMVModule self) throws SMVParseException {
		for (Iterator<SMVAbstractElementInfo> iter_elem = this.sub_elements
				.iterator(); iter_elem.hasNext();) {
			SMVAbstractElementInfo elem = iter_elem.next();
			elem.mk_modules_skel(self);
		}
	}

	@Override
	public void mk_defines(SMVModule self) throws SMVParseException {
		for (Iterator<SMVAbstractElementInfo> iter_elem = this.sub_elements
				.iterator(); iter_elem.hasNext();) {
			SMVAbstractElementInfo elem = iter_elem.next();
			elem.mk_defines(self);
		}
	}

	@Override
	public void mk_variables(SMVModule self) throws SMVParseException {
		for (Iterator<SMVAbstractElementInfo> iter_elem = this.sub_elements
				.iterator(); iter_elem.hasNext();) {
			SMVAbstractElementInfo elem = iter_elem.next();
			elem.mk_variables(self);
		}
	}

	@Override
	public void mk_module_args(SMVModule self) throws SMVParseException {
		for (Iterator<SMVAbstractElementInfo> iter_elem = this.sub_elements
				.iterator(); iter_elem.hasNext();) {
			SMVAbstractElementInfo elem = iter_elem.next();
			elem.mk_module_args(self);
		}
	}
}
