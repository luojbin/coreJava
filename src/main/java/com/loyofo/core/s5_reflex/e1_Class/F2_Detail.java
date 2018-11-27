package com.loyofo.core.s5_reflex.e1_Class;

import com.loyofo.core.s6_interface.e0_demo.Manager;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class F2_Detail {

    @Test
    public void getClassName() {
        Manager manager = new Manager();
        // 获取一个 Class 类型的实例
        Class cl = manager.getClass();
        // 获取完整类名(含包名)
        System.out.println(cl.getName()); // com.loyofo.core.s6_interface.e0_demo.Manager
        // 获取简单类名(不含包名)
        System.out.println(cl.getSimpleName()); // Manager
    }

    @Test
    public void testGetField() {
        System.out.println("Aoo Fields:");
        Class aooCL = Aoo.class;
        Field[] aooFields = aooCL.getFields();
        printArray(aooFields);

        System.out.println("Boo Fields:");
        Class booCl = Boo.class;
        Field[] booFields = booCl.getFields();
        printArray(booFields);
    }
    @Test
    public void testGetDeclaredField() {
        System.out.println("Aoo Fields:");
        Class aooCL = Aoo.class;
        Field[] aooFields = aooCL.getDeclaredFields();
        printArray(aooFields);

        System.out.println("Boo Fields:");
        Class booCl = Boo.class;
        Field[] booFields = booCl.getDeclaredFields();
        printArray(booFields);
    }

    public void printArray(Object[] array) {
        for (Object obj : array) {
            System.out.println(obj);
        }
        System.out.println();
    }
}

class Aoo {
    public int publicAtAoo;
    protected int protectedAtAoo;
    int packageAtAoo;
    private int privateAtAoo;

    public static int publicStaticAtAoo;
}
class Boo extends Aoo {
    public int publicAtBoo;
    protected int protectedAtBoo;
    int packageAtBoo;
    private int privateAtBoo;

    public static int publicStaticAtBoo;
}

