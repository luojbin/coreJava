package com.loyofo.core.s8_generic.e4_extends;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-26 10:20
 */
public class F1_extendsDemo {
    @Test
    public void testExtend() {
        // Teacher 是 Person 的子类
        Person person = new Teacher();
        // 但 ArrayList<Teacher> 不是 ArrayList<Pserson> 的子类, 编译错误
        // ArrayList<Person> personList = getTeachers();
        // 并且不允许在同一泛型类的不同参数化之间直接进行强转
        // ArrayList<Person> personList1 = (ArrayList<Person>) getTeachers();
    }

    @Test
    public void testConver() {
        // 只允许在原始类型与参数化类型之间强转, 但会带来类型安全的问题
        ArrayList<Teacher> teacherList = getTeachers();
        ArrayList<Person> personList = (ArrayList<Person>) (ArrayList) teacherList;
        Person p1 = personList.get(0);

        // 这时 personList 与 teacherList 引用了同一个对象
        // 如果在 personList 中添加 Person 对象, 则对 teacherList 而言是不合法的, 取出对象时出现类型转化异常
        personList.add(new Person());
        Teacher teacher = teacherList.get(1);// ClassCastException
    }

    @Test
    public void test() {
        List<Teacher> list = getTeachers();
        Teacher t = list.get(0);
    }
    public ArrayList<Teacher> getTeachers() {
        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher());
        return teacherList;
    }
    public ArrayList<Person> getPersons() {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person());
        return personList;
    }
}

class Person {}
class Teacher extends Person {}