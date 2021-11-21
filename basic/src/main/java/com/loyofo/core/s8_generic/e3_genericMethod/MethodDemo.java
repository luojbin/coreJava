package com.loyofo.core.s8_generic.e3_genericMethod;

import org.junit.jupiter.api.Test;

public class MethodDemo {

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    @Test
    public void test() {
        // 在方法名前用尖括号确定参数类型
        String s1 = MethodDemo.<String>getMiddle("aa", "bb", "cc");
        System.out.println(s1);

        // 大多数情况下, 编译器能根据实参类型推断出泛型方法的具体类型, 因此可以省略类型参数
        String s2 = MethodDemo.getMiddle("a", "b", "c");
        System.out.println(s2);

        // 如果实参有多种类型, 编译器会尝试寻求公共父类型, 此处推断出类型为 Number 或 Comparable, 上限为 Object
        Number n = MethodDemo.getMiddle(1, 20L, 3.3f, 4.0);
        System.out.println(n);

        // 如果想知道编译器推断出什么类型, 可以故意将返回值用不可能的类型接受, 则编译器会给出错误信息, 告知推断类型
        // String n2 = MethodDemo.getMiddle(1, 20L, 3.3f, 4.0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0 ){
            return null;
        }
        T smallest = a[0];
        for (int i = 1; i < a.length ; i++) {
            // 若不添加限定, 无法确定 T 类型中拥有 compareTo 方法, 此处编译错误
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }
}
