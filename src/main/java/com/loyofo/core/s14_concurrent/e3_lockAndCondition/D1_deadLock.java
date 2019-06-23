package com.loyofo.core.s14_concurrent.e3_lockAndCondition;

public class D1_deadLock {
    public static void main(String[] args) {
        // 创建3个人, 都没钱
        Person a = new Person("张三", 0);
        Person b = new Person("李四", 0);
        Person c = new Person("王五", 0);
        Person d = new Person("赵六", 100);

        // 银行, 实施转账操作
        Bank bank = new Bank();

        // 创建三个线程, 让给别人转账
        Thread t1 = getThread(bank, a, b);
        Thread t2 = getThread(bank, b, c);
        Thread t3 = getThread(bank, c, a);
        Thread key = getThread(bank, d, a);
        Thread t5 = getThread(bank, a, d);

        t1.start();
        t5.start();
        t2.start();
        t3.start();

        // 若没有第四个人出现, 前面的三个人都没有钱, 无法执行转账, 程序陷入死锁

        // 三天后, 来了一个赵六, 手里有钱, 借给了张三100块
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n=====三天后====\n");
        key.start();

    }

    private static Thread getThread(Bank bank, Person from, Person to) {
        Thread t = new Thread(() -> {
            try {
                bank.transfer(from, to);
            } catch (InterruptedException e) {
            }
        });
        return t;
    }
}

