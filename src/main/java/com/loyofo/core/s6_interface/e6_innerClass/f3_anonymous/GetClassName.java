package com.loyofo.core.s6_interface.e6_innerClass.f3_anonymous;

import org.junit.Test;

public class GetClassName {
    @Test
    public void testGetEnclosingClass() {
        System.out.println(getClassInMethod());
        System.out.println(getClassInStaticMethod());
    }

    public Class getClassInMethod() {
        return getClass();
    }

    public static Class getClassInStaticMethod() {
        return new Object() {
        }.getClass().getEnclosingClass();
    }
}
