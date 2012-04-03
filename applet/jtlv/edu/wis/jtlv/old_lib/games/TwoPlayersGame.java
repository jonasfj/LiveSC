package edu.wis.jtlv.old_lib.games;

import net.sf.javabdd.BDD;

/**
 * <p>
 * A general interface for mathematical games.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public interface TwoPlayersGame extends Game {

	public abstract BDD firstPlayersWinningStates();
	
	public abstract BDD secondPlayersWinningStates();
	
}