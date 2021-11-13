package com.loyofo.core.s14_concurrent.e7_readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Notebook book = new Notebook();

        Thread t1 = new Thread(() -> {
            book.read("文章..1");
        });
        Thread t2 = new Thread(() -> {
            book.read("文章..2");
        });
        Thread t3 = new Thread(() -> {
            book.read("文章..3");
        });

        t1.start();
        t2.start();
        t3.start();


        System.out.println("\n准备写入文章");
        Thread t4 = new Thread(() -> {
            book.write("文章..4", "世上只有妈妈好");
        });
        Thread t5 = new Thread(() -> {
            book.write("文章..5", "我在马路边, 捡到一分钱");
        });
        Thread t6 = new Thread(() -> {
            book.read("文章..5");
        });

        t4.start();
        t5.start();
        t6.start();
    }
}

class Notebook {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    private Map<String, String> content = new HashMap<>();

    {
        content.put("文章..1", "hello world");
        content.put("文章..2", "早上好");
        content.put("文章..3", "今天天气好晴朗");
    }

    public void read(String title) {
        readLock.lock();
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ": 让我找找文章在哪里..." + title);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName() + ": 找到了 【" + title + "】内容是:" + content.get(title));
        readLock.unlock();
    }

    public void write(String title, String detail) {
        writeLock.lock();
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ": 正在写入" + title + "...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        content.put(title, detail);
        System.out.println(t.getName() + ": 终于写完了 【" + title + "】");
        writeLock.unlock();
    }


}