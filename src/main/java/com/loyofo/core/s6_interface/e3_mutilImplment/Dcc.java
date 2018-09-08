package com.loyofo.core.s6_interface.e3_mutilImplment;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-09
 */
public class Dcc extends Ecc implements Bii, Cii {
    public static final int A = 999;
    @Override
    public void get() {
        System.out.println("Dcc");
    }

    /**
     * Bii 提供了 get2 的默认实现, Cii 仍是抽象方法
     * 此时不会采用 Bii 的实现, 仍需子类提供实现来解决冲突
     */
    @Override
    public void get2() {
        Bii.super.get2();
    }


    public void test(){
        System.out.println("==============方法调用测试");
        get();
        // 直接 super, 指的是父类对象
        super.get();
        // 实现的接口名.super, 指对应接口中的方法
        Bii.super.get();
        Cii.super.get();
        Aii.sget();

        System.out.println("==============getClass调用测试");
        System.out.println(getClass());
        System.out.println(getClass().getSuperclass());
        System.out.println(super.getClass().getSuperclass());
        System.out.println(super.getClass().getSuperclass().getSuperclass());
        System.out.println(Bii.super.getClass());
        System.out.println(Cii.super.getClass());

        System.out.println("==============接口常量调用测试");
        // 因为 Bii 和 Cii 中都定义了常量A, 但如果在类中不调用, 编译器不会提示常量冲突.
        // System.out.println(A);
    }

    public static void main(String[] args){
        Dcc d = new Dcc();
        d.test();
        Fcc f = d.new Fcc();
        f.get();
    }

    class Fcc{
        void get(){
            Dcc.super.getClass();
            Aii.sget();
            System.out.println(Aii.A);
            System.out.println(Bii.A);
            System.out.println(Cii.A);
            System.out.println(Dcc.A);
            System.out.println(Dcc.B);

        }
    }
}

