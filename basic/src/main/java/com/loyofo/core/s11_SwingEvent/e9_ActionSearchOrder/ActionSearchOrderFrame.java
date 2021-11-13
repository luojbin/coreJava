package com.loyofo.core.s11_SwingEvent.e9_ActionSearchOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class ActionSearchOrderFrame extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    public ActionSearchOrderFrame() {
        // 设置窗口标题
        setTitle("键盘动作的搜索次序");

        // 创建两个不同的panel, 放置按钮以获取焦点
        panel1 = new JPanel();
        panel1.setSize(300, 38);
        add(panel1, BorderLayout.NORTH);

        panel2 = new JPanel();
        panel2.setSize(300, 38);
        add(panel2, BorderLayout.SOUTH);

        // 创建一个色块panel, 用以体现动作的触发
        panel3 = new JPanel();
        panel3.setSize(300, 50);
        panel3.setPreferredSize(new Dimension(300,50));
        add(panel3);

        // 按钮本身获取了焦点时触发的事件
        Action redBtnAct = new ColorAction("红色", new ImageIcon("image/red-ball.gif"), Color.RED, "焦点在红按钮");
        Action blueBtnAct = new ColorAction("蓝色", new ImageIcon("image/blue-ball.gif"), Color.BLUE, "焦点在蓝按钮");
        Action yellowBtnAct = new ColorAction("黄色", new ImageIcon("image/yellow-ball.gif"), Color.YELLOW, "焦点在黄按钮");

        // 按钮所在面板获取了焦点时触发事件
        Action redAct = new ColorAction("红色", new ImageIcon("image/red-ball.gif"), Color.RED, "焦点在顶部, 但不在红按钮");
        Action blueAct = new ColorAction("蓝色", new ImageIcon("image/blue-ball.gif"), Color.BLUE, "焦点在顶部, 但不在蓝按钮");
        Action yellowAct = new ColorAction("黄色", new ImageIcon("image/yellow-ball.gif"), Color.YELLOW, "焦点在顶部, 但不在黄按钮");

        // 同窗口的其他面板获取了焦点
        Action redOtherAct = new ColorAction("红色", new ImageIcon("image/red-ball.gif"), Color.RED, "焦点在底部, 红色");
        Action blueOtherAct = new ColorAction("蓝色", new ImageIcon("image/blue-ball.gif"), Color.BLUE, "焦点在底部, 蓝色");
        Action yellowOtherAct = new ColorAction("黄色", new ImageIcon("image/yellow-ball.gif"), Color.YELLOW, "焦点在底部, 黄色");

        // 创建顶部 panel 的按钮
        JButton redBtn = new JButton(redBtnAct);
        JButton blueBtn = new JButton(blueBtnAct);
        JButton yellowBtn = new JButton(yellowBtnAct);
        panel1.add(redBtn);
        panel1.add(blueBtn);
        panel1.add(yellowBtn);

        JButton otherBtn = new JButton("只为获取焦点");
        panel2.add(otherBtn);

        // 获取击键对象
        KeyStroke ctrlY = KeyStroke.getKeyStroke("ctrl Y");
        KeyStroke ctrlB = KeyStroke.getKeyStroke("ctrl B");
        KeyStroke ctrlR = KeyStroke.getKeyStroke("ctrl R");

        // 为获取焦点的按钮, 添加 when_focused 的 inputMap 和 action
        InputMap yFoucesInputMap = yellowBtn.getInputMap(JComponent.WHEN_FOCUSED);
        InputMap rFoucesInputMap = redBtn.getInputMap(JComponent.WHEN_FOCUSED);
        InputMap bFoucesInputMap = blueBtn.getInputMap(JComponent.WHEN_FOCUSED);

        ActionMap yFoucesActionMap = yellowBtn.getActionMap();
        ActionMap rFoucesActionMap = redBtn.getActionMap();
        ActionMap bFoucesActionMap = blueBtn.getActionMap();

        yFoucesInputMap.put(ctrlY, "btnY");
        rFoucesInputMap.put(ctrlR, "btnR");
        bFoucesInputMap.put(ctrlB, "btnB");

        yFoucesActionMap.put("btnY", yellowBtnAct);
        rFoucesActionMap.put("btnR", redBtnAct);
        bFoucesActionMap.put("btnB", blueBtnAct);

        // 为顶部panel, 添加下级按钮获取焦点时的 inputMap 和 actionMap
        InputMap panelInputMap =  panel1.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap panelActionMap = panel1.getActionMap();

        panelInputMap.put(ctrlY, "panelNotY");
        panelInputMap.put(ctrlR, "panelNotR");
        panelInputMap.put(ctrlB, "panelNotB");

        panelActionMap.put("panelNotY", yellowAct);
        panelActionMap.put("panelNotR", redAct);
        panelActionMap.put("panelNotB", blueAct);

        // 为顶部panel, 添加焦点在其他面板时的 inputMap 和 actionMap
        InputMap otherInputMap = panel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap otherActionMap = panel1.getActionMap();
        otherInputMap.put(ctrlY, "otherY");
        otherInputMap.put(ctrlR, "otherR");
        otherInputMap.put(ctrlB, "otherB");

        otherActionMap.put("otherY", yellowOtherAct);
        otherActionMap.put("otherR", redOtherAct);
        otherActionMap.put("otherB", blueOtherAct);

        pack();
    }

    // AbstractAction 实现了 Action 接口, 通常只需要重写 actionPerformed 方法即可
    class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color color, String msg) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "修改颜色为:" + name);
            putValue("color", color);
            putValue("msg", msg);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(getValue("msg"));
            Color c = (Color) getValue("color");
            panel3.setBackground(c);
        }
    }

}


