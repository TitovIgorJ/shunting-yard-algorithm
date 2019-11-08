package com.mmust;

import com.mmust.token.NumToken;
import com.mmust.token.Parenthesis;
import com.mmust.tokenizer.Tokenizer;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static com.mmust.token.Operators.*;

public class TokenizerTest {

	@Test
	public void testArithmeticOperatorsOnly() {
		Tokenizer tokenizer = new Tokenizer("3+4-5*2-9/8");

		Assertions.assertThat(tokenizer)
				.hasSize(11)
				.containsExactly(
						new NumToken("3"),
						PLUS,
						new NumToken("4"),
						MINUS,
						new NumToken("5"),
						MULTIPLY,
						new NumToken("2"),
						MINUS,
						new NumToken("9"),
						DIV,
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
						MULTIPLY,
						Parenthesis.LEFT,
						new NumToken("5"),
						MINUS,
						new NumToken("1"),
						Parenthesis.RIGHT
				);
	}
}