package com.davpp.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.math.BigDecimal;

public class Client {
    private BufferedReader in;
    private BigDecimal result;

    public Client(String str) {
        in = new BufferedReader(new InputStreamReader(new StringBufferInputStream(str)));
    }
    public Client() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        String line = readLine();
        try {
            ExpressionParser parser = new ExpressionParser(line);
            Expression expression = parser.getExpression();
            result = expression.getResult();
        } catch (InvalidNumericFormatException e) {
            System.out.println("Invalid input numeric format");
        } catch (DivideByZeroException e) {
            System.out.println("the second parameter in Divider can't be zero");
        }
    }
    private String readLine() {
        String str = null;
        try {
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            closeIn();
        }
        return str;
    }

    private void closeIn() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BigDecimal getResult() {
        return result;
    }

    public static void main(String[] args) {
        Client client = new Client();
        while (true) {
            client.run();
        }
    }
}
