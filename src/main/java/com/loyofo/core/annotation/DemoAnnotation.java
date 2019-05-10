package com.loyofo.core.annotation;

import com.loyofo.core.annotation.e1_meta.MyTag;
import com.loyofo.core.annotation.e1_meta.MyTags;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DemoAnnotation {

    @Test
    public void testAAA() {
        System.out.println("========= OneTag ======");
        System.out.println("可重复的注解只添加一个时, 反射可以获取到这个独立注解 ");
        System.out.println(OneTag.class.isAnnotationPresent(MyTag.class));
        System.out.println(OneTag.class.isAnnotationPresent(MyTags.class));
        System.out.println("========= TwoTags ======");
        System.out.println("可重复的注解添加多个时, 反射只可以获取到这个独立注解对应的容器注解 ");
        System.out.println(TwoTags.class.isAnnotationPresent(MyTag.class));
        System.out.println(TwoTags.class.isAnnotationPresent(MyTags.class));
        System.out.println("========= TwoTags2 ======");
        System.out.println("添加多个可重复注解时, 实际上编译器会将其替换成对应的容器注解, 因此在反射获取注解时, 不能获取到单个注解");
        System.out.println(TwoTags2.class.isAnnotationPresent(MyTag.class));
        System.out.println(TwoTags2.class.isAnnotationPresent(MyTags.class));
        System.out.println("========= ThreeTags ======");
        System.out.println("竟然可以将单个注解和容器注解配合使用");
        Class tag3 = ThreeTags.class;
        System.out.println(tag3.isAnnotationPresent(MyTag.class));
        System.out.println(tag3.isAnnotationPresent(MyTags.class));
        System.out.println(Arrays.toString(tag3.getAnnotations()));
    }
}

@MyTag(msg = "this is a tag")
interface OneTag {
}

@MyTag(msg = "this is a tag")
@MyTag(msg = "hello world")
class TwoTags3 {}

@MyTag(msg = "this is a tag")
@MyTag(msg = "hello world")
class TwoTags {
    @MyTag(msg = "field tag")
    private int ii;

    @MyTag
    public void ttt(@MyTag String s) {
        @MyTag int iii;
        // 默认不适用于 type_use
        // new ArrayList<@MyTag String>();
    }


}

@MyTags(value= {@MyTag(msg = "this is a tag"), @MyTag(msg = "hello world")})
class TwoTags2 {
}
@MyTags(value= {@MyTag(msg = "this is a tag"), @MyTag(msg = "hello world")})
@MyTag(msg = "this is a amazing tag")
class ThreeTags {

}

// 默认不能用于 TYPE_PARAMETER
// class Tass<@MyTag T> {
//     public T getT(T t) {
//         return t;
//     }
// }

