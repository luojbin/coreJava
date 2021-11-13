package com.loyofo.core.s11_SwingEvent.e10_mouse;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-12 10:04
 */
public class DemoMouse {

    public static void main(String[] args) {
        // 建议将图形程序放在 EveneQueue 中, 这样可以在完成一系列的初始化工作之后再显示图形窗口
        // 如果直接在主线程中初始化, 在复杂的图形程序时可能会出现问题.
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MouseFrame(); // 创建窗口对象
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); // 是否可见
            }
        });
    }

}

