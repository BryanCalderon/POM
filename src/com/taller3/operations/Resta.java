package com.taller3.operations;

import com.taller3.Operation;

public class Resta implements Operation {

    public static String getSymbol() {
        return "-";
    }

    @Override
    public Long calculate(Long val1, Long val2) {
        return val1 - val2;
    }

}
