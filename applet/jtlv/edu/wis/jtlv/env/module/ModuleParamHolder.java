package edu.wis.jtlv.env.module;


/**
 * <p>
 * An object representing a parameter to a module. Its implementation is as a
 * pointer. The pointer is to a "kind of like" define in the module which
 * instantiated this module. (Will be adjusted to the ModuleEntity in the
 * future...)
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
// TODO: see if I can fit this class to the ModuleEntity abstract class
public class ModuleParamHolder {
	private SMVModule for_instance;
	private String local_name;
	private String init_string;
	private RedirectTo redirection;

	/**
	 * <p>
	 * The constructor takes as arguments the instance to which he is parameter
	 * to, its local name in that instance, and its instantiating (unparsed)
	 * string.
	 * </p>
	 * 
	 * <p>
	 * The actual instantiation is done just-in-time. i.e. only when it is
	 * needed, it will go to the "kind of like" define in the executer Module,
	 * and fetch the value.
	 * </p>
	 * 
	 * @param a_for_instance
	 *            The instance to which this parameter belongs to.
	 * @param a_local_name
	 *            The local name of this parameter.
	 * @param an_init_string
	 *            The instantiating string.
	 */
	public ModuleParamHolder(SMVModule a_for_instance, String a_local_name,
			String an_init_string) {
		this.for_instance = a_for_instance;
		this.local_name = a_local_name;
		this.init_string = an_init_string;
		this.redirection = null;
	}

	/**
	 * <p>
	 * Getter for the local name.
	 * </p>
	 * 
	 * @return The local name of the parameter.
	 */
	public String getLocalName() {
		return this.local_name;
	}

	/**
	 * <p>
	 * Getter for instantiating string.
	 * </p>
	 * 
	 * @return The instantiating string.
	 */
	public String getInitString() {
		return this.init_string;
	}

	/**
	 * <p>
	 * Getter for the module to which this parameter belongs to.
	 * </p>
	 * 
	 * @return The module to which this parameter belongs to.
	 */
	public SMVModule getForInstance() {
		return this.for_instance;
	}

	/**
	 * <p>
	 * Attach the pointer. Go to the instantiating module, and construct the
	 * value that had been passed.
	 * </p>
	 * 
	 * @throws ModuleException
	 *             If this pointer is actually a local define, then it might be
	 *             that a new define needs to be declared in this module. For
	 *             such case, there could be an exception for wrong Module
	 *             manipulation.
	 *             
	 * @deprecated <b>INTERNAL PROCEDURE - will be encapsulated and removed from
	 *             the external API in the following few releases.</b>
	 * 
	 */
	public void ___attachPointer() throws ModuleException {
		// if already attached by an early request
		if (this.redirection != null)
			return;
		SMVModule holder_context = this.for_instance.getHolder();
		if (holder_context.hasVar(getInitString(), true)) {
			this.redirection = new RedirectToVar(holder_context.getVar(
					getInitString(), true));
		} else if (holder_context.hasVarArray(getInitString(), true)) {
			this.redirection = new RedirectToVarArray(holder_context
					.getVarArray(getInitString(), true));
		} else if (holder_context.hasDefine(getInitString(), true)) {
			this.redirection = new RedirectToDefine(holder_context.getDefine(
					getInitString(), true));
		} else if (holder_context.hasInstance(getInitString(), true)) {
			this.redirection = new RedirectToInstance(holder_context
					.getInstance(getInitString(), true));
		} else if (holder_context.hasInstanceArray(getInitString(), true)) {
			this.redirection = new RedirectToInstanceArray(holder_context
					.getInstanceArray(getInitString(), true));
		} else {
			// could be an expression...!!
			// for such cases I'm adding a define at this instance with that
			// same name. and attaching this redirection to that define...
			this.for_instance.___addDefineFromParam(this.local_name);
			this.redirection = new RedirectToDefine(this.for_instance
					.getDefine(this.local_name, true));
		}
	}

	private boolean attachIfPossible() {
		if (this.redirection == null) {
			try {
				this.___attachPointer();
			} catch (ModuleException me) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Check if this pointer points to variable.
	 * </p>
	 * 
	 * @return true if this pointer point to a variable, otherwise false.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#getVar()
	 */
	public boolean isVar() {
		return attachIfPossible() ? this.redirection.isVar() : false;
	}

	/**
	 * <p>
	 * Check if this pointer points to variable array.
	 * </p>
	 * 
	 * @return true if this pointer point to a variable array, otherwise false.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#getVarArray()
	 */
	public boolean isVarArray() {
		return attachIfPossible() ? this.redirection.isVarArray() : false;
	}

	/**
	 * <p>
	 * Check if this pointer points to module.
	 * </p>
	 * 
	 * @return true if this pointer point to a module, otherwise false.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#getInstance()
	 */
	public boolean isInstance() {
		return attachIfPossible() ? this.redirection.isInstance() : false;
	}

	/**
	 * <p>
	 * Check if this pointer points to module array.
	 * </p>
	 * 
	 * @return true if this pointer point to a module array, otherwise false.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#getInstanceArray()
	 */
	public boolean isInstanceArray() {
		return attachIfPossible() ? this.redirection.isInstanceArray() : false;
	}

	/**
	 * <p>
	 * Check if this pointer points to define.
	 * </p>
	 * 
	 * @return true if this pointer point to a define, otherwise false.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#getDefine()
	 */
	public boolean isDefine() {
		return attachIfPossible() ? this.redirection.isDefine() : false;
	}

	/**
	 * <p>
	 * The variable this pointer points to, if this is not a variable, then null
	 * is returned.
	 * </p>
	 * 
	 * @return The variable this pointer points to, if this is not a variable,
	 *         then null is returned.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#isVar()
	 */
	public ModuleBDDField getVar() {
		return attachIfPossible() ? this.redirection.getVar() : null;
	}

	/**
	 * <p>
	 * The variable array this pointer points to, if this is not a variable
	 * array, then null is returned.
	 * </p>
	 * 
	 * @return The variable array this pointer points to, if this is not a
	 *         variable array, then null is returned.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#isVarArray()
	 */
	public ModuleBDDField[] getVarArray() {
		return attachIfPossible() ? this.redirection.getVarArray() : null;
	}

	/**
	 * <p>
	 * The module this pointer points to, if this is not a module, then null is
	 * returned.
	 * </p>
	 * 
	 * @return The module this pointer points to, if this is not a module, then
	 *         null is returned.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#isInstance()
	 */
	public SMVModule getInstance() {
		return attachIfPossible() ? this.redirection.getInstance() : null;
	}

	/**
	 * <p>
	 * The module array this pointer points to, if this is not a module array,
	 * then null is returned.
	 * </p>
	 * 
	 * @return The module array this pointer points to, if this is not a module
	 *         array, then null is returned.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#isInstanceArray()
	 */
	public SMVModule[] getInstanceArray() {
		return attachIfPossible() ? this.redirection.getInstanceArray() : null;
	}

	/**
	 * <p>
	 * The define this pointer points to, if this is not a define, then null is
	 * returned.
	 * </p>
	 * 
	 * @return The define this pointer points to, if this is not a define, then
	 *         null is returned.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleParamHolder#isDefine()
	 */
	public ModuleBDDDefine getDefine() {
		return attachIfPossible() ? this.redirection.getDefine() : null;
	}

	private abstract class RedirectTo {
		protected Object points_to = null;

		protected RedirectTo(Object a_points_to) {
			this.points_to = a_points_to;
		}

		public boolean isVar() {
			return false;
		}

		public boolean isVarArray() {
			return false;
		}

		public boolean isInstance() {
			return false;
		}

		public boolean isInstanceArray() {
			return false;
		}

		public boolean isDefine() {
			return false;
		}

		public ModuleBDDField getVar() {
			return null;
		}

		public ModuleBDDField[] getVarArray() {
			return null;
		}

		public SMVModule getInstance() {
			return null;
		}

		public SMVModule[] getInstanceArray() {
			return null;
		}

		public ModuleBDDDefine getDefine() {
			return null;
		}

	}

	private class RedirectToVar extends RedirectTo {
		public RedirectToVar(ModuleBDDField points_to_var) {
			super(points_to_var);
		}

		@Override
		public boolean isVar() {
			return true;
		}

		@Override
		public ModuleBDDField getVar() {
			return (ModuleBDDField) super.points_to;
		}
	}

	private class RedirectToVarArray extends RedirectTo {
		public RedirectToVarArray(ModuleBDDField[] points_to_var) {
			super(points_to_var);
		}

		@Override
		public boolean isVarArray() {
			return true;
		}

		@Override
		public ModuleBDDField[] getVarArray() {
			return (ModuleBDDField[]) super.points_to;
		}
	}

	private class RedirectToInstance extends RedirectTo {
		public RedirectToInstance(SMVModule points_to_module) {
			super(points_to_module);
		}

		@Override
		public boolean isInstance() {
			return true;
		}

		@Override
		public SMVModule getInstance() {
			return (SMVModule) super.points_to;
		}
	}

	private class RedirectToInstanceArray extends RedirectTo {
		public RedirectToInstanceArray(SMVModule[] points_to_module) {
			super(points_to_module);
		}

		@Override
		public boolean isInstanceArray() {
			return true;
		}

		@Override
		public SMVModule[] getInstanceArray() {
			return (SMVModule[]) super.points_to;
		}
	}

	private class RedirectToDefine extends RedirectTo {
		public RedirectToDefine(ModuleBDDDefine points_to_define) {
			super(points_to_define);
		}

		@Override
		public boolean isDefine() {
			return true;
		}

		@Override
		public ModuleBDDDefine getDefine() {
			return (ModuleBDDDefine) super.points_to;
		}
	}
}
