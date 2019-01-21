package com.loyofo.core.s11_SwingEvent.e8_action;

import sun.util.resources.en.CurrencyNames_en_MT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class ActionFrame extends JFrame{
    private int count = 0;
    private JPanel btnPanel;

    public ActionFrame() {
        // 设置窗口标题
        setTitle("动作事件");

        btnPanel = new JPanel();

        Action redAct = new ColorAction("红色", new ImageIcon("image/red-ball.gif"), Color.RED);
        Action blueAct = new ColorAction("蓝色", new ImageIcon("image/blue-ball.gif"), Color.BLUE);
        Action yellowAct = new ColorAction("黄色", new ImageIcon("image/yellow-ball.gif"), Color.YELLOW);

        // Jbutton 有一个以 Action 对象为参数的构造方法, 可以根据 Action 对象的属性自动添加按钮标题图标等, 并自动设置监听器
        JButton redBtn = new JButton(redAct);
        JButton blueBtn = new JButton(blueAct);
        JButton yellowBtn = new JButton(yellowAct);

        btnPanel.add(redBtn);
        btnPanel.add(blueBtn);
        btnPanel.add(yellowBtn);

        add(btnPanel);
        setSize(100,200);
    }

    // AbstractAction 实现了 Action 接口, 通常只需要重写 actionPerformed 方法即可
    class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "修改颜色为:" + name);
            putValue("color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            btnPanel.setBackground(c);
        }
    }

}


