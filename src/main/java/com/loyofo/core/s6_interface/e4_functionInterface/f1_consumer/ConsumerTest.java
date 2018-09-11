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
        OneArgConsumer consumer = new OneArgConsumer();
        // IntConsumer
        System.out.println("----------IntConsumer 测试");
        consumer.doWithInt(1, i -> System.out.println(i));
        consumer.doWithInt(2, i -> System.out.println("这次输入了" + i));
        consumer.doWithInt(3, i -> {
            System.out.println("第三次测试, 输出 i 的平方");
            System.out.println(2 * 2);
        });

        System.out.println("----------DoubleConsumer 测试");
        consumer.doWithDouble(5, a -> System.out.println(a + 5));

    }
}
