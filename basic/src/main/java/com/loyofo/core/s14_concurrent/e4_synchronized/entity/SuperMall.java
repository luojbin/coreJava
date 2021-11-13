package com.loyofo.core.s14_concurrent.e4_synchronized.entity;

public class SuperMall {
    private String name;

    public SuperMall(String name) {
        this.name = name;
    }

    /**
     * 静态同步方法, 对所有线程同步
     * 模拟: 一个商场内只有一个收银台
     */
    public synchronized static void cashier() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "正在结账...");
            Thread.sleep(5000);
            System.out.println(t.getName() + "结完账, 离开商场\n");
        } catch (Exception e) {
        }

    }

    public void buy() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "进入店铺 " + name);
            System.out.println(t.getName() + "正在" + name + "内挑衣服...\n");
            Thread.sleep(5000);

            //同步块，只在试衣间排队
            synchronized (this) {
                System.out.println(t.getName() + "进入" + name + "的试衣间...");
                Thread.sleep(5000);
                System.out.println(t.getName() + "离开" + name + "的试衣间...\n");
            }

        } catch (Exception e) {

        }
    }
}
