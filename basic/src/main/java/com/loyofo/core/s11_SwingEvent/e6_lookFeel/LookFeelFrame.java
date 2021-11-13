package com.loyofo.core.s11_SwingEvent.e6_lookFeel;

import javax.swing.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class LookFeelFrame extends JFrame{
    private JPanel btnPanel;

    public LookFeelFrame() {
        // 设置窗口标题
        setTitle("切换观感");
        // 添加到面板
        btnPanel = new JPanel();

        // 获取所有可用观感
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }

        add(btnPanel);
        pack();
    }

    void makeButton(String name, final String plafName) {
        // 添加按钮
        JButton button = new JButton(name);
        btnPanel.add(button);

        button.addActionListener(event -> {
                try {
                    // 设置要用的观感
                    UIManager.setLookAndFeel(plafName);
                    // 更新目标对象的观感, lambda中, "this"就是外围对象, 不需要像匿名内部类使用 "外围类.this"
                    SwingUtilities.updateComponentTreeUI(this);
                    pack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );
    }
}
