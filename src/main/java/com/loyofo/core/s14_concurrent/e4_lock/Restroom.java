package com.loyofo.core.s14_concurrent.e4_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Restroom {

    private Lock doorLock = new ReentrantLock();

    public void bath(String name) throws InterruptedException {
        doorLock.lock();
        try {
            System.out.println(name + "开始洗澡...");
            Thread.sleep(2000);
            System.out.println(name + "洗完澡出来了.");
        } finally {
            doorLock.unlock();
        }
    }
    public void poo(String name) throws InterruptedException {
        doorLock.lock();
        try {
            System.out.println(name + "开始拉屎...");
            Thread.sleep(2000);
            System.out.println(name + "拉完屎出来了.");
        } finally {
            doorLock.unlock();
        }
    }
    public void bathAndPoo(String name) throws InterruptedException {
        doorLock.lock();
        try {
            bath(name);
            poo(name);
        } finally {
            doorLock.unlock();
        }
    }
    public void pooAndBath(String name) throws InterruptedException {
        doorLock.lock();
        try {
            poo(name);
            bath(name);
        } finally {
            doorLock.unlock();
        }
    }
}
