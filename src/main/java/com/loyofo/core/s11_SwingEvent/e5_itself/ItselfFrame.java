package com.loyofo.core.s11_SwingEvent.e5_itself;

import javax.swing.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class ItselfFrame extends JFrame{


    public ItselfFrame() {
        // 设置窗口标题
        setTitle("框架自身充当监听器");
        // 设置大小
        setSize(400, 400);
        // 添加到面板
        JPanel btnPanel = new ItselfPanel();
        add(btnPanel);
    }
}
