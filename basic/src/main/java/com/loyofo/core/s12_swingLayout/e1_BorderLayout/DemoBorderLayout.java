package com.loyofo.core.s12_swingLayout.e1_BorderLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-12 10:04
 */
public class DemoBorderLayout {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BorderLayoutFrame(); // 创建窗口对象
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); // 是否可见
            }
        });
    }

}

