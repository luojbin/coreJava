package com.loyofo.core.s12_swingLayout.e1_BorderLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-22 19:32
 */
public class BorderLayoutFrame extends JFrame {

    public BorderLayoutFrame() throws HeadlessException {
        JPanel panel1 = new InfoPanel("顶部", 200, 50);
        JPanel panel2 = new InfoPanel("左侧栏", 50, 100);
        JPanel panel3 = new InfoPanel("中部", 100, 100);
        JPanel panel4 = new InfoPanel("右侧栏", 50, 100);
        JPanel panel5 = new InfoPanel("底部", 200, 50);

        panel1.setBackground(Color.PINK);
        panel2.setBackground(Color.GRAY);
        panel3.setBackground(Color.GREEN);
        panel4.setBackground(Color.MAGENTA);
        panel5.setBackground(Color.YELLOW);

        // BorderLayout 是 JFrame 默认的布局管理器, 分成上下左右中五块, 会将添加到 jFrame 的元素拉伸填满所在区域
        // 如果不指定区域, 则放置在中部
        // 窗口大小变化时, 上下左右的宽度不变, 中间区域被拉伸
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.WEST);
        add(panel3, BorderLayout.CENTER);
        add(panel4, BorderLayout.EAST);
        add(panel5, BorderLayout.SOUTH);

        pack();

    }

    class InfoPanel extends JPanel {
        private String msg;
        public InfoPanel(String msg, int width, int height) {
            this.msg = msg;
            setPreferredSize(new Dimension(width, height));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(msg, 1*getWidth()/5, getHeight()/2);
        }
    }
}
