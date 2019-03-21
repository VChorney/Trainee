package com.courseWork.model;

import lombok.Data;

public @Data
class OperandMatrix {

    protected Double[][] firstMatrix;

    public OperandMatrix() {
    }

    public OperandMatrix(Double[][] firstMatrix) {
        this.firstMatrix = firstMatrix;
    }
}
