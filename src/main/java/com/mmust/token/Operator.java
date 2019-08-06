package com.mmust.token;

public interface Operator {

	double eval(double op1, double op2);

	int getPrecedence();

	Associativity getAssociativity();
}
