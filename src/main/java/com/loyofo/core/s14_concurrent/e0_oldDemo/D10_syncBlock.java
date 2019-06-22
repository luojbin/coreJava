package com.loyofo.core.s14_concurrent.e0_oldDemo;

/**
 * 同步块
 * 可以更精确的锁定需要同步执行的代码片段, 有效的缩小同步范围可以在保证并发安全的前提下提高并发效率
 * 但是需要注意的是多个线程之间若需要同步执行该段代码，看到的同步监视器对象必须是同一个!
 * 对于实例方法, 监视器对象为该实例本身, 即 synchronized(this)
 * 对于静态方法, 监视器对象为该类的 class 对象, 即 synchronized(xxx.class)
 * <p>
 * synchronized(同步监视器对象){
 *      需要同步的代码片段
 * }
 */
public class D10_syncBlock {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        Thread t1 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        t1.start();
        t2.start();

    }
}

class Shop {

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











