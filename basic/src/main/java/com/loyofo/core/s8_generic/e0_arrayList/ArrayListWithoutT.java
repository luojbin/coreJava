package com.loyofo.core.s8_generic.e0_arrayList;

import java.util.ArrayList;

public class ArrayListWithoutT {

    public static void addStrToList(ArrayList list) {
        String s = "test";
        list.add(s);
    }


    public static ArrayList getList() {
        ArrayList list = new ArrayList();
        list.add("str in list");
        return list;
    }
}
