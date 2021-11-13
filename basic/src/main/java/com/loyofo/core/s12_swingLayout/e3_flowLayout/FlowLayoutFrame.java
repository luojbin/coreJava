package com.loyofo.core.s12_swingLayout.e3_flowLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-22 19:32
 */
public class FlowLayoutFrame extends JFrame {

    public FlowLayoutFrame() throws HeadlessException {
        JPanel cpn1 = new ColorPanel("自", Color.RED);
        JPanel cpn2 = new ColorPanel("动", Color.CYAN);
        JPanel cpn3 = new ColorPanel("排", Color.YELLOW);
        JPanel cpn4 = new ColorPanel("列", Color.GREEN);
        JPanel cpn5 = new ColorPanel("保", Color.GRAY);
        JPanel cpn6 = new ColorPanel("留", Color.MAGENTA);
        JPanel cpn7 = new ColorPanel("大", Color.BLACK);
        JPanel cpn8 = new ColorPanel("小", Color.PINK);

        // 流式布局, 从顶部开始依次排列容器中的元素, 保留元素的大小, 自动换行并居中显示, 窗口变化时自动重排
        setLayout(new FlowLayout());
        cpn1.setPreferredSize(new Dimension(200,200));
        cpn2.setPreferredSize(new Dimension(20,20));

        add(cpn1);
        add(cpn2);
        add(cpn3);

        add(cpn4);
        add(cpn5);
        add(cpn6);

        add(cpn7);
        add(cpn8);

        setSize(500,500);

    }

    private class ColorPanel extends JPanel {
        private String msg;

        public ColorPanel(String msg, Color c) {
            this.msg = msg;
            setBackground(c);
            setPreferredSize(new Dimension(100, 100));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(msg, getWidth() / 2, getHeight() / 2);
        }
    }
}
