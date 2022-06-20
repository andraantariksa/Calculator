package id.shaderboi.calculator.util.calculator

import java.math.BigInteger

sealed class Tree {
    data class Number(val number: BigInteger): Tree()
    data class Operator(val operator: id.shaderboi.calculator.util.calculator.Operator): Tree()
}