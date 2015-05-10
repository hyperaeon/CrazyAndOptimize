package com.crazy.chapter16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionAccount {

	private final ReentrantLock lock = new ReentrantLock();
	
	private final Condition cond = lock.newCondition();
	
	private String accountNo;

	private double balance;

	private boolean flag = false;

	public ConditionAccount(String accountNo, double balance) {
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

	public synchronized void draw(double drawAmount) {
		lock.lock();
		try {
			if (!flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "取钱，取钱金额是" + drawAmount);
				balance -= drawAmount;
				System.out.println("余额是" + balance);
				flag = false;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public synchronized void deposit(double depositAmount) {
		lock.lock();
		try {
			if (flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "存钱，存钱金额是" + depositAmount);
				balance += depositAmount;
				System.out.println("余额是" + balance);
				flag = true;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConditionAccount other = (ConditionAccount) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}

}
