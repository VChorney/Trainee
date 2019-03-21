package com.courseWork.interfaces;

public interface CalculationMatrix {

    Double[][] plus(Double[][] firstMatrix, Double[][] secondMatrix);

    Double[][] minus(Double[][] firstMatrix, Double[][] secondMatrix);

    Double[][] transposing(Double[][] matrix);

    Double[][] multiplicationByNumber(Double[][] matrix, Double number);

    Double[][] multiplication(Double[][] firstMatrix, Double[][] secondMatrix);

    Double[][] expoonent(Double[][] matrix, int exponent);

    Double determinate(Double[][] matrix, int size);

    Double[][] revers(Double[][] matrix);

    Double[] multiplicationByVector(Double[][] matrix, Double[] vector);


}
