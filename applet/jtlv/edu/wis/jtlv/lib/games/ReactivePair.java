package edu.wis.jtlv.lib.games;

import net.sf.javabdd.BDD;

/**
 * <p>
 * A pair of BDD's representing a reactive property where if 'assumption', and
 * 'guarantee' are given, then the specification is
 * "[]<>assumption -> []<>guarantee".
 * </p>
 * 
 * @author yaniv sa'ar
 * 
 */
public class ReactivePair {
	private BDD assum, guaran;

	public ReactivePair(BDD assumption, BDD guarantee) {
		this.assum = assumption;
		this.guaran = guarantee;
	}

	public BDD getAssum() {
		return assum;
	}

	public BDD getGuarantee() {
		return guaran;
	}
}
