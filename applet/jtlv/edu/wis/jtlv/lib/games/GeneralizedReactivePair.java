package edu.wis.jtlv.lib.games;

import net.sf.javabdd.BDD;

/**
 * <p>
 * A pair of sets of BDD's representing a generalized reactive property where if
 * 'assumption_{1...n}', and 'guarantee_{1...m}' are given, then the
 * specification is "([]<>assumption_1 /\ ... /\ []<>assumption_n) ->
 * ([]<>guarantee_1 /\ ... /\ []<>guarantee_m)".
 * </p>
 * 
 * @author yaniv sa'ar
 * 
 */
public class GeneralizedReactivePair {
	private BDD assum[], guaran[];

	public GeneralizedReactivePair(BDD[] assumption, BDD[] guarantee) {
		this.assum = assumption;
		this.guaran = guarantee;
	}

	public int getNumOfAssum() {
		return assum.length;
	}

	public BDD[] getAllAssum() {
		return assum;
	}

	public BDD getAssum(int idx) {
		return assum[idx];
	}

	public int getNumOfGuarantee() {
		return guaran.length;
	}

	public BDD[] getAllGuarantee() {
		return guaran;
	}

	public BDD getGuarantee(int idx) {
		return guaran[idx];
	}
}
