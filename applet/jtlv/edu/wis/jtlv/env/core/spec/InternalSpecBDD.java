package edu.wis.jtlv.env.core.spec;

import net.sf.javabdd.BDD;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVLexer;
import edu.wis.jtlv.env.core.smv.SMVParser;
import edu.wis.jtlv.env.core.smv.SMVStmtWalker;
import edu.wis.jtlv.env.core.smv.Initiator;
import edu.wis.jtlv.env.core.smv.eval.StmtOperator;

/**
 * <p>
 * First order specification.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class InternalSpecBDD extends InternalSpec {
	private BDD val = null;

	public InternalSpecBDD(String exp_str, Token start) {
		super(exp_str, start);
	}

	public BDD getVal() {
		return this.val;
	}
	
	public String getExprStr() {
		return this.exp_str;
	}

	@Override
	public void evalBDDChildrenExp(TokenStream input)
			throws SpecParseException {
		// do nothing... (since it has no children...
		// the actual evaluation of this expr, will be done by the holding
		// expression
		this.setChildrenBDDsAsEvaluated(true);
	}

	public void evalBDDExp(TokenStream input)
			throws SpecParseException {
		if (this.val != null)
			return;
		if (!InternalSpec.evalBDDs)
			return;
		// else

		try {
			// faking position...
			String parse_exp = "";
			for (int i = 0; i < this.tstart.getLine() - 1; i++)
				parse_exp += "\n";
			for (int i = 0; i < this.tstart.getCharPositionInLine(); i++)
				parse_exp += " ";
			parse_exp += this.exp_str;
			// //////////////////////////////////////////
			// 1. // lexer and parsing //////////////////
			// //////////////////////////////////////////
			SMVLexer lex = new SMVLexer(new ANTLRStringStream(parse_exp));
			CommonTokenStream tokens = new CommonTokenStream(lex);
			SMVParser parser = new SMVParser(tokens);
			SMVParser.simple_expression_return pr;
			pr = parser.simple_expression();

			// //////////////////////////////////////////
			// 2. // evaluating statement ///////////////
			// //////////////////////////////////////////
			tokens.rewind();
			CommonTreeNodeStream expr_nodes;
			expr_nodes = new CommonTreeNodeStream((Tree) pr.getTree());
			expr_nodes.setTokenStream(tokens);
			SMVStmtWalker walker = new SMVStmtWalker(expr_nodes);
			SMVStmtWalker.simple_expression_return wr;
			Initiator.get_instance().collect_module_inst("main");
			wr = walker.simple_expression();
			// if a "clean" exception, error recovery, and a message, had been
			// thrown internally, then the result will be null...
			if ((wr != null) & (wr.ret != null)) {
				StmtOperator stmt = new StmtOperator(null, wr.ret.arr[0]);
				this.val = (stmt.eval_stmt()).toBDD();
			}
		} catch (RecognitionException re) {
			SPCParser.in_my_recovery_mode = true;
			// throw new SpecParseException("BDD statement exception: " +
			// re.getMessage(), input);
		} catch (Exception e) {
			SPCParser.in_my_recovery_mode = true;
			// throw new SpecParseException("BDD statement exception: " +
			// e.toString(), input);
		}
	}

	@Override
	public boolean isCTLSpec() {
		return true;
	}

	@Override
	public boolean isRealTimeCTLSpec() {
		return true;
	}

	@Override
	public boolean isCTLStarSpec() {
		return true;
	}

	@Override
	public boolean isLTLSpec() {
		return true;
	}

	@Override
	public boolean isFutureLTLSpec() {
		return true;
	}

	@Override
	public boolean isPastLTLSpec() {
		return true;
	}

	@Override
	public boolean isPropSpec() {
		return true;
	}

	@Override
	public boolean hasTemporalOperators() {
		return false;
	}

	@Override
	public String toString() {
		if (this.getVal() == null)
			if (this.getExprStr() != "")
				return "\"" + this.getExprStr() + "\"";
			else
				return "[!$#! Cannot Identify BDD Expression]";
		return "#[" + Env.toNiceSignleLineString(null, this.getVal()) + "]";
		// return "#[" + this.getExprStr() + "]";
	}
}
