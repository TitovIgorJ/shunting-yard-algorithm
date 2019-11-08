package com.mmust.evaluators.impl

import com.mmust.evaluators.PostfixEvaluator
import com.mmust.token.*
import com.mmust.token.Number
import java.util.*

class StackPostfixMathExpressionEvaluator : PostfixEvaluator {

    override fun eval(postfixExpr: Iterable<Token>): Double {
        val stack = LinkedList<Token>()

        for (t in postfixExpr) {
            when (t.type) {
                TokenType.NUMBER -> stack.push(t)

                TokenType.OPERATOR -> {
                    val op2 = stack.pop() as Number
                    val op1 = stack.pop() as Number

                    val evaluator = t as Operator

                    val result = evaluator.eval(op1.`val`(), op2.`val`())

                    stack.push(NumToken(result))
                }
            }
        }

        val result = stack.pop() as Number

        return result.`val`()
    }
}
