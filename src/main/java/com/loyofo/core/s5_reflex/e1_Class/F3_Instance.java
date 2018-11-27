package com.loyofo.core.s5_reflex.e1_Class;

import com.loyofo.core.s6_interface.e0_demo.Employee;
import com.loyofo.core.s6_interface.e0_demo.Manager;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class F3_Instance {
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
