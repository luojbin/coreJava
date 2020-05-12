package com.loyofo.core.common;

import java.util.*;

/**
 * 测试数据的构造工具, 不用每个 demo 都重复构造测试用的数据
 *
 * @author luojbin
 * @version 1.0
 * @date 2020/5/12 17:16
 */
public class DemoUtil {

    //region string
    public static List<String> stringList() {
        List<String> list = new ArrayList<>();
        list.add("谢霆锋");
        list.add("郭富城");
        list.add("王宝强");
        list.add("古天乐");
        list.add("张家辉");
        list.add("郭采洁");
        list.add("范冰冰");
        list.add("关晓彤");
        list.add("刘诗诗");
        list.add("高圆圆");
        return list;
    }

    public static Set<String> stringSet() {
        return new HashSet<>(stringList());
    }

    public static String[] stringArray() {
        return stringList().toArray(new String[]{});
    }
    //endregion


    //region Integer
    public static List<Integer> intList() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        list.add(66);
        list.add(77);
        list.add(88);
        list.add(99);
        list.add(100);
        return list;
    }

    public static Set<Integer> intSet() {
        return new HashSet<>(intList());
    }

    public static Integer[] integerArray() {
        return intList().toArray(new Integer[]{});
    }

    public static int[] intArray() {
        return intList().stream().mapToInt(i -> i).toArray();
    }
    //endregion

    //region map
    public static Map<String, String> str2strMap() {
        Map<String, String> map = new HashMap<>();
        map.put("谢霆锋", "xtf");
        map.put("郭富城", "gfc");
        map.put("王宝强", "wbq");
        map.put("古天乐", "gtl");
        map.put("张家辉", "zjh");
        map.put("郭采洁", "gcj");
        map.put("范冰冰", "fbb");
        map.put("关晓彤", "gxt");
        map.put("刘诗诗", "lss");
        map.put("高圆圆", "gyy");
        return map;
    }

    public static Map<String, Integer> str2intMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("谢霆锋", 11);
        map.put("郭富城", 22);
        map.put("王宝强", 33);
        map.put("古天乐", 44);
        map.put("张家辉", 55);
        map.put("郭采洁", 66);
        map.put("范冰冰", 77);
        map.put("关晓彤", 88);
        map.put("刘诗诗", 99);
        map.put("高圆圆", 100);
        return map;
    }
    //endregion

}
