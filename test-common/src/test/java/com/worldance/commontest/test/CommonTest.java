package com.worldance.commontest.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

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

    @Test
    public void arrayToListTest() {
        String sqlPart = "da";
        boolean isOk = !">".equals(sqlPart) && !"<".equals(sqlPart) && !"=".equals(sqlPart) && !"<>".equals(sqlPart)
            && !">=".equals(sqlPart) && !"<=".equals(sqlPart) && !"in".equals(sqlPart) && !"not".equals(sqlPart)
            && !"like".equals(sqlPart) && !"and".equals(sqlPart) && !"or".equals(sqlPart) && !"(".equals(sqlPart)
            && !")".equals(sqlPart);

        Logger.info("equals:{}", isOk);

        String[] symbols = {">", "<", "=", "<>", ">=", "<=", "in", "not", "like", "and", "or", "(", ")"};

        Logger.info("Arrays.asList:{}", !Arrays.asList(symbols).contains(sqlPart));


    }

    @Test
    public void getEnvParamTest() {
        Logger.info("环境变量：{}", System.getenv());
        Logger.info(System.lineSeparator());
        Logger.info("环境变量PATH：{}", System.getenv("path"));
        Logger.info(System.lineSeparator());
        Logger.info("环境变量testParam：{}", System.getenv("testParam"));
        Logger.info(System.lineSeparator());
        Logger.info("properties变量：{}", System.getProperties());
        Logger.info(System.lineSeparator());
        Logger.info("properties变量testParam：{}", System.getProperty("testParam"));
    }

}
