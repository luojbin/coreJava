package com.loyofo.core.s9;

import javafx.util.Pair;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * @author luojbin
 * @version 1.0
 * @time 2018-11-22 17:41
 */
public class CooperateWithOlder {



    @Test
    public void test1() {
        JSlider jSlider = new JSlider();
        Dictionary<Integer, Component> dictionary = new Hashtable<>();

        // 将泛型对象, 传递给无类型方法, 没毛病
        jSlider.setLabelTable(dictionary);

        // 将无类型对象, 赋值给泛型类对象, 会警告类型转换
        Dictionary<Integer, Component> d2 = jSlider.getLabelTable();

        Dictionary d3 = (Dictionary<Integer, Component>)new Object();


        Pair<String, String>[] pairs = new Pair[10];


    }
}
