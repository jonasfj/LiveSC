package edu.wis.jtlv.env.module;

/**
 * <p>
 * A common interface from a module BDD entity. Mostly takes care of the entity
 * location (i.e. path and name..)
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public abstract class ModuleEntity {

	/**
	 * <p>
	 * The path leading to the field.
	 * </p>
	 */
	protected String path;

	/**
	 * <p>
	 * The field name.
	 * </p>
	 */
	protected String name;

	// public abstract BDDVarSet support();

	/**
	 * <p>
	 * Overrides the {@link java.lang.Object#equals(Object)}. Check whether
	 * this object is identical to the given object by comparing the field's
	 * path, and the field's name. This procedure does not continue to check
	 * whether the domains are identical. (This is done so that collections will
	 * identify that such a field exists, regardless of its domain)
	 * </p>
	 * 
	 * @param other
	 *            The other object to compare this filed to.
	 * 
	 * @return true if the given object is identical to this, false otherwise.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDField#comparable(ModuleBDDField)
	 * @see edu.wis.jtlv.env.module.ModuleBDDField#strongEquals(Object)
	 */
	public boolean equals(Object other) {
		if (!(ModuleEntity.class.isInstance(other))) {
			return false;
		}
		if (this.getPath() != ((ModuleEntity) other).getPath()) {
			return false;
		}
		if (this.getName() != ((ModuleEntity) other).getName()) {
			return false;
		}
		return true;
	}

	/**
	 * <p>
	 * Check whether this object is completely identical to the give object.
	 * This implementation is referred to the original
	 * {@link java.lang.Object#equals(Object)}.
	 * </p>
	 * 
	 * @param other
	 *            The other object to compare this filed to.
	 * @return true if the given object is identical to this, false otherwise.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDField#comparable(ModuleBDDField)
	 * @see edu.wis.jtlv.env.module.ModuleBDDField#equals(Object)
	 */
	public boolean strongEquals(Object other) {
		return super.equals(other);
	}

	/**
	 * <p>
	 * Get the string representation of this field, without the path leading to
	 * it.
	 * </p>
	 * 
	 * @return A short string representing this field.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDField#toFullString()
	 */
	public String toString() {
		return this.name;
	}

	/**
	 * <p>
	 * Get the string representation of this field, with the path leading to it.
	 * </p>
	 * 
	 * @return A short string representing this field.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDField#toString()
	 */
	public String toFullString() {
		return this.path + "->" + this.name;
	}

	/**
	 * <p>
	 * Get this field's path.
	 * </p>
	 * 
	 * @return This field's path.
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * <p>
	 * Get this field's name.
	 * </p>
	 * 
	 * @return This field's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * <p>
	 * In case this is an array name for field, returns the simple name without
	 * the braces '['']'.<br>
	 * If this is not an array name, then an empty string "", will be returned.
	 * </p>
	 * 
	 * @return The simple name for this field.
	 */
	public String getSimpleArrayName() {
		int last_RB = this.name.lastIndexOf(']');
		if ((last_RB + 1) != this.name.length())
			return "";

		int last_LB = last_RB - 1;
		int count = 1;
		while ((last_LB > 0) & (count > 0)) {
			if (this.name.charAt(last_LB) == ']')
				count++;
			if (this.name.charAt(last_LB) == '[')
				count--;
			last_LB--;
		}
		return this.name.substring(0, last_LB + 1);
	}

}