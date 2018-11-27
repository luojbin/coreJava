package com.loyofo.core.s5_reflex.e1_Class;

import org.junit.Test;

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
        System.out.println(cl); // class java.lang.String
    }

    @Test
    public void testForName() throws ClassNotFoundException {
        // 根据类名获取 Class 对象, 需要提供完整类名(含包名)
        String name = "com.loyofo.core.s6_interface.e0_demo.Manager";
        Class cl = Class.forName(name);
        System.out.println(cl);// class com.loyofo.core.s6_interface.e0_demo.Manager
    }

    @Test
    public void testTClass() {
        // 基本类型
        Class intCl = int.class;
        System.out.println(intCl);// int
        // 引用类型
        Class strCl = String.class;
        System.out.println(strCl);// class java.lang.String
        // void 关键字
        Class voidCl = void.class;
        System.out.println(voidCl);// void
    }

    @Test
    public void testArrayClass() {
        System.out.println(byte[].class); // class [B
        System.out.println(boolean[].class); // class [Z
        System.out.println(int[].class); // class [I
        System.out.println(int[][].class); // class [[I
        System.out.println(Integer[].class);    // class [Ljava.lang.Integer;
        System.out.println(Integer[][][].class);  // class [[[Ljava.lang.Integer;
    }

    @Test
    public void testEquals() throws Exception{
        System.out.println("str".getClass() == String.class);  // true
        System.out.println(Class.forName("java.lang.String") == String.class);  // true
        System.out.println(Class.forName("java.lang.String") == "str".getClass());  // true
    }
}
