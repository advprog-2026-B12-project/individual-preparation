package com.example.individualprep.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    @DisplayName("Subtraction with positive results")
    void sub_Positive_Success() {
        int numLow = 2;
        int numBig = 3;
        double expectedResult = 1.0;

        double actualResult = arithmeticUtility.subtract(numBig, numLow);
        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should calculate positive power correctly")
    void exponent_PositivePower_Success() {
        double base = 2.0;
        int power = 3;
        double expectedResult = 8.0;

        double actualResult = arithmeticUtility.exponent(base, power);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Subtraction resulting in negative value")
    void sub_Negative_Success() {
        int numLow = 2;
        int numBig = 3;
        double expectedResult = -1.0;

        double actualResult = arithmeticUtility.subtract(numLow, numBig);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should return 1.0 when power is zero")
    void exponent_ZeroPower_ReturnsOne() {
        double base = 123.45;
        int power = 0;
        double expectedResult = 1.0;

        double actualResult = arithmeticUtility.exponent(base, power);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Subtraction with floating point numbers")
    void sub_FloatingPoint_Success() {
        double num2 = 2.756;
        double num1 = 5.80;
        double expectedResult = 3.044;

        double actualResult = arithmeticUtility.subtract(num1, num2);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should handle negative power correctly (inverse)")
    void exponent_NegativePower_Success() {
        double base = 2.0;
        int power = -2;
        double expectedResult = 0.25;

        double actualResult = arithmeticUtility.exponent(base, power);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Multiplication of two positive numbers")
    void multiply_PositiveNumbers_Success() {
        double num1 = 4.0;
        double num2 = 5.0;
        double expectedResult = 20.0;

        double actualResult = arithmeticUtility.multiply(num1, num2);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Multiplication involving a negative number")
    void multiply_NegativeNumber_Success() {
        double num1 = -4.0;
        double num2 = 5.0;
        double expectedResult = -20.0;

        double actualResult = arithmeticUtility.multiply(num1, num2);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Multiplication by zero")
    void multiply_ByZero_Success() {
        double num1 = 4.0;
        double num2 = 0.0;
        double expectedResult = 0.0;

        double actualResult = arithmeticUtility.multiply(num1, num2);

        assertEquals(expectedResult, actualResult, 0.0001);
    }
}