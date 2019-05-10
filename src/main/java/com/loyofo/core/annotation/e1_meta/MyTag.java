package com.loyofo.core.annotation.e1_meta;

import java.lang.annotation.*;
// 是否将注解信息添加到 javadoc
@Documented
// 允许在什么地方使用这个注解
// @Target(ElementType.TYPE)
// 注解的保留到什么时候? source/class/runtime
@Retention(RetentionPolicy.RUNTIME)
// 子类继承时时候继承注解
@Inherited
// 是否可以在同一个位置添加多个同类注解, 需要指定对应的容器注解
// 因为编译器会将多个重复注解替换成对应的容器注解, 相当于是容器注解的子类
// 单个注解的适用范围要小于容器注解, 具体的说,
@Repeatable(MyTags.class)
public @interface MyTag {
    String msg() default "";
}

