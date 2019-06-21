package com.loyofo.core.s14_concurrent.e0_oldDemo;
/**
 * 互斥锁
 * 当 synchronized 修饰的是两段不同的代码
 * 但是锁对象相同时，那么这两段代码就是互斥的, 不能同时执行。
 */
public class D12_mutex {
	public static void main(String[] args) {
		final Car b = new Car();
		Thread t1 = new Thread(){
			public void run(){
				b.driveToSZ();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				b.driveToBJ();
			}
		};
		t1.start();
		t2.start();
	}
}

class Car {
	public void driveToSZ(){
		synchronized(this){
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+": 把车子开去深圳了...");
				Thread.sleep(5000);
				System.out.println(t.getName()+": 从深圳回来了.");
			} catch (Exception e) {			
			}
		}
	}
	public void driveToBJ(){
		synchronized(this){
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+": 把车子开去北京了...");
				Thread.sleep(5000);
				System.out.println(t.getName()+": 从北京回来了.");
			} catch (Exception e) {			
			}
		}
	}
}







