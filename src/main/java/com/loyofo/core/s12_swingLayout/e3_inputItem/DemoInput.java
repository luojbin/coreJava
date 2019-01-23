package com.loyofo.core.s12_swingLayout.e3_inputItem;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-12 10:04
 */
public class DemoInput {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new InputFrame(); // 创建窗口对象
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); // 是否可见
            }
        });
    }

}

