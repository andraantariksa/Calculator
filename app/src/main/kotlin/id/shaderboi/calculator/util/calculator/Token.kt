package id.shaderboi.calculator.util.calculator

import java.math.BigInteger

sealed class Token {
    class ParenthesisOpen(): Token() {
        override fun equals(other: Any?): Boolean {
            return this === other || javaClass == other?.javaClass
        }

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }
    class ParenthesisClose(): Token() {
        override fun equals(other: Any?): Boolean {
            return this === other || javaClass == other?.javaClass
        }

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }
    data class Number(val number: BigInteger): Token()
    data class Operator(val operator: id.shaderboi.calculator.util.calculator.Operator): Token()
}