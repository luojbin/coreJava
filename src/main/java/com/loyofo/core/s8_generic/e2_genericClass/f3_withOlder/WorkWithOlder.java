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



}


