package com.loyofo.core.s7_asserLog.e5_globalLog;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoLogManager {

    private static final Logger logger = Logger.getLogger("com.loyofo.log");

    public static void main(String[] args){
        logger.setLevel(Level.FINEST);
        logger.logp(Level.WARNING, "com.loyofo.core.s7_asserLog.e5_globalLog", "main", "messageDetail");

        logger.entering("className", "method", "asaas1111");

        System.out.println(111);
        Map<String, String> strMap = new HashMap<>();
        strMap.put("a1", "a1");
        strMap.put("a2", "a2");
        strMap.put("a3", "a3");
        System.out.println(strMap);
        logger.exiting("className", "method", "asaas2222");
    }
}
