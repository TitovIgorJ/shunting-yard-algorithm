package com.mmust.evaluators

interface MathEvaluator {

    fun eval(infixExpression: String): Double

    operator fun invoke(expression: String): Double
}
