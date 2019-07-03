package com.loyofo.spring.bean;

public class WomanPerson extends Person {

    {
        System.out.println("WomanPerson 正在创建");
        this.name = "女人";
    }

    @Override
    public void work() {
        System.out.println(this.getName() + "正在做饭");
    }

    @Override
    public void pee() {
        System.out.println(this.getName() + "蹲着尿尿");
    }
}
