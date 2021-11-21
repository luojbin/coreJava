import com.loyofo.core.s6_interface.e4_functionInterface.f1_consumer.MyConsumer;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * Created by Ung8023
 * 测试java中的闭包
 */

public class ClosureTest {
    private static String sVar = "类静态域";
    private String var = "类实例域";

    @Test
    public void testLambdaNoVar() {
        MyConsumer consumer = new MyConsumer();
        consumer.doWithObject("sss", s -> System.out.println(s));
    }

    @Test
    public void testFreeVar() {
        String mVar = "方法中的局部变量";
        MyConsumer consumer = new MyConsumer();
        consumer.doWithObject("str", s -> {
            System.out.println(s);
            // 访问当前对象的实例域 var 和静态域 sVar
            System.out.println(var);
            System.out.println(sVar);
            // 访问当前方法的局部变量
            System.out.println(mVar);
        });
    }
    @Test
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

            System.out.println("this:" + this);
            System.out.println("var:" + var);// 局部变量, 要求事实上final
            System.out.println("svar:" + sVar);// 外部类的sVar, 不要求final
            // 此处的 this, 指的是外部类对象, 在 lambda 表达式中, 完全隐藏了内部类对象, 也就没有实例域
            System.out.println("this.var:" + this.var);// 类实例域, 不要求final
            System.out.println("ClosureTest.this.var:" + ClosureTest.this.var);
        });
    }

    @Test
    public void testLambdaTrans() {
        String var = "方法内局部变量";
        String obj = "nothing";

        // 尝试外部修改
        // var = ""; //局部变量要求事实final, 不可修改
        sVar = sVar + "_testLambdaTrans()";
        this.var = this.var + "_testLambdaTrans()";

        System.out.println("---------------以下是 lambda 转化测试-------------");
        MyConsumer consumer = new MyConsumer();
        consumer.doWithObject(obj, new Consumer<String>() {
            // 相当于存在这样一个局部变量, 引用了外部对象
            ClosureTest capture = ClosureTest.this;
            @Override
            public void accept(String s) {
                // 尝试在 lambda 内修改
                // var = var + "_lambda内修改"; // lambda报错, lambda要求局部变量为事实final, 不可修改
                sVar = sVar + "_lambda内修改";
                capture.var = capture.var + "_lambda内修改";

                System.out.println("var:" + var);// 局部变量, 要求事实上final
                System.out.println("svar:" + sVar);// 外部类的sVar, 不要求final
                // 并将原来的 this.var, 换成了 capture.var
                System.out.println("this.var:" + capture.var);// 类实例域, 不要求final
                System.out.println("ClosureTest.this.var:" + ClosureTest.this.var);
            }
        });
    }

    @Test
    public void testInnerClass() {
        String methodVar = "方法内局部变量";
        String obj = "nothing";

        // 尝试外部修改
        // methodVar = ""; //局部变量要求事实final, 不可修改
        sVar = sVar + "_testInnerClass()";
        this.var = this.var + "_testInnerClass()";

        System.out.println("---------------以下是内部类测试-------------");
        MyConsumer consumer = new MyConsumer();
        consumer.doWithObject(obj, new Consumer<String>() {
            // String var = "内部类实例域";

            @Override
            public void accept(String s) {
                // String var = "内部类方法局部变量";
                //
                // // 尝试在内部类方法中修改
                // // methodVar = ""; // 捕捉的局部变量要求事实final, 不可修改
                // var = var + "_内部类方法中修改";
                // this.var = this.var + "_内部类方法中修改";
                // ClosureTest.this.var = ClosureTest.this.var + "_内部类方法中修改";
                // sVar = sVar + "_内部类方法中修改";
                //
                // // 内部类访问外部方法中的局部变量, 要求事实上 final
                // // System.out.println("methodVar:" + methodVar);
                // // 方法中定义的局部变量
                // System.out.println("var:" + var);
                // // 此处的 this, 指的是内部类对象
                // System.out.println("this.var:" + this.var);
                // // 需要用 外部类型.this 获取外部类对象
                // System.out.println("ClosureTest.this.var:" + ClosureTest.this.var);
                // // 内部类访问外部类的静态域
                // System.out.println("svar:" + sVar);
            }
        });
    }
}

