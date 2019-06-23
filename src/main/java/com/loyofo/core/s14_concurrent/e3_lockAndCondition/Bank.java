package com.loyofo.core.s14_concurrent.e3_lockAndCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank {
    private Lock lock = new ReentrantLock();
    private Condition enoughMoney = lock.newCondition();

    public void transfer(Person from, Person to) throws InterruptedException {
        lock.lock();
        try {
            while (from.getMoney() < 100) {
                System.out.println(from.getName() + ": 我现在没钱, 晚点才能给" + to.getName());
                enoughMoney.await();
            }
            System.out.println(from.getName() + ": 有钱了, 给" + to.getName() + "转账吧");
            from.setMoney(from.getMoney() - 100);
            to.setMoney(to.getMoney() + 100);
            enoughMoney.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
