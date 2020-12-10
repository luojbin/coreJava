package com.loyofo.core.seal.yes;

public class DogKiller {
    public void killDog(SealDog dog){
        System.out.println("DogKiller get the dog: " + dog.name);
    }

    public static void main(String[] args) {
        new DogKiller().killDog(new SealDog());
    }
}
