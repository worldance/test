package com.worldance.test.datastructure.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Collection co = new ArrayList();
        co.add(new Object());
        co.add("adfad");
        co.add(new Date());
        co.add(new ArrayList().add("12"));
        listIterator2(co);
        List<String> list = new ArrayList<String>();

        list.add("hello");
        list.add("world");
        list.add("dance");
        list.add(3, "hihi");
        listIterator1(list);

        List<String> list2 = new ArrayList<String>();
        list2.add("hello2");
        list2.add("world2");
        list2.add("dance2");
        list2.add(3, "hihi2");

        //		list.addAll(1,list2);
        listIterator2(list);
        //		System.out.println(list.containsAll(list2));
        //
        listIterator3(list);

    }

    private static void listIterator1(List list) {
        System.out.println("listIterator1-------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void listIterator2(Collection list) {
        System.out.println("listIterator2-------------------");
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            System.out.println(obj);
        }
    }

    private static void listIterator3(List list) {
        System.out.println("listIterator3-------------------");
        ListIterator itr = list.listIterator();
        while (itr.hasNext()) {
            int ind = itr.nextIndex();
            Object obj = itr.next();
            System.out.println("index:" + ind + "," + obj.toString());

            if (obj.toString().equals("dance")) {
                itr.add("heihei");
                itr.add("haha");
                System.out.println(list.size());
            }
        }
        System.out.println("-----------------------------");
        while (itr.hasPrevious()) {
            int ind = itr.previousIndex();
            Object obj = itr.previous();
            //			int ind = itr.previousIndex();
            System.out.println("index:" + ind + "," + obj.toString());
        }
    }

}
