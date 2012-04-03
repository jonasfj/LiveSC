package edu.wis.jtlv.lib;

/**
 * <p>
 * Implement the resulting object, as a string, and as what ever object that
 * you'd like.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public interface AlgResultI {

	/**
	 * <p>
	 * A general flag for the results status.
	 * </p>
	 * 
	 * @author yaniv sa'ar
	 * 
	 */
	public static enum ResultStatus {
		failed, succeed, undecided
	}

	/**
	 * <p>
	 * Get the result status.
	 * </p>
	 * 
	 * @return The results status.
	 */
	public ResultStatus getResultStat();

	/**
	 * <p>
	 * A string representation of the results.
	 * </p>
	 * 
	 * @return A string representing the results.
	 */
	public String resultString();

	/**
	 * <p>
	 * An object representation of the results.
	 * </p>
	 * 
	 * @return An object representing the results.
	 */
	public Object resultObject();

}
