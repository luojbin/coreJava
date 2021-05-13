package com.loyofo.core.s6_interface.e7_proxy.api.impl;

import com.loyofo.core.s6_interface.e7_proxy.api.Dog;

public class RealDog implements Dog {
    @Override
    public void wang() {
        System.out.println("狗子汪汪汪");
    }
}
