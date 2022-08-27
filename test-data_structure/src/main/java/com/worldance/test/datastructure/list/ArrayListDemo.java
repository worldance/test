package com.worldance.test.datastructure.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        List list = new ArrayList();

        Student st1 = new Student("周杰伦", 30);
        Student st2 = new Student("郭富城", 35);
        Student st3 = new Student("任贤齐", 40);
        Student st4 = new Student("周杰伦", 25);
        Student st5 = new Student("周杰伦", 30);

        list.add(st2);
        list.add(st1);
        list.add(st3);
        list.add(st4);

        System.out.println(list.contains(st5));

    }

}
