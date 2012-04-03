package edu.wis.jtlv.env.module;


/**
 * <p>
 * An exception caused by wrong manipulation to a Module.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 * @see edu.wis.jtlv.env.module.Module
 */
public class ModuleException extends Exception {
	private static final long serialVersionUID = 1L;

	public ModuleException(String str) {
		super(str);
	}
}
