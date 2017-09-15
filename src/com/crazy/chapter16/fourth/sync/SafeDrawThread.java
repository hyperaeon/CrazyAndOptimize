package com.crazy.chapter16.fourth.sync;

public class SafeDrawThread extends Thread {

	private Account account;
	
	private double drawAmount;
	
	public SafeDrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	public void run() {
		synchronized(account) {
			if (account.getBalance() >= drawAmount) {
				System.out.println(getName() + " ¿ªÊ¼ÍÂÇ®£¬amount: " + drawAmount);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println(getName() + " Óà¶î£º " + account.getBalance());
			}
		}
	}
}
