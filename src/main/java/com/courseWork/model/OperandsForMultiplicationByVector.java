package com.courseWork.model;

import lombok.Data;

public @Data
class OperandsForMultiplicationByVector extends OperandMatrix {

    private Double[] vector;

    public OperandsForMultiplicationByVector(Double[][] firstMatrix, Double[] vector) {
        super(firstMatrix);
        this.vector = vector;
    }
}
