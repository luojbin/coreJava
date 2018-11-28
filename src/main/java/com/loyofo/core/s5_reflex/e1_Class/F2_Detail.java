package com.loyofo.core.s5_reflex.e1_Class;

import com.loyofo.core.s6_interface.e0_demo.Manager;

import org.junit.Test;

import java.lang.reflect.*;

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

    @Test
    public void testParseClass() throws Exception{
        String name = "com.loyofo.core.s6_interface.e0_demo.Employee";
        Class cl = Class.forName(name);
        Class superCl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());

        // 拼凑类的声明
        if (modifiers.length() > 0) System.out.print(modifiers + " ");
        System.out.print("class " + cl.getSimpleName());
        if (superCl != null && superCl != Object.class) System.out.println(" extends " + superCl.getSimpleName());
        System.out.println(" {");
        // 输出静态域
        prinFields(cl);
        System.out.println();
        // 输出实例域
        // 输出构造函数
        printConstruceors(cl);
        System.out.println();
        // 输出普通方法
        printMethods(cl);
        System.out.println("}");
    }

    public void printConstruceors(Class cl) {
        Constructor[] cs = cl.getDeclaredConstructors();
        for (Constructor c : cs) {
            String name = c.getName();
            System.out.print("\t");
            System.out.print(Modifier.toString(c.getModifiers()) + " ");
            System.out.print(name + "(");
            // 输出参数列表
            Parameter[] parameters = c.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                Parameter p = parameters[i];
                System.out.print(p.getType().getSimpleName() + " ");
                System.out.print(p.getName());
            }
            System.out.println(")");
        }
    }
    public void printMethods(Class cl) {
        Method[] ms = cl.getDeclaredMethods();
        for (Method m : ms) {
            String name = m.getName();
            System.out.print("\t");
            System.out.print(Modifier.toString(m.getModifiers()) + " ");
            System.out.print(name + "(");
            // 输出参数列表
            Parameter[] parameters = m.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                Parameter p = parameters[i];
                System.out.print(p.getType().getSimpleName() + " ");
                System.out.print(p.getName());
            }
            System.out.println(")");
        }
    }
    public void prinFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            System.out.print("\t");
            System.out.print(Modifier.toString(f.getModifiers()) + " ");
            System.out.print(f.getType().getSimpleName() + " ");
            System.out.println(name);
        }
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

