package com.mmust.token;

public class NumToken extends BaseToken implements Number {

	public NumToken(String value) {
		super(value);
	}

	public NumToken(double num) {
		this(Double.toString(num));
	}

	@Override
	public double val() {
		return Double.parseDouble(getRawValue());
	}

	@Override
	public TokenType getType() {
		return TokenType.NUMBER;
	}
}
