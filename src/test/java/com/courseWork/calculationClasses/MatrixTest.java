package com.courseWork.calculationClasses;

import com.courseWork.exeptions.IllegalSizeExeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    private Matrix matrix = new Matrix();

    @Test
    void testPlus() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{5.0, 6.0}, {7.0, 8.0}};
        final Double[][] third = {{6.0, 8.0}, {10.0, 12.0}};
        final Double[][] result = matrix.plus(first, second);
        assertArrayEquals(result, third);
    }

    @Test
    void testMinus() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{5.0, 6.0}, {7.0, 8.0}};
        final Double[][] third = {{-4.0, -4.0}, {-4.0, -4.0}};
        final Double[][] result = matrix.minus(first, second);
        assertArrayEquals(result, third);
    }

    @Test
    void testMultiplication() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{5.0, 6.0}, {7.0, 8.0}};
        final Double[][] third = {{19.0, 22.0}, {43.0, 50.0}};
        final Double[][] result = matrix.multiplication(first, second);
        assertArrayEquals(result, third);
    }

    @Test
    void testEmptyMatrix() {
        final Double[][] first = new Double[2][2];
        final Double[][] second = {{5.0, 6.0}, {7.0, 8.0}};
        assertThrows(NullPointerException.class, () -> matrix.plus(first, second));
    }

    @Test
    void testLegalSizeMatrix() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{5.0, 6.0}, {7.0, 8.0}};

        assertThrows(IllegalSizeExeption.class, () -> matrix.multiplication(first, second));
    }

    @Test
    void testTransposing() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{1.0, 3.0}, {2.0, 4.0}};
        final Double[][] result = matrix.transposing(first);
        assertArrayEquals(second, result);
    }

    @Test
    void testMultiplicationByNumber() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{2.0, 4.0}, {6.0, 8.0}};
        final Double[][] result = matrix.multiplicationByNumber(first, 2.0);
        assertArrayEquals(second, result);

    }

    @Test
    void testExpoonent() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{7.0, 10.0}, {15.0, 22.0}};
        final Double[][] result = matrix.expoonent(2, first);
        assertArrayEquals(second, result);
    }

    @Test
    void testDeterminate() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double result = matrix.determinate(2, first);
        assertEquals(-2.0, result.doubleValue());

    }

    @Test
    void testRevers() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{-2.0, 1.0}, {1.5, -0.5}};
        final Double[][] result = matrix.revers(first);
        assertArrayEquals(second, result);

    }

    @Test
    void testMultiplicationByVector() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[] second = {1.0, 2.0};
        final Double[] third = {5.0, 11.0};
        final Double[] result = matrix.multiplicationByVector(first, second);
        assertArrayEquals(result, third);
    }

}