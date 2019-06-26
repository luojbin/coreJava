package com.loyofo.core.s14_concurrent.e11_controlAll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ControlALL {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Callable<Integer> c;
        List<Callable<Integer>> tasks = new ArrayList<>();

        // 创建多个 callable, 放入 tasks 中
        for (int i = 0; i < 10; i++) {
            c = createSumCallable(10 * i + 1, 10 * i + 10);
            tasks.add(c);
        }

        // 将 list 交给 线程池
        List<Future<Integer>> results = pool.invokeAll(tasks);

        // 合并结果
        int total = 0;
        System.out.println("等待最终结果出炉...");
        for (Future<Integer> result : results) {
            System.out.println(result.get());
            total+=result.get();
        }
        System.out.println("最终结果为: " + total);
    }

    static Callable<Integer> createSumCallable(int from, int to) {
        return () -> {
            int sum = 0;
            System.out.printf("%s 正在计算...\n", Thread.currentThread());
            for (int start = from; start <= to; start++) {
                sum += start;
            }
            Thread.sleep(1000);
            System.out.printf("%s 计算 %d 到 %d, 得出结果 %d \n", Thread.currentThread(), from, to, sum);
            return sum;
        };
    }
}
