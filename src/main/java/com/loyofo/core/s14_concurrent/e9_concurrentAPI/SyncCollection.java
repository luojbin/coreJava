package com.loyofo.core.s14_concurrent.e9_concurrentAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 线程安全的集合与Map
 * 常用的集合都不是线程安全的, Collections 类可以很方便的创建指定集合的线程安全副本, 线程安全集合中的方法, 都被同步锁保护, 实现线程安全.
 * 同步集合副本, 其实是原集合的包装类, 所有的方法, 都是在同步块内调用原集合的方法.
 * 与原集合同步更新. 但如果调用原集合的修改方法, 也会修改同步集合副本而不受锁的保护
 */
public class SyncCollection {
    public static void main(String[] args) {
        /*
         * ArrayList与LinkedList都不是线程 安全的
         */
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list.getClass().getName() + list);
        //将给定的List集合转换为线程安全的
        List clist = Collections.synchronizedList(list);
        System.out.println(clist.getClass().getName() + clist);

        // 修改list
        list.add("测试");
        System.out.println("测试两集合同步更新");
        System.out.println(clist.getClass().getName() + clist);
        System.out.println(list.getClass().getName() + list);

        /*
         * HashSet不是线程安全的
         */
        Set<String> set = new HashSet<>(list);
        System.out.println(set.getClass().getName() + set);
        set = Collections.synchronizedSet(set);
        System.out.println(set.getClass().getName() + set);

        /*
         * HashMap不是线程安全的
         */
        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 99);
        map.put("数学", 98);
        map.put("英语", 97);
        System.out.println(map.getClass().getName() + map);
        //转换为线程安全的Map
        map = Collections.synchronizedMap(map);
        System.out.println(map.getClass().getName() + map);

        /*
         * 集合的元素操作方法不与迭代互斥。
         * 所以若多线程操作时，并发迭代与增删
         * 元素间不同步，这可能导致迭代出错。
         * 所以需要自行维护互斥关系。
         */
    }
}











