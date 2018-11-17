package temp.OverloadDemo;

import java.io.PrintStream;

public class TestABC {

    public static void main(String[] args){
        Coo c = new Coo();
        print((Aoo)c);
        print((Boo)c);

    }

    public static void print(Aoo a) {
        System.out.println("Aoo method");
    }
    public static void print(Boo b) {
        System.out.println("Boo method");
    }
}
