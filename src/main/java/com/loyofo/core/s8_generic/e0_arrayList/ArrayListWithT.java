package com.loyofo.core.s8_generic.e0_arrayList;

import java.util.ArrayList;

public class ArrayListWithT {
    public static void addStrToList(ArrayList<String> list) {
        String s = "test";
        list.add(s);
    }

    public static ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("str in list");
        return list;
    }
}
