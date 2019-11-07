package com.mmust.token

abstract class BaseToken internal constructor(override val rawValue: String) : Token {

    override fun toString(): String {
        return rawValue
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val baseToken = o as BaseToken?

        return rawValue == baseToken!!.rawValue
    }

    override fun hashCode(): Int {
        return rawValue.hashCode()
    }
}
