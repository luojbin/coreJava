package com.loyofo.core.seal.demo;

import com.loyofo.core.seal.no.UnsealCat;
import com.loyofo.core.seal.no.UnsealDog;

public class UnsealDemo {
    public static void main(String[] args) {
        UnsealCat cat = new UnsealCat();
        UnsealDog dog = new UnsealDog();

        System.out.println(cat.toString());
        System.out.println(dog.toString());
    }
}
