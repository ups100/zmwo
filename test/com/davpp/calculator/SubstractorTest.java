package com.davpp.calculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SubstractorTest {
    @Test
    public void test_two_sub_one() throws Exception {
        BigDecimal param1 = new BigDecimal("2");
        BigDecimal param2 = new BigDecimal("1");
        Substractor substractor = new Substractor(param1, param2);
        assertEquals(0, BigDecimal.ONE.compareTo(substractor.getResult()));
    }
}
