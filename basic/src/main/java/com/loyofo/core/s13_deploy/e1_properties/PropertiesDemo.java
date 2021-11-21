package com.loyofo.core.s13_deploy.e1_properties;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class PropertiesDemo {

    /**
     * store, 将配置键值对写到输出流
     */
    @Test
    public void testSaveProperties() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("intVal", "123");
        properties.setProperty("strVal", "luojbin");
        properties.setProperty("listVal", "Collections.singletonList");

        OutputStream out = new FileOutputStream("src/main/resources/s13/prop.properties");
        properties.store(out, "test save properties");
    }

    /**
     * load, 从输入流中读取配置
     */
    @Test
    public void testLoadProp() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/s13/prop.properties"));
        props.forEach((k,v) -> System.out.println(k + "=" + v));

        // 获取指定项的值
        assertEquals("123", props.getProperty("intVal"));

        // 如果该项不存在, 则返回 null
        assertNull(props.getProperty("str"));

        // 在获取配置的时候, 可以指定默认值
        assertEquals("luojbin", props.getProperty("author", "luojbin"));
    }


    /**
     * 每次获取配置的时候指定默认值, 会比较麻烦, 也可以事先指定默认值, 在 getProperties 时就不需要单独指定默认值了
     */
    @Test
    public void testDefault() throws IOException {
        // 默认配置
        Properties defaultProp = new Properties();
        defaultProp.setProperty("author", "luojbin");
        defaultProp.setProperty("address", "guangzhou");

        // 以一个已有的properties 作为参数创建， 则原 properties 会作为默认值
        Properties props = new Properties(defaultProp);
        props.load(new FileInputStream("src/main/resources/s13/prop.properties"));

        // 从外部文件获取到的配置
        assertEquals("123", props.getProperty("intVal"));
        // 外部文件中没有，取默认值的配置
        assertEquals("luojbin", props.getProperty("author"));
        assertEquals("guangzhou", props.getProperty("address"));
    }

}
