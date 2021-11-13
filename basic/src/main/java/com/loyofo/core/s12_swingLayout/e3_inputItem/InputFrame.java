package com.loyofo.core.s12_swingLayout.e3_inputItem;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-22 19:32
 */
public class InputFrame extends JFrame {

    JPanel borderPanel;
    ButtonGroup borderBtnGroup;

    public InputFrame() throws HeadlessException {
        setLayout(new GridLayout(6,1));
        setTitle("输入控件");
        setSize(400,500);

        // 文本框
        // 普通文本框
        JTextField textField = new JTextField("预设文字", 10);
        // 密码文本框
        JPasswordField passwordField = new JPasswordField("123456", 10);
        // 可以修改回显字符, 将用指定字符替换输入的内容
        passwordField.setEchoChar('*');

        // 标签
        JPanel labelPanel = new JPanel();
        JLabel nameLabel = new JLabel("用户名:    ", SwingConstants.RIGHT);
        JLabel pwdLabel = new JLabel("密码:    ", SwingConstants.RIGHT);
        // 将标签与文本框按顺序添加到面板上
        labelPanel.setLayout(new GridLayout(2,2));
        labelPanel.add(nameLabel);
        labelPanel.add(textField);
        labelPanel.add(pwdLabel);
        labelPanel.add(passwordField);
        add(labelPanel);

        // 多行文本区
        JPanel textAreaPanel = new JPanel();
        JTextArea textArea = new JTextArea("预设文本 1\n预设文本 2\n预设文本 3\n预设文本 3\n预设文本 3\n预设文本 3",5, 15);
        textAreaPanel.add(textArea);
        add(textAreaPanel);

        // 多行文本区默认不能滚动, 如果超出范围, 则无法显示完整
        // 可以将多行文本区添加到 JScrollPane 中, 在需要时可以自动添加滚动条
        // 使用滚动窗格管理多行文本区后, 则多行文本区的大小取 文本区/滚动窗格 两者的较大值
        JPanel textAreaPanel2 = new JPanel();
        JTextArea textArea2 = new JTextArea("预设文本 1\n预设文本 2\n预设文本 3\n预设文本 3\n预设文本 3\n预设文本 3", 4, 15);
        JScrollPane scrollPane = new JScrollPane(textArea2);
        scrollPane.setSize(new Dimension(250,30));
        textAreaPanel2.add(scrollPane);
        add(textAreaPanel2);

        //region 多选框
        JPanel checkBoxPanel = new JPanel();
        JCheckBox bold = new JCheckBox("加粗");
        JCheckBox italic = new JCheckBox("倾斜");
        JCheckBox delete = new JCheckBox("删除");
        JCheckBox underLine = new JCheckBox("下划线");
        checkBoxPanel.add(bold);
        checkBoxPanel.add(italic);
        checkBoxPanel.add(delete);
        checkBoxPanel.add(underLine);
        add(checkBoxPanel);
        //endregion

        //region 单选框组实例
        ButtonGroup group = new ButtonGroup();
        JRadioButton btn1 = new JRadioButton("单");
        JRadioButton btn2 = new JRadioButton("选");
        JRadioButton btn3 = new JRadioButton("按");
        JRadioButton btn4 = new JRadioButton("钮");
        JRadioButton btn5 = new JRadioButton("组");

        group.add(btn1);
        group.add(btn2);
        group.add(btn3);
        group.add(btn4);
        group.add(btn5);

        JPanel radioGroupPanel = new JPanel();
        // 将单选框加入了按钮组, 但按钮组不是 swing 容器, 不能直接将一个按钮组添加到 JPanel 中
        // radioGroupPanel.add(group) // 编译错误
        // 需要将每一个单选按钮分别添加
        radioGroupPanel.add(btn1);
        radioGroupPanel.add(btn2);
        radioGroupPanel.add(btn3);
        radioGroupPanel.add(btn4);
        radioGroupPanel.add(btn5);
        add(radioGroupPanel);
        //endregion

        // 边框
        borderPanel = new JPanel();
        borderBtnGroup = new ButtonGroup();
        addRadioButton("低斜角边框", BorderFactory.createLoweredBevelBorder());
        addRadioButton("凸斜角边框", BorderFactory.createRaisedBevelBorder());
        addRadioButton("蚀刻边框", BorderFactory.createEtchedBorder());
        addRadioButton("线条边框", BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("填充边框", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
        addRadioButton("空白边框", BorderFactory.createEmptyBorder());
        Border titleBorder = BorderFactory.createTitledBorder( BorderFactory.createBevelBorder(BevelBorder.LOWERED), "标题边框");
        addRadioButton("标题边框", titleBorder);
        add(borderPanel);
    }

    public void addRadioButton(String buttonName, final Border b) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                borderPanel.setBorder(b);
            }
        });
        borderBtnGroup.add(button);
        borderPanel.add(button);
    }
}
