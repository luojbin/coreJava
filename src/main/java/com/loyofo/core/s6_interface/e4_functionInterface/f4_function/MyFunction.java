package com.loyofo.core.s6_interface.e4_functionInterface.f4_function;

import java.util.function.*;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-11 16:44
 */
public class MyFunction {
    public <T,R> R doWithTFunction(T arg, Function<T,R> func){
        return func.apply(arg);
    }

    public <R> R doWithIntFunctin(int arg, IntFunction<R> func){
        return func.apply(arg);
    }

    public <R> R doWithLongFunctin(long arg, LongFunction<R> func){
        return func.apply(arg);
    }

    public <R> R doWithDoubleFunctin(double arg, DoubleFunction<R> func){
        return func.apply(arg);
    }


    public <T> int getIntFromT(T t, ToIntFunction<T> func){
        return func.applyAsInt(t);
    }

    public int getIntFromLong(long t, LongToIntFunction func){
        return func.applyAsInt(t);
    }

    public int getIntFromDouble(double t, DoubleToIntFunction func){
        return func.applyAsInt(t);
    }


    public <T> long getLongFromT(T t, ToLongFunction<T> func){
        return func.applyAsLong(t);
    }

    public long getLongFromInt(int t, IntToLongFunction func) {
        return func.applyAsLong(t);
    }

    public long getLongFromDouble(double t, DoubleToLongFunction func) {
        return func.applyAsLong(t);
    }


    public <T> double getDoubleFromT(T t, ToDoubleFunction<T> func){
        return func.applyAsDouble(t);
    }

    public double getDoubleFromInt(int t, IntToDoubleFunction func){
        return func.applyAsDouble(t);
    }

    public double getDoubleFromLong(long t, LongToDoubleFunction func){
        return func.applyAsDouble(t);
    }

    public <T, U, R> R getFromTU(T t, U u, BiFunction<T,U,R> func){
        return func.apply(t, u);
    }

    public <T, U> int getFromTU(T t, U u, ToIntBiFunction<T,U> func){
        return func.applyAsInt(t, u);
    }

    public <T, U> long getFromTU(T t, U u, ToLongBiFunction<T,U> func){
        return func.applyAsLong(t, u);
    }

    public <T, U> double getFromTU(T t, U u, ToDoubleBiFunction<T,U> func){
        return func.applyAsDouble(t, u);
    }
}
