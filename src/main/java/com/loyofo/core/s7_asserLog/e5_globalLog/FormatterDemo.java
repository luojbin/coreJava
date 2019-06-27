package com.loyofo.core.s7_asserLog.e5_globalLog;

import java.util.logging.*;

public class FormatterDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("com.loyofo.log");
        logger.info("随便记录一条日志");

        Handler handler = new ConsoleHandler();
        handler.setFormatter(new LuojbinFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);

        logger.info("这条消息应该怎么显示");
    }
}

class LuojbinFormatter extends Formatter{

    @Override
    public String format(LogRecord record) {
        String originMsg = record.getMessage();
        System.out.println(originMsg);
        return "老板说这个日志要记录下来:" + record.getSourceClassName() +": "+ originMsg;
    }
}