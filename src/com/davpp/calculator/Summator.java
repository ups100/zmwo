package com.davpp.calculator;

import java.math.BigDecimal;

public class Summator extends Expression{
    public Summator(BigDecimal param1, BigDecimal param2) {
        super(param1, param2);
    }

    @Override
    protected void calculate() {
        result = param1.add( param2);
    }
}
