package id.shaderboi.calculator.util.calculator

private val EQUATION_REGEX = Regex("(?<=[-+*/()])|(?=[-+*/()])")

class Calculator {
    fun isValidExpression(expression: String): Boolean {
        return expression.matches(EQUATION_REGEX)
    }

    fun calculate(equation: String): Boolean {
        TODO()
    }
}