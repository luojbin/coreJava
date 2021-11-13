package com.loyofo.core.s10_swing.e6_image;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class ImageComponent extends JComponent {

    private static final int HEIGHT = 300;
    private static final int WIDTH = 300;

    private Image image;


    public ImageComponent() {
        this.image = new ImageIcon("image/icon.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (image == null) {
            return;
        }

        int imgWidth = image.getWidth(this);
        int imgHeight = image.getHeight(this);

        g.drawImage(image, 0, 0, null);

        // 图片平铺
        for (int i = 0; i*imgWidth <= getWidth(); i++) {
            for (int j = 0; j* imgHeight <= getHeight(); j++) {
                if (i + j > 0) {
                    g.copyArea(0,0, imgWidth, imgHeight, i*imgWidth, j*imgHeight);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}
