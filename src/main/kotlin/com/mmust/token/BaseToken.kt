package com.mmust.token

internal abstract class BaseToken internal constructor(override val rawValue: String) : Token {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseToken

        if (rawValue != other.rawValue) return false

        return true
    }

    override fun hashCode(): Int {
        return rawValue.hashCode()
    }

    override fun toString() = rawValue
}
