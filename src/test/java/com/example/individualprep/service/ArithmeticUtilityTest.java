package com.example.individualprep.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

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
    @DisplayName("Should return 1.0 when power is zero")
    void exponent_ZeroPower_ReturnsOne() {
        double base = 123.45;
        int power = 0;
        double expectedResult = 1.0;

        double actualResult = arithmeticUtility.exponent(base, power);

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
}