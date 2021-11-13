package com.loyofo.core.s14_concurrent.e12_forkJoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoin {
    public static void main(String[] args) {
        long from = 1L;
        long end = 100000000000L;

        // 计算 1..1w 的和
        Counter c = new Counter(from, end, 1000);
        long t1 = System.nanoTime();
        System.out.println(c.compute());
        long t2 = System.nanoTime();


        long sss = 0;
        long t3 = System.nanoTime();
        for (long i = from; i<= end; i++){
            sss += i;
        }
        long t4 = System.nanoTime();
        System.out.println(sss);

        System.out.println("fork/join 运算: " + (t2 - t1));
        System.out.println("for   循环 运算: " + (t4 - t3));


    }
}

class Counter extends RecursiveTask<Long>{

    private long from;
    private long end ;
    private long threshold;

    Counter(long from, long end, long threshold){
        this.from = from;
        this.end = end;
        this.threshold = threshold;
    }
    @Override
    protected Long compute() {
        if (end - from < threshold) {
            // 如果不超过阈值, 直接计算
            long sum = 0L;
            for (long i = from ; i <= end; i++ ) {
                sum += i;
            }
            return sum;
        } else {
            // 如果超过阈值, 分两半计算
            long half = (from + end) /2 ;
            Counter t1 = new Counter(from, half, threshold);
            Counter t2 = new Counter(half+1, end, threshold);
            // 分别计算
            invokeAll(t1, t2);
            // 合并结果
            return t1.join() + t2.join();
        }
    }
}