package com.davpp.calculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SummatorTest {
    @Test
    public void test_one_add_one() throws Exception {
        BigDecimal param1 = new BigDecimal("1");
        BigDecimal param2 = new BigDecimal("1");
        Summator summator = new Summator(param1, param2);
        assertEquals(0, new BigDecimal("2").compareTo(summator.getResult()));
    }
}
