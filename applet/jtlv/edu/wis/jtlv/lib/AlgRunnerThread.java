package edu.wis.jtlv.lib;

/**
 * <p>
 * A runner thread to execute any kind of algorithm, which implemented the AlgI
 * scheme.
 * </p>
 * 
 * @author yaniv sa'ar
 * 
 */
public class AlgRunnerThread extends Thread {
	private AlgI algo;
	private AlgResultI preResult;
	private AlgResultI doResult;
	private AlgResultI postResult;
	private AlgExceptionI preException;
	private AlgExceptionI doException;
	private AlgExceptionI postException;

	/**
	 * <p>
	 * A constructor for an algorithm runner.
	 * </p>
	 * 
	 * @param algorithm
	 *            The algorithm which this runner will perform.
	 */
	public AlgRunnerThread(AlgI algorithm) {
		this.algo = algorithm;
	}

	/**
	 * <p>
	 * <b>NOTE</b> that when not using the sequential mode, the user should take
	 * care of BDD synchronization issue - see the following link for more
	 * details {@link edu.wis.jtlv.env.JTLVThread }
	 * </p>
	 * 
	 * @see java.lang.Thread#run()
	 * @see AlgRunnerThread#runSequential()
	 */
	public void run() {
		preException = null;
		try {
			preResult = algo.preAlgorithm();
		} catch (AlgExceptionI e) {
			preException = e;
		}
		doException = null;
		try {
			doResult = algo.doAlgorithm();
		} catch (AlgExceptionI e) {
			doException = e;
		}
		postException = null;
		try {
			postResult = algo.postAlgorithm();
		} catch (AlgExceptionI e) {
			postException = e;
		}
	}

	/**
	 * <p>
	 * Execute in sequential mode.<br>
	 * <b>NOTE</b> that when not using the sequential mode, the user should take
	 * care of BDD synchronization issue - see the following link for more
	 * details {@link edu.wis.jtlv.env.JTLVThread }
	 * </p>
	 */
	public void runSequential() {
		this.start();
		try {
			this.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Getter for the pre-run phase results.
	 * </p>
	 * 
	 * @return The pre-run phase results.
	 */
	public AlgResultI getPreResult() {
		return preResult;
	}

	/**
	 * <p>
	 * Getter for the main run phase results.
	 * </p>
	 * 
	 * @return The main run phase results.
	 */
	public AlgResultI getDoResult() {
		return doResult;
	}

	/**
	 * <p>
	 * Getter for the post-run phase results.
	 * </p>
	 * 
	 * @return The post-run phase results.
	 */
	public AlgResultI getPostResult() {
		return postResult;
	}

	/**
	 * <p>
	 * Getter for the pre-run phase exception.
	 * </p>
	 * 
	 * @return The pre-run phase exception.
	 */
	public AlgExceptionI getPreException() {
		return preException;
	}

	/**
	 * <p>
	 * Getter for the main run phase exception.
	 * </p>
	 * 
	 * @return The main run phase exception.
	 */
	public AlgExceptionI getDoException() {
		return doException;
	}

	/**
	 * <p>
	 * Getter for the post-run phase exception.
	 * </p>
	 * 
	 * @return The post-run phase exception.
	 */
	public AlgExceptionI getPostException() {
		return postException;
	}
}
