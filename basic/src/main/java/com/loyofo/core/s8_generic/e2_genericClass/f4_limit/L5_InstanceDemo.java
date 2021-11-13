package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.Test;

import java.util.function.Supplier;

public class L5_InstanceDemo {
    @Test
    public void test1() {
        Container<Content> c = Container.getInstance(Content::new);
        System.out.println(c.content);
    }

    @Test
    public void test2() {
        Container<Content> c = Container.reflexInstance(Content.class);
        System.out.println(c.content);
    }
}

class Container<T> {
    T content;

    public Container() {
        // 不允许直接创建类型参数的实例, 因为类型擦除后会是 new Object(), 显然不是想要的结果
        // content = new T();
    }

    public Container(T t) {
        // 不允许直接创建类型参数的实例, 因为类型擦除后会是 new Object(), 显然不是想要的结果
        // content = new T();
        this.content = t;
    }

    public static <T> Container<T> getInstance(Supplier<T> constructor) {
        return new Container<>(constructor.get());
    }

    public static <R> Container<R> reflexInstance(Class<R> cl) {
        try {
            return new Container<>(cl.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Content {
    private String name = "this is content";

    @Override
    public String toString() {
        return this.name;
    }
}
