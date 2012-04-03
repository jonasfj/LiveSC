package edu.wis.jtlv.env.spec;

/**
 * <p>
 * An exception dedicated for all kind of specifications issues.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public class SpecException extends Exception {
	private static final long serialVersionUID = 1L;

	public SpecException(String desc) {
		super(desc);
	}
}
