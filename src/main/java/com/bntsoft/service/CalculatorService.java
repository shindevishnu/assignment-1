package com.bntsoft.service;

import java.math.BigDecimal;

public interface CalculatorService {
    public String add(double number1, double number2);

    public String substract(double number1, double number2);

    public String multiply(double number1, double number2);

    public String divide(double number1, double number2);

    public String square(double number);

    public String squareroot(double number);

    public int factorial(int number);

    public int[] minmax(int[] intArray);
}
