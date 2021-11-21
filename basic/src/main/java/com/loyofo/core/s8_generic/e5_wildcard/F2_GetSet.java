package com.loyofo.core.s8_generic.e5_wildcard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 使用 ? extends T 时的限制
 * @author luojbin
 * @version 1.0
 * @time 2018-11-26 15:53
 */
public class F2_GetSet {
    @Test
    /**
     * 泛型类中的 get/set 方法
     */
    public void testExtends() {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        // ? extends Animal, 表示列表内可能是 Animal 的任意子类, Cat 是 Animal 的子类, 满足要求, 可以转换
        ArrayList<? extends Animal> animals = cats;

        // 但由于不确定里面的元素是什么类型, 因此不接受任何类型的实参, 不能往里面加东西
        // animals.add(new Animal());
        // animals.add(new Dog());
        // animals.add(new Cat());

        // 由于里面的东西肯定是Animal 的子类, 返回 Animal 不会有错, 所有返回类型都是 Animal
        Animal animal = animals.get(0);
    }

    @Test
    /**
     * 泛型类中的 get/set 方法
     */
    public void testSuper() {
        ArrayList<Animal> animals = new ArrayList<>();

        // ? super Cat, 表示列表内可能是 Cat 的任意超类, Animal 是 Cat 的超类, 满足要求, 可以转换
        ArrayList<? super Cat> superCats = animals;

        // 由于list内能装 Cat 的任意超类, 那么存入 Cat 及其子类对象肯定没问题
        superCats.add(new Cat());
        superCats.add(new Lion());

        // 但因为不确定是哪一个超类, 所以不允许存入 Cat 的超类对象
        // superCats.add(new Animal());

        // 虽然能确定列表内是 Cat 的某个超类, 但无法确定具体是什么, 只能返回 Object,
        Object animal = animals.get(0);
    }
}
