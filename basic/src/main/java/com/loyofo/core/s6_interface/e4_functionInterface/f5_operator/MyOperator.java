package com.loyofo.core.s6_interface.e4_functionInterface.f5_operator;

import java.util.function.*;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-12 14:32
 */
public class MyOperator<T> {
    public T operateWithT(T t, UnaryOperator<T> operator){
        return operator.apply(t);
    }

    public int operateWithInt(int t, IntUnaryOperator operator){
        return operator.applyAsInt(t);
    }

    public long operateWithLong(long t, LongUnaryOperator operator){
        return operator.applyAsLong(t);
    }

    public double operateWithDouble(double t, DoubleUnaryOperator operator){
        return operator.applyAsDouble(t);
    }

    public T operateWithT2(T t1, T t2, BinaryOperator<T> operator){
        return operator.apply(t1, t2);
    }

    public int operateWithInt2(int t1, int t2, IntBinaryOperator operator){
        return operator.applyAsInt(t1, t2);
    }

    public long operateWithLong2(long t1, long t2, LongBinaryOperator operator){
        return operator.applyAsLong(t1, t2);
    }

    public double operateWithDouble2(double t1, double t2, DoubleBinaryOperator operator){
        return operator.applyAsDouble(t1, t2);
    }
}
