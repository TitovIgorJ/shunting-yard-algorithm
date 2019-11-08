package com.mmust.token

enum class Parenthesis private constructor(override val rawValue: String) : Token {

    LEFT("("),
    RIGHT(")")
}
