package com.loyofo.core.s6_interface.e1_interface;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-08
 */
public class ConstantsClass implements ConstantInterface{
    public static final int D = 4;
    public static final int E = 4;
    public static final int F = 4;

    public static ConstantsClass instance = new ConstantsClass();
    public static void main(String[] args){
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }

    public void geta(){}
}
