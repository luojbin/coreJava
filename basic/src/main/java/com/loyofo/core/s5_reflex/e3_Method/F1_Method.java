package com.loyofo.core.s5_reflex.e3_Method;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-29 17:32
 */
public class F1_Method {

    @Test
    public void testGetMethods() throws NoSuchMethodException {
        Method1 m1 = new Method1();
        Class m1c = m1.getClass();
        // 获取类中声明的方法
        System.out.println(">>>>>>>>> Method1 中声明的方法");
        Method[] m1Methods = m1c.getDeclaredMethods();
        for (Method m : m1Methods) {
            System.out.println(m.getName());
        }
        // 获取所有公用方法(含超类方法)
        System.out.println();
        System.out.println(">>>>>>>>> Method1 的所有公有方法");
        m1Methods = m1c.getMethods();
        for (Method m :m1Methods ) {
            System.out.println(m.getName());
        }
        // 根据名字获取方法
        System.out.println(">>>>>>>>> 根据名字获取方法");
        Method pbNoArgs = m1c.getMethod("pbNoArgs");
        System.out.println(Modifier.toString(pbNoArgs.getModifiers()) + " " + pbNoArgs.getName());

        // 根据名字和类型获取方法
        System.out.println(">>>>>>>>> 根据名字和参数获取方法");
        Method pbConsumer = m1c.getMethod("pbConsumer", Object.class);
        System.out.println(Modifier.toString(pbConsumer.getModifiers()) + " " + pbConsumer.getName());
    }
}

class Method1{
    public void pbNoArgs() {
        System.out.println("爷爷的公有方法: ");
    }
    public void pbConsumer(Object obj) {
        System.out.println("爷爷的公有方法: " + obj);
    }
    void pkgConsumer(Object obj) {
        System.out.println("爷爷的包方法: " + obj);
    }
    protected void ptcConsumer(Object obj) {
        System.out.println("爷爷的保护方法: " + obj);
    }
    private void pvConsumer(Object obj) {
        System.out.println("爷爷的私有方法: " + obj);
    }

    public static void staticPbConsumer(Object obj) {
        System.out.println("爷爷的静态公有方法: " + obj);
    }
    static void staticPkgConsumer(Object obj) {
        System.out.println("爷爷的静态包方法: " + obj);
    }
    protected static void staticPtcConsumer(Object obj) {
        System.out.println("爷爷的静态保护方法: " + obj);
    }

    private static void staticPvConsumer(Object obj) {
        System.out.println("爷爷的静态私有方法: " + obj);
    }
}

class Method2 extends Method1{


}


class Method3 extends Method2{}