package com.courseWork.model;

import lombok.Data;

public @Data
class OperandsTwoMatrices extends OperandMatrix{
    private Double[][] secondMatrix;

    public OperandsTwoMatrices(Double[][] firstMatrix, Double[][] secondMatrix) {
        super(firstMatrix);
        this.secondMatrix = secondMatrix;
    }
}
