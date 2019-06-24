package com.loyofo.core.s14_concurrent.e5_threadLocal;

import com.loyofo.core.s6_interface.e5_methodRef.Person;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        String hello = "hello";
        String world = "world";
        Person a = new Person("张三");
        Person b = new Person("李四");

        // 线程1
        createNewThread(hello, a);
        // 线程2
        createNewThread(world, b);

        // 主线程可以修改a, 会影响线程1中的线程局部变量, 由此可见用set方法为线程局部变量赋值会有风险.
        Thread.sleep(500);
        a.setName("道明寺");
    }

    public static Thread createNewThread(String name, Person person) {
        Thread t = new Thread(() -> {
            // 尽量不要用 set 方法为线程局部变量赋值, 会破坏封装性, 容易被别的线程修改
            MyThreadLocals.THREAD_STR.set(name);
            MyThreadLocals.THREAD_PERSON.set(person);
            pringThreadLocal();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pringThreadLocal();
        });
        t.start();
        return t;
    }

    public static void pringThreadLocal() {
        Thread c = Thread.currentThread();
        System.out.println(c + "的 THREAD_STR : " + MyThreadLocals.THREAD_STR.get());
        System.out.println(c + "的 THREAD_PERSON : " + MyThreadLocals.THREAD_PERSON.get());
    }
}

class MyThreadLocals {
    // ThreadLocal 实例作为 key 去线程实例域 threadLocals 中查找 value, 为此应保存好这个 key, 实践中常用静态域来保存.
    // 应该尽量为线程局部变量指定初始化方法
    public static final ThreadLocal<String> THREAD_STR = new ThreadLocal<>();
    public static final ThreadLocal<Person> THREAD_PERSON = new ThreadLocal<>();
}