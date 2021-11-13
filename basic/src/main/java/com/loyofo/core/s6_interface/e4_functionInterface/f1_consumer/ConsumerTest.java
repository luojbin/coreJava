package com.loyofo.core.s6_interface.e4_functionInterface.f1_consumer;

import org.junit.Test;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-11 16:32
 */
public class ConsumerTest {
    @Test
    public void testIntConsumer() {
        MyConsumer consumer = new MyConsumer();
        // 以 lambda 作为实参传递
        consumer.doWithObject("hello lambda", s -> System.out.println(s));
        // 以 方法引用 作为实参传递
        consumer.doWithObject("hello method ref", System.out::println);
    }
}
