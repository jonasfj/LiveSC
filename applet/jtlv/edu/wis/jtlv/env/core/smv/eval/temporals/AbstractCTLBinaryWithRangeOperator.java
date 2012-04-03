package edu.wis.jtlv.env.core.smv.eval.temporals;

import java.util.Vector;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractBinaryOperator;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.ICTLOperator;

public abstract class AbstractCTLBinaryWithRangeOperator extends
		AbstractBinaryOperator implements ICTLOperator {
	protected String type;
	protected Vector<String> range;

	public AbstractCTLBinaryWithRangeOperator(AbstractElement a_left,
			String a_type, Vector<String> a_range, AbstractElement a_right)
			throws SMVParseException {
		super(a_left, a_right);
		this.type = a_type;
		this.range = a_range;
	}

	@Override
	public String toString() {
		return "[" + getLeft().toString() + " " + elemToString() + ", " + type
				+ ", " + range.toString() + getRight().toString() + "]";
	}
}
