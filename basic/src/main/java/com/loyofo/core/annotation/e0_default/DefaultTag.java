package com.loyofo.core.annotation.e0_default;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target({ElementType.TYPE_USE, ElementType.METHOD, ElementType.PACKAGE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultTag {

    String value() default "";
    String msg() default "";
}

