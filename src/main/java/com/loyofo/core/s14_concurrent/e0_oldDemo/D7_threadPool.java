package com.loyofo.core.s14_concurrent.e0_oldDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 主要作用:
 * 1:控制线程数量
 * 2:重用线程
 *
 * 可以将多个任务指派给线程池, 若池内线程数小于任务数, 线程会重用, 依次完成所有任务
 * 若在执行任务期间关闭线程池, 则终止所有正在执行的任务, 未开始的任务无法执行.
 */
public class D7_threadPool {
	public static void main(String[] args) {
		// 创建线程池, 池内有两条线程可用
		ExecutorService threadPool = Executors.newFixedThreadPool(2);

		//
		Runnable task1 = () -> {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName() + ": 执行任务1");
				Thread.sleep(1000);
				System.out.println(t.getName() + ": 111运行任务完毕");
			} catch (Exception e) {
				System.out.println("任务1线程被中断了!");
			}
		};
		Runnable task2 = () -> {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName() + ": 执行任务2");
				Thread.sleep(1000);
				System.out.println(t.getName() + ": 222运行任务完毕");
			} catch (Exception e) {
				System.out.println("任务2线程被中断了!");
			}
		};
		Runnable task3 = () -> {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName() + ": 执行任务3");
				Thread.sleep(1000);
				System.out.println(t.getName() + ": 333运行任务完毕");
			} catch (Exception e) {
				System.out.println("任务3线程被中断了!");
			}
		};
		Runnable task4 = () -> {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName() + ": 执行任务4");
				Thread.sleep(1000);
				System.out.println(t.getName() + ": 444运行任务完毕");
			} catch (Exception e) {
				System.out.println("任务4线程被中断了!");
			}
		};
		Runnable task5 = () -> {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName() + ": 执行任务5");
				Thread.sleep(1000);
				System.out.println(t.getName() + ": 555运行任务完毕");
			} catch (Exception e) {
				System.out.println("任务5线程被中断了!");
			}
		};

		// 将5个任务添加到线程池
		threadPool.execute(task1);
		System.out.println("添加task1");
		threadPool.execute(task2);
		System.out.println("添加task2");
		threadPool.execute(task3);
		System.out.println("添加task3");
		threadPool.execute(task4);
		System.out.println("添加task4");
		threadPool.execute(task5);
		System.out.println("添加task5");

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
}








