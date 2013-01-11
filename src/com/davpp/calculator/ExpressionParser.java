package com.davpp.calculator;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {
    private String formular;
    private String regex = "(-?\\d+)(\\.\\d+)?([+-//*/])(-?\\d+)(\\.\\d+)?";
    private BigDecimal param1;
    private BigDecimal param2;
    private Expression expression;

    public ExpressionParser(String formular) {
        this.formular = formular;
        parse();
    }

    private void parse() {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(formular);
        if (m.matches()) {
            param1 = getParam(m.group(1), m.group(2));
            param2 = getParam(m.group(4), m.group(5));
            expression = matchExpression(m.group(3).charAt(0));
        } else
            throw new InvalidNumericFormatException();
    }

    private Expression matchExpression(char symbol) {
        switch (symbol) {
            case '+':
                return new Summator(param1, param2);
            case '-':
                return new Substractor(param1, param2);
            case '*':
                return new Multiplier(param1, param2);
            case '/':
                return new Divider(param1, param2);
        }
        return null;
    }

    private BigDecimal getParam(String group1, String group2) {
        BigDecimal param;
        if (group2 != null)
            param = new BigDecimal(group1 + group2);
        else
            param = new BigDecimal(group1);
        return param;
    }

    public BigDecimal getParam1() {
        return param1;
    }

    public BigDecimal getParam2() {
        return param2;
    }

    public Expression getExpression() {
        return expression;
    }
}
