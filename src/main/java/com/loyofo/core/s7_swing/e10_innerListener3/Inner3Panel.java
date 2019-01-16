package com.loyofo.core.s7_swing.e10_innerListener3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-16 10:31
 */
public class Inner3Panel extends JPanel {
    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;

    public Inner3Panel() {
        // 添加按钮
        JButton yellowBtn = makeButton("黄色", Color.YELLOW);
        JButton redBtn = makeButton("红色", Color.RED);
        JButton blueBtn = makeButton("蓝色", Color.BLUE);

        // 将按钮添加到按钮面板
        add(yellowBtn);
        add(redBtn);
        add(blueBtn);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public JButton makeButton(String label, Color color) {
        JButton btn = new JButton(label);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inner3Panel.this.setBackground(color);
            }
        });
        return btn;
    }

}
