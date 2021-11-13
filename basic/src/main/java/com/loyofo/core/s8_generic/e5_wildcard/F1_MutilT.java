package com.loyofo.core.s8_generic.e5_wildcard;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-26 11:34
 */
public class F1_MutilT {

    @Test
    public void test1() {
        // 不能将 ArrayList<Cat> 或 ArrayList<Dog> 作为 ArrayList<Animal> 的实参传入
        printList(new ArrayList<Animal>());
        // printList(new ArrayList<Cat>());
        // printList(new ArrayList<Dog>());
    }

    /**
     * 普通的泛型类, 不能接受同一泛型类的不同参数化
     * @param list
     */
    public void printList(ArrayList<Animal> list) {
        System.out.println(list);
    }

    @Test
    public void test2() {
        // ? extend T, 能够接受 T 的任意子类作为类型参数
        printExtendList(new ArrayList<Cat>());
        printExtendList(new ArrayList<Lion>());

        // 不接受非 T 子类的类型作为类型参数
        // printExtendList(new ArrayList<Animal>());
    }

    public void printExtendList(ArrayList<? extends Cat> list) {
        System.out.println(list);
    }

    @Test
    public void test3() {
        // ? super T, 能够接受 T 的任意超类作为类型参数
        printSuperList(new ArrayList<Animal>());
        printSuperList(new ArrayList<Cat>());

        // 不接受非 T 超类的类型作为类型参数
        // printSuperList(new ArrayList<Dog>());

        ArrayList<? extends Cat> list1 = new ArrayList<>();
    }
    public void printSuperList(ArrayList<? super Cat> list) {
        System.out.println(list);
    }
}


