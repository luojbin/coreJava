package com.loyofo.core.s6_interface.e0_demo;

import java.util.Comparator;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-08-23 11:25
 */
public class EmpployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
