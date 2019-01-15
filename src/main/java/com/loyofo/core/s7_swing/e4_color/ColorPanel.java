package com.loyofo.core.s7_swing.e4_color;

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
public class ColorPanel extends JPanel {
    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // 通过 setColor/setColor 指定后续绘图需要的颜色, 需要需要使用多种颜色, 就重复 颜色-绘制-颜色-绘制
        // 后绘制的在上层, 覆盖先绘制的

        // 可以使用 Color 中定义的颜色
        g2.setPaint(Color.CYAN);
        double x1 = 100;
        double y1 = 100;
        double width = 200;
        double height = 150;
        Rectangle2D rect = new Rectangle2D.Double(x1, y1, width, height);
        g2.draw(rect);

        // 可以使用自定义的颜色, 通过 RGB 三色调配
        g2.setColor(new Color(98, 199, 111));
        g2.draw(new Line2D.Double(x1, y1, x1 + width, y1 + height));
        g2.draw(new Line2D.Double(x1, y1 + height, x1 + width, y1));

        // 可以使用 SystemColor 的颜色, 可以获取当前系统主题颜色
        g2.setColor(SystemColor.activeCaption);
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);

        // 填充, 使用 fill 替代 draw
        g2.fill(ellipse);

        g2.setColor(Color.GREEN);
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
