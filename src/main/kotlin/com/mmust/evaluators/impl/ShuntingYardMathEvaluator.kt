package com.mmust.evaluators.impl

import com.mmust.evaluators.MathEvaluator
import com.mmust.tokenizer.Tokenizer

class ShuntingYardMathEvaluator : MathEvaluator {

    private val infixToPostfixParser = ShuntingYardInfixToPostfixParser()
    private val postfixEvaluator = StackPostfixMathExpressionEvaluator()

    override fun eval(infixExpression: String): Double {
        val tokenizer = Tokenizer(infixExpression)
        val postfixExpression = infixToPostfixParser.parse(tokenizer)
        return postfixEvaluator.eval(postfixExpression)
    }

    override fun invoke(expression: String): Double {
        return eval(expression)
    }
}
