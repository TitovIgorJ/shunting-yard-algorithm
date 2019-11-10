package com.mmust.token

interface BinaryOperator {

    val precedence: Int

    val associativity: Associativity

    fun eval(op1: Double, op2: Double): Double
}