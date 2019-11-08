package com.mmust.evaluators;

import com.mmust.evaluators.impl.StackPostfixMathExpressionEvaluator;
import com.mmust.token.NumToken;
import com.mmust.token.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.mmust.token.Operators.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PostfixMathExpressionEvaluatorTest {

	private PostfixEvaluator evaluator;

	@Before
	public void init() {
		evaluator = new StackPostfixMathExpressionEvaluator();
	}

	@Test
	public void testAddition() {
		Iterable<Token> simplePostfixExpr = List.of(
				new NumToken("2"),
				new NumToken("3"),
				PLUS
		);

		double actualResult = evaluator.eval(simplePostfixExpr);
		double expectedResult = 5.0;

		assertThat(actualResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void testSubtract() {
		Iterable<Token> simplePostfixExpr = List.of(
				new NumToken("5"),
				new NumToken("2"),
				MINUS
		);

		double actualResult = evaluator.eval(simplePostfixExpr);
		double expectedResult = 3.0;

		assertThat(actualResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void testMultiply() {
		Iterable<Token> simplePostfixExpr = List.of(
				new NumToken("3"),
				new NumToken("4"),
				MULTIPLY
		);

		double actualResult = evaluator.eval(simplePostfixExpr);
		double expectedResult = 12.0;

		assertThat(actualResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void testDivide() {
		Iterable<Token> simplePostfixExpr = List.of(
				new NumToken("8"),
				new NumToken("4"),
				DIV
		);

		double actualResult = evaluator.eval(simplePostfixExpr);
		double expectedResult = 2.0;

		assertThat(actualResult)
				.isEqualTo(expectedResult);
	}

	@Test
	public void testFewOps() {
		Iterable<Token> simplePostfixExpr = List.of(
				new NumToken("3"),
				new NumToken("4"),
				new NumToken("5"),
				MULTIPLY,
				MINUS
		);

		double actualResult = evaluator.eval(simplePostfixExpr);
		double expectedResult = -17.0;

		assertThat(actualResult)
				.isEqualTo(expectedResult);
	}
}