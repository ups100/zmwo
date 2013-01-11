package com.davpp.calculator;

import java.math.BigDecimal;

public abstract class Expression {
    protected BigDecimal param1;
    protected BigDecimal param2;
    protected BigDecimal result;

    public Expression(BigDecimal param1, BigDecimal param2) {
        this.param1 = param1;
        this.param2 = param2;
        calculate();
    }

    abstract protected void calculate();

    public BigDecimal getResult(){
        return result;
    }
}
