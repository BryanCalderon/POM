package com.taller1;

public class Person {

    private final Double weight;
    private final Double height;

    public Person(Double weight, Double height) {
        this.weight = weight;
        this.height = height;
    }

    public double calculateIMC() {
        return Math.round(weight / Math.pow(height, 2));
    }

}
