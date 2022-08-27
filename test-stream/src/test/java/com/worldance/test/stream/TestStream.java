package com.worldance.test.stream;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {


    @Test
    public void testSort() {
       int[] intArr = Stream.generate(() -> new Random().nextInt(100))
           .limit(10).mapToInt(Integer::intValue).toArray();
        int[] intArr1 = IntStream.of(intArr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
       System.out.println(intArr);
       System.out.println(intArr1);
    }


}
