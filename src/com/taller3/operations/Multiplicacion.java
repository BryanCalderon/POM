package com.taller3.operations;

import com.taller3.Operation;

public class Multiplicacion implements Operation {

    public static String getSymbol() {
        return "*";
    }

    @Override
    public Long calculate(Long val1, Long val2) {
        return Math.multiplyExact(val1, val2);
    }

}
