package edu.wis.jtlv.lib;

/**
 * <p>
 * Boolean results.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class AlgResultBoolean implements AlgResultI {
	private ResultStatus stat;
	private boolean result;

	/**
	 * <p>
	 * A constructor for a Boolean results, with a general flag is was
	 * successful.
	 * </p>
	 * 
	 * @param was_successful
	 *            Did the algorithm succeed.
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultBoolean(boolean was_successful, boolean res) {
		this.result = res;
		this.stat = was_successful ? ResultStatus.succeed : ResultStatus.failed;
	}

	/**
	 * <p>
	 * A constructor for a Boolean results, with a general flag is was
	 * successful.
	 * </p>
	 * 
	 * @param fin_status
	 *            The algorithm finishing status.
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultBoolean(ResultStatus fin_status, boolean res) {
		this.result = res;
		this.stat = fin_status;
	}

	/**
	 * <p>
	 * A constructor for a Boolean results, without successfulness status.
	 * </p>
	 * 
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultBoolean(boolean res) {
		this.result = res;
		this.stat = ResultStatus.undecided;
	}

	/* (non-Javadoc)
	 * @see edu.wis.jtlv.lib.AlgResultI#getResultStat()
	 */
	@Override
	public ResultStatus getResultStat() {
		return stat;
	}

	/**
	 * <p>
	 * A Boolean object representation of the results.
	 * </p>
	 * 
	 * @return A Boolean object representing the results.
	 */
	@Override
	public Object resultObject() {
		return new Boolean(this.result);
	}

	/* (non-Javadoc)
	 * @see edu.wis.jtlv.lib.AlgResultI#resultString()
	 */
	@Override
	public String resultString() {
		return this.result ? "true" : "false";
	}
}
