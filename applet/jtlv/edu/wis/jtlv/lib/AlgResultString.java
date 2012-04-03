package edu.wis.jtlv.lib;

/**
 * <p>
 * String results.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class AlgResultString implements AlgResultI {
	private ResultStatus stat;
	private String result;

	/**
	 * <p>
	 * A constructor for a String results, with a general flag is was
	 * successful.
	 * </p>
	 * 
	 * @param was_successful
	 *            Did the algorithm succeed.
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultString(boolean was_successful, String res) {
		this.result = res;
		this.stat = was_successful ? ResultStatus.succeed : ResultStatus.failed;
	}

	/**
	 * <p>
	 * A constructor for a String results, with a general flag is was
	 * successful.
	 * </p>
	 * 
	 * @param fin_status
	 *            The algorithm finishing status.
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultString(ResultStatus fin_status, String res) {
		this.result = res;
		this.stat = fin_status;
	}

	/**
	 * <p>
	 * A constructor for a String results, without successfulness status.
	 * </p>
	 * 
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultString(String res) {
		this.result = res;
		this.stat = ResultStatus.undecided;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wis.jtlv.lib.AlgResultI#getResultStat()
	 */
	@Override
	public ResultStatus getResultStat() {
		return stat;
	}

	/**
	 * <p>
	 * A String object representation of the results.
	 * </p>
	 * 
	 * @return A String object representing the results.
	 */
	@Override
	public Object resultObject() {
		return this.result;
	}

	/* (non-Javadoc)
	 * @see edu.wis.jtlv.lib.AlgResultI#resultString()
	 */
	@Override
	public String resultString() {
		return this.result;
	}
}
