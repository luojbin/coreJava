package com.loyofo.core.s14_concurrent.e4_lock;

public class ReentrantLockDemo {

    public static void main(String[] args) {
        String a = "张三";
        String b = "李四";
        String c = "王五";
        String d = "赵六";

        Restroom restroom = new Restroom();

        Thread aToBath = new Thread(() -> {
            try {
                restroom.bath(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread bToPoo = new Thread(() -> {
            try {
                restroom.poo(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread cToBathAndPoo = new Thread(() -> {
            try {
                restroom.bathAndPoo(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread dToPooAndBath = new Thread(() -> {
            try {
                restroom.pooAndBath(d);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        aToBath.start();
        bToPoo.start();
        cToBathAndPoo.start();
        dToPooAndBath.start();

    }
}

