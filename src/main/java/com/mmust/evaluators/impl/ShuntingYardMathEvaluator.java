package com.mmust.evaluators.impl;

import com.mmust.evaluators.InfixToPostfixParser;
import com.mmust.evaluators.MathEvaluator;
import com.mmust.evaluators.PostfixEvaluator;
import com.mmust.token.Token;
import com.mmust.tokenizer.Tokenizer;

public class ShuntingYardMathEvaluator implements MathEvaluator {

	private InfixToPostfixParser infixToPostfixParser = new ShuntingYardInfixToPostfixParser();
	private PostfixEvaluator postfixEvaluator = new StackPostfixMathExpressionEvaluator();

	@Override
	public double eval(String infixExpression) {
		Tokenizer tokenizer = new Tokenizer(infixExpression);
		Iterable<Token> postfixExpression = infixToPostfixParser.parse(tokenizer);
		return postfixEvaluator.eval(postfixExpression);
	}
}
