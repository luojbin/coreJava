package com.loyofo.core.s14_concurrent.e2_infoAndProperty;

/**
 * <b>static Thread currendThread()</b><br />
 * 该方法可以获取运行这个方法的线程对象, 可以通过线程对象获取线程相关信息
 */
public class D2_threadInfo {
    public static void main(String[] args) {
        // 获取主线程的信息
        getThreadInfo();

        // 获取新建线程的信息
        Thread my = new Thread(D2_threadInfo::getThreadInfo);
        my.start();
    }

    public static void getThreadInfo() {
        //获取当前线程对象
        Thread currentThread = Thread.currentThread();
        System.out.println("当前线程是:" + currentThread);

        //获取id
        long id = currentThread.getId();
        System.out.println("id:" + id);

        //获取名字
        String name = currentThread.getName();
        System.out.println("name:" + name);

        //获取线程优先级
        int priority = currentThread.getPriority();
        System.out.println("线程优先级 priority:" + priority);

        // 线程是否存活
        boolean isAlive = currentThread.isAlive();
        System.out.println("线程是否存活 isAlive:" + isAlive);

        // 是否守护线程
        boolean isDaemon = currentThread.isDaemon();
        System.out.println("是否守护线程 isDaemon:" + isDaemon);

        // 是否已被中断
        boolean isInterrupted = currentThread.isInterrupted();
        System.out.println("是否已被中断 isInterrupted:" + isInterrupted);

        System.out.println();
    }
}







