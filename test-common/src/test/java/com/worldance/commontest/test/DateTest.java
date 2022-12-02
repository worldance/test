package com.worldance.commontest.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

public class DateTest {

    private static Logger Logger  = LoggerFactory.getLogger(DateTest.class);


    public static void main(String[] args) {
        Logger.info("1");
        Logger.info("2");
        try {
            Thread.sleep(50000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.info("testFun:{}", testFun(1, 2));
        try {
            Thread.sleep(1000000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.info("3");
    }

    public static int testFun(int a, int b) {
        int c;
        c = a+ b;
        return c;
    }



    @Test
    public void testCalendar() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.MILLISECOND, 0);
        Logger.info("calendar1第一次获取时间：{},{}", calendar1.getTime(), calendar1.getTimeInMillis());

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.MILLISECOND, 0);
        Logger.info("calendar2第一次获取时间：{},{}", calendar1.getTime(), calendar2.getTimeInMillis());
        try {
            Thread.sleep(20);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


        Logger.info("calendar1第二次获取时间：{}", calendar1.getTimeInMillis());



    }


}
