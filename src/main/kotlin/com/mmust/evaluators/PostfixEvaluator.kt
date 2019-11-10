package com.mmust.evaluators

import com.mmust.token.Token

internal interface PostfixEvaluator {

    fun eval(postfixExpr: Iterable<Token>): Double
}
