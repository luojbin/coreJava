package com.loyofo.core.s8_generic.e5_wildcard;

import java.util.ArrayList;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-27 14:11
 */
class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

class Lion extends Cat {
}

public class Zoo {
    private ArrayList<Animal> animals;
    private ArrayList<Dog> dogs;
    private ArrayList<Cat> cats;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnyAnimal(ArrayList<? extends Animal> list) {
        animals.addAll(list);
    }

    // public void addAnimal(ArrayList<Animal> list) {
    //     animals.addAll(list);
    // }
    // public void addAnyCat(ArrayList<? super Lion> list) {
    //     cats.addAll(list);
    // }
    //
    // public void addCat(ArrayList<Cat> list) {
    //     animals.addAll(list);
    // }
    //
    // public ArrayList<? extends Animal> getDogs() {
    //     return dogs;
    // }
    // public ArrayList<? extends Animal> getCats() {
    //     return cats;
    // }
    // public ArrayList<? super Lion> getCats() {
    //     return cats;
    // }
}