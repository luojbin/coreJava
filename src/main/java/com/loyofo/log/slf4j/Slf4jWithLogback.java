package com.loyofo.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jWithLogback {


    /*
    有两个方法可以获取日志记录器
    public static Logger getLogger(String name) 指定记录器的名字
    public static Logger getLogger(Class<?> clazz) 指定记录器所属的类
     */
    private static Logger logger = LoggerFactory.getLogger("日志器的名字, 默认显示在日志的最前面");

    public static void main(String[] args) {
        // slf4j 提供了5种级别的日志, 默认只记录前面4种, 最低级的 trace 不显示
        logger.error("这是错误日志");
        logger.warn("这是警告日志");
        logger.info("这是普通日志");
        logger.debug("这是测试日志");
        logger.trace("这是跟踪日志");

        // 可以指定格式, 使用大括号作为占位符, 生成日志时按顺序替换
        logger.info("使用占位符, 允许任意多个: {}是一个数字, {}是一个字符", 1, 'a');

        // 获取 logback 的内部状态, 如果 logback 发生错误, 会自动输出这些内部信息
        // LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // StatusPrinter.print(lc);
        /*
         使用 logback 的三个步骤
         1. 配置 logback 的环境,
         2. 在每一个需要日志的类里, 通过 LoggerFactory.getLogger 获取日志记录器, 传入类名或 class 对象作为参数
         3. 调用 logger 实例的日志方法, 包括 debug, info, warn, error
         */

        /*
        避免 appender 继承, 比如继承树 a.b.c.d
        当在c 上禁用继承, 则c 与d 的日志只会被 cd 的appender 处理, 而不会继续往上发送给 ab
         */
        ((ch.qos.logback.classic.Logger)logger).setAdditive(false);
    }

}
