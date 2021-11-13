package com.loyofo.core.s6_interface.e6_innerClass.f1_innerClass;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-14 14:26
 */
public class InnerClassScope {
    public static void main(String[] args){
        OuterA outer = new OuterA();
        // 访问 public 内部类
        OuterA.PublicInner publicInner = outer.new PublicInner();
        System.out.println(publicInner.publicField);
        // System.out.println(publicInner.privateField);// 私有域, 不允许访问
        publicInner.publicPrint();
        // publicInner.privatePrint(); // 私有方法, 不允许访问

        // 访问 private 内部类, 错误, 私有内部类不允许访问
        // OuterA.PrivateInner privateInner = outer.new PrivateInner();

        outer.printInner();
    }
}

class OuterA{
    public void printInner(){
        System.out.println("-----------------在外围类中访问内部类");

        PublicInner pubInner = new PublicInner();
        pubInner.publicField = "1";
        pubInner.privateField = "1";
        pubInner.publicPrint();
        pubInner.privatePrint();

        PrivateInner priInner = new PrivateInner();
        priInner.publicField = "2";
        priInner.privateField = "2";
        priInner.publicPrint();
        priInner.privatePrint();
    }

    public class PublicInner{
        public String publicField = "public 内部类的公有域";
        private String privateField = "public 内部类的私有域";

        public void publicPrint(){
            System.out.println("public 内部类的公有方法");
        }
        private void privatePrint(){
            System.out.println("public 内部类的公有方法");
        }
    }
    private class PrivateInner{
        public String publicField = "private 内部类的公有域";
        private String privateField = "private 内部类的私有域";

        public void publicPrint(){
            System.out.println("private 内部类的公有方法");
        }
        private void privatePrint(){
            System.out.println("private 内部类的公有方法");
        }
    }
}
