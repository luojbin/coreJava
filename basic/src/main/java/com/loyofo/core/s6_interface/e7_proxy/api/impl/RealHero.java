package com.loyofo.core.s6_interface.e7_proxy.api.impl;

import com.loyofo.core.s6_interface.e7_proxy.api.Hero;

public class RealHero implements Hero {
    @Override
    public void fight() {
        System.out.println("战斗!");
    }
}
