package com.loyofo.core.s6_interface.e3_mutilImplment;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-09
 */
public interface Bii extends Aii{
    int A = 2;
    int B = 2;
    @Override
    default void get(){
        System.out.println("Bii");
    }
    default void get2(){
        System.out.println("Bii2");
    }
}
