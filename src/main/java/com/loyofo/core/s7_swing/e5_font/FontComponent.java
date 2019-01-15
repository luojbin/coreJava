package com.loyofo.core.s7_swing.e5_font;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class FontComponent extends JComponent {

    private static final int HEIGHT = 100;
    private static final int WIDTH = 300;

    private String text;


    public FontComponent(String text) {
        this.text = text;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setFont(new Font("YaHei Monaco Hybird", Font.PLAIN,20));
        g.drawString(text, 50, 50);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
