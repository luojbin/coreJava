package com.loyofo.core.seal.no;

public class CatKiller {
    public void killCat(UnsealCat cat){
        System.out.println("catKiller get the cat: " + cat.name);
    }

    public static void main(String[] args) {
        new CatKiller().killCat(new UnsealCat());
    }
}
