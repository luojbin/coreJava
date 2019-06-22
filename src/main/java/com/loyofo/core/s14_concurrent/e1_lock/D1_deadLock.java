package com.loyofo.core.s14_concurrent.e1_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

class Bank{
    private Lock lock = new ReentrantLock();
    private Condition enoughMoney = lock.newCondition();

    public void transfer(Person from, Person to) throws InterruptedException {
        lock.lock();
        try {
            while(from.getMoney() < 100){
                System.out.println(from.getName() + ": 我现在没钱, 晚点才能给" + to.getName());
                enoughMoney.await();
            }
            System.out.println(from.getName() + ": 有钱了, 给"+ to.getName() +"转账吧");
            from.setMoney(from.getMoney() - 100);
            to.setMoney(to.getMoney() + 100);
            enoughMoney.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
class Person{
    private String name;
    private int money;

    public Person(String name, int money){
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

