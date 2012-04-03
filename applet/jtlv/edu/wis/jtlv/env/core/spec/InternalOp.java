package edu.wis.jtlv.env.core.spec;

public enum InternalOp {
	// UNARY............
	// Prop
	NOT,
	// LTL
	FINALLY, GLOBALLY, HISTORICALLY, NEXT, NOT_PREV_NOT, ONCE, PREV,
	// CTL
	EX, EF, EG, AX, AF, AG,

	// BINARY............
	// Prop
	AND, OR, XOR, XNOR, IFF, IMPLIES,
	// LTL
	RELEASES, SINCE, TRIGGERED, UNTIL,
	// CTL
	ABF, ABG, EBF, EBG, AU, EU,
	// TRIPLET............
	// Prop
	// LTL
	// CTL
	ABU, EBU;

	// Extra Prop - Binary
	// EQ, NEQ, LT, GT, LE, GE, SETIN, UNION, LSHIFT, RSHIFT, MOD, PLUS, MINUS,
	// TIMES, DIVIDE, CONCATENATION;

	// ////////////////////////////////////////////////////////////////////////
	// Groupings //////////////////////////////////////////////////////////////
	// number of operands...
	public static final InternalOp[] unaryOp = { NOT, FINALLY, GLOBALLY, HISTORICALLY,
			NEXT, NOT_PREV_NOT, ONCE, PREV, EX, EF, EG, AX, AF, AG };
	public static final InternalOp[] binaryOp = { AND, OR, XOR, XNOR, IFF, IMPLIES,
			RELEASES, SINCE, TRIGGERED, UNTIL, ABF, ABG, EBF, EBG, AU, EU };
	public static final InternalOp[] tripletOp = { ABU, EBU };

	// is it propositional, or TL operator.
	public static final InternalOp[] propOp = { NOT, AND, OR, XOR, XNOR, IFF, IMPLIES };
	public static final InternalOp[] FutureLTLOp = { FINALLY, GLOBALLY, NEXT, RELEASES,
			UNTIL };
	public static final InternalOp[] PastLTLOp = { HISTORICALLY, NOT_PREV_NOT, ONCE,
			PREV, SINCE, TRIGGERED };
	public static final InternalOp[] CTLOp = { EX, EF, EG, AX, AF, AG, ABF, ABG, EBF,
			EBG, AU, EU, ABU, EBU };
	public static final InternalOp[] RealTimeCTLOp = { ABF, ABG, EBF, EBG, ABU, EBU };

	private boolean in(InternalOp[] set) {
		for (InternalOp op : set)
			if (this == op)
				return true;
		return false;
	}

	// ////////////////////////////////////////////////////////////////////////

	public boolean isProp() {
		return this.in(propOp);
	}

	public boolean isLTLOp() {
		return this.in(FutureLTLOp) | this.in(PastLTLOp);
	}

	public boolean isFutureLTLOp() {
		return this.in(FutureLTLOp);
	}

	public boolean isPastLTLOp() {
		return this.in(PastLTLOp);
	}

	public boolean isCTLOp() {
		return this.in(CTLOp) | this.in(RealTimeCTLOp);
	}

	public boolean isRealTimeCTLOp() {
		return this.in(RealTimeCTLOp);
	}

	public boolean isTemporalOp() {
		return this.in(FutureLTLOp) | this.in(PastLTLOp) | this.in(CTLOp)
				| this.in(RealTimeCTLOp);
	}

	public boolean isUnary() {
		return this.in(unaryOp);
	}

	public boolean isBinary() {
		return this.in(binaryOp);
	}

	public boolean isTriplet() {
		return this.in(tripletOp);
	}

	public int numOfOperands() {
		if (this.in(unaryOp))
			return 1;
		if (this.in(binaryOp))
			return 2;
		if (this.in(tripletOp))
			return 3;
		return -1;
	}
	
	public String toString() {
		return super.toString();
	}
}
