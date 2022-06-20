package id.shaderboi.calculator

import id.shaderboi.calculator.util.calculator.Calculator
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.math.BigInteger

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun equation_isValid() {
        assert(calculator.isValidExpression("1 + 2+3+4"))
        assert(calculator.isValidExpression("5*(1+2%2)/(3-5)"))
    }

    @Test
    fun equation_isInvalid() {
        assertFalse(calculator.isValidExpression("1++2"))
        assertFalse(calculator.isValidExpression("5+2&9"))
        assertFalse(calculator.isValidExpression("5+(29+2"))
        assertFalse(calculator.isValidExpression("5+29+2)"))
    }

    @Test
    fun equation_doCalculation() {
        assertEquals(calculator.calculate("9999999999999999999999999999+9999999999999999999999999999"), BigInteger("19999999999999999999999999998"))
    }
}