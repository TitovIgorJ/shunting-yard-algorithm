package com.mmust.token;

public class DivisionOpToken extends OperatorToken {

	public DivisionOpToken() {
		super("/");
	}

	@Override
	public double eval(double op1, double op2) {
		return op1 / op2;
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
