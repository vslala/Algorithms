package com.bma.problemsolving.leetcode.java.design.basiccalculator;

import com.bma.problemsolving.leetcode.java.design.basiccalculator.infixtopostfix.ExpressionParser;
import com.bma.problemsolving.leetcode.java.design.basiccalculator.infixtopostfix.InfixToPostfixConverter;
import com.bma.problemsolving.leetcode.java.design.basiccalculator.infixtopostfix.ReversePolishNotation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {

    @Test
    void itShouldEvaluateTheGivenExpressionAndReturnTheResult() {
        String infixExpression = "(1+(4+5+2)-3)+(6+8)";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new BasicCalculator(infixToPostfixConverter, reversePolishNotation);
        int result = calculator.calculate(infixExpression);
        assertEquals(23, result);
    }
}