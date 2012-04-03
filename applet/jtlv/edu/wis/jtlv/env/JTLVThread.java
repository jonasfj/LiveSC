package edu.wis.jtlv.env;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;

/**
 * <p>
 * JTLVThread is a thread dedicated to BDD operations. The BDD packages them
 * selves are not implemented to support multi threading. This current
 * implementation is very restrictive. The user must be completely aware to the
 * implementation, and avoid the following issue.
 * </p>
 * 
 * <p>
 * Main thread has a BDD manager of its own. In addition, each instance of a
 * JTLV thread has a completely disjoint dedicated BDD manager in JTLV
 * environment. You can get the thread dedicated manager index by using
 * {@link edu.wis.jtlv.env.JTLVThread#getDedicatedBDDManagerIdx()}.<br>
 * Performing operation between two BDD, created from different BDD manager will
 * lead to and error. The only way to port BDDs from one manager to another is
 * by using adjustBDD* procedure given in this implementation. Porting is a BDD
 * action, be also careful with multi threading porting.<br>
 * e.g. don't do adjustBDDToBase in two concurrent threads since both are
 * writing to the same base manager.
 * </p>
 * 
 * <p>
 * The number managers must be declared up-front before doing anything in "Env"
 * (or before reseting the environment). The number of managers is declared by
 * the System.property key "pool_size" (plus one additional manager to the main
 * thread).<br>
 * Be aware that instantiating and assigning more JTLVThread then the number of
 * managers, will lock the last thread until a manager will be freed. (e.g.
 * might lead to a deadlock.)
 * </p>
 * 
 * @see edu.wis.jtlv.env.Env#getThreadPoolSize()
 * @see edu.wis.jtlv.env.Env#assignDedicatedBDDManagerIdx(JTLVThread)
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 */
public abstract class JTLVThread extends Thread {
	private boolean monitorCopyTime = false;
	private long copyTime = 0;

	protected JTLVThread() {
		super();
		this.dedicatedBDDManagerIdx = Env.assignDedicatedBDDManagerIdx(this);
	}

	protected JTLVThread(Runnable target) {
		super(target);
		this.dedicatedBDDManagerIdx = Env.assignDedicatedBDDManagerIdx(this);
	}

	protected JTLVThread(Runnable target, String name) {
		super(target, name);
		this.dedicatedBDDManagerIdx = Env.assignDedicatedBDDManagerIdx(this);
	}

	protected JTLVThread(String name) {
		super(name);
		this.dedicatedBDDManagerIdx = Env.assignDedicatedBDDManagerIdx(this);
	}

	protected JTLVThread(ThreadGroup group, Runnable target) {
		super(group, target);
		this.dedicatedBDDManagerIdx = Env.assignDedicatedBDDManagerIdx(this);
	}

	protected JTLVThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		this.dedicatedBDDManagerIdx = Env.assignDedicatedBDDManagerIdx(this);
	}

	protected JTLVThread(ThreadGroup group, Runnable target, String name,
			long stackSize) {
		super(group, target, name, stackSize);
		this.dedicatedBDDManagerIdx = Env.assignDedicatedBDDManagerIdx(this);
	}

	protected JTLVThread(ThreadGroup group, String name) {
		super(group, name);
		this.dedicatedBDDManagerIdx = Env.assignDedicatedBDDManagerIdx(this);
	}

	private int dedicatedBDDManagerIdx;

	public int getDedicatedBDDManagerIdx() {
		return dedicatedBDDManagerIdx;
	}

	public boolean isMonitoringCopyTime() {
		return monitorCopyTime;
	}

	/**
	 * <p>
	 * Reset the time this thread spent on copying.
	 * </p>
	 * 
	 * @see JTLVThread#getCopyTime()
	 */
	public void resetCopyTime() {
		monitorCopyTime = true;
		copyTime = 0;
	}

	protected void addCopyTime(long to_add) {
		copyTime += to_add;
	}

	/**
	 * <p>
	 * Get the accumulated overall time (since last reset) of copy to this BDD
	 * factory.
	 * </p>
	 * 
	 * @return The time it took to copy BDD's into this BDD factory.
	 * 
	 * @see JTLVThread#resetCopyTime()
	 */
	public long getCopyTime() {
		return copyTime;
	}

	/**
	 * <p>
	 * Copy the BDD to the manager assigned to this thread.
	 * </p>
	 * 
	 * @param to_adjust
	 *            The BDD to copy.
	 * @return The copied BDD in the manager assigned to this thread.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToBase(BDD)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToBase(BDD[])
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToManager(BDD[])
	 */
	public BDD adjustBDDToManager(BDD to_adjust) {
		long start_time = 0;
		if (isMonitoringCopyTime())
			start_time = System.currentTimeMillis();

		BDD res = Env.copyBDDIntoManager(this.getDedicatedBDDManagerIdx(),
				to_adjust);
		if (isMonitoringCopyTime())
			addCopyTime(System.currentTimeMillis() - start_time);
		return res;
	}

	/**
	 * <p>
	 * Copy an array of BDDs to the manager assigned to this thread.
	 * </p>
	 * 
	 * @param to_adjust
	 *            The array of BDD's to copy.
	 * @return An array with the copied BDD in the manager assigned to this
	 *         thread.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToBase(BDD)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToBase(BDD[])
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToManager(BDD)
	 */
	public BDD[] adjustBDDToManager(BDD[] to_adjust) {
		if (to_adjust == null)
			return null;
		BDD[] res = new BDD[to_adjust.length];
		for (int i = 0; i < to_adjust.length; i++) {
			res[i] = this.adjustBDDToManager(to_adjust[i]);
		}
		return res;
	}

	/**
	 * <p>
	 * Copy the BDD from this manager to the base manager.
	 * </p>
	 * 
	 * @param to_adjust
	 *            The BDD to copy.
	 * @return The copied BDD in the Base manager.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToBase(BDD[])
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToManager(BDD)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToManager(BDD[])
	 */
	public BDD adjustBDDToBase(BDD to_adjust) {
		long start_time = 0;
		if (isMonitoringCopyTime())
			start_time = System.currentTimeMillis();

		BDD res = Env.copyBDDIntoBaseManager(to_adjust);
		if (isMonitoringCopyTime())
			addCopyTime(System.currentTimeMillis() - start_time);
		return res;
	}

	/**
	 * <p>
	 * Copy an array of BDDs from this manager to the base manager.
	 * </p>
	 * 
	 * @param to_adjust
	 *            The array of BDD's to copy.
	 * @return An array with the copied BDD in the Base manager.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToBase(BDD)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToManager(BDD)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToManager(BDD[])
	 */
	public BDD[] adjustBDDToBase(BDD[] to_adjust) {
		if (to_adjust == null)
			return null;
		BDD[] res = new BDD[to_adjust.length];
		for (int i = 0; i < to_adjust.length; i++) {
			res[i] = this.adjustBDDToBase(to_adjust[i]);
		}
		return res;
	}

	/**
	 * <p>
	 * Copy the BDDVarSet to the manager assigned to this thread.
	 * </p>
	 * 
	 * @param to_adjust
	 *            The BDDVarSet to copy.
	 * @return The copied BDDVarSet in the manager assigned to this thread.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToBase(BDDVarSet)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToBase(BDDVarSet[])
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToManager(BDDVarSet[])
	 */
	public BDDVarSet adjustBDDVarSetToManager(BDDVarSet to_adjust) {
		long start_time = 0;
		if (isMonitoringCopyTime())
			start_time = System.currentTimeMillis();

		BDDVarSet res = Env.copyBDDVarSetIntoManager(this
				.getDedicatedBDDManagerIdx(), to_adjust);
		if (isMonitoringCopyTime())
			addCopyTime(System.currentTimeMillis() - start_time);
		return res;
	}

	/**
	 * <p>
	 * Copy an array of BDDVarSets to the manager assigned to this thread.
	 * </p>
	 * 
	 * @param to_adjust
	 *            The array of BDDVarSet's to copy.
	 * @return An array with the copied BDDVarSet in the manager assigned to
	 *         this thread.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToBase(BDDVarSet)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToBase(BDDVarSet[])
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToManager(BDDVarSet)
	 */
	public BDDVarSet[] adjustBDDVarSetToManager(BDDVarSet[] to_adjust) {
		if (to_adjust == null)
			return null;
		BDDVarSet[] res = new BDDVarSet[to_adjust.length];
		for (int i = 0; i < to_adjust.length; i++) {
			res[i] = this.adjustBDDVarSetToManager(to_adjust[i]);
		}
		return res;
	}

	/**
	 * <p>
	 * Copy the BDDVarSet from this manager to the base manager.
	 * </p>
	 * 
	 * @param to_adjust
	 *            The BDDVarSet to copy.
	 * @return The copied BDDVarSet in the Base manager.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToBase(BDDVarSet[])
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToManager(BDDVarSet)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToManager(BDDVarSet[])
	 */
	public BDDVarSet adjustBDDVarSetToBase(BDDVarSet to_adjust) {
		long start_time = 0;
		if (isMonitoringCopyTime())
			start_time = System.currentTimeMillis();

		BDDVarSet res = Env.copyBDDVarSetIntoBaseManager(to_adjust);
		if (isMonitoringCopyTime())
			addCopyTime(System.currentTimeMillis() - start_time);
		return res;
	}

	/**
	 * <p>
	 * Copy an array of BDDVarSets from this manager to the base manager.
	 * </p>
	 * 
	 * @param to_adjust
	 *            The array of BDDVarSet's to copy.
	 * @return An array with the copied BDDVarSet in the Base manager.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToBase(BDDVarSet)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToManager(BDDVarSet)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToManager(BDDVarSet[])
	 */
	public BDDVarSet[] adjustBDDVarSetToBase(BDDVarSet[] to_adjust) {
		if (to_adjust == null)
			return null;
		BDDVarSet[] res = new BDDVarSet[to_adjust.length];
		for (int i = 0; i < to_adjust.length; i++) {
			res[i] = this.adjustBDDVarSetToBase(to_adjust[i]);
		}
		return res;
	}
}
