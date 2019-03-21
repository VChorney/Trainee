package com.courseWork.model;

import lombok.Data;

public @Data
class OperandForDeterminant extends OperandMatrix {

    private int size;

    public OperandForDeterminant(Double[][] firstMatrix, int size) {
        super(firstMatrix);
        this.size = size;
    }
}
