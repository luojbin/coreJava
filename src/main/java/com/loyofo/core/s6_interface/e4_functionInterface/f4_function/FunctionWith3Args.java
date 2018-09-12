package com.loyofo.core.s6_interface.e4_functionInterface.f4_function;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-12 17:33
 */
public interface FunctionWith3Args<A, B, C, R> {
    R apply(A a, B b, C c);
}
