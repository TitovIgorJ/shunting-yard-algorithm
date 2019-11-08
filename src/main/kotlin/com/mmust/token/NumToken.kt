package com.mmust.token

class NumToken(value: String) : BaseToken(value), Number {

    constructor(num: Double) : this(java.lang.Double.toString(num)) {}

    override fun doubleValue(): Double {
        return java.lang.Double.parseDouble(rawValue)
    }
}
