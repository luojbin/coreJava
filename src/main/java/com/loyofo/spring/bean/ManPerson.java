package com.loyofo.spring.bean;

public class ManPerson extends Person {

    {
        System.out.println("ManPerson 正在创建");
        this.name = "男人";
    }

    @Override
    public void work() {
        System.out.println(this.getName() + "正在敲代码");
    }

    @Override
    public void pee() {
        System.out.println(this.getName() + "站着尿尿");
    }
}
