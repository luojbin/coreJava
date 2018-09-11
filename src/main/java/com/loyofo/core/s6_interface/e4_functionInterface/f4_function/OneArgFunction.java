package com.loyofo.core.s6_interface.e4_functionInterface.f4_function;

import java.util.function.IntFunction;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-11 16:44
 */
public class OneArgFunction {

    //
    public <R> R doWithIntFunctin(Integer arg, IntFunction<R> func){
        return func.apply(arg);
    }
}
