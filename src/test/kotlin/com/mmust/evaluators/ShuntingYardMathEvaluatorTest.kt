package com.mmust.evaluators

import com.mmust.evaluators.impl.ShuntingYardMathEvaluator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ShuntingYardMathEvaluatorTest {

    private var mathEvaluator: MathEvaluator = ShuntingYardMathEvaluator()

    @Test
    @DisplayName("Simple Sum")
    fun simpleSum() {
        val infixExpression = "3+5"
        val expectedResult = 8.0


        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Simple Subtraction")
    fun simpleSubtraction() {
        val infixExpression = "3-5"
        val expectedResult = -2.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Few Operators")
    fun fewOperators() {
        val infixExpression = "3+8-6"
        val expectedResult = 5.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Simple Parenthesis")
    fun simpleParenthesis() {
        val infixExpression = "(3-1)"
        val expectedResult = 2.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Parenthesis")
    fun withParenthesis() {
        val infixExpression = "2*(3-1)"
        val expectedResult = 4.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Inner Parenthesis")
    fun innerParenthesis() {
        val infixExpression = "2*(3-(2-1))"
        val expectedResult = 4.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Bigger Numbers")
    fun biggerNumbers() {
        val infixExpression = "2*(12-(78-72))"
        val expectedResult = 12.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Simple Pow")
    fun simplePow() {
        val testExpr = "2^3"
        val expectedResult = 8.0

        val actResult = mathEvaluator.eval(testExpr)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Few Operators With Pow")
    fun testPow() {
        val testExpr = "2^2*(5-3)"
        val expectedResult = 8.0

        val actResult = mathEvaluator.eval(testExpr)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }
}