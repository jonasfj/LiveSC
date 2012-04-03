package edu.wis.jtlv.env.core.smv.schema;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.tree.TreeNodeStream;

public class SMVParsingInfo {
	private IntStream input;

	// private RecognitionException re;
	public int row_no;
	public int column_no;

	// public SMVParsingInfo(int a_row, int a_column) {
	// this.row_no = a_row;
	// this.column_no = a_column;
	// }

	public SMVParsingInfo(IntStream an_input) {
		this.input = an_input;
		this.row_no = -1;
		this.column_no = 0;

		if (this.input instanceof TokenStream) {
			Token token = ((TokenStream) input).LT(1);
			this.row_no = token.getLine();
			this.column_no = token.getCharPositionInLine();
		}
		if (input instanceof TreeNodeStream) {
			extractInformationFromTreeNodeStream(input);
		} else if (input instanceof CharStream) {
			this.row_no = ((CharStream) input).getLine();
			this.column_no = ((CharStream) input).getCharPositionInLine();
		}

	}

	private void extractInformationFromTreeNodeStream(IntStream input) {
		TreeNodeStream nodes = (TreeNodeStream) input;
		Object node = nodes.LT(1);
		TreeAdaptor adaptor = nodes.getTreeAdaptor();
		Token payload = adaptor.getToken(node);
		if (payload != null) {
			if (payload.getLine() <= 0) {
				// imaginary node; no line/pos info; scan backwards
				int i = -1;
				Object priorNode = nodes.LT(i);
				while (priorNode != null) {
					Token priorPayload = adaptor.getToken(priorNode);
					if (priorPayload != null && priorPayload.getLine() > 0) {
						// we found the most recent real line / pos info
						this.row_no = priorPayload.getLine();
						this.column_no = priorPayload.getCharPositionInLine();
						break;
					}
					--i;
					priorNode = nodes.LT(i);
				}
			} else { // node created from real token
				this.row_no = payload.getLine();
				this.column_no = payload.getCharPositionInLine();
			}
		} else if (node instanceof Tree) {
			this.row_no = ((Tree) node).getLine();
			this.column_no = ((Tree) node).getCharPositionInLine();
		}
	}

	public String toString() {
		return "line " + this.row_no + ":" + this.column_no;
	}

	public IntStream get_input() {
		return this.input;
	}
}
