package com.loyofo.core.s6_interface.e6_innerClass.f1_innerClass;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-14 14:26
 */
public class InnerClassTest {
    public static void main(String[] args){
        Car car = new Car("捷豹", "F-TYPE");
        car.start();
    }
}

class Car{
    private String brand;
    private String model;

    public Car(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    public void start(){
        Engine engine = new Engine("95号汽油", 100);
        engine.run();
    }

    /**
     * 内部类
     */
    class Engine{
        private String oil;
        private int power;

        public Engine(String oil, int power){
            this.oil = oil;
            this.power = power;
        }

        public void run(){
            System.out.println("汽车正在运行");
            // 访问外部对象的数据域, 可注释后观察是否还有外围类对象的引用
            System.out.println("品牌: " + brand);
            System.out.println("型号: " + model);
            // 访问内部类对象的数据域
            System.out.println("发动机汽油: " + oil);
            System.out.println("发动机马力: " + power);
        }
    }
}
