package com.worldance.test.object.test;

public class BeanInitParentTest {

    public static String parentStaticFieldA = "parentStaticFieldA";


    public String parentInstFieldA = "parentInstFieldA";

    static  {
        System.out.println("parentStaticBlockA");
    }

    {
        System.out.println("parentInstBlockA");
    }

    public BeanInitParentTest() {
        System.out.println("BeanInitParentTest-parentStaticFieldA:" + parentStaticFieldA );
        System.out.println("BeanInitParentTest-parentInstFieldA:" + parentInstFieldA);
    }
    
}
