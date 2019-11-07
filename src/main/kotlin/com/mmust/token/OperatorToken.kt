package com.mmust.token

abstract class OperatorToken(value: String) : BaseToken(value), Operator {

    override val type: TokenType
        get() = TokenType.OPERATOR
}
