package com.calculator;

import org.junit.*;

public class CalculatorTests {
    
    private Calculator calculator;
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int a = 15;
        int b = 20;
        int expectedResult = 35;
        long result = calculator.add(a, b);
        Assert.assertEquals(expectedResult, result);;
    }

    @Test
    public void testSubtract() {
        int a = 25;
        int b = 20;
        int expectedResult = 5;
        long result = calculator.subtract(a, b);
        Assert.assertEquals(expectedResult, result);;
    }

    @Test
    public void testMultiply() {
        int a = 10;
        int b = 25;
        long expectedResult = 250;
        long result = calculator.multiply(a, b);
        Assert.assertEquals(expectedResult, result);;
    }
    
}
