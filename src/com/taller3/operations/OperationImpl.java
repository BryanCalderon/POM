package com.taller3.operations;

import com.taller3.Operation;

import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class OperationImpl {

    private final HashMap<String, Operation> operations = new HashMap<>();
    private final String ecuation;

    public OperationImpl(String ecuation) {
        this.ecuation = ecuation;

        operations.put(Suma.getSymbol(), new Suma());
        operations.put(Resta.getSymbol(), new Resta());
        operations.put(Multiplicacion.getSymbol(), new Multiplicacion());
        operations.put(Division.getSymbol(), new Division());
    }

    public String execute() {
        String symbol = getSymbol();
        if (Objects.isNull(symbol)) {
            return "Operator not found";
        }

        String[] params = ecuation.split(Pattern.quote(symbol));
        long val1 = Long.parseLong(params[0]);
        long val2 = Long.parseLong(params[1]);
        return operations.get(symbol).calculate(val1, val2).toString();
    }

    public String getSymbol() {
        return operations.keySet()
                .stream()
                .filter(ecuation::contains)
                .findFirst()
                .orElse(null);
    }
}

