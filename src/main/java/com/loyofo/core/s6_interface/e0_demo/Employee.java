package com.loyofo.core.s6_interface.e0_demo;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-08-23 11:13
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private String sex;

    public static void ok(){
        System.out.println("ok");
    }
    public Employee(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 按年龄排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Employee o) {
        return this.age - o.age;
    }

    public int compareToBYname(Employee o) {
        return this.name.compareTo(o.name);
    }
}
