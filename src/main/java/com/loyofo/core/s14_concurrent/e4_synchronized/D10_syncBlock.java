package com.loyofo.core.s14_concurrent.e4_synchronized;

import com.loyofo.core.s14_concurrent.e4_synchronized.entity.Shop;

/**
 * 同步块
 * 可以更精确的锁定需要同步执行的代码片段, 有效的缩小同步范围可以在保证并发安全的前提下提高并发效率
 * 但是需要注意的是多个线程之间若需要同步执行该段代码，看到的同步监视器对象必须是同一个!
 * 对于实例方法, 监视器对象为该实例本身, 即 synchronized(this)
 * 对于静态方法, 监视器对象为该类的 class 对象, 即 synchronized(xxx.class)
 * <p>
 * synchronized(同步监视器对象){
 * 需要同步的代码片段
 * }
 */
public class D10_syncBlock {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        Thread t1 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        t1.start();
        t2.start();

    }
}











