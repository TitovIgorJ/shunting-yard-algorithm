package com.mmust.evaluators

import com.mmust.evaluators.impl.StackPostfixMathExpressionEvaluator
import com.mmust.token.ArithmeticOperators.*
import com.mmust.token.NumToken
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PostfixMathExpressionEvaluatorTest {

    private val evaluator: PostfixEvaluator = StackPostfixMathExpressionEvaluator()

    @Test
    @DisplayName("+")
    fun addition() {
        val simplePostfixExpr = listOf(
                NumToken("2"),
                NumToken("3"),
                PLUS
        )

        val actualResult = evaluator.eval(simplePostfixExpr)
        val expectedResult = 5.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("-")
    fun subtract() {
        val simplePostfixExpr = listOf(
                NumToken("5"),
                NumToken("2"),
                MINUS
        )

        val actualResult = evaluator.eval(simplePostfixExpr)
        val expectedResult = 3.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("*")
    fun multiply() {
        val simplePostfixExpr = listOf(
                NumToken("3"),
                NumToken("4"),
                TIMES
        )

        val actualResult = evaluator.eval(simplePostfixExpr)
        val expectedResult = 12.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("/")
    fun divide() {
        val simplePostfixExpr = listOf(
                NumToken("8"),
                NumToken("4"),
                DIV
        )

        val actualResult = evaluator.eval(simplePostfixExpr)
        val expectedResult = 2.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("Few operations")
    fun fewOps() {
        val simplePostfixExpr = listOf(
                NumToken("3"),
                NumToken("4"),
                NumToken("5"),
                TIMES,
                MINUS
        )

        val actualResult = evaluator.eval(simplePostfixExpr)
        val expectedResult = -17.0

        assertThat(actualResult)
                .isEqualTo(expectedResult)
    }
}