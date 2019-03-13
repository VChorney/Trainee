package com.courseWork.model;

import lombok.Data;

public @Data
class Operand {
    private Double[][] firstMatrix;
    private Double[][] secondMatrix;
    private Double[] vector;
    private int exponent;
    private double number;
    private int size;

}
