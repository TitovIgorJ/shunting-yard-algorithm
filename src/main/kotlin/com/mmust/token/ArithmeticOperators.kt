package com.mmust.token

enum class ArithmeticOperators(
        override val rawValue: String,
        override val precedence: Int,
        override val associativity: Associativity,
        private val evaluator: (Double, Double) -> Double
) : Token, BinaryOperator {
    PLUS("+", 2, Associativity.LEFT, { op1: Double, op2: Double -> op1 + op2 }),
    MINUS("-", 2, Associativity.LEFT, { op1: Double, op2: Double -> op1 - op2 }),
    DIV("/", 3, Associativity.LEFT, { op1: Double, op2: Double -> op1 / op2 }),
    TIMES("*", 3, Associativity.LEFT, { op1: Double, op2: Double -> op1 * op2 });

    override fun eval(op1: Double, op2: Double): Double {
        return evaluator.invoke(op1, op2)
    }
}
