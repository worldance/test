package com.worldance.test.object.postprocessor;

import com.worldance.test.object.beaninit.BeanThird;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestObjectBeanPostProcessor implements BeanPostProcessor {
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(TestObjectBeanPostProcessor.class);


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        Logger.info(beanName + ":TestObjectBeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        Logger.info(beanName + ":TestObjectBeanPostProcessor,postProcessAfterInitialization");
        return bean;
    }
}
