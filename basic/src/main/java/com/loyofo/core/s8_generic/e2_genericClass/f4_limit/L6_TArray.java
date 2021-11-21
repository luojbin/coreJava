package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class L6_TArray {

    public static <T extends Comparable> T[] minMax(T... a){
        // 不能直接使用 T[] 实例化数组, 因为类型擦除, 永远是原始类型
        // T[] mm = new T[2];
        Comparable[] mm = new Comparable[2];
        mm[0] = a[0];
        mm[1] = a[1];
        // 由于类型擦除, 强制类型转换无效
        return (T[]) mm;
    }

    @Test
    public void test() {
        // 不会有编译错误, 但是运行时异常.
        Comparable[] mm = L6_TArray.<Integer>minMax(123,456,789);
    }

    @Test
    public void testToArray() {
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");

        // toArray() 方法没有成分类型,无法构造 T[] 数组, 只能返回 Object[], 因此不能用具体类型数组接收
        // String[] array = list.toArray();

        // 为了能够返回指定类型数组, 需要用户提供一个已有的具体类型数组, 以获取目标类型
        String[] array = list.toArray(new String[1]);
        System.out.println(Arrays.toString(array));
    }

}

class MyList<E> {
    // 如果是私有域, 则可以声明为 Object[], 并在获取时进行类型转换
    private Object[] data;
    public MyList(int n) {
        data = new Object[n];
    }

    @SuppressWarnings("unchecked")
    public E get(int n) {
        if (n >= 0 && n < data.length) {
            // 这里的强制类型转换是假象, 由于类型擦除, 在这里并不会进行类型转换, 类型转换出现在调用该方法的地方
            return (E) data[n];
        }
        return null;
    }
    public void set(int n, E e) {
        if (n >= 0 && n < data.length) {
            data[n] = e;
        }
    }

}
