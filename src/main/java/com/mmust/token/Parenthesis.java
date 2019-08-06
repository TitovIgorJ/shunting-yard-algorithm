package com.mmust.token;

public enum Parenthesis implements Token {

	LEFT(TokenType.LEFT_PARENTHESIS, "("),
	RIGHT(TokenType.RIGHT_PARENTHESIS, ")");

	private TokenType type;
	private String rawValue;

	Parenthesis(TokenType type, String rawValue) {
		this.type = type;
		this.rawValue = rawValue;
	}

	@Override
	public TokenType getType() {
		return type;
	}

	@Override
	public String getRawValue() {
		return rawValue;
	}
}
