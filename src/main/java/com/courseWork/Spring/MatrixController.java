package com.courseWork.Spring;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrixController {

    @RequestMapping(value = "/matrix", method = RequestMethod.POST, consumes = "text/plain")
    public String someMethod(@RequestBody String check) {
        return check;
    }

}
