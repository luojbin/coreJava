package com.loyofo.core.s8_generic.e5_wildcard;
//
// import com.loyofo.core.s6_interface.e0_demo.Employee;
// import com.loyofo.core.s6_interface.e0_demo.Manager;
// import com.loyofo.core.s8_generic.e2_genericClass.f1_basic.Pair;
// import org.junit.Test;
//
// import java.util.ArrayList;
//
// /**
//  * @author luojbin
//  * @version 1.0
//  * @time 2018-11-26 11:34
//  */
// public class F1_extends {
//
//     @Test
//     public void testExtends() {
//         Zoo zoo = new Zoo();
//         ArrayList<Dog> dogs = new ArrayList<>();
//         dogs.add(new Dog());
//         ArrayList<Cat> cats = new ArrayList<>();
//         cats.add(new Cat());
//         ArrayList<Animal> animals = new ArrayList<>();
//         animals.add(new Dog());
//         animals.add(new Cat());
//
//         // 由于不允许在同一泛型类的不同参数化之间进行类型转化, 导致此处不可调用
//         // zoo.addAnimal(dogs);
//         // zoo.addAnimal(cats);
//
//         // 使用 <? extends Animal> 匹配参数, 能够接受满足要求的多种不同的参数类型
//         zoo.addAnyAnimal(dogs);
//         zoo.addAnyAnimal(cats);
//         zoo.addAnyAnimal(animals);
//     }
//
//     @Test
//     public void test1() {
//         ArrayList<? extends Animal> zoo = new ArrayList<>();
//         // 使用通配符作为泛型类的类型参数, 则泛型类中以类型参数为形参的方法都将失效
//         // 因为 ? 无法匹配具体类型, 所以拒绝接受所有特定类型的实参
//         // zoo.add(new Dog());
//         // zoo.add(new Cat());
//
//         // 但可以正常使用以类型参数为返回值类型的方法, 这些方法将返回类型参数的限定类型
//         Animal animal = zoo.get(0);
//     }
//
//     @Test
//     public void test2() {
//         // 与 extends 相反, 可以以 T 类型及其子类为方法实参
//         ArrayList<? super Animal> zoo = new ArrayList<>();
//         zoo.add(new Animal());
//         zoo.add(new Cat());
//         zoo.add(new Lion());
//
//         // 但无法返回具体类型的对象, 只能赋值给Object
//         // Cat animal = zoo.get(0);
//         // Animal animal = zoo.get(0);
//         Object obj = zoo.get(0);
//     }
//
//     @Test
//     public void test3() {
//         // 在普通类中, 以 Generic<? extends T> 为形参类型的方法, 可以接受泛型类的多种参数化, 其中类型参数是 T 及其任意子类
//         Zoo zoo = new Zoo();
//         zoo.addAnyAnimal(new ArrayList<Dog>());
//         zoo.addAnyAnimal(new ArrayList<Cat>());
//         zoo.addAnyAnimal(new ArrayList<Animal>());
//
//         // 但若以 Generic<? extends T> 作为方法的返回值, 则该方法无法返回任何具体类型
//         // ArrayList<Animal> animals = zoo.getCats();
//         // ArrayList<Dog> dogs = zoo.getDogs();
//         // ArrayList<Cat> cats = zoo.getCats();
//     }
//
//     @Test
//     public void test4() {
//         // 在普通类中, 以 Generic<? super T> 为形参类型的方法, 可以接受泛型类的多种参数化, 其中类型参数是 T 及其任意子类
//         Zoo zoo = new Zoo();
//         zoo.addAnyAnimal(new ArrayList<Dog>());
//         zoo.addAnyAnimal(new ArrayList<Cat>());
//         zoo.addAnyAnimal(new ArrayList<Animal>());
//
//         // 但若以 Generic<? super T> 作为方法的返回值, 则该方法无法返回很合具体类型
//         // ArrayList<Animal> animals = zoo.getCats();
//         // ArrayList<Dog> dogs = zoo.getDogs();
//         // ArrayList<Cat> cats = zoo.getCats();
//     }
//
//
// }
//
class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}
class Lion extends Cat{}
//
// class Zoo {
//     private ArrayList<Animal> animals;
//     private ArrayList<Dog> dogs;
//     private ArrayList<Cat> cats;
//
//     public Zoo(){
//         animals = new ArrayList<>();
//     }
//
//     public void addAnyAnimal(ArrayList<? extends Animal> list) {
//         animals.addAll(list);
//     }
//
//     public void addAnimal(ArrayList<Animal> list) {
//         animals.addAll(list);
//     }
//     public void addAnyCat(ArrayList<? super Lion> list) {
//         cats.addAll(list);
//     }
//
//     public void addCat(ArrayList<Cat> list) {
//         animals.addAll(list);
//     }
//
//     public ArrayList<? extends Animal> getDogs() {
//         return dogs;
//     }
//     public ArrayList<? extends Animal> getCats() {
//         return cats;
//     }
//     public ArrayList<? super Lion> getCats() {
//         return cats;
//     }
// }
