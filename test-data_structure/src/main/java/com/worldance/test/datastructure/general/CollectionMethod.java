package com.worldance.test.datastructure.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CollectionMethod {

    /**
     * 获取1-20内的10个随机数，不能重复
     */
    public static List<Integer> randomList1(int count, int start, int end) {
        List<Integer> list = new ArrayList<Integer>();

        Random r = new Random();
        while (count > 0) {
            int val = start + r.nextInt(end - start + 1);
            if (!list.contains(val)) {
                list.add(val);
                count--;
            }

        }
        return list;
    }

    /*可变参*/
    public static List<Integer> randomList2(int... a) {
        if (a.length < 0)
            return null;

        List<Integer> list = new ArrayList<Integer>();
        int count = a[0];
        int start = 0;
        int end = Integer.MAX_VALUE - 1;

        if (a.length == 2) {
            end = a[1];
        }
        else if (a.length == 3) {
            start = a[1];
            end = a[2];
        }

        if (end - start < count) {
            count = end - start;
        }

        Set<Integer> set = new HashSet<Integer>();

        Random r = new Random();
        while (count > set.size()) {
            int val = start + r.nextInt(end - start + 1);
            set.add(val);
        }

        for (Integer i : set) {
            list.add(i);
        }

        return list;
    }

    public static List<Integer> randomList3(int... a) {
        if (a.length < 0)
            return null;

        List<Integer> list = new ArrayList<Integer>();
        int count = a[0];
        int start = 0;
        int end = Integer.MAX_VALUE - 1;

        if (a.length == 2) {
            end = a[1];
        }
        else if (a.length == 3) {
            start = a[1];
            end = a[2];
        }

        if (end - start < count) {
            count = end - start;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        Random r = new Random();
        while (count > map.keySet().size()) {
            int val = start + r.nextInt(end - start + 1);
            map.put(String.valueOf(val), val);
        }

        for (String str : map.keySet()) {
            list.add(Integer.valueOf(str));
        }

        return list;
    }

    public static List<Integer> randomList4(int... a) {
        if (a.length < 0)
            return null;

        List<Integer> list = new ArrayList<Integer>();
        int count = a[0];
        int start = 0;
        int end = Integer.MAX_VALUE - 1;

        if (a.length == 2) {
            end = a[1];
        }
        else if (a.length == 3) {
            start = a[1];
            end = a[2];
        }

        if (end - start < count) {
            count = end - start;
        }

        List<Integer> tempList = new ArrayList<Integer>();
        for (int i = start; i <= end; i++) {
            tempList.add(i);
        }

        Random r = new Random();
        while (count > 0) {
            int val = r.nextInt(tempList.size());
            list.add(tempList.remove(val));
            count--;
        }

        return list;
    }

    /*1.函数泛型。2.迭代器遍历*/
    public static <E> void printlnList(Collection<E> c) {
        System.out.println("----------------------");
        Iterator<E> itr = c.iterator();
        while (itr.hasNext()) {
            E obj = itr.next();
            if (obj.getClass() == String.class) {
                System.out.print(obj);
            }
            else {
                System.out.println(obj);
            }

        }
    }

}
