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
public class L3_GenericArray {

    @Test
    public void testInit() {
        // 不允许泛型数组初始化
        // ArrayList<String>[] strArr = new ArrayList<String>[10];
        ArrayList[] objArr = new ArrayList[10];

        // 只能用原始类型去初始化泛型数组
        ArrayList<String>[] strArr1 = new ArrayList[10];
        // 或者使用通配符初始化, 再强转为指定类型的数组(实质还是原始类型数组, 但便于编译器进行类型检查)
        ArrayList<Double>[] strArr2 = (ArrayList<Double>[])new ArrayList<?>[10];

        // 由于类型擦除, 参数化类型的数组变量, 与原始类型的数组变量, 在虚拟机中是同一种类型
        System.out.println(objArr.getClass());  // class [Ljava.util.ArrayList;
        System.out.println(strArr1.getClass()); // class [Ljava.util.ArrayList;
        System.out.println(strArr2.getClass()); // class [Ljava.util.ArrayList;
        System.out.println(objArr.getClass().equals(strArr1.getClass())); // true
    }


    @Test
    public void testDeclare() {
        // 可以声明参数类型的数组变量, 但是只能用初始类型初始化, 有"未检查类型"的警告
        ArrayList<String>[] strArr = new ArrayList[10];

        // 往参数类型数组中, 存入参数类型元素, 编译器会进行类型检查, 若不符合会编译错误
        // strArr[0] = new ArrayList<Integer>();    // 编译错误
        strArr[0] = new ArrayList<String>();

        // 往原始类型数组中, 存入不同参数类型的元素, 不会编译错误
        ArrayList[] objArr = new ArrayList[10];
        objArr[0] = new ArrayList<String>();
        objArr[0] = new ArrayList<Integer>();

        // 将参数类型数组赋值给原始类型数组, 则原数组也可存入不同的参数类型元素, 不会编译错误
        ArrayList[] strArrToObjArr = strArr;
            // 可以存入 ArrayList<String>
            ArrayList<String> strList = new ArrayList<>();
            strList.add("hello generic");
            strArrToObjArr[0] = strList;
            // 可以存入 ArrayList<Integer>
            ArrayList<Integer> intList = new ArrayList<>();
            intList.add(123);
            strArrToObjArr[1] = intList;

        // 虽然存入了不同参数类型的元素, 但取出时可能出现类型转换异常
        // String s1 = strArr[1].get(0); // 类型转换异常
        String s2 = strArr[0].get(0);
    }
}
