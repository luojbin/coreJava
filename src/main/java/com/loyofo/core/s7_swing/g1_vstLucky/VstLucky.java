package com.loyofo.core.s7_swing.g1_vstLucky;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-18 14:01
 */
public class VstLucky {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 创建图形框架
                JFrame frame = new JFrame();
                // 创建主面板
                LuckyPanel mainPanel = new LuckyPanel();
                // 添加候选人框

                // 添加按钮面板到主面板
                frame.add(new BtnPanel(mainPanel));

                frame.add(mainPanel);
                frame.pack();
                // 设置关闭程序的时机
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 框架默认不可见, 在完成初始化添加完组件, 需要设置可见性
                frame.setVisible(true);
            }
        });
    }
}
