package com.courseWork.Spring;

import com.courseWork.calculationClasses.Matrix;
import com.courseWork.exeptions.IllegalSizeExeption;
import com.courseWork.interfaces.CalculationMatrix;
import com.courseWork.model.OperandMatrix;
import com.courseWork.model.OperandsTwoMatrices;
import com.courseWork.model.OperandForDeterminant;
import com.courseWork.model.OperandForMultiplicationByNumber;
import com.courseWork.model.OperandsForExponent;
import com.courseWork.model.OperandsForMultiplicationByVector;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MatrixControllerTest {
    @Mock
    CalculationMatrix matrix = mock(Matrix.class);

    @Test
    void matrixAddition() {

        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{5.0, 6.0}, {7.0, 8.0}};
        final Double[][] third = {{6.0, 8.0}, {10.0, 12.0}};
        when(matrix.plus(first, second)).thenReturn(third);
        OperandsTwoMatrices operands = new OperandsTwoMatrices(first, second);
        MatrixController matrixController = new MatrixController(matrix);
        final Double[][] result = matrixController.matrixAddition(operands);
        assertArrayEquals(third, result);
    }

    @Test
    void matrixSubtraction() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{5.0, 6.0}, {7.0, 8.0}};
        final Double[][] third = {{-4.0, -4.0}, {-4.0, -4.0}};
        when(matrix.minus(first, second)).thenReturn(third);
        OperandsTwoMatrices operands = new OperandsTwoMatrices(first, second);
        MatrixController matrixController = new MatrixController(matrix);
        final Double[][] result = matrixController.matrixSubtraction(operands);
        assertArrayEquals(third, result);
    }

    @Test
    void matrixDeterminate() {
        final Double[][] first = {{1.0, 2.0,3.0}, {4.0, 5.0,6.0},{7.0,8.0,9.0}};
        when(matrix.determinate(first, first.length)).thenReturn(-2.0);
        OperandForDeterminant operand = new OperandForDeterminant(first, first.length);
        MatrixController matrixController = new MatrixController(matrix);
        final Double result = matrixController.matrixDeterminate(operand);
        assertEquals(-2.0, result.doubleValue());
    }

    @Test
    void matrixTransposing() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{1.0, 3.0}, {2.0, 4.0}};
        when(matrix.revers(first)).thenReturn(second);
        OperandMatrix operand = new OperandMatrix(first);
        MatrixController matrixController = new MatrixController(matrix);
        final Double[][] result = matrixController.matrixRevers(operand);
        assertArrayEquals(second, result);
    }

    @Test
    void matrixMultiplicationByNumber() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{2.0, 4.0}, {6.0, 8.0}};
        when(matrix.multiplicationByNumber(first,2.0)).thenReturn(second);
        OperandForMultiplicationByNumber operands = new OperandForMultiplicationByNumber(first,-2.0);
        MatrixController matrixController = new MatrixController(matrix);
        final Double[][] result = matrixController.matrixMultiplicationByNumber(operands);
        assertArrayEquals(second, result);
    }

    @Test
    void matrixMultiplication() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{5.0, 6.0}, {7.0, 8.0}};
        final Double[][] third = {{19.0, 22.0}, {43.0, 50.0}};
        when(matrix.multiplication(first,second)).thenReturn(third);
        OperandsTwoMatrices operands = new OperandsTwoMatrices(first,second);
        MatrixController matrixController = new MatrixController(matrix);
        final Double[][] result = matrixController.matrixMultiplication(operands);
        assertArrayEquals(second, result);
    }

    @Test
    void matrixMultiplicationByVector() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[] second = {1.0, 2.0};
        final Double[] third = {5.0, 11.0};
        when(matrix.multiplicationByVector(first,second)).thenReturn(third);
        OperandsForMultiplicationByVector operands = new OperandsForMultiplicationByVector(first,second);
        MatrixController matrixController = new MatrixController(matrix);
        final Double[] result = matrixController.matrixMultiplicationByVector(operands);
        assertArrayEquals(second, result);
    }

    @Test
    void matrixExponent() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{7.0, 10.0}, {15.0, 22.0}};
        when(matrix.expoonent(first,2)).thenReturn(second);
        OperandsForExponent operands = new OperandsForExponent(first,2);
        MatrixController matrixController = new MatrixController(matrix);
        final Double[][] result = matrixController.matrixExponent(operands);
        assertArrayEquals(second, result);
    }

    @Test
    void matrixRevers() {
        final Double[][] first = {{1.0, 2.0,}, {3.0, 4.0}};
        final Double[][] second = {{-2.0, 1.0}, {1.5, -0.5}};
        when(matrix.revers(first)).thenReturn(second);
        OperandMatrix operand = new OperandMatrix(first);
        MatrixController matrixController = new MatrixController(matrix);
        final Double[][] result = matrixController.matrixRevers(operand);
        assertArrayEquals(second, result);
    }
}