package com.worldance.commontest.testinterface;

public interface IDefaultMethod {

    default void defaultMethod(String str) {
        System.out.println(str);
    }

    static void defaultStaticMethod(String str) {
        System.out.println(str);
    }

}
