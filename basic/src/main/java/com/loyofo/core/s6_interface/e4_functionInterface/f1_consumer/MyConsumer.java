package com.loyofo.core.s6_interface.e4_functionInterface.f1_consumer;

import java.util.function.*;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-11 16:23
 */
public class MyConsumer {
    public void doWithInt(int i, IntConsumer consumer) {
        consumer.accept(i);
    }

    public void doWithDouble(double d, DoubleConsumer consumer) {
        consumer.accept(d);
    }

    public void doWithLong(long l, LongConsumer consumer) {
        consumer.accept(l);
    }

    public <T> void doWithObject(T obj, Consumer<T> consumer) {
        consumer.accept(obj);
    }

    public <T> void doWithInt2(T a, int b,  ObjIntConsumer<T> consumer){
        consumer.accept(a, b);
    }

    public <T> void doWithDouble2(T a, double d, ObjDoubleConsumer<T> consumer){
        consumer.accept(a, d);
    }

    public <T> void doWithLong2(T a, long l , ObjLongConsumer<T> consumer){
        consumer.accept(a, l);
    }

    public <T, U> void doWithObject2(T a, U b, BiConsumer<T, U> consumer){
        consumer.accept(a, b);
    }
}
