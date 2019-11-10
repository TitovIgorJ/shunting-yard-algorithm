package com.mmust.tokenizer

import com.mmust.token.ArithmeticOperators.*
import com.mmust.token.LeftParenthesis
import com.mmust.token.NumToken
import com.mmust.token.RightParenthesis
import com.mmust.token.Token
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TokenizerTest {

    @Test
    @DisplayName("Arithmetic Operators Only")
    fun arithmeticOperatorsOnly() {
        val tokens = Tokenizer("3+4-5*2-9/8").parse()
        assertThat<Token>(tokens)
                .hasSize(11)
                .containsExactly(
                        NumToken("3"),
                        PLUS,
                        NumToken("4"),
                        MINUS,
                        NumToken("5"),
                        TIMES,
                        NumToken("2"),
                        MINUS,
                        NumToken("9"),
                        DIV,
                        NumToken("8")
                )
    }

    @Test
    @DisplayName("With Parenthesis")
    fun withParenthesis() {
        val tokens = Tokenizer("3*(5-1)").parse()
        assertThat<Token>(tokens)
                .hasSize(7)
                .containsExactly(
                        NumToken("3"),
                        TIMES,
                        LeftParenthesis,
                        NumToken("5"),
                        MINUS,
                        NumToken("1"),
                        RightParenthesis
                )
    }

    @Test
    @DisplayName("Without Numbers")
    fun withoutNumbers() {
        val tokens = Tokenizer("(+)").parse()

        assertThat<Token>(tokens)
                .hasSize(3)
                .containsExactly(
                        LeftParenthesis,
                        PLUS,
                        RightParenthesis
                )
    }

    @Test
    @DisplayName("Multi Digit")
    fun multiDigits() {
        val tokens = Tokenizer("125-75").parse()
        assertThat<Token>(tokens)
                .hasSize(3)
                .containsExactly(
                        NumToken("125"),
                        MINUS,
                        NumToken("75")
                )
    }

    @Test
    @DisplayName("Multi Digit Few Operators")
    fun multiDigitFewOps() {
        val tokens = Tokenizer("10*(15-3)").parse()
        assertThat<Token>(tokens)
                .hasSize(7)
                .containsExactly(
                        NumToken("10"),
                        TIMES,
                        LeftParenthesis,
                        NumToken("15"),
                        MINUS,
                        NumToken("3"),
                        RightParenthesis
                )
    }
}