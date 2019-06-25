package com.loyofo.core.s14_concurrent.e8_blockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueDemo {

    public static int count = 1;

    public static void main(String[] args) {

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        ThreadLocal<Integer> threadCode = ThreadLocal.withInitial(() -> count++);

        // 生产者线程, 20个生产者线程, 往容量为10的队列里加元素, 十个成功, 十个阻塞
        for (int i = 1; i <= 20; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    queue.put(Thread.currentThread().getName() + " 存入的 " + threadCode.get());
                    System.out.println("第" + threadCode.get() + "个生产者线程已成功加入任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
            System.out.println(">>>>>>>>>第" + i + "个线程已启动");
        }

        // 一个消费者线程, 逐渐消费阻塞队列中的内容
        Thread t2 = new Thread(() -> {
            try {
                while(true){
                    System.out.println("消费者已取出元素, " + queue.take());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
    }
}
