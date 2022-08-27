package com.worldance.test.datastructure.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.worldance.test.datastructure.general.GenericClass.Animal;
import com.worldance.test.datastructure.general.GenericClass.ChongChong;
import com.worldance.test.datastructure.general.GenericClass.dog;
import com.worldance.test.datastructure.general.GenericClass.hotDog;

public class GeneralDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("张三");
        list.add("李四");
        list.add("王五");

        Object[] objArray = list.toArray();

        System.out.println("1---------------");
        for (Object obj : objArray) {
            System.out.println(obj);
        }

        String[] strArray = new String[list.size()];
        String[] strArray1 = list.toArray(strArray);

        System.out.println("2---------------");
        for (String str : strArray) {
            System.out.println(str);
        }
        System.out.println("3---------------");
        for (int i = 0; i < strArray1.length; i++) {
            System.out.println(strArray1[i]);
        }

        List<String> asList = Arrays.asList(strArray);
        System.out.println("4---------------");
        Iterator<String> itr = asList.iterator();
        while (itr.hasNext()) {
            String str = itr.next();
            System.out.println(str);
        }

        //		asList.add("陆六");
        //		asList.remove(2);
        asList.set(2, "陆六");
        System.out.println("5---------------");
        for (int i = 0; i < asList.size(); i++) {
            System.out.println(asList.get(i));
        }

        CollectionMethod.printlnList(asList);

        System.out.println("泛型测试---------------");

        GenericClass<Animal> ge1 = new GenericClass<Animal>();
        //		GenericClass<? extends Animal> ge2 = new GenericClass<Object>(); //父类，报错
        GenericClass<? extends Animal> ge3 = new GenericClass<Animal>(); //本身
        GenericClass<? extends Animal> ge4 = new GenericClass<dog>(); //继承
        GenericClass<? extends Animal> ge5 = new GenericClass<hotDog>(); //继承

        GenericClass<? extends ChongChong> ge51 = new GenericClass<dog>(); //继承
        GenericClass<? super hotDog> ge52 = new GenericClass<ChongChong>(); //继承

        GenericClass<? super Animal> ge6 = new GenericClass<Object>(); //父类
        GenericClass<? super Animal> ge7 = new GenericClass<Animal>(); //本身
        //		GenericClass<? super Animal> ge8 = new GenericClass<dog>(); //继承,报错
        //		GenericClass<? super Animal> ge9 = new GenericClass<hotDog>(); //继承,报错

    }

}
