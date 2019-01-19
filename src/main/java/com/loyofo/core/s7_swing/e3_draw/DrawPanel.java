package com.loyofo.core.s7_swing.e3_draw;

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
