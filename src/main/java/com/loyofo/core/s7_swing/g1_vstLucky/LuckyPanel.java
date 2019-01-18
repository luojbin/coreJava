package com.loyofo.core.s7_swing.g1_vstLucky;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-18 14:02
 */
public class LuckyPanel extends JPanel {

    // 尺寸
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    // 背景
    public static BufferedImage background;
    // 候选人
    public static BufferedImage candidate;
    // 状态
    public int status = Constant.STATUS_START;
    // imgList
    public static File[] imgList;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public LuckyPanel() {
        // 背景
        try {
            background = ImageIO.read(LuckyPanel.class.getResource("/image/background.jpg"));
            candidate = ImageIO.read(LuckyPanel.class.getResource("/image/background.jpg"));
            imgList = getAllFile("/candidate/male");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        g.drawImage(candidate, 560, 200, 800, 600, null);
    }

    public void reloadImgList(){
        try {
            imgList = getAllFile("/candidate/male");
            candidate = ImageIO.read(imgList[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File[] getAllFile(String path) {
        String rootPath = LuckyPanel.class.getResource("/").getPath();
        File dir = new File(rootPath + path);
        return dir.listFiles();
    }

    private void changeImg() {
        try {
            int index = (int) (Math.random() * imgList.length);
            candidate = ImageIO.read(imgList[index]);
            repaint();
        } catch (Exception e) {
            changeImg();
        }
    }

    class StartActListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Runnable t = () -> {
                status = Constant.STATUS_RUNNING;
                while (true) {
                    changeImg();
                    // 如果要求停止,
                    if (LuckyPanel.this.status != Constant.STATUS_RUNNING) {
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e1) {
                    }
                }
            };
            Thread t2 = new Thread(t);
            t2.start();
        }
    }

    class StopActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            status = Constant.STATUS_PAUSE;
            System.out.println("结束");
        }
    }

}

