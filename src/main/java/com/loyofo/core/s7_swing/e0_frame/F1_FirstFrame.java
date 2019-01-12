package com.loyofo.core.s7_swing.e0_frame;

import javax.swing.*;
import java.awt.*;

/**
 * @author luojbin
 * @version 1.0
 * @time 2019-01-12 10:04
 */
public class F1_FirstFrame {

    public static void main(String[] args) {
        // 建议将图形程序放在 EveneQueue 中, 这样可以在完成一系列的初始化工作之后再显示图形窗口
        // 如果直接在主线程中初始化, 在复杂的图形程序时可能会出现问题.
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 创建图形框架
                JFrame frame = new FirstFrame();
                // 设置关闭程序的时机
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // 框架默认不可见, 在完成初始化添加完组件, 需要设置可见性
                frame.setVisible(true);
            }
        });
    }

}

/**
 * JFrame 是图形程序的主框架, 即图形窗口
 * 每个 swing 程序都需要先创建一个主框架, 然后在这个 frame 之上添加其他组件
 */
class FirstFrame extends JFrame {

    private static final int HEIGHT = 300;
    private static final int WIDTH = 500;


    public FirstFrame() {
        // 设置窗口标题
        setTitle("我的首个窗体");
        // 设置窗体图标
        Image icon = new ImageIcon("image/icon.png").getImage();
        setIconImage(icon);

        // 设置框架的大小, 若不指定, 窗口大小为 0*0
        setSize(WIDTH, HEIGHT);
        // 设置位置, 可以用 setLocation/setLocation 或 setLocationByPlatform
        // setLocation 只设置窗口的位置, 多开的时候会完全重叠
        // frame.setLocation(500, 300);
        // setBounds 能一次性设置窗口位置和大小, 多开的时候会完全重叠
        // frame.setBounds(500, 300, 800, 600);
        // setLocationByPlatform 由系统平台设置位置. 在多开的时候会自动偏移
        setLocationByPlatform(true);

        // 可以根据显示器尺寸自动调整窗口大小, 需要通过 Toolkit 获取环境属性
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 通过 toolkit 获取屏幕大小, 返回的 dimension 对象包含了屏幕的尺寸, 多显示器的情况下, 只获取主显示器的参数
        Dimension screenSize = toolkit.getScreenSize();
        double screenHeight = screenSize.getHeight();
        double screenWidth = screenSize.getWidth();
        System.out.println("首选显示器尺寸: " + screenHeight + "*" + screenWidth);

        // 获取多显示器, 不知道怎么用
        // GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // GraphicsDevice[] screens = graphicsEnvironment.getScreenDevices();
    }

}