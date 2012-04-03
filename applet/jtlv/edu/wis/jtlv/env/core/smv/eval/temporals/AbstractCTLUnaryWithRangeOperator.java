package edu.wis.jtlv.env.core.smv.eval.temporals;

import java.util.Vector;

import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.core.smv.eval.AbstractElement;
import edu.wis.jtlv.env.core.smv.eval.AbstractUnaryOperator;
import edu.wis.jtlv.env.core.smv.eval.ICTLOperator;

public abstract class AbstractCTLUnaryWithRangeOperator extends
		AbstractUnaryOperator implements ICTLOperator {
	protected Vector<String> range;

	public AbstractCTLUnaryWithRangeOperator(AbstractElement a_val,
			Vector<String> a_range) throws SMVParseException {
		super(a_val);
		this.range = a_range;
	}

	@Override
	public String toString() {
		return "[" + elemToString() + " " + getVal().toString() + ", " + range.toString()
				+ "]";
	}
}
