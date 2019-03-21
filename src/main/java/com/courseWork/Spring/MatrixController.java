package com.courseWork.Spring;

import com.courseWork.interfaces.CalculationMatrix;
import com.courseWork.model.OperandsForExponent;
import com.courseWork.model.OperandMatrix;
import com.courseWork.model.OperandsForMultiplicationByVector;
import com.courseWork.model.OperandsTwoMatrices;
import com.courseWork.model.OperandForMultiplicationByNumber;
import com.courseWork.model.OperandForDeterminant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matrix")
public class MatrixController {

    private CalculationMatrix matrix;

    @Autowired
    public MatrixController(CalculationMatrix matrix) {
        this.matrix = matrix;
    }


    @RequestMapping(value = "/plus", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixAddition(@RequestBody OperandsTwoMatrices operand) {
        return matrix.plus(operand.getFirstMatrix(), operand.getSecondMatrix());
    }

    @RequestMapping(value = "/minus", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixSubtraction(@RequestBody OperandsTwoMatrices operand) {
        return matrix.minus(operand.getFirstMatrix(), operand.getSecondMatrix());
    }

    @RequestMapping(value = "/determinant", method = RequestMethod.POST, consumes = "application/json")
    public Double matrixDeterminate(@RequestBody OperandForDeterminant operand) {
        return matrix.determinate(operand.getFirstMatrix(), operand.getSize());
    }

    @RequestMapping(value = "/transposing", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixTransposing(@RequestBody OperandMatrix operand) {
        return matrix.transposing(operand.getFirstMatrix());
    }

    @RequestMapping(value = "/multiplicationByNumber", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixMultiplicationByNumber(@RequestBody OperandForMultiplicationByNumber operand) {
        return matrix.multiplicationByNumber(operand.getFirstMatrix(), operand.getMultiplier());
    }

    @RequestMapping(value = "/multiplication", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixMultiplication(@RequestBody OperandsTwoMatrices operand) {
        return matrix.multiplication(operand.getFirstMatrix(), operand.getSecondMatrix());
    }

    @RequestMapping(value = "/multiplicationByVector", method = RequestMethod.POST, consumes = "application/json")
    public Double[] matrixMultiplicationByVector(@RequestBody OperandsForMultiplicationByVector operand) {
        return matrix.multiplicationByVector(operand.getFirstMatrix(), operand.getVector());
    }

    @RequestMapping(value = "/expoonent", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixExponent(@RequestBody OperandsForExponent operand) {
        return matrix.expoonent(operand.getFirstMatrix(), operand.getExponent());
    }

    @RequestMapping(value = "/revers", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixRevers(@RequestBody OperandMatrix operand) {
        return matrix.revers(operand.getFirstMatrix());
    }
}