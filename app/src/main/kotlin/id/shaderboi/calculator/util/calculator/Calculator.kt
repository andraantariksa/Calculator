package id.shaderboi.calculator.util.calculator

import java.lang.IllegalStateException
import java.math.BigInteger

class Calculator {
    fun calculate(equation: String): BigInteger {
        val tokens = EquationLexer(equation).getAllTokens()
        return BigInteger("123")
    }
}