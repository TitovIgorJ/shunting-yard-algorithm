package com.mmust.evaluators.impl

import com.mmust.evaluators.MathEvaluator
import com.mmust.tokenizer.Tokenizer

class ShuntingYardMathEvaluator : MathEvaluator {

    private val infixToPostfixParser = ShuntingYardInfixToPostfixParser()
    private val postfixEvaluator = StackPostfixMathExpressionEvaluator()

    override fun eval(infixExpression: String): Double {
        val tokens = Tokenizer(infixExpression).parse()
        val postfixExpression = infixToPostfixParser.parse(tokens)
        return postfixEvaluator.eval(postfixExpression)
    }

    override fun invoke(infixExpression: String): Double {
        return eval(infixExpression)
    }
}
