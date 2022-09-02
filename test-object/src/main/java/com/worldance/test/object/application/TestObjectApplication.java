package com.worldance.test.object.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.worldance.test.object")
public class TestObjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestObjectApplication.class, args);
    }

}
