package com.mmust.token

class DivisionOpToken : OperatorToken("/") {

    override val precedence: Int
        get() = 3

    override val associativity: Associativity
        get() = Associativity.LEFT

    override fun eval(op1: Double, op2: Double): Double {
        return op1 / op2
    }
}
