package com.mmust.token

enum class Operators(
        override val rawValue: String,
        override val precedence: Int,
        override val associativity: Associativity,
        private val evaluator: (Double, Double) -> Double
) : Token, Operator {
    PLUS("+", 2, Associativity.LEFT, { op1: Double, op2: Double -> op1 + op2 }),
    MINUS("-", 2, Associativity.LEFT, { op1: Double, op2: Double -> op1 - op2 }),
    DIV("/", 3, Associativity.LEFT, { op1: Double, op2: Double -> op1 / op2 }),
    MULTIPLY("*", 3, Associativity.LEFT, { op1: Double, op2: Double -> op1 * op2 });

    override val type: TokenType
        get() = TokenType.OPERATOR

    override fun eval(op1: Double, op2: Double): Double {
        return evaluator.invoke(op1, op2)
    }
}
