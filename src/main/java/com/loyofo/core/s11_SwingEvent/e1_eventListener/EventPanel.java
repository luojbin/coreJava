package com.loyofo.core.s11_SwingEvent.e1_eventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-16 10:02
 */
public class EventPanel extends JPanel {

    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;

    public EventPanel() {
        // 添加按钮
        JButton yellowBtn = new JButton("黄色");
        JButton redBtn = new JButton("红色");
        JButton blueBtn = new JButton("蓝色");

        // 创建监听器
        // 因为监听器不是面板的内部类, 所以需要在创建监听器对象时, 将监听器要操作的面板传入, 由监听器对象自己管理对按钮面板的引用
        ActionListener yellowAct = new EventListener(this, Color.YELLOW);
        ActionListener redAct = new EventListener(this, Color.RED);
        ActionListener blueAct = new EventListener(this, Color.BLUE);

        // 为按钮添加监听器
        yellowBtn.addActionListener(yellowAct);
        redBtn.addActionListener(redAct);
        blueBtn.addActionListener(blueAct);

        // 将按钮添加到按钮面板
        add(yellowBtn);
        add(redBtn);
        add(blueBtn);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

}
