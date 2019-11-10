package com.mmust.token

internal class NumToken(value: String) : BaseToken(value), Number {

    constructor(num: Double) : this(num.toString())

    override fun doubleValue(): Double {
        return rawValue.toDouble()
    }
}
