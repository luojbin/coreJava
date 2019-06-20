package com.loyofo.core.s14_concurrent.e0_oldDemo;
/**
 * 守护线程
 * 当一个进程结束时，守护线程会强制退出。
 * 当一个进程中所有前台线程都结束时，进程
 * 就会结束。
 * @author adminitartor
 *
 */
public class D9_deamon {
	public static void main(String[] args) {
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("rose:啊啊啊啊啊AAAAAAaaaaaaa...");
				System.out.println("音效:噗通!");
			}
		};

		Thread jack = new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("you jump!I jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				while (true) {
					System.out.println("haha,i am still alive");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		rose.start();
		
		//后台线程要单独设定，并在start前调用
		jack.setDaemon(true);
		jack.start();

	}
}







