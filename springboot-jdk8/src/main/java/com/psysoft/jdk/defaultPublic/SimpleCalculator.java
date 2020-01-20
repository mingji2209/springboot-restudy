package com.psysoft.jdk.defaultPublic;

public class SimpleCalculator implements Calculator {
    @Override
    public double sub(double a, double b) {
        return a*b;
    }

    @Override
    public double div(double a, double b) {
        double result = 0L;
        if(b != 0){
            result = a/b;
        }

        return result;
    }
}
