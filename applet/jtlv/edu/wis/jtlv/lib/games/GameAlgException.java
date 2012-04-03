package edu.wis.jtlv.lib.games;

import edu.wis.jtlv.lib.AlgExceptionI;

/**
 * <p>
 * A general framework for games exception.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class GameAlgException extends AlgExceptionI {
	private static final long serialVersionUID = 1L;

	public GameAlgException(String str) {
		super(str);
	}
}
