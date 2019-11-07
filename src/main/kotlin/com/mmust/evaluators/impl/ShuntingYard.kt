package com.mmust.evaluators.impl

import com.mmust.token.*
import com.mmust.token.Function
import java.util.*

internal class ShuntingYard(private val infixExpression: Iterable<Token>) {

    private val operatorStack = LinkedList<Token>()
    private val outputQueue = LinkedList<Token>()

    private val isFunctionOnTop: Boolean
        get() = !operatorStack.isEmpty() && operatorStack.peek() is Function

    private val isLeftParenthesisOnTop: Boolean
        get() = !operatorStack.isEmpty() && operatorStack.peek() is Parenthesis && operatorStack.peek() == Parenthesis.LEFT

    fun doSorting(): Iterable<Token> {
        for (token in infixExpression) {
            when (token) {
                is NumToken -> outputQueue.add(token)
                is Function -> operatorStack.push(token)
                is Operator -> {
                    val op = token as Operator
                    while (isFunctionOnTop || isHigherPriorityOpOnTop(op) || isLeftAssociativeAndEqualPriorityOpOnTop(op) && !isLeftParenthesisOnTop) {
                        outputQueue.add(operatorStack.pop())
                    }
                    operatorStack.push(token)
                }
                is Parenthesis -> {
                    if (token == Parenthesis.LEFT) {
                        operatorStack.push(token)
                    } else {
                        while (!isLeftParenthesisOnTop) {
                            outputQueue.add(operatorStack.pop())
                        }
                        if (isLeftParenthesisOnTop) {
                            operatorStack.pop()
                        }
                    }
                }
            }
        }

        outputQueue.addAll(operatorStack)

        return outputQueue
    }

    private fun isLeftAssociativeAndEqualPriorityOpOnTop(op: Operator): Boolean {
        val top = operatorStack.peek()
        if (top != null && top.type == TokenType.OPERATOR) {
            val topOp = top as Operator
            return topOp.associativity == Associativity.LEFT && op.precedence == topOp.precedence
        }
        return false
    }

    private fun isHigherPriorityOpOnTop(op: Operator): Boolean {
        if (!operatorStack.isEmpty()) {
            val top = operatorStack.peek()
            if (top.type == TokenType.OPERATOR) {
                val topOp = top as Operator
                return topOp.precedence > op.precedence
            }
        }
        return false
    }
}
