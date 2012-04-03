package edu.wis.jtlv.env.core.spec;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;


public class InitSpec {
	// change the assert to SpecParseInternalException....

	// ////////////////////////////////////////////////////////////////////////
	// all mk's are sorted by their order of parsing in SPC.g. ////////////////
	// ////////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////
	// prop ///////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////
	// helper ///////////////////////////////////
	// //////////////////////////////////////////
	private static InternalSpec mk_simple_binary_node(TokenStream input, Token start, String exp_str,
			InternalOp op, InternalSpec l, InternalSpec r) throws SpecParseException {
		assert op.isProp();
		if (!l.hasTemporalOperators() & !r.hasTemporalOperators())
			return new InternalSpecBDD(exp_str, start);
		// if (!l.hasTemporalOperators())
		// l = new SpecBDD(exp_str);
		// if (!r.hasTemporalOperators())
		// r = new SpecBDD(exp_str);
		// otherwise, someone has temporal.
		return new InternalSpecExp(exp_str, op, l, r, start);
	}

	private static InternalSpec mk_simple_unary_node(TokenStream input, Token start, String exp_str,
			InternalOp op, InternalSpec v) throws SpecParseException {
		assert op.isProp();
		if (!v.hasTemporalOperators())
			return new InternalSpecBDD(exp_str, start);
		return new InternalSpecExp(exp_str, op, v, start);
	}

	// //////////////////////////////////////////
	// //////////////////////////////////////////
	// //////////////////////////////////////////

	public static InternalSpec mk_imply(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_simple_binary_node(input, start, exp_str, InternalOp.IMPLIES, l, r);
	}

	public static InternalSpec mk_iff(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_simple_binary_node(input, start, exp_str, InternalOp.IFF, l, r);
	}

	public static InternalSpec mk_or(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_simple_binary_node(input, start, exp_str, InternalOp.OR, l, r);
	}

	public static InternalSpec mk_xor(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_simple_binary_node(input, start, exp_str, InternalOp.XOR, l, r);
	}

	public static InternalSpec mk_xnor(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_simple_binary_node(input, start, exp_str, InternalOp.XNOR, l, r);
	}

	public static InternalSpec mk_and(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_simple_binary_node(input, start, exp_str, InternalOp.AND, l, r);
	}

	public static InternalSpec mk_not(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_simple_unary_node(input, start, exp_str, InternalOp.NOT, v);
	}

	// ////////////////////////////////////////////////////////////////////////
	// temporal ///////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////
	// helper ///////////////////////////////////
	// //////////////////////////////////////////
	private static InternalSpec mk_triplet_temporal_op(TokenStream input, Token start, String exp_str,
			InternalOp op, InternalSpec l, InternalSpec m, InternalSpec r) throws SpecParseException {
		assert (op.isTemporalOp());
		return new InternalSpecExp(exp_str, op, l, m, r, start);
	}

	private static InternalSpec mk_binary_temporal_op(TokenStream input, Token start, String exp_str,
			InternalOp op, InternalSpec l, InternalSpec r) throws SpecParseException {
		assert (op.isTemporalOp());
		return new InternalSpecExp(exp_str, op, l, r, start);
	}

	private static InternalSpec mk_unary_temporal_op(TokenStream input, Token start, String exp_str,
			InternalOp op, InternalSpec v) throws SpecParseException {
		assert (op.isTemporalOp());
		return new InternalSpecExp(exp_str, op, v, start);
	}

	// //////////////////////////////////////////
	// //////////////////////////////////////////
	// //////////////////////////////////////////

	// //////////////////
	// LTL binary
	public static InternalSpec mk_until(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.UNTIL, l, r);
	}

	public static InternalSpec mk_since(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.SINCE, l, r);
	}

	public static InternalSpec mk_releases(TokenStream input, Token start, String exp_str, InternalSpec l,
			InternalSpec r) throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.RELEASES, l, r);
	}

	public static InternalSpec mk_triggered(TokenStream input, Token start, String exp_str, InternalSpec l,
			InternalSpec r) throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.TRIGGERED, l, r);
	}

	// //////////////////
	// LTL unary
	public static InternalSpec mk_next(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.NEXT, v);
	}

	public static InternalSpec mk_prev(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.PREV, v);
	}

	public static InternalSpec mk_notprevnot(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.NOT_PREV_NOT, v);
	}

	public static InternalSpec mk_globally(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.GLOBALLY, v);
	}

	public static InternalSpec mk_historically(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.HISTORICALLY, v);
	}

	public static InternalSpec mk_finally(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.FINALLY, v);
	}

	public static InternalSpec mk_once(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.ONCE, v);
	}

	// //////////////////
	// CTL unary
	public static InternalSpec mk_EX(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.EX, v);
	}

	public static InternalSpec mk_AX(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.AX, v);
	}

	public static InternalSpec mk_EF(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.EF, v);
	}

	public static InternalSpec mk_AF(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.AF, v);
	}

	public static InternalSpec mk_EG(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.EG, v);
	}

	public static InternalSpec mk_AG(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		return mk_unary_temporal_op(input, start, exp_str, InternalOp.AG, v);
	}

	// //////////////////
	// RT-CTL binary
	public static InternalSpec mk_AU(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.AU, l, r);
	}

	// to avoid conflicts in parsing of ctl-star, we need to check consistency
	// after construction.
	public static InternalSpec mk_AU(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		if (!(v instanceof InternalSpecExp))
			throw new SpecParseException("Operator 'A' most be followed by "
					+ "'U' or 'BU'", input, start, null);
		InternalSpecExp vse = (InternalSpecExp) v;
		if (vse.getOperator() != InternalOp.UNTIL)
			throw new SpecParseException("Operator 'A' most be followed by "
					+ "'U' or 'BU'", input, start, null);
		InternalSpec[] children = vse.getChildren();
		return mk_AU(input, start, exp_str, children[0], children[1]);
	}

	public static InternalSpec mk_EU(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.EU, l, r);
	}

	// to avoid conflicts in parsing of ctl-star, we need to check consistency
	// after construction.
	public static InternalSpec mk_EU(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		if (!(v instanceof InternalSpecExp))
			throw new SpecParseException("Operator 'E' most be followed by "
					+ "'U' or 'BU'", input, start, null);
		InternalSpecExp vse = (InternalSpecExp) v;
		if (vse.getOperator() != InternalOp.UNTIL)
			throw new SpecParseException("Operator 'E' most be followed by "
					+ "'U' or 'BU'", input, start, null);
		InternalSpec[] children = vse.getChildren();
		return mk_EU(input, start, exp_str, children[0], children[1]);
	}

	// //////////////////
	// RT-CTL triplet
	public static InternalSpec mk_ABU(TokenStream input, Token start, String exp_str, InternalSpec l,
			InternalSpecCTLRange m, InternalSpec r) throws SpecParseException {
		return mk_triplet_temporal_op(input, start, exp_str, InternalOp.ABU, l, m, r);
	}

	public static InternalSpec mk_EBU(TokenStream input, Token start, String exp_str, InternalSpec l,
			InternalSpecCTLRange m, InternalSpec r) throws SpecParseException {
		return mk_triplet_temporal_op(input, start, exp_str, InternalOp.EBU, l, m, r);
	}

	// //////////////////
	// RT-CTL binary
	public static InternalSpec mk_EBF(TokenStream input, Token start, String exp_str, InternalSpecCTLRange l,
			InternalSpec r) throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.EBF, l, r);
	}

	public static InternalSpec mk_ABF(TokenStream input, Token start, String exp_str, InternalSpecCTLRange l,
			InternalSpec r) throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.ABF, l, r);
	}

	public static InternalSpec mk_EBG(TokenStream input, Token start, String exp_str, InternalSpecCTLRange l,
			InternalSpec r) throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.EBG, l, r);
	}

	public static InternalSpec mk_ABG(TokenStream input, Token start, String exp_str, InternalSpecCTLRange l,
			InternalSpec r) throws SpecParseException {
		return mk_binary_temporal_op(input, start, exp_str, InternalOp.ABG, l, r);
	}

	// ////////////////////////////////////////////////////////////////////////
	// prop - no parse tree (relational and some others) //////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////
	// helper ///////////////////////////////////
	// //////////////////////////////////////////
	private static void check_no_temporal_operand(TokenStream input, Token start,
			String op_str, InternalSpec l, InternalSpec r) throws SpecParseException {
		if (l.hasTemporalOperators() | r.hasTemporalOperators()) {
			String tl_spec = l.hasTemporalOperators() ? l.toString() : r
					.toString();
			throw new SpecParseException("Cannot evaluate operator '" + op_str
					+ "' on a TL spec operand:\n" + tl_spec, input, start, null);
		}
	}

	private static InternalSpec mk_smv_exp(TokenStream input, Token start, String exp_str,
			String op_str, InternalSpec l, InternalSpec r) throws SpecParseException {
		// trying to catch errors first
		check_no_temporal_operand(input, start, op_str, l, r);
		// then constructing this Spec....
		// return mk_node(input, start, exp_str, null, l, r);
		// or, a shortcut:
		return new InternalSpecBDD(exp_str, start);
	}

	// for 'subrange' and 'set_list', we do not need to do a check (the parse
	// won't let temporal exps get into that expressions)
	private static InternalSpec mk_no_check(TokenStream input, Token start, String exp_str)
			throws SpecParseException {
		return new InternalSpecBDD(exp_str, start);
	}

	// //////////////////////////////////////////
	// //////////////////////////////////////////
	// //////////////////////////////////////////

	public static InternalSpec mk_eq(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "=", l, r);
	}

	public static InternalSpec mk_neq(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "!=", l, r);
	}

	public static InternalSpec mk_lt(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "<", l, r);
	}

	public static InternalSpec mk_gt(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, ">", l, r);
	}

	public static InternalSpec mk_le(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "<=", l, r);
	}

	public static InternalSpec mk_ge(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, ">=", l, r);
	}

	public static InternalSpec mk_setin(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "in", l, r);
	}

	public static InternalSpec mk_union(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "union", l, r);
	}

	// ////////////
	// no need for check since the parsing itself won't allow it.
	public static InternalSpec mk_set(TokenStream input, Token start, String exp_str)
			throws SpecParseException {
		return mk_no_check(input, start, exp_str);
	}

	// no need for check since the parsing itself won't allow it.
	public static InternalSpec mk_range(TokenStream input, Token start, String exp_str)
			throws SpecParseException {
		return mk_no_check(input, start, exp_str);
	}

	// ////////////

	public static InternalSpec mk_lshift(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "<<", l, r);
	}

	public static InternalSpec mk_rshift(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, ">>", l, r);
	}

	public static InternalSpec mk_mod(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "mod", l, r);
	}

	public static InternalSpec mk_plus(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "+", l, r);
	}

	public static InternalSpec mk_minus(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "-", l, r);
	}

	public static InternalSpec mk_times(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "*", l, r);
	}

	public static InternalSpec mk_divide(TokenStream input, Token start, String exp_str, InternalSpec l, InternalSpec r)
			throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "/", l, r);
	}

	public static InternalSpec mk_concatenation(TokenStream input, Token start, String exp_str,
			InternalSpec l, InternalSpec r) throws SpecParseException {
		return mk_smv_exp(input, start, exp_str, "::", l, r);
	}

	public static InternalSpec mk_unary_minus(TokenStream input, Token start, String exp_str, InternalSpec v)
			throws SpecParseException {
		if (v.hasTemporalOperators())
			throw new SpecParseException("Cannot evaluate operator '-"
					+ "' on a TL spec operand:\n" + v.toString(), input, start, null);
		return new InternalSpecBDD(exp_str, start);
	}

	// no need for check references.
	public static InternalSpec mk_ref(TokenStream input, Token start, String exp_str)
			throws SpecParseException {
		return mk_no_check(input, start, exp_str);
	}

	// ////////////////////////////////////////////////////////////////////////
	// deleted ////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
}
