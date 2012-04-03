package edu.wis.jtlv.env.core.smv;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

public class SMVInternalParseException extends RecognitionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;
//	public SMVInternalParseException(String desc) {
//		super();
//		this.description = desc;
//	}
	
	public SMVInternalParseException(String desc, IntStream arg0) {
		super(arg0);
		arg0.consume();
		this.description = desc;
	}
	
	public String toString() {
		return this.description;
	}
}
