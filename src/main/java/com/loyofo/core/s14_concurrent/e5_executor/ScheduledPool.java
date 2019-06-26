package com.loyofo.core.s14_concurrent.e5_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * 主要作用:
 * 1:控制线程数量
 * 2:重用线程
 * <p>
 * 可以将多个任务指派给线程池, 若池内线程数小于任务数, 线程会重用, 依次完成所有任务
 * 若在执行任务期间关闭线程池, 则终止所有正在执行的任务, 未开始的任务无法执行.
 */
public class ScheduledPool {
    public static void main(String[] args) {
        // 创建线程池, 池内有两条线程可用
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

        // 任务1, 每1000ms执行一次
        Runnable task1 = () -> System.out.println("当前时间: " + System.currentTimeMillis());

        // 任务2, 重复3次, 间隔500
        Runnable task2 = () -> {
            System.out.println("敲敲敲, penny");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("敲敲敲, 敲完了");
        };

        // 任务1, 每1000ms执行一次
        threadPool.scheduleAtFixedRate(task1, 0, 1000, TimeUnit.MILLISECONDS);
        threadPool.scheduleWithFixedDelay(task2, 0, 5000, TimeUnit.MILLISECONDS);


        // 若不关闭线程池, 线程池会依次完成所有任务
        // 若关闭线程池, 则未执行的任务无法执行
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // threadPool.shutdownNow();
        // System.out.println("停止了线程池!");
    }

}








