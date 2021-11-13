package com.loyofo.core.s6_interface.e7_proxy.api.impl;

import com.loyofo.core.s6_interface.e7_proxy.api.Spider;

public class RealSpider implements Spider {
    @Override
    public void xiu() {
        System.out.println("蜘蛛吐丝, 咻咻咻");
    }
}
