package com.mmust.token;

public enum Operators implements Token, Operator {
	PLUS("+", 2, Associativity.LEFT, (double op1, double op2) -> op1 + op2),
	MINUS("-", 2, Associativity.LEFT, (double op1, double op2) -> op1 - op2),
	DIV("/", 3, Associativity.LEFT, (double op1, double op2) -> op1 / op2),
	MULTIPLY("*", 3, Associativity.LEFT, (double op1, double op2) -> op1 * op2);

	private String rawValue;
	private int precedence;
	private Associativity associativity;
	private Evaluator evaluator;

	Operators(String rawValue, int precedence, Associativity associativity, Evaluator evaluator) {
		this.rawValue = rawValue;
		this.precedence = precedence;
		this.associativity = associativity;
		this.evaluator = evaluator;
	}

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
		return evaluator.eval(op1, op2);
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public Associativity getAssociativity() {
		return associativity;
	}
}
