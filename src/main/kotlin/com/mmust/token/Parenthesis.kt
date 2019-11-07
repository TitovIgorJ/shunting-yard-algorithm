package com.mmust.token

enum class Parenthesis private constructor(override val type: TokenType, override val rawValue: String) : Token {

    LEFT(TokenType.LEFT_PARENTHESIS, "("),
    RIGHT(TokenType.RIGHT_PARENTHESIS, ")")
}
