package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class StmtDefineOperator extends AbstractUnaryOperator {
	private SMVModule context;

	public StmtDefineOperator(SMVModule a_context, AbstractElement the_stmt)
			throws SMVParseException {
		super(the_stmt);
		this.context = a_context;
	}

	@Override
	protected ValueStmt do_eval() throws SMVParseException {
		return this.getVal().do_eval();
	}

	@Override
	public String elemToString() {
		return "Define";
	}

	@Override
	protected StmtDefineOperator duplicate() throws SMVParseException {
		return new StmtDefineOperator(this.context, this.getVal());
	}

	// ////////////////
	// mostly do nothing except define
	@Override
	protected void evalDefineMacro(AbstractElement par) {
		// this has only single child...
		int my_index = par.nChildIndex(this); 
		par.nSetChild(my_index, this.nGetChild(0));
		par.nGetChild(my_index).evalDefineMacro(par);
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public ValueStmt eval_stmt() throws SMVParseException {
		// return this.do_eval();
		return this.getVal().newEval();
	}

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt v) throws SMVParseException {
		return v;
		// throw new SMVParseException("No default operation for Define
		// statement");
	}
}
