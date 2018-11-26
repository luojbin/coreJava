package com.loyofo.core.s8_generic.e5_wildcard;

import com.loyofo.core.s6_interface.e0_demo.Employee;
import com.loyofo.core.s6_interface.e0_demo.Manager;
import com.loyofo.core.s8_generic.e2_genericClass.f1_basic.Pair;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-26 15:53
 */
public class F2_EmpMan {

    @Test
    public void test1() {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();

        // 不能将 ArrayList<Cat> 或 ArrayList<Dog> 作为 ArrayList<Animal> 的实参传入
        printList(animals);
        // printList(cats);
        // printList(dogs);
    }

    public void printList(ArrayList<Animal> list){
        System.out.println(list);
    }

    @Test
    public void test2() {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();

        // 不能将 ArrayList<Cat> 或 ArrayList<Dog> 作为 ArrayList<Animal> 的实参传入
        printListExtend(animals);
        printListExtend(cats);
        printListExtend(dogs);
    }
    public void printListExtend(ArrayList<? extends Animal> list){
        System.out.println(list);
    }

    @Test
    public void test3() {
        ArrayList<Cat> cats = new ArrayList<>();
        // 将 ArrayList<Cat> 向上造型为 ArrayList<Animal>, 没问题
        ArrayList<? extends Animal> animals = cats;
        // 尝试往里面添加别的 animal 类型对象, 编译失败
        // animals.add(new Animal());
    }
}
