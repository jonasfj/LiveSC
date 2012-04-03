package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public abstract class AbstractElement {

	public AbstractElement(AbstractElement[] children) {
		this.nSetChildren(children);
	}

	protected abstract AbstractElement duplicate() throws SMVParseException;

	protected abstract ValueStmt do_eval() throws SMVParseException;

	public abstract String elemToString();

	public abstract String toString();

	protected abstract ValueStmt newEval() throws SMVParseException;

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// new impl for children, parenting, define, and conditional macros.
	private AbstractElement nParent;
	private AbstractElement[] nChildren;

	protected int nChildrenCount() {
		return nChildren.length;
	}

	protected AbstractElement[] nGetChildren() {
		return nChildren;
	}

	protected AbstractElement nGetParent() {
		return nParent;
	}

	protected AbstractElement nGetChild(int i) throws IndexOutOfBoundsException {
		return nChildren[i];
	}

	protected void nSetChild(int i, AbstractElement nChild)
			throws IndexOutOfBoundsException {
		nChildren[i] = nChild;
		nChildren[i].nSetParent(this);
	}

	protected void nSetChildren(AbstractElement[] children) {
		this.nChildren = children;
		for (AbstractElement child : this.nChildren) {
			child.nSetParent(this);
		}
	}

	protected int nChildIndex(AbstractElement child) {
		for (int i = 0; i < this.nGetChildren().length; i++)
			if (this.nGetChildren()[i] == child)
				return i;
		return -1;
	}

	private void nSetParent(AbstractElement par) {
		nParent = par;
	}

	// ////////////////
	// mostly do nothing except define
	protected void evalDefineMacro(AbstractElement par) {
		for (int i = 0; i < this.nGetChildren().length; i++) {
			this.nGetChildren()[i].evalDefineMacro(this);
		}
	}

	// mostly do nothing except conditional stmt.
	protected void evalCaseMacro(SMVModule a_context, AbstractElement grand,
			AbstractElement par) {
		for (int i = 0; i < this.nGetChildren().length; i++) {
			this.nGetChildren()[i].evalCaseMacro(a_context, par, this);
		}
	}

	// used by the define macro to push the wrapping next down
	// mostly do nothing except next expression.
	protected void pushNextDown(SMVModule a_context, AbstractElement grand,
			AbstractElement par) {
		if (par instanceof OpNext) {
			if (this instanceof ValueStmt) {
				return;
			}

			int par_idx = grand.nChildIndex(par);
			grand.nSetChild(par_idx, this);

			for (int i = 0; i < this.nGetChildren().length; i++) {
				try {
					AbstractElement child = this.nGetChildren()[i];
					AbstractElement new_child = new OpNext(child);
					this.nSetChild(i, new_child);
					child.pushNextDown(a_context, this, new_child);
				} catch (SMVParseException e) {
				}
			}
		} else {
			for (int i = 0; i < this.nGetChildren().length; i++) {
				this.nGetChildren()[i].pushNextDown(a_context, par, this);
			}
		}
	}
}
