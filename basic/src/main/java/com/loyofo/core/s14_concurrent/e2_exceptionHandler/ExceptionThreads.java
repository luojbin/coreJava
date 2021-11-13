package com.loyofo.core.s14_concurrent.e2_exceptionHandler;

public class ExceptionThreads {
    public static void main(String[] args) throws InterruptedException {
        ExHandler1 handler1 = new ExHandler1();
        ExHandler2 handler2 = new ExHandler2();
        ExHandler3 handler3 = new ExHandler3();

        Thread t1 = new Thread(() -> {
            throw new RuntimeException("随便抛一个 RuntimeException");
        });
        Thread t2 = new Thread(() -> {
            throw new NullPointerException("随便抛一个 NullPointerException");
        });
        Thread t3 = new Thread(() -> {
            throw new IndexOutOfBoundsException("随便抛一个 IndexOutOfBoundsException");
        });

        // 为指定线程配置异常处理器, 出现异常时由异常处理器处理
        t1.setUncaughtExceptionHandler(handler1);
        t2.setUncaughtExceptionHandler(handler2);
        // 配置默认异常处理器, 处理未指定异常处理器的线程抛出的异常
        Thread.setDefaultUncaughtExceptionHandler(handler3);
        // 若不配置默认异常处理器, 线程抛出的异常最终会通过 System.err 输出.

        Thread.sleep(100);
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();
    }

}
