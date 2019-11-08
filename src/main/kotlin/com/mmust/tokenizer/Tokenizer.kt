package com.mmust.tokenizer

import com.mmust.token.ArithmeticOperators.*
import com.mmust.token.NumToken
import com.mmust.token.Parenthesis
import com.mmust.token.Token
import java.lang.Character.isDigit

class Tokenizer(expression: String) : Iterable<Token> {

    private val data: CharArray = expression.toCharArray()

    private fun parseToken(c: Char): Token {
        return when {
            c == '(' -> Parenthesis.LEFT
            c == ')' -> Parenthesis.RIGHT
            isDigit(c) -> NumToken(c.toString())
            c == '+' -> PLUS
            c == '-' -> MINUS
            c == '*' -> TIMES
            c == '/' -> DIV
            else -> throw IllegalArgumentException(String.format("Can't recognize token type, token = [%s]", c))
        }
    }

    override fun iterator(): Iterator<Token> {
        return Itr()
    }

    private inner class Itr : Iterator<Token> {
        private var pos = 0

        override fun hasNext(): Boolean {
            return pos < data.size
        }

        override fun next(): Token {
            return parseToken(data[pos++])
        }
    }
}
