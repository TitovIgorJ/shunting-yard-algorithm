package com.mmust.evaluators

import com.mmust.evaluators.impl.ShuntingYardMathEvaluator
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test

class ShuntingYardMathEvaluatorTest {

    private var mathEvaluator: MathEvaluator? = null

    @Before
    fun setUp() {
        mathEvaluator = ShuntingYardMathEvaluator()
    }

    @Test
    fun simpleSum() {
        val infixExpression = "3+5"
        val expectedResult = 8.0


        val actResult = mathEvaluator!!.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun simpleSubtraction() {
        val infixExpression = "3-5"
        val expectedResult = -2.0

        val actResult = mathEvaluator!!.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun fewOperators() {
        val infixExpression = "3+8-6"
        val expectedResult = 5.0

        val actResult = mathEvaluator!!.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun simpleParenthesis() {
        val infixExpression = "(3-1)"
        val expectedResult = 2.0

        val actResult = mathEvaluator!!.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun parenthesis() {
        val infixExpression = "2*(3-1)"
        val expectedResult = 4.0

        val actResult = mathEvaluator!!.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun innerParenthesis() {
        val infixExpression = "2*(3-(2-1))"
        val expectedResult = 4.0

        val actResult = mathEvaluator!!.eval(infixExpression)

        Assertions.assertThat(actResult)
                .isEqualTo(expectedResult)
    }
}