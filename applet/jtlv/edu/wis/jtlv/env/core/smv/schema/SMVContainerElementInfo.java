package edu.wis.jtlv.env.core.smv.schema;

import edu.wis.jtlv.env.core.smv.SMVParseException;

public abstract class SMVContainerElementInfo extends SMVAbstractElementInfo {

	public SMVContainerElementInfo(String a_name, SMVParsingInfo a_parse_info)
			throws SMVParseException {
		super(a_name, a_parse_info);
	}
}
