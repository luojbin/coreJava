package com.loyofo.core.s11_SwingEvent.e5_itself;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class ItselfPanel extends JPanel implements ActionListener {

    private JButton yellowBtn;
    private JButton redBtn;
    private JButton blueBtn;

    public ItselfPanel() {
        //创建按钮，并且将按钮添加到内容面板中
        yellowBtn = new JButton("黄色");
        redBtn = new JButton("红色");
        blueBtn = new JButton("蓝色");

        // 让受变化的对象自己成为监听器
        yellowBtn.addActionListener(this);
        redBtn.addActionListener(this);
        blueBtn.addActionListener(this);

        // 将按钮添加到按钮面板上
        add(yellowBtn);
        add(redBtn);
        add(blueBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == yellowBtn) {
            setBackground(Color.YELLOW);
        } else if (source == redBtn) {
            setBackground(Color.RED);
        } else if(source == blueBtn) {
            setBackground(Color.BLUE);
        }
    }
}
