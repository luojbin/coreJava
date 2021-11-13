package com.loyofo.core.s14_concurrent.e14_sync;

import java.util.concurrent.CountDownLatch;

/**
 * 设置一个带计数器的门栓, 每次调用 countDown 后计数器减1, 当计数器归0, 打开门放行
 * 模拟: 4个人点了5个菜, 菜上起了才开始吃饭, 4个人吃完以后进来2个服务员收摊
 */
public class CountDownDemo {
    public static void main(String[] args) {
        // 倒计时门栓
        CountDownLatch cookingLatch = new CountDownLatch(5);
        CountDownLatch eatingLatch = new CountDownLatch(4);

        // 厨子做饭, 四菜一汤, 5个线程, 计数器为5
        Thread t1 = getCook(cookingLatch, "红烧肉", 3000);
        Thread t2 = getCook(cookingLatch, "鲮鱼油麦菜", 5000);
        Thread t3 = getCook(cookingLatch, "韭菜鸡蛋", 4000);
        Thread t4 = getCook(cookingLatch, "清蒸桂花鱼", 5000);
        Thread t5 = getCook(cookingLatch, "紫菜蛋花汤", 6000);

        // 食客吃饭, 4人聚餐, 计数器为4
        Thread t6 = getCustomer(cookingLatch, eatingLatch, "关羽", 4000);
        Thread t7 = getCustomer(cookingLatch, eatingLatch, "张飞", 5000);
        Thread t8 = getCustomer(cookingLatch, eatingLatch, "刘备", 6000);
        Thread t9 = getCustomer(cookingLatch, eatingLatch, "赵云", 5000);

        // 收摊的服务员
        Thread t10 = getWaiter(eatingLatch, "貂蝉");
        Thread t11 = getWaiter(eatingLatch, "西施");

        // 启动全部线程
        t11.start();
        t10.start();
        t9.start();
        t8.start();
        t7.start();
        t6.start();
        t5.start();
        t4.start();
        t3.start();
        t2.start();
        t1.start();
    }

    static Thread getCook(CountDownLatch cookindLatch, String name, int timeout) {
        Thread t = new Thread(() -> {
            String ct = Thread.currentThread().getName() + ": ";
            System.out.println(ct + "正在做菜...");
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ct + "菜做好了, 上菜");
            cookindLatch.countDown();
        });
        t.setName(name + "的厨子");
        return t;
    }

    static Thread getCustomer(CountDownLatch cookindLatch, CountDownLatch eatingLatch, String name, int timeout) {
        Thread t = new Thread(() -> {
            try {
                String ct = Thread.currentThread().getName() + ": ";
                System.out.println(ct + "我点几个菜...");
                System.out.println(ct + "菜还没上, 没得吃");
                cookindLatch.await();
                System.out.println(ct + "菜上齐了, 开吃");
                Thread.sleep(timeout);
                System.out.println(ct + "好了, 我吃饱了");
                eatingLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setName("顾客" + name);
        return t;
    }

    static Thread getWaiter(CountDownLatch eatingLatch, String name) {
        Thread t = new Thread(() -> {
            try {
                String ct = Thread.currentThread().getName() + ": ";
                System.out.println(ct + "顾客还没吃完, 先等等");
                eatingLatch.await();
                System.out.println(ct + "顾客吃完了, 收摊去");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setName("服务员" + name);
        return t;
    }


}
