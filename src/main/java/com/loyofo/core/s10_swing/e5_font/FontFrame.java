package com.loyofo.core.s10_swing.e5_font;

import javax.swing.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class FontFrame extends JFrame {

    public FontFrame() {
        // 设置窗口标题
        setTitle("字体测试");

        // 添加框架内的组件
        JComponent c1 = new FontComponent("class");
        add(c1);


        // 自动根据组件去调节框架的大小
        pack();
    }

}
