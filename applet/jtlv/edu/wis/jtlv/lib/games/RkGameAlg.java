package edu.wis.jtlv.lib.games;

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
import edu.wis.jtlv.lib.AlgExceptionI;
import edu.wis.jtlv.lib.AlgResultBDD;
import edu.wis.jtlv.lib.AlgResultI;
import edu.wis.jtlv.lib.AlgResultString;
import edu.wis.jtlv.lib.FixPoint;

/**
 * <p>
 * Nir Piterman, Amir Pnueli. "Faster Solutions of Rabin and Streett Games".
 * (The streett implementation)
 * </p>
 * 
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author yaniv sa'ar.
 * @author nir piterman.
 * 
 */
public class RkGameAlg implements GameAlgI {
	private Module env, sys;
	private Set<ReactivePair> main_pairs;
	// The memory used to construct the strategy
	private Memory mem;

	/**
	 * <p>
	 * A constructor for the R[k] Game and synthesis.
	 * </p>
	 * 
	 * @param env
	 *            The environment player.
	 * @param sys
	 *            The system player.
	 * @param pairs
	 *            A set of pair of implications.
	 * @throws GameAlgException
	 *             When instantiating with null players or set of pairs.
	 */
	public RkGameAlg(Module env, Module sys, Set<ReactivePair> pairs)
			throws GameAlgException {
		if ((env == null) || (sys == null) || (pairs == null))
			throw new GameAlgException("Cannot instantiate a GR[N] Game "
					+ "with an empty player.");

		this.env = env;
		this.sys = sys;
		this.main_pairs = pairs;
	}

	/**
	 * <p>
	 * Does nothing.
	 * </p>
	 * 
	 * @return Nothing.
	 * 
	 * @see edu.wis.jtlv.lib.AlgI#preAlgorithm()
	 */
	@Override
	public AlgResultI preAlgorithm() throws AlgExceptionI {
		return null;
	}

	/**
	 * <p>
	 * performing the GR 1 game itself, and collecting all memory.
	 * </p>
	 * 
	 * @return The winning state of the system player.
	 * 
	 * @see edu.wis.jtlv.lib.AlgI#doAlgorithm()
	 */
	@Override
	public AlgResultI doAlgorithm() throws AlgExceptionI {
		// playing the games itself...
		BDD sys_win;
		if (main_pairs.isEmpty()) {
			sys_win = m_Streett(Env.TRUE(), Env.FALSE());
		} else {
			MyPair res = Streett(main_pairs, Env.TRUE(), Env.FALSE());
			sys_win = res.bdd;
			this.mem = res.mem;
		}
		return new AlgResultBDD(sys_win);
	}

	/**
	 * <p>
	 * Calculating winning states. ("Func Streett")
	 * </p>
	 * 
	 * @return The winning states for this game and the memory used to construct
	 *         the strategy.
	 */
	private MyPair Streett(Set<ReactivePair> pairs, BDD seqng, BDD rest) {
		BDD y, z;
		FixPoint<BDD> iterZ, iterY;

		Memory localmem = new Memory(pairs);

		z = Env.TRUE();
		for (iterZ = new FixPoint<BDD>(); iterZ.advance(z);) {
			for (ReactivePair entity : pairs) {
				int pair_index = localmem.local_index(entity);
				int p_cy = 0;
				// The first used memory is always empty.
				Memory returned_memory = new Memory();
				Set<ReactivePair> nSet = rm_entity(pairs, entity);
				BDD p1 = rest
						.or(seqng.and(entity.getGuarantee()).and(cpred(z)));
				y = Env.FALSE();
				for (iterY = new FixPoint<BDD>(); iterY.advance(y);) {
					BDD p2 = p1.or(seqng.and(cpred(y)));
					// Store the BDD and its corresponding recursive partition
					// (returned_memory)
					localmem.insert(entity, pair_index, p_cy++, p2,
							returned_memory);
					if (nSet.isEmpty()) {
						y = m_Streett(seqng.and(entity.getAssum().not()), p2);
					} else {
						MyPair temp = Streett(nSet, seqng.and(entity.getAssum()
								.not()), p2);
						y = y.or(temp.bdd);
						returned_memory = temp.mem;
					}
				}
				z = y.id();
			}
		}
		// Return a pair consisting of BDD and memory
		MyPair ret = new MyPair(z.id(), localmem);
		return ret;
	}

	private BDD cpred(BDD to) {
		BDDVarSet sys_prime = this.sys.modulePrimeVars();
		BDDVarSet env_prime = this.env.modulePrimeVars();
		BDD exy = Env.prime(to).and(this.sys.trans()).exist(sys_prime);
		return this.env.trans().imp(exy).forAll(env_prime);
	}

	private BDD m_Streett(BDD seqng, BDD rest) {
		BDD x = Env.TRUE();
		for (FixPoint<BDD> iterX = new FixPoint<BDD>(); iterX.advance(x);) {
			x = rest.or(seqng.and(cpred(x)));
		}
		return x.id();
	}

	/**
	 * <p>
	 * The post algorithm calculate the synthesizing implementation.
	 * </p>
	 * 
	 * <p>
	 * Extracting an arbitrary implementation from the set of possible
	 * strategies.
	 * </p>
	 * 
	 * @return The synthesis of the design (in String format).
	 */
	@Override
	public AlgResultI postAlgorithm() throws AlgExceptionI {
		Stack<BDD> st_stack = new Stack<BDD>();
		Stack<Permutation> perm_stack = new Stack<Permutation>();
		Stack<RawState> aut = new Stack<RawState>();

		BDD all_init = env.initial().and(sys.initial());

		Permutation iperm = new Permutation(this.mem.size());
		for (int i = 0; i < this.mem.size(); ++i)
			iperm.perm[i] = 0;

		BDDIterator all_states = all_init.iterator(this.env.moduleUnprimeVars()
				.union(this.sys.moduleUnprimeVars()));
		// insert all the initial states with the initial permutation
		// to the stacks of states and permutations
		while (all_states.hasNext()) {
			BDD sin = (BDD) all_states.next();
			st_stack.push(sin);
			perm_stack.push(iperm);
		}

		while (!st_stack.isEmpty()) {
			BDD p_st = st_stack.pop();
			Permutation p_perm = perm_stack.pop();
			RawState new_state = new RawState(aut.size(), p_st, p_perm);

			int nidx = aut.indexOf(new_state);
			if (nidx == -1)
				aut.push(new_state);
			else
				new_state = aut.elementAt(nidx);

			// Find the minimal index set according to this permutation
			// We are reusing the permutation data structure for the sequence of
			// locations
			Permutation p_loc = new Permutation(this.mem.size());
			boolean found = this.mem.find_intersect(p_st, p_perm, p_loc);
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
				BDD next_op = Env.unprime(this.sys.trans().and(p_st).and(
						primed_curr_succ).exist(
						this.env.moduleUnprimeVars().union(
								this.sys.moduleUnprimeVars())));

				Permutation perm_cand = new Permutation(this.mem.size());
				perm_cand.copy(p_perm);

				BDD candidate = this.mem.next_intersect(p_st, next_op,
						perm_cand, p_loc);
				assert !candidate.isZero() : "Failed to find a successor for a state";

				// Picking one candidate. In JDD satOne does not take
				// env.unprimeVars().union(sys.unprimeVars()) into its
				// considerations.
				BDD one_cand = candidate.satOne(this.env.moduleUnprimeVars()
						.union(this.sys.moduleUnprimeVars()), false);

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

		// System.out.print("\n\n");
		// System.out.print(res);
		return new AlgResultString("\n" + res);
	}

	private Set<ReactivePair> rm_entity(Set<ReactivePair> a_set,
			ReactivePair entity) {
		// creating a new set with the same elements, and removing the entity.
		Set<ReactivePair> res = new HashSet<ReactivePair>(a_set);
		res.remove(entity);
		return res;
	}

	private class RawState {
		private int id;
		private Permutation perm;
		private BDD state;
		private Vector<RawState> succ;

		public RawState(int id, BDD state, Permutation perm) {
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

		public Permutation get_perm() {
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
			String res = "State " + id + " with perm " + perm.toString()
					+ " -> " + state.toStringWithDomains(Env.stringer) + "\n";
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

	/**
	 * <p>
	 * A permutation is a sequence of integers. We have a strange representation
	 * The 1st integer is a number in 0..(n-1) The 2nd integer is a number in
	 * 0..(n-2) telling us which of the remaining numbers is chosen The i-th
	 * integer is a number in 0..(n-i) telling us which of the remaining numbers
	 * is chosen The n-th integer is always 0 there is no more choice here ...
	 * For example: the permutation 0123 is represented by 0000 the permutation
	 * 3210 is represented by 3210 the permutation 1032 is represented by 1010
	 * the 1 in {0,1,2,3} the 0 is {0,2,3} the 1 in {2,3} the 0 in {2} the
	 * permutation 2103 is represented by 2100 the 2 in {0,1,2,3} the 1 is
	 * {0,1,3} the 0 in {0,3} the 0 in {3} In particular, the last entry is
	 * always 0.
	 * </p>
	 * 
	 * <p>
	 * NOTICE: A permutation is also used to represent a ranking. This is just
	 * an ordered tuple of integers. In this case, the integers refer to the
	 * number of iterations of the least fixpoint in a given level of the
	 * recursion
	 * </p>
	 */
	private class Permutation {
		// The permutation - an array of integers
		public int[] perm;
		// The size of the array
		public int size;

		// Initialize the permutation to a given size
		public Permutation(int size) {
			this.perm = new int[size];
			this.size = size;
		}

		// Copy a permutation
		public void copy(Permutation source) {
			assert source.size == this.size : "Copying permutations of different sizes";
			for (int i = 0; i < this.size; ++i)
				this.perm[i] = source.perm[i];
		}

		// The order of permutations is the lexicographical ordering.
		// We increase a permutation in a given location (loc).
		// This is done by:
		// 1. If the location to be increased holds the maximal pair that is
		// remaining
		// then the location is reduced to 0.
		// 2. If the location to be increased is not the maximal pair that is
		// remaining
		// then the location is increased by 1.
		// The rest of the permutation is set to 0 (i.e., the rest of the pairs
		// are set
		// to the fixed order of increasing numbers).
		public void increase(int loc) {
			assert loc < size : "Cannot increase a non-existent size";
			if (this.perm[loc] == size - loc - 1)
				this.perm[loc] = 0;
			else
				++(this.perm[loc]);
			for (int i = loc + 1; i < size; ++i)
				this.perm[i] = 0;
		}

		// When two permutations are equal
		public boolean equals(Object other) {
			if (other.getClass() != this.getClass())
				return false;
			Permutation temp = (Permutation) other;
			if (temp.size != this.size)
				return false;
			for (int i = 0; i < this.size; ++i)
				if (temp.perm[i] != this.perm[i])
					return false;

			return true;
		}

		// Output the permutation to a String.
		// There could be a nicer output that computes the actual number of pair
		// that
		// matches a given location.
		public String toString() {
			String res = "<";
			for (int i = 0; i < this.size; ++i)
				res += this.perm[i];
			res += ">";
			return res;
		}
	} // end of permutation class.

	/**
	 * <p>
	 * This class is intended to serve as the data structure for holding BDDs in
	 * the recursive game (Streett game). It also harvests this data structure
	 * for the strategy.
	 * </p>
	 * 
	 * <p>
	 * The idea of the data structure is as follows. Upon creation, the
	 * structure gets a set of fairness numbers. Per fairness number we have a
	 * vector of BDDs with each entry in this vector, there is also an
	 * associated recursive pointer to the same substructure.
	 * </p>
	 * 
	 * <p>
	 * At the moment only existential strategy is implemented. This matches a
	 * situation where the environment makes the first move and the system has
	 * to answer it. The idea of the strategy is as follows: 1. If the current
	 * state is a r state, then the permutation is increased to the next
	 * permutation and the successor is set to the minimal possible successor
	 * according to the next permutation. 2. If the current state is not an r
	 * state, then the permutation remains the same permutation in this level We
	 * either a. Reduce the ranking in this level, or b. Remain in the same rank
	 * in this level, make sure that we are not a g-state and call recursively
	 * for the strategy to handle the next levels. 3. At the bottom of the
	 * recursion, if we are not in all the g's of all the pairs, then the
	 * ranking can remain the same and we just choose some successor.
	 * 
	 * @author Nir Piterman <firstname.lastname@doc.ic.ac.uk>
	 * 
	 */
	private class Memory {

		// The amount of increase in chunks of BDDs.
		private static final int increase = 20;

		// All the different arrays agree on the size of the first dimension.
		// This dimension is of the size size.
		// The second dimension grows according to the need.
		// It is intended to hold as many BDDs as needed.
		// The structure of bdd_mem and recursive_mem should develop
		// simultaneously
		// In the bdd_mem[i][j] we have the BDD whose structure is recursively
		// decomposed
		// by recursive_mem[i][j]

		// The size of the first dimension
		private int size;
		// The size of the second dimension
		private int length;
		// The ordered Streett pairs
		private ReactivePair[] indices;
		// The BDDs
		private BDD[][] bdd_mem;
		// The recursive decomposition of the BDDs
		private Memory[][] recursive_mem;

		// An empty memory (required for stopping the recursion).
		public Memory() {
			this.size = 0;
			this.length = 0;
		}

		// A memory initizlized with a set of Streett pairs.
		// We copy the set of Streett pairs
		// And initialize the BDD memory and the recursive memory.
		// The BDDs are initialized to FALSE - this is important for searching
		// the location
		// of states in the memory. At the worst case,
		// we search also in uninitialized locations.
		public Memory(Set<ReactivePair> pairs) {
			this.size = pairs.size();
			this.indices = new ReactivePair[this.size];
			int i = 0;
			for (ReactivePair entity : pairs)
				indices[i++] = entity;

			this.bdd_mem = new BDD[this.size][increase];
			for (int j = 0; j < this.size; ++j)
				for (int k = 0; k < increase; ++k)
					this.bdd_mem[j][k] = Env.FALSE();

			this.length = increase;
			if (this.size > 1)
				this.recursive_mem = new Memory[this.size][increase];
		}

		// Translate a pair to its location in the 1st dimension in the
		// memory.
		public int local_index(ReactivePair pair) {
			for (int i = 0; i < this.size; ++i) {
				if (pair == this.indices[i])
					return i;
			}
			return -1;
		}

		// Add a BDD new_bdd and it's corresponding decomposition new_memory.
		// The new values are added in the location location.
		// The dimension is set by pair_ind and it is checked to match the pair.
		// When extra size is required the arrays are increased in size.
		public void insert(ReactivePair pair, int pair_ind, int location,
				BDD new_bdd, Memory new_memory) {
			assert this.indices[pair_ind] == pair : "Wrong index!";
			if (location == this.length)
				extend_size();

			this.bdd_mem[pair_ind][location] = new_bdd;
			if (this.size == 1)
				assert new_memory.blank();
			else
				this.recursive_mem[pair_ind][location] = new_memory;
		}

		// Check when a memory is blank
		public boolean blank() {
			return this.size == 0 && this.length == 0;
		}

		// Return the size of the first dimension
		public int size() {
			return this.size;
		}

		// Find the location (rank) of a target according to a permutation.
		// We are searching for an intersection of the target with the memory.
		// The matching find_contained should be implemented for dual games.
		// This is done by recursive analysis.
		// The returned value is whether found or not.
		// The location is updated to the found location.
		public boolean find_intersect(BDD target, Permutation perm,
				Permutation loc) {
			return recursive_find_intersect(target, perm, loc, 0);
		}

		// The recursive analysis of the rank.
		// target - the thing to be found in the memory
		// permutation - return the ranking according to this permutation
		// location - return the ranking in this variable
		// ind - how far are we in the recursion
		//
		// 1. If the target is an r state of the current stage of the recursion,
		// then it's current rank is 0
		// and the rest of the rank is not important.
		// 2. If the target is not an r state then we search the memory until we
		// find an intersection.
		// We update the current location to where we found the intersection and
		// call
		// recursively (if possible) to find the location of the following
		// locations.
		public boolean recursive_find_intersect(BDD target, Permutation perm,
				Permutation loc, int ind) {
			if (!target.and(this.indices[perm.perm[ind]].getGuarantee())
					.isZero()) {
				assert !target.and(this.bdd_mem[perm.perm[ind]][0]).isZero() : "Something is wrong with the way I understand the strategy!";
				loc.perm[ind] = 0;
			} else {
				int l = 0;
				while (target.and(this.bdd_mem[perm.perm[ind]][l]).isZero()
						&& l < this.length) {
					++l;
				}
				if (l == this.length)
					return false;
				loc.perm[ind] = l;
				if (ind < this.size - 1)
					return recursive_find_intersect(target, perm, loc, ind + 1);
			}
			return true;
		}

		// Find the strategy successor that matches a current state and a
		// target.
		// NOTICE - if current is a set of states it is interpreted
		// existentially!!!
		// We are searching for an intersection of the target with the memory in
		// a location that
		// is better than the location of the current state.
		// The matching next_contained should be implemented for dual games.
		// This is done by recursive analysis.
		// The returned value is the intersection of the memory and the target.
		public BDD next_intersect(BDD current, BDD target, Permutation perm,
				Permutation loc) {
			return recursive_next_intersect(current, target, perm, loc, 0);
		}

		// The recursive finding of a successor that matches a current state and
		// a target.
		// current - the current state
		// target - a set containing the next state
		// permutation - the successor should be better according to this
		// permutation
		// it is updated to the permutation according to which the next state
		// should continue the strategy (if at all)
		// location - the rank of current according to permutation
		// ind - how far are we in the recursion
		//
		// 1. If the current is an r-state of the current stage of the
		// recursion, then the permutation is increased,
		// and the target should preserve the ranking according to previous
		// stages of the recursion and be the minimal
		// in this level of the recursion for the next permutation.
		// 2. If the current is not an r-state of current stage of recursion,
		// then permutation remains the same.
		// We search for the lowest place (that is at most as bad as location of
		// current) where the target appears.
		// If we can reduce the ranking in current level then we do it.
		// If we cannot reduce the ranking in current level then current cannot
		// be a g-state.
		// When we do not reduce the ranking we try to continue recursively.
		// The returned value is the intersection of the memory with the target.
		public BDD recursive_next_intersect(BDD current, BDD target,
				Permutation perm, Permutation loc, int ind) {
			if (!current.and(this.indices[perm.perm[ind]].getGuarantee())
					.isZero()) {
				assert !current.and(this.bdd_mem[perm.perm[ind]][0]).isZero() : "Something is very wrong with the way I understand strategy (g)!";
				perm.increase(ind);
				int l = 0;
				BDD temp = target.and(this.bdd_mem[perm.perm[ind]][l++]);
				while (temp.isZero())
					temp = target.and(this.bdd_mem[perm.perm[ind]][l++]);
				return temp;
			} else {
				BDD temp = Env.FALSE();
				int l = 0;
				for (; l <= loc.perm[ind]; ++l) {
					temp = target.and(this.bdd_mem[perm.perm[ind]][l]);
					if (!temp.isZero())
						break;
				}
				if (temp.isZero())
					return Env.FALSE();

				if (l < loc.perm[ind])
					return temp;
				if (l == loc.perm[ind]) {
					assert (current
							.and(this.indices[perm.perm[ind]].getAssum())
							.isZero()) : "Something is very wrong with the way I understand strategy (r)!";
					if (ind < this.size - 1)
						return recursive_next_intersect(current, target, perm,
								loc, ind + 1);
					else
						return temp;
				} else
					return Env.FALSE();
			}
		}

		// The dual of the above - not implemented
		public BDD next_contained(BDD target) {
			assert false : "not implemented yet!";
			return this.bdd_mem[0][0];
		}

		// Increase the size of the second dimension of the array.
		// BDDs are initialized to false, to allow for finding.
		private void extend_size() {
			BDD[][] target_bdd = new BDD[this.size][this.length + increase];
			Memory[][] target_mem;
			if (this.size > 1)
				target_mem = new Memory[this.size][this.length + increase];
			else
				target_mem = new Memory[0][0];

			for (int i = 0; i < this.size; ++i) {
				for (int j = 0; j < this.length; ++j) {
					target_bdd[i][j] = this.bdd_mem[i][j];
					if (this.size > 1)
						target_mem[i][j] = this.recursive_mem[i][j];
				}
				for (int j = this.length; j < this.length + increase; ++j)
					target_bdd[i][j] = Env.FALSE();
			}
			this.bdd_mem = target_bdd;
			if (this.size > 1)
				this.recursive_mem = target_mem;
			this.length += increase;
		}

		/*
		 * // Obsolete, should probably be removed. // Extending the size
		 * separately for the bdd and the recursive memory // It does not make
		 * much sense to do it separately. private void extend_size_bdd (){
		 * BDD[][] res; res = new BDD[size][length+increase]; for (int i = 0; i
		 * < size; ++i) { for (int j = 0; j < length; ++j) { res[i][j] =
		 * bdd_mem[i][j]; } } bdd_mem = res; }
		 * 
		 * private void extend_size_mem () { if (size <=1) return; Memory[][]
		 * res = new Memory[size][length + increase]; for (int i=0 ; i<size;
		 * ++i) { for (int j=0; j<length; ++j) { res[i][j] =
		 * recursive_mem[i][j]; } } recursive_mem = res; }
		 */
	}

	private class MyPair {
		public BDD bdd;
		public Memory mem;

		public MyPair(BDD bdd, Memory mem) {
			this.bdd = bdd;
			this.mem = mem;
		}
	}

}
