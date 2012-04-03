package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class OpCond extends AbstractElement implements IBoolOperator {
	public OpCond(AbstractElement[] a_cond, AbstractElement[] a_then)
			throws SMVParseException {
		super(new AbstractElement[] {});
		if (a_cond.length != a_then.length)
			throw new SMVParseException("Cannot constract a conditional "
					+ "operation with out matching then statements");
		AbstractElement[] children = new AbstractElement[a_cond.length * 2];
		for (int i = 0; i < children.length; i++) {
			children[i] = (i % 2 == 0) ? a_cond[i / 2] : a_then[i / 2];
		}
		this.nSetChildren(children);
	}

	public AbstractElement[] getCond() {
		AbstractElement[] res = new AbstractElement[this.nChildrenCount() / 2];
		for (int i = 0; i < res.length; i++)
			res[i] = this.nGetChild(i * 2);
		return res;
	}

	public AbstractElement getCond(int index) {
		return this.nGetChild(index * 2);
	}

	public AbstractElement[] getThen() {
		AbstractElement[] res = new AbstractElement[this.nChildrenCount() / 2];
		for (int i = 0; i < res.length; i++)
			res[i] = this.nGetChild((i * 2) + 1);
		return res;
	}

	public AbstractElement getThen(int index) {
		return this.nGetChild((index * 2) + 1);
	}

	// //////////////
	// mostly do nothing except conditional stmt.
	@Override
	protected void evalCaseMacro(SMVModule a_context, AbstractElement grand,
			AbstractElement par) {
		try {
			// 1. case this a "stand alone" statement.
			if (grand == null) {
				// no above operator for this "case" statement....
				assert par instanceof StmtOperator;
				int my_index = par.nChildIndex(this);
				AbstractElement to_sub = new ValueBDDStmt(a_context, Env.TRUE());
				for (int k = this.getCond().length - 1; k >= 0; k--) {
					AbstractElement succ_cond = new OpImplies(this.getCond(k),
							this.getThen(k));
					AbstractElement fail_cond = new OpImplies(new OpNot(this
							.getCond(k)), to_sub);
					to_sub = new OpAnd(succ_cond, fail_cond);
				}
				par.nSetChild(my_index, to_sub);
				par.nGetChild(my_index).evalCaseMacro(a_context, grand, par);
				return;
			}

			// this has only single child...
			int my_index = par.nChildIndex(this);
			int fa_index = grand.nChildIndex(par);
			AbstractElement to_sub = new ValueBDDStmt(a_context, Env.TRUE());

			// 2. case the "case" holder is a next statement, the evaluation
			// is a little different.
			if (par instanceof OpNext) {
				// 3. otherwise, the general case...
				for (int k = this.getCond().length - 1; k >= 0; k--) {
					AbstractElement dup_par = par.duplicate();
					AbstractElement next_cond = new OpNext(this.getCond(k));
					dup_par.nSetChild(my_index, this.getThen(k));
					AbstractElement succ_cond = new OpImplies(next_cond,
							dup_par);
					AbstractElement fail_cond = new OpImplies(new OpNot(
							next_cond), to_sub);
					to_sub = new OpAnd(succ_cond, fail_cond);
				}
				//to_sub.pushNextDown(a_context, grand, par);
			} else {
				// 3. otherwise, the general case...
				for (int k = this.getCond().length - 1; k >= 0; k--) {
					AbstractElement dup_par = par.duplicate();
					dup_par.nSetChild(my_index, this.getThen(k));
					AbstractElement succ_cond = new OpImplies(this.getCond(k),
							dup_par);
					AbstractElement fail_cond = new OpImplies(new OpNot(this
							.getCond(k)), to_sub);
					to_sub = new OpAnd(succ_cond, fail_cond);
				}
			}

			grand.nSetChild(fa_index, to_sub);
			grand.nGetChild(fa_index).evalCaseMacro(a_context, null, grand);
		} catch (SMVParseException e) {
		}
	}

	@Override
	public String elemToString() {
		return " ? : ";
	}

	@Override
	public String toString() {
		String res = "[";
		for (int i = 0; i < this.getCond().length; i++) {
			res += "{" + this.getCond(i).toString() + " : "
					+ this.getThen(i).toString() + "}";
		}
		return res + "]";
	}

	@Override
	protected OpCond duplicate() throws SMVParseException {
		return new OpCond(this.getCond(), this.getThen());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	@Override
	protected ValueStmt newEval() throws SMVParseException {
		throw new SMVParseException("Cannot evaluate a conditional op without"
				+ " pre processing.");
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		throw new SMVParseException("Cannot evaluate a conditional op without"
				+ " pre processing.");
	}

}
