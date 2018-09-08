package com.loyofo.core.s6_interface.e3_mutilImplment;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-09
 */
public interface Aii {
    int A = 1;
    default void get(){
        System.out.println("Aii");
    }
    static void sget(){
        System.out.println("Aii static");
    }
}
