package com.loyofo.core.s11_SwingEvent.e10_mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class MouseFrame extends JFrame{


    public MouseFrame() {
        // 设置窗口标题
        setTitle("键盘触发动作");
        add(new MouseComponent());
        pack();
    }

}


