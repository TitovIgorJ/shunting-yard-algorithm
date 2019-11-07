package com.mmust.token

class Function(value: String): BaseToken(value) {

    override val type: TokenType
        get() = TokenType.FUNCTION
}