package com.loyofo.core.s7_swing.e2_panelComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-19 12:18
 */
public class BackGroundPanel extends JPanel {

    // 尺寸
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;


    public BackGroundPanel() {
        setBackground(Color.RED);

        JPanel jpanel = new InfoPanel2("这是一个 Jpanel");
        jpanel.setLocation(500, 100);
        add(jpanel);

        JComponent jcomponent = new InfoComponent2("这是一个 Jcomponent");
        jcomponent.setLocation(0, 0);
        add(jcomponent);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    // @Override
    // public void paint(Graphics g) {
    //
    //     g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
    // }
}
