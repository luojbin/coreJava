package com.loyofo.core.s10_swing.e3_draw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-15 18:46
 */
public class DrawPanel extends JPanel {
    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // 长方形
        double x1 = 100;
        double y1 = 100;
        double width = 200;
        double height = 150;
        Rectangle2D rect = new Rectangle2D.Double(x1, y1, width, height);
        g2.draw(rect);


        double px=100, py=100, qx=10, qy=10;
        // 这种方式创建, 若 p 不是左上角顶点, 则矩形不存在
        Rectangle2D rect2 = new Rectangle2D.Double(px,py, qx-px, qy-py);
        g2.draw(rect2);

        // 在不确定是否左上角时, 可以根据两对角点构造对象
        Rectangle2D rect3 = new Rectangle2D.Double();
        rect3.setFrameFromDiagonal(px, py, qx, qy);
        g2.draw(rect3);

        // 线段
        g2.draw(new Line2D.Double(x1,y1, x1+width, y1+height));
        g2.draw(new Line2D.Double(x1, y1+height, x1+width, y1));

        // 椭圆, 根据外接矩形来确定
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        // 圆
        double x2 = rect.getCenterX();
        double y2 = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(x2,y2,x2+radius, y2+radius);
        g2.draw(circle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
