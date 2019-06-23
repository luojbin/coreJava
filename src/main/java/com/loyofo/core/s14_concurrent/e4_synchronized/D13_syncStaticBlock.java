package com.loyofo.core.s14_concurrent.e4_synchronized;

public class D13_syncStaticBlock {

    public static void main(String[] args) {
        Thread t1 = new Thread(D13_syncStaticBlock::syncWithClass);
        Thread t2 = new Thread(D13_syncStaticBlock::syncWithClass);
        Thread t3 = new Thread(D13_syncStaticBlock::syncWithObject);
        Thread t4 = new Thread(D13_syncStaticBlock::syncWithObject);

        // t1.start();
        // t2.start();
        t3.start();
        t4.start();
    }

    public static void syncWithClass() {
        // 对于静态方法, 应该锁其该类的 class 对象
        synchronized (D13_syncStaticBlock.class) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "进入静态方法");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + "离开静态方法");
        }
    }

    public static void syncWithObject() {
        // 如果锁不同对象, 则没有意义
        synchronized (new Object()) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "进入静态方法");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + "离开静态方法");
        }
    }
}
