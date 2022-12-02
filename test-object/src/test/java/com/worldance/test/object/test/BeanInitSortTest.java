package com.worldance.test.object.test;

/**
 * 测试下如下父子对象的初始化顺序
 * 1.静态字段、静态代码块
 * 2.实例字段、实例代码块
 * 3.构造方法
 *
 * 验证后加载顺序：
 * 1.1.父：静态字段、静态代码块
 * 1.2.子：静态字段、静态代码块
 * 2.1.父：实例字段、实例代码块
 * 2.2..父：构造器函数执行
 * 3.1..父：实例字段、实例代码块
 * 3.2.父：构造器函数执行
 */
public class BeanInitSortTest extends BeanInitParentTest {

    public static String staticFieldA = "staticFieldA";

    public static String staticFieldB = "staticFieldB";

    public String instFieldA = "instFieldA";

   static  {
        System.out.println("staticBlockA");
    }

    {
        System.out.println("instBlockA");

    }

    public String instFieldB = "instFieldB";

    public BeanInitSortTest() {
        System.out.println("BeanInitSortTest-staticFieldA:" + staticFieldA );
        System.out.println("BeanInitSortTest-staticFieldB:" + staticFieldB );
        System.out.println("BeanInitSortTest-instFieldA:" + instFieldA);
        System.out.println("BeanInitSortTest-instFieldB:" + instFieldB);
    }

    public static void staticMethod() {
        System.out.println("staticMethodA");
    }
    public void instMethod() {
        System.out.println("instMethodB");
    }

    public static void main(String[] args) {
        BeanInitSortTest beanInitSortTest1 = new BeanInitSortTest();
        System.out.println(System.lineSeparator());
        System.out.println("---第二次实例化不会再执行静态字段、静态代码块---");
        BeanInitSortTest beanInitSortTest2 = new BeanInitSortTest();

    }

}
