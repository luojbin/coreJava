package com.loyofo.core.s14_concurrent.e0_interrupt;

public class ExceptionEnd {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println("第" + ++i + "次输出;");
                if (i == 3) {
                    System.out.println("线程内抛出异常");
                    throw new RuntimeException();
                }
            }
        });

        // 安装默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler((thread, e) -> {
            System.out.println("线程:" + thread + "异常结束, 异常: " + e);
        });
        t.start();
    }
}