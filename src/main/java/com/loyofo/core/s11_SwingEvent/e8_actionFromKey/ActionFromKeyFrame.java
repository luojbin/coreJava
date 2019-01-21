package com.loyofo.core.s11_SwingEvent.e8_actionFromKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class ActionFromKeyFrame extends JFrame{
    private int count = 0;
    private JPanel btnPanel;

    public ActionFromKeyFrame() {
        // 设置窗口标题
        setTitle("键盘触发动作");

        btnPanel = new JPanel();

        Action redAct = new ColorAction("红色", new ImageIcon("image/red-ball.gif"), Color.RED, "panel 的 RED action");
        Action blueAct = new ColorAction("蓝色", new ImageIcon("image/blue-ball.gif"), Color.BLUE, "panel 的 BLUE action");
        Action yellowAct = new ColorAction("黄色", new ImageIcon("image/yellow-ball.gif"), Color.YELLOW, "panel 的 YELLOW action");

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

        // 关联击键动作到 panel 的 inputMap, 即实现 具体按键 -> 某类操作(操作的名称)
        // key 是击键操作, 由键盘触发的事件
        // value 给这个击键动作一个任意类型的对象, 相当于给按键操作取一个名字, 这个对象还需要作为 actionMap 的 key
        InputMap inputMap =  btnPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(ctrlY, "null");
        inputMap.put(ctrlR, 123);
        inputMap.put(ctrlB, btnPanel);

        // 关联输入与动作, 即实现 某类操作(操作的名称) -> 具体操作过程(action对象)
        // key 是在 inputMap 中使用的 value
        // value 是具体的 action 对象
        ActionMap actionMap = btnPanel.getActionMap();
        actionMap.put("null", yellowAct);
        actionMap.put(123, redAct);
        actionMap.put(btnPanel, blueAct);

        // 通过 inputMap 和 actionMap 的两次映射, 可以实现 按键 <n--1> 操作名 <n---1> action对象,
        // 这种两次映射, 可以支持多个不同按键触发同样的操作, 并且可以在程序运行时动态修改 按键 <--> action 的关系
        // 如果使用 按键 -> action 的单次映射, 若在运行时删除了key(取消某个按键), 则对应value则会丢失(action对象失去引用), 无法重新关联
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


