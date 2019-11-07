package com.mmust.token;

public class MultiplicationOpToken extends OperatorToken {

	public MultiplicationOpToken() {
		super("*");
	}

	@Override
	public double eval(double op1, double op2) {
		return op1 * op2;
	}

	@Override
	public int getPrecedence() {
		return 3;
	}

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
