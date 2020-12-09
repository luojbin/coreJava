package com.loyofo.core.spi;

import java.util.ServiceLoader;

public class Zoo {

    public static ServiceLoader<PetAnimal> petService = ServiceLoader.load(PetAnimal.class);
    public static ServiceLoader<ActorAnimal> actorService = ServiceLoader.load(ActorAnimal.class);

    public static void main(String[] args) {
        System.out.println("动物园开门了");
        for (PetAnimal pet : petService) {
            pet.say();
        }

        for (ActorAnimal actor : actorService) {
            actor.show();
        }

        System.out.println("动物园关门了");
    }
}
