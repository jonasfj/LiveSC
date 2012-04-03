package edu.wis.jtlv.old_lib.mc;

/**
 * An exception dedicated for all kind of model checking issues.
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public class ModelCheckException extends Exception {
	private static final long serialVersionUID = 1L;

	public ModelCheckException(String desc) {
		super(desc);
	}
}
