package com.courseWork.Spring;

import com.courseWork.interfaces.CalculationMatrix;
import com.courseWork.model.Operand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatrixController {

    @Autowired
    CalculationMatrix matrix;

    @RequestMapping(value = "/matrix/plus", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixAddition(@RequestBody Operand operand) {
        return matrix.plus(operand.getFirstMatrix(), operand.getSecondMatrix());
    }

    @RequestMapping(value = "/matrix/minus", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixSubtraction(@RequestBody Operand operand) {
        return matrix.minus(operand.getFirstMatrix(), operand.getSecondMatrix());
    }

    @RequestMapping(value = "/matrix/determinant", method = RequestMethod.POST, consumes = "application/json")
    public Double matrixDeterminate(@RequestBody Operand operand) {
        return matrix.determinate(operand.getFirstMatrix(), operand.getSize());
    }

    @RequestMapping(value = "/matrix/transposing", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixTransposing(@RequestBody Operand operand) {
        return matrix.transposing(operand.getFirstMatrix());
    }

    @RequestMapping(value = "/matrix/multiplicationByNumber", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixMultiplicationByNumber(@RequestBody Operand operand) {
        return matrix.multiplicationByNumber(operand.getFirstMatrix(), operand.getNumber());
    }

    @RequestMapping(value = "/matrix/multiplication", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixMultiplication(@RequestBody Operand operand) {
        return matrix.multiplication(operand.getFirstMatrix(), operand.getSecondMatrix());
    }

    @RequestMapping(value = "/matrix/multiplicationByVector", method = RequestMethod.POST, consumes = "application/json")
    public Double[] matrixMultiplicationByVector(@RequestBody Operand operand) {
        return matrix.multiplicationByVector(operand.getFirstMatrix(), operand.getVector());
    }

    @RequestMapping(value = "/matrix/expoonent", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixExpoonent(@RequestBody Operand operand) {
        return matrix.expoonent(operand.getFirstMatrix(), operand.getExponent());
    }

    @RequestMapping(value = "/matrix/revers", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] matrixRevers(@RequestBody Operand operand) {
        return matrix.revers(operand.getFirstMatrix());
    }
}