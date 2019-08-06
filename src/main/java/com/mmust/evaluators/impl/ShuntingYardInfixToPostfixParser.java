package com.mmust.evaluators.impl;

import com.mmust.token.Token;
import com.mmust.evaluators.InfixToPostfixParser;

public class ShuntingYardInfixToPostfixParser implements InfixToPostfixParser {

	@Override
	public Iterable<Token> parse(Iterable<Token> infixExpression) {
		ShuntingYard shuntingYard = new ShuntingYard(infixExpression);
		return shuntingYard.doSorting();
	}
}
