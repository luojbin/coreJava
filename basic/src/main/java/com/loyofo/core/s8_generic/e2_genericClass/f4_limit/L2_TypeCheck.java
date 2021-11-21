package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-23 15:20
 */
public class L2_TypeCheck {
    @Test
    public void testTypeCheck() {
        Object list = getStrList();

        // 不能使用 instanceof 检查泛型类的类型参数
        // if (list instanceof ArrayList<String>) {
        //      System.out.println("list instanceof ArrayList<String>");
        // }

        if (list instanceof ArrayList) {
            System.out.println("list instanceof ArrayList");
        }

    }

    @Test
    public void testGetClass() {
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();

        // getClass() 只会返回原始类型, 不包含泛型类型参数
        System.out.println(strList.getClass()); // class java.util.ArrayList
        System.out.println(intList.getClass()); // class java.util.ArrayList
        System.out.println(strList.getClass() == intList.getClass()); // true
        System.out.println(strList.getClass().equals(intList.getClass())); // true
    }

    @Test
    public void testConver() {
        ArrayList list = new ArrayList();
        // 由于无法检查泛型类型, 因此强制类型转换时会警告"未经检查的类型转换", 可通过注解抑制警告
        @SuppressWarnings("unchecked")
        ArrayList<Integer> list2 = (ArrayList<Integer>) list;
    }

    public ArrayList getStrList() {
        return new ArrayList();
    }
}
