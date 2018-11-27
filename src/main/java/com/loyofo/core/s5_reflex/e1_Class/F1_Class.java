package com.loyofo.core.s5_reflex.e1_Class;

import com.loyofo.core.s6_interface.e0_demo.Employee;
import com.loyofo.core.s6_interface.e0_demo.Manager;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-27 15:51
 */
public class F1_Class {
    @Test
    public void test1() {
        String s = "hello reflex";
        // 获取一个 Class 类型的实例
        Class cl = s.getClass();
        System.out.println(cl); // class java.lang.String

        // 通过类本身来获取 Class 对象
        Class cl2 = String.class;
        System.out.println(cl2); // class java.lang.String
    }
    @Test
    public void test2() {
        Manager manager = new Manager();
        // 获取一个 Class 类型的实例
        Class cl = manager.getClass();
        // 获取完整类名(含包名)
        System.out.println(cl.getName());           // com.loyofo.core.s6_interface.e0_demo.Manager
        // 获取简单类名(不含包名)
        System.out.println(cl.getSimpleName());     // Manager
        // 获取方法列表
        Method[] methods = cl.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }

    @Test
    public void test3() throws ClassNotFoundException {
        // 根据类名获取 Class 对象, 需要提供完整类名(含包名)
        String name = "com.loyofo.core.s6_interface.e0_demo.Manager";
        Class cl = Class.forName(name);
    }

    @Test
    public void test4() {
        Class intCl = int.class;
        System.out.println(intCl);  // int

        Class doubleCl = double.class;
        System.out.println(doubleCl);   // double
    }

    @Test
    public void test5() {
        int[] ints = new int[]{};
        System.out.println(ints.getClass());    // class [I

        byte[] bys = new byte[]{};
        System.out.println(bys.getClass());     // class [B

        boolean[] bls = new boolean[]{};
        System.out.println(bls.getClass());     // class [Z

        Integer[] integers = new Integer[]{};
        System.out.println(integers.getClass());    // class [Ljava.lang.Integer;

        int[][] ij = new int[][]{ {}, {}, {} };
        System.out.println(ij.getClass());  // class [[I

        int[][][] ijk = new int[][][]{ {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}} };
        System.out.println(ijk.getClass());  // class [[I
    }

    @Test
    public void test6() {
        System.out.println("str".getClass() == String.class);  // true
    }

    @Test
    public void test7() {
        try {
            Manager manager1 = new Manager("张三", 20, "男");
            Manager manager2 = manager1.getClass().newInstance();
            System.out.println("创建 Manager ok");

            String empName = "com.loyofo.core.s6_interface.e0_demo.Employee";
            Employee employee = (Employee) Class.forName(empName).newInstance();
            System.out.println("创建 Employee ok");
        } catch (Exception e) {
            System.out.println("newInstance 异常:" + e.getCause());
        }
    }
    @Test
    public void test8() {
        try {
            String empName = "com.loyofo.core.s6_interface.e0_demo.Employee";
            Constructor[] cs = Class.forName(empName).getConstructors();
            Constructor c = cs[0];
            Object obj = c.newInstance("反射创建员工", 22, "男");
            System.out.println(obj);    // Employee{name='反射创建员工', age=22, sex='男'}
        } catch (Exception e) {
            System.out.println("newInstance 异常:" + e.getCause());
        }
    }
}
