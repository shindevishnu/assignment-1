package com.bntsoft.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorUtilsTest {
    @InjectMocks
    private CalculatorUtils calculatorUtils;

    @Test
    void testFormatVal() {
        String result = calculatorUtils.formatVal(10);
        Assertions.assertEquals("10", result);
    }
    @Test
    void testFormatValForFloatVal() {
        String result = calculatorUtils.formatVal(10.25);
        Assertions.assertEquals("10.25", result);
    }

    @Test
    void calculateFactorial() {
        int result = calculatorUtils.calculateFactorial(5);
        Assertions.assertEquals(120, result);
    }
}