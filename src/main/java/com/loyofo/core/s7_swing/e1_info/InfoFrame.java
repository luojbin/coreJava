package com.loyofo.core.s7_swing.e1_info;

import javax.swing.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class InfoFrame extends JFrame {

    public InfoFrame() {
        // 设置窗口标题
        setTitle("添加组件");

        // 添加框架内的组件
        JPanel c2 = new InfoPanel("这是一个 Jpanel");
        c2.setLocation(100, 100);
        add(c2);
        JComponent c1 = new InfoComponent("这是一个 Jcomponent");
        c1.setLocation(0, 0);
        add(c1);


        // 自动根据组件去调节框架的大小
        pack();
    }

}
