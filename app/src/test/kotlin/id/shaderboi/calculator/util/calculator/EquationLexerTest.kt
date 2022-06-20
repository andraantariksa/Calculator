package id.shaderboi.calculator.util.calculator

import org.junit.Assert
import org.junit.Test
import java.math.BigInteger

class EquationLexerTest {
    @Test
    fun tokensizeNumberAndOperators() {
        Assert.assertEquals(
            EquationLexer("0987654321+1234567890").getAllTokens(), listOf(
                Token.Number(BigInteger("0987654321")),
                Token.Operator(Operator.Addition),
                Token.Number(BigInteger("1234567890"))
            )
        )
        Assert.assertEquals(
            EquationLexer("1+1-1/1%1*1").getAllTokens(), listOf(
                Token.Number(BigInteger("1")),
                Token.Operator(Operator.Addition),
                Token.Number(BigInteger("1")),
                Token.Operator(Operator.Subtraction),
                Token.Number(BigInteger("1")),
                Token.Operator(Operator.Division),
                Token.Number(BigInteger("1")),
                Token.Operator(Operator.Modulo),
                Token.Number(BigInteger("1")),
                Token.Operator(Operator.Multiplication),
                Token.Number(BigInteger("1")),
            )
        )
    }

    @Test
    fun tokensizeParentesis() {
        println(EquationLexer("1+(1-(1/1)%1)").getAllTokens())
        println(listOf(
            Token.Number(BigInteger("1")),
            Token.Operator(Operator.Addition),
            Token.ParenthesisOpen(),
            Token.Number(BigInteger("1")),
            Token.Operator(Operator.Subtraction),
            Token.ParenthesisOpen(),
            Token.Number(BigInteger("1")),
            Token.Operator(Operator.Division),
            Token.Number(BigInteger("1")),
            Token.ParenthesisClose(),
            Token.Operator(Operator.Modulo),
            Token.Number(BigInteger("1")),
            Token.ParenthesisClose(),
        ))
        Assert.assertEquals(
            EquationLexer("1+(1-(1/1)%1)").getAllTokens(), listOf(
                Token.Number(BigInteger("1")),
                Token.Operator(Operator.Addition),
                Token.ParenthesisOpen(),
                Token.Number(BigInteger("1")),
                Token.Operator(Operator.Subtraction),
                Token.ParenthesisOpen(),
                Token.Number(BigInteger("1")),
                Token.Operator(Operator.Division),
                Token.Number(BigInteger("1")),
                Token.ParenthesisClose(),
                Token.Operator(Operator.Modulo),
                Token.Number(BigInteger("1")),
                Token.ParenthesisClose(),
            )
        )
    }
}