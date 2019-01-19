package com.loyofo.core.s7_swing.e5_font;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

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
        Font font = new Font("YaHei Monaco Hybird", Font.PLAIN, 20);
        g.setFont(font);

        // 获取字符串大小
        Graphics2D g2 = (Graphics2D) g;
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(text, context);
        double strWidth = bounds.getWidth();
        double setHeight = bounds.getHeight();
        double ascent = -bounds.getY();
        System.out.println(ascent);

        int strX = (int) ((WIDTH - strWidth) / 2);
        int strY = (int) ((HEIGHT - setHeight) / 2 + ascent);
        // 这里的Y是基线的位置, 不是字符所在矩形的上边框
        g.drawString(text, strX, strY);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
