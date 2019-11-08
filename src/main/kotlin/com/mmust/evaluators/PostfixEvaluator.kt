package com.mmust.evaluators

import com.mmust.token.Token

interface PostfixEvaluator {

    fun eval(postfixExpr: Iterable<Token>): Double
}
