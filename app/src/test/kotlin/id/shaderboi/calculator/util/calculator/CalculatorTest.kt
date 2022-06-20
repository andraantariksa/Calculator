package id.shaderboi.calculator.util.calculator

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.math.BigInteger

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun equation_doCalculation() {
        assertEquals(
            calculator.calculate("9999999999999999999999999999+9999999999999999999999999999"),
            BigInteger("19999999999999999999999999998")
        )
        assertEquals(calculator.calculate("1+1"), BigInteger("2"))
        assertEquals(calculator.calculate("1 + 1"), BigInteger("2"))
        assertEquals(calculator.calculate("1 + 2"), BigInteger("-1"))
    }
}