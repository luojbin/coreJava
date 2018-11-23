package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.Test;

import javax.xml.transform.OutputKeys;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-23 15:25
 */
public class l3_GenericArray {
    @Test
    public void testArray() {

        ArrayList[] array = new ArrayList[10];
        ArrayList<String>[] array2 = new ArrayList[10];

        Object[] objArr = array;

        // 泛型对象擦除后得到原始类型, 因此可以通过数组的类型检查
        objArr[0] = new ArrayList<String>();

        System.out.println("ok");
        // 数组会记住自己的实际类型, 添加不合适的类型将会导致运行时异常
        // objArr[1] = "asd";

        ArrayList<String>[] abl = new ArrayList[10];
        ArrayList[] arr2 = abl;
        abl[0] = new ArrayList();
        abl[0] = new ArrayList<String>();
        arr2[0] = new ArrayList<Integer>();
        ArrayList<String> g = abl[0];

    }

    @Test
    public void testArrayT() {
        // 不允许实例化参数化类型的数组, 由于类型擦除, 数组实际上只能是原始类型 ArrayList[]
        // ArrayList<String>[] strArr1 = new ArrayList<String>[10];
        // 如果允许, 会带来什么后果?

        // 可以声明参数化类型的数组变量, 但是只能用初始类型初始化, 但有"未检查"的警告
        ArrayList<String>[] strArr = new ArrayList[10];

        // 由于类型擦除, 参数化类型的数组变量, 与原始类型的数组变量, 在虚拟机中是同一种类型
        ArrayList[] objArr = new ArrayList[10];
        System.out.println(strArr.getClass());
        System.out.println(objArr.getClass());

        // 往参数化类型数组中, 存入参数化类型对象, 编译器会进行类型检查, 若不符合会编译错误
        // strArr[0] = new ArrayList<Integer>();
        strArr[0] = new ArrayList<String>();

        // 往原始类型数组中, 可以存入不同参数化类型的对象, 因为类型擦除后, 在虚拟机中都是原始类型
        objArr[0] = new ArrayList<String>();
        objArr[0] = new ArrayList<Integer>();

        // 若将参数化类型数组赋值给原始类型数组, 则原对象也可存入不同的参数化类型对象
        ArrayList[] strArrToObjArr = strArr;
        ArrayList<String> strList = new ArrayList<>();
        strList.add("hello generic");
        strArrToObjArr[0] = strList;

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(123);
        strArrToObjArr[1] = intList;

        // 将不同的参数化类型对象存入原始类型数组, 取出时可能有类型转换异常
        String s1 = strArr[0].get(0);
        String s2 = strArr[1].get(0);
    }
}
