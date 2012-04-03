package edu.wis.jtlv.lib;

import edu.wis.jtlv.env.Env;
import net.sf.javabdd.BDD;

/**
 * <p>
 * BDD array results (Path).
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class AlgResultPath implements AlgResultI {
	private ResultStatus stat;
	private BDD[] result;

	/**
	 * <p>
	 * A constructor for a path results, with a general flag is was
	 * successful.
	 * </p>
	 * 
	 * @param was_successful
	 *            Did the algorithm succeed.
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultPath(boolean was_successful, BDD[] res) {
		this.result = res;
		this.stat = was_successful ? ResultStatus.succeed : ResultStatus.failed;
	}

	/**
	 * <p>
	 * A constructor for a path results, with a general flag is was
	 * successful.
	 * </p>
	 * 
	 * @param fin_status
	 *            The algorithm finishing status.
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultPath(ResultStatus fin_status, BDD[] res) {
		this.result = res;
		this.stat = fin_status;
	}

	/**
	 * <p>
	 * A constructor for a path results, without successfulness status.
	 * </p>
	 * 
	 * @param res
	 *            The results themselves.
	 */
	public AlgResultPath(BDD[] res) {
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
	 * A BDD[] object representation of the results.
	 * </p>
	 * 
	 * @return A BDD[] object representing the results.
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
		String res = "";
		res += "   Counter Example \n";
		res += "=====================\n";
		for (int i = 0; i < this.result.length; i++) {
			res += "[" + i + "] " + Env.toNiceString(this.result[i]);
			res += ((i == (this.result.length - 1)) ? "" : "\n");
		}
		return res;
	}
}
