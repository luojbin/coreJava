package com.loyofo.core.s8_generic.e2_genericClass.f3_withOlder;


import org.junit.Test;

import java.lang.reflect.Array;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Random;

public class WorkWithOlder {

    @Test
    public void testTtoObj() {
        ArrayList<String> strList = new ArrayList<>();

        // T to Obj, 类似向上造型, 不会出现编译警告
        doWithObjList(strList);
        ArrayList objList = getStrList();
    }

    public void doWithObjList(ArrayList objList) {
        objList.add(123);
        objList.add("ok");
        objList.add(new Random());
        System.out.println(objList.get(0));
    }

    public ArrayList<String> getStrList() {
        return new ArrayList<>();
    }

    @Test
    public void testObjToT() {
        ArrayList objList = new ArrayList();

        // Obj to T, 需要强制转换, 会有编译警告
        doWithStrList(objList);
        ArrayList<String> strList = getObjList();
    }

    public void doWithStrList(ArrayList<String> strList) {
        strList.add("123");
        strList.add("ok");
        strList.add("new Random");
        System.out.println(strList.get(0));
    }


    public ArrayList getObjList() {
        return new ArrayList();
    }

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

}


