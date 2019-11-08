package com.mmust.tokenizer

import com.mmust.token.NumToken
import com.mmust.token.Operators.*
import com.mmust.token.Parenthesis
import com.mmust.token.Token
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TokenizerTest {

    @Test
    @DisplayName("Arithmetic Operators Only")
    fun arithmeticOperatorsOnly() {
        val tokenizer = Tokenizer("3+4-5*2-9/8")

        assertThat<Token>(tokenizer)
                .hasSize(11)
                .containsExactly(
                        NumToken("3"),
                        PLUS,
                        NumToken("4"),
                        MINUS,
                        NumToken("5"),
                        MULTIPLY,
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
        val tokenizer = Tokenizer("3*(5-1)")

        assertThat<Token>(tokenizer)
                .hasSize(7)
                .containsExactly(
                        NumToken("3"),
                        MULTIPLY,
                        Parenthesis.LEFT,
                        NumToken("5"),
                        MINUS,
                        NumToken("1"),
                        Parenthesis.RIGHT
                )
    }
}