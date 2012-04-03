package edu.wis.jtlv.old_lib.games;

import java.util.Set;

import net.sf.javabdd.BDD;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.old_lib.games.RkGame;
import edu.wis.jtlv.old_lib.games.RkGame.ImplicationEntity;

/**
 * <p>
 * This class is intended to serve as the data structure for holding BDDs in the recursive game (Streett game).
 * It also harvests this data structure for the strategy.
 * </p>
 * 
 * <p>
 * The idea of the data structure is as follows.
 * Upon creation, the structure gets a set of fairness numbers.
 * Per fairness number we have a vector of BDDs with each entry in this vector, there is also 
 * an associated recursive pointer to the same substructure.
 * </p>
 * 
 * <p>
 * At the moment only existential strategy is implemented.
 * This matches a situation where the environment makes the first move and the system has to answer it.
 * The idea of the strategy is as follows:
 * 1. If the current state is a r state, then the permutation is increased to the next permutation 
 *    and the successor is set to the minimal possible successor according to the next permutation.
 * 2. If the current state is not an r state, then the permutation remains the same permutation in this level
 *    We either a. Reduce the ranking in this level, or
 *              b. Remain in the same rank in this level, make sure that we are not a g-state 
 *                 and call recursively for the strategy to handle the next levels.
 * 3. At the bottom of the recursion, if we are not in all the g's of all the pairs, then
 *    the ranking can remain the same and we just choose some successor.
 *    
 * @version {@value edu.wis.jtlv.env.Env#version}
 * @author Nir Piterman <firstname.lastname@doc.ic.ac.uk>
 * 
 */
public class Memory {

	// A permutation is a sequence of integers.
	// We have a strange representation
	// The 1st integer is a number in 0..(n-1)
	// The 2nd integer is a number in 0..(n-2) telling us which of the remaining numbers is chosen
	// The i-th integer is a number in 0..(n-i) telling us which of the remaining numbers is chosen
	// The n-th integer is always 0 there is no more choice here ...
	// For example: the permutation 0123 is represented by 0000
	//              the permutation 3210 is represented by 3210
	//              the permutation 1032 is represented by 1010
	//                                          the 1 in {0,1,2,3}
	//                                          the 0 is {0,2,3}
	//                                          the 1 in {2,3}
	//                                          the 0 in {2}
	//              the permutation 2103 is represented by 2100 
	//                                          the 2 in {0,1,2,3}
	//                                          the 1 is {0,1,3}
	//                                          the 0 in {0,3}
	//                                          the 0 in {3}
	// In particular, the last entry is always 0.
	// NOTICE:
	// A permutation is also used to represent a ranking.
	// This is just an ordered tuple of integers.
	// In this case, the integers refer to the number of iterations of the least fixpoint in a given
	// level of the recursion
	public static class Permutation {
		// The permutation - an array of integers
		public int [] perm;
		// The size of the array
		public int size;
		
		// Initialize the permutation to a given size
		public Permutation(int size) {
			this.perm = new int[size];
			this.size=size;
		}
		
		// Copy a permutation
		public void copy(Permutation source) {
			assert source.size == this.size : "Copying permutations of different sizes";
			for (int i=0 ; i<this.size ; ++i) 
				this.perm[i] = source.perm[i];
		}
		
		// The order of permutations is the lexicographical ordering.
		// We increase a permutation in a given location (loc).
		// This is done by:
		// 1. If the location to be increased holds the maximal pair that is remaining
		//    then the location is reduced to 0.
		// 2. If the location to be increased is not the maximal pair that is remaining
		//    then the location is increased by 1.
		// The rest of the permutation is set to 0 (i.e., the rest of the pairs are set
		// to the fixed order of increasing numbers).
		public void increase(int loc) {
			assert loc < size : "Cannot increase a non-existent size";
			if (this.perm[loc]==size-loc-1)
				this.perm[loc]=0;
			else
				++(this.perm[loc]);
			for (int i=loc+1 ; i<size ; ++i) 
				this.perm[i]=0;
		}
		
		// When two permutations are equal
		public boolean equals(Object other) {
			if (other.getClass()!=this.getClass())
				return false;
			Permutation temp = (Permutation) other;
			if (temp.size != this.size)
				return false;
			for (int i=0 ; i<this.size ; ++i) 
				if (temp.perm[i] != this.perm[i]) 
					return false;
				
			return true;
		}
		
		// Output the permutation to a String.
		// There could be a nicer output that computes the actual number of pair that
		// matches a given location.
		public String toString() {
			String res="<";
			for (int i=0 ; i<this.size ; ++i) 
				res += this.perm[i];
			res += ">";
			return res;
		}
	} // end of permutation class.
	
	
	// The amount of increase in chunks of BDDs.
	private static final int increase=20; 

	// All the different arrays agree on the size of the first dimension.
	// This dimension is of the size size.
	// The second dimension grows according to the need.
	// It is intended to hold as many BDDs as needed.
	// The structure of bdd_mem and recursive_mem should develop simultaneously
	// In the bdd_mem[i][j] we have the BDD whose structure is recursively decomposed
	// by recursive_mem[i][j]
	
	// The size of the first dimension
	private int    size;
	// The size of the second dimension
	private int    length;
	// The ordered Streett pairs
	private RkGame.ImplicationEntity [] indices;
	// The BDDs
	private BDD    [][] bdd_mem;
	// The recursive decomposition of the BDDs
	private Memory [][] recursive_mem;
	
	// An empty memory (required for stopping the recursion).
	public Memory()
	{
		this.size = 0;
		this.length = 0;
	}
	
	// A memory initizlized with a set of Streett pairs.
	// We copy the set of Streett pairs
	// And initialize the BDD memory and the recursive memory.
	// The BDDs are initialized to FALSE - this is important for searching the location
	//                                     of states in the memory. At the worst case,
	//                                     we search also in uninitialized locations.
	public Memory(Set<RkGame.ImplicationEntity> pairs) {
		this.size=pairs.size();
		this.indices = new RkGame.ImplicationEntity[this.size];
		int i=0;
		for (ImplicationEntity entity : pairs) 
			indices[i++] = entity;

		this.bdd_mem = new BDD[this.size][increase];
		for (int j=0 ; j<this.size ; ++j)
			for (int k=0 ; k<increase ; ++k)
				this.bdd_mem[j][k]=Env.FALSE();
		
		this.length = increase;
		if (this.size > 1)
			this.recursive_mem = new Memory[this.size][increase];                    	
	}

	// Translate a pair to its location in the 1st dimension in the 
	// memory.
	public int local_index(RkGame.ImplicationEntity pair) {
		for (int i=0 ; i < this.size ; ++i) {
			if (pair == this.indices[i])
				return i;
		}
		return -1;
	}
	
	// Add a BDD new_bdd and it's corresponding decomposition new_memory.
	// The new values are added in the location location.
	// The dimension is set by pair_ind and it is checked to match the pair.
	// When extra size is required the arrays are increased in size.
	public void insert(RkGame.ImplicationEntity pair,int pair_ind, int location, BDD new_bdd,Memory new_memory) {
		assert this.indices[pair_ind] == pair : "Wrong index!";
		if (location == this.length) 
			extend_size();
		
		this.bdd_mem[pair_ind][location] = new_bdd;
		if (this.size==1) 
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
	public boolean find_intersect(BDD target,Permutation perm, Permutation loc) {
		return recursive_find_intersect(target,perm,loc,0);
	}
	
	// The recursive analysis of the rank.
	// target - the thing to be found in the memory
	// permutation - return the ranking according to this permutation
	// location - return the ranking in this variable
	// ind - how far are we in the recursion
	//
	// 1. If the target is an r state of the current stage of the recursion, then it's current rank is 0
	//    and the rest of the rank is not important.
	// 2. If the target is not an r state then we search the memory until we find an intersection.
	//    We update the current location to where we found the intersection and call
	//    recursively (if possible) to find the location of the following locations.
	public boolean recursive_find_intersect(BDD target,Permutation perm,Permutation loc,int ind) {
		if (!target.and(this.indices[perm.perm[ind]].r).isZero()) {
			assert !target.and(this.bdd_mem[perm.perm[ind]][0]).isZero() : "Something is wrong with the way I understand the strategy!";
			loc.perm[ind]=0;
		}
		else {
			int l=0;
			while (target.and(this.bdd_mem[perm.perm[ind]][l]).isZero() && l<this.length) {
				++l;
			}
			if (l==this.length)
				return false;
			loc.perm[ind]=l;
			if (ind < this.size-1)
				return recursive_find_intersect(target,perm,loc,ind+1);
		}
		return true;
	}
	
	// Find the strategy successor that matches a current state and a target.
	// NOTICE - if current is a set of states it is interpreted existentially!!!
	// We are searching for an intersection of the target with the memory in a location that 
	// is better than the location of the current state.
	// The matching next_contained should be implemented for dual games.
	// This is done by recursive analysis.
	// The returned value is the intersection of the memory and the target.
	public BDD next_intersect(BDD current,BDD target,Permutation perm,Permutation loc) {
		return recursive_next_intersect(current,target,perm,loc,0);
	}

	// The recursive finding of a successor that matches a current state and a target.
	// current - the current state
	// target - a set containing the next state
	// permutation - the successor should be better according to this permutation
	//               it is updated to the permutation according to which the next state
	//               should continue the strategy (if at all)
	// location - the rank of current according to permutation
	// ind - how far are we in the recursion
	//
	// 1. If the current is an r-state of the current stage of the recursion, then the permutation is increased,
	//    and the target should preserve the ranking according to previous stages of the recursion and be the minimal
	//    in this level of the recursion for the next permutation.
	// 2. If the current is not an r-state of current stage of recursion, then permutation remains the same.
	//   We search for the lowest place (that is at most as bad as location of current) where the target appears.
	//    If we can reduce the ranking in current level then we do it.
	//    If we cannot reduce the ranking in current level then current cannot be a g-state.
	//    When we do not reduce the ranking we try to continue recursively.
	// The returned value is the intersection of the memory with the target.
	public BDD recursive_next_intersect(BDD current,BDD target, Permutation perm, Permutation loc, int ind) {
		if (!current.and(this.indices[perm.perm[ind]].r).isZero()) {
			assert !current.and(this.bdd_mem[perm.perm[ind]][0]).isZero() : "Something is very wrong with the way I understand strategy (g)!";
			perm.increase(ind);
			int l=0;
			BDD temp = target.and(this.bdd_mem[perm.perm[ind]][l++]);
			while (temp.isZero())
				 temp = target.and(this.bdd_mem[perm.perm[ind]][l++]);
			return temp;
		}
		else {
			BDD temp = Env.FALSE();
			int l=0;
			for (; l<=loc.perm[ind] ; ++l) {
				temp = target.and(this.bdd_mem[perm.perm[ind]][l]);
				if (!temp.isZero())
					break;
			}
			if (temp.isZero())
				return Env.FALSE();
			
			if (l<loc.perm[ind])
				return temp;
			if (l==loc.perm[ind]) {
				assert (current.and(this.indices[perm.perm[ind]].g).isZero()) : "Something is very wrong with the way I understand strategy (r)!";
				if (ind < this.size-1) 
					return recursive_next_intersect(current,target,perm,loc,ind+1);
				else
					return temp;
			}
			else 
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
		BDD [][] target_bdd = new BDD[this.size][this.length+increase];
		Memory [][] target_mem;
		if (this.size > 1)
			target_mem = new Memory[this.size][this.length+increase];
		else 
			target_mem = new Memory[0][0];
		
		for (int i = 0; i < this.size; ++i) {
			for (int j = 0; j < this.length; ++j) {
				target_bdd[i][j] = this.bdd_mem[i][j];
				if (this.size > 1) 
					target_mem[i][j] = this.recursive_mem[i][j];
			}
			for (int j = this.length; j<this.length+increase ; ++j)
				target_bdd[i][j] = Env.FALSE();
		}
		this.bdd_mem = target_bdd;
		if (this.size > 1)
			this.recursive_mem = target_mem;
		this.length += increase;
	}
	
	/*
	// Obsolete, should probably be removed.
	// Extending the size separately for the bdd and the recursive memory
	// It does not make much sense to do it separately.
	private void extend_size_bdd (){
		BDD[][] res;
		res = new BDD[size][length+increase];
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < length; ++j) {
				res[i][j] = bdd_mem[i][j];
			}
		}
		bdd_mem = res;
	}
	
	private void extend_size_mem () {
		if (size <=1)
			return;
		Memory[][] res = new Memory[size][length + increase];
		for (int i=0 ; i<size; ++i) {
			for (int j=0; j<length; ++j) {
				res[i][j] = recursive_mem[i][j];	
			}
		}
		recursive_mem = res;
	}
	*/
}
