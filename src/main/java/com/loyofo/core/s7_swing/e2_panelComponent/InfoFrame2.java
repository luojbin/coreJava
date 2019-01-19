package com.loyofo.core.s7_swing.e2_panelComponent;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class InfoFrame2 extends JFrame {

    public InfoFrame2() {
        // 设置窗口标题
        setTitle("添加组件");

        // 添加框架内的组件
        JPanel backGroundPanel = new BackGroundPanel();
        add(backGroundPanel);

        // 自动根据组件去调节框架的大小
        pack();
    }

}
