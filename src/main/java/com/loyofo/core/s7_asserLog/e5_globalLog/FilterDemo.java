package com.loyofo.core.s7_asserLog.e5_globalLog;

import java.util.logging.*;

public class FilterDemo {
    public static void main(String[] args) {
        // 为记录器设置过滤器
        Logger luojbin = Logger.getLogger("com.loyofo.log");
        luojbin.setFilter(new LuojbinFilter());

        luojbin.info("这条没有, 不应该显示");
        luojbin.info("这条有了, 应该显示 luojbin");

        // 获取另一个记录器, 不设置过滤器
        Logger logger = Logger.getLogger("com.loyofo.all");
        logger.info("还没设置过滤器, 应该显示");

        // 为处理器添加过滤器
        Handler filterHandler = new ConsoleHandler();
        filterHandler.setFilter(new LuojbinFilter());
        logger.addHandler(filterHandler);
        logger.setUseParentHandlers(false);

        logger.info("设置了过滤器, 这条不显示");
        logger.info("luojbin, 设置了过滤器, 这条也包含了, 应该显示");
    }
}

class LuojbinFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        return record.getMessage().contains("luojbin");
    }
}