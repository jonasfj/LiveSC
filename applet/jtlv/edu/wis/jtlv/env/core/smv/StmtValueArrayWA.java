package edu.wis.jtlv.env.core.smv;

import edu.wis.jtlv.env.core.smv.eval.AbstractElement;


// this is a workaround since antlr cannot return an array... 
// it swallows the braces. 
public class StmtValueArrayWA {
	public AbstractElement[] arr;
	public int length;
	public StmtValueArrayWA(int size) {
		this.length = size;
		this.arr = new AbstractElement[this.length];
	}
}
