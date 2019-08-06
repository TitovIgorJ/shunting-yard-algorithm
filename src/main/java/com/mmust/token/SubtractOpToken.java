package com.mmust.token;

public class SubtractOpToken extends OperatorToken {

	public SubtractOpToken() {
		super("-");
	}

	@Override
	public double eval(double op1, double op2) {
		return op1 - op2;
	}

	@Override
	public int getPrecedence() {
		return 2;
	}

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
