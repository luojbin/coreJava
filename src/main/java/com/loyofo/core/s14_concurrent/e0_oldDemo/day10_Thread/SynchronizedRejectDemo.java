package com.loyofo.core.s14_concurrent.e0_oldDemo.day10_Thread;

public class SynchronizedRejectDemo {

	public static void main(String[] args) {
		A a = new A();
		A b = new A();
		
		Thread t1 = new Thread(){
			public void run(){
				a.methodaA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				b.methodaB();
				
			}
		};
		
		t1.start();
		t2.start();
	}

}
class A{
	public synchronized void methodaA(){
		try{
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"运行A方法...");
			Thread.sleep(5000);
			System.out.println(t.getName()+"运行A方法结束");
		}catch(Exception e){
			
		}
	}
	public synchronized void methodaB(){
		try{
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"运行B方法...");
			Thread.sleep(5000);
			System.out.println(t.getName()+"运行B方法结束");
		}catch(Exception e){
			
		}
	}
	
}