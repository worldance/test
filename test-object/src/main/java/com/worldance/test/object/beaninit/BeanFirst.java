package com.worldance.test.object.beaninit;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
@Data
public class BeanFirst {

    @Value("BeanFirst")
    private String name;

    public BeanFirst() {
        this.name = name;
        System.out.println("BeanScan:BeanFirst初始化");
    }

    public BeanFirst(String name) {
        this.name = name;
        System.out.println(this.name + "初始化1");
    }

}
