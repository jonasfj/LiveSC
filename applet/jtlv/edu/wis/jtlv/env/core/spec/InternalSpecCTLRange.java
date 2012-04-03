package edu.wis.jtlv.env.core.spec;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

/**
 * <p>
 * This node is a range node for the Real Time CTL operators.<br>
 * Simple ranges are not assigned with such a node, and are evaluated as a smv
 * expressions.<br>
 * For consistency, this is not regarded as a temporal operator in the queries.
 * Its holder should mark it as a temporal operator.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class InternalSpecCTLRange extends InternalSpec {
	private int from;
	private int to;

	public InternalSpecCTLRange(int from, int to, Token start) {
		super(from + ".." + to, start);
		this.from = from;
		this.to = to;
	}

	public InternalSpecCTLRange(String from, String to, Token start) {
		this(Integer.parseInt(from), Integer.parseInt(to), start);
	}

	public int getFrom() {
		return this.from;
	}

	public int getTo() {
		return this.to;
	}

	@Override
	public void evalBDDChildrenExp(TokenStream input)
			throws SpecParseException {
		// do nothing.
		this.setChildrenBDDsAsEvaluated(true);
	}

	@Override
	public boolean isPropSpec() {
		return true;
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
	public boolean isCTLStarSpec() {
		return true;
	}

	@Override
	public boolean hasTemporalOperators() {
		return false;
	}

	@Override
	public String toString() {
		return "#[" + this.getFrom() + ".." + this.getTo() + "]";
	}
}
