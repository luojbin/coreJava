package com.loyofo.core.s14_concurrent.e0_oldDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程提供了方法:
 * static void sleep(long ms)
 * 该方法会导致运行该方法的线程阻塞指定毫秒
 * 超时以后该线程会自动回到RUNNABLE状态等待
 * 再次获取CPU时间并发运行
 * 常用sleep方法做定时或周期间隔时间使用
 * @author adminitartor
 *
 */
public class D7_sleep {
	public static void main(String[] args) {
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		Runnable r = new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("插队！");
				}
			}
		};
		Runnable r2 = new Runnable() {
			public void run() {
				while (true) {
					String timeStr = fmt.format(new Date());
					System.out.println(timeStr);
					//使用Thread.sleep制造阻塞停顿
					//可能会抛出异常，使用try-catch结构
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t = new Thread(r);
		Thread t2 = new Thread(r2);
		t.start();
		t2.start();
	}
}







