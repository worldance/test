package com.worldance.test.datastructure.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("12");
        list.add("222");
        //		list.add(12);

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

}