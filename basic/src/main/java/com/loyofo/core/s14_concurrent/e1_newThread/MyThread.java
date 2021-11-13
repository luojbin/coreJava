package com.loyofo.core.s14_concurrent.e1_newThread;

/**
 * Thread 的子类, 重写 run 方法
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 200 == 0) {
                System.out.println("1-----Thread 的子类");
            }
        }
    }
}
