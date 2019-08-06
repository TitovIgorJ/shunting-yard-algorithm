package com.mmust;

import com.mmust.token.*;
import com.mmust.tokenizer.Tokenizer;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TokenizerTest {

	@Test
	public void testArithmeticOperatorsOnly() {
		Tokenizer tokenizer = new Tokenizer("3+4-5*2-9/8");

		Assertions.assertThat(tokenizer)
				.hasSize(11)
				.containsExactly(
						new NumToken("3"),
						new AdditionOpToken(),
						new NumToken("4"),
						new SubtractOpToken(),
						new NumToken("5"),
						new MultiplicationOp(),
						new NumToken("2"),
						new SubtractOpToken(),
						new NumToken("9"),
						new DivisionOpToken(),
						new NumToken("8")
				);
	}

	@Test
	public void testWithParenthesis() {
		Tokenizer tokenizer = new Tokenizer("3*(5-1)");

		Assertions.assertThat(tokenizer)
				.hasSize(7)
				.containsExactly(
						new NumToken("3"),
						new MultiplicationOp(),
						Parenthesis.LEFT,
						new NumToken("5"),
						new SubtractOpToken(),
						new NumToken("1"),
						Parenthesis.RIGHT
				);
	}
}