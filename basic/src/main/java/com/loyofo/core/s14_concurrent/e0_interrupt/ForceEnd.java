package com.loyofo.core.s14_concurrent.e0_interrupt;

public class ForceEnd {
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
            System.out.println("线程自然结束.");
        });

        t.start();
        Thread.sleep(2000);

        // 强制结束
        t.stop();
        if (Thread.State.TERMINATED.equals(t.getState())) {
            System.out.println(t.getName() + "已被强制结束.");
        } else {
            System.out.println("还没结束? ");
        }

    }
}
