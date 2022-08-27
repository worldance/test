package com.worldance.test.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 获取一定个数的随机数，不能重复
 *
 * @author 唐彬
 */

public class GetRandom {

    /**
     * start、end范围内获取count个随机数，start、end取闭集；
     *
     * @param count 随机数个数
     * @param start 最小数
     * @param end   最大数
     * @return
     */
    public static List<Integer> randomList1(int count, int start, int end) {
        List<Integer> list = new ArrayList<Integer>();

        Random r = new Random();
        while (count > 0) {
            int val = start + r.nextInt(end - start + 1);//r.nextInt(n)表示在0到n-1间取随机数
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

}
