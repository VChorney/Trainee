package com.courseWork.model;

import lombok.Data;

public @Data
class OperandsForExponent extends OperandMatrix {

    private int exponent;

    public OperandsForExponent(Double[][] firstMatrix) {
        super(firstMatrix);
    }

    public OperandsForExponent(Double[][] firstMatrix, int exponent) {
        super(firstMatrix);
        this.exponent = exponent;
    }
}
