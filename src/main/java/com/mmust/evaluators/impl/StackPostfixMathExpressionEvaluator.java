package com.mmust.evaluators.impl;

import com.mmust.token.Token;
import com.mmust.evaluators.PostfixEvaluator;
import com.mmust.token.Operator;
import com.mmust.token.NumToken;
import com.mmust.token.Number;

import java.util.Deque;
import java.util.LinkedList;

public class StackPostfixMathExpressionEvaluator implements PostfixEvaluator {

	@Override
	public double eval(Iterable<Token> postfixExpr) {
		Deque<Token> stack = new LinkedList<>();

		for (Token t : postfixExpr) {
			switch (t.getType()) {
				case NUMBER:
					stack.push(t);
					break;

				case OPERATOR:
					Number op2 = (Number) stack.pop();
					Number op1 = (Number) stack.pop();

					Operator evaluator = (Operator) t;

					double result = evaluator.eval(op1.val(), op2.val());

					stack.push(new NumToken(result));
					break;
			}
		}

		Number result = (Number) stack.pop();

		return result.val();
	}
}
