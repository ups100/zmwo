package com.davpp.calculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ClientTest {
    @Test
    public void test_client() throws Exception {
        String str = "1+1\r\n" + "3-2.0\r\n" + "4.3*5.8\r\n" + "8.2/2\r\n";
        Client client = new Client(str);

        client.run();
        assertEquals(0, new BigDecimal("2").compareTo(client.getResult()));

        client.run();
        assertEquals(0, new BigDecimal("1").compareTo(client.getResult()));

        client.run();
        assertEquals(0, new BigDecimal("24.94").compareTo(client.getResult()));

        client.run();
        assertEquals(0, new BigDecimal("4.1").compareTo(client.getResult()));
    }
}
