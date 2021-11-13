package com.loyofo.core.s6_interface.e3_mutilImplment;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-09
 */
public interface Cii extends Aii{
    int A = 3;
    @Override
    default void get(){
        System.out.println("Cii");
    }
    void get2();
}
