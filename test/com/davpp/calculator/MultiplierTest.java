package com.davpp.calculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MultiplierTest {
    @Test
    public void test_four_multi_two() throws Exception {
        BigDecimal param1 = new BigDecimal("4");
        BigDecimal param2 = new BigDecimal("2");
        Multiplier multiplier = new Multiplier(param1, param2);
        assertEquals(0, new BigDecimal("8").compareTo(multiplier.getResult()));
    }
}
