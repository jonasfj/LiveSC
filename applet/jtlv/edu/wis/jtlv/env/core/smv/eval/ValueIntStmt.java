package edu.wis.jtlv.env.core.smv.eval;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDDomain;
import net.sf.javabdd.BDDVarSet;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.core.smv.SMVParseException;
import edu.wis.jtlv.env.module.SMVModule;

public class ValueIntStmt extends ValueStmt {
	// each bdd most have at least one corresponding value (could be more...)
	private HashMap<BDD, Vector<Integer>> sat2val_vec;
	private BDD all_assigned_bdds;
	private BDDVarSet var_set;

	// a_var_set has to be the exact variable in use...
	public ValueIntStmt(SMVModule a_context, BDDVarSet a_var_set)
			throws SMVParseException {
		super(a_context);
		this.all_assigned_bdds = Env.FALSE().id();
		this.sat2val_vec = new HashMap<BDD, Vector<Integer>>(50);
		this.var_set = a_var_set;
	}

	// a_var_set has to be the exact variable in use...
	private ValueIntStmt(SMVModule a_context, BDDVarSet a_var_set,
			BDD an_all_assigned_bdds,
			HashMap<BDD, Vector<Integer>> a_sat2val_vec)
			throws SMVParseException {
		super(a_context);
		this.all_assigned_bdds = an_all_assigned_bdds;
		this.sat2val_vec = a_sat2val_vec;
		this.var_set = a_var_set;
	}

	@Override
	protected ValueIntStmt duplicate() throws SMVParseException {
		return new ValueIntStmt(this.context, this.var_set,
				this.all_assigned_bdds, this.sat2val_vec);
	}

	@Override
	public ValueBDDStmt toValueBDDStmt() throws SMVParseException {
		BDD res = Env.FALSE().id();
		for (BDD single : getAllBDDAssigned()) {
			Vector<Integer> val_vec = getValue(single);
			for (Integer val : val_vec) {
				if (val.intValue() == 0) {
					// is OK, but no disjunct is added
					// res = res.id().or(single.not());
				} else if (val.intValue() == 1) {
					res = res.id().or(single);
				} else {
					throw new SMVParseException("Cannot convert an integer "
							+ "into a BDD");
				}
			}
		}
		return new ValueBDDStmt(this.getContext(), res);
	}

	@Override
	public ValueIntStmt toValueIntStmt() throws SMVParseException {
		return this;
	}

	public ValueIntStmt toPrimeValueIntStmt() throws SMVParseException {
		BDDVarSet res_vset = Env.getEmptySet();
		for (BDDDomain dom : this.getBDDVarSet().getDomains()) {
			res_vset = res_vset.union(this.getContext().getVar(dom.toString(),
					true).prime().getDomain().set());
		}
		ValueIntStmt res = new ValueIntStmt(this.getContext(), res_vset);
		for (BDD single : this.getAllBDDAssigned()) {
			res.addValue(Env.prime(single), this.getValue(single));
		}
		return res;
	}

	@Override
	public ValueDomStmt toValueDomStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert integer value to domains");
	}

	@Override
	public ValueConsStmt toValueConsStmt() throws SMVParseException {
		throw new SMVParseException("Cannot convert integer value to constant");
	}

	@Override
	public BDD toBDD() throws SMVParseException {
		return this.toValueBDDStmt().toBDD();
	}

	@Override
	public boolean isValueIntStmt() {
		return true;
	}

	@Override
	public String elemToString() {
		String res = "";
		try {
			int[] vals = this.getAllIntValues();
			for (int i = 0; i < vals.length; i++) {
				res += ((i + 1) != vals.length) ? vals[i] + "," : vals[i];
			}
		} catch (SMVParseException e) {
			res = "Anonym";
		}
		return "<I#" + toNicerString(res) + ">";
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public void addValue(BDD single, Integer val) throws SMVParseException {
		if (single.satCount(this.var_set) > 1)
			throw new SMVParseException("Cannot assign an integer value to a "
					+ "non singleton BDD");
		this.all_assigned_bdds = this.all_assigned_bdds.id().or(single);
		if (this.sat2val_vec.containsKey(single)) {
			Vector<Integer> to_add = this.sat2val_vec.get(single);
			to_add.add(val);
		} else {
			Vector<Integer> to_add = new Vector<Integer>(3);
			to_add.add(val);
			this.sat2val_vec.put(single, to_add);
		}
		;
	}

	public void addValue(BDD single, Vector<Integer> val)
			throws SMVParseException {
		if (single.satCount(this.var_set) > 1)
			throw new SMVParseException("Cannot assign an integer value to a "
					+ "non singleton BDD");
		this.all_assigned_bdds = this.all_assigned_bdds.id().or(single);
		if (this.sat2val_vec.containsKey(single)) {
			Vector<Integer> to_add = this.sat2val_vec.get(single);
			to_add.addAll(val);
		} else {
			Vector<Integer> to_add = new Vector<Integer>(3);
			to_add.addAll(val);
			this.sat2val_vec.put(single, to_add);
		}
		;
	}

	public Vector<Integer> getValue(BDD single) throws SMVParseException {
		if (single.satCount(this.var_set) > 1)
			throw new SMVParseException("Cannot get an integer value from a "
					+ "non singleton BDD");
		return this.sat2val_vec.get(single); // could be null!!
	}

	public Integer[] getAllValues() throws SMVParseException {
		Vector<Integer> res_vec = new Vector<Integer>(20);
		for (Vector<Integer> val_entry : this.sat2val_vec.values()) {
			res_vec.addAll(val_entry);
		}
		Integer[] res = new Integer[res_vec.size()];
		res_vec.toArray(res);
		return res;
	}

	public int[] getAllIntValues() throws SMVParseException {
		Integer[] res_integers = getAllValues();
		int[] res = new int[res_integers.length];
		for (int i = 0; i < res_integers.length; i++) {
			res[i] = res_integers[i].intValue();
		}
		return res;
	}

	public Set<BDD> getAllBDDAssigned() {
		return this.sat2val_vec.keySet();
	}

	public BDDVarSet getBDDVarSet() {
		return this.var_set;
	}

	public BDD aboveIntToBDD(int val) {
		BDD res = Env.FALSE();
		for (BDD single : this.getAllBDDAssigned()) {
			try {
				for (Integer single_int : this.getValue(single)) {
					if (val < single_int.intValue()) {
						res = res.id().or(single);
						break;
					}
				}
			} catch (SMVParseException sme) {
				// do nothing
			}
		}
		return res;
	}

	public BDD belowIntToBDD(int val) {
		BDD res = Env.FALSE();
		for (BDD single : this.getAllBDDAssigned()) {
			try {
				for (Integer single_int : this.getValue(single)) {
					if (val > single_int.intValue()) {
						res = res.id().or(single);
						break;
					}
				}
			} catch (SMVParseException sme) {
				// do nothing
			}
		}
		return res;
	}

	public BDD intToBDD(int val) {
		BDD res = Env.FALSE();
		for (BDD single : this.getAllBDDAssigned()) {
			try {
				for (Integer single_int : this.getValue(single)) {
					if (val == single_int.intValue()) {
						res = res.id().or(single);
						break;
					}
				}
			} catch (SMVParseException sme) {
				// do nothing
			}
		}
		return res;
	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////

	public static ValueIntStmt PlusOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new PlusOp());
	}

	public static ValueIntStmt PlusOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new PlusOp());
	}

	public static ValueIntStmt PlusOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new PlusOp());
	}

	public static ValueIntStmt MinusOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new MinusOp());
	}

	public static ValueIntStmt MinusOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new MinusOp());
	}

	public static ValueIntStmt MinusOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new MinusOp());
	}

	public static ValueIntStmt TimesOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new MultOp());
	}

	public static ValueIntStmt TimesOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new MultOp());
	}

	public static ValueIntStmt TimesOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new MultOp());
	}

	public static ValueIntStmt DivOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new DivOp());
	}

	public static ValueIntStmt DivOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new DivOp());
	}

	public static ValueIntStmt DivOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new DivOp());
	}

	public static ValueIntStmt ModOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new ModOp());
	}

	public static ValueIntStmt ModOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new ModOp());
	}

	public static ValueIntStmt ModOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new ModOp());
	}

	public static ValueIntStmt EQOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new EQOp());
	}

	public static ValueIntStmt EQOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new EQOp());
	}

	public static ValueIntStmt EQOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new EQOp());
	}

	public static ValueIntStmt NEQOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new NEQOp());
	}

	public static ValueIntStmt NEQOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new NEQOp());
	}

	public static ValueIntStmt NEQOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new NEQOp());
	}

	public static ValueIntStmt LEOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new LEOp());
	}

	public static ValueIntStmt LEOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new LEOp());
	}

	public static ValueIntStmt LEOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new LEOp());
	}

	public static ValueIntStmt LTOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new LTOp());
	}

	public static ValueIntStmt LTOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new LTOp());
	}

	public static ValueIntStmt LTOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new LTOp());
	}

	public static ValueIntStmt GEOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new GEOp());
	}

	public static ValueIntStmt GEOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new GEOp());
	}

	public static ValueIntStmt GEOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new GEOp());
	}

	public static ValueIntStmt GTOp(ValueIntStmt first, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOp2(first, other, new GTOp());
	}

	public static ValueIntStmt GTOpWithCons(ValueIntStmt first, Integer cons)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(first, cons, new GTOp());
	}

	public static ValueIntStmt GTOpWithCons(Integer cons, ValueIntStmt other)
			throws SMVParseException {
		return ValueIntStmt.aritmaticOpWithCons(cons, other, new GTOp());
	}

	private static ValueIntStmt aritmaticOp2(ValueIntStmt first,
			ValueIntStmt other, BinOp op) throws SMVParseException {
		BDDVarSet new_var_set = first.getBDDVarSet()
				.union(other.getBDDVarSet());
		ValueIntStmt res = new ValueIntStmt(first.getContext(), new_var_set);
		for (BDD this_single : first.getAllBDDAssigned()) {
			for (BDD other_single : other.getAllBDDAssigned()) {
				BDD new_bdd_val = this_single.and(other_single);
				if (!new_bdd_val.isZero()) {
					for (Integer this_val : first.getValue(this_single)) {
						for (Integer other_val : other.getValue(other_single)) {
							Integer new_int_val = op.doOp(this_val, other_val);
							res.addValue(new_bdd_val, new_int_val);
						}
					}
				}
			}
		}
		return res;
	}

	private static ValueIntStmt aritmaticOpWithCons(ValueIntStmt first,
			Integer val, BinOp op) throws SMVParseException {
		BDDVarSet new_var_set = first.getBDDVarSet();
		ValueIntStmt res = new ValueIntStmt(first.getContext(), new_var_set);
		for (BDD this_single : first.getAllBDDAssigned()) {
			BDD new_bdd_val = this_single.id();
			if (!new_bdd_val.isZero()) {
				for (Integer this_val : first.getValue(this_single)) {
					Integer new_int_val = op.doOp(this_val, val);
					res.addValue(new_bdd_val, new_int_val);
				}
			}
		}
		return res;
	}

	private static ValueIntStmt aritmaticOpWithCons(Integer val,
			ValueIntStmt other, BinOp op) throws SMVParseException {
		BDDVarSet new_var_set = other.getBDDVarSet();
		ValueIntStmt res = new ValueIntStmt(other.getContext(), new_var_set);
		for (BDD other_single : other.getAllBDDAssigned()) {
			BDD new_bdd_val = other_single.id();
			if (!new_bdd_val.isZero()) {
				for (Integer other_val : other.getValue(other_single)) {
					Integer new_int_val = op.doOp(val, other_val);
					res.addValue(new_bdd_val, new_int_val);
				}
			}
		}
		return res;
	}

	// all operators
	private abstract static class BinOp {
		public abstract Integer doOp(Integer a, Integer b);
	}

	private static class PlusOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer(a.intValue() + b.intValue());
		}
	}

	private static class MinusOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer(a.intValue() - b.intValue());
		}
	}

	private static class MultOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer(a.intValue() * b.intValue());
		}
	}

	private static class DivOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer(a.intValue() / b.intValue());
		}
	}

	private static class ModOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer(a.intValue() % b.intValue());
		}
	}

	private static class EQOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer((a.intValue() == b.intValue()) ? 1 : 0);
		}
	}

	private static class NEQOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer((a.intValue() != b.intValue()) ? 1 : 0);
		}
	}

	private static class GTOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer((a.intValue() > b.intValue()) ? 1 : 0);
		}
	}

	private static class GEOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer((a.intValue() >= b.intValue()) ? 1 : 0);
		}
	}

	private static class LTOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer((a.intValue() < b.intValue()) ? 1 : 0);
		}
	}

	private static class LEOp extends BinOp {
		@Override
		public Integer doOp(Integer a, Integer b) {
			return new Integer((a.intValue() <= b.intValue()) ? 1 : 0);
		}
	}
}
