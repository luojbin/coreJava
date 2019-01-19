package com.loyofo.core.s7_swing.g1_vstLucky;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public int status = VstLucky.STATUS_START;
    // imgList
    public static File[] imgList;
    // 中奖者
    public List<BufferedImage> pickedList;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public LuckyPanel() {
        reset();
    }

    @Override
    public void paintComponent(Graphics g) {
        // super.paintComponent(g);
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        g.drawImage(candidate, 560, 200, 800, 600, null);
        int count = pickedList.size();
        for (int i = 0; i< count ; i++) {
            g.drawImage(pickedList.get(i), 10, 130*i + 10, 160, 120, null);
        }
    }

    public File[] getAllFile(String path) {
        String rootPath = LuckyPanel.class.getResource("/").getPath();
        File dir = new File(rootPath + path);
        return dir.listFiles();
    }

    private void reset() {
        try {
            pickedList = new ArrayList<>();
            background = ImageIO.read(LuckyPanel.class.getResource("/image/background.jpg"));
            candidate = null;
            imgList = getAllFile("/candidate/male");
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeImg() {
        try {
            int index = (int) (Math.random() * imgList.length);
            System.out.println(index);
            candidate = ImageIO.read(imgList[index]);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
            changeImg();
        }
    }

    class StartActListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Runnable t = () -> {
                status = VstLucky.STATUS_RUNNING;
                while (true) {
                    changeImg();
                    // 如果要求停止,
                    if (LuckyPanel.this.status != VstLucky.STATUS_RUNNING) {
                        pickedList.add(candidate);
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (Exception e1) {
                        e1.printStackTrace();
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
            status = VstLucky.STATUS_PAUSE;
            System.out.println("结束");
        }
    }

    class ResetActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            reset();
        }
    }

}

