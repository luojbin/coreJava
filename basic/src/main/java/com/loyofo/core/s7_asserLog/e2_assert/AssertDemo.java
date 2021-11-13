package com.loyofo.core.s7_asserLog.e2_assert;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 默认情况下, 断言不会被执行, 需要手动在 jvm 参数中指定 -ea
 * main 方法采用默认方式启动, 未开启断言, 程序正常执行到底
 * junit 方法启用了断言, 程序执行到断言处抛出错误而结束
 *
 * 可以手动关闭断言, 但需要在目标类加载之前设置, 对于已经加载的类中的断言, 依旧会执行
 */
public class AssertDemo {

    /**
     * 使用 main 方法测试, 未开启断言
     */
    public static void main(String[] args) {
        AssertMethod.testAssert();
    }

    /**
     * 使用 junit 方法测试, 开启断言
     */
    @Test
    @Ignore
    public void test() {
        AssertMethod.testAssert();
    }

    @Test
    public void testSetAssert() {
        System.out.println("第一次测试, junit 默认开启断言");
        try {
            AssertMethod.testAssert();
        } catch (Throwable e) {
            System.out.println("捕获断言抛出的 error" + e);
        }
        System.out.println();

        System.out.println("第二次测试, 手动关闭断言");
        this.getClass().getClassLoader().setDefaultAssertionStatus(false);
        try {
            AssertMethod.testAssert();
        } catch (Throwable e) {
            System.out.println("已加载的类, 断言仍会抛出 error" + e);
        }
        try {
            AssertMethod2.testAssert();
        } catch (Throwable e) {
            System.out.println("捕获断言抛出的 error" + e);
        }
    }
}

class AssertMethod {
    static void testAssert() {
        System.out.println("测试断言方法");
        assert false : "断言开启, 不能通过";
        System.out.println("测试方法结束");
    }
}
class AssertMethod2 {
    static void testAssert() {
        System.out.println("测试断言方法");
        assert false : "断言开启, 不能通过";
        System.out.println("测试方法结束");
    }
}
