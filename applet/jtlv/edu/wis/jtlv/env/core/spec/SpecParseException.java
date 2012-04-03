package edu.wis.jtlv.env.core.spec;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

public class SpecParseException extends RecognitionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Token start;
	Token stop;

	public SpecParseException(String desc, IntStream arg0, Token start,
			Token stop) {
		super(arg0);
		this.start = start;
		this.stop = stop;
		super.line = this.getErrorStartLine();
		super.charPositionInLine = this.getErrorStartCharPos();
		this.description = desc;
	}

	private String description;

	// public SpecParseException(String desc) {
	// super();
	// this.description = desc;
	// }

	// public void setDescription(String to_set) {
	// this.description = to_set;
	// }

	public String toString() {
		return this.description;
	}

	public int getErrorStartLine() {
		return this.start.getLine();
	}

	public int getErrorStartCharPos() {
		return this.start.getCharPositionInLine();
	}

	public int getErrorStopLine() {
		return this.stop.getLine();
	}

	public int getErrorStopCharPos() {
		return this.stop.getCharPositionInLine() + this.stop.getText().length();
	}
}
