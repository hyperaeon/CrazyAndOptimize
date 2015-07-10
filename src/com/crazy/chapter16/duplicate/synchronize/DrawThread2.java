package com.crazy.chapter16.duplicate.synchronize;

public class DrawThread2 extends Thread {

	private Account account;
	private double drawAmount;

	public DrawThread2(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	public void run() {
		synchronized (account) {
			if (account.getBalance() >= drawAmount) {
				System.out.println(getName() + "取钱成功！取钱：" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("账户余额：" + account.getBalance());
			} else {
				System.out.println(getName() + "取钱失败！余额不足");
			}
		}
	}
}
