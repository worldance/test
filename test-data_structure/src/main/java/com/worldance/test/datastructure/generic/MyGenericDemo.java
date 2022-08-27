package com.worldance.test.datastructure.generic;

import com.worldance.test.datastructure.list.Student;

public class MyGenericDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyGeneric<String, Integer, Student> myGen = new MyGeneric<String, Integer, Student>();
        myGen.setObj1("唐彬");
        myGen.setObj2(1221);
        myGen.setObj3(new Student("疯子", 12));
        System.out.println(myGen.getObj1());
        System.out.println(myGen.getObj2());
        System.out.println(myGen.getObj3());

        myGen.show("121");
        myGen.show(12);
    }

}
