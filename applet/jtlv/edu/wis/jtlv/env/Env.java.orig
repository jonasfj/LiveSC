package edu.wis.jtlv.env;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDDomain;
import net.sf.javabdd.BDDException;
import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.BDDPairing;
import net.sf.javabdd.BDDVarSet;
import net.sf.javabdd.BDD.BDDToString;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import edu.wis.jtlv.env.core.ASTDebugger;
import edu.wis.jtlv.env.core.fds.FDSLexer;
import edu.wis.jtlv.env.core.fds.FDSParser;
import edu.wis.jtlv.env.core.fds.FDSStmtWalker;
import edu.wis.jtlv.env.core.fds.FDSVarWalker;
import edu.wis.jtlv.env.core.smv.SMVLexer;
import edu.wis.jtlv.env.core.smv.SMVParser;
import edu.wis.jtlv.env.core.smv.SMVStmtWalker;
import edu.wis.jtlv.env.core.smv.Initiator;
import edu.wis.jtlv.env.core.smv.StructuralInit;
import edu.wis.jtlv.env.core.spec.InternalOp;
import edu.wis.jtlv.env.core.spec.InternalSpec;
import edu.wis.jtlv.env.core.spec.InternalSpecBDD;
import edu.wis.jtlv.env.core.spec.InternalSpecCTLRange;
import edu.wis.jtlv.env.core.spec.InternalSpecExp;
import edu.wis.jtlv.env.core.spec.SPCLexer;
import edu.wis.jtlv.env.core.spec.SPCParser;
import edu.wis.jtlv.env.module.FDSModule;
import edu.wis.jtlv.env.module.Module;
import edu.wis.jtlv.env.module.ModuleBDDDefine;
import edu.wis.jtlv.env.module.ModuleBDDField;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.ModuleVariableException;
import edu.wis.jtlv.env.module.SMVModule;
import edu.wis.jtlv.env.spec.Operator;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.env.spec.SpecBDD;
import edu.wis.jtlv.env.spec.SpecCTLRange;
import edu.wis.jtlv.env.spec.SpecException;
import edu.wis.jtlv.env.spec.SpecExp;

/**
 * <p>
 * The main JTLV environment Facade, which supplies the API to basic
 * functionalities through delegators to the private internal managers. The
 * environment is somewhat corresponding to the Java "System" environment.
 * </p>
 * 
 * <p>
 * The two main field which Env is delegating with are: The JTLVBDDManager,
 * which is responsible of communicating with the actual BDD implementation
 * (through JavaBDD package). The JTLVBDDManagerPairing, which is responsible of
 * all BDD naming and coupling operations (i.e. prime and unprimed versions of
 * all fields).
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public final class Env {

	// a static environment, should not be instantiated.
	private Env() {
	}

	/**
	 * <p>
	 * JTLV version count.
	 * </p>
	 */
	public static final String version = "1.4.0";

	/**
	 * <p>
	 * Responsible of communicating with the actual BDD implementation.
	 * </p>
	 * 
	 */
	private static JTLVBDDManager[] bdd_manager;

	/**
	 * <p>
	 * Responsible of all BDD naming and coupling operations (i.e. prime and
	 * unprime versions of all fields).
	 * </p>
	 * 
	 */
	private static JTLVBDDManagerPairing[] bdd_namer;

	/**
	 * <p>
	 * Responsible of all BDD JTLV threads in the system.
	 * </p>
	 * 
	 */
	private static JTLVThread[] threads_pool;

	/**
	 * <p>
	 * An hash map associating String module name to its Module instance.
	 * </p>
	 * 
	 * @see edu.wis.jtlv.env.Env#getAllModules()
	 * @see edu.wis.jtlv.env.Env#getModule(String)
	 * @see edu.wis.jtlv.env.module.Module
	 * @see edu.wis.jtlv.env.module.FDSModule
	 * @see edu.wis.jtlv.env.module.SMVModule
	 */
	private static HashMap<String, Module> all_modules;

	/**
	 * <p>
	 * An object responsible for associating BDD variables to their names.
	 * </p>
	 */
	public static JTLVBDDToString stringer;

	static {
		reset_pool_and_managers();
	}

	private static void reset_pool_and_managers() {
		reset_pool_and_managers(null);
	}

	private static void reset_pool_and_managers(BDDFactory f) {
		// /////////////////////////////////
		// constructing the thread pool
		int pool_size = 0;
		String pool_size_str = System.getProperty("pool_size");

		if ((pool_size_str != null) && (!pool_size_str.equals("null"))) {
			try {
				pool_size = Integer.parseInt(pool_size_str);
				if (pool_size < 1)
					throw new Exception("Pool size is less then 1.");
			} catch (Exception e) {
				System.err.println("Cannot set property 'pool_size' to: '"
						+ pool_size_str + "'.");
				System.err.println("Initializing threads pool to 1.");
				pool_size = 1;
			}
		}
		threads_pool = new JTLVThread[pool_size];

		// /////////////////////////////////
		// constructing the BDD manager
		int node_num, cache_size;
		String str_start_node_num = System.getProperty("bdd_table_size");
		String str_start_cache_size = System.getProperty("bdd_cache_size");
		try {
			node_num = Integer.parseInt(str_start_node_num);
		} catch (NumberFormatException nfe) {
			node_num = 50000;
		}
		try {
			cache_size = Integer.parseInt(str_start_cache_size);
		} catch (NumberFormatException nfe) {
			cache_size = 10000;
		}

		if (bdd_manager == null) { // no previous initiation.
			bdd_manager = new JTLVBDDManager[1 + pool_size];
			for (int i = 0; i < bdd_manager.length; i++) {
				if (f == null)
					bdd_manager[i] = new JTLVBDDManager(node_num, cache_size);
				else
					bdd_manager[i] = new JTLVBDDManager(f);
			}
		} else if (bdd_manager.length <= (1 + pool_size)) {
			// i.e. size has changed.
			JTLVBDDManager[] new_mgr = new JTLVBDDManager[1 + pool_size];
			for (int i = 0; i < new_mgr.length; i++) {
				if (i < bdd_manager.length) {
					new_mgr[i] = bdd_manager[i];
					if (f == null)
						new_mgr[i].reset_factory(node_num, cache_size);
					else
						new_mgr[i].reset_factory(f);
				} else {
					if (f == null)
						new_mgr[i] = new JTLVBDDManager(node_num, cache_size);
					else
						new_mgr[i] = new JTLVBDDManager(f);
				}
			}
			bdd_manager = new_mgr;
		} else { // if "(bdd_manager.length > (1 + pool_size))" size changed.
			JTLVBDDManager[] new_mgr = new JTLVBDDManager[1 + pool_size];
			for (int i = 0; i < bdd_manager.length; i++) {
				if (i < new_mgr.length) {
					new_mgr[i] = bdd_manager[i];
					if (f == null)
						new_mgr[i].reset_factory(node_num, cache_size);
					else
						new_mgr[i].reset_factory(f);
				} else {
					bdd_manager[i].tear_down();
				}
			}
			bdd_manager = new_mgr;
		}

		// /////////////////////////////////
		// constructing the pairs manager
		bdd_namer = new JTLVBDDManagerPairing[1 + pool_size];
		for (int i = 0; i < bdd_namer.length; i++) {
			bdd_namer[i] = new JTLVBDDManagerPairing();
		}

		// /////////////////////////////////
		// re-initiating other vars
		all_modules = new HashMap<String, Module>(10);
		stringer = new JTLVBDDToString();

		// /////////////////////////////////
		// other resets...
		StructuralInit.resetParser();

		if (all_error_listeners == null) {
			all_error_listeners = new LinkedList<ErrorListener>();
			Env.registerErrorListener(new StandardErrorOutput());
			Env.registerErrorListener(new LogErrorOutput());
		} // otherwise, leave the listeners as is.
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// general Functionalities ////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Reset the environment. In particular reset the bdd factory and all
	 * Modules and fields declared in the environment.
	 * </p>
	 * 
	 */
	public static void resetEnv() {
		Env.reset_pool_and_managers();
	}

	/**
	 * <p>
	 * Reset the environment. In particular reset the bdd factory and all
	 * Modules and fields declared in the environment.
	 * </p>
	 * 
	 */
	public static void resetEnv(BDDFactory f) {
		Env.reset_pool_and_managers(f);
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// multi BDD manager Functionalities //////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The number of BDD managers in this environment. The number is set by the
	 * System.property key "pool_size" (plus one additional manager to the main
	 * thread) during the time of the last reset.
	 * </p>
	 * 
	 * @return The number of BDD managers.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread
	 */
	public static int getThreadPoolSize() {
		// already initialized.
		return threads_pool.length;
	}

	/**
	 * <p>
	 * A procedure called from within JTLVThread which allocates and assign a
	 * manager to the given thread. Be aware that instantiating and assigning
	 * more JTLVThread then the number of managers, will lock this thread until
	 * a manager will be freed. (i.e. might lead to a deadlock...)
	 * </p>
	 * 
	 * @param new_thread
	 *            The thread to assign a manager to.
	 * @return The index manager assigned to the given thread.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread
	 * @see edu.wis.jtlv.env.Env#getThreadPoolSize()
	 */
	public static synchronized int assignDedicatedBDDManagerIdx(
			JTLVThread new_thread) {
		for (int loop = 0; true; loop++) {
			for (int i = 0; i < threads_pool.length; i++)
				if ((threads_pool[i] == null)
						|| (threads_pool[i].getState() == Thread.State.TERMINATED)) {
					threads_pool[i] = new_thread;
					return 1 + i; // the corresponding manager, is plus 1.
				}
			if (loop % 30 == 29)
				System.err
						.println("WARNING!! \n"
								+ "Cannot find a place in the threads pool "
								+ "to initiate a new JTLV thread. There might be a "
								+ "dead lock.\n"
								+ "If this error message will continue to appear, please "
								+ "try to extend the thread pool size property 'pool_size'\n"
								+ "If you will still encounter this message, try to look for "
								+ "dead locks in your code.");
			// waiting until someone will clear space in the pool.
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * <p>
	 * Get the current running thread, BDD manager index.
	 * </p>
	 * 
	 * @return The current running thread, BDD manager index.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#getDedicatedBDDManagerIdx()
	 */
	public static int getCurrentThreadManagerIdx() {
		Thread t = Thread.currentThread();
		if (t instanceof JTLVThread)
			return ((JTLVThread) t).getDedicatedBDDManagerIdx();
		// else returning the main thread manager
		return 0;
	}

	/**
	 * <p>
	 * Copy a given BDD into the base BDD manager. The user should take care for
	 * synchronization issues by himself, i.e. beware not to copy to the same
	 * factory at the same time (copy from is safe...).
	 * </p>
	 * 
	 * @param b
	 *            The BDD to copy.
	 * @return The new identical BDD in the base BDD manager.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToBase(BDD)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToManager(BDD)
	 */
	public static BDD copyBDDIntoBaseManager(BDD b) {
		return copyBDDIntoManager(0, b);
	}

	/**
	 * <p>
	 * Copy a given BDD into a given BDD manager. The user should take care for
	 * synchronization issues by himself, i.e. beware not to copy to the same
	 * factory at the same time (copy from is safe...).
	 * </p>
	 * 
	 * @param idx
	 *            The given BDD manager index.
	 * @param b
	 *            The BDD to copy.
	 * @return The new identical BDD in the given BDD manager.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToBase(BDD)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDToManager(BDD)
	 */
	public static BDD copyBDDIntoManager(int idx, BDD b) {
		if (b.getFactory() == bdd_manager[idx].factory)
			return b;
		BDD res = bdd_manager[idx].copyBDDIntoFactory(b);
		return res;
	}

	/**
	 * <p>
	 * Copy a given BDDVarSet into the base BDD manager. The user should take
	 * care for synchronization issues by himself, i.e. beware not to copy to
	 * the same factory at the same time (copy from is safe...).
	 * </p>
	 * 
	 * @param b
	 *            The BDDVarSet to copy.
	 * @return The new identical BDDVarSet in the base BDD manager.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToBase(BDDVarSet)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToManager(BDDVarSet)
	 */
	public static BDDVarSet copyBDDVarSetIntoBaseManager(BDDVarSet b) {
		return copyBDDVarSetIntoManager(0, b);
	}

	/**
	 * <p>
	 * Copy a given BDDVarSet into a given BDD manager. The user should take
	 * care for synchronization issues by himself, i.e. beware not to copy to
	 * the same factory at the same time (copy from is safe...).
	 * </p>
	 * 
	 * @param idx
	 *            The given BDD manager index.
	 * @param b
	 *            The BDDVarSet to copy.
	 * @return The new identical BDDVarSet in the given BDD manager.
	 * 
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToBase(BDDVarSet)
	 * @see edu.wis.jtlv.env.JTLVThread#adjustBDDVarSetToManager(BDDVarSet)
	 */
	public static BDDVarSet copyBDDVarSetIntoManager(int idx, BDDVarSet b) {
		if (b.getFactory() == bdd_manager[idx].factory)
			return b;
		// else copying
		// long start = System.currentTimeMillis();
		BDDVarSet res = bdd_manager[idx].copyBDDVarSetIntoFactory(b);
		// long this_copy = System.currentTimeMillis() - start;
		// BDDVarSetCopyTime += this_copy;
		return res;
	}

	/**
	 * <p>
	 * Do not call the standard copy procedure. Instead it perform the recursive
	 * copy to all factories at once. (not much better then calling copy one by
	 * one)
	 * </p>
	 * 
	 * @param managerIdxs
	 *            all manager indices
	 * @param toCopy
	 *            the BDD to copy
	 * @return An array of identical BDD's. Each BDD is in the BDD manager
	 *         specified by the given array of indices.
	 */
	public static BDD[] multiCopyBDD(int[] managerIdxs, BDD toCopy) {
		// retrieving all factories.
		BDDFactory[] factories = new BDDFactory[managerIdxs.length];
		for (int i = 0; i < factories.length; i++)
			// getting a simple BDD in that manager, and extracting its factory.
			factories[i] = Env.copyBDDIntoManager(managerIdxs[i], Env.TRUE())
					.getFactory();

		return multiCopyBDDHelper(factories, toCopy);
	}

	private static BDD[] multiCopyBDDHelper(BDDFactory[] factories, BDD that) {
		// ///////////////////////////////////
		// the actual copy.
		BDD[] res = new BDD[factories.length];
		if (that.isUniverse()) {
			for (int i = 0; i < res.length; i++)
				res[i] = factories[i].one();
			return res;
		}
		if (that.isZero()) {
			for (int i = 0; i < res.length; i++)
				res[i] = factories[i].zero();
			return res;
		}

		BDD that_l = that.low();
		BDD that_h = that.high();
		if (that_l.equals(that_h)) {
			res = multiCopyBDDHelper(factories, that_l);
		} else {
			BDD[] l = multiCopyBDDHelper(factories, that_l);
			BDD[] h = multiCopyBDDHelper(factories, that_h);
			for (int i = 0; i < res.length; i++)
				res[i] = factories[i].ithVar(that.var()).ite(h[i], l[i]);
		}

		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// module Functionalities /////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Get all module objects currently loaded into the environment.
	 * </p>
	 * 
	 * @return an array of modules.
	 * 
	 * @see edu.wis.jtlv.env.Env#putModule(String, Module)
	 * @see edu.wis.jtlv.env.Env#getModule(String)
	 * @see edu.wis.jtlv.env.module.Module
	 * @see edu.wis.jtlv.env.module.FDSModule
	 * @see edu.wis.jtlv.env.module.SMVModule
	 */
	public static Module[] getAllModules() {
		Vector<Module> res = new Vector<Module>(10);

		Set<String> all = Env.getModuleNames();
		for (String key : all) {
			res.add(Env.getModule(key));
		}

		Module[] res_arr = new Module[res.size()];
		res.toArray(res_arr);
		return res_arr;
	}

	/**
	 * <p>
	 * Get a module instance by its associated full path string.
	 * </p>
	 * 
	 * @param full_inst_name
	 *            the full path string to the instance.
	 * @return the module object or null if not existing.
	 * 
	 * @see edu.wis.jtlv.env.Env#putModule(String, Module)
	 * @see edu.wis.jtlv.env.Env#getAllModules()
	 * @see edu.wis.jtlv.env.module.Module
	 * @see edu.wis.jtlv.env.module.FDSModule
	 * @see edu.wis.jtlv.env.module.SMVModule
	 */
	public static Module getModule(String full_inst_name) {
		return Env.all_modules.get(full_inst_name);
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// TODO: remove the String full_inst_name from the signature, /////////////
	// and use the full name in the module instance itself. ///////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Add a new module to the collection of all modules, and associate it with
	 * the given string.
	 * </p>
	 * 
	 * @param full_inst_name
	 *            the string to associate this module with.
	 * @param to_add
	 *            the module to add.
	 * 
	 * @see edu.wis.jtlv.env.Env#getAllModules()
	 * @see edu.wis.jtlv.env.Env#getModule(String)
	 * @see edu.wis.jtlv.env.module.Module
	 * @see edu.wis.jtlv.env.module.FDSModule
	 * @see edu.wis.jtlv.env.module.SMVModule
	 */
	public static void putModule(String full_inst_name, Module to_add) {
		Env.all_modules.put(full_inst_name, to_add);
	}

	/**
	 * <p>
	 * Get the number of modules currently loaded into the environment.
	 * </p>
	 * 
	 * @return The number of modules currently loaded into the environment.
	 */
	public static int getModuleNum() {
		return Env.all_modules.size();
	}

	/**
	 * <p>
	 * The set of all names which are associated with the modules loaded to the
	 * environment.
	 * </p>
	 * 
	 * @return The set of all names.
	 * 
	 * @see edu.wis.jtlv.env.Env#getAllModules()
	 * @see edu.wis.jtlv.env.Env#getModule(String)
	 */
	public static Set<String> getModuleNames() {
		return Env.all_modules.keySet();
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Loading Functionalities ////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Load any kind of specification from a given input stream.
	 * </p>
	 * 
	 * @param is
	 *            The input stream to parse.
	 * @return An array of Specifications.
	 * 
	 * @see edu.wis.jtlv.env.Env#loadSpecString(String)
	 * @see edu.wis.jtlv.env.Env#loadSpecFile(String)
	 */
	public static Spec[] loadSpecInputStream(InputStream is) throws IOException {
		try {
			CharStream input = new ANTLRInputStream(is);
			return convertSpecToAPI(loadSpec(input, false));
		} catch (RecognitionException re) {
			Env.doError(re, re.getMessage());
		} catch (IOException ioe) {
			throw ioe;
		} catch (Exception e) {
			// do nothing
		}
		return null;
	}

	/**
	 * <p>
	 * Load any kind of specification from a string.
	 * </p>
	 * 
	 * @param to_parse
	 *            The string to parse.
	 * @return An array of Specifications.
	 * 
	 * @see edu.wis.jtlv.env.Env#loadSpecInputStream(InputStream)
	 * @see edu.wis.jtlv.env.Env#loadSpecFile(String)
	 */
	public static Spec[] loadSpecString(String to_parse) {
		try {
			CharStream input = new ANTLRStringStream(to_parse);
			return convertSpecToAPI(loadSpec(input, false));
		} catch (RecognitionException re) {
			Env.doError(re, re.getMessage());
		} catch (Exception e) {
			Env.doError(e, e.getMessage());
			// do nothing
		}
		return null;
	}

	/**
	 * <p>
	 * Load any kind of specification from a file.
	 * </p>
	 * 
	 * @param filename
	 *            The file to load from.
	 * @return An array of Specifications.
	 * @throws IOException
	 *             When there where problems reading the file.
	 * 
	 * @see edu.wis.jtlv.env.Env#loadSpecInputStream(InputStream)
	 * @see edu.wis.jtlv.env.Env#loadSpecString(String)
	 */
	public static Spec[] loadSpecFile(String filename) throws IOException {
		try {
			CharStream input = new ANTLRFileStream(filename);
			return convertSpecToAPI(loadSpec(input, false));
		} catch (RecognitionException re) {
			Env.doError(re, re.getMessage());
		} catch (IOException ioe) {
			throw ioe;
		} catch (Exception e) {
			// do nothing
		}
		return null;
	}

	private static Spec[] convertSpecToAPI(InternalSpec[] orig) {
		Spec[] res = new Spec[orig.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = convertSpecToAPIHelper(orig[i]);
		}
		return res;
	}

	private static Spec convertSpecToAPIHelper(InternalSpec orig) {
		if (orig == null)
			return null;
		if (orig instanceof InternalSpecBDD) {
			InternalSpecBDD cast_orig = (InternalSpecBDD) orig;
			return new SpecBDD(cast_orig.getExprStr(), cast_orig.getVal());
		}
		if (orig instanceof InternalSpecCTLRange) {
			InternalSpecCTLRange cast_orig = (InternalSpecCTLRange) orig;
			return new SpecCTLRange(cast_orig.getFrom(), cast_orig.getTo());
		}
		// if (orig instanceof InternalSpecExp)
		InternalSpecExp cast_orig = (InternalSpecExp) orig;
		Operator op = convertOperatorToAPI(cast_orig.getOperator());
		Spec[] children = convertSpecToAPI(cast_orig.getChildren());
		Spec res = null;
		try {
			res = new SpecExp(op, children);
		} catch (SpecException e) {
			// will never happen...
			e.printStackTrace();
		}
		return res;
	}

	private static Operator convertOperatorToAPI(InternalOp orig) {
		return Operator.operatorFromString(orig.toString());
	}

	private static InternalSpec[] loadSpec(CharStream input,
			boolean show_parse_tree) throws RecognitionException {
		// //////////////////////////////////////////
		// 1. // lexer and parsing //////////////////
		// //////////////////////////////////////////
		SPCLexer lex = new SPCLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		SPCParser parser = new SPCParser(tokens);
		SPCParser.spec_return r = parser.spec();
		// //////////////////////////////////////////
		// debugging... /////////////////////////////
		// //////////////////////////////////////////
		if (show_parse_tree) {
			ASTDebugger deb = new ASTDebugger("just a name", (CommonTree) r
					.getTree());
			deb.setSize(800, 600);
			deb.setVisible(true);
		}
		return r.ret.getArray();
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// TODO: see if I can prevent loading of modules with the same name. //////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Load a given file into the system with a specified order given by the
	 * other file. The order file must contain all unprimed variable in the
	 * system. Currently two file extensions are supported, *.fds an *.smv. The
	 * procedure will load according to the file extension. The modules loaded
	 * are returned. Alternatively, The modules can also be found through the
	 * modules facilities here: {@link edu.wis.jtlv.env.Env#getAllModules()} or
	 * {@link edu.wis.jtlv.env.Env#getModule(String)}.
	 * </p>
	 * 
	 * <p>
	 * All paring and interpreting exceptions are thrown to listeners through
	 * the Env error mechanism. (i.e.
	 * {@link edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)}
	 * {@link edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)}
	 * {@link edu.wis.jtlv.env.Env#doError(Exception, String)})
	 * </p>
	 * 
	 * @param filename
	 *            The file to load with file extension *.fds, or *.smv .
	 * @param ordfile
	 *            The file with the order of variables. all variable (in their
	 *            unprime version) must be supplied.
	 * @return Array of module which were loaded from the given file.
	 * @throws IOException
	 *             If there was a problem with reading the file.
	 * 
	 * @see edu.wis.jtlv.env.Env#loadModule(String)
	 * @see edu.wis.jtlv.env.Env#parseModule(String)
	 * @see edu.wis.jtlv.env.Env#debugParseModule(String)
	 * @see edu.wis.jtlv.env.Env#getAllModules()
	 * @see edu.wis.jtlv.env.Env#getModule(String)
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 */
	public static Module[] loadModule(String filename, String ordfile)
			throws IOException {
		String text = "";
		FileReader fr = new FileReader(new File(ordfile));
		BufferedReader in = new BufferedReader(fr);
		String next_read = in.readLine();
		while (next_read != null) {
			text += "\n" + next_read;
			next_read = in.readLine();
		}

		Stack<String> vars = new Stack<String>();
		StringTokenizer st = new StringTokenizer(text);
		while (st.hasMoreElements()) {
			vars.add(st.nextToken());
		}

		String[] vars_arr = new String[vars.size()];
		vars.toArray(vars_arr);
		return loadModule(filename, vars_arr);
	}

	/**
	 * <p>
	 * Load a given file into the system without a specified order (i.e. the
	 * order will be the order of declaration of variables in the file).
	 * Currently two file extensions are supported, *.fds an *.smv. The
	 * procedure will load according to the file extension. The modules loaded
	 * are returned. Alternatively, The modules can also be found through the
	 * modules facilities here: {@link edu.wis.jtlv.env.Env#getAllModules()} or
	 * {@link edu.wis.jtlv.env.Env#getModule(String)}.
	 * </p>
	 * 
	 * <p>
	 * All paring and interpreting exceptions are thrown to listeners through
	 * the Env error mechanism. (i.e.
	 * {@link edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)}
	 * {@link edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)}
	 * {@link edu.wis.jtlv.env.Env#doError(Exception, String)})
	 * </p>
	 * 
	 * @param filename
	 *            The file to load with file extension *.fds, or *.smv .
	 * @return Array of module which were loaded from the given file.
	 * @throws IOException
	 *             If there was a problem with reading the file.
	 * 
	 * @see edu.wis.jtlv.env.Env#loadModule(String, String)
	 * @see edu.wis.jtlv.env.Env#parseModule(String)
	 * @see edu.wis.jtlv.env.Env#debugParseModule(String)
	 * @see edu.wis.jtlv.env.Env#getAllModules()
	 * @see edu.wis.jtlv.env.Env#getModule(String)
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 */
	public static Module[] loadModule(String filename) throws IOException {
		return loadModule(filename, (String[]) null);
	}

	private static Module[] loadModule(String filename, String[] order)
			throws IOException {
		try {
			if (filename.toLowerCase().endsWith("fds")) {
				return loadFDSModule(new ANTLRFileStream(filename), false,
						false, order);
			} else if (filename.toLowerCase().endsWith("smv")) {
				return loadSMVModule(new ANTLRFileStream(filename), false,
						false, order);
			}
		} catch (RecognitionException e) {
			Env.doError(e, e.getMessage());
		} catch (ModuleException e) {
			Env.doError(e, e.getMessage());
		}
		throw new IOException("Cannot load module with formats other then"
				+ " .fds or .smv");
	}

	/**
	 * <p>
	 * Parse the given file and add it to the system. Currently two file
	 * extensions are supported, *.fds an *.smv. The procedure will parse
	 * according to the file extension. The modules parsed are returned. (BUT
	 * NOT FILLED WITH THEIR VARIABLES AND STATEMENT, SINCE THIS IS DONE IN THE
	 * INTERPRETATION STAGE.) Alternatively, The modules can also be found
	 * through the modules facilities here:
	 * {@link edu.wis.jtlv.env.Env#getAllModules()} or
	 * {@link edu.wis.jtlv.env.Env#getModule(String)}.
	 * </p>
	 * 
	 * <p>
	 * All paring and interpreting exceptions are thrown to listeners through
	 * the Env error mechanism. (i.e.
	 * {@link edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)}
	 * {@link edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)}
	 * {@link edu.wis.jtlv.env.Env#doError(Exception, String)})
	 * </p>
	 * 
	 * @param filename
	 *            The file to load with file extension *.fds, or *.smv .
	 * @return Array of module which were loaded from the given file.
	 * @throws IOException
	 *             If there was a problem with reading the file.
	 * 
	 * @see edu.wis.jtlv.env.Env#loadModule(String)
	 * @see edu.wis.jtlv.env.Env#loadModule(String, String)
	 * @see edu.wis.jtlv.env.Env#debugParseModule(String)
	 * @see edu.wis.jtlv.env.Env#getAllModules()
	 * @see edu.wis.jtlv.env.Env#getModule(String)
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 */
	public static Module[] parseModule(String filename) throws IOException {
		try {
			if (filename.toLowerCase().endsWith("fds")) {
				return loadFDSModule(new ANTLRFileStream(filename), true,
						false, null);
			} else if (filename.toLowerCase().endsWith("smv")) {
				return loadSMVModule(new ANTLRFileStream(filename), true,
						false, null);
			}
		} catch (RecognitionException e) {
			Env.doError(e, e.getMessage());
		} catch (ModuleException e) {
			Env.doError(e, e.getMessage());
		}
		throw new IOException("Cannot load module with formats other then"
				+ " .fds or .smv");
	}

	/**
	 * <p>
	 * Parse the given file, add it to the system, and pops a window browser
	 * with the parsing tree which the parser read. Currently two file
	 * extensions are supported, *.fds an *.smv. The procedure will parse
	 * according to the file extension. The modules parsed are returned. (BUT
	 * NOT FILLED WITH THEIR VARIABLES AND STATEMENT, SINCE THIS IS DONE IN THE
	 * INTERPRETATION STAGE.) Alternatively, The modules can also be found
	 * through the modules facilities here:
	 * {@link edu.wis.jtlv.env.Env#getAllModules()} or
	 * {@link edu.wis.jtlv.env.Env#getModule(String)}.
	 * </p>
	 * <p>
	 * All paring and interpreting exceptions are thrown to listeners through
	 * the Env error mechanism. (i.e.
	 * {@link edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)}
	 * {@link edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)}
	 * {@link edu.wis.jtlv.env.Env#doError(Exception, String)})
	 * </p>
	 * 
	 * @param filename
	 *            The file to load with file extension *.fds, or *.smv .
	 * @return Array of module which were loaded from the given file.
	 * @throws IOException
	 *             If there was a problem with reading the file.
	 * 
	 * @see edu.wis.jtlv.env.Env#loadModule(String)
	 * @see edu.wis.jtlv.env.Env#loadModule(String, String)
	 * @see edu.wis.jtlv.env.Env#parseModule(String)
	 * @see edu.wis.jtlv.env.Env#getAllModules()
	 * @see edu.wis.jtlv.env.Env#getModule(String)
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 */
	public static Module[] debugParseModule(String filename) throws IOException {
		try {
			if (filename.toLowerCase().endsWith("fds")) {
				return loadFDSModule(new ANTLRFileStream(filename), true, true,
						null);
			} else if (filename.toLowerCase().endsWith("smv")) {
				return loadSMVModule(new ANTLRFileStream(filename), true, true,
						null);
			}
		} catch (RecognitionException e) {
			Env.doError(e, e.getMessage());
		} catch (ModuleException e) {
			Env.doError(e, e.getMessage());
		}
		throw new IOException("Cannot load module with formats other then"
				+ " .fds or .smv");
	}

	private static SMVModule[] loadSMVModule(CharStream input,
			boolean do_parse_only, boolean show_parse_tree, String[] order)
			throws IOException, RecognitionException, ModuleException {
		String[] all_names_before = new String[Env.getModuleNum()];
		int count = 0;
		for (Iterator<String> name_iter = Env.getModuleNames().iterator(); name_iter
				.hasNext();) {
			all_names_before[count] = name_iter.next();
			count++;
		}

		// //////////////////////////////////////////
		// 1. // lexer and parsing //////////////////
		// //////////////////////////////////////////
		// CharStream input = new ANTLRFileStream(filename);
		SMVLexer lex = new SMVLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		SMVParser parser = new SMVParser(tokens);
		SMVParser.program_return r = parser.program();
		// //////////////////////////////////////////
		// debugging... /////////////////////////////
		// //////////////////////////////////////////
		if (show_parse_tree) {
			ASTDebugger deb = new ASTDebugger("just a name", (CommonTree) r
					.getTree());
			deb.setSize(800, 600);
			deb.setVisible(true);
		}

		if (do_parse_only)
			return getNewModules(all_names_before);

		// //////////////////////////////////////////
		// 2. // variable declarations //////////////
		// //////////////////////////////////////////
		Initiator intr = Initiator.get_instance();
		intr.startVarDeclPhase();
		tokens.rewind();
		CommonTreeNodeStream expr_nodes = new CommonTreeNodeStream((Tree) r
				.getTree());
		expr_nodes.setTokenStream(tokens);
		SMVStmtWalker walker2 = new SMVStmtWalker(expr_nodes);

		// SMVVarWalker walker2 = new SMVVarWalker(expr_nodes);
		walker2.program();
		
		intr.do_creation();
		intr.endVarDeclPhase();
		// ////////
		// if exists order, then now is the time to reorder
		if (order != null) {
			makeOrder(order);
		}

		// //////////////////////////////////////////
		// 3. // attaching defines //////////////////
		// //////////////////////////////////////////
		intr.startDefinePhase();
		// int def_inited = -1;
		while (intr.countAllInitiatedDefines() < intr.countAllDefines()) {
			tokens.rewind();
			expr_nodes = new CommonTreeNodeStream((Tree) r.getTree());
			expr_nodes.setTokenStream(tokens);
			SMVStmtWalker walker3 = new SMVStmtWalker(expr_nodes);
			int def_inited = intr.countAllInitiatedDefines();
			walker3.program();
			// this loop did not contribute, so we can assume a problem.
			if (def_inited == intr.countAllInitiatedDefines()) {
				// for the case where empty for loop just removed a refine
				if (intr.countAllInitiatedDefines() == intr.countAllDefines())
					break;

				// not all defines where initiated.... !!
				throwRecursiveDefineException(intr);
			}
		}
		intr.endDefinePhase();

		// //////////////////////////////////////////
		// 4. // attaching statements ///////////////
		// //////////////////////////////////////////
		intr.startInitTransPhase();
		tokens.rewind();
		expr_nodes = new CommonTreeNodeStream((Tree) r.getTree());
		expr_nodes.setTokenStream(tokens);
		SMVStmtWalker walker4 = new SMVStmtWalker(expr_nodes);
		walker4.program();
		intr.endInitTransPhase();

		// //////////////////////////////////////////
		// //////////////////////////////////////////
		// //////////////////////////////////////////
		// // other constructions.
		// expr_nodes = new CommonTreeNodeStream((Tree) r.getTree());
		// expr_nodes.setTokenStream(tokens);
		// SMVXXXWalker walker3 = new SMVXXXWalker(expr_nodes);
		// walker3.program();
		// //////////////////////////////////////////
		// //////////////////////////////////////////
		// //////////////////////////////////////////
		return getNewModules(all_names_before);
	}

	private static SMVModule[] getNewModules(String[] all_names_before) {
		// placing the result.
		Set<String> all_names_after = Env.getModuleNames();
		SMVModule[] res = new SMVModule[all_names_after.size()
				- all_names_before.length];
		int count = 0;
		for (Iterator<String> iterator = all_names_after.iterator(); iterator
				.hasNext();) {
			String name = iterator.next();
			boolean to_add = true;
			for (int i = 0; i < all_names_before.length; i++)
				if (name.equals(all_names_before[i]))
					to_add = false;
			if (to_add) {
				res[count] = (SMVModule) Env.getModule(name);
				count++;
			}
		}
		return res;
	}

	private static void throwRecursiveDefineException(Initiator intr)
			throws ModuleException {
		ModuleBDDDefine[] defs = intr.getAllUninitiatedDefines();
		String def_str = "";
		for (int i = 0; i < defs.length; i++) {
			def_str += defs[i].toString();
			def_str += ((i + 1) != defs.length) ? ", " : "";
		}
		throw new ModuleException("Recursive define statements "
				+ "between one of the following defines:\n\t" + def_str);
	}

	private static FDSModule[] loadFDSModule(CharStream input,
			boolean do_parse_only, boolean show_parse_tree, String[] order)
			throws IOException, RecognitionException {
		FDSModule[] res = null;
		String[] all_names_before = new String[Env.getModuleNum()];
		int count = 0;
		for (Iterator<String> name_iter = Env.getModuleNames().iterator(); name_iter
				.hasNext();) {
			all_names_before[count] = name_iter.next();
			count++;
		}

		// constructing the tree.
		// CharStream input = new ANTLRFileStream(filename);
		FDSLexer lex = new FDSLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		FDSParser parser = new FDSParser(tokens);
		FDSParser.program_return r = parser.program();

		// debugging...
		if (show_parse_tree) {
			ASTDebugger deb = new ASTDebugger("stam name", (CommonTree) r
					.getTree());
			deb.setSize(800, 600);
			deb.setVisible(true);
		}

		// declaring the variables.
		CommonTreeNodeStream var_decl_nodes = new CommonTreeNodeStream((Tree) r
				.getTree());
		var_decl_nodes.setTokenStream(tokens);
		FDSVarWalker var_decl_walker = new FDSVarWalker(var_decl_nodes);
		var_decl_walker.program();

		if (order != null) {
			makeOrder(order);
		}

		// other constructions.
		if (!do_parse_only) {
			tokens.rewind();
			CommonTreeNodeStream expr_nodes = new CommonTreeNodeStream((Tree) r
					.getTree());
			expr_nodes.setTokenStream(tokens);
			FDSStmtWalker expr_walker = new FDSStmtWalker(expr_nodes);
			expr_walker.program();
		}

		// placing the result.
		Set<String> all_names_after = Env.getModuleNames();
		res = new FDSModule[all_names_after.size() - all_names_before.length];
		count = 0;
		for (Iterator<String> iterator = all_names_after.iterator(); iterator
				.hasNext();) {
			String name = iterator.next();
			boolean to_add = true;
			for (int i = 0; i < all_names_before.length; i++)
				if (name.equals(all_names_before[i]))
					to_add = false;
			if (to_add) {
				res[count] = (FDSModule) Env.getModule(name);
				count++;
			}
		}

		return res;
	}

	private static void makeOrder(String[] order) {
		BDDFactory factory = Env.TRUE().getFactory();
		if ((2 * order.length) != factory.numberOfDomains()) {
			Env.doError(new Exception("The order given is not complete."),
					"The order given is not complete.");
		} else {
			// reordering all factories
			int[] idx_order = makeOrderArr(order);
			for (int i = 0; i < bdd_manager.length; i++) {
				bdd_manager[i].factory.setVarOrder(idx_order);
			}
		}
	}

	private static int[] makeOrderArr(String[] vars) {
		int[] order = new int[2 * vars.length];
		for (int i = 0; i < order.length; i++) {
			int idx = vars[i / 2].lastIndexOf('.');
			ModuleBDDField f;
			if (idx == -1)
				f = getVar("", vars[i / 2]);
			else
				f = getVar(vars[i / 2].substring(0, idx), vars[i / 2]
						.substring(idx + 1));
			if (i % 2 == 0)
				order[i] = f.getDomain().getIndex();
			else
				order[i] = f.getOtherDomain().getIndex();
		}
		return order;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// BDD Functionalities ////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The factory package which is currently used by the environment to
	 * allocate new BDD fields.
	 * </p>
	 * 
	 * @return The BDD factory name.
	 * 
	 */
	public static String getFactoryName() {
		return bdd_manager[0].factoryName();
	}

	/**
	 * <p>
	 * Register a procedure to be done at every garbage collection.
	 * </p>
	 * 
	 * @param m_gc
	 *            The method to perform.
	 * 
	 * @see edu.wis.jtlv.env.Env#beQuiet()
	 * @see edu.wis.jtlv.env.Env#doOnResize(Method)
	 * @see edu.wis.jtlv.env.Env#doOnReorder(Method)
	 */
	public static void doOnGC(Method m_gc) {
		for (JTLVBDDManager man : bdd_manager) {
			man.doOnGC(m_gc);
		}
	}

	/**
	 * <p>
	 * Register a procedure to be done at every resize to the BDD table.
	 * </p>
	 * 
	 * @param m_resize
	 *            The method to perform.
	 * 
	 * @see edu.wis.jtlv.env.Env#beQuiet()
	 * @see edu.wis.jtlv.env.Env#doOnGC(Method)
	 * @see edu.wis.jtlv.env.Env#doOnReorder(Method)
	 */
	public static void doOnResize(Method m_resize) {
		for (JTLVBDDManager man : bdd_manager) {
			man.doOnResize(m_resize);
		}
	}

	/**
	 * <p>
	 * Register a procedure to be done at every reorder to the BDD table.
	 * </p>
	 * 
	 * @param m_reorder
	 *            The method to perform.
	 * 
	 * @see edu.wis.jtlv.env.Env#beQuiet()
	 * @see edu.wis.jtlv.env.Env#doOnGC(Method)
	 * @see edu.wis.jtlv.env.Env#doOnResize(Method)
	 */
	public static void doOnReorder(Method m_reorder) {
		for (JTLVBDDManager man : bdd_manager) {
			man.doOnReorder(m_reorder);
		}
	}

	/**
	 * <p>
	 * Turning off the entire factory verbose (garbage collection, resize,
	 * reorder).
	 * </p>
	 * 
	 * @see edu.wis.jtlv.env.Env#doOnGC(Method)
	 * @see edu.wis.jtlv.env.Env#doOnResize(Method)
	 * @see edu.wis.jtlv.env.Env#doOnReorder(Method)
	 */
	public static void beQuiet() {
		try {
			Method m = Env.class.getMethod("NOP", (Class[]) null);
			doOnGC(m);
			doOnResize(m);
			doOnReorder(m);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * An empty procedure for shutting down the factory verbose.
	 * </p>
	 * 
	 * @see edu.wis.jtlv.env.Env#beQuiet()
	 */
	public static void NOP() {
	}

	/**
	 * <p>
	 * The constant FALSE BDD.
	 * </p>
	 * 
	 * @return The constant FALSE BDD.
	 * 
	 * @see edu.wis.jtlv.env.Env#TRUE()
	 */
	public static BDD FALSE() {
		return bdd_manager[Env.getCurrentThreadManagerIdx()].FALSE();
	}

	/**
	 * <p>
	 * The constant TRUE BDD.
	 * </p>
	 * 
	 * @return The constant TRUE BDD.
	 * 
	 * @see edu.wis.jtlv.env.Env#FALSE()
	 */
	public static BDD TRUE() {
		return bdd_manager[Env.getCurrentThreadManagerIdx()].TRUE();
	}

	/**
	 * <p>
	 * Save a BDD to the file system.
	 * </p>
	 * 
	 * @param filename
	 *            The file to save the BDD to.
	 * @param to_save
	 *            The BDD to save.
	 * @throws IOException
	 *             If the was a problem with creating the file.
	 * 
	 * @see edu.wis.jtlv.env.Env#loadBDD(String)
	 */
	public static void saveBDD(String filename, BDD to_save) throws IOException {
		bdd_manager[0].save(filename, copyBDDIntoBaseManager(to_save));
	}

	/**
	 * <p>
	 * Load a BDD from the file system.
	 * </p>
	 * 
	 * <p>
	 * <b> Make sure that the system is configured with the same BDD package
	 * which saved the BDD to the file!! </b>
	 * </p>
	 * 
	 * @param filename
	 *            The file to load the BDD from.
	 * @return The BDD which was loaded.
	 * @throws IOException
	 *             If the was a problem with reading the file.
	 * 
	 * @see edu.wis.jtlv.env.Env#saveBDD(String, BDD)
	 */
	public static BDD loadBDD(String filename) throws IOException {
		return bdd_manager[0].load(filename);
	}

	/**
	 * <p>
	 * Search and retrieve the BDD field by the given path and field name.
	 * </p>
	 * 
	 * @param preface
	 *            The path to the field.
	 * @param name
	 *            The field name.
	 * @return The BDD field, null if not found.
	 * 
	 * @see edu.wis.jtlv.env.Env#newVar(String, String, int)
	 * @see edu.wis.jtlv.env.Env#newVar(String, String)
	 * @see edu.wis.jtlv.env.Env#allocBDD(int, int)
	 */
	public static ModuleBDDField getVar(String preface, String name) {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].get_var(preface,
				name);
	}

	/**
	 * <p>
	 * Create and allocate a new BDD <b>field</b> with the given domain size,
	 * i.e. the number of values that this BDD contains. (the actual number
	 * values rounded to the power of 2)
	 * </p>
	 * 
	 * <p>
	 * With this field instantiation The BDD is created with an associated
	 * facilities in the environment.<br>
	 * For creating a BDD without the environment field facilities, please refer
	 * to {@link edu.wis.jtlv.env.Env#allocBDD(int, int)}.
	 * </p>
	 * 
	 * @param preface
	 *            The path to the field.
	 * @param name
	 *            The field name.
	 * @param values_size
	 *            The size of the domain.
	 * @return The newly created BDD field.
	 * @throws ModuleVariableException
	 *             If the given name for the new field to create is illegal (for
	 *             instance duplication).
	 * 
	 * @see edu.wis.jtlv.env.Env#getVar(String, String)
	 * @see edu.wis.jtlv.env.Env#newVar(String, String)
	 * @see edu.wis.jtlv.env.Env#allocBDD(int, int)
	 */
	public static ModuleBDDField newVar(String preface, String name,
			int values_size) throws ModuleVariableException {
		ModuleBDDField res = bdd_namer[0]
				.new_var(0, preface, name, values_size);
		for (int i = 1; i < bdd_namer.length; i++) {
			bdd_namer[i].new_var(i, preface, name, values_size);
		}
		return res;
	}

	/**
	 * <p>
	 * Create and allocate a new BDD <b>field</b> with 2 values domain.
	 * </p>
	 * 
	 * <p>
	 * With this field instantiation The BDD is created with an associated
	 * facilities in the environment.<br>
	 * For creating a BDD without the environment field facilities, please refer
	 * to {@link edu.wis.jtlv.env.Env#allocBDD(int,int)}.
	 * </p>
	 * 
	 * @param preface
	 *            The path to the field.
	 * @param name
	 *            The field name.
	 * @return The newly created BDD couple variable.
	 * @throws ModuleVariableException
	 *             If the given name for the new field to create is illegal (for
	 *             instance duplication).
	 * 
	 * @see edu.wis.jtlv.env.Env#getVar(String, String)
	 * @see edu.wis.jtlv.env.Env#newVar(String, String, int)
	 * @see edu.wis.jtlv.env.Env#allocBDD(int, int)
	 */
	public static ModuleBDDField newVar(String preface, String name)
			throws ModuleVariableException {
		return newVar(preface, name, 2);
	}

	/**
	 * <p>
	 * Allocate a new BDD with the given domain size, i.e. the number of values
	 * that this BDD contains. (the actual number values rounded to the power of
	 * 2)
	 * </p>
	 * 
	 * <p>
	 * This procedure does not create the entire BDD field facilities. For
	 * creating a BDD field, please refer to
	 * {@link edu.wis.jtlv.env.Env#newVar(String, String)} or
	 * {@link edu.wis.jtlv.env.Env#newVar(String, String, int)}
	 * </p>
	 * 
	 * @param thread_idx
	 *            The factory to create this BDD for.
	 * @param values_size
	 *            The size of the domain.
	 * @return A new domain to be used.
	 * 
	 * @see edu.wis.jtlv.env.Env#getVar(String, String)
	 * @see edu.wis.jtlv.env.Env#newVar(String, String)
	 * @see edu.wis.jtlv.env.Env#newVar(String, String, int)
	 */
	private static BDDDomain allocBDD(int thread_idx, int values_size) {
		return bdd_manager[thread_idx].allocBDD(values_size);
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// String Functionalities /////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * Prepare a string representing the If-Then-Else form of the given BDD.
	 * This kind of printing is better by an order of magnitude with respect to
	 * simple BDD.toString, which is exponential to the size of the BDD.<br>
	 * The naming is done respective to the given module, i.e. the path leading
	 * to the variable from the given module.<br>
	 * The print is done with line indentation.
	 * </p>
	 * 
	 * <p>
	 * <b> It is advise to use this procedure for printing big BDDs!! </b>
	 * </p>
	 * 
	 * @param con
	 *            The module context of the BDD.
	 * @param b
	 *            The BDD to prepare string to.
	 * @return The string representing the BDD.
	 * 
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(BDD)
	 */
	public static String toNiceString(Module con, BDD b) {
		// printing is always done at the main factory
		BDD newB = copyBDDIntoBaseManager(b);
		return bdd_manager[0].toNiceString(con, newB);
	}

	/**
	 * <p>
	 * Prepare a string representing the If-Then-Else form of the given BDD.
	 * This kind of printing is better by an order of magnitude with respect to
	 * simple BDD.toString, which is exponential to the size of the BDD.<br>
	 * The naming is done respective to "main" module, i.e. the path leading to
	 * the variable from the given module.<br>
	 * The print is done with line indentation.
	 * </p>
	 * 
	 * <p>
	 * <b> It is advise to use this procedure for printing big BDDs!! </b>
	 * </p>
	 * 
	 * @param b
	 *            The BDD to prepare string to.
	 * @return The string representing the BDD.
	 * 
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(BDD)
	 */
	public static String toNiceString(BDD b) {
		// printing is always done at the main factory
		BDD newB = copyBDDIntoBaseManager(b);
		return bdd_manager[0].toNiceString(Env.getModule("main"), newB);
	}

	/**
	 * <p>
	 * Prepare a string representing the If-Then-Else form of the given BDD.
	 * This kind of printing is better by an order of magnitude with respect to
	 * simple BDD.toString, which is exponential to the size of the BDD.<br>
	 * The naming is done respective to the given module, i.e. the path leading
	 * to the variable from the given module.<br>
	 * The print is done with line indentation starting with the given initial
	 * indentation.
	 * </p>
	 * 
	 * <p>
	 * <b> It is advise to use this procedure for printing big BDDs!! </b>
	 * </p>
	 * 
	 * @param con
	 *            The module context of the BDD.
	 * @param b
	 *            The BDD to prepare string to.
	 * @param startIndent
	 *            The initial indentation.
	 * @return The string representing the BDD.
	 * 
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(BDD)
	 */
	public static String toNiceString(Module con, BDD b, String startIndent) {
		// printing is always done at the main factory
		BDD newB = copyBDDIntoBaseManager(b);
		return bdd_manager[0].toNiceString(con, newB, startIndent);
	}

	/**
	 * <p>
	 * Prepare a string representing the If-Then-Else form of the given BDD.
	 * This kind of printing is better by an order of magnitude with respect to
	 * simple BDD.toString, which is exponential to the size of the BDD.<br>
	 * The naming is done respective to "main" module, i.e. the path leading to
	 * the variable from the given module.<br>
	 * The print is done with line indentation starting with the given initial
	 * indentation.
	 * </p>
	 * 
	 * <p>
	 * <b> It is advise to use this procedure for printing big BDDs!! </b>
	 * </p>
	 * 
	 * @param b
	 *            The BDD to prepare string to.
	 * @param startIndent
	 *            The initial indentation.
	 * @return The string representing the BDD.
	 * 
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(BDD)
	 */
	public static String toNiceString(BDD b, String startIndent) {
		// printing is always done at the main factory
		BDD newB = copyBDDIntoBaseManager(b);
		return bdd_manager[0].toNiceString(Env.getModule("main"), newB,
				startIndent);
	}

	/**
	 * <p>
	 * Prepare a string representing the If-Then-Else form of the given BDD.
	 * This kind of printing is better by an order of magnitude with respect to
	 * simple BDD.toString, which is exponential to the size of the BDD.<br>
	 * The naming is done respective to the given module, i.e. the path leading
	 * to the variable from the given module.<br>
	 * The print is done in a single line.
	 * </p>
	 * 
	 * <p>
	 * <b> It is advise to use this procedure for printing big BDDs!! </b>
	 * </p>
	 * 
	 * @param con
	 *            The module context of the BDD.
	 * @param b
	 *            The BDD to prepare string to.
	 * @return The string representing the BDD.
	 * 
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(BDD)
	 */
	public static String toNiceSignleLineString(Module con, BDD b) {
		// printing is always done at the main factory
		BDD newB = copyBDDIntoBaseManager(b);
		return bdd_manager[0].toNiceSignleLineString(con, newB);
	}

	/**
	 * <p>
	 * Prepare a string representing the If-Then-Else form of the given BDD.
	 * This kind of printing is better by an order of magnitude with respect to
	 * simple BDD.toString, which is exponential to the size of the BDD.<br>
	 * The naming is done respective to the "main" module, i.e. the path leading
	 * to the variable from the given module.<br>
	 * The print is done in a single line.
	 * </p>
	 * 
	 * <p>
	 * <b> It is advise to use this procedure for printing big BDDs!! </b>
	 * </p>
	 * 
	 * @param b
	 *            The BDD to prepare string to.
	 * @return The string representing the BDD.
	 * 
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD)
	 * @see edu.wis.jtlv.env.Env#toNiceString(Module, BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceString(BDD, String)
	 * @see edu.wis.jtlv.env.Env#toNiceSignleLineString(Module, BDD)
	 */
	public static String toNiceSignleLineString(BDD b) {
		// printing is always done at the main factory
		BDD newB = copyBDDIntoBaseManager(b);
		return bdd_manager[0].toNiceSignleLineString(Env.getModule("main"),
				newB);
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Naming and Coupling Functionalities ////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The empty set of fields.
	 * </p>
	 * 
	 * @return The empty set of fields.
	 */
	public static BDDVarSet getEmptySet() {
		return bdd_manager[Env.getCurrentThreadManagerIdx()].emptySet();
	}

	// A workaround (better implemented in JTLVBDDFactory, as of 1.3.2)
	private static BDDVarSet intersect(BDDVarSet a, BDDVarSet b) {
		return bdd_manager[Env.getCurrentThreadManagerIdx()].intersect(a, b);
	}

	/**
	 * <p>
	 * Given a BDD, returns the same BDD in its prime version of the variables.
	 * </p>
	 * 
	 * @param unp_bdd
	 *            The unprimed BDD.
	 * @return The primed version of the given BDD.
	 * @throws BDDException
	 *             When trying to prime BDD with primed fields.
	 * 
	 * @see edu.wis.jtlv.env.Env#prime(BDD, ModuleBDDField[])
	 * @see edu.wis.jtlv.env.Env#unprime(BDD)
	 * @see edu.wis.jtlv.env.Env#unprime(BDD, ModuleBDDField[])
	 * @see edu.wis.jtlv.env.Env#containPrimeVars(BDD)
	 * @see edu.wis.jtlv.env.Env#containUnprimeVars(BDD)
	 */
	public static BDD prime(BDD unp_bdd) throws BDDException {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].prime(unp_bdd);
	}

	/**
	 * <p>
	 * Given a BDD, returns the same BDD with the prime version of the given
	 * array of fields.
	 * </p>
	 * 
	 * @deprecated due to performance issues. Try to use prime(BDD) where ever
	 *             possible.
	 * 
	 * @param unp_bdd
	 *            The given BDD.
	 * @param couples
	 *            The fields to prime.
	 * @return A BDD with primed version of the given fields.
	 * @throws BDDException
	 *             When trying to prime already primed fields.
	 * 
	 * @see edu.wis.jtlv.env.Env#prime(BDD)
	 * @see edu.wis.jtlv.env.Env#unprime(BDD)
	 * @see edu.wis.jtlv.env.Env#unprime(BDD, ModuleBDDField[])
	 * @see edu.wis.jtlv.env.Env#containPrimeVars(BDD)
	 * @see edu.wis.jtlv.env.Env#containUnprimeVars(BDD)
	 */
	public static BDD prime(BDD unp_bdd, ModuleBDDField[] couples)
			throws BDDException {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].prime(unp_bdd,
				couples);
	}

	/**
	 * <p>
	 * Given a BDD, returns the same BDD in its unprime version of the fields.
	 * </p>
	 * 
	 * @param p_bdd
	 *            The primed BDD.
	 * @return The unprimed version of the given BDD.
	 * @throws BDDException
	 *             When trying to unprime BDD with unprime fields.
	 * 
	 * @see edu.wis.jtlv.env.Env#prime(BDD)
	 * @see edu.wis.jtlv.env.Env#prime(BDD, ModuleBDDField[])
	 * @see edu.wis.jtlv.env.Env#unprime(BDD, ModuleBDDField[])
	 * @see edu.wis.jtlv.env.Env#containPrimeVars(BDD)
	 * @see edu.wis.jtlv.env.Env#containUnprimeVars(BDD)
	 */
	public static BDD unprime(BDD p_bdd) throws BDDException {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].unprime(p_bdd);
	}

	/**
	 * <p>
	 * Given a BDD, returns the same BDD with the unprime version of the given
	 * array of fields.
	 * 
	 * </p>
	 * 
	 * @deprecated due to performance issues. Try to use unprime(BDD) where ever
	 *             possible.
	 * 
	 * @param p_bdd
	 *            The given BDD.
	 * @param couples
	 *            The fields to unprime.
	 * @return A BDD with unprimed version of the given fields.
	 * @throws BDDException
	 *             When trying to unprime already unprimed fields.
	 * 
	 * @see edu.wis.jtlv.env.Env#prime(BDD)
	 * @see edu.wis.jtlv.env.Env#prime(BDD, ModuleBDDField[])
	 * @see edu.wis.jtlv.env.Env#unprime(BDD)
	 * @see edu.wis.jtlv.env.Env#containPrimeVars(BDD)
	 * @see edu.wis.jtlv.env.Env#containUnprimeVars(BDD)
	 */
	public static BDD unprime(BDD p_bdd, ModuleBDDField[] couples)
			throws BDDException {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].unprime(p_bdd,
				couples);
	}

	/**
	 * <p>
	 * Check whether the given BDD contains a prime version of some field.
	 * </p>
	 * 
	 * @param set
	 *            The BDD to check.
	 * @return true if the given BDD contains prime version of some field, false
	 *         otherwise.
	 * 
	 * @see edu.wis.jtlv.env.Env#containUnprimeVars(BDD)
	 * @see edu.wis.jtlv.env.Env#prime(BDD)
	 * @see edu.wis.jtlv.env.Env#prime(BDD, ModuleBDDField[])
	 * @see edu.wis.jtlv.env.Env#unprime(BDD)
	 * @see edu.wis.jtlv.env.Env#unprime(BDD, ModuleBDDField[])
	 */
	public static boolean containPrimeVars(BDD set) {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].has_prime_vars(set);
	}

	/**
	 * <p>
	 * Check whether the given BDD contains an unprime version of some field.
	 * </p>
	 * 
	 * @param set
	 *            The BDD to check.
	 * @return true if the given BDD contains unprime version of some field,
	 *         false otherwise.
	 * 
	 * @see edu.wis.jtlv.env.Env#containPrimeVars(BDD)
	 * @see edu.wis.jtlv.env.Env#prime(BDD)
	 * @see edu.wis.jtlv.env.Env#prime(BDD, ModuleBDDField[])
	 * @see edu.wis.jtlv.env.Env#unprime(BDD)
	 * @see edu.wis.jtlv.env.Env#unprime(BDD, ModuleBDDField[])
	 */
	public static boolean containUnprimeVars(BDD set) {
		return bdd_namer[Env.getCurrentThreadManagerIdx()]
				.has_unprime_vars(set);
	}

	/**
	 * <p>
	 * Get all primed variables in the system.
	 * </p>
	 * 
	 * @return All primed variables in the system.
	 * 
	 * @see edu.wis.jtlv.env.Env#globalUnprimeVars()
	 * @see edu.wis.jtlv.env.Env#globalVarsMinus(BDDVarSet)
	 */
	public static BDDVarSet globalPrimeVars() {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].globalPrimeVars();
	}

	/**
	 * <p>
	 * Get all unprimed variables in the system.
	 * </p>
	 * 
	 * @return All unprimed variables in the system.
	 * 
	 * @see edu.wis.jtlv.env.Env#globalPrimeVars()
	 * @see edu.wis.jtlv.env.Env#globalVarsMinus(BDDVarSet)
	 */
	public static BDDVarSet globalUnprimeVars() {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].globalUnprimeVars();
	}

	/**
	 * <p>
	 * Get the set of all variables (including the prime and unprime versions),
	 * except the given set of variables.
	 * </p>
	 * 
	 * @param minus
	 *            The variable set to remove.
	 * @return A set of all variables except the given ones.
	 * 
	 * @see edu.wis.jtlv.env.Env#globalPrimeVars()
	 * @see edu.wis.jtlv.env.Env#globalUnprimeVars()
	 */
	public static BDDVarSet globalVarsMinus(BDDVarSet minus) {
		return bdd_namer[Env.getCurrentThreadManagerIdx()]
				.globalVarsMinus(minus);
	}

	// public static BDDVarSet globalPrimeVarsMinus(BDDVarSet primeMinus) {
	// return bdd_namer[Env.getCurrentThreadManagerIdx()]
	// .globalPrimeVarsMinus(primeMinus);
	// }
	//
	// public static BDDVarSet globalUnprimeVarsMinus(BDDVarSet unprimeMinus) {
	// return bdd_namer[Env.getCurrentThreadManagerIdx()]
	// .globalUnprimeVarsMinus(unprimeMinus);
	// }

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can lead in a single step to the given states.
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param to
	 *            The set of state to be reach.
	 * @return The set of states which can lead in a single step to the given
	 *         states.
	 * 
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD pred(BDD trans, BDD to) {
		return pred(trans, to, Env.globalPrimeVars());
	}

	/**
	 * <p>
	 * Given a set of state, transitions, and a set of variables, the procedure
	 * return all states which can lead in a single step over the set of
	 * variables, to the given states.
	 * </p>
	 * 
	 * <p>
	 * Note that the returned set of states can contain prime version of the
	 * variable (not in primeVars).
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param to
	 *            The set of state to be reach.
	 * @param primeVars
	 *            The set of variable qualified for the step.
	 * @return The set of states which can lead in a single step to the given
	 *         states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	private static BDD pred(BDD trans, BDD to, BDDVarSet primeVars) {
		BDD prime_to = Env.prime(to);
		return prime_to.and(trans).exist(primeVars);
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can be reached in a single step from the given states.
	 * </p>
	 * 
	 * @param from
	 *            The given set of state.
	 * @param trans
	 *            The given transitions.
	 * @return The set of states which can be reached in a single step from the
	 *         given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD succ(BDD from, BDD trans) {
		return succ(from, trans, Env.globalUnprimeVars());
	}

	/**
	 * <p>
	 * Given a set of state, transitions, and a set of variables, the procedure
	 * return all states which can be reached in a single step over the set of
	 * variables, to the given states.
	 * </p>
	 * 
	 * <p>
	 * Note that the returned set of states can contain prime version of the
	 * variable (not in primeVars).
	 * </p>
	 * 
	 * @param from
	 * @param trans
	 * @param unprimeVars
	 *            The set of variable qualified for the step.
	 * @return The set of states which can be reached in a single step from the
	 *         given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	private static BDD succ(BDD from, BDD trans, BDDVarSet unprimeVars) {
		BDD prime_to = from.and(trans).exist(unprimeVars);
		return Env.unprime(prime_to);
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can lead in any number of steps to given states.
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param to
	 *            The set of state to be reach.
	 * @return The set of states which can lead in any number of steps to the
	 *         given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD allPred(BDD trans, BDD to) {
		return kPred(trans, to, Env.globalPrimeVars(), -1);
	}

	@SuppressWarnings("unused")
	private static BDD allPred(BDD trans, BDD to, BDDVarSet primeVars) {
		return kPred(trans, to, primeVars, -1);
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can lead in maximum k number of steps to given states.
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param to
	 *            The set of state to be reach.
	 * @param k
	 *            The number of maximum steps allowed.
	 * @return The set of states which can lead in k number of steps to the
	 *         given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD kPred(BDD trans, BDD to, int k) {
		return kPred(trans, to, Env.globalPrimeVars(), k);
	}

	private static BDD kPred(BDD trans, BDD to, BDDVarSet primeVars, int k) {
		int counter = 1;
		BDD oldPred, newPred = to;
		do {
			oldPred = newPred;
			newPred = oldPred.or(pred(trans, oldPred, primeVars));
			counter++;
		} while (!oldPred.equals(newPred) & (counter != k));
		return newPred;
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can lead in any number of steps to given states, excluding the
	 * given states themselves (in some cases this might be more efficient the
	 * allPred, and then conjuncting out the negation).
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param to
	 *            The set of state to be reach.
	 * @return The set of states which can lead in any number of steps to the
	 *         given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD allDeltaPred(BDD trans, BDD to) {
		// test for spell chek
		return kDeltaPred(trans, to, Env.globalPrimeVars(), -1);
	}

	@SuppressWarnings("unused")
	private static BDD allDeltaPred(BDD trans, BDD to, BDDVarSet primeVars) {
		return kDeltaPred(trans, to, primeVars, -1);
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can lead in maximum k number of steps to given states, excluding
	 * the given states themselves (in some cases this might be more efficient
	 * the kPred, and then conjuncting out the negation).
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param to
	 *            The set of state to be reach.
	 * @param k
	 *            The number of maximum steps allowed.
	 * @return The set of states which can lead in any number of steps to the
	 *         given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD kDeltaPred(BDD trans, BDD to, int k) {
		return kDeltaPred(trans, to, Env.globalPrimeVars(), k);
	}

	private static BDD kDeltaPred(BDD trans, BDD to, BDDVarSet primeVars, int k) {
		int counter = 1;
		BDD deltaPred = pred(trans, to, primeVars).and(to.not());
		BDD oldPred, newPred = deltaPred;
		if (k == 1)
			return newPred;
		else if (k == 0) // just so it will be close
			return Env.FALSE();
		// else
		do {
			oldPred = newPred;
			deltaPred = pred(deltaPred, trans, primeVars).and(oldPred.not())
					.and(to.not());
			newPred = oldPred.or(deltaPred);
			counter++;
		} while ((!oldPred.equals(newPred)) & (counter != k));
		return newPred;
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can be reached in a any number of steps from these states.
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param from
	 *            The given set of state.
	 * @return The set of states which can be reached in any number of steps
	 *         from the given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD allSucc(BDD from, BDD trans) {
		return kSucc(from, trans, Env.globalUnprimeVars(), -1);
	}

	@SuppressWarnings("unused")
	private static BDD allSucc(BDD from, BDD trans, BDDVarSet unprimeVars) {
		return kSucc(from, trans, unprimeVars, -1);
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can be reached in maximum k number of steps from these states.
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param from
	 *            The given set of state.
	 * @param k
	 *            The number of maximum steps allowed.
	 * @return The set of states which can be reached in maximum k number of
	 *         steps from the given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD kSucc(BDD from, BDD trans, int k) {
		return kSucc(from, trans, Env.globalUnprimeVars(), k);
	}

	private static BDD kSucc(BDD from, BDD trans, BDDVarSet unprimeVars, int k) {
		int counter = 1;
		BDD oldSucc, newSucc = from;
		do {
			oldSucc = newSucc;
			newSucc = oldSucc.or(succ(oldSucc, trans, unprimeVars));
			counter++;
		} while (!oldSucc.equals(newSucc) & (counter != k));
		return newSucc;
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can be reached in any number of steps from these states, excluding
	 * the given states themselves (in some cases this might be more efficient
	 * the allSucc, and then conjuncting out the negation).
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param from
	 *            The given set of state.
	 * @return The set of states which can be reached in any number of steps
	 *         from the given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kDeltaSucc(BDD, BDD, int)
	 */
	public static BDD allDeltaSucc(BDD from, BDD trans) {
		return kDeltaSucc(from, trans, Env.globalUnprimeVars(), -1);
	}

	@SuppressWarnings("unused")
	private static BDD allDeltaSucc(BDD from, BDD trans, BDDVarSet unprimeVars) {
		return kDeltaSucc(from, trans, unprimeVars, -1);
	}

	/**
	 * <p>
	 * Given a set of state and a transitions, the procedure return all states
	 * which can be reached in maximum k number of steps from these states,
	 * excluding the given states themselves (in some cases this might be more
	 * efficient the allSucc, and then conjuncting out the negation).
	 * </p>
	 * 
	 * @param trans
	 *            The given transitions.
	 * @param from
	 *            The given set of state.
	 * @param k
	 *            The number of maximum steps allowed.
	 * @return The set of states which can be reached in maximum k number of
	 *         steps from the given states.
	 * 
	 * @see edu.wis.jtlv.env.Env#pred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#succ(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kPred(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#kSucc(BDD, BDD, int)
	 * @see edu.wis.jtlv.env.Env#allDeltaPred(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#allDeltaSucc(BDD, BDD)
	 * @see edu.wis.jtlv.env.Env#kDeltaPred(BDD, BDD, int)
	 */
	public static BDD kDeltaSucc(BDD from, BDD trans, int k) {
		return kDeltaSucc(from, trans, Env.globalUnprimeVars(), k);
	}

	private static BDD kDeltaSucc(BDD from, BDD trans, BDDVarSet unprimeVars,
			int k) {
		int counter = 1;
		BDD deltaSucc = succ(from, trans, unprimeVars).and(from.not());
		BDD oldSucc, newSucc = deltaSucc;
		if (k == 1)
			return newSucc;
		else if (k == 0) // just so it will be close
			return Env.FALSE();
		// else
		do {
			oldSucc = newSucc;
			deltaSucc = succ(deltaSucc, trans, unprimeVars).and(oldSucc.not())
					.and(from.not());
			newSucc = oldSucc.or(deltaSucc);
			counter++;
		} while ((!oldSucc.equals(newSucc)) & (counter != k));
		return newSucc;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Error Handling /////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * A list of all error listeners which are invoked on any kind of error in
	 * the system.
	 * </p>
	 * 
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#removeErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#clearErrorListener()
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 * @see edu.wis.jtlv.env.ErrorListener
	 */
	public static LinkedList<ErrorListener> all_error_listeners;

	/**
	 * <p>
	 * Register an error listener to be invoked on every error which is thrown
	 * in the JTLV environment.
	 * </p>
	 * 
	 * @param lis
	 *            The new listener to add.
	 * @return true if the listeners queue has been changed.
	 * 
	 * @see edu.wis.jtlv.env.Env#all_error_listeners
	 * @see edu.wis.jtlv.env.Env#removeErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#clearErrorListener()
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 * @see edu.wis.jtlv.env.ErrorListener
	 */
	public static boolean registerErrorListener(ErrorListener lis) {
		return all_error_listeners.add(lis);
	}

	/**
	 * <p>
	 * Remove an error listener from the queue of listeners.
	 * </p>
	 * 
	 * @param lis
	 *            The listener to be removed.
	 * @return true if the listeners queue contained the specified element.
	 * 
	 * @see edu.wis.jtlv.env.Env#all_error_listeners
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#clearErrorListener()
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 * @see edu.wis.jtlv.env.ErrorListener
	 */
	public static boolean removeErrorListener(ErrorListener lis) {
		return all_error_listeners.remove(lis);
	}

	/**
	 * <p>
	 * Clears the entire listeners queue.
	 * </p>
	 * 
	 * @see edu.wis.jtlv.env.Env#all_error_listeners
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#removeErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 * @see edu.wis.jtlv.env.ErrorListener
	 */
	public static void clearErrorListener() {
		all_error_listeners.clear();
	}

	/**
	 * <p>
	 * Invoke the listeners queue with the given exception. This is the exact
	 * same procedure as {@link edu.wis.jtlv.env.Env#doError(Exception, String)}
	 * </p>
	 * 
	 * @param e
	 *            The exception to invoke the listeners with.
	 * @param msg
	 *            A text message describing the failure.
	 * 
	 * @see edu.wis.jtlv.env.Env#all_error_listeners
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#removeErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#clearErrorListener()
	 * @see edu.wis.jtlv.env.Env#doError(Exception, String)
	 * @see edu.wis.jtlv.env.ErrorListener
	 */
	private static void activateErrorListeners(Exception e, String msg) {
		for (ErrorListener listener : all_error_listeners) {
			listener.doError(e, msg);
		}
	}

	/**
	 * <p>
	 * Invoke the listeners queue with the given exception. This is the exact
	 * same procedure as
	 * {@link edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)}
	 * </p>
	 * 
	 * @param e
	 *            The exception to invoke the listeners with.
	 * @param msg
	 *            A text message describing the failure.
	 * 
	 * @see edu.wis.jtlv.env.Env#all_error_listeners
	 * @see edu.wis.jtlv.env.Env#registerErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#removeErrorListener(ErrorListener)
	 * @see edu.wis.jtlv.env.Env#clearErrorListener()
	 * @see edu.wis.jtlv.env.Env#activateErrorListeners(Exception, String)
	 * @see edu.wis.jtlv.env.ErrorListener
	 */
	public static void doError(Exception e, String msg) {
		activateErrorListeners(e, msg);
	}

	private static class StandardErrorOutput implements ErrorListener {
		public void doError(Exception e, String msg) {
			String pre = "";
			if (e instanceof RecognitionException) {
				RecognitionException re = (RecognitionException) e;
				pre += "line " + re.line + ":" + re.charPositionInLine + " ";
			}
			System.err.println(pre + msg);
		}
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// TODO: should also add a log file with the trace. ///////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	private static class LogErrorOutput implements ErrorListener {
		public void doError(Exception e, String msg) {
			// System.err.println("ERROR: " + e.getMessage());
			// System.err.println(msg);
		}
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////// Other Functionalities that Should be Hidden ////////////////
	// ////////////////////////////////////////////////////////////////////////
	/**
	 * <p>
	 * Creates a pair object which can then be used to associate two BDD fields.
	 * </p>
	 * 
	 * @param i
	 *            The factory to make the pair to.
	 * @return A new BDD pair.
	 * @throws ArrayIndexOutOfBoundsException
	 *             If addressed a non existing factory.
	 * 
	 */
	private static BDDPairing makePair() {
		return bdd_manager[Env.getCurrentThreadManagerIdx()].makePair();
	}

	/**
	 * <p>
	 * Given a BDD domain, search and returns the corresponding BDD field.
	 * </p>
	 * 
	 * @param dom
	 *            The domain to look his variable for.
	 * @return The variable corresponding to the given domain.
	 * 
	 */
	private static ModuleBDDField getVarForDomain(BDDDomain dom) {
		return bdd_namer[Env.getCurrentThreadManagerIdx()].getVarForDomain(dom);
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Thrown Functionalities /////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	// public static BDDDomain[] create_couple_bdds(int values_size) {
	// return bdd_manager.create_couple_bdds(values_size);
	// }

	// public static BDD ithVar(int var) {
	// return bdd_manager.ithVar(var);
	// }

	// public static int numberOfDomains() {
	// return bdd_manager.numberOfDomains();
	// }

	// public static BDDDomain getDomain(int d) {
	// return bdd_manager.getDomain(d);
	// }

	// public static JTLVBDDCouple get_glob_var(String name)
	// throws JTLVIllegalVariableException {
	// return bdd_namer.get_glob_var(name);
	// }

	// public static JTLVBDDCouple[] get_glob_var(String[] names)
	// throws JTLVIllegalVariableException {
	// return bdd_namer.get_glob_var(names);
	// }

	// public static JTLVBDDCouple[] get_var(String preface, String[] names)
	// throws JTLVIllegalVariableException {
	// return bdd_namer.get_var(preface, names);
	// }

	// public static boolean has_var(String preface, String[] names) {
	// return bdd_namer.has_vars(preface, names);
	// }

	// public static JTLVBDDCouple new_glob_var(String name)
	// throws JTLVIllegalVariableException {
	// return bdd_namer.new_glob_var(name);
	// }

	// public static JTLVBDDCouple[] new_glob_var(String[] names)
	// throws JTLVIllegalVariableException {
	// return bdd_namer.new_glob_var(names);
	// }

	// public static BDDVarSet get_prime_vars() {
	// return bdd_namer.get_prime_vars();
	// }

	// public static BDDVarSet get_unprime_vars() {
	// return bdd_namer.get_unprime_vars();
	// }

	// public static BDDVarSet var_intersection(BDD a, BDD b) {
	// // a work around for a bug in the BDDVarSet
	// BDDVarSet res = bdd_manager.emptySet();
	// int[] a_idx = a.support().toArray();
	// int[] b_idx = b.support().toArray();
	// for (int i = 0; i < a_idx.length; i++)
	// for (int j = 0; j < b_idx.length; j++)
	// if (a_idx[i] == b_idx[j])
	// res = res.id().union(a_idx[i]);
	// return res;
	// }

	// public static boolean hasVar(String preface, String name) {
	// return bdd_namer.has_var(preface, name);
	// }

	// public static JTLVBDDCouple[] new_var(String preface, String[] names,
	// int[] values_size) throws JTLVIllegalVariableException {
	// return bdd_namer.new_var(preface, names, values_size);
	// }

	// public static JTLVBDDCouple[] new_var(String preface, String[] names)
	// throws JTLVIllegalVariableException {
	// int[] values_size_arr = new int[names.length];
	// for (int i = 0; i < values_size_arr.length; i++) {
	// values_size_arr[i] = 2;
	// }
	// return new_var(preface, names, values_size_arr);
	// }

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// Internal Classes ///////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The JTLVBDDManager is responsible for communicating with all JavaBDD
	 * functionalities.
	 * </p>
	 * 
	 * <p>
	 * Its only holder is the Env, and all operation should be done through the
	 * Env.
	 * </p>
	 * 
	 * @see edu.wis.jtlv.env.Env
	 * 
	 * @version {@value edu.wis.jtlv.env.Env#version}
	 * @author yaniv sa'ar.
	 */
	private static final class JTLVBDDManager {
		private static int print_order_domain_threshold = 32;
		private static int range_thrashold = 3;

		static {
			// init 64
			if (System.getProperty("java.vm.name").contains("64")) {
				System.setProperty("buddylib", "buddy64");
				// for some reason the property is not used for CAL and CUDD.
				System.setProperty("cuddlib", "cudd64");
				System.setProperty("callib", "cal64");
			}
		}

		private BDDFactory factory;
		private String factory_name;
		private String package_name;
		private int nodenum;
		private int cachesize;

		private JTLVBDDManager() {
		}

		private JTLVBDDManager(BDDFactory f) {
			tear_down();
			reset_factory(f);
		}

		private JTLVBDDManager(int node_num, int cache_size) {
			reset_factory(node_num, cache_size);
		}

		private static final String getProperty(String key, String def) {
			try {
				return System.getProperty(key, def);
			} catch (AccessControlException _) {
				return def;
			}
		}

		// ////////////////////////////
		// factory methods...
		private void reset_factory(BDDFactory f) {
			this.tear_down();
			this.nodenum = -1;
			this.cachesize = -1;
			this.factory_name = "user_factory";
			// no setup...
			this.factory = f;
		}

		private void reset_factory(int node_num, int cache_size) {
			this.tear_down();
			this.nodenum = node_num;
			this.cachesize = cache_size;
			this.factory_name = prompt2name();
			this.package_name = "net.sf.javabdd." + factory_name;
			this.setup();
		}

		private void setup() {
			assert (this.factory == null);
			String prev_user_dir = System.getProperty("user.dir", ".");
			System.setProperty("user.dir", prev_user_dir
					+ getProperty("file.separator", "/") + "JTLV_DLIB");
			try {
				this.factory = BDDFactory
						.init(package_name, nodenum, cachesize);
			} catch (Throwable t) {
				if (t instanceof InvocationTargetException)
					t = ((InvocationTargetException) t).getTargetException();
				System.err.println("Failed initializing " + package_name + ": "
						+ t);
			}
			System.setProperty("user.dir", prev_user_dir);
		}

		private static String prompt2name() {
			// default is BuDDy...
			String bddpackage = BDDFactory.getProperty("bdd", "jtlv");
			if (bddpackage.equals("buddy"))
				return "BuDDyFactory";
			if (bddpackage.equals("cudd"))
				return "CUDDFactory";
			if (bddpackage.equals("cal"))
				return "CALFactory";
			if (bddpackage.equals("j") || bddpackage.equals("java"))
				return "JFactory";
			if (bddpackage.equals("u"))
				return "UberMicroFactory";
			if (bddpackage.equals("micro"))
				return "MicroFactory";
			if (bddpackage.equals("jdd"))
				return "JDDFactory";
			// not factories of their own...
			// if (bddpackage.equals("test"))
			// return "TestBDDFactory";
			// if (bddpackage.equals("typed"))
			// return "TypedBDDFactory";
			if (bddpackage.equals("jtlv"))
				return "JTLVJavaFactory";
			if (bddpackage.equals("jtlvjdd"))
				return "JTLVJddFactory";
			// if (bddpackage.equals("zdd")) {
			// BDDFactory bdd = JFactory.init(nodenum, cachesize);
			// ((JFactory)bdd).ZDD = true;
			// return bdd;
			// }
			System.err.println("Failed to find package '" + bddpackage
					+ "' initializing JTLVBDDFactory instead.");
			return "JTLVBDDFactory";

		}

		private void tear_down() {
			destroy_factory();
		}

		private void destroy_factory() {
			if (this.factory == null)
				return;
			this.factory.done();
			this.factory = null;
		}

		public void doOnGC(Method m_gc) {
			this.factory.registerGCCallback(this, m_gc);
		}

		public void doOnResize(Method m_resize) {
			this.factory.registerResizeCallback(this, m_resize);
		}

		public void doOnReorder(Method m_reorder) {
			this.factory.registerReorderCallback(this, m_reorder);
		}

		public static void doQuietGcCallback() {
		}

		public static void doQuietResizeCallback() {
		}

		// /////////////////////////////////
		private BDD TRUE() {
			return this.factory.one();
		}

		private BDD FALSE() {
			return this.factory.zero();
		}

		private BDDDomain allocBDD(int values_size) {
			return this.factory.extDomain(values_size);
		}

		// ///////////////////////////////////////////
		// general util.
		// public int numberOfDomains() {
		// return factory.numberOfDomains();
		// }
		//
		// public BDDDomain getDomain(int d) {
		// return factory.getDomain(d);
		// }
		//
		// public BDD ithVar(int var) {
		// return factory.ithVar(var);
		// }

		private BDDVarSet emptySet() {
			return this.factory.emptySet();
		}

		private BDDPairing makePair() {
			return this.factory.makePair();
		}

		/**
		 * @return the factory_name
		 */
		private String factoryName() {
			return factory_name;
		}

		private void save(String filename, BDD to_save) throws IOException {
			this.factory.save(filename, to_save);
		}

		private BDD load(String filename) throws IOException {
			return this.factory.load(filename);
		}

		private String toNiceString(Module con, BDD b) {
			return toNiceStringHelper(con, b, true, "");
		}

		private String toNiceString(Module con, BDD b, String startIndent) {
			return toNiceStringHelper(con, b, true, startIndent);
		}

		private String toNiceSignleLineString(Module con, BDD b) {
			return toNiceStringHelper(con, b, false, "");
		}

		private String toNiceStringHelper(Module con, BDD b,
				boolean withIndent, String currIndent) {
			// restricting the values, to the ones possible in the domains.
			BDDDomain[] all_doms = b.support().getDomains();
			BDD non_existing_vals = Env.FALSE();
			for (int i = 0; i < all_doms.length; i++) {
				b = b.and(all_doms[i].domain());
				non_existing_vals = non_existing_vals.or(all_doms[i].domain()
						.not());
			}
			return toNiceStringHelper2(con, b, non_existing_vals, withIndent,
					currIndent);
		}

		private String toNiceStringHelper2(Module con, BDD b,
				BDD non_existing_vals, boolean withIndent, String currIndent) {
			BDDDomain[] all_doms = b.support().getDomains();
			// int[] all_doms = b.support().toArray();

			if (b.or(non_existing_vals).isUniverse())
				return "TRUE";
			if (b.and(non_existing_vals.not()).isZero())
				return "FALSE";

			// all relevant domains...
			sortArr(all_doms, new BDDDomainComparator());
			BDDDomain curDom = all_doms[0];
			// BDDDomain curDom = factory.getDomain(all_doms[0]);

			// ////////////////////////////////////////////////////////////////////
			// preparing
			String res = "";
			String pre = ((withIndent) ? currIndent : ""); // prefix indent...
			String suf = ((withIndent) ? "\n" : " "); // suffix line break...
			String fName = getFieldName(con, curDom);
			BigInteger[] allVals = getDomainLegitValues(curDom, b);
			sortArr(allVals, new BigIntegerComparator());

			// ////////////////////////////////////////////////////////////////////
			// now we are starting to work on this domain....

			// if this is the last domain, then shortening it...
			if (all_doms.length == 1) {
				res = pre + getValueStr(fName, curDom, allVals);
				return res;
			}

			// first checking if I can do a simple grouping of everything...
			// i.e. all values has the same rest BDD.
			if (valsCanBeGrouped(b, curDom, allVals)) {
				// if (false) {
				BDD rest = b.and(curDom.ithVar(allVals[0])).exist(curDom.set());
				res += pre + "(" + getValueStr(fName, curDom, allVals) + " and";

				String toAdd = toNiceStringHelper2(con, rest,
						non_existing_vals, withIndent, currIndent);
				// removing tabes
				while (toAdd.startsWith("\t"))
					toAdd = toAdd.substring(1);

				// making new line for the next indent in line...
				return res + " " + toAdd + ")";
			}

			// otherwise, enumarating everything.
			// first conjuncting out all not possible values...
			BigInteger[] notVals = opVals(allVals, curDom.size().intValue());
			if (notVals.length > 0)
				res += pre + getNotValueStr(fName, curDom, notVals) + " and"
						+ suf;

			// then conjuncting in all possible values...
			boolean isFirst = true;
			for (BigInteger val : allVals) {
				BDD rest = b.and(curDom.ithVar(val)).exist(curDom.set());
				if (rest.or(non_existing_vals).isUniverse())
					continue;
				res += (isFirst ? "" : " and" + suf) + pre + "(" + fName;
				res += "=" + Env.stringer.elementName(curDom, val) + " -> ";

				// making new line for the next indent in line...
				boolean doIndent = (all_doms.length > 2);
				res += doIndent ? suf : "";
				res += toNiceStringHelper2(con, rest, non_existing_vals,
						doIndent & withIndent, currIndent + "\t");
				res += ")";
				isFirst = false;
			}
			return res;
		}

		private boolean valsCanBeGrouped(BDD b, BDDDomain dom,
				BigInteger[] allVals) {
			BDD toCompare = b.and(dom.ithVar(allVals[0])).exist(dom.set());
			for (int i = 1; i < allVals.length; i++) {
				if (!b.and(dom.ithVar(allVals[i])).exist(dom.set()).biimp(
						toCompare).isUniverse()) {
					return false;
				}
			}
			return true;
		}

		private BigInteger[] getDomainLegitValues(BDDDomain curDom, BDD b) {
			BDD iter_b = b.id();
			Vector<BigInteger> res_vec = new Vector<BigInteger>();

			while (!iter_b.isZero()) {
				BigInteger toAdd = iter_b.scanVar(curDom);
				res_vec.add(toAdd);
				BDD val_bdd = curDom.ithVar(toAdd);
				iter_b = iter_b.and(val_bdd.not());
			}

			BigInteger[] res = new BigInteger[res_vec.size()];
			res_vec.toArray(res);
			return res;
		}

		// private BigInteger[] getBelowValues(BigInteger[] allVals,
		// BigInteger maxVal) {
		// Vector<BigInteger> res_vec = new Vector<BigInteger>(allVals.length);
		// for (BigInteger val : allVals) {
		// if (!val.max(maxVal).equals(val))
		// res_vec.add(val);
		// }
		// BigInteger[] res = new BigInteger[res_vec.size()];
		// res_vec.toArray(res);
		// return res;
		// }

		private String getFieldName(Module con, BDDDomain dom) {
			ModuleBDDField coup = Env.getVarForDomain(dom);
			if (con == null)
				return coup.getPath() + "." + coup.getName();
			if (!(coup.getPath().equals(con.getFullInstName())))
				return coup.getPath() + "." + coup.getName();
			return coup.getName();
		}

		// all_vals is always sorted...
		private String getValueStr(String field, BDDDomain dom,
				BigInteger[] allVals) {
			if (allVals.length > (dom.size().intValue() / 2))
				return getNotValueStr(field, dom, opVals(allVals, dom.size()
						.intValue()));
			if (allVals.length == 1)
				return field + "=" + Env.stringer.elementName(dom, allVals[0]);
			String res = field + "=" + "{";
			for (int i = 0; i < allVals.length; i++) {
				res += (i == 0) ? "" : ", ";
				int until = rangeUntil(allVals, i);
				if (until != -1)
					res += Env.stringer.elementNames(dom, allVals[i],
							allVals[until]);
				else
					res += Env.stringer.elementName(dom, allVals[i]);
			}
			res += "}";
			return res;
		}

		private int rangeUntil(BigInteger[] all_vals, int start_idx) {
			int range_elem_count = 0;
			for (int i = start_idx; i < all_vals.length - 1; i++)
				if (all_vals[i].intValue() + 1 == all_vals[i + 1].intValue())
					range_elem_count++;
				else if (range_elem_count >= range_thrashold)
					return i;
				else
					return -1;
			if (range_elem_count >= range_thrashold)
				return all_vals.length - 1;
			else
				return -1;
		}

		// all_vals is always sorted...
		private String getNotValueStr(String field, BDDDomain dom,
				BigInteger[] allVals) {
			if (allVals.length > (dom.size().intValue() / 2))
				return getValueStr(field, dom, opVals(allVals, dom.size()
						.intValue()));
			if (allVals.length == 1)
				return field + "!=" + Env.stringer.elementName(dom, allVals[0]);
			String res = field + "!=" + "{";
			for (int i = 0; i < allVals.length; i++) {
				res += (i == 0) ? "" : ", ";
				int until = rangeUntil(allVals, i);
				if (until != -1)
					res += Env.stringer.elementNames(dom, allVals[i],
							allVals[until]);
				else
					res += Env.stringer.elementName(dom, allVals[i]);
			}
			res += "}";
			return res;
		}

		private BigInteger[] opVals(BigInteger[] cur_vals, int max) {
			Vector<BigInteger> res_vec = new Vector<BigInteger>(max);
			for (int i = 0; i < max; i++) {
				boolean exists = false;
				for (int j = 0; j < cur_vals.length; j++)
					if (cur_vals[j].intValue() == i)
						exists = true;
				if (!exists)
					res_vec.add(new BigInteger("" + i));
			}
			BigInteger[] res = new BigInteger[res_vec.size()];
			res_vec.toArray(res);
			sortArr(res, new BigIntegerComparator());
			return res;
		}

		// private boolean isUniverseValue(BDDDomain dom, BigInteger val, BDD b)
		// {
		// // restricting the values, to the ones possible in this domain.
		// b = b.id().and(dom.domain());
		// if (b.and(dom.ithVar(val)).exist(dom.set()).isUniverse()) {
		// return true;
		// }
		// return false;
		// }

		@SuppressWarnings("unchecked")
		private void sortArr(Object[] objArr, Comparator c) {
			List<Object> objList = new LinkedList<Object>();
			for (int i = 0; i < objArr.length; i++) {
				objList.add(objArr[i]);
			}
			Collections.sort(objList, c);
			objList.toArray(objArr);
		}

		private class BDDDomainComparator implements Comparator<BDDDomain> {
			public int compare(BDDDomain arg0, BDDDomain arg1) {
				int left = enumDomain(arg0);
				int right = enumDomain(arg1);
				return (left - right);
			}

			public int enumDomain(BDDDomain dom) {
				if (dom.size().intValue() <= print_order_domain_threshold)
					return dom.getIndex();
				else
					// factory.varNum() won't be changed during a single
					// print...
					return (int) (Math.pow(2, factory.varNum()))
							+ dom.getIndex();
			}
		}

		private class BigIntegerComparator implements Comparator<BigInteger> {
			public int compare(BigInteger arg0, BigInteger arg1) {
				return (int) (arg0.longValue() - arg1.longValue());
			}
		}

		// // always working with 'that' facilities, except when coming to
		// return a
		// // value...
		// @SuppressWarnings("unused")
		// private BDD copyBDDIntoFactory(BDD that) {
		// // go over 'that' domains
		// BDDDomain[] all_doms = that.support().getDomains();
		//
		// // if there is no domain in the BDD, i.e. FALSE, or TRUE.
		// if (all_doms.length == 0)
		// return (that.isUniverse() ? this.TRUE() : this.FALSE());
		// //
		// ////////////////////////////////////////////////////////////////////
		// // all relevant domains...
		// BDDDomain curDom = all_doms[0];
		// BDD reduced_that = that.id();
		// for (int i = all_doms.length - 1; 0 < i; i--) {
		// reduced_that = reduced_that.exist(all_doms[i].set());
		// }
		// BigInteger[] allVals = curDom.getVarIndices(reduced_that);
		// // for some reason I sometime get values not in the actual range...
		// allVals = getValuesBelow(allVals, curDom.size());
		// //
		// ////////////////////////////////////////////////////////////////////
		// // now we are starting to work on this domain....
		// BDD res = this.FALSE();
		// BDDDomain this_curr_dom = this.factory.getDomain(curDom.getIndex());
		// if (all_doms.length == 1) {
		// for (int i = 0; i < allVals.length; i++)
		// res = res.or(this_curr_dom.ithVar(allVals[i]));
		// } else {
		// for (BigInteger val : allVals) {
		// BDD new_val = this_curr_dom.ithVar(val);
		// BDD rest = curDom.ithVar(val).and(that).exist(curDom.set());
		// res = res.or(new_val.and(copyBDDIntoFactory(rest)));
		// }
		// }
		// if (debugCopyBDD) {
		// if (!that.toString().equals(res.toString())) {
		// System.err.println("BDD convertion failed.");
		// }
		// }
		// return res;
		// }

		// always working with 'that' facilities, except when coming to return a
		// value...
		// private BDD oldCopyBDDIntoFactory(BDD that) {
		// // FIX ME: causes the parallel bug (was a GC occurs)
		// // if (factory_converter.containsKey(that))
		// // return factory_converter.get(that).id();
		// if (that.isUniverse())
		// return TRUE();
		// if (that.isZero())
		// return FALSE();
		//
		// BDD res;
		// BDD that_l = that.low();
		// BDD that_h = that.high();
		// if (that_l.equals(that_h)) {
		// res = oldCopyBDDIntoFactory(that_l);
		// } else {
		// BDD l = oldCopyBDDIntoFactory(that_l);
		// BDD h = oldCopyBDDIntoFactory(that_h);
		// res = this.factory.ithVar(that.var()).ite(h, l);
		// }
		//
		// // if (debugCopyBDD) {
		// // if (!that.toString().equals(res.toString())) {
		// // System.err.println("BDD convertion failed.");
		// // }
		// // }
		// // FIX ME: as noted at the top of the method
		// // factory_converter.put(that, res);
		// return res;
		// }

		// FIX ME: as noted at the top of the method
		// private HashMap<BDD, BDD> factory_converter = new HashMap<BDD,
		// BDD>();

		private BDDVarSet copyBDDVarSetIntoFactory(BDDVarSet that) {
			if (that.getFactory() == this.factory)
				return that;
			BDDVarSet res = this.factory.emptySet();
			BDDDomain[] all_doms = that.getDomains();
			for (int i = 0; i < all_doms.length; i++) {
				BDDDomain this_domain = this.factory.getDomain(all_doms[i]
						.getIndex());
				res = res.union(this_domain.set());
			}
			return res;
		}

		// @SuppressWarnings("unused")
		// private BDD oldCopyBDDIntoFactory(BDD that) {
		// if (that.isUniverse())
		// return this.factory.one();
		// if (that.isZero())
		// return this.factory.zero();
		//
		// return this.factory.ithVar(that.var()).ite(
		// oldCopyBDDIntoFactory(that.high()),
		// oldCopyBDDIntoFactory(that.low()));
		// }

		/* recursive copy, uses map to avoid recomputation */
		private BDD copyBDDIntoFactory(BDD that) {
			if (that.isUniverse())
				return this.factory.one();
			if (that.isZero())
				return this.factory.zero();

			BDD result = copyBDDIntoFactoryRec(that, new HashMap<BDD, BDD>());
			return result;
		}

		private BDD copyBDDIntoFactoryRec(BDD that, HashMap<BDD, BDD> map) {
			if (that.isUniverse())
				return this.factory.one();
			if (that.isZero())
				return this.factory.zero();

			BDD stored = map.get(that);

			if (stored != null)
				return stored;

			/* else, compute; store, then return result */

			BDD high = copyBDDIntoFactoryRec(that.high(), map);
			BDD low = copyBDDIntoFactoryRec(that.low(), map);
			stored = this.factory.ithVar(that.var()).ite(high, low);

			map.put(that, stored);

			return stored;
		}

		// a workaround for a bug in javaBDD
		private BDDVarSet intersect(BDDVarSet a, BDDVarSet b) {
			BDDVarSet res = this.emptySet();
			BDDDomain[] aDoms = a.getDomains();
			BDDDomain[] bDoms = b.getDomains();
			for (int i = 0; i < aDoms.length; i++) {
				for (int j = 0; j < bDoms.length; j++) {
					if (aDoms[i].getIndex() == bDoms[j].getIndex())
						res = res.id().union(aDoms[i].set());
				}
			}
			return res;
		}

	}

	// private static boolean debugCopyBDD = false;

	/**
	 * <p>
	 * The JTLVBDDManagerPairing is responsible for the BDD coupling, i.e. the
	 * prime and unprime versions of the fields.
	 * </p>
	 * 
	 * <p>
	 * Its only holder is the Env, and all operation should be done through the
	 * Env.
	 * </p>
	 * 
	 * @version {@value edu.wis.jtlv.env.Env#version}
	 * @author yaniv sa'ar.
	 * 
	 */
	private static final class JTLVBDDManagerPairing {
		// //////////////////////////////////
		// the current implementation is to order the bdd as unprime variable
		// first, and the immediately followed variable is its primed version.
		private Vector<ModuleBDDField> all_couples;

		private JTLVBDDManagerPairing() {
			all_couples = new Vector<ModuleBDDField>(100);
		}

		/**
		 * The main implementation for creating a variable.
		 * 
		 * @param preface
		 *            module name.
		 * @param name_with_tick
		 *            variable name, can also be in prime notation (e.g. x').
		 * @param values_size
		 * @return the couple bdd created for this name.
		 * @throws ModuleVariableException
		 *             if the name already exists.
		 */
		private ModuleBDDField new_var(int thread_idx, String preface,
				String name_with_tick, int values_size)
				throws ModuleVariableException {
			// preparing a proper name.
			if (is_prime_name(name_with_tick)) {
				throw new ModuleVariableException(
						"Cannot declare a variable with \'.");
			}
			String name = this.to_simple_name(name_with_tick);

			// preparing the actual bdds.
			if (search_couple(preface, this.to_simple_name(name)) != null) {
				throw new ModuleVariableException("variable \"" + "<" + preface
						+ ">." + name + "\" already exists.");
			}

			BDDDomain[] couple = new BDDDomain[2];
			couple[0] = Env.allocBDD(thread_idx, values_size);
			couple[1] = Env.allocBDD(thread_idx, values_size);

			// making the pair
			ModuleBDDField new_pair = new ModuleBDDField(couple[0], couple[1],
					preface, name);

			all_couples.add(new_pair);

			// returning the relevant couple.
			return new_pair;
		}

		private ModuleBDDField getVarForDomain(BDDDomain dom) {
			for (ModuleBDDField coup : this.all_couples) {
				if (dom.getIndex() == coup.getDomain().getIndex())
					return coup;
				if (dom.getIndex() == coup.other().getDomain().getIndex())
					return coup.other();
			}
			return null;
		}

		// ////////////////////////////////////
		// getter without creation
		private ModuleBDDField search_couple(String preface, String name) {
			ModuleBDDField[] iter = new ModuleBDDField[this.all_couples.size()];
			all_couples.toArray(iter);
			for (int i = 0; i < iter.length; i++) {
				if ((iter[i].getPath().equals(preface))
						&& (iter[i].getName().equals(name))) {
					return iter[i];
				}
			}
			return null;
		}

		private ModuleBDDField get_var(String preface, String name) {
			ModuleBDDField res;
			try {
				res = search_couple(preface, this.to_simple_name(name));
				if (res == null)
					return null;
				return this.is_prime_name(name) ? res.prime() : res;
			} catch (ModuleVariableException e) {
				return null;
			}
		}

		// ////////////////////////////////////
		// until here all was single var BDD manipulations.
		// here on there are general BDD operations.

		private boolean is_prime_name(String name)
				throws ModuleVariableException {
			if (name.indexOf("'") != name.lastIndexOf("'")) {
				throw new ModuleVariableException(
						"ERROR: cannot name a variable: \"" + name + "\"");
			}
			return (name.indexOf("'") != -1);
		}

		private String to_simple_name(String name)
				throws ModuleVariableException {
			return is_prime_name(name) ? name.substring(0, name.indexOf("'"))
					: name;
		}

		// /////////////////////// pairings ///////////////////////
		private ModuleBDDField[] all_couples_arr = null;

		private ModuleBDDField[] all_couples_arr() {
			if (all_couples_arr != null)
				if (all_couples_arr.length == all_couples.size())
					return all_couples_arr;

			all_couples_arr = new ModuleBDDField[all_couples.size()];
			all_couples.toArray(all_couples_arr);
			return all_couples_arr;
		}

		private BDDPairing all_couples_pairing = null;
		private int all_couples_pairing_size = 0;

		private BDDPairing all_couples_pairing() {
			ModuleBDDField[] pairs = all_couples_arr();
			if (pairs != null) {
				if (pairs.length == all_couples_pairing_size) {
					return all_couples_pairing;
				}
			}
			all_couples_pairing = this.mk_pairs(pairs);
			all_couples_pairing_size = pairs.length;
			return all_couples_pairing;
		}

		private BDD all_buddy_couples_pairing = null;
		private int all_buddy_couples_pairing_size = 0;

		private BDD all_buddy_couples_pairing() {
			ModuleBDDField[] pairs = all_couples_arr();
			if (pairs != null) {
				if (pairs.length == all_buddy_couples_pairing_size) {
					if (all_buddy_couples_pairing == null) {
						all_buddy_couples_pairing = Env.TRUE();
					}
					return all_buddy_couples_pairing;
				}
			}
			all_buddy_couples_pairing_size = pairs.length;
			all_buddy_couples_pairing = this.mk_buddy_pairs(pairs);
			return all_buddy_couples_pairing;
		}

		/**
		 * @deprecated
		 * 
		 * @param unp_bdd
		 * @param pairs
		 * @return
		 * @throws BDDException
		 */
		private BDD prime(BDD unp_bdd, ModuleBDDField[] pairs)
				throws BDDException {
			// FIXME_DONE: performance issue....
			if (has_prime_vars(unp_bdd, pairs))
				throw new BDDException("ERROR: Cannot prime primed "
						+ "variables: \n\t" + get_prime_vars(pairs));
			BDD res = null;
			if (Env.getFactoryName() == "BuDDyFactory") {
				// workaround due to some kind of a bug in pairing with buddy
				res = unp_bdd.id().and(all_buddy_couples_pairing());
				res = res.exist(get_unprime_vars(pairs));
			} else {
				// mk_pairs is a speedup consumer...
				res = unp_bdd.id().replace(this.mk_pairs(pairs));
			}
			return res;
		}

		private BDD prime(BDD unp_bdd) throws BDDException {
			ModuleBDDField[] pairs = all_couples_arr();
			if (has_prime_vars(unp_bdd, pairs))
				throw new BDDException("ERROR: Cannot prime primed "
						+ "variables: \n\t" + get_prime_vars(pairs));
			BDD res = null;
			if (Env.getFactoryName() == "BuDDyFactory") {
				// workaround due to some kind of a bug in pairing with buddy
				res = unp_bdd.id().and(all_buddy_couples_pairing());
				res = res.exist(get_unprime_vars(pairs));
			} else {
				res = unp_bdd.id().replace(all_couples_pairing());
			}
			return res;
		}

		/**
		 * @deprecated
		 * 
		 * @param p_bdd
		 * @param pairs
		 * @return
		 * @throws BDDException
		 */
		private BDD unprime(BDD p_bdd, ModuleBDDField[] pairs)
				throws BDDException {
			// FIXME_DONE: performance issue....
			if (has_unprime_vars(p_bdd, pairs))
				throw new BDDException("ERROR: Cannot unprime unprimed "
						+ "variables: \n\t" + get_unprime_vars(pairs));
			BDD res = null;
			if (Env.getFactoryName() == "BuDDyFactory") {
				// workaround due to some kind of a bug in pairing with buddy
				res = p_bdd.id().and(all_buddy_couples_pairing());
				res = res.exist(get_prime_vars(pairs));
			} else {
				// mk_pairs is a speedup consumer...
				res = p_bdd.id().replace(this.mk_pairs(pairs));
			}
			return res;
		}

		private BDD unprime(BDD p_bdd) throws BDDException {
			ModuleBDDField[] pairs = all_couples_arr();
			if (has_unprime_vars(p_bdd, pairs))
				throw new BDDException("ERROR: Cannot unprime unprimed "
						+ "variables: \n\t" + get_unprime_vars(pairs));
			BDD res = null;
			if (Env.getFactoryName() == "BuDDyFactory") {
				// workaround due to some kind of a bug in pairing with buddy
				res = p_bdd.id().and(all_buddy_couples_pairing());
				res = res.exist(get_prime_vars(pairs));
			} else {
				res = p_bdd.id().replace(all_couples_pairing());
			}
			return res;
		}

		private BDDVarSet globalPrimeVars() {
			return get_prime_vars(all_couples_arr());
		}

		private BDDVarSet globalUnprimeVars() {
			return get_unprime_vars(all_couples_arr());
		}

		private BDDVarSet globalPrimeVarsMinus(BDDVarSet primeMinus) {
			Vector<ModuleBDDField> all_less = new Vector<ModuleBDDField>();
			ModuleBDDField[] all = all_couples_arr();

			for (int i = 0; i < all.length; i++) {
				BDDVarSet var = all[i].getOtherDomain().set();
				if (Env.intersect(primeMinus, var).isEmpty())
					all_less.add(all[i]);
			}

			ModuleBDDField[] all_less_arr = new ModuleBDDField[all_less.size()];
			all_less.toArray(all_less_arr);
			return get_prime_vars(all_less_arr);
		}

		private BDDVarSet globalUnprimeVarsMinus(BDDVarSet unprimeMinus) {
			Vector<ModuleBDDField> all_less = new Vector<ModuleBDDField>();
			ModuleBDDField[] all = all_couples_arr();

			for (int i = 0; i < all.length; i++) {
				BDDVarSet var = all[i].getDomain().set();
				if (Env.intersect(unprimeMinus, var).isEmpty())
					all_less.add(all[i]);
			}

			ModuleBDDField[] all_less_arr = new ModuleBDDField[all_less.size()];
			all_less.toArray(all_less_arr);
			return get_unprime_vars(all_less_arr);
		}

		private BDDVarSet globalVarsMinus(BDDVarSet minus) {
			BDDVarSet minusPrime = Env.intersect(minus, this.globalPrimeVars());
			BDDVarSet minusUnprime = Env.intersect(minus, this
					.globalUnprimeVars());

			return this.globalPrimeVarsMinus(minusPrime).union(
					this.globalUnprimeVarsMinus(minusUnprime));
		}

		private boolean has_prime_vars(BDD set, ModuleBDDField[] pairs) {
			int[] var_prof = set.varProfile();
			for (int j = 0; j < pairs.length; j++) {
				ModuleBDDField p = pairs[j].isPrime() ? pairs[j] : pairs[j]
						.other();
				int[] vars = p.getDomain().vars();
				for (int i = 0; i < vars.length; i++)
					if (var_prof[vars[i]] > 0)
						return true;
			}
			return false;
		}

		@SuppressWarnings("unused")
		private boolean bad_has_prime_vars(BDD set, ModuleBDDField[] pairs) {
			BDDVarSet all_vars = set.support();
			for (int j = 0; j < pairs.length; j++) {
				BDDVarSet p_var = pairs[j].isPrime() ? pairs[j].support()
						: pairs[j].prime().support();
				// there is a bug with the intersect
				BDDVarSet un = all_vars.union(p_var);
				if (un.size() != (p_var.size() + all_vars.size()))
					return true;
			}
			return false;
		}

		private boolean has_prime_vars(BDD set) {
			return has_prime_vars(set, all_couples_arr());
		}

		private BDDVarSet get_prime_vars(ModuleBDDField[] pairs) {
			BDDVarSet res = Env.getEmptySet();
			for (int j = 0; j < pairs.length; j++) {
				BDDVarSet p_var = pairs[j].isPrime() ? pairs[j].support()
						: pairs[j].prime().support();
				res = res.id().union(p_var);
			}
			return res;
		}

		private boolean has_unprime_vars(BDD set, ModuleBDDField[] pairs) {
			int[] var_prof = set.varProfile();
			for (int j = 0; j < pairs.length; j++) {
				ModuleBDDField up = pairs[j].isPrime() ? pairs[j].other()
						: pairs[j];
				int[] vars = up.getDomain().vars();
				for (int i = 0; i < vars.length; i++)
					if (var_prof[vars[i]] > 0)
						return true;
			}
			return false;
		}

		@SuppressWarnings("unused")
		private boolean bad_has_unprime_vars(BDD set, ModuleBDDField[] pairs) {
			BDDVarSet all_vars = set.support();
			for (int j = 0; j < pairs.length; j++) {
				BDDVarSet up_var = pairs[j].isPrime() ? pairs[j].unprime()
						.support() : pairs[j].support();
				BDDVarSet un = all_vars.id().union(up_var);
				if (un.size() != (up_var.size() + all_vars.size()))
					return true;
			}
			return false;
		}

		private boolean has_unprime_vars(BDD set) {
			return has_unprime_vars(set, all_couples_arr());
		}

		private BDDVarSet get_unprime_vars(ModuleBDDField[] pairs) {
			BDDVarSet res = Env.getEmptySet();
			for (int j = 0; j < pairs.length; j++) {
				BDDVarSet up_var = pairs[j].isPrime() ? pairs[j].unprime()
						.support() : pairs[j].support();
				res = res.id().union(up_var);
			}
			return res;
		}

		private BDD mk_buddy_pairs(ModuleBDDField[] all_couples) {
			BDD res = Env.TRUE();
			for (int i = 0; i < all_couples.length; i++) {
				res = res.id().and(
						all_couples[i].getDomain().buildEquals(
								all_couples[i].getOtherDomain()));
			}
			return res;
		}

		private BDDPairing mk_pairs(ModuleBDDField[] all_couples) {
			BDDPairing res = Env.makePair();
			res.reset();
			for (int i = 0; i < all_couples.length; i++) {
				res.set(all_couples[i].getDomain().vars(), all_couples[i]
						.getOtherDomain().vars());
				res.set(all_couples[i].getOtherDomain().vars(), all_couples[i]
						.getDomain().vars());
			}
			return res;
		}

		// ////////////////////////////////////////////////////////////////////
		// deleted unused funtionalities.
		// ////////////////////////////////////////////////////////////////////
		// 
		// /*
		// * a loop of variable list creation.
		// *
		// * @param preface
		// * module name.
		// * @param names
		// * list of names.
		// * @param values_size
		// * @return list of couples created, corresponding to the list of names
		// * given.
		// * @throws ModuleVariableException
		// * if one of the names already exists.
		// */
		// private ModuleBDDField[] new_var(int thread_idx, String preface,
		// String[] names, int[] values_size)
		// throws ModuleVariableException {
		// ModuleBDDField[] res = new ModuleBDDField[names.length];
		// for (int i = 0; i < names.length; i++) {
		// res[i] = new_var(thread_idx, preface, names[i], values_size[i]);
		// }
		// return res;
		// }
		//
		// private ModuleBDDField new_glob_var(int thread_idx, String name,
		// int values_size) throws ModuleVariableException {
		// return new_var(thread_idx, "global", name, values_size);
		// }
		//
		// private ModuleBDDField new_glob_var(int thread_idx, String name)
		// throws ModuleVariableException {
		// return new_var(thread_idx, "global", name, 2);
		// }
		//
		// private ModuleBDDField[] new_glob_var(int thread_idx, String[] names,
		// int[] values_size) throws ModuleVariableException {
		// return new_var(thread_idx, "global", names, values_size);
		// }
		//
		// private ModuleBDDField[] new_glob_var(int thread_idx, String[] names)
		// throws ModuleVariableException {
		// int[] values_size_arr = new int[names.length];
		// for (int i = 0; i < values_size_arr.length; i++) {
		// values_size_arr[i] = 2;
		// }
		// return new_var(thread_idx, "global", names, values_size_arr);
		// }
		// 
		// ////////////////////////////////////////////////////////////////////
		// 
		// private boolean has_var(String preface, String name) {
		// boolean res = false;
		// try {
		// res = (null != search_couple(preface, this.to_simple_name(name)));
		// } catch (ModuleVariableException e) {
		// // not exists
		// }
		// return res;
		// }
		//
		// private ModuleBDDField[] get_var(String preface, String[] names)
		// throws ModuleVariableException {
		// ModuleBDDField[] res = new ModuleBDDField[names.length];
		// for (int i = 0; i < names.length; i++) {
		// res[i] = get_var(preface, names[i]);
		// if (res[i] == null)
		// throw new ModuleVariableException(
		// "ERROR: Couldn't find variable named <" + preface
		// + ">." + names[i]);
		// }
		// return res;
		// }

		// private boolean has_vars(String preface, String[] names) {
		// for (int i = 0; i < names.length; i++) {
		// if (!has_var(preface, names[i]))
		// return false;
		// }
		// return true;
		// }
		//
		// private ModuleBDDField get_glob_var(String name)
		// throws ModuleVariableException {
		// return get_var("global", name);
		// }
		//
		// private ModuleBDDField[] get_glob_var(String[] names)
		// throws ModuleVariableException {
		// return get_var("global", names);
		// }
		// 
		// ////////////////////////////////////////////////////////////////////
		// 
		// private BDDVarSet get_prime_vars() {
		// return get_prime_vars(all_couples_arr());
		// }
		// 
		// private BDDVarSet get_unprime_vars() {
		// return get_unprime_vars(all_couples_arr());
		// }
		// 
		// ////////////////////////////////////////////////////////////////////
		// 

	}

	/**
	 * <p>
	 * The JTLVBDDToString is responsible for naming of the values in the BDD
	 * domain.
	 * </p>
	 * 
	 * <p>
	 * Its holder is variable stringer at Env, and all operation should be done
	 * through the Env (unless another instance of this object is created else
	 * where by the user...).
	 * </p>
	 * 
	 * @version {@value edu.wis.jtlv.env.Env#version}
	 * @author yaniv sa'ar.
	 * 
	 */
	public static class JTLVBDDToString extends BDDToString implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private HashMap<Integer, String[]> dom2vals;
		private HashMap<Integer, Integer[]> dom2range;

		public JTLVBDDToString() {
			dom2vals = new HashMap<Integer, String[]>(100);
			dom2range = new HashMap<Integer, Integer[]>(100);
		}

		public void register_domain_module_values(SMVModule m, BDDDomain dom,
				String[] values) {
			dom2vals.put(dom.getIndex(), mk_unique_val_name(
					m.getFullInstName(), values));
		}

		public void register_domain_module_values(SMVModule m, BDDDomain dom,
				int range_start, int range_size) {
			dom2range.put(dom.getIndex(), new Integer[] { range_start,
					range_size });
		}

		public boolean domain_has_module_value(SMVModule m, BDDDomain dom,
				String value) {
			int dom_idx = dom.getIndex();
			String[] all_vals = dom2vals.get(dom_idx);
			if (all_vals == null)
				return false;
			for (int i = 0; i < all_vals.length; i++) {
				if (all_vals[i].equals(mk_unique_val_name(m.getFullInstName(),
						value))) {
					return true;
				}
			}
			return false;
		}

		public BigInteger get_module_value_loc(SMVModule m, BDDDomain dom,
				String value) {
			int dom_idx = dom.getIndex();
			String[] all_vals = dom2vals.get(dom_idx);
			if (all_vals == null)
				return new BigInteger("-1");
			for (int i = 0; i < all_vals.length; i++) {
				if (all_vals[i].equals(mk_unique_val_name(m.getFullInstName(),
						value))) {
					String val = "" + i;
					return new BigInteger(val);
				}
			}
			return new BigInteger("-1");
		}

		private static boolean print_as_range = false;

		// implementations
		public String elementName(BDDDomain dom, BigInteger j) {
			return elementName(dom.getIndex(), j);
		}

		public String elementName(int i, BigInteger j) {
			String res = "";
			int val_idx = j.intValue();
			String[] all_vals = dom2vals.get(i);
			if (all_vals == null) {
				if (val_idx == 0) {
					res = "0";
				} else if (val_idx == 1) {
					res = "1";
				} else {
					// looking for range domain
					Integer[] range = dom2range.get(i);
					if (range != null) {
						int range_val = range[0] + val_idx;
						res += range_val;
					} else {
						res += "#?#";
					}
				}
			} else {
				if (val_idx < all_vals.length) {
					res = all_vals[val_idx];
				} else {
					res = "#?#";
				}
			}
			return res;
		}

		public String elementNames(BDDDomain dom, BigInteger lo, BigInteger hi) {
			return elementNames(dom.getIndex(), lo, hi);
		}

		public String elementNames(int i, BigInteger lo, BigInteger hi) {
			int lo_idx = lo.intValue();
			int hi_idx = hi.intValue();
			if (lo_idx == hi_idx) {
				return elementName(i, lo);
			}

			if (print_as_range) {
				return "{" + elementName(i, lo) + ".." + elementName(i, hi)
						+ "}";
			}

			String res = "{";
			for (int iter = lo_idx; iter <= hi_idx; iter++) {
				res += elementName(i, new BigInteger("" + lo_idx));
				res += (iter != hi_idx) ? ", " : "}";
			}
			return res;
		}

		private String[] mk_unique_val_name(String prefix,
				String[] unique_val_name) {
			String[] res = new String[unique_val_name.length];
			for (int i = 0; i < unique_val_name.length; i++) {
				res[i] = mk_unique_val_name(prefix, unique_val_name[i]);
			}
			return res;
		}

		private String mk_unique_val_name(String prefix, String val_name) {
			// if it is a number, then I'm not making it unique.
			//
			// make problems with param, since I don't always have the holder if
			// it
			// is a long address (e.g. the param is "cg.mode")
			// try {
			// Integer.parseInt(val_name);
			// return val_name;
			// } catch (NumberFormatException nfe) {
			// }
			// return "___value___" + prefix + "[$]" + val_name;
			return val_name;
		}

		// ////////////////////////////////////////////////////////////////////
		// deleted unused funtionalities.
		// ////////////////////////////////////////////////////////////////////
		// 
		// // has.... (only for names...)
		// private boolean domain_has_all_module_values(SMVModule m, BDDDomain
		// dom,
		// String[] values) {
		// return this.domain_has_all_module_values(m, dom.getIndex(), values);
		// }
		//
		// private boolean domain_has_all_module_values(SMVModule m, int dom,
		// String[] values) {
		// for (int i = 0; i < values.length; i++) {
		// if (!domain_has_module_value(m, dom, values[i])) {
		// return false;
		// }
		// }
		// return true;
		// }
		// 
		// private BigInteger get_module_value_loc(SMVModule m, BDDDomain dom,
		// int range_value) {
		// return this.get_module_value_loc(m, dom.getIndex(), range_value);
		// }
		//
		// private BigInteger get_module_value_loc(SMVModule m, int dom,
		// int range_value) {
		// Integer[] range = dom2range.get(dom);
		// if (range != null) {
		// if ((range_value >= range[0])
		// && (range_value <= range[0] + range[1])) {
		// int int_val = range_value - range[0];
		// String str_val = "" + int_val;
		// return new BigInteger(str_val);
		// }
		// }
		// return new BigInteger("-1");
		// }

	}

}
