package com.mmust.evaluators.impl

import com.mmust.evaluators.InfixToPostfixParser
import com.mmust.token.Token

class ShuntingYardInfixToPostfixParser : InfixToPostfixParser {

    override fun parse(infixExpression: Iterable<Token>): Iterable<Token> {
        return ShuntingYard(infixExpression).doSorting()
    }
}
