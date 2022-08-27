package com.worldance.test.datastructure.general;

import java.util.List;

import com.worldance.test.algorithm.GetRandom;

public class CollectionMethodDemo {

    public static void main(String[] args) {
        List<Integer> randomList1 = GetRandom.randomList1(10, 30, 50);
        CollectionMethod.printlnList(randomList1);

        List<Integer> randomList2 = GetRandom.randomList2(10, 45, 50);
        CollectionMethod.printlnList(randomList2);

        List<Integer> randomList3 = GetRandom.randomList3(10, 100, 2000);
        CollectionMethod.printlnList(randomList3);

        List<Integer> randomList4 = GetRandom.randomList4(10, 100, 110);
        CollectionMethod.printlnList(randomList4);
    }

}
