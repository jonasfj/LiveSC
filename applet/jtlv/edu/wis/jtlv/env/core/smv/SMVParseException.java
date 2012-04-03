package edu.wis.jtlv.env.core.smv;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

import edu.wis.jtlv.env.core.smv.schema.SMVParsingInfo;

public class SMVParseException extends RecognitionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private TokenStream tokenInput;
	
	public SMVParseException(String desc, IntStream arg0) {
		super(arg0);
		this.description = desc;
	}

	private SMVParsingInfo parse_info;
	private String description;

	public SMVParseException(String desc, SMVParsingInfo an_info) {
		super();
		this.description = desc;
		this.parse_info = an_info;
	}

	public SMVParseException(String desc) {
		this(desc, (SMVParsingInfo) null);
	}

	public boolean hasParseInfo() {
		return (this.parse_info != null);
	}
	
	public SMVParsingInfo getParseInfo() {
		return this.parse_info;
	}
	
	
	public String toString() {
		return (hasParseInfo() ? this.parse_info.toString() + " " : "")
				+ this.description;
	}
}
