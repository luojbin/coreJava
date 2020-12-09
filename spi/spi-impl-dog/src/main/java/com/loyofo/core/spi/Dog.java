package com.loyofo.core.spi;

public class Dog implements PetAnimal {
    @Override
    public void say() {
        System.out.println("狗子在叫 汪汪汪");
    }
}
