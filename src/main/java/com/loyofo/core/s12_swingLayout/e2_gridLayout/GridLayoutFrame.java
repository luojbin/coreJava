package com.loyofo.core.s12_swingLayout.e2_gridLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-22 19:32
 */
public class GridLayoutFrame extends JFrame {

    public GridLayoutFrame() throws HeadlessException {
        JPanel cpn1 = new ColorPanel("完", Color.RED);
        JPanel cpn2 = new ColorPanel("全", Color.CYAN);
        JPanel cpn3 = new ColorPanel("平", Color.YELLOW);
        JPanel cpn4 = new ColorPanel("分", Color.GREEN);
        JPanel cpn5 = new ColorPanel("实", Color.GRAY);
        JPanel cpn6 = new ColorPanel("际", Color.MAGENTA);
        JPanel cpn7 = new ColorPanel("中", Color.BLACK);
        JPanel cpn8 = new ColorPanel("少", Color.PINK);
        JPanel cpn9 = new ColorPanel("用", Color.ORANGE);

        // 网格布局, 其中所有的元素都是相同的大小, 拉伸窗口时自动变化, 实际中这种布局并不常见, 往往只在单行或单列的局部使用
        setLayout(new GridLayout(3,3));
        add(cpn1);
        add(cpn2);
        add(cpn3);

        add(cpn4);
        add(cpn5);
        add(cpn6);

        add(cpn7);
        add(cpn8);
        add(cpn9);

        pack();

    }

    private class ColorPanel extends JPanel {
        private String msg;
        public ColorPanel(String msg, Color c) {
            this.msg = msg;
            setBackground(c);
            setPreferredSize(new Dimension(100,100));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(msg, getWidth()/2, getHeight()/2);
        }
    }
}
