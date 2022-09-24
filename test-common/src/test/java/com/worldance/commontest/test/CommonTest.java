package com.worldance.commontest.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonTest {

    private static Logger Logger  = LoggerFactory.getLogger(CommonTest.class);


    @Test
    public void commonTest() {
        String topValueStr = "99.99%";
        double callTimesRate = 100.0 / 100;
        double topValue = Double.valueOf(topValueStr.substring(0, topValueStr.length() - 1)) / 100;
        System.out.println(callTimesRate);
        System.out.println(topValue);
        System.out.println(callTimesRate < topValue);
    }

    @Test
    public void instanceTest() {
        String str = null;
        Logger.info("str instanceof String : {}", str instanceof String);

        str = "";
        Logger.info("str instanceof String : {}", str instanceof String);
    }

}
