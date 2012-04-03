package edu.wis.jtlv.env.core.spec;

import java.util.Vector;


// a work around for the parser since he cannot work directly with vectors. 
public class WAArrayOfSpec {
	public Vector<InternalSpec> specs;

	public WAArrayOfSpec() {
		this.specs = new Vector<InternalSpec>();
	}

	public InternalSpec[] getArray() {
		InternalSpec[] res = new InternalSpec[specs.size()];
		specs.toArray(res);
		return res;
	}
}
