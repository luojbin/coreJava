package com.loyofo.core.s14_concurrent.e4_synchronized.entity;

public class Shop {

    /**
     * 未加锁方法, 两个线程可同时进入方法内, 并可能在任意位置切换线程, 导致冲突
     * 模拟: 两个人同时进入店内, 并进入了同一个试衣间
     */
    // public void buy(){
    /**
     * 同步方法, 避免两个线程同时进入方法内, 后来的线程需要等待前一个线程执行完整个方法, 才能进入
     * 模拟: 店里一次只能接待一个客人, 前一个客人离店后, 后来的客人才能进入店内
     */
    // public synchronized void buy() {
    // 	try {
    // 		Thread t = Thread.currentThread();
    // 		System.out.println(t.getName() + "进入店内...");
    // 		System.out.println(t.getName() + "正在挑衣服...");
    // 		Thread.sleep(5000);
    //
    // 		{
    // 			System.out.println(t.getName() + "进入1号试衣间...");
    // 			Thread.sleep(5000);
    // 			System.out.println(t.getName() + "离开1号试衣间...");
    // 		}
    //
    // 		System.out.println(t.getName() + "结账离开...");
    // 		Thread.sleep(2000);
    //
    // 		System.out.println(t.getName() + "交易完成...");
    //
    // 	} catch (Exception e) {
    //
    // 	}
    // }


    /**
     * 同步块
     * 模拟: 两个客人可以同时进入店内挑衣服, 但试衣间一次只能进一个人, 后来者需要排队等候
     */
    public void buy() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "进入店内...");
            System.out.println(t.getName() + "正在挑衣服...");
            Thread.sleep(5000);

            //同步块，只在试衣间排队
            synchronized (this) {
                System.out.println(t.getName() + "进入1号试衣间...");
                Thread.sleep(5000);
                System.out.println(t.getName() + "离开1号试衣间...");
            }

            System.out.println(t.getName() + "结账离开...");
            Thread.sleep(2000);

            System.out.println(t.getName() + "交易完成...");

        } catch (Exception e) {

        }
    }
}
