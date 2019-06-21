package com.loyofo.core.s14_concurrent.e0_oldDemo;
/**
 * █ 线程的创建方式:
 * 1. 继承 Thread 并重写 run 方法
 * 2. 实现 Runnable 并重写 run 方法, 利用其对象创建新的 thread 对象
 * 3. 通过匿名内部类创建 Thread 子类对象, 或 Runnable 实现类对象
 * 4. 通过 lambda 表达式创建 Thread 子类对象, 或 Runnable 实现类对象
 *
 * █ 启动线程:
 * 创建线程后, 通过 thread.start() 方法启动线程。
 * 当start方法调用后，线程纳入到线程调度中。run方法在获取CPU时间片后自动调用。
 *
 * 线程对于线程调度的工作是不能控制的。
 * 时间片分配给哪个线程，时间片的长短线程都不可控。线程只能被动的被分配时间片。
 * 线程调度尽可能均匀的将时间片分配给每个线程，但不保证"一人一次"的分配模式
 *
 * █ 继承 Thread 的缺点
 * 1:继承冲突: 由于java是单继承的，这就导致不能去继承其他类，会存在继承冲突问题。
 * 2:线程耦合: 由于重写了线程的run方法，这就导致该线程只会运行 run 方法中的任务，存在任务与线程的强耦合关系，不利于线程重用。
 */
public class D1_newThread {
    public static void main(String[] args) {
        // 方法1, 新建 Thread 子类的对象
        Thread t1 = new MyThread1();

        // 方法2, 新建 Runnable 实现类的对象, 再创建相应的 thread 对象
        Thread t2 = new Thread(new MyRunnable1());

        // 方法3-1, 使用匿名内部类的创建 Thread 的子类对象。
        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i % 200 == 0) {
                        System.out.println("3.1-----Thread 的匿名子类");
                    }
                }
            }
        };

        // 方法3-2, 使用匿名内部类创建 Runnable 实现类的对象, 再创建相应的 thread 对象
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i % 200 == 0) {
                        System.out.println("3.2-----Runnable 的匿名实现类");
                    }
                }
            }
        };
        Thread t4 = new Thread(r2);

        // 方法4-1, 使用 lambda 表达式创建 Thread 子类对象
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                if (i % 200 == 0) {
                    System.out.println("4.1-----Thread 的匿名子类, lambda 形式");
                }
            }
        });

        // 方法4-2, 使用 lambda 表达式创建 Runnable 实现类对象, 再创建相应的 thread 对象
        Runnable r3 = () -> {
            for (int i = 0; i < 1000; i++) {
                if (i % 200 == 0) {
                    System.out.println("4.2-----Runnable 的匿名实现类, lambda 形式");
                }
            }
        };
        Thread t6 = new Thread(r3);

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}

/**
 * Thread 的子类, 重写 run 方法
 */
class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 200 == 0) {
                System.out.println("1-----Thread 的子类");
            }
        }
    }
}

/**
 * Runnable 的实现类, 重写 run 方法
 */
class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 200 == 0) {
                System.out.println("2-----Runnable 的实现类");
            }
        }
    }
}














