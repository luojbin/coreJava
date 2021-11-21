package com.loyofo.core.s6_interface.e6_innerClass.f2_local;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-14 16:18
 */
public class LocalInner {
    String field = "LocalInner";

    public Consumer<String> getConsumer(){
        String methodName = "getConsumer()";
        class LocalConsumer implements Consumer<String> {
            @Override
            public void accept(String s) {
                System.out.println(s);
                // 局部内部类可以访问外围类对象的实例域
                System.out.println(field);
                // 局部内部类可以访问当前方法的局部变量, 但要求为事实 final
                System.out.println(methodName);
                // 局部内部类中的 this 指当前内部类对象, 不是外围类对象
                System.out.println(this);
            }
        }
        return new LocalConsumer();
    }

    @Test
    public void testLocalInner() {
        String methodName = "testLocalInner()";

        // 获取普通内部类
        Consumer<String> innerConsumer = new InnerConsumer();
        innerConsumer.accept("test InnerConsumer");

        // 获取局部内部类
        Consumer<String> localConsumer = getConsumer();
        localConsumer.accept("test localConsumer");

        // 获取静态内部类
        Consumer<String> anonyConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println(methodName);
                System.out.println(field);
                System.out.println(this);
            }
        };
        anonyConsumer.accept("test anonyConsumer");
    }

    class InnerConsumer implements Consumer<String>{
        @Override
        public void accept(String s) {
            System.out.println(s);
            // 因为不在方法中, 不存在局部变量, 所以不能访问
            // System.out.println(methodName);
            System.out.println(field);
            System.out.println(this);
        }
    }
}
