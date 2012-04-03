package edu.wis.jtlv.env;

/**
 * <p>
 * An environment error listener interface. In order to listen and receive
 * errors thrown from the lexer, parser, walkers, one has register a listener
 * through Env.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
 * @see edu.wis.jtlv.env.Env#removeErrorListener(ErrorListener)
 * @see edu.wis.jtlv.env.Env#clearErrorListener()
 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
 * @see edu.wis.jtlv.env.Env#all_error_listeners
 */
public interface ErrorListener {
	public void doError(Exception e, String msg);
}
