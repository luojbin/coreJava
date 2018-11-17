package com.loyofo.core.s8_generic.e0_arrayList;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListDemo {

    @Test
    public void test2() {
        ArrayList objList = new ArrayList();
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();

        System.out.println("测试在不同类型ArrayList 中添加 String");
        ArrayListWithoutT.addStrToList(objList);
        ArrayListWithoutT.addStrToList(intList);
        ArrayListWithoutT.addStrToList(strList);
        System.out.println("在不同类型的 ArrayList 中添加 String 成功\n");

        System.out.println("测试将数组 toString 输出");
        System.out.println(objList);
        System.out.println(intList);
        System.out.println(strList);
        System.out.println("不同类型的 ArrayList 都正常 toString 输出\n");

        System.out.println("测试获取添加到里面的 String 元素");
        Object o2 = objList.get(0);
        String s2 = strList.get(0);
        try {
            Integer i2 = intList.get(0);
        } catch (ClassCastException e) {
            System.out.println(">>> intList 获取其中 String 元素时发生了异常");
            ArrayList intList2 = intList;
            String i2 = (String)intList2.get(0);
            System.out.println(">>> intList 重新赋值给无类型 ArrayList 后又能正常取出 String 元素\n");
        }
    }
    @Test
    public void test4() {
        ArrayList objList = new ArrayList();
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();

        System.out.println("测试在不同类型ArrayList 中添加 String");
        ArrayListWithT.addStrToList(objList);
        // ArrayListWithT.addStrToList(intList);
        ArrayListWithT.addStrToList(strList);
        System.out.println("intList  不能添加 String \n");

        System.out.println("测试将数组 toString 输出");
        System.out.println(objList);
        System.out.println(intList);
        System.out.println(strList);
        System.out.println("不同类型的 ArrayList 都正常 toString 输出\n");

        System.out.println("测试获取添加到里面的 String 元素");
        Object o4 = objList.get(0);
        String s4 = strList.get(0);
        System.out.println(">>> intList 未能添加 String 元素\n");
    }

    @Test
    public void test3() {
        ArrayList objList = ArrayListWithoutT.getList();
        // 提示 未检查的类型绑定
        ArrayList<String> strList = ArrayListWithoutT.getList();
        ArrayList<Integer> intList = ArrayListWithoutT.getList();
        // 警告 未检查的类型转换
        ArrayList<String> strList1 = (ArrayList<String>) ArrayListWithoutT.getList();
        ArrayList<Integer> intList1 = (ArrayList<Integer>) ArrayListWithoutT.getList();

        ArrayList objList2 = ArrayListWithT.getList();
        ArrayList<String> strList2 = ArrayListWithT.getList();
    }
}
