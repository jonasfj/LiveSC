package edu.wis.jtlv.lib;

/**
 * <p>
 * A general abstract class for any kind of exception.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public abstract class AlgExceptionI extends Exception {

	private static final long serialVersionUID = 1L;

	public AlgExceptionI() {
		super();
	}

	public AlgExceptionI(String message, Throwable cause) {
		super(message, cause);
	}

	public AlgExceptionI(String message) {
		super(message);
	}

	public AlgExceptionI(Throwable cause) {
		super(cause);
	}

}
