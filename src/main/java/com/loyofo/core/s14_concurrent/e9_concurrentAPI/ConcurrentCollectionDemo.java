package com.loyofo.core.s14_concurrent.e9_concurrentAPI;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        // 普通hashMap, 在迭代时被修改会抛异常
        Map<String, String> hashMap = new HashMap<>();

        // 并发hashMap, 在迭代时被修改没毛病
        ConcurrentHashMap<String, String> conMap = new ConcurrentHashMap<>();

        // 往两个 map 填充数据
        fillMap(hashMap);
        fillMap(conMap);

        // 遍历 hashMap
        Thread t = new Thread(() -> {
            for (Map.Entry<String, String> e : hashMap.entrySet()) {
                System.out.println("hashMap:" + e.getKey() + " : " + e.getValue());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("HashMap 遍历结束");
        });

        // 遍历 hashMap
        Thread t2 = new Thread(() -> {
            for (Map.Entry<String, String> e : conMap.entrySet()) {
                System.out.println("              conMap: " + e.getKey() + " : " + e.getValue());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("conMap 遍历结束");
        });

        t.start();
        t2.start();

        // 修改线程, 尝试往两个map里添加元素, 普通 hashMap 抛出异常, 并发 conMap 可以完成遍历, 但缺少最新的修改
        Thread t3 = new Thread(() -> {
            try {
                System.out.println("修改线程已启动");
                Thread.sleep(1500);
                // hashMap.put("error", "error");
                conMap.put("error", "error");
                System.out.println("已用其他线程修改集合");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();


    }

    static void fillMap(Map<String, String> map) {
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        map.put("6", "F");
        map.put("7", "G");
        map.put("8", "H");
        map.put("9", "I");
        map.put("10", "J");
        map.put("11", "K");
        map.put("12", "L");
    }
}
