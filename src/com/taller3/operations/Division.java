package com.taller3.operations;

import com.taller3.Operation;

public class Division implements Operation {

    public static String getSymbol() {
        return "/";
    }

    @Override
    public Long calculate(Long val1, Long val2) {
        return Math.floorDiv(val1, val2);
    }


}
