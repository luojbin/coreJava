package com.loyofo.core.s14_concurrent.e4_synchronized;

import com.loyofo.core.s14_concurrent.e4_synchronized.entity.SuperMall;

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

