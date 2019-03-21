package com.courseWork.model;

import lombok.Data;

public @Data
class OperandForMultiplicationByNumber extends OperandMatrix {

    private double multiplier;

    public OperandForMultiplicationByNumber(Double[][] firstMatrix, double multiplier) {
        super(firstMatrix);
        this.multiplier = multiplier;
    }
}
