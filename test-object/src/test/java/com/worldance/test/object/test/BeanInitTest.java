package com.worldance.test.object.test;

import com.worldance.test.object.beaninit.BeanConfigure;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Arrays;

public class BeanInitTest {

    ApplicationContext applicationContext = null;

    @BeforeTestClass
    public void initAppliaction() {
        applicationContext = new AnnotationConfigApplicationContext(BeanConfigure.class);
    }

    @Test
    public void configBeanInitTest() {
        applicationContext = new AnnotationConfigApplicationContext(BeanConfigure.class);
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
        System.out.println(applicationContext.getBean("beanFirst"));
    }

    @Test
    public void xmlBeanInitTest() {
        applicationContext = new GenericXmlApplicationContext("classpath:beaninit/spring-config.xml");
        System.out.println(applicationContext.getBean("beanFirst"));
    }

}
