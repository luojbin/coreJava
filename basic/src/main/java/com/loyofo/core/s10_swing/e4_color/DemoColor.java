package com.loyofo.core.s10_swing.e4_color;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-12 10:04
 */
public class DemoColor {

    public static void main(String[] args) {
        // 建议将图形程序放在 EveneQueue 中, 这样可以在完成一系列的初始化工作之后再显示图形窗口
        // 如果直接在主线程中初始化, 在复杂的图形程序时可能会出现问题.
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 创建图形框架
                JFrame frame = new ColorFrame();
                // 设置关闭程序的时机
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 框架默认不可见, 在完成初始化添加完组件, 需要设置可见性
                frame.setVisible(true);
            }
        });
    }

}

