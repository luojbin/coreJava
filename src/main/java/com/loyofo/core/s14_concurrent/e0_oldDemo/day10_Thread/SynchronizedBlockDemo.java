package com.loyofo.core.s14_concurrent.e0_oldDemo.day10_Thread;

public class SynchronizedBlockDemo {

	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		Shop uniqlo = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				uniqlo.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				uniqlo.buy();
			}
		};
		t1.start();
		t2.start();
	}

}

class Shop{
	
	/*
	public synchronized void buy(){		//加锁，避免两个人同时进入同一试衣间
	//public void buy(){				//两个人同时进入了试衣间。。。
		try{
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"正在挑衣服...");
			Thread.sleep(5000);
			
			{
			System.out.println(t.getName()+"正在试衣服...");
			Thread.sleep(5000);
			}

			System.out.println(t.getName()+"结账离开...");
			Thread.sleep(2000);
			
			System.out.println(t.getName()+"交易完成...");
			
		}catch(Exception e){
			
		}
	}*/
	
	public void buy(){				//两个人同时进店
		try{
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"正在挑衣服...");
			Thread.sleep(5000);
			
			synchronized(this){		//同步块，只在试衣间排队
			System.out.println(t.getName()+"正在试衣服...");
			Thread.sleep(5000);
			}
			
			System.out.println(t.getName()+"结账离开...");
			Thread.sleep(2000);

			System.out.println(t.getName()+"交易完成...");
				
			}catch(Exception e){
				
			}
		}
}