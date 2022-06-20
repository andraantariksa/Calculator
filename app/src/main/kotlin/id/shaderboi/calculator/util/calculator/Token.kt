package id.shaderboi.calculator.util.calculator

import java.math.BigDecimal
import java.math.BigInteger

sealed class Token {
    data class Number(val number: BigDecimal): Token()
    data class Operator(val operator: id.shaderboi.calculator.util.calculator.Operator): Token()
}