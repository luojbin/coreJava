package com.loyofo.core.s14_concurrent.e14_sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 障栅演示
 * 多个线程, 完成各自任务后都运行到栅栏处, 等所有线程都到了栅栏处, 就释放栅栏, 所有线程可以继续往下走
 * <p>
 * 模拟, 考场上多个学生不同时间交卷, 全部交卷后考试结束, 大家放学回家
 */
public class BarrierDemo {

    public static void main(String[] args) {
        // 需要指定栅栏等待几个线程
        CyclicBarrier barrier = new CyclicBarrier(3);

        // 三个人参加考试
        Thread t1 = getStudent(barrier, 4000, "张三");
        Thread t2 = getStudent(barrier, 5000, "李四");
        Thread t3 = getStudent(barrier, 13000, "王五");

        System.out.println("考试开始");
        t1.start();
        t2.start();
        t3.start();
    }

    static Thread getStudent(CyclicBarrier barrier, int timeout, String name) {
        Thread t = new Thread(() -> {
            String ct = Thread.currentThread().getName();
            System.out.println(ct + " 正在认真做题...");
            try {
                Thread.sleep(timeout);
                System.out.println(ct + "做完了交卷吧, 但是还不能回家");
                barrier.await();
                System.out.println(ct + " 考试终于结束了, 放学啦");
                Thread.sleep(timeout);
                System.out.println(ct + "卧槽, 有个红绿灯");
                // 全部线程释放后, 可以再次使用
                barrier.await();
                System.out.println(ct + "到家了");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t.setName(name);
        return t;
    }
}
