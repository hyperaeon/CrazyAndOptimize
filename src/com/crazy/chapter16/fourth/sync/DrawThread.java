package com.crazy.chapter16.fourth.sync;

public class DrawThread extends Thread {

	private Account account;
	
	private double drawAmount;
	
	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	public void run() {
		if (account.getBalance() >= drawAmount) {
			System.out.println("¿ªÊ¼ÍÂÇ®£¬amount: " + drawAmount);
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			account.setBalance(account.getBalance() - drawAmount);
			System.out.println("Óà¶î£º " + account.getBalance());
		}
	}
}
