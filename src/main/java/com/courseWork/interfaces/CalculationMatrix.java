package com.courseWork.interfaces;

public interface CalculationMatrix {

    Double[][] transposing(Double[][] matrix);

    Double[][] multiplicationByNumber(Double[][] matrix, final Double NUMBER);

    Double[][] multiplication(final Double[][] firstMatrix, final Double[][] secondMatrix);

    Double[][] expoonent(final int EXPONENT, Double[][] matrix);

    Double determinate(final int SIZE, Double[][] matrix);

    Double[][] revers(Double[][] matrix);

    Double[] multiplicationByVector(Double[][] matrix, Double[] vector);


}
