package com.worldance.test.object.beaninit;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BeanThird implements InitializingBean, DisposableBean {
    private static Logger Logger = LoggerFactory.getLogger(BeanThird.class);

    @Value("BeanThird：")
    private String name;

    public BeanThird() {
        Logger.info("1.BeanScan:BeanThird实例化");
    }

    public BeanThird(String name) {
        this.name = name;
        Logger.info("1." + this.name + "实例化");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Logger.info("2.1.初始化：" + name + "afterPropertiesSet()");
    }

    public void beanThirdInit() {
        Logger.info("2.2.初始化：" + name + "beanThirdInit()");
    }

    @Override
    public void destroy() throws Exception {
        Logger.info("3.1.销毁时：" + name + "destroy()");
    }

    public void beanThirdDestroy() {
        Logger.info("3.2.销毁时：" + name + "beanThirdDestroy()");
    }
}
