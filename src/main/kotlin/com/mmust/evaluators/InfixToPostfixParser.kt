package com.mmust.evaluators

import com.mmust.token.Token

internal interface InfixToPostfixParser {

    fun parse(infixExpression: Iterable<Token>): Iterable<Token>
}
