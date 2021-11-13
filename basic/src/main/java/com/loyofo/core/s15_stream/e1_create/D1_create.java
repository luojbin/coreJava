package com.loyofo.core.s15_stream.e1_create;

import com.loyofo.core.common.DemoUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class D1_create {

    @Test
    public void fromCollection() {
        // 可以从现有的集合中获取流, 也是流最常见的使用场景

        // 
        List<Integer> integerList = DemoUtil.intList();
        Stream<Integer> listStream = integerList.stream();

        Set<Integer> integerSet = DemoUtil.intSet();
        Stream<Integer> setStream = integerSet.stream();
    }

    @Test
    public void fromArray() {

    }

    @Test
    public void from() {

    }

    private List<String> demoList() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        return list;
    }
}
