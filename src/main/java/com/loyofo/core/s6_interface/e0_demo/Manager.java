package com.loyofo.core.s6_interface.e0_demo;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-08-23 13:08
 */
public class Manager extends Employee {
    public Manager(){
        this("经理", 20, "男");
    }
    public Manager(String name, int age, String sex) {
        super(name, age, sex);
    }

}
