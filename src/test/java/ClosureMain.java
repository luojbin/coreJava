import com.loyofo.core.s6_interface.e4_functionInterface.f1_consumer.MyConsumer;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * Created by Ung8023
 * 测试java中的闭包
 */

public class ClosureMain {
    private static String sVar = "类静态域";
    private String var = "类实例域";


    public void testLambdaNoVar() {
        MyConsumer consumer = new MyConsumer();
        consumer.doWithObject("sss", s -> System.out.println(s));
    }


    public void testFreeVar() {
        String mVar = "方法中的局部变量";
        MyConsumer consumer = new MyConsumer();
        consumer.doWithObject("str", s -> {
            System.out.println(s);
            // 访问当前对象的实例域 var 和静态域 sVar
            System.out.println(var);
            System.out.println(sVar);
            System.out.println(mVar);
        });
    }

    public void testLambda() throws Exception{
        String var = "方法内局部变量";
        String obj = "nothing";
        MyConsumer consumer = new MyConsumer();

        // 尝试外部修改
        // var = ""; //局部变量要求事实final, 不可修改
        sVar = sVar + "_testLambda()";
        this.var = this.var + "_testLambda()";

        System.out.println("---------------以下是 lambda 测试-------------");
        consumer.doWithObject(obj, s -> {
            // String var = "lambda 成员变量";// 不能在 lambda 内声明同名变量

            // 尝试在 lambda 内修改
            // var = var + "_lambda内修改"; // lambda报错, lambda要求局部变量为事实final, 不可修改
            sVar = sVar + "_lambda内修改";
            this.var = this.var + "_lambda内修改";

            System.out.println("var:" + var);// 局部变量, 要求事实上final
            System.out.println("svar:" + sVar);// 外部类的sVar, 不要求final
            System.out.println("this.var:" + this.var);// 类实例域, 不要求final
            System.out.println("ClosureTest.this.var:" + ClosureMain.this.var);
        });
    }

    public static void main(String[] args){
        CloseP c1 = new CloseP();
        c1 = new CloseP();
        c1.testFreeVar();
        c1 = null;
    }
}

class CloseP{
    private static String sVar = "类静态域";
    private String var = "类实例域";

    public void testFreeVar() {
        String mVar = "方法中的局部变量";
        MyConsumer consumer = new MyConsumer();
        consumer.doWithObject("str", s -> {
            System.out.println(s);
            // 访问当前对象的实例域 var 和静态域 sVar
            System.out.println(var);
            System.out.println(sVar);
            System.out.println(mVar);
        });
    }
}

