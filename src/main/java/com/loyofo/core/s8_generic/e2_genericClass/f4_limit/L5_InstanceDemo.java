package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.Test;

public class L5_InstanceDemo {
    @Test
    public void test1() {
        Container<Content> c = Container.getInstance(Content::new);
        System.out.println(c.content);
    }

    @Test
    public void test2() {
        Container<Content> c = Container.reflexInstance(Content.class);
        System.out.println(c.content);
    }
}

