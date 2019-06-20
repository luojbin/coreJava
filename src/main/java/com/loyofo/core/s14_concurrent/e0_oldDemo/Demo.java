package com.loyofo.core.s14_concurrent.e0_oldDemo;

public class Demo {
	public boolean getMoney(int money){
		int account = getAccount();
		if(account>=money){
			account = account - money;
			saveAccount(account);
			return true;
		}
		return false;
		
	}
	public void saveAccount(int account){
		
	}
	
	public int getAccount(){
		return 1000;
	}
}
