package com.loyofo.core.s14_concurrent.e0_oldDemo.day10_Thread;

public class SynchronizedStaticDemo {

	public static void main(String[] args) {
		SuperMall uniqlo = new SuperMall("uniqlo");
		SuperMall jackjones = new SuperMall("uniqlo");
		Thread t1 = new Thread(){
			public void run(){
				uniqlo.buy();
				SuperMall.cashier();
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				jackjones.buy();
				SuperMall.cashier();
			}
		};
		t1.start();
		t2.start();

	}

}
class SuperMall{
	String name;
	SuperMall(String aShop){
		this.name=aShop;
	}
	public synchronized static void cashier(){
		try{
			Thread t= Thread.currentThread();
			System.out.println(t.getName()+"正在结账...");
			Thread.sleep(5000);
			System.out.println(t.getName()+"离开商场");
		}catch(Exception e){
		}
		
	}
	
	public void buy(){				//两个人同时进店
		try{
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"正在挑衣服...");
			Thread.sleep(5000);
			
			synchronized(this){		//同步块，只在试衣间排队
			System.out.println(t.getName()+"正在试衣服...");
			Thread.sleep(5000);
			}
				
			}catch(Exception e){
				
			}
		}
}