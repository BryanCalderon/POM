package com.taller3.operations;

import com.taller3.Operation;

public class Suma implements Operation {

    public static String getSymbol() {
        return "+";
    }

    public Long calculate(Long val1, Long val2) {
        return val1 + val2;
    }

}
