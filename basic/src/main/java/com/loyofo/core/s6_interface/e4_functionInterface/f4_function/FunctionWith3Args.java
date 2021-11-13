package com.loyofo.core.s6_interface.e4_functionInterface.f4_function;

/**
 * 自定义的函数式接口, 接受3个参数, 并给出返回值
 *
 * @author luojbin
 * @version 1.0
 * @create 2018-09-12 17:33
 */
@FunctionalInterface
public interface FunctionWith3Args<A, B, C, R> {
    R apply(A a, B b, C c);
}
