package com.loyofo.core.s14_concurrent.e9_concurrentAPI;

import java.util.concurrent.ConcurrentHashMap;

public class BatchOperate {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> conMap = new ConcurrentHashMap<>();

        // 往 map 填充数据
        ConcurrentCollectionDemo.fillMap(conMap);

        // 批操作
        // search, 找到一个返回非null 的就终止
        System.out.println(conMap.<Integer>search(1, (k, v) -> {
            System.out.println(Thread.currentThread() + " in searchKeys" + v);
            if (Integer.parseInt(k) >= 10) {
                return 100;
            } else {
                return null;
            }
        }));

        // forEach

        // reduce

    }
}
