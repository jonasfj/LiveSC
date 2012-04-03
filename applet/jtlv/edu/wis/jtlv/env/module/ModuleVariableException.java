package edu.wis.jtlv.env.module;


/**
 * <p>
 * An exception caused by wrong variable naming in a Module.  
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 * @see edu.wis.jtlv.env.module.Module
 */
public class ModuleVariableException extends ModuleException {
	private static final long serialVersionUID = 1L;

	public ModuleVariableException(String str) {
		super(str);
	}
}
