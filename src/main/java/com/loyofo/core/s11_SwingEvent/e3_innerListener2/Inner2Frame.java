package com.loyofo.core.s11_SwingEvent.e3_innerListener2;

import javax.swing.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class Inner2Frame extends JFrame {

    public Inner2Frame() {
        // 设置窗口标题
        setTitle("按钮框架");

        // 创建按钮面板
        JPanel btnPanel = new Inner2Panel();

        // 将按钮面板添加到框架上
        add(btnPanel);

        // 自动根据组件去调节框架的大小
        pack();
    }
}
