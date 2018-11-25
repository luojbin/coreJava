package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class L4_varargs {

    @SafeVarargs
    public static <T> void addAll(Collection<T> coll, T... ts) {
        System.out.println(ts.getClass());
        for (T t : ts) {
            coll.add(t);
        }
    }

    // @SuppressWarnings("unchecked")
    @Test
    public void test() {
        Collection<ArrayList<String>> coll = new LinkedList<>();
        // 原始类型可以正常调用
        ArrayList list1 = new ArrayList<String>();
        ArrayList list2 = new ArrayList<Integer>();
        addAll(coll, list1, list2);

        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<Integer> list5 = new ArrayList<Integer>();
        // 当实参的类型参数一致时, 可以调用, 但给出了"创建泛型数组"的警告

        addAll(coll, list3, list4);

        // 当实参的类型参数不一致时, 编译错误
        // addAll(coll, list3, list4, list5);
    }
}
