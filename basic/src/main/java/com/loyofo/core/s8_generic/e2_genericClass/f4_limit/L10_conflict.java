package com.loyofo.core.s8_generic.e2_genericClass.f4_limit;

import org.junit.Test;

public class L10_conflict {

}

class Box<T> {
    T value;

    // 类型擦除后, 与 Object 类的 boolean equals(Object) 冲突
    // public boolean equals(T value){
    //     return this.value.equals(value);
    // }

    public boolean equals(Object value){
        return this.value.equals(value);
    }
}

// 不能同时实现同一接口的不同参数化, 擦除后是重复实现同一接口
// class Aoo implements Comparable<String>, Comparable<Integer>{
//
//     @Override
//     public int compareTo(String o) {
//         return 0;
//     }
//     @Override
//     public int compareTo(Integer o) {
//         return 0;
//     }
// }
class Aoo implements Comparable<String>{
    /*
     * 将会合成桥方法:
     * public int comparaTo(Object o) { return comparaTo((String) o); }
     */
    @Override
    public int compareTo(String o) {
        return 0;
    }

}
// class Boo extends Aoo implements Comparable<Integer>{
    /*
     * 将会合成桥方法:
     * public int comparaTo(Object o) { return comparaTo((Integer) o); }
     * 与 Aoo 中合成的桥方法冲突
     * public int comparaTo(Object o) { return comparaTo((String) o); }
     */
    // @Override
    // public int compareTo(Integer o) {
    //     return 0;
    // }
// }