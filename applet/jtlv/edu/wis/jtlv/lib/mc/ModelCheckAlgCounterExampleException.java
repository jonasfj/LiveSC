package edu.wis.jtlv.lib.mc;

import net.sf.javabdd.BDD;

/**
 * <p>
 * An exception dedicated for counter examples.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public class ModelCheckAlgCounterExampleException extends ModelCheckAlgException {
	private static final long serialVersionUID = 1L;
	private BDD[] path;

	public ModelCheckAlgCounterExampleException(String desc, BDD[] path) {
		super(desc);
		this.path = path;
	}

	public BDD[] getPath() {
		return this.path;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		String res = super.toString() + "\n";
		if ((path == null) || (path.length == 0))
			return res + "No Counter Example Exists.";
		res += " Counter Example\n";
		res += "=================\n";
		// the last is not printed. It is only to point to the cycle.
		BDD last = path[path.length - 1];
		int loop_index = -1;
		boolean loop_exists = false;
		for (int i = 0; i < path.length - 1; i++) {
			boolean loop_here = path[i].biimp(last).isOne();
			if ((loop_here) && (loop_index == -1)) {
				loop_index = i + 1;
				res += "[[" + (i + 1) + "]]";
				loop_exists = true;
			} else {
				res += "  " + (i + 1) + "  ";
			}
			res += " \t: " + path[i].toString() + "\n";
		}
		if (loop_exists)
			res += "Loop back to state " + loop_index;
		else
			res += "  " + path.length + "   \t: "
					+ path[path.length - 1].toString() + "\n";

		return res;
	}
}
