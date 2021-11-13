package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.Test;

import java.util.function.Supplier;

public class L8_Throwable<T extends Exception, R>  {
    // 不允许抛出未加限定的泛型类对象, 因为未加限定的泛型类, 会被擦除成Objcet, Object 不是 Throwable 的
    // public void throwR(Supplier<R> constructor) throws R {
    //     throw constructor.get();
    // }

    // 可以抛出限定为 Throwable 的泛型对象, 也可以在方法声明中的异常声明处使用该类型
    public void throwT(Supplier<T> constructor) throws T {
        throw constructor.get();
    }

    public void catchT(Supplier<T> constructor){
        try {
            throwT(constructor);
            // 不能在 catch 子句中使用类型参数
            // } catch (T t1) {
        } catch (RuntimeException t1) {
            System.out.println("Catch Exception ok");
        } catch (Exception t1) {
            System.out.println("Catch Exception ok");
        }
    }

    @Test
    public void testThrowable() {
        L8_Throwable<RuntimeException, String> t = new L8_Throwable<>();
        t.catchT(RuntimeException::new);
    }
}



