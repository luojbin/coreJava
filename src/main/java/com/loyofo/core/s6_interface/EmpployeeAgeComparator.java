package com.loyofo.core.s6_interface;

import java.util.Comparator;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-08-23 11:25
 */
public class EmpployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge()-o2.getAge();
    }
}
