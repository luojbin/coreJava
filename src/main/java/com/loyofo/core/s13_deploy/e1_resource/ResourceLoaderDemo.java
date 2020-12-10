package com.loyofo.core.s13_deploy.e1_resource;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ResourceLoaderDemo {
    public static void main(String[] args) throws IOException {
        // 获取 class 文件
        Class c = ResourceLoaderDemo.class;
        // class.getResource() 会以当前类的路径为起点查找资源
        System.out.println(c.getResource(""));
        // class.getClassLoader().getResource() 会以项目 classpath 为起点查找资源
        System.out.println(c.getClassLoader().getResource(""));
    }
}
