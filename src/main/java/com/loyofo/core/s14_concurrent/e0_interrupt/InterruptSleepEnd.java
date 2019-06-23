package com.loyofo.core.s14_concurrent.e0_interrupt;

public class InterruptSleepEnd {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                int i = 0;
                while (true) {
                    System.out.println("第" + ++i + "次输出;");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("中断+sleep 产生了 InterruptedException, 打断了 while 循环, 往下执行直至线程结束");
        });

        t.start();

        Thread.sleep(5000);
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread + "请求将线程" + t.getName() + "中断");
        t.interrupt();
        System.out.println("中断请求已发出");
    }
}
