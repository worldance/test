package com.worldance.test.object.beaninit;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BeanSecond implements DisposableBean {

   private static Logger Logger = LoggerFactory.getLogger(BeanSecond.class);

    @Value("BeanSecond:")
    private String name;

    public BeanSecond() {
        Logger.info("BeanScan:BeanSecond初始化");
    }

    public BeanSecond(String name) {
        this.name = name;
        Logger.info(this.name + "初始化1");
    }

    @Override
    public void destroy() throws Exception {
        Logger.info(this.name + "destroy()");
    }

    public void beanSecondDestroy() {
        Logger.info(this.name + "beanSecondDestroy()");
    }
}
