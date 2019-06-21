package com.loyofo.core.s14_concurrent.e0_oldDemo;

/**
 * 线程优先级
 * 线程有10个优先级，分别用数字1-10表示
 * 其中1为最低优先级，5为默认优先级，10为最高优先级
 * 理论上优先级越高的线程获取CPU时间片的次数就越多, 但不保证绝对优先。
 */
public class D3_priority {
    public static void main(String[] args) {
        Thread max = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (i % 1000 == 0) {
                    System.out.println("max");
                }
            }
        });
        Thread nor = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (i % 1000 == 0) {
                    System.out.println(".............nor");
                }
            }
        });
        Thread min = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (i % 1000 == 0) {
                    System.out.println("..........................min");
                }
            }
        });

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        min.start();
        nor.start();
        max.start();
    }
}








