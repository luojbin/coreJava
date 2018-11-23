package com.loyofo.core.s8_generic.e2_genericClass.f3_withOlder;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkWithOlder {

    public static void main(String[] args){
        new WorkWithOlder().test();
    }

    public void test() {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("abc");
        strList.add("123");

        ArrayList objList = new ArrayList();
        objList.add(123);
        objList.add("123");

        this.doWithObjList(objList);

        // 无泛型对象, 作为实参传递到泛型形参的方法中, 警告可能会出现类型转换错误
        this.doWithStrList(objList);

        // 有类型对象, 传递给无类型方法
        this.doWithObjList(strList);

        // 方法返回无泛型对象, 被泛型变量接收, 提示未检查的类型转换
        List<String> strList2 = this.getObjList();

        // 方法返回泛型对象, 被无泛型变量接收
        List objList2 = this.getStrList();

        System.out.println(strList2);
        System.out.println(objList2);


    }

    public void doWithStrList(ArrayList<String> strList) {
        strList.add("ok");
        System.out.println(strList.get(0));
    }

    public void doWithObjList(ArrayList objList) {
        objList.add("ok");
        objList.add(123);
        objList.add(new Random());
        System.out.println(objList.get(0));
    }

    @Test
    public void test1() {

    }
    public ArrayList<String> getStrList() {
        return new ArrayList<>();
    }

    public ArrayList getObjList() {
        return new ArrayList();
    }

}


