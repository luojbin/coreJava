package com.loyofo.core.s7_asserLog.e5_globalLog;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoLogManager {

    private static final Logger logger = Logger.getLogger("com.loyofo.log");

    public static void main(String[] args){
        logger.setLevel(Level.FINEST);

        // 需要添加处理器, 才能输出到控制台, 否则控制台只能输出默认的三种级别
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);
        logger.addHandler(handler);

        logger.info("默认方式记录的 INFO 日志");
        logger.finest("默认方式记录的 finest 日志");
        logger.logp(Level.FINEST, "com.loyofo.core.s7_asserLog.e5_globalLog.DemoLogManager", "main", "这是 logp 方法记录的日志");

        testLogMethod("测试方法, 这是参数");
        testLogMethod("测试方法, 这是参数2");
    }

    static String testLogMethod(String param) {
        logger.entering("com.loyofo.core.s7_asserLog.e5_globalLog.DemoLogManager", "testLogMethod", param);
        System.out.println(">>>>>>>方法内部, 具体操作<<<<<<");
        String result = "这是返回结果";
        int a = 5;
        System.out.println(a);
        logger.exiting("com.loyofo.core.s7_asserLog.e5_globalLog.DemoLogManager", "testLogMethod", result);
        return result;
    }
}
