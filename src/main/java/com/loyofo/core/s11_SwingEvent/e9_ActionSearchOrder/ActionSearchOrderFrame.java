package com.loyofo.core.s11_SwingEvent.e9_ActionSearchOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class ActionSearchOrderFrame extends JFrame{
    private int count = 0;
    private JPanel btnPanel;

    public ActionSearchOrderFrame() {
        // 设置窗口标题
        setTitle("键盘动作的搜索次序");

        btnPanel = new JPanel();

        Action redAct = new ColorAction("红色", new ImageIcon("image/red-ball.gif"), Color.RED, "panel 的 RED action");
        Action blueAct = new ColorAction("蓝色", new ImageIcon("image/blue-ball.gif"), Color.BLUE, "panel 的 BLUE action");
        Action yellowAct = new ColorAction("黄色", new ImageIcon("image/yellow-ball.gif"), Color.YELLOW, "panel 的 YELLOW action");

        Action redBtnAct = new ColorAction("红色", new ImageIcon("image/red-ball.gif"), Color.RED, "当前焦点在红按钮");
        Action blueBtnAct = new ColorAction("蓝色", new ImageIcon("image/blue-ball.gif"), Color.BLUE, "当前焦点在蓝按钮");
        Action yellowBtnAct = new ColorAction("黄色", new ImageIcon("image/yellow-ball.gif"), Color.YELLOW, "当前焦点在黄按钮");

        // Jbutton 有一个以 Action 对象为参数的构造方法, 可以根据 Action 对象的属性自动添加按钮标题图标等, 并自动设置监听器
        JButton redBtn = new JButton(redAct);
        JButton blueBtn = new JButton(blueAct);
        JButton yellowBtn = new JButton(yellowAct);

        btnPanel.add(redBtn);
        btnPanel.add(blueBtn);
        btnPanel.add(yellowBtn);

        add(btnPanel);

        // 获取击键对象
        KeyStroke ctrlY = KeyStroke.getKeyStroke("ctrl Y");
        KeyStroke ctrlB = KeyStroke.getKeyStroke("ctrl B");
        KeyStroke ctrlR = KeyStroke.getKeyStroke("ctrl R");

        // swing 会先在获取焦点的组件中, 搜索其 WHEN_FOCUSED 的 inputMap, 如果有对应的按钮并执行, 就不在其他组件中查找
        // 关联动作到 yellowBtn 的 inputMap
        InputMap yellowBtnInputMap = yellowBtn.getInputMap(JComponent.WHEN_FOCUSED);
        yellowBtnInputMap.put(ctrlY, "btnY");
        ActionMap yellowBtnActionMap = yellowBtn.getActionMap();
        yellowBtnActionMap.put("btnY", yellowBtnAct);

        // 关联动作到 yellowBtn 的 inputMap
        InputMap btnRInputMap = redBtn.getInputMap(JComponent.WHEN_FOCUSED);
        btnRInputMap.put(ctrlR, "btnR");
        ActionMap btnRActionMap = redBtn.getActionMap();
        btnRActionMap.put("btnR", redBtnAct);

        // 关联动作到 yellowBtn 的 inputMap
        InputMap btnBInputMap = blueBtn.getInputMap(JComponent.WHEN_FOCUSED);
        btnBInputMap.put(ctrlB, "btnB");
        ActionMap btnBActionMap = blueBtn.getActionMap();
        btnBActionMap.put("btnB", blueBtnAct);

        // 如果在焦点组件的 inputMap 中没有找到对应的按钮事件, 就会搜索焦点组件的父级组件的 WHEN_ANCESTOR_OF_FOCUSED_COMPONENT 的 inputMap
        // 关联击键动作到 panel 的 inputMap
        InputMap inputMap =  btnPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(ctrlY, "null");
        inputMap.put(ctrlR, 123);
        inputMap.put(ctrlB, btnPanel);

        // 关联输入与动作
        ActionMap actionMap = btnPanel.getActionMap();
        actionMap.put("null", yellowAct);
        actionMap.put(123, redAct);
        actionMap.put(btnPanel, blueAct);

        setSize(100,200);
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
            btnPanel.setBackground(c);
        }
    }

}


