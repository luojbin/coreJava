package com.loyofo.core.s5_reflex.e2_Field;

import com.loyofo.core.s6_interface.e0_demo.Employee;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-29 16:00
 */
public class F1_GetValue {

    @Test
    public void testGetFieldValue() throws IllegalAccessException, NoSuchFieldException {
        Employee employee = new Employee("张三", 11, "男");
        Class cl = employee.getClass();
        // 获取 public 域
        Field f2 = cl.getDeclaredField("pbname");
        System.out.println(f2.get(employee));

        // 获取 private 域
        Field f1 = cl.getDeclaredField("name");
        f1.setAccessible(true);
        System.out.println(f1.get(employee));
    }
}
