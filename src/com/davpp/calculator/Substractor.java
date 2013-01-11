package com.davpp.calculator;

import java.math.BigDecimal;

public class Substractor extends Expression{
    public Substractor(BigDecimal param1, BigDecimal param2) {
        super(param1,param2);
    }

    @Override
    protected void calculate() {
        result = param1.subtract(param2);
    }
}
