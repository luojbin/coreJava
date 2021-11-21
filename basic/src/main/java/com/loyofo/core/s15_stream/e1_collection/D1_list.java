package com.loyofo.core.s15_stream.e1_collection;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class D1_list {

    Logger logger = LoggerFactory.getLogger(D1_list.class);
    @Test
    public void testListForeach() {
        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("测试");
        strList.add("List 的 foreach");
        // foreach, 需要一个 consumer 的函数式接口, 用来对集合内的元素遍历操作, 无返回值.
        strList.forEach(str -> logger.info("集合元素 {} 的长度为 {}", str, str.length()));
    }

    @Test
    public void testMatch() {
        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("测试");
        strList.add("List 的 foreach");
        // stream 会将集合转换为 Stream 类型, 以使用 stream api
        // foreach: 与 list.forEach 功能类似, 遍历操作集合内的每一个元素
        strList.stream().forEach(str ->  logger.info("集合元素 {} 的长度为 {}", str, str.length()) );
        // stream().anyMatch(), 判断在集合内是否存在满足指定条件的元素
        boolean hasLongStr = strList.stream().anyMatch(str -> str.length()>10);
        System.out.println(hasLongStr);

        // nonMatch, 判断集合内是否不存在满足条件的元素
        boolean hasNoLargeStr = strList.stream().noneMatch(str -> str.length()>100);
        System.out.println(hasNoLargeStr);

        // allMatch, 判断集合内是否所有元素都满足条件
        boolean noEmptyStr = strList.stream().allMatch(str -> str.length() > 0 );
        System.out.println(noEmptyStr);
    }

    /**  链式调用, 方法执行后扔返回 stream 对象, 可以进一步操作, 最后往往需要 collect() 方法将stream 元素收集起来 */
    @Test
    public void testCollect() {
        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("/a-长度");
        strList.add("/a-长度a21");
        strList.add("/b-长度a323");
        strList.add("/b-长度bbbbb");
        strList.add("/b-长度bbbbb1");
        strList.add("/b-长度bbbbb22");

        // collect, 接收一个 Collector 收集器, 指示需要如何收集stream 中的元素,
        // 通常用来将 stream 转换为 list, map 等集合对象
        List<String> toList = strList.stream().collect(Collectors.toList());
        Set<String> toSet = strList.stream().collect(Collectors.toSet());
        Map<String, String> toMap = strList.stream()
                .collect(Collectors.toMap(
                        str -> str,
                        str -> str.substring(0,2)
                ));
        logger.info("stream.toList 结果{}", toList);
        logger.info("stream.toSet 结果{}", toSet);
        logger.info("stream.toMap 结果{}", toMap);
    }

    /**
     * 链式调用, 方法返回值仍是 stream, 最后通常需要使用 collect 收集结果元素
     */
    @Test
    public void testChain() {
        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("/a-长度");
        strList.add("/a-长度a21");
        strList.add("/b-长度a323");
        strList.add("/b-长度bbbbb");
        strList.add("/b-长度bbbbb");
        strList.add("/b-长度bbbbb");
        strList.add("/b-长度bbbbb");
        strList.add("/b-长度bbbbb1");
        strList.add("/b-长度bbbbb22");

        List<String> aList = strList.stream()
                .filter(str -> str.startsWith("/a"))
                .collect(Collectors.toList());
        List<String> distinctList = strList.stream()
                .distinct()
                .collect(Collectors.toList());

        logger.info("过滤结果: {}", aList);
        logger.info("去重结果: {}",distinctList);
    }


    /**
     * 通过 filter 在集合中筛选出满足指定条件的元素, 通常会用 collect() 方法收集元素
     */
    @Test
    public void testFilter() {
        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("apple");
        strList.add("banana");
        strList.add("candy");
        strList.add("dog");
        strList.add("elephant");
        strList.add("food");
        strList.add("apple");

        // 可以使用 collect 收集所有满足条件的
        List<String> fiveLetter = strList.stream()
                .filter(s -> s.length() == 5)
                .collect(Collectors.toList());
        System.out.println(fiveLetter);

        // 去除重复
        List<String> fiveLetter2 = strList.stream()
                .filter(s -> s.length() == 5)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(fiveLetter2);

        // 可以使用 findAny() 获取任意一个
        strList.stream()
                .filter(s -> s.length() == 5)
                .findAny()
                .ifPresent(System.out::println);

        // 可以使用 findAny() 获取任意一个
        strList.stream()
                .filter(s -> s.length() == 5)
                .findFirst()
                .ifPresent(System.out::println);
    }

    /**
     * map 是映射, 可以将原始流映射为另一个流, 通常需要用 collect 收集结果
     */
    @Test
    public void testMap() {
        List<String> origin = new ArrayList<>();
        origin.add("apple");
        origin.add("boy");
        origin.add("cat");
        origin.add("dog");
        origin.add("egg");
        origin.add("food");
        origin.add("girl");
        origin.add("hand");
        origin.add("idea");
        origin.add("joke");
        origin.add("king");

        List<String> result = origin.stream()
                .map(s -> s + s.length())
                .collect(Collectors.toList());
        System.out.println(origin);
        System.out.println(result);
    }

}
