package edu.wis.jtlv.env.module;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.StmtDefineOperator;
import edu.wis.jtlv.env.core.smv.eval.ValueConsStmt;

/**
 * <p>
 * This object represents a define declaration field. It is degenerate in a way
 * by not supporting the 'other', 'prime', and 'unprime' procedures.
 * </p>
 * 
 * <p>
 * Since define can refer to other defines, fields, values, etc., and has no
 * real entity of its own (i.e. marco), define is declared in two stages. The
 * first is only for declaring its existence. The second is for real evaluation.
 * The second stage is done just-in-time (per demand), i.e. if not refer to, the
 * second stage will not be execute.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class ModuleBDDDefine extends ModuleEntity {

	/**
	 * <p>
	 * The parsing statement. i.e. pre-evaluation.
	 * </p>
	 */
	protected StmtDefineOperator main_stmt;

	/**
	 * <p>
	 * The main public constructor. Given a path, a name, a new define field is
	 * created with no associated statement.<br>
	 * In order to complete the instantiation properly, an expression most be
	 * attached.
	 * </p>
	 * 
	 * @param a_path
	 *            A path to the field.
	 * @param name
	 *            A name for this field.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#attachStmt(StmtDefineOperator)
	 */
	public ModuleBDDDefine(String a_path, String name) {
		this.path = a_path;
		this.name = name;
		this.main_stmt = null;
	}

	/**
	 * <p>
	 * Attach an expression to the define.
	 * </p>
	 * 
	 * @param stmt
	 *            The parsing statement to attach.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#ModuleBDDDefine(String,
	 *      String)
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#getStmt()
	 */
	public void attachStmt(StmtDefineOperator stmt) {
		this.main_stmt = stmt;
	}

	/**
	 * <p>
	 * Getter for the parsing statement.
	 * </p>
	 * 
	 * @return The parsing statement attached to this define.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#attachStmt(StmtDefineOperator)
	 */
	public AbstractElement getStmt() {
		return this.main_stmt;
	}

	/**
	 * <p>
	 * Check whether this define was attached with an expression. (i.e. this
	 * define can continue to the second stage.)
	 * </p>
	 * 
	 * @return true if this define is attached with an expression, false
	 *         otherwise.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#attachStmt(StmtDefineOperator)
	 */
	public boolean isInitiated() {
		return this.main_stmt != null;
	}

	/**
	 * <p>
	 * Evaluate the statement, and return the BDD value.
	 * </p>
	 * 
	 * @return The BDD value of the statement.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#attachStmt(StmtDefineOperator)
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#getIntVal()
	 */
	public BDD getBDDVal() {
		try {
			return this.main_stmt.eval_stmt().toBDD();
		} catch (Exception e) { // I want to also catch null pointer exception.
			// I have no choice.
			Env.doError(e, e.toString());
			return null;
		}
	}

	/**
	 * <p>
	 * Evaluate the statement, and return an array of integer values.
	 * </p>
	 * 
	 * @return An array of integer values of the statement.
	 * 
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#attachStmt(StmtDefineOperator)
	 * @see edu.wis.jtlv.env.module.ModuleBDDDefine#getBDDVal()
	 */
	public int[] getIntVals() {
		int[] res = null;
		try {
			AbstractElement ae = this.main_stmt.getVal();
			if (ae instanceof ValueConsStmt) {
				ValueConsStmt vae = (ValueConsStmt) ae;
				if (vae.isValueConsRangeStmt()) {
					int from = vae.toValueConsRangeStmt().fromRange();
					int to = vae.toValueConsRangeStmt().toRange();
					res = new int[to - from + 1];
					for (int i = 0; i < res.length; i++) {
						res[i] = to + i;
					}
				} else if (vae.isValueConsStrStmt()) {
					String[] vals = vae.toValueConsStrStmt().getValues();
					res = new int[vals.length];
					for (int i = 0; i < vals.length; i++) {
						res[i] = Integer.parseInt(vals[i]);
					}
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return res;
	}
}
