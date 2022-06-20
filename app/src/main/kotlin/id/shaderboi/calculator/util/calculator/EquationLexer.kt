package id.shaderboi.calculator.util.calculator

import java.math.BigDecimal

class EquationLexer(equation: String) {
    val it = equation.iterator()
    val trees = mutableListOf<Tree>()
    var currentChar: Char? = null

    init {
        nextChar()
    }

    private fun nextChar(): Char? {
        if (it.hasNext()) {
            val char = it.nextChar()
            currentChar = char
            return char
        }
        currentChar = null
        return null
    }

    private fun scanNumber(): Token.Number {
        var numberString = ""
        while (currentChar?.isDigit() == true) {
            numberString += currentChar
            nextChar()
        }

        if (currentChar == '.') {
            numberString += "."
            while (currentChar?.isDigit() == true) {
                numberString += currentChar
                nextChar()
            }
        }

        return Token.Number(BigDecimal(numberString))
    }

    fun nextToken(): Token? {
        val token = when (currentChar) {
            '-' -> {
                nextChar()
                Token.Operator(Operator.Subtraction)
            }
            '+' -> {
                nextChar()
                Token.Operator(Operator.Addition)
            }
            '/' -> {
                nextChar()
                Token.Operator(Operator.Division)
            }
            '*' -> {
                nextChar()
                Token.Operator(Operator.Multiplication)
            }
            '%' -> {
                nextChar()
                Token.Operator(Operator.Modulo)
            }
            in '0'..'9' -> scanNumber()
            null -> null
            else -> throw IllegalStateException("Invalid character")
        }
        return token
    }

    fun getAllTokens(): List<Token> {
        val tokens = mutableListOf<Token>()
        while (true) {
            val token = nextToken() ?: break
            tokens.add(token)
        }
        return tokens
    }
}