package com.loyofo.core.s6_interface.e4_functionInterface.f1_consumer;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-11 16:23
 */
public class OneArgConsumer {
    public void doWithInt(int i, IntConsumer consumer){
        consumer.accept(i);
    }

    public void doWithDouble(double d, DoubleConsumer consumer){
        consumer.accept(d);
    }

    public void doWithLong(long l , LongConsumer consumer){
        consumer.accept(l);
    }

    public <T> void doWithObject(T obj, Consumer<T> consumer){
        consumer.accept(obj);
    }
}
