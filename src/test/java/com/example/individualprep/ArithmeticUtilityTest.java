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

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Should return 1.0 when power is zero")
    void Sub_Negative_Success() {
        int numLow = 2;
        int numBig = 3;
        double expectedResult = -1.0;

        double actualResult = arithmeticUtility.subtract(numLow, numBig);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Should handle negative power correctly (inverse)")
    void sub_FloatingPoint_Success() {
        double num2 = 2.756;
        double num1 = 5.80;
        double expectedResult = 3.044;

        double actualResult = arithmeticUtility.subtract(num1, num2);

        assertEquals(expectedResult, actualResult, 0.0001);
    }
}