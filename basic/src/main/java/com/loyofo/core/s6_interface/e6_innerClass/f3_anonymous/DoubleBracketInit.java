package com.loyofo.core.s6_interface.e6_innerClass.f3_anonymous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DoubleBracketInit {
    @Test
    public void testInitWithAnonymous() {
        // 传统方式构造列表
        ArrayList<String> list = new ArrayList<>();
        list.add("list-1");
        list.add("list-2");
        list.add("list-3");
        printList(list);

        // 双括号初始化构造列表
        printList(new ArrayList<String>() {{
            add("anonymous-1");
            add("anonymous-2");
            add("anonymous-3");
        }});
    }

    public void printList(ArrayList<String> list) {
        System.out.println(list);
    }
}
