package com.example.individualprep.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    @DisplayName("Should return sum of two vectors when dimensions match")
    void add_Success() {
        double[] vectorA = {1.0, 2.0, 3.0};
        double[] vectorB = {4.0, 5.0, 6.0};
        double[] expectedResult = {5.0, 7.0, 9.0};

        double[] actualResult = vectorUtility.add(vectorA, vectorB);

        assertArrayEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should handle negative numbers correctly")
    void add_NegativeNumbers_Success() {
        double[] negativeVector = {-1.0, -5.0};
        double[] mixedVector = {1.0, -2.0};
        double[] expectedResult = {0.0, -7.0};

        double[] actualResult = vectorUtility.add(negativeVector, mixedVector);

        assertArrayEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should throw exception when vector dimensions mismatch")
    void add_DimensionMismatch_ThrowsException() {
        double[] vector2D = {1.0, 2.0};
        double[] vector3D = {1.0, 2.0, 3.0};

        assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(vector2D, vector3D));
    }
}