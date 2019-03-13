package com.courseWork.Spring;

import com.courseWork.calculationClasses.Matrix;
import com.courseWork.model.Operand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MatrixController  {

    @Autowired
    Matrix matrix;

    public MatrixController() {
    }

    @RequestMapping(value = "/matrix", method = RequestMethod.POST, consumes = "application/json")
    public Double[][] someMethod(@RequestBody Operand operand) {
        return matrix.plus(operand.getFirstMatrix(),operand.getSecondMatrix());
    }



}