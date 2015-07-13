package com.crazy.chapter16.duplicate.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();

	private String accountNo;
	private double balance;

	private boolean flag = false;

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	public void draw(double drawAmount) {
		lock.lock();
		try {
			if (!flag) {
				condition.await();
			} else {
				System.out.println(Thread.currentThread().getName() + " 取钱："
						+ drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为：" + balance);
				flag = false;
				condition.signalAll();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void deposit(double depositAmount) {
		lock.lock();
		try {
			if (flag) {
				condition.await();
			} else {
				System.out.println(Thread.currentThread().getName() + " 存款："
						+ depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为：" + balance);
				flag = true;
				condition.signalAll();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
