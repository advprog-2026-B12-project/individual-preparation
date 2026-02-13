package com.example.individualprep.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    @DisplayName("Should return dot product of two vectors when dimensions match")
    void dot_Success() {
        double[] vectorA = {1.0, 2.0, 3.0};
        double[] vectorB = {4.0, 5.0, 6.0};
        double expectedResult = 32.0;

        double actualResult = vectorUtility.dotProduct(vectorA, vectorB);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

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
    @DisplayName("Should return vector with all elements multiplied by scalar")
    void multiply_Scalar_Success() {
        double[] vector = {1.0, -2.0, 3.0};
        int scalar = 3;
        double[] expectedResult = {3.0, -6.0, 9.0};

        double[] actualResult = vectorUtility.multiply(vector, scalar);

        assertArrayEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should return zero vector when multiplying by zero scalar")
    void multiply_ZeroScalar_Success() {
        double[] vector = {1.0, -2.0, 3.0};
        int scalar = 0;
        double[] expectedResult = {0.0, 0.0, 0.0};

        double[] actualResult = vectorUtility.multiply(vector, scalar);

        assertArrayEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should return negative vector when multiplying by negative scalar")
    void multiply_NegativeScalar_Success() {
        double[] vector = {1.0, -2.0, 3.0};
        int scalar = -2;
        double[] expectedResult = {-2.0, 4.0, -6.0};

        double[] actualResult = vectorUtility.multiply(vector, scalar);

        assertArrayEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should handle negative numbers correctly in dot product")
    void dot_NegativeNumbers_Success() {
        double[] negativeVector = {-1.0, -5.0};
        double[] positiveVector = {1.0, 2.0};
        double expectedResult = -11.0;

        double actualResult = vectorUtility.dotProduct(negativeVector, positiveVector);

        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("dot product only works with vectors of the same dimension")
    void dot_DimensionMismatch_ThrowsException() {
        double[] vector2D = {1.0, 2.0};
        double[] vector3D = {1.0, 2.0, 3.0};

        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(vector2D, vector3D));
    }

    @Test
    @DisplayName("Should handle negative numbers correctly in addition")
    void add_NegativeNumbers_Success() {
        double[] negativeVector = {-1.0, -5.0};
        double[] mixedVector = {1.0, -2.0};
        double[] expectedResult = {0.0, -7.0};

        double[] actualResult = vectorUtility.add(negativeVector, mixedVector);

        assertArrayEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should throw exception when vector dimensions mismatch in addition")
    void add_DimensionMismatch_ThrowsException() {
        double[] vector2D = {1.0, 2.0};
        double[] vector3D = {1.0, 2.0, 3.0};

        assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(vector2D, vector3D));
    }

    @Test
    @DisplayName("Should return difference of two vectors when dimensions match")
    void subtract_Success() {
        double[] vectorA = {10.0, 5.0, 3.0};
        double[] vectorB = {4.0, 2.0, 1.0};
        double[] expectedResult = {6.0, 3.0, 2.0};

        double[] actualResult = vectorUtility.subtract(vectorA, vectorB);

        assertArrayEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should handle negative results correctly in subtraction")
    void subtract_NegativeResults_Success() {
        double[] vectorA = {1.0, 2.0};
        double[] vectorB = {5.0, 5.0};
        double[] expectedResult = {-4.0, -3.0};

        double[] actualResult = vectorUtility.subtract(vectorA, vectorB);

        assertArrayEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Should throw exception when vector dimensions mismatch in subtraction")
    void subtract_DimensionMismatch_ThrowsException() {
        double[] vector2D = {1.0, 2.0};
        double[] vector3D = {1.0, 2.0, 3.0};

        assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(vector2D, vector3D);
        });
    }

    @Test
    @DisplayName("Should return correct Euclidean norm for positive vector")
    void norm_PositiveVector_Success() {
        double[] v = {3.0, 4.0};
        double expected = 5.0;

        double actual = vectorUtility.norm(v);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    @DisplayName("Should return correct Euclidean norm for negative vector")
    void norm_NegativeVector_Success() {
        double[] v = {-3.0, -4.0};
        double expected = 5.0;

        double actual = vectorUtility.norm(v);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    @DisplayName("Should return zero when vector is zero vector")
    void norm_ZeroVector_Success() {
        double[] v = {0.0, 0.0, 0.0};
        double expected = 0.0;

        double actual = vectorUtility.norm(v);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    @DisplayName("Should throw exception when vector is empty")
    void norm_EmptyVector_ThrowsException() {
        double[] v = {};

        assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.norm(v);
        });
    }
}