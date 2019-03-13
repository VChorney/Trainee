package com.courseWork.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"com.courseWork.calculationClasses","com.courseWork.interfaces"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}