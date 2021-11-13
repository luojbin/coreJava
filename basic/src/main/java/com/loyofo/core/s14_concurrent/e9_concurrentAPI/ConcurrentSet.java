package com.loyofo.core.s14_concurrent.e9_concurrentAPI;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentSet {
    public static void main(String[] args) {
        // 并发包没有提供 ConcurrentSet, 可以通过 ConcurrentHashMap的 keySet 来实现
        Set<Integer> conSet = ConcurrentHashMap.newKeySet();
        conSet.add(1);
        conSet.add(2);
        conSet.add(3);
        conSet.add(4);
        conSet.add(5);
        conSet.add(7);
        conSet.add(8);
        conSet.add(9);
        System.out.println(conSet.getClass());

        // keySet 只是视图, 对 keySet 修改会影响 map
        ConcurrentHashMap<String, Integer> conMap = new ConcurrentHashMap<>();
        conMap.put("java", 100);
        conMap.put("python", 70);
        conMap.put("c#", 90);
        conMap.put("c++", 40);

        // 有提供默认值的 keySet, 允许添加key元素, 对应的 value 为默认值
        Set<String> mapSet = conMap.keySet(99);
        mapSet.add("ruby");
        System.out.println(mapSet);
        System.out.println(conMap);

        // 不提供默认值的 keySet, 不允许添加元素, 抛出 UnsupportedOperationException
        Set<String> mapSet2 = conMap.keySet();
        // mapSet2.add("perl");
    }
}
