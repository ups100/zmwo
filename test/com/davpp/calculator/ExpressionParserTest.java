package com.davpp.calculator;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ExpressionParserTest {

    @Test(expected = InvalidNumericFormatException.class)
    public void test_parser_with_wrong_number_format() throws Exception {
        ExpressionParser expressionParser = new ExpressionParser("1.a+1");
    }

    @Test(expected = InvalidNumericFormatException.class)
    public void test_parser_with_wrong_symbol_format() throws Exception {
        ExpressionParser expressionParser = new ExpressionParser("1.0^1");
    }

    @Test
    public void test_parser_by_divider() throws Exception {
        ExpressionParser expressionParser = new ExpressionParser("1/2.0");
        assertEquals(0, BigDecimal.ONE.compareTo(expressionParser.getParam1()));
        assertEquals(0, new BigDecimal("2").compareTo(expressionParser.getParam2()));
        Expression e = expressionParser.getExpression();
        assertTrue(e instanceof Divider);
    }

    @Test
    public void test_parser_by_multiplier() throws Exception {
        ExpressionParser expressionParser = new ExpressionParser("1.0*2");
        assertEquals(0, BigDecimal.ONE.compareTo(expressionParser.getParam1()));
        assertEquals(0, new BigDecimal("2").compareTo(expressionParser.getParam2()));
        Expression e = expressionParser.getExpression();
        assertTrue(e instanceof Multiplier);
    }

    @Test
    public void test_parser_by_substractor() throws Exception {
        ExpressionParser expressionParser = new ExpressionParser("1.0-2.0");
        assertEquals(0, BigDecimal.ONE.compareTo(expressionParser.getParam1()));
        assertEquals(0, new BigDecimal("2").compareTo(expressionParser.getParam2()));
        Expression e = expressionParser.getExpression();
        assertTrue(e instanceof Substractor);
    }

    @Test
    public void test_parser_by_summator() throws Exception {
        ExpressionParser expressionParser = new ExpressionParser("1+2");
        assertEquals(0, BigDecimal.ONE.compareTo(expressionParser.getParam1()));
        assertEquals(0, new BigDecimal("2").compareTo(expressionParser.getParam2()));
        Expression e = expressionParser.getExpression();
        assertTrue(e instanceof Summator);
    }
}
