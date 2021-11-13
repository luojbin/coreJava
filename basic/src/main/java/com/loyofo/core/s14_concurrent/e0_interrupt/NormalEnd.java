package com.loyofo.core.s14_concurrent.e0_interrupt;

public class NormalEnd {
    public static void main(String[] args){
        Thread t = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("第" + i + "次输出;");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程自然结束.");
        });

        t.start();
    }
}
