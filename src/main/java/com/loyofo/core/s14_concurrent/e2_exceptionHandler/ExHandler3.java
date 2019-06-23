package com.loyofo.core.s14_concurrent.e2_exceptionHandler;

public class ExHandler3 implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("****ExHandler3: 捕获线程" + t.getName() + "抛出的异常:" + e);
    }
}
