package com.loyofo.core.s5_reflex.e1_Class;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-27 15:51
 */
public class F1_Class {
    @Test
    public void testGetClass() {
        String s = "hello reflex";
        // 获取一个 Class 类型的实例
        Class cl = s.getClass();
        // class java.lang.String
        System.out.println(cl);
    }

    @Test
    public void testForName() throws ClassNotFoundException {
        // 根据类名获取 Class 对象, 需要提供完整类名(含包名)
        String name = "com.loyofo.core.s6_interface.e0_demo.Manager";
        Class cl = Class.forName(name);
        // class com.loyofo.core.s6_interface.e0_demo.Manager
        System.out.println(cl);
    }

    @Test
    public void testTClass() {
        // 基本类型
        Class intCl = int.class;
        // int
        System.out.println(intCl);
        // 引用类型
        Class strCl = String.class;
        // class java.lang.String
        System.out.println(strCl);
        // void 关键字
        Class voidCl = void.class;
        // void
        System.out.println(voidCl);
    }

    @Test
    public void testArrayClass() {
        // class [B
        System.out.println(byte[].class);
        // class [Z
        System.out.println(boolean[].class);
        // class [I
        System.out.println(int[].class);
        // class [[I
        System.out.println(int[][].class);
        // class [Ljava.lang.Integer;
        System.out.println(Integer[].class);
        // class [[[Ljava.lang.Integer;
        System.out.println(Integer[][][].class);
    }

    @Test
    public void testEquals() throws Exception{
        // true
        System.out.println("str".getClass() == String.class);
        // true
        System.out.println(Class.forName("java.lang.String") == String.class);
        // true
        System.out.println(Class.forName("java.lang.String") == "str".getClass());
    }

    @Test
    public void testUnmodifyList() {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        List<Integer> unmodifyList = Collections.unmodifiableList(l);
        unmodifyList.add(4);

    }
}
