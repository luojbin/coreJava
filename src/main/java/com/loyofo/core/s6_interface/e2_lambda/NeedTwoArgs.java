package com.loyofo.core.s6_interface.e2_lambda;

import org.junit.Test;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-08-23 14:02
 */
public class NeedTwoArgs {
    public String hello(String s1, String s2, TwoArgs twoArgs){
        return twoArgs.contact(s1, s2);
    }

    @Test
    public void testTwoArgs() {
        String str1 = "aaaaa, ";
        String str2 = "bbbbb";
        System.out.println(hello(str1, str2, (s1, s2)->s1+s2));
    }

}
