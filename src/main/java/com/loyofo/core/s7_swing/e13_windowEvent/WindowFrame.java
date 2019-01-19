package com.loyofo.core.s7_swing.e13_windowEvent;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class WindowFrame extends JFrame{
    private int count = 0;

    public WindowFrame() {
        // 设置窗口标题
        setTitle("窗口事件");

        // 设置大小
        setSize(100, 100);

        // 添加窗口事件监听器, 第三次才关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                count++;
                System.out.println("点击关闭:" + count);
                if (count >= 3) {
                    System.exit(0);
                }
            }
        });

        // 为了配合窗口监听器, 要求点击关闭时先不关闭, 这里需要设置为不做任何操作
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }


}


