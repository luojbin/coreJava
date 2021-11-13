package com.loyofo.core.s11_SwingEvent.e2_innerListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class InnerFrame extends JFrame {

    private JPanel innerPanel;
    private static final int HEIGHT = 300;
    private static final int WIDTH = 300;

    public InnerFrame() {
        // 设置窗口标题
        setTitle("显示图像");
        // 设置大小
        setSize(WIDTH, HEIGHT);

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
        JPanel btnPanel = new JPanel();
        btnPanel.add(yellowBtn);
        btnPanel.add(redBtn);
        btnPanel.add(blueBtn);

        // 用框架的实例域保存按钮面板的引用, 以便监听器对按钮面板进行操作
        innerPanel = btnPanel;

        // 将按钮面板添加到框架上
        add(btnPanel);
    }


    class ColorAction implements ActionListener{

        private Color color;

        public ColorAction(Color color) {
            this.color = color;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // 监听器作为框架的内部类, 可以访问框架的实例域
            innerPanel.setBackground(color);
        }
    }
}
