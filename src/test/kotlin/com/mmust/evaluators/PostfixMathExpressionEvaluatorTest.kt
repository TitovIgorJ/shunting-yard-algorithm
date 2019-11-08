package com.mmust.evaluators

import com.mmust.evaluators.impl.StackPostfixMathExpressionEvaluator
import com.mmust.token.NumToken
import com.mmust.token.Operators.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class PostfixMathExpressionEvaluatorTest {

    private var evaluator: PostfixEvaluator? = null

    @Before
    fun init() {
        evaluator = StackPostfixMathExpressionEvaluator()
    }

    @Test
    fun testAddition() {
        val simplePostfixExpr = listOf(
                NumToken("2"),
                NumToken("3"),
                PLUS
        )

        val actualResult = evaluator!!.eval(simplePostfixExpr)
        val expectedResult = 5.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun testSubtract() {
        val simplePostfixExpr = listOf(
                NumToken("5"),
                NumToken("2"),
                MINUS
        )

        val actualResult = evaluator!!.eval(simplePostfixExpr)
        val expectedResult = 3.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun testMultiply() {
        val simplePostfixExpr = listOf(
                NumToken("3"),
                NumToken("4"),
                MULTIPLY
        )

        val actualResult = evaluator!!.eval(simplePostfixExpr)
        val expectedResult = 12.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun testDivide() {
        val simplePostfixExpr = listOf(
                NumToken("8"),
                NumToken("4"),
                DIV
        )

        val actualResult = evaluator!!.eval(simplePostfixExpr)
        val expectedResult = 2.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }

    @Test
    fun testFewOps() {
        val simplePostfixExpr = listOf(
                NumToken("3"),
                NumToken("4"),
                NumToken("5"),
                MULTIPLY,
                MINUS
        )

        val actualResult = evaluator!!.eval(simplePostfixExpr)
        val expectedResult = -17.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }
}