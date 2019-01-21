package com.loyofo.core.s11_SwingEvent.e1_eventListener;

import javax.swing.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class EventFrame extends JFrame {

    public EventFrame() {
        // 设置窗口标题
        setTitle("显示图像");

        // 将按钮添加到按钮面板
        JPanel btnPanel = new EventPanel();
        add(btnPanel);

        // 自动根据组件去调节框架的大小
        pack();
    }

}
