package com.worldance.test.object.beaninit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@ImportResource({"classpath:beaninit/spring-config.xml"})
public class BeanConfigure {
    @Bean
    public BeanFirst beanFirst() {
        BeanFirst beanFirst = new BeanFirst("BeanConfigure:BeanFirst");
        return beanFirst;
    }

//    @Bean
    public BeanSecond beanSecond() {
        BeanSecond beanSecond = new BeanSecond("BeanConfigure:BeanSecond");
        return beanSecond;
    }

}
