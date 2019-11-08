package com.mmust.evaluators

import com.mmust.token.Token

interface InfixToPostfixParser {

    fun parse(infixExpression: Iterable<Token>): Iterable<Token>
}
