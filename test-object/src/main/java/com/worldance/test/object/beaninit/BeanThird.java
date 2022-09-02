package com.worldance.test.object.beaninit;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Data
public class BeanThird implements InitializingBean, DisposableBean {

    @Value("BeanThird：")
    private String name;

    public BeanThird() {
        System.out.println("1.BeanScan:BeanThird实例化");
    }

    public BeanThird(String name) {
        this.name = name;
        System.out.println("1." + this.name + "实例化");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2.1.初始化：" + name + "afterPropertiesSet()");
    }

    public void beanThirdInit() {
        System.out.println("2.2.初始化：" + name + "beanThirdInit()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("3.1.销毁时：" + name + "destroy()");
    }

    public void beanThirdDestroy() {
        System.out.println("3.2.销毁时：" + name + "beanThirdDestroy()");
    }
}
