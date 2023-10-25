package com.bntsoft.service;

import com.bntsoft.util.CalculatorUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceImplTest {
    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @Mock
    private CalculatorUtils calculatorUtils;

    @Test
    public void testAdd() {
        Mockito.when(calculatorUtils.formatVal(30.0)).thenReturn("30");
        String formattedOutput = calculatorService.add(10, 20);
        Assertions.assertEquals("30", formattedOutput);
    }

    @Test
    public void testAddForFloatNum() {
        Mockito.when(calculatorUtils.formatVal(30.25)).thenReturn("30.25");
        String formattedOutput = calculatorService.add(10, 20.25);
        Assertions.assertEquals("30.25", formattedOutput);
    }

    @Test
    public void testSubstract() {
        Mockito.when(calculatorUtils.formatVal(10.0)).thenReturn("10");
        String formattedOutput = calculatorService.substract(20, 10);
        Assertions.assertEquals("10", formattedOutput);
    }

    @Test
    public void testSubstractForFloatNum() {
        Mockito.when(calculatorUtils.formatVal(9.5)).thenReturn("9.5");
        String formattedOutput = calculatorService.substract(20, 10.5);
        Assertions.assertEquals("9.5", formattedOutput);
    }

    @Test
    public void testMultiply() {
        Mockito.when(calculatorUtils.formatVal(200.0)).thenReturn("200");
        String formattedOutput = calculatorService.multiply(20, 10);
        Assertions.assertEquals("200", formattedOutput);
    }

    @Test
    public void testMultiplyForFloatNum() {
        Mockito.when(calculatorUtils.formatVal(10.35)).thenReturn("10.35");
        String formattedOutput = calculatorService.multiply(4.5, 2.3);
        Assertions.assertEquals("10.35", formattedOutput);
    }

    @Test
    public void testDivide() {
        Mockito.when(calculatorUtils.formatVal(2.0)).thenReturn("2");
        String formattedOutput = calculatorService.divide(20, 10);
        Assertions.assertEquals("2", formattedOutput);
    }

    @Test
    public void testDivideForFloatNum() {
        Mockito.when(calculatorUtils.formatVal(3.7714285714285714)).thenReturn("3.7714285714285714");
        String formattedOutput = calculatorService.divide(13.2, 3.5);
        Assertions.assertEquals("3.7714285714285714", formattedOutput);
    }

    @Test
    public void testSquare() {
        Mockito.when(calculatorUtils.formatVal(100.0)).thenReturn("100");
        String formattedOutput = calculatorService.square(10);
        Assertions.assertEquals("100", formattedOutput);
    }

    @Test
    public void testSquareForFloatNum() {
        Mockito.when(calculatorUtils.formatVal(110.25)).thenReturn("110.25");
        String formattedOutput = calculatorService.square(10.5);
        Assertions.assertEquals("110.25", formattedOutput);
    }

    @Test
    public void testSquareroot() {
        Mockito.when(calculatorUtils.formatVal(3)).thenReturn("3");
        String formattedOutput = calculatorService.squareroot(9);
        Assertions.assertEquals("3", formattedOutput);
    }

    @Test
    public void testSquarerootForFloatNum() {
        Mockito.when(calculatorUtils.formatVal(3.20156211871642433)).thenReturn("3.20156211871642433");
        String formattedOutput = calculatorService.squareroot(10.25);
        Assertions.assertEquals("3.20156211871642433", formattedOutput);
    }

    @Test
    public void testFactorial() {
        Mockito.when(calculatorUtils.calculateFactorial(5)).thenReturn(120);
        int result = calculatorService.factorial(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    public void testMinMax() {
        int[] intArray = new int[]{10, 20, 30, 5};
        int[] result = calculatorService.minmax(intArray);
        Assertions.assertEquals(5, result[0]);
        Assertions.assertEquals(30, result[1]);
    }

}
