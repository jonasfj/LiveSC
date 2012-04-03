package edu.wis.jtlv.lib;

import edu.wis.jtlv.env.module.Module;

/**
 * <p>
 * Module results.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class AlgResultModule implements AlgResultI {
	private ResultStatus stat;
	private Module result;

	/**
	 * <p>
	 * A constructor for a module results, with a general flag is was
	 * successful.
	 * </p>
	 * 
	 * @param was_successful
	 *            Did the algorithm succeed.
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultModule(boolean was_successful, Module res) {
		this.result = res;
		this.stat = was_successful ? ResultStatus.succeed : ResultStatus.failed;
	}

	/**
	 * <p>
	 * A constructor for a module results, with a general flag is was
	 * successful.
	 * </p>
	 * 
	 * @param fin_status
	 *            The algorithm finishing status.
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultModule(ResultStatus fin_status, Module res) {
		this.result = res;
		this.stat = fin_status;
	}

	/**
	 * <p>
	 * A constructor for a module results, without successfulness status.
	 * </p>
	 * 
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultModule(Module res) {
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
	 * A Module object representation of the results.
	 * </p>
	 * 
	 * @return A Module object representing the results.
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
		return this.result.toString();
	}
}
