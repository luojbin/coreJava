package com.loyofo.core.s7_asserLog.e5_globalLog;

import java.io.IOException;
import java.util.logging.*;

public class DemoGlobalLog {

    public static void main(String[] args) throws IOException {
        // 设置日志开关
        Logger logger = Logger.getGlobal();
        logger.setLevel(Level.FINEST);

        // 添加一个能处理低级日志的处理器
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);
        logger.addHandler(handler);

        // 添加一个文件日志处理器, 可以指定文件名, 默认以 xml 的形式记录日志
        FileHandler fileHandler = new FileHandler("logDemo.txt", true);
        logger.addHandler(fileHandler);

        // 默认处理器会处理INFO 以上的, 因为我们已有自己的处理器,
        // 若不停用原处理器, 则 info 以上的信息会出现两次
        logger.setUseParentHandlers(false);

        // 默认能显示的日志记录
        logger.severe("这是全局日志 severe-严重");
        logger.warning("这是全局日志 warning-警告");
        logger.info("这是全局日志 info-信息");

        // 默认不显示的日志记录
        logger.config("这是全局日志 config-配置");
        logger.fine("这是全局日志 fine-详细");
        logger.finer("这是全局日志 finer-较详细");
        logger.finest("这是全局日志 finest-非常详细");

        System.out.println("主程序");
    }

}
