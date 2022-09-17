package com.worldance.test.object.beaninit;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
@Data
public class BeanFirst {

    private static Logger Logger = LoggerFactory.getLogger(BeanFirst.class);

    @Value("BeanFirst")
    private String name;

    public BeanFirst() {
        this.name = name;
        Logger.info("BeanScan:BeanFirst初始化");
    }

    public BeanFirst(String name) {
        this.name = name;
        Logger.info(this.name + "初始化1");
    }

}
