package com.loyofo.core.s14_concurrent.e4_synchronized.entity;

public class Table {
    //桌子上有20个豆子
    private int beans = 20;

    // 添加 synchronized 以避免线程安全问题
    public synchronized int getBean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了!");
        }
        // 请求线程切换
        Thread.yield();
        return beans--;
    }
}
