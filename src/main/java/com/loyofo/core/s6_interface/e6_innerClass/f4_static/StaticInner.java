package com.loyofo.core.s6_interface.e6_innerClass.f4_static;

import org.junit.Test;

public class StaticInner {
    @Test
    public void testStatic() {
        System.out.println(StaticObj.name);
        StaticObj.name = "修改静态域";
        System.out.println(StaticObj.name);
        StaticObj.print();

        System.out.println(StaticInter.ClassInInterface.name);
        StaticInter.ClassInInterface.printInInterface();

    }

    static class StaticObj {
        public static String name = "这是静态域";

        public static void print(){
            System.out.println("这是静态内部类的静态方法");
        }
    }
}

interface StaticInter {
    class ClassInInterface{
        static String name = "接口中的内部类, 静态域";
        static void printInInterface() {
            System.out.println("接口中的内部类, 静态方法");
        }
    }
}

