package com.loyofo.core.s11_SwingEvent.e10_mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class MouseComponent extends JComponent {
    // 画板的大小
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    // 正方形边长
    private static final int SIDELENGTH = 10;

    // 正方形列表, 由于需要经常增删对象, List 比数组方便
    private List<Rectangle2D> squares;
    // 记录当前鼠标选中的正方形
    private Rectangle2D current;

    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;

        // 添加鼠标事件处理器, 处理鼠标按钮事件
        addMouseListener(new MouseHandler());
        // 添加鼠标移动事件处理器, 处理鼠标移动与拖拽事件
        addMouseMotionListener(new MouseMotionHandler());
    }

    // 经常需要重绘, 需要复写 paintComponent 方法
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // 画出所有正方形
        for (Rectangle2D r : squares) {
            g2.draw(r);
        }
    }

    // 给定坐标, 查找是否落在已有正方形中
    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares) {
            if (r.contains(p)) return r;
        }
        return null;
    }

    // 给定一个位置, 添加一个正方形
    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    // 删除指定的正方形
    public void remove(Rectangle2D s) {
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }

    // 鼠标事件处理器, 处理鼠标按键的事件, 不区分鼠标按键, 都触发相同事件
    // 若不同按键触发不同事件, 需要在方法内判断按键来源
    private class MouseHandler extends MouseAdapter {
        // 鼠标按下
        public void mousePressed(MouseEvent event) {
            // int button = event.getButton();
            // String btnName = button == 1? "左键" : button == 2 ? "中键" : "右键";
            // System.out.println(btnName + "按下!");
            System.out.println("左按键码:" + Integer.toBinaryString(InputEvent.BUTTON1_DOWN_MASK));
            System.out.println("中按键码:" + Integer.toBinaryString(InputEvent.BUTTON2_DOWN_MASK));
            System.out.println("右按键码:" + Integer.toBinaryString(InputEvent.BUTTON3_DOWN_MASK));
            System.out.println("ALT\t\t按键码:" + Integer.toBinaryString(InputEvent.ALT_DOWN_MASK));
            System.out.println("CTRL\t按键码:" + Integer.toBinaryString(InputEvent.CTRL_DOWN_MASK));
            System.out.println("SHIFT\t按键码:" + Integer.toBinaryString(InputEvent.SHIFT_DOWN_MASK));

            // 通过掩码的位运算, 来判断某个键是否按下, 从而可以判断是否有 ctrl/shift/alt 等功能键被按下
            if ((event.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK) != 0) {
                System.out.println("鼠标右键");
            } else if ((event.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) != 0) {
                System.out.println("鼠标左键");
            } else if ((event.getModifiersEx() & InputEvent.BUTTON2_DOWN_MASK) != 0) {
                System.out.println("鼠标中键");
            }

            System.out.println("实际按键码: " + event.getModifiersEx());
            // 查找当前位置的正方形
            current = find(event.getPoint());
            // 若当前位置没有正方形, 就添加一个
            if (current == null) {
                add(event.getPoint());
            }
        }

        // 每次点击都会触发, 并且会统计一定时间内的击键次数
        public void mouseClicked(MouseEvent event) {
            System.out.println("点击! 次数为:" + event.getClickCount());
            // 点击时选中正方形
            current = find(event.getPoint());
            // 双击移除正方形
            if (current != null && event.getClickCount() >= 2) remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        public void mouseMoved(MouseEvent event) {
            // System.out.println("移动事件!");
            // 当前鼠标位置能否找到正方形
            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            // 找到了更改鼠标样式
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseDragged(MouseEvent event) {
            if (current != null) {
                int x = event.getX();
                int y = event.getY();

                // 修改当前正方形到新位置
                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


}
