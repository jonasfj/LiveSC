package edu.wis.jtlv.old_lib.mc;

import edu.wis.jtlv.env.module.SMVModule;

/**
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public abstract class ModelChecker {

	private SMVModule design;

	public ModelChecker(SMVModule design, boolean removeRunningVar) throws ModelCheckException {
		if (design == null)
			throw new ModelCheckException("Cannot instatiate an LTL Model "
					+ "Checker with a null module.");
		this.design = design;
		if (removeRunningVar)
			this.design.removeRunningVar();

	}

	public SMVModule getDesign() {
		return this.design;
	}

	//public abstract void modelCheck(Spec property) throws ModelCheckException;

}
