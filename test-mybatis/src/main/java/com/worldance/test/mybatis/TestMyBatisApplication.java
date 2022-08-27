package com.worldance.test.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@MapperScan(basePackages = "com.worldance.test.mybatis.dao")
@ImportResource({"classpath*:spring.xml", "classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml"})
@SpringBootApplication
public class TestMyBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestMyBatisApplication.class, args);
    }

}
