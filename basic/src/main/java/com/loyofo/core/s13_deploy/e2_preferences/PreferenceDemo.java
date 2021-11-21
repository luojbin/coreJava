package com.loyofo.core.s13_deploy.e2_preferences;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;
import java.util.stream.Stream;

public class PreferenceDemo {
    
    @Test
    public void testNode() throws BackingStoreException {
        // 获取用户树
        Preferences userRoot = Preferences.userRoot();
        System.out.println(userRoot.absolutePath());

        // 如果节点路径等于包名, 可以通过 class 获取该节点
        Preferences userPackageNode = Preferences.userNodeForPackage(PreferenceDemo.class);
        System.out.println(userPackageNode.absolutePath());

        // 获取节点
        Preferences node = userRoot.node("com/loyofo");
        System.out.println(node.absolutePath());

        // 相对路径, 获取下级节点
        Preferences sonNode = node.node("son");
        System.out.println(sonNode.absolutePath());

        // 绝对路径, 获取任意节点
        Preferences sonNode2 = node.node("/son");
        System.out.println(sonNode2.absolutePath());

        Preferences comNode = node.node("/com");
        System.out.println(Arrays.toString(comNode.childrenNames()));

        // 清理测试的节点
        node.removeNode();
    }

    @Test
    public void testData() throws BackingStoreException {
        Preferences userRoot = Preferences.userRoot();
        Preferences node = userRoot.node("com/loyofo/data");

        // 往节点的映射表中添加数据, 字符串或数值
        node.put("strVal", "hello Pref");
        node.putInt("intVal", 123);
        node.putBoolean("boolVal", true);
        node.putByteArray("byteArray", "byte Array".getBytes(StandardCharsets.UTF_8));

        // 获取节点下所有 keys
        System.out.println(Arrays.toString(node.keys()));

        // 获取某个key的值
        System.out.println(node.get("strVal", "--empty--"));
        System.out.println(node.getInt("intVal", 0));
        System.out.println(node.getBoolean("boolVal", false));
        System.out.println(new String(node.getByteArray("byteArray", new byte[]{})));

        // 如果类型不正确, 不会抛出异常, 而是会用默认值替代
        System.out.println(node.getInt("strVal", -1));
        System.out.println(node.getBoolean("strVal", false));
        System.out.println(node.get("strVal", ""));
        System.out.println(node.getFloat("strVal", -1));
    }

    @Test
    public void testExport() throws BackingStoreException, IOException {
        Preferences userRoot = Preferences.userRoot();

        // 导出数据
        OutputStream treeOut = new FileOutputStream("target/subTree.xml");
        Preferences treeNode = userRoot.node("com");
        treeNode.exportSubtree(treeOut);

        OutputStream nodeOut = new FileOutputStream("target/node.xml");
        Preferences node = userRoot.node("com/loyofo/data");
        node.exportNode(nodeOut);
    }

    @Test
    public void testImport() throws BackingStoreException, IOException, InvalidPreferencesFormatException {
        Preferences userRoot = Preferences.userRoot();
        Preferences node = userRoot.node("com/loyofo/data");
        node.removeNode();

        // 重新获取节点, 确认已清空
        node = userRoot.node("com/loyofo/data");
        System.out.println(Arrays.toString(node.keys()));

        // 导入数据
        InputStream in = new FileInputStream("target/node.xml");
        Preferences.importPreferences(in);

        // 确认已清空
        System.out.println(Arrays.toString(node.keys()));

    }

    @Test
    public void testSystem() throws BackingStoreException {
        Preferences system = Preferences.systemRoot();
        System.out.println(system);
        // System.out.println(system.keys());
        // System.out.println(Arrays.toString(system.childrenNames()));
    }
}
