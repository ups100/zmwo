package com.davpp.calculator;

import static org.junit.Assert.*;
import java.math.BigDecimal;

import org.junit.Test;

public class DividerTests {
    @Test
    public void test_ten_divide_Two() throws Exception {
        BigDecimal param1 = new BigDecimal("10");
        BigDecimal param2 = new BigDecimal("2");
        Divider divider = new Divider(param1, param2);
        assertEquals(0, new BigDecimal("5").compareTo(divider.getResult()));
    }

    @Test(expected = DivideByZeroException.class)
    public void test_divide_zero() throws Exception {
        BigDecimal param1 = new BigDecimal("10");
        BigDecimal param2 = new BigDecimal("0");
        Divider divider = new Divider(param1, param2);
    }

    @Test
    public void test_ten_divide_three() throws Exception {
        BigDecimal param1 = new BigDecimal("10");
        BigDecimal param2 = new BigDecimal("3");
        Divider divider = new Divider(param1, param2);
        assertEquals(0, new BigDecimal("3.333333333").compareTo(divider.getResult()));
    }
}
