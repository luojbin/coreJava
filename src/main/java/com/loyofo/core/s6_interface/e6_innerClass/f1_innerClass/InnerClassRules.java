package com.loyofo.core.s6_interface.e6_innerClass.f1_innerClass;

import org.junit.Test;

public class InnerClassRules {
    @Test
    public void testGetInner() {
        // 获取当前类的内部类
        Inner inner = new Inner();
        System.out.println(inner);

        // 获取其他类的内部类
        Outer outer = new Outer();
        Outer.OuterInner outerInner = outer.new OuterInner();
        System.out.println(outerInner);

        Outer.OuterStatic.printS();
    }

    @Test
    public void testGetOuter() {
        Inner rules = new Inner();
        InnerClassRules outer = rules.getOuter();
        System.out.println(outer);
        System.out.println(this);
    }

    class Inner{
        public InnerClassRules getOuter(){
            return InnerClassRules.this;
        }
    }
}

class Outer{
    class OuterInner{

    }
    static class OuterStatic{
        public static void printS(){
            System.out.println("外部的静态内部类");
        }
    }
}