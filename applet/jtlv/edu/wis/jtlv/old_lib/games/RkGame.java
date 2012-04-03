package edu.wis.jtlv.old_lib.games;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDVarSet;
import net.sf.javabdd.BDD.BDDIterator;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.Module;
import edu.wis.jtlv.lib.FixPoint;
import edu.wis.jtlv.old_lib.games.Memory;
import edu.wis.jtlv.old_lib.games.MyPair;
import edu.wis.jtlv.old_lib.games.Memory.Permutation;

/**
 * <p>
 * Nir Piterman, Amir Pnueli. "Faster Solutions of Rabin and Streett Games".
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * 
 */
public class RkGame implements Game {
	public static class ImplicationEntity {
		public BDD g, r;

		public ImplicationEntity(BDD g, BDD r) {
			this.g = g;
			this.r = r;
		}
	}

	private Module env, sys;
	private BDD sys_win;

	// The memory used to construct the strategy
	private Memory mem;
	
	public RkGame(Module env, Module sys, Set<ImplicationEntity> pairs)
			throws GameException {
		if ((env == null) || (sys == null))
			throw new GameException("Cannot instansiate a GR[N] Game "
					+ "with an empty player.");

		this.env = env;
		this.sys = sys;

		// playing the games itself...
		if (pairs.isEmpty()) {
			sys_win = m_Streett(Env.TRUE(), Env.FALSE());
		} else {
			MyPair res = Streett(pairs,Env.TRUE(), Env.FALSE());
			sys_win = res.bdd;
			this.mem = res.mem;
		}
	}

	private BDD cpred(BDD to) {
		BDDVarSet sys_prime = this.sys.modulePrimeVars();
		BDDVarSet env_prime = this.env.modulePrimeVars();
		BDD exy = Env.prime(to).and(this.sys.trans()).exist(sys_prime);
		return this.env.trans().imp(exy).forAll(env_prime);
	}

	public BDD m_Streett(BDD seqng, BDD rest) {
		BDD x = Env.TRUE();
		for (FixPoint<BDD> iterX = new FixPoint<BDD>(); iterX.advance(x);) {
			x = rest.or(seqng.and(cpred(x)));
		}
		return x.id();
	}

	/**
	 * <p>
	 * Calculating winning states. ("Func Streett")
	 * </p>
	 * 
	 * @return The winning states for this game and the memory used to construct the strategy.
	 */
	private MyPair Streett(Set<ImplicationEntity> pairs, BDD seqng, BDD rest) {
		BDD y, z;
		FixPoint<BDD> iterZ, iterY;
		
		Memory localmem = new Memory(pairs);

		z = Env.TRUE();
		for (iterZ = new FixPoint<BDD>(); iterZ.advance(z);) {
			for (ImplicationEntity entity : pairs) {
				int pair_index = localmem.local_index(entity);
				int p_cy = 0;
				// The first used memory is always empty.
				Memory returned_memory = new Memory();
				Set<ImplicationEntity> nSet = rm_entity(pairs, entity);
				BDD p1 = rest.or(seqng.and(entity.r).and(cpred(z)));
				y = Env.FALSE();
				for (iterY = new FixPoint<BDD>(); iterY.advance(y);) {
					BDD p2 = p1.or(seqng.and(cpred(y)));
					// Store the BDD and its corresponding recursive partition (returned_memory)
					localmem.insert(entity,pair_index,p_cy++,p2,returned_memory);
					if (nSet.isEmpty()) {
						y = m_Streett(seqng.and(entity.g.not()), p2);
					} else {
						MyPair temp = Streett(nSet,seqng.and(entity.g.not()),p2);
						y=y.or(temp.bdd);
						returned_memory = temp.mem;
					}
				}
				z = y.id();
			}
		}
		// Return a pair consisting of BDD and memory
		MyPair ret = new MyPair(z.id(),localmem);
		return ret;
	}

	private Set<ImplicationEntity> rm_entity(Set<ImplicationEntity> a_set,
			ImplicationEntity entity) {
		// creating a new set with the same elements, and removing the entity.
		Set<ImplicationEntity> res = new HashSet<ImplicationEntity>(a_set);
		res.remove(entity);
		return res;
	}

	public void printWinningStrategy() {
		Stack<BDD> st_stack = new Stack<BDD>();
		Stack<Memory.Permutation> perm_stack = new Stack<Memory.Permutation	>();
		Stack<RawState> aut = new Stack<RawState>();

		BDD all_init = env.initial().and(sys.initial());
		
		Memory.Permutation iperm = new Memory.Permutation(this.mem.size());
		for (int i=0; i<this.mem.size(); ++i) 
			iperm.perm[i] = 0;
		
		BDDIterator all_states = all_init.iterator(this.env.moduleUnprimeVars().union(this.sys.moduleUnprimeVars()));
		// insert all the initial states with the initial permutation
		// to the stacks of states and permutations
		while (all_states.hasNext()) {
			BDD sin = (BDD) all_states.next();
			st_stack.push(sin);
			perm_stack.push(iperm);
		}

		while (!st_stack.isEmpty()) {
			BDD p_st = st_stack.pop();
			Memory.Permutation p_perm = perm_stack.pop();
			RawState new_state = new RawState(aut.size(), p_st, p_perm);

			int nidx = aut.indexOf(new_state);
			if (nidx == -1)
				aut.push(new_state);
			else 
				new_state = aut.elementAt(nidx);
			
			// Find the minimal index set according to this permutation
			// We are reusing the permutation data structure for the sequence of locations
			Memory.Permutation p_loc = new Memory.Permutation(this.mem.size());
			boolean found = this.mem.find_intersect(p_st,p_perm,p_loc); 
			assert found : "Coulnd't find location of a state";

			// Compute the set of environment possible successors
			Vector<BDD> succs = new Vector<BDD>();
			BDD all_succs = this.env.succ(p_st);
			all_states = all_succs.iterator(this.env.moduleUnprimeVars());
			while (all_states.hasNext()) {
				BDD sin = (BDD) all_states.next();
				succs.add(sin);
			}

			Iterator<BDD> iter_succ = succs.iterator();
			while (iter_succ.hasNext()) {
				BDD primed_curr_succ = Env.prime(iter_succ.next());
				BDD next_op = Env.unprime(this.sys.trans().and(p_st).and(primed_curr_succ)
						.exist(
								this.env.moduleUnprimeVars().union(
										this.sys.moduleUnprimeVars())));
				
				Permutation perm_cand = new Permutation(this.mem.size());
				perm_cand.copy(p_perm);

				BDD candidate = this.mem.next_intersect(p_st,next_op, perm_cand,p_loc); 
				assert !candidate.isZero() : "Failed to find a successor for a state"; 
						
				// Picking one candidate. In JDD satOne does not take
				// env.unprimeVars().union(sys.unprimeVars()) into its
				// considerations.
				BDD one_cand = candidate.satOne(this.env.moduleUnprimeVars().union(
						this.sys.moduleUnprimeVars()),false);
			
				RawState gsucc = new RawState(aut.size(), one_cand, perm_cand);
				int idx = aut.indexOf(gsucc);
				if (idx == -1) {
					st_stack.push(one_cand);
					perm_stack.push(perm_cand);			
					aut.add(gsucc);				
					idx = aut.indexOf(gsucc);			
				}			
				new_state.add_succ(aut.elementAt(idx));			
			}
		}

		String res = "";
		RawState[] all_st = new RawState[aut.size()];
		aut.toArray(all_st);
		for (int i = 0; i < all_st.length; i++) {
			res += all_st[i] + "\n";
		}

		System.out.print("\n\n");
		System.out.print(res);
		// return null; // res;
	}

	/**
	 * <p>
	 * Getter for the environment player.
	 * </p>
	 * 
	 * @return The environment player.
	 */
	public Module getEnvPlayer() {
		return env;
	}

	/**
	 * <p>
	 * Getter for the system player.
	 * </p>
	 * 
	 * @return The system player.
	 */
	public Module getSysPlayer() {
		return sys;
	}

	/**
	 * <p>
	 * Getter for the environment's winning states.
	 * </p>
	 * 
	 * @return The environment's winning states.
	 */
	public BDD sysWinningStates() {
		return sys_win;
	}

	/**
	 * <p>
	 * Getter for the system's winning states.
	 * </p>
	 * 
	 * @return The system's winning states.
	 */
	public BDD envWinningStates() {
		return sys_win.not();
	}

	public BDD gameInitials() {
		return getSysPlayer().initial().and(getEnvPlayer().initial());
	}

	public BDD[] playersWinningStates() {
		return new BDD[] { envWinningStates(), sysWinningStates() };
	}
	
	protected class RawState {
		private int id;
		private Memory.Permutation perm;
		private BDD state;
		private Vector<RawState> succ;

		public RawState(int id, BDD state, Memory.Permutation perm) {
			this.id = id;
			this.state = state;
			this.perm = perm;
			succ = new Vector<RawState>(10);
		}

		public void add_succ(RawState to_add) {
			succ.add(to_add);
		}

		public BDD get_state() {
			return this.state;
		}

		public Memory.Permutation get_perm() {
			return this.perm;
		}

		public BDD[] get_succ() {
			BDD[] res = new BDD[this.succ.size()];
			this.succ.toArray(res);
			return res;
		}

		public boolean equals(Object other) {
			if (!(other instanceof RawState))
				return false;
			RawState other_raw = (RawState) other;
			if (other_raw == null)
				return false;

			
			return ((this.perm.equals(other_raw.perm)) & (this.state
					.equals(other_raw.state)));
		}

		public String toString() {
			String res = "State " + id + " with perm " + perm.toString() + " -> "
					+ state.toStringWithDomains(Env.stringer) + "\n";
			if (succ.isEmpty()) {
				res += "\tWith no successors.";
			} else {
				RawState[] all_succ = new RawState[succ.size()];
				succ.toArray(all_succ);
				res += "\tWith successors : " + all_succ[0].id;
				for (int i = 1; i < all_succ.length; i++) {
					res += ", " + all_succ[i].id;
				}
			}
			return res;
		}
	}

}
