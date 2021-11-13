package com.loyofo.core.s11_SwingEvent.e1_eventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class EventListener implements ActionListener {

    private Color color;
    private JPanel btnPanel;

    public EventListener(JPanel panel, Color color) {
        this.btnPanel = panel;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnPanel.setBackground(color);
    }
}
