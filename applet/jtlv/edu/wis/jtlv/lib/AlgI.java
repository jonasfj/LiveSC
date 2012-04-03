package edu.wis.jtlv.lib;

/**
 * <p>
 * Implement your algorithm, use or ignore what ever phases that you'd like.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public interface AlgI {

	/**
	 * <p>
	 * Pre algorithm phase.
	 * </p>
	 * 
	 * @return Any kind of results the algorithm choose to.
	 * @throws AlgExceptionI
	 *             Wherever the algorithm implementor choose to.
	 */
	public AlgResultI preAlgorithm() throws AlgExceptionI;

	/**
	 * <p>
	 * The main algorithm phase.
	 * </p>
	 * 
	 * @return Any kind of results the algorithm choose to.
	 * @throws AlgExceptionI
	 *             Wherever the algorithm implementor choose to.
	 */
	public AlgResultI doAlgorithm() throws AlgExceptionI;

	/**
	 * <p>
	 * Post algorithm phase.
	 * </p>
	 * 
	 * @return Any kind of results the algorithm choose to.
	 * @throws AlgExceptionI
	 *             Wherever the algorithm implementor choose to.
	 */
	public AlgResultI postAlgorithm() throws AlgExceptionI;

}
