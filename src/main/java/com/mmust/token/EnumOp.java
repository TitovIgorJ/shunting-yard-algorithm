package com.mmust.token;

public enum EnumOp implements Token, Operator {
	PLUS;

	private String rawValue;

	@Override
	public TokenType getType() {
		return TokenType.OPERATOR;
	}

	@Override
	public String getRawValue() {
		return rawValue;
	}

	@Override
	public double eval(double op1, double op2) {
		return 0;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

	@Override
	public Associativity getAssociativity() {
		return null;
	}
}
