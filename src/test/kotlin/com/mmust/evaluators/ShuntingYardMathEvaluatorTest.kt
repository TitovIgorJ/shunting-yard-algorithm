package com.mmust.evaluators

import com.mmust.evaluators.impl.ShuntingYardMathEvaluator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ShuntingYardMathEvaluatorTest {

    private var mathEvaluator: MathEvaluator = ShuntingYardMathEvaluator()

    @Test
    @DisplayName("Simple Sum")
    fun testSimpleSum() {
        val infixExpression = "3+5"
        val expectedResult = 8.0


        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Simple Subtraction")
    fun testSimpleSubtraction() {
        val infixExpression = "3-5"
        val expectedResult = -2.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Few Operators")
    fun testFewOperators() {
        val infixExpression = "3+8-6"
        val expectedResult = 5.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Simple Parenthesis")
    fun testSimpleParenthesis() {
        val infixExpression = "(3-1)"
        val expectedResult = 2.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Parenthesis")
    fun testWithParenthesis() {
        val infixExpression = "2*(3-1)"
        val expectedResult = 4.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Inner Parenthesis")
    fun testWithInnerParenthesis() {
        val infixExpression = "2*(3-(2-1))"
        val expectedResult = 4.0

        val actResult = mathEvaluator.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }
}