package com.loyofo.core.s14_concurrent.e2_exceptionHandler;

public class ExHandler2 implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("====ExHandler2: 捕获线程" + t.getName() + "抛出的异常:" + e);
        e.printStackTrace();
    }
}
