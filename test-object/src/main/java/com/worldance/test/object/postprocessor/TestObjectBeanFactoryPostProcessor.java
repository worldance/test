package com.worldance.test.object.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class TestObjectBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private static Logger Logger = LoggerFactory.getLogger(TestObjectBeanFactoryPostProcessor.class);


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
        throws BeansException {
//        Logger.info("TestObjectBeanFactoryPostProcessor:postProcessBeanFactory");
    }
}
