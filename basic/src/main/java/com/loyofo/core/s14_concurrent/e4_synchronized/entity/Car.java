package com.loyofo.core.s14_concurrent.e4_synchronized.entity;

public class Car {
    public void driveToSZ() {
        synchronized (this) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ": 把车子开去深圳了...");
                Thread.sleep(5000);
                System.out.println(t.getName() + ": 从深圳回来了.");
            } catch (Exception e) {
            }
        }
    }

    public void driveToBJ() {
        synchronized (this) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ": 把车子开去北京了...");
                Thread.sleep(5000);
                System.out.println(t.getName() + ": 从北京回来了.");
            } catch (Exception e) {
            }
        }
    }
}
