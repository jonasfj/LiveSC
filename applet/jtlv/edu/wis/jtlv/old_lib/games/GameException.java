package edu.wis.jtlv.old_lib.games;

import java.io.IOException;

/**
 * <p>
 * A general framework for games exception.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class GameException extends IOException {
	private static final long serialVersionUID = 1L;

	public GameException(String str) {
		super(str);
	}
}
