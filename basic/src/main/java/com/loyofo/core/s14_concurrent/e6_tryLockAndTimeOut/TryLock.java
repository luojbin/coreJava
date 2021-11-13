package com.loyofo.core.s14_concurrent.e6_tryLockAndTimeOut;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    public static void main(String[] args) throws InterruptedException {
        Kfc kfc = new Kfc();

        Thread t1 = new Thread(() -> kfc.buy());
        Thread t2 = new Thread(() -> kfc.buy());
        Thread t3 = new Thread(() -> kfc.buy());
        Thread t4 = new Thread(() -> kfc.buy());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(2000);
        // 2000, t2 应该还在阻塞中, 尝试打断
        t2.interrupt();
    }

}

class Kfc{

    Lock cookingLock = new ReentrantLock();

    public void buy(){
        Thread t = Thread.currentThread();
        try {
            if(cookingLock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(t.getName() + " 正在下单...");
                    Thread.sleep(2000);
                    System.out.println(t.getName() + " 正在准备...");
                    Thread.sleep(2000);
                    System.out.println(t.getName() + " 做好了, 拿走吃饭啦.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cookingLock.unlock();
                }
            } else {
                System.out.println(t.getName()  + " 哎呀, 太慢了, 不等了");
            }
        } catch (InterruptedException e) {
            //  tryLock 允许被中断
            System.out.println(Thread.currentThread() + ": 等待锁的期间, 被中断");
            e.printStackTrace();
        }
    }
    public void unInterruiptBuy(){
        try {
            cookingLock.lock();
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + " 正在下单...");
            Thread.sleep(2000);
            System.out.println(t.getName() + " 正在准备...");
            Thread.sleep(2000);
            System.out.println(t.getName() + " 做好了, 拿走吃饭啦.");
        } catch (InterruptedException e) {
            //  tryLock 允许被中断
            System.out.println(Thread.currentThread() + ": 等待锁的期间, 被中断");
            e.printStackTrace();
        } finally {
            cookingLock.unlock();
        }
    }
}