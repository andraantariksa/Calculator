package id.shaderboi.calculator.util.calculator

import java.math.BigDecimal

class Calculator {
    fun calculate(equation: String): BigDecimal {
        val tokens = EquationLexer(equation).getAllTokens()
        if (!isTokensValid(tokens)) throw RuntimeException()
        return BigDecimal("123")
    }

    fun isExpressionValid(equation: String): Boolean {
        val tokens = EquationLexer(equation).getAllTokens()
        return isTokensValid(tokens)
    }

    fun isTokensValid(tokens: List<Token>): Boolean {
        var expectCurrentIsNumber = true
        for (token in tokens) {
            if (token is Token.Number) {
                if (expectCurrentIsNumber) {
                    expectCurrentIsNumber = false
                } else {
                    return false
                }
            } else {
                if (!expectCurrentIsNumber) {
                    expectCurrentIsNumber = true
                } else {
                    return false
                }
            }
        }

        return true
    }
}