package com.loyofo.core.s6_interface.e4_functionInterface.f3_predicate;

import java.util.function.*;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-12 14:08
 */
public class MyPredicate {
    public <T> boolean predicateWithT(T t, Predicate<T> predicate){
        return predicate.test(t);
    }

    public boolean predicateWithInt(int t, IntPredicate predicate){
        return predicate.test(t);
    }

    public boolean predicateWithLong(long t, LongPredicate predicate){
        return predicate.test(t);
    }

    public boolean predicateWithDouble(double t, DoublePredicate predicate){
        return predicate.test(t);
    }

    public <T, U> boolean predicateWithTU(T t, U u, BiPredicate predicate){
        return predicate.test(t, u);
    }
}
