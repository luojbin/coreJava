package com.loyofo.core.s6_interface.e5_methodRef;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-12 16:47
 */
public class Person {
    private String name;
    private String phone;
    private String address;

    public Person(){
        System.out.println("无参构造");
        this.name = "hello ref new";
    }

    public Person(String name){
        System.out.println("单参构造");
        this.name = name;
    }

    public Person(String name, String phone){
        System.out.println("双参构造");
        this.name = name;
        this.phone = phone;
    }

    public Person(String name, String phone, String address){
        System.out.println("三参构造");
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    //<editor-fold desc="getter/setter">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //</editor-fold>

}
