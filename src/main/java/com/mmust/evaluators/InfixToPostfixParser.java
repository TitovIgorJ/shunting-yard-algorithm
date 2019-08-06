package com.mmust.evaluators;

import com.mmust.token.Token;

public interface InfixToPostfixParser {

	Iterable<Token> parse(Iterable<Token> infixExpression);
}
