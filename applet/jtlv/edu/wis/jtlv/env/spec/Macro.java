package edu.wis.jtlv.env.spec;

/**
 * <p>
 * A NOT YET IMPLEMENTED, general Macro interface for converting specifications.
 * </p>
 * 
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public interface Macro {

	// public boolean isApplicableForMacro(Spec orig);

	public Spec executeMacro(Spec orig);

}
