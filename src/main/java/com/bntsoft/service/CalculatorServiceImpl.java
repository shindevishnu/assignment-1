package com.bntsoft.service;

import com.bntsoft.util.CalculatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Autowired
    private CalculatorUtils calculatorUtils;

    @Override
    public String add(double number1, double number2) {
        double result = number1 + number2;
        String formattedOutput = calculatorUtils.formatVal(result);
        return formattedOutput;
    }

    @Override
    public String substract(double number1, double number2) {
        double result = number1 - number2;
        String formattedOutput = calculatorUtils.formatVal(result);
        return formattedOutput;
    }

    @Override
    public String multiply(double number1, double number2) {
        double result = number1 * number2;
        String formattedOutput = calculatorUtils.formatVal(result);
        return formattedOutput;
    }

    @Override
    public String divide(double number1, double number2) {
        double result = number1 / number2;
        String formattedOutput = calculatorUtils.formatVal(result);
        return formattedOutput;
    }

    @Override
    public String square(double number) {
        double result = number * number;
        String formattedOutput = calculatorUtils.formatVal(result);
        return formattedOutput;
    }

    @Override
    public String squareroot(double number) {
        double result = Math.sqrt(number);
        String formattedOutput = calculatorUtils.formatVal(result);
        return formattedOutput;
    }

    @Override
    public int factorial(int number) {
        return calculatorUtils.calculateFactorial(number);
    }

    @Override
    public int[] minmax(int[] intArray) {
        int min = intArray[0];
        int max = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < min) {
                min = intArray[i];
            } else if (intArray[i] > max) {
                max = intArray[i];
            }
        }
        return new int[]{min, max};
    }
}
