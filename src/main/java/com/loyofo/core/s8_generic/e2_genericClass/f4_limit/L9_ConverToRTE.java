package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.Test;

import java.io.FileNotFoundException;

abstract class ThreadWithAnyException {
    public static <T extends Throwable> T returnAs(Throwable t) throws T {
        // 如果是返回 T, 则会在调用处进行类型转换, 会出现类型转换异常
        return (T) t;
    }

    public static <T extends Throwable> void throwAs(Throwable t) throws T {
        // 由于类型擦除, 此处不会进行类型转换, 因此也不会抛出类型转换异常
        throw (T) t;
    }

    public abstract void body() throws Exception;

    public Thread toThread() {
        return new Thread(){
            public void run() {
                try {
                    body();
                } catch (Exception e) {
                    // 此处出现类型转换异常
                    try {
                        RuntimeException e2 = ThreadWithAnyException.<RuntimeException>returnAs(e);
                    } catch (ClassCastException e1) {
                        System.out.println("发生类型转换异常");
                    }

                    // 直接抛出, 则不会执行类型转换
                    ThreadWithAnyException.<RuntimeException>throwAs(e);
                }
            }
        };
    }
}

public class L9_ConverToRTE {
    @Test
    public void test1() {
        // 业务逻辑中可以抛出任意类型的异常
        new ThreadWithAnyException(){
            @Override
            public void body() throws Exception {
                throw new FileNotFoundException();
            }
        }.toThread().run();
    }

    @Test
    public void test2() {
        // 使用原始的Thread, 必须在业务 run 方法中捕获所有受查异常, 并包装成非受查异常
        new Thread(){
            @Override
            public void run() {
                try {
                    throw new FileNotFoundException();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }.run();
    }
}


