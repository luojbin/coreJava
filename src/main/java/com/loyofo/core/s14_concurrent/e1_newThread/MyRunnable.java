package com.loyofo.core.s14_concurrent.e1_newThread;

/**
 * Runnable 的实现类, 重写 run 方法
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 200 == 0) {
                System.out.println("2-----Runnable 的实现类");
            }
        }
    }
}
