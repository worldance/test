package com.worldance.test.object.beaninit;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BeanSecond implements DisposableBean {

    @Value("BeanSecond:")
    private String name;

    public BeanSecond() {
        System.out.println("BeanScan:BeanSecond初始化");
    }

    public BeanSecond(String name) {
        this.name = name;
        System.out.println(this.name + "初始化1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.name + "destroy()");
    }

    public void beanSecondDestroy() {
        System.out.println(this.name + "beanSecondDestroy()");
    }
}
