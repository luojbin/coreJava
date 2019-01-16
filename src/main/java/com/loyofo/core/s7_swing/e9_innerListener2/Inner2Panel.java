package com.loyofo.core.s7_swing.e9_innerListener2;

import com.loyofo.core.s7_swing.e7_eventListener.EventPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-16 10:31
 */
public class Inner2Panel extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    public Inner2Panel() {
        // 添加按钮
        JButton yellowBtn = new JButton("黄色");
        JButton redBtn = new JButton("红色");
        JButton blueBtn = new JButton("蓝色");

        // 创建监听器
        ColorAction yellowAct = new ColorAction(Color.YELLOW);
        ColorAction redAct = new ColorAction(Color.RED);
        ColorAction blueAct = new ColorAction(Color.BLUE);

        // 为按钮添加监听器
        yellowBtn.addActionListener(yellowAct);
        redBtn.addActionListener(redAct);
        blueBtn.addActionListener(blueAct);

        // 将按钮添加到按钮面板
        add(yellowBtn);
        add(redBtn);
        add(blueBtn);
    }

    class ColorAction implements ActionListener {

        private Color color;

        public ColorAction(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // 监听器作为框架的内部类, 可以访问框架的实例域
            Inner2Panel.this.setBackground(color);
        }
    }
}
