package com.crazy.chapter16.fourth.sync;

public class Account2 {

	private String accountNo;
	
	private double balance;
	
	private boolean flag;
	
	public Account2() {
		
	}
	
	public Account2(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public synchronized void draw(double amount) {
			try {
				if (!flag) {
					wait();
				} else {
					System.out.println(Thread.currentThread().getName() + " »°«Æ£∫" + amount);
					balance -= amount;
					System.out.println("remainner:" + balance);
					flag = false;
					notifyAll();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public synchronized void deposit(double amount) {
		try {
			if (flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + " ¥Ê«Æ£∫" + amount);
				balance += amount;
				System.out.println("remainner:" + balance);
				flag = true;
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account2 other = (Account2) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}
	
}
