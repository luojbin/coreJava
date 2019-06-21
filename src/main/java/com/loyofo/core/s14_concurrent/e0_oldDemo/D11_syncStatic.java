package com.loyofo.core.s14_concurrent.e0_oldDemo;

/**
 * 静态方法使用synchronized修饰后，该方法一定具有同步效果
 * 模拟: 商场内有两家店, 店内都有试衣间, 但商场只有一个收银台, 需要排队结账
 */
public class D11_syncStatic {

    public static void main(String[] args) {
        SuperMall uniqlo = new SuperMall("uniqlo");
        SuperMall jackjones = new SuperMall("jackjones");
        Thread t1 = new Thread(() -> {
            uniqlo.buy();
            SuperMall.cashier();
        });

        Thread t2 = new Thread(() -> {
            jackjones.buy();
            SuperMall.cashier();
        });
        Thread t3 = new Thread(() -> {
            uniqlo.buy();
            SuperMall.cashier();
        });

        Thread t4 = new Thread(() -> {
            jackjones.buy();
            SuperMall.cashier();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

class SuperMall {
    private String name;

    SuperMall(String name) {
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