package com.crazy.chapter16.fourth.sync;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockAccount {

	private final ReentrantLock lock = new ReentrantLock();
	
	private String accoutNo;
	
	private double balance;
	
	public ReentrantLockAccount() {
		
	}
	
	public ReentrantLockAccount(String accountNo, double balance) {
		this.accoutNo = accountNo;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	
	public void draw(double drawAmount) {
		lock.lock();
		try {
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + "»°«Æ≥…π¶£¨" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("”‡∂Ó£∫" + balance);
			} else {
				System.out.println(Thread.currentThread().getName() + " failed");
			}
		} catch (Exception e) {
			
		} finally {
			lock.unlock();
		}
	}
	
}
