package com.mmust.evaluators.impl;

import com.mmust.token.Associativity;
import com.mmust.token.Operator;
import com.mmust.token.Token;
import com.mmust.token.TokenType;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class ShuntingYard {

	private Deque<Token> operatorStack = new LinkedList<>();
	private Queue<Token> outputQueue = new LinkedList<>();

	private Iterable<Token> infixExpression;

	ShuntingYard(Iterable<Token> infixExpression) {
		this.infixExpression = infixExpression;
	}

	Iterable<Token> doSorting() {
		for (Token token : infixExpression) {
			TokenType type = token.getType();
			if (type == TokenType.NUMBER) {
				outputQueue.add(token);
			} else if (type == TokenType.FUNCTION) {
				operatorStack.add(token);
			} else if (type == TokenType.OPERATOR) {
				Operator op = (Operator) token;
				while (
						isFunctionOnTop() || isHigherPriorityOpOnTop(op) || isLeftAssociativeAndEqualPriorityOpOnTop(op)
								&& !isLeftParenthesisOnTop()
				) {
					outputQueue.add(operatorStack.pop());
				}
				operatorStack.push(token);
			} else if (type == TokenType.LEFT_PARENTHESIS) {
				operatorStack.push(token);
			} else if (type == TokenType.RIGHT_PARENTHESIS) {
				while (!isLeftParenthesisOnTop()) {
					outputQueue.add(operatorStack.pop());
				}
				if (isLeftParenthesisOnTop()) {
					operatorStack.pop();
				}
			}
		}

		outputQueue.addAll(operatorStack);

		return outputQueue;
	}

	private boolean isLeftAssociativeAndEqualPriorityOpOnTop(Operator op) {
		Token top = operatorStack.peek();
		if (top != null && top.getType() == TokenType.OPERATOR) {
			Operator topOp = (Operator) top;
			return topOp.getAssociativity() == Associativity.LEFT && op.getPrecedence() == topOp.getPrecedence();
		}
		return false;
	}

	private boolean isHigherPriorityOpOnTop(Operator op) {
		if (!operatorStack.isEmpty()) {
			Token top = operatorStack.peek();
			if (top.getType() == TokenType.OPERATOR) {
				Operator topOp = (Operator) top;
				return topOp.getPrecedence() > op.getPrecedence();
			}
		}
		return false;
	}

	private boolean isFunctionOnTop() {
		return !operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.FUNCTION;
	}

	private boolean isLeftParenthesisOnTop() {
		return !operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.LEFT_PARENTHESIS;
	}
}
