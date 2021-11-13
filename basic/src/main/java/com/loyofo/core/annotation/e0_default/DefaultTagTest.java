// @DefaultTag 需要用在 package-info.java 中
package com.loyofo.core.annotation.e0_default;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class DefaultTagTest {
    @Test
    public void testDefaultTag() throws Exception {
        Class<DefaultTag> ac = DefaultTag.class;
        
        // type
        System.out.println(TagAtInterface.class.getAnnotation(ac).value());
        System.out.println(TagAtAnnotation.class.getAnnotation(ac).msg());
        System.out.println(TagAtEnum.class.getAnnotation(ac).value());
        System.out.println(AbstractTagAtAbsClass.class.getAnnotation(ac).value());
        System.out.println(TagAtClass.class.getAnnotation(ac).value());

        // content
        System.out.println("===== content =====");
        Class<TagAtClass> c = TagAtClass.class;

        Field f = c.getField("tagAtField");
        System.out.println(f.getAnnotation(ac).value());

        Field sf = c.getField("tagAtStaticField");
        System.out.println(sf.getAnnotation(ac).value());

        Method m = c.getMethod("tagAtMethod", String.class);
        System.out.println(m.getAnnotation(ac).value());

        Parameter[] ps = m.getParameters();
        for(Parameter p : ps){
            System.out.println(p.getAnnotation(ac).value());
        }
        // m.get
    }
}


@DefaultTag("接口上的注解 TYPE/TYPE_USE")
interface TagAtInterface{}

@DefaultTag("注解上的注解 TYPE/ANNOTATION_TYPE/TYPE_USE")
@interface TagAtAnnotation{}

@DefaultTag("枚举类上的注解 TYPE/TYPE_USE")
enum TagAtEnum{}

@DefaultTag("抽象类的注解 TYPE/TYPE_USE")
abstract class AbstractTagAtAbsClass{}

@DefaultTag("具体类的注解 TYPE/TYPE_USE")
class TagAtClass{
    @DefaultTag("实例域的注解 FIELD/TYPE_USE")
    public int tagAtField;

    @DefaultTag("静态域的注解 FIELD/TYPE_USE")
    public static int tagAtStaticField;

    @DefaultTag("构造器的注解 CONSTRUCTOR/TYPE_USE")
    public TagAtClass(){}

    @DefaultTag("方法的注解 METHOD")
    public void tagAtMethod(@DefaultTag("形参的注解 PARAMETER/TYPE_USE") String tagAtParameter){
        @DefaultTag("局部变量的注解 LOCAL_VARIABLE/TYPE_USE")
        String tagAtLocalVar;

        // MyTClass<@DefaultTag("类型使用的注解 TYPE_USE") String> list = new MyTClass<>();
     }
}

// class MyTClass<@DefaultTag("类型使用的注解 TYPE_PARAMETER/TYPE_USE")  T> {
//     public @DefaultTag("方法的注解 METHOD/TYPE_USE") T getT(@DefaultTag("类型使用的注解 PARAMETER/TYPE_USE") T t) {
//         return t;
//     }
//     public @DefaultTag("方法的注解 METHOD/TYPE_USE") int getInt(@DefaultTag("类型使用的注解 PARAMETER/TYPE_USE") int t) {
//         return t;
//     }
//
// }


