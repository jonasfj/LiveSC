package edu.wis.jtlv.env.core.fds;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

import edu.wis.jtlv.env.core.smv.schema.SMVParsingInfo;

public class FDSParseException extends RecognitionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FDSParseException(String desc, IntStream arg0) {
		super(arg0);
		this.description = desc;
	}

	private SMVParsingInfo parse_info;
	private String description;

	public FDSParseException(String desc, SMVParsingInfo an_info) {
		super();
		this.description = desc;
		this.parse_info = an_info;
	}

	public FDSParseException(String desc) {
		this(desc, (SMVParsingInfo) null);
	}

	public boolean hasParseInfo() {
		return (this.parse_info != null);
	}

	public String toString() {
		return (hasParseInfo() ? this.parse_info.toString() + " " : "")
				+ this.description;
	}
}
