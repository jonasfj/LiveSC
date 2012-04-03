package edu.wis.jtlv.env.core.smv.eval;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class StmtOperator extends AbstractUnaryOperator {
	private SMVModule context;

	public StmtOperator(SMVModule a_context, AbstractElement the_stmt)
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
		return "Statement";
	}

	@Override
	protected StmtOperator duplicate() throws SMVParseException {
		return new StmtOperator(this.context, this.getVal());
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public ValueStmt eval_stmt() throws SMVParseException {
		this.evalDefineMacro(this);
		this.pushNextDown(this.context, null, null);
		this.evalCaseMacro(this.context, null, null);
		return this.getVal().newEval();
	}

	@Override
	protected ValueStmt doDefaultNodeOp(ValueStmt v) throws SMVParseException {
		throw new SMVParseException("No default operation for assign statement");
	}
}
