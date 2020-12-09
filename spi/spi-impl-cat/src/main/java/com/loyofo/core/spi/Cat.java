package com.loyofo.core.spi;

public class Cat implements PetAnimal {
    @Override
    public void say() {
        System.out.println("猫咪在叫 喵喵喵");
    }
}
