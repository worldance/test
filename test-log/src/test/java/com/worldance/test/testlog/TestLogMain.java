package com.worldance.test.testlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogMain {
    private static Logger Logger = LoggerFactory.getLogger(TestLogMain.class);
    public static void main(String[] args) {
        Logger.debug("debug日志");
        Logger.info("info日志");
        Logger.warn("warn日志");
        Logger.error("error日志");
        Logger.trace("trace日志");
    }

}
