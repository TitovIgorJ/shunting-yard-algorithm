package com.mmust.evaluators.impl

import com.mmust.evaluators.PostfixEvaluator
import com.mmust.token.NumToken
import com.mmust.token.Number
import com.mmust.token.Operator
import com.mmust.token.Token
import java.util.*

class StackPostfixMathExpressionEvaluator : PostfixEvaluator {

    override fun eval(postfixExpr: Iterable<Token>): Double {
        val stack = LinkedList<Token>()

        for (t in postfixExpr) {
            when (t) {
                is Number -> stack.push(t)

                is Operator -> {
                    val op2 = stack.pop() as Number
                    val op1 = stack.pop() as Number

                    val result = t.eval(op1.`val`(), op2.`val`())

                    stack.push(NumToken(result))
                }
            }
        }

        val result = stack.pop() as Number

        return result.`val`()
    }
}
