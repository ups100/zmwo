package com.davpp.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Divider extends Expression{
    public Divider(BigDecimal param1, BigDecimal param2) {
        super(param1, param2);
    }

    @Override
    protected void calculate() {
        if (new BigDecimal("0").compareTo(param2) == 0) {
            throw new DivideByZeroException();
        }
        result = param1.divide(param2,new MathContext(10, RoundingMode.HALF_UP));
    }
}
