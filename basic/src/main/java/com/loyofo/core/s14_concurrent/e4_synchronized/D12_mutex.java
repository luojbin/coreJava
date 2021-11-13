package com.loyofo.core.s14_concurrent.e4_synchronized;

import com.loyofo.core.s14_concurrent.e4_synchronized.entity.Car;

/**
 * 互斥锁
 * 当 synchronized 修饰的是两段不同的代码
 * 但是锁对象相同时，那么这两段代码就是互斥的, 不能同时执行。
 * 场景: 一辆车, 同一时间不能又去北京又去深圳, 必须从一个地方回来后才可以去另一个地方
 */
public class D12_mutex {
    public static void main(String[] args) {
        final Car car = new Car();
        Thread t1 = new Thread() {
            public void run() {
                car.driveToSZ();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                car.driveToBJ();
            }
        };
        t1.start();
        t2.start();
    }
}







