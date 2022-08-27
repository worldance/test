package com.worldance.commontest.test;

import org.junit.jupiter.api.Test;

public class CommonTest {


    @Test
    public void commonTest() {
        String topValueStr = "99.99%";
        double callTimesRate = 100.0 / 100;
        double topValue = Double.valueOf(topValueStr.substring(0, topValueStr.length() - 1)) / 100;
        System.out.println(callTimesRate);
        System.out.println(topValue);
        System.out.println(callTimesRate < topValue);
    }

}
