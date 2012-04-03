package edu.wis.jtlv.lib.mc;

import edu.wis.jtlv.lib.AlgExceptionI;

/**
 * <p>
 * An exception dedicated for all kind of model checking issues.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public class ModelCheckAlgException extends AlgExceptionI {
	private static final long serialVersionUID = 1L;

	public ModelCheckAlgException(String desc) {
		super(desc);
	}
}
