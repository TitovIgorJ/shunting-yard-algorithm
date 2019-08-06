package com.mmust.token;

abstract class OperatorToken extends BaseToken implements Operator {

	OperatorToken(String value) {
		super(value);
	}

	@Override
	public TokenType getType() {
		return TokenType.OPERATOR;
	}
}
