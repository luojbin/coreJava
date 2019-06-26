package com.loyofo.core.s14_concurrent.e11_controlAll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ControlALL2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(pool);

        Callable<Integer> c;
        // List<Callable<Integer>> tasks = new ArrayList<>();

        // 创建多个 callable, 提交到 service
        int count = 0;
        for (int i = 0; i < 10; i++) {
            c = ControlALL.createSumCallable(10 * i + 1, 10 * i + 10);
            service.submit(c);
            count++;
        }

        // // 将 list 交给 线程池
        // List<Future<Integer>> results = pool.invokeAll(tasks);



        // 合并结果
        int total = 0;
        int unitResult = 0;
        System.out.println("等待最终结果出炉...");
        for(int i = 0; i< count ; i++){
            unitResult = service.take().get();
            System.out.println(unitResult);
            total += unitResult;
        }
        System.out.println("最终结果为: " + total);
    }


}
