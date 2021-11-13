package com.loyofo.core.s14_concurrent.e5_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 主要作用:
 * 1:控制线程数量
 * 2:重用线程
 * <p>
 * 可以将多个任务指派给线程池, 若池内线程数小于任务数, 线程会重用, 依次完成所有任务
 * 若在执行任务期间关闭线程池, 则终止所有正在执行的任务, 未开始的任务无法执行.
 */
public class ThreadPool {
    public static void main(String[] args) {
        // 创建线程池, 池内有两条线程可用
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        // 创建5个线程任务
        Runnable task1 = getRunnable(1);
        Runnable task2 = getRunnable(2);
        Runnable task3 = getRunnable(3);
        Runnable task4 = getRunnable(4);
        Runnable task5 = getRunnable(5);

        // 将5个任务添加到线程池
        threadPool.execute(task1);
        threadPool.execute(task2);
        threadPool.execute(task3);
        threadPool.execute(task4);
        threadPool.execute(task5);

        // 若不关闭线程池, 线程池会依次完成所有任务
        // 若关闭线程池, 则未执行的任务无法执行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdownNow();
        System.out.println("停止了线程池!");
    }

    public static Runnable getRunnable(int count) {
        return () -> {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ": 执行任务" + count);
                Thread.sleep(1000);
                System.out.println(t.getName() + ": 任务完毕:" + count);
            } catch (Exception e) {
                System.out.println("任务" + count + "线程被中断了!");
            }
        };
    }
}








