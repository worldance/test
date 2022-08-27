package com.worldance.test.datastructure.general;

import com.worldance.test.datastructure.list.Student;

public class ArgsDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Student a = new Student("a", 1);
        Student b = new Student("b", 2);
        Student c = new Student("c", 3);
        Student d = new Student("d", 4);

        System.out.println(sum1(a, b));
        System.out.println(sum1(a, b, c));
        System.out.println(sum1(a, b, c, d));
    }

    private static String sum1(Student... a) {
        String sum = "";
        for (Student i : a) {
            sum += i.getName();
        }

        return sum;
    }

}
