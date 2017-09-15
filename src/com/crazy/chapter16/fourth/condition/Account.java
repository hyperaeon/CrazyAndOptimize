package com.crazy.chapter16.fourth.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private String accoutNo;
	
	private double balance;
	
	private boolean flag;
	
	private final Lock lock = new ReentrantLock();
	
	private final Condition condition = lock.newCondition();
	
	public Account() {
		
	}
	
	public Account(String accountNo, double balance) {
		this.accoutNo = accountNo;
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void draw(double amount) {
		lock.lock();
		try {
			if (!flag) {
				condition.await();
			} else {
				System.out.println(Thread.currentThread().getName() + "»°«Æ£∫" + amount);
				balance -= amount;
				System.out.println("”‡∂Ó£∫" + balance);
				flag = false;
				condition.signalAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void deposit(double amount) {
		lock.unlock();
		try {
			if (flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + "¥Ê«Æ£∫" + amount);
				balance += amount;
				System.out.println("”‡∂Ó£∫" + balance);
				flag = true;
				condition.signalAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accoutNo == null) ? 0 : accoutNo.hashCode());
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
		Account other = (Account) obj;
		if (accoutNo == null) {
			if (other.accoutNo != null)
				return false;
		} else if (!accoutNo.equals(other.accoutNo))
			return false;
		return true;
	}
	
	
}
