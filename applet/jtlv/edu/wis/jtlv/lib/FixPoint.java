package edu.wis.jtlv.lib;

/**
 * <p>
 * A template for fix-point using for loop.
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class FixPoint<T> {

	private T previous;

	public FixPoint() {
		previous = null;
	}

	public FixPoint(T initial_old_value) {
		previous = initial_old_value;
	}

	/**
	 * Given the element to fix-point on, determine whether it has changed since
	 * the last time a check was performed. If it had changed, then another
	 * iteration is allowed.
	 * 
	 * <p>
	 * <b>NOTE</b> that the fix-point is on the object's equality. If the
	 * Underlying current object is changed, then it might affect this iterator.
	 * (e.g. if you are using BDD.*With API, then you are changing the object
	 * himself)
	 * </p>
	 * 
	 * @param curr
	 *            The current value of the element to perform fix-point upon.
	 * @return true, if the element has changed since the last time, otherwise
	 *         false.
	 */
	public boolean advance(T curr) {
		boolean res = (previous == null) ? true : (!curr.equals(previous));
		previous = curr;
		return res;
	}
}
