package com.loyofo.core.s7_asserLog.e5_globalLog;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DadAndSonLogger {

    public static final Logger dadLogger = Logger.getLogger("com.loyofo.log");

    static {
        // 为父记录器添加一个 处理器, 并关闭父处理器
        dadLogger.setLevel(Level.CONFIG);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.CONFIG);
        dadLogger.addHandler(handler);
        dadLogger.setUseParentHandlers(false);
    }
    public static void main(String[] args) {
        // 测试普通记录器的级别
        System.out.println("\n测试普通记录器的级别.....");
        Logger uncle = Logger.getLogger("com.loyofo.uncle");
        uncle.severe("-----普通记录器的 severe 信息");
        uncle.warning("-----普通记录器的 warning 信息");
        uncle.info("-----普通记录器的 info 信息");
        uncle.config("-----普通记录器的 config 信息");
        uncle.fine("-----普通记录器的 fine 信息");
        uncle.finer("-----普通记录器的 finer 信息");
        uncle.finest("-----普通记录器的 finest 信息");


        // 测试父记录器的级别
        System.out.println("\n测试父记录器的级别.....");
        dadLogger.severe("父记录器的 severe 信息");
        dadLogger.warning("父记录器的 warning 信息");
        dadLogger.info("父记录器的 info 信息");
        dadLogger.config("父记录器的 config 信息");
        dadLogger.fine("父记录器的 fine 信息");
        dadLogger.finer("父记录器的 finer 信息");
        dadLogger.finest("父记录器的 finest 信息");

        // 测试子记录器的级别
        System.out.println("\n测试子记录器的级别.....");
        Logger sonLogger = Logger.getLogger("com.loyofo.log.son");
        sonLogger.severe(">>>>子记录器的 severe 信息");
        sonLogger.warning(">>>>子记录器的 warning 信息");
        sonLogger.info(">>>>子记录器的 info 信息");
        sonLogger.config(">>>>子记录器的 config 信息");
        sonLogger.fine(">>>>子记录器的 fine 信息");
        sonLogger.finer(">>>>子记录器的 finer 信息");
        sonLogger.finest(">>>>子记录器的 finest 信息");
    }
}
