package com.loyofo.core.s14_concurrent.e0_oldDemo;
/**
 * 守护线程
 * 当一个进程结束时，守护线程会强制退出。
 * 当一个进程中所有前台线程都结束时，进程就会结束。
 */
public class D6_deamon {
	public static void main(String[] args) {
		// rose 只执行5次, 循环结束后关闭线程
		Thread rose = new Thread(() -> {
			for(int i=0;i<5;i++){
				System.out.println("肉丝: let me go!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
			System.out.println("rose:啊啊啊啊啊AAAAAAaaaaaaa...");
			System.out.println("音效:噗通!");
		});

		// jack 无限循环, 但若作为守护线程, 则 rose 线程结束后也随之结束
		Thread jack = new Thread(() -> {
			while (true) {
				System.out.println("杰克: you jump!I jump!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		});
		
		rose.start();
		
		// 将 jack 设为后台守护线程, 要在启动线程之前前显式设定. 若不设置, 则 jack 线程无限运行
		jack.setDaemon(true);
		jack.start();

	}
}







