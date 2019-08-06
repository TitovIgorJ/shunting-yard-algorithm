package com.mmust.tokenizer;

import com.mmust.token.*;

import java.util.Iterator;

import static java.lang.String.valueOf;

public class Tokenizer implements Iterable<Token> {

	private char[] data;

	public Tokenizer(String expression) {
		this.data = expression.toCharArray();
	}

	private Token parseToken(char c) {
		Token token;
		if (c == '(') {
			token = Parenthesis.LEFT;
		} else if (c == ')') {
			token = Parenthesis.RIGHT;
		} else if (Character.isDigit(c)) {
			token = new NumToken(valueOf(c));
		} else if (c == '+') {
			token = new AdditionOpToken();
		} else if (c == '-') {
			token = new SubtractOpToken();
		} else if (c == '*') {
			token = new MultiplicationOp();
		} else if (c == '/') {
			token = new DivisionOpToken();
		} else {
			throw new IllegalArgumentException(String.format("Can't recognize token type, token = [%s]", c));
		}
		return token;
	}

	@Override
	public Iterator<Token> iterator() {
		return new Itr();
	}

	private class Itr implements Iterator<Token> {
		private int pos = 0;

		@Override
		public boolean hasNext() {
			return pos < data.length;
		}

		@Override
		public Token next() {
			return parseToken(data[pos++]);
		}
	}
}
