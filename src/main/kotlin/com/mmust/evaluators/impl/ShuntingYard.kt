package com.mmust.evaluators.impl

import com.mmust.token.*
import com.mmust.token.Function
import java.util.*

internal class ShuntingYard(private val infixExpression: Iterable<Token>) {

    private val operatorStack = LinkedList<Token>()
    private val outputQueue = LinkedList<Token>()

    private val isFunctionOnTop: Boolean
        get() = operatorStack.isNotEmpty() && operatorStack.peek() is Function

    private val isLeftParenthesisOnTop: Boolean
        get() = operatorStack.isNotEmpty() && operatorStack.peek() is LeftParenthesis

    fun doSorting(): Iterable<Token> {
        for (token in infixExpression) {
            when (token) {
                is NumToken -> outputQueue.add(token)
                is Function -> operatorStack.push(token)
                is BinaryOperator -> {
                    val op = token as BinaryOperator
                    while (isFunctionOnTop || isHigherPriorityOpOnTop(op) || isLeftAssociativeAndEqualPriorityOpOnTop(op) && !isLeftParenthesisOnTop) {
                        outputQueue.add(operatorStack.pop())
                    }
                    operatorStack.push(token)
                }
                is LeftParenthesis -> operatorStack.push(token)
                is RightParenthesis -> {
                    while (!isLeftParenthesisOnTop) {
                        outputQueue.add(operatorStack.pop())
                    }
                    if (isLeftParenthesisOnTop) {
                        operatorStack.pop()
                    }
                }
            }
        }

        outputQueue.addAll(operatorStack)

        return outputQueue
    }

    private fun isLeftAssociativeAndEqualPriorityOpOnTop(op: BinaryOperator): Boolean {
        if (operatorStack.isNotEmpty()) {
            val top = operatorStack.peek()
            if (top is BinaryOperator) {
                return top.associativity == Associativity.LEFT && op.precedence == top.precedence
            }
        }
        return false
    }

    private fun isHigherPriorityOpOnTop(op: BinaryOperator): Boolean {
        if (operatorStack.isNotEmpty()) {
            val top = operatorStack.peek()
            if (top is BinaryOperator) {
                return top.precedence > op.precedence
            }
        }
        return false
    }
}
