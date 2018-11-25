package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.Test;

import java.util.function.Supplier;

public class L7_noStatic<T> {
    // 泛型类中的静态域不能使用参数类型
    // private static T name;

    // 泛型类中的静态方法中, 不允许使用泛型类定义的参数类型
    // public static T getT(Supplier<T> constructor) {
    //     return constructor.get();
    // }

    // 但可以将静态方法定义为泛型方法, 使用有别于泛型类的类型参数
    public static <R> R getR(Supplier<R> constructor) {
        return constructor.get();
    }

    @Test
    public void testStaticT() {
        Content c = L7_noStatic.<Content>getR(Content::new);
        System.out.println(c);
    }
}

class NormalClassWithT {
    public static <T> T getT(Supplier<T> constructor){
        return constructor.get();
    }
}