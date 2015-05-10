package com.crazy.chapter16;

import java.util.concurrent.locks.ReentrantLock;

public class LockAccount {

	private final ReentrantLock lock = new ReentrantLock();

	private String accountNo;

	private double balance;

	public LockAccount() {
	}

	public LockAccount(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void draw(double drawAmount) {
		lock.lock();
		try {
			if (drawAmount <= balance) {
				System.out.println(Thread.currentThread().getName()
						+ "ȡǮ�ɹ�����ȡǮ��" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println(Thread.currentThread().getName()
						+ "ȡǮ�������ǣ�" + balance);
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "ȡǮʧ�ܣ�����");
			}
		} finally {
			lock.unlock();
		}
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
		LockAccount other = (LockAccount) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}

}
