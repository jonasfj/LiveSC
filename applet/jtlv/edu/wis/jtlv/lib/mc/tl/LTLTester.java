package edu.wis.jtlv.lib.mc.tl;

import java.util.HashMap;
import java.util.Set;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDException;
import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.ModuleBDDField;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.SMVModule;
import edu.wis.jtlv.env.spec.Operator;
import edu.wis.jtlv.env.spec.Spec;
import edu.wis.jtlv.env.spec.SpecBDD;
import edu.wis.jtlv.env.spec.SpecExp;
import edu.wis.jtlv.lib.mc.ModelCheckAlgException;

/**
 * <p>
 * Construct a tester for a given LTL specification.
 * </p>
 * 
 * @author yaniv sa'ar
 * 
 */
public class LTLTester {
	private static int tester_id = 0;
	private static int field_id = 0;

	private Spec root;
	private SMVModule tester;
	private HashMap<SpecExp, ModuleBDDField> spec2field = new HashMap<SpecExp, ModuleBDDField>();

	/**
	 * <p>
	 * Constructor for the tester.
	 * </p>
	 * 
	 * @param root_spec
	 *            The specification to construct tester for.
	 * @param isWeak
	 *            Whether to add initial or not.
	 * @throws ModelCheckAlgException
	 */
	public LTLTester(Spec root_spec, boolean isWeak)
			throws ModelCheckAlgException {
		this.root = root_spec;
		if ((root == null) || (!root.isLTLSpec()))
			throw new ModelCheckAlgException("Cannot construct a tester for"
					+ "specification: " + root);

		this.tester = new SMVModule("LTLTester_" + (++tester_id));
		createAuxVariable(root);
		constructModule(root, isWeak);
	}

	/**
	 * <p>
	 * Getter for the tester which where constructed from this specification.
	 * </p>
	 * 
	 * @return The tester which where constructed from this specification.
	 */
	public SMVModule getTester() {
		return this.tester;
	}

	/**
	 * <p>
	 * Returns a BDD variable representing the given specification in this
	 * tester.
	 * </p>
	 * 
	 * @param root
	 *            The specification.
	 * @return A BDD variable representing the given specification in this
	 *         tester.
	 * 
	 * @throws ModelCheckAlgException
	 *             When failed to find the cooresponding BDD variable.
	 */
	public BDD getSpec2BDD(Spec root) throws ModelCheckAlgException {
		if (root instanceof SpecBDD)
			return ((SpecBDD) root).getVal();
		// else it is SpecExp (cannot be a SpecCTLRange)
		SpecExp se = (SpecExp) root;
		Spec[] child = se.getChildren();
		Operator op = se.getOperator();

		if (op == Operator.NOT)
			return getSpec2BDD(child[0]).not();
		if (op == Operator.AND)
			return getSpec2BDD(child[0]).and(getSpec2BDD(child[1]));
		if (op == Operator.OR)
			return getSpec2BDD(child[0]).or(getSpec2BDD(child[1]));
		if (op == Operator.XOR)
			return getSpec2BDD(child[0]).xor(getSpec2BDD(child[1]));
		if (op == Operator.XNOR)
			return getSpec2BDD(child[0]).xor(getSpec2BDD(child[1])).not();
		if (op == Operator.IFF)
			return getSpec2BDD(child[0]).biimp(getSpec2BDD(child[1]));
		if (op == Operator.IMPLIES)
			return getSpec2BDD(child[0]).imp(getSpec2BDD(child[1]));
		if (op.isLTLOp()) {
			ModuleBDDField f = spec2field.get(root);
			if ((f != null) && (f.getDomain().size().intValue() == 2))
				return f.getDomain().ithVar(1);
		}
		// something is wrong
		throw new ModelCheckAlgException("Failed to find corresponding bdd"
				+ " to specification: " + root.toString());
	}

	private void createAuxVariable(Spec s) throws ModelCheckAlgException {
		if (!(s instanceof SpecExp))
			return;
		// else
		SpecExp se = (SpecExp) s;
		if (se.getOperator().isLTLOp()) {
			try {
				// String name = se.getOperator().toString() + "_"
				// + (++field_id);
				String name = "AUX[" + (++field_id) + "]";
				ModuleBDDField f = tester.addVar(name);
				spec2field.put(se, f);
			} catch (ModuleException e) {
				throw new ModelCheckAlgException("Failed naming the extra "
						+ "auxiliary fields");
			}
		}

		Spec[] children = se.getChildren();
		for (int i = 0; i < children.length; i++) {
			createAuxVariable(children[i]);
		}
	}

	private void constructModule(Spec root, boolean isWeak)
			throws ModelCheckAlgException {
		BDD p_c1, p_c2, p_aux;

		Set<SpecExp> specifications = spec2field.keySet();
		for (SpecExp spec : specifications) {
			try {
				Operator op = spec.getOperator();
				Spec[] child = spec.getChildren();
				BDD aux = getSpec2BDD(spec);
				int noo = op.numOfOperands();
				BDD c1 = (noo > 0) ? getSpec2BDD(child[0]) : null;
				BDD c2 = (noo > 1) ? getSpec2BDD(child[1]) : null;
				switch (op) {
				case NEXT:
					p_c1 = Env.prime(c1);
					tester.conjunctTrans(aux.biimp(p_c1));
					break;
				case FINALLY:
					p_aux = Env.prime(aux);
					tester.conjunctTrans(aux.biimp(c1.or(p_aux)));
					tester.addJustice(c1.or(aux.not()));
					break;
				case GLOBALLY:
					p_aux = Env.prime(aux);
					tester.conjunctTrans(aux.biimp(c1.and(p_aux)));
					tester.addJustice(c1.not().or(aux));
					break;
				case PREV:
					p_aux = Env.prime(aux);
					tester.addInitial(aux.not());
					tester.conjunctTrans(p_aux.biimp(c1));
					break;
				// no BEFORE
				case ONCE:
					p_c1 = Env.prime(c1);
					p_aux = Env.prime(aux);
					tester.addInitial(aux.biimp(c1));
					tester.conjunctTrans(p_aux.biimp(aux.or(p_c1)));
					break;
				case HISTORICALLY:
					p_c1 = Env.prime(c1);
					p_aux = Env.prime(aux);
					tester.addInitial(aux.biimp(c1));
					tester.conjunctTrans(p_aux.biimp(aux.and(p_c1)));
					break;
				case UNTIL:
					p_aux = Env.prime(aux);
					tester.conjunctTrans(aux.biimp(c2.or(c1.and(p_aux))));
					tester.addJustice(aux.not());
					break;
				case RELEASES:
					p_aux = Env.prime(aux);
					tester.conjunctTrans(aux.biimp(c2.or(c1.and(p_aux))));
					tester.addJustice(c1.not().and(c2.not()).or(aux));
					break;
				case SINCE:
					p_c1 = Env.prime(c1);
					p_c2 = Env.prime(c2);
					p_aux = Env.prime(aux);
					tester.addInitial(aux.biimp(c2));
					tester.conjunctTrans(p_aux.biimp(p_c2.or(p_c1.and(aux))));
					break;
				case TRIGGERED:
					p_c1 = Env.prime(c1);
					p_c2 = Env.prime(c2);
					p_aux = Env.prime(aux);
					tester.addInitial(aux.biimp(c1.or(c2)));
					tester.conjunctTrans(p_aux.biimp(p_c2.or(p_c1.and(aux))));
					break;
				// NOT_PREV_NOT,
				default:
					break;
				}
			} catch (ModuleException e) {
				throw new ModelCheckAlgException("Failed to construct BDD "
						+ "assertion for specification: " + spec.toString());
			} catch (BDDException e) {
				throw new ModelCheckAlgException("Failed to prime BDD "
						+ "assertion for specification: " + spec.toString());
			}
		}
		if (!isWeak) {
			try {
				tester.addInitial(getSpec2BDD(root).not());
			} catch (ModuleException e) {
				throw new ModelCheckAlgException(
						"Failed to add roots BDD assertion.");
			}
		}
	}
}
