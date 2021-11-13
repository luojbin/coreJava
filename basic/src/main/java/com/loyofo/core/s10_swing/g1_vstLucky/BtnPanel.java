package com.loyofo.core.s10_swing.g1_vstLucky;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-18 16:12
 */
public class BtnPanel extends JPanel {

    public BtnPanel(LuckyPanel panel) {
        // 按钮面板
        setSize(200, 35);
        setLocation(860, 900);

        //创建按钮，并且将按钮添加到内容面板中
        JButton startBtn = new JButton("开始");
        JButton stopBtn = new JButton("停止");
        JButton resetBtn = new JButton("重置");

        startBtn.addActionListener(panel.new StartActListener());
        stopBtn.addActionListener(panel.new StopActionListener());
        resetBtn.addActionListener(panel.new ResetActionListener());

        // 添加按钮到面板上
        add(startBtn);
        add(stopBtn);
        add(resetBtn);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
