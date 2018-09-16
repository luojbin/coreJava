package com.loyofo.core.s6_interface.e6_innerClass.f3_anonymous;

import org.junit.Test;

public class OuterRef {

    @Test
    public void testThisRef() {
        Object innerFromInstanceMethod = getInner();
        // Object innerFromStaticMethod = getInnerStatic();

        Object localFromInstanceMethod = getLocal();
        Object localFromStaticMethod = getLocalStatic();

        Object anonymousFromInstanceMethod = getAnonymous();
        Object anonymousFromStaticMethod = getAnonymousStatic();

        Object staticInnerFromInstanceMethod = getStaticInner();
        Object staticInnerFromStaticMethod = getStaticInnerStatic();
    }

    class Inner {}

    static class StaticInner {}

    public Object getInner(){ return new Inner(); }

    public static Object getInnerStatic(){
        // 静态方法不能创建非静态内部类对象
        // return new Inner();
        return null;
    }

    public Object getLocal() {
        class LocalObject {}
        return new LocalObject();
    }

    public static Object getLocalStatic() {
        class LocalObject {}
        return new LocalObject();
    }

    public Object getAnonymous(){ return new Object() {}; }

    public static Object getAnonymousStatic() { return new Object() {}; }

    public Object getStaticInner(){
        return new StaticInner();
    }

    public static Object getStaticInnerStatic(){
        return new StaticInner();
    }
}
