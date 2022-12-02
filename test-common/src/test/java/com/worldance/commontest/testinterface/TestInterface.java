package com.worldance.commontest.testinterface;

public class TestInterface {
    public static void main(String[] args) {
        IDefaultMethod defaultMethod = new DefaultMethodImpl();
        defaultMethod.defaultMethod("测试接口默认方法");
        IDefaultMethod.defaultStaticMethod("接口中的静态方法！");
    }

}
