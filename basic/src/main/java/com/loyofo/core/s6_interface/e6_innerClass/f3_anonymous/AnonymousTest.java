package com.loyofo.core.s6_interface.e6_innerClass.f3_anonymous;

public class AnonymousTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.getClass());
        outer.printMe();

        // 创建一个匿名内部类对象, 没有构造参数
        Outer anonymous = new Outer() {
            @Override
            public void printMe() {
                System.out.println("这里是无参匿名内部类");
            }
        };
        System.out.println(anonymous.getClass());
        anonymous.printMe();

        // 创建一个匿名内部类对象, 传入参数
        Outer anonymousWithArgs = new Outer("有参匿名类", 99) {
            @Override
            public void printMe() {
                System.out.println("这里是有参匿名内部类, name=" + name + ", age=" + age);
            }

            public void printMe2() {
                System.out.println("匿名内部类新增方法");
            }
        };
        System.out.println(anonymousWithArgs.getClass());
        anonymousWithArgs.printMe();
        // 无法访问匿名类中新增的方法
        // anonymousWithArgs.printMe2();
    }
}

class Outer {
    String name;
    int age;

    public Outer() {
        System.out.println("\n-->> 这是 Outer 类的无参构造");
        this.name = "普通类";
        this.age = 22;
    }

    public Outer(String name, int age) {
        System.out.println("\n-->> 这是 Outer 类的有参构造");
        this.name = name;
        this.age = age;
    }

    public void printMe() {
        System.out.println("这里是普通类, name=" + name + ", age=" + age);
    }
}