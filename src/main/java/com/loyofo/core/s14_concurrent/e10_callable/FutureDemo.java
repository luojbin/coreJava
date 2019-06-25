package com.loyofo.core.s14_concurrent.e10_callable;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) {
        // 构造一个 callable
        Callable<String> getMsg = () -> {
            System.out.println("让我想想我要说什么");
            Thread.sleep(5000);
            System.out.println("想好了, 可以来取结果了.\n");
            return "今天天气很晴朗, 处处好风光";
        };

        // 构造一个 Task
        FutureTask<String> task = new FutureTask<>(getMsg);

        // 构造一个线程, 执行计算任务
        Thread t1 = new Thread(task);
        t1.start();

        // 构造另一个线程, 检查计算进度
        Thread t2 = new Thread(() -> {
            try {
                int i = 1;
                while (!task.isDone()) {
                    System.out.println("等一下看会不会好吧...");
                    try {
                        task.get(100, TimeUnit.MILLISECONDS);
                    } catch (TimeoutException e) {
                        System.out.println("果然没这么快...");
                    }
                    System.out.println("第 " + i++ + "次查询, 尚未完成\n");
                    Thread.sleep(500);
                }
                System.out.println("第 " + i + "次查询, 已经完成了");
                for (int j = 1; j <= 3; j++) {
                    System.out.println("第 " + j + "次重复获取, 不会阻塞");
                    System.out.println(task.get());
                }
            } catch( ExecutionException | InterruptedException e){
                    e.printStackTrace();
            }
        });
        t2.start();

    }
}
