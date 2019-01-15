package com.loyofo.core.s7_swing.e4_color;

import javax.swing.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class ColorFrame extends JFrame {

    public ColorFrame() {
        // 设置窗口标题
        setTitle("使用颜色");

        // 添加框架内的组件
        JPanel p = new ColorPanel();
        add(p);

        // 自动根据组件去调节框架的大小
        pack();
    }

}
