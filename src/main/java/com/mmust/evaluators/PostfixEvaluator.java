package com.mmust.evaluators;

import com.mmust.token.Token;

public interface PostfixEvaluator {

	double eval(Iterable<Token> postfixExpr);
}
