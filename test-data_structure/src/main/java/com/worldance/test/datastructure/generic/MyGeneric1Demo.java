package com.worldance.test.datastructure.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyGeneric1Demo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<String>();
        List<?> list2 = new ArrayList<Integer>();
        List<?> list3 = new ArrayList<Collection>();
        List<?> list4 = new ArrayList<List>();
        List<? extends List> list5 = new ArrayList<List>();//本类及其子类
        List<? extends List> list6 = new ArrayList<ArrayList>();
        List<? super List> list7 = new ArrayList<Collection>();//本类及其父类
    }

}
