package com.mmust.tokenizer

import com.mmust.token.*

class Tokenizer(expression: String) {

    private val data = expression
    private var pos = 0

    fun parse(): List<Token> {

        val result = mutableListOf<Token>()

        do {
            val c = peek()
            val token = when {
                c == '(' -> LeftParenthesis
                c == ')' -> RightParenthesis
                Character.isDigit(c) -> extractDigit()
                c == '+' -> ArithmeticOperators.PLUS
                c == '-' -> ArithmeticOperators.MINUS
                c == '*' -> ArithmeticOperators.TIMES
                c == '/' -> ArithmeticOperators.DIV
                else -> throw IllegalArgumentException("Can't recognize token type, token = [$c]")
            }
            result.add(token)
            movePos()
        } while (hasNext())

        return result
    }

    private fun extractDigit(): Token {
        var r = peek().toString()

        while (oneMoreDigitPresent()) {
            movePos()
            r += peek()
        }

        return NumToken(r)
    }

    private fun peek() = data[pos]

    private fun hasNext() = pos < data.length

    private fun oneMoreDigitPresent() = pos + 1 < data.length && data[pos + 1].isDigit()

    private fun movePos(offset: Int = 1) {
        pos += offset
    }
}
