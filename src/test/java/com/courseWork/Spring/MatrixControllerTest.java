package com.courseWork.Spring;

import com.courseWork.calculationClasses.Matrix;
import com.courseWork.interfaces.CalculationMatrix;
import com.courseWork.model.OperandMatrix;
import com.courseWork.model.OperandsTwoMatrices;
import com.courseWork.model.OperandForDeterminant;
import com.courseWork.model.OperandForMultiplicationOnNumber;
import com.courseWork.model.OperandsForExponent;
import com.courseWork.model.OperandsForMultiplicationOnVector;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MatrixControllerTest {
    @Mock
    MatrixController matrixController = new MatrixController(mock(Matrix.class));
    @Test
    void matrixAddition() {

        final Double[][] third = {{6.0, 8.0}, {10.0, 12.0}};
        when(matrixController.matrixAddition((new OperandsTwoMatrices()))).thenReturn(third);
        assertArrayEquals(matrixController.matrixAddition(new OperandsTwoMatrices()), third);
    }

    @Test
    void matrixSubtraction() {

    }

    @Test
    void matrixDeterminate() {
    }

    @Test
    void matrixTransposing() {
    }

    @Test
    void matrixMultiplicationByNumber() {
    }

    @Test
    void matrixMultiplication() {
    }

    @Test
    void matrixMultiplicationByVector() {
    }

    @Test
    void matrixExponent() {
    }

    @Test
    void matrixRevers() {
    }
}