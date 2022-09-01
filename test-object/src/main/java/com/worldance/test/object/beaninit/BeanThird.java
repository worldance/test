package com.worldance.test.object.beaninit;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Data
public class BeanThird {

    @Value("BeanThird")
    private String name;

    public BeanThird() {
        System.out.println("BeanScan:BeanThird初始化");
    }

    public BeanThird(String name) {
        this.name = name;
        System.out.println(this.name + "初始化1");
    }

}
