package com.courseWork.calculationClasses;

import com.courseWork.exeptions.IllegalSizeExeption;
import com.courseWork.interfaces.CalculationMatrix;
import org.springframework.stereotype.Component;

@Component
public class Matrix implements CalculationMatrix {

    private enum Operation {PLUS, MINUS}

    private Double[][] plusAndMinus(Double[][] firstMatrix, Double[][] secondMatrix, Operation operation) {

        for (int i = 0; i < firstMatrix.length; i++) {

            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (operation == Operation.PLUS) {
                    firstMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
                } else
                    firstMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return firstMatrix;
    }

    @Override
    public Double[][] plus(Double[][] firstMatrix, Double[][] secondMatrix) {
        return plusAndMinus(firstMatrix, secondMatrix, Operation.PLUS);
    }

    @Override
    public Double[][] minus(Double[][] firstMatrix, Double[][] secondMatrix) {
        return plusAndMinus(firstMatrix, secondMatrix, Operation.MINUS);
    }

    @Override
    public Double[][] multiplication(Double[][] firstMatrix, Double[][] secondMatrix) throws IllegalSizeExeption {

        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalSizeExeption("Columns of first matrix must be equal to rows of second matrix");
        }


        Double[][] matrix = new Double[firstMatrix[0].length][secondMatrix.length];

        for (int i = 0; i < firstMatrix.length; ++i) {
            for (int j = 0; j < secondMatrix[0].length; ++j) {
                matrix[i][j] = 0.0;
                for (int k = 0; k < secondMatrix.length; ++k) {
                    matrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return matrix;
    }

    @Override
    public Double[][] transposing(Double[][] matrix) {
        Double[][] buffer = new Double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                buffer[j][i] = matrix[i][j];
            }
        }
        return buffer;
    }

    @Override
    public Double[][] multiplicationByNumber(Double[][] matrix, Double multiplier) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * multiplier;
            }
        }
        return matrix;
    }

    @Override
    public Double[][] expoonent(Double[][] matrix, int exponent) {
        Double[][] buffer = matrix;
        for (int t = 1; t < exponent; t++) {
            matrix = multiplication(buffer, matrix);

        }
        return matrix;
    }

    @Override
    public Double determinate(Double[][] matrix, int size) {
        double determinate;
        if (size == 1) {
            determinate = matrix[0][0];

        } else if (size == 2) {
            determinate = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        } else {
            determinate = 0;
            Double[][] buffer = new Double[size][size];
            for (int k = 0; k < size; k++) {
                for (int i = 1; i < size; i++) {
                    int j1 = 0;
                    for (int j = 0; j < size; j++) {
                        if (j == k) {
                            continue;
                        }
                        buffer[i - 1][j1] = matrix[i][j];
                        j1++;
                    }
                }
                determinate += Math.pow(-1.0, 1.0 + k + 1.0) * matrix[0][k] * determinate(buffer, size - 1);
            }
        }
        return determinate;
    }

    @Override
    public Double[][] revers(Double[][] matrix) {
        Double[][] minor = new Double[matrix.length - 1][matrix.length - 1];
        Double[][] united = new Double[matrix.length][matrix.length];
        Double[][] buffer;

        int k, k1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                k = 0;
                k1 = 0;
                for (int i1 = 0; i1 < matrix.length; i1++) {
                    for (int j1 = 0; j1 < matrix.length; j1++) {
                        if ((i != i1) && (j != j1)) {
                            minor[k][k1++] = matrix[i1][j1];
                            if (k1 == matrix.length - 1) {
                                k1 = 0;
                                k++;
                            }
                        }
                    }
                }
                united[i][j] = Math.pow(-1, i + j) * determinate(minor, matrix.length - 1);
            }
        }
        buffer = transposing(united);
        Double[][] result = new Double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                result[i][j] = buffer[i][j] / determinate(matrix, matrix.length);
            }
        }
        return result;
    }

    @Override
    public Double[] multiplicationByVector(Double[][] matrix, Double[] vector) {
        Double[] buffer = new Double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            buffer[i] = 0.0;
            for (int j = 0; j < matrix[0].length; j++) {
                buffer[i] += vector[j] * matrix[i][j];
            }
        }
        return buffer;
    }
    @Override
    public int pr(){return 2;}
}

