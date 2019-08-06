package com.mmust.evaluators.impl;

import com.mmust.evaluators.MathEvaluator;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ShuntingYardMathEvaluatorTest {

	private MathEvaluator mathEvaluator;

	@Before
	public void setUp() {
		mathEvaluator = new ShuntingYardMathEvaluator();
	}

	@Test
	public void simpleSum() {
		String infixExpression = "3+5";
		double expectedResult = 8;


		double actResult = mathEvaluator.eval(infixExpression);

		Assertions.assertThat(actResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void simpleSubtraction() {
		String infixExpression = "3-5";
		double expectedResult = -2;

		double actResult = mathEvaluator.eval(infixExpression);

		Assertions.assertThat(actResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void fewOperators() {
		String infixExpression = "3+8-6";
		double expectedResult = 5;

		double actResult = mathEvaluator.eval(infixExpression);

		Assertions.assertThat(actResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void simpleParenthesis() {
		String infixExpression = "(3-1)";
		double expectedResult = 2;

		double actResult = mathEvaluator.eval(infixExpression);

		Assertions.assertThat(actResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void parenthesis() {
		String infixExpression = "2*(3-1)";
		double expectedResult = 4;

		double actResult = mathEvaluator.eval(infixExpression);

		Assertions.assertThat(actResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void innerParenthesis() {
		String infixExpression = "2*(3-(2-1))";
		double expectedResult = 4;

		double actResult = mathEvaluator.eval(infixExpression);

		Assertions.assertThat(actResult)
				.isEqualTo(expectedResult);
	}
}