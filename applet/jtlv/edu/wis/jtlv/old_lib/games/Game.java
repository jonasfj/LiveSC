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
public interface Game {
	public abstract BDD gameInitials();

	public abstract BDD[] playersWinningStates();

	public abstract void printWinningStrategy();
	
}