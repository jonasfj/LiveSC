package edu.wis.jtlv.env.core.smv;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

public class SMVUnimplementedException extends RecognitionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	public SMVUnimplementedException(String desc) {
//		super();
//		this.description = desc;
//	}
	
	public SMVUnimplementedException(String desc, IntStream arg0) {
		super(arg0);
		this.description = desc;
	}
		
	private String description;
	
	public String toString() {
		return this.description;
	}
}
