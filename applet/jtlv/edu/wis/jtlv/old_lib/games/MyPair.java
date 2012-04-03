package edu.wis.jtlv.old_lib.games;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.old_lib.games.Memory;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author Nir Piterman <firstname.lastname@doc.ic.ac.uk>
 * 
 */
public class MyPair {
	public BDD bdd;
	public Memory mem;

	public MyPair(BDD bdd, Memory mem) {
		this.bdd = bdd;
		this.mem = mem;
	}
}
