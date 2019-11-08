package com.mmust.token

class NumToken(value: String) : BaseToken(value), Number {

    constructor(num: Double) : this(num.toString())

    override fun doubleValue(): Double {
        return java.lang.Double.parseDouble(rawValue)
    }
}
