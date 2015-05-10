package com.crazy.chapter16;

public class TraditionalAccount {

	private String accountNo;

	private double balance;

	private boolean flag = false;

	public TraditionalAccount(String accountNo, double balance) {
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
		try {
			if (!flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "取钱，取钱金额是" + drawAmount);
				balance -= drawAmount;
				System.out.println("余额是" + balance);
				flag = false;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void deposit(double depositAmount) {
		try {
			if (flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "存钱，存钱金额是" + depositAmount);
				balance += depositAmount;
				System.out.println("余额是" + balance);
				flag = true;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
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
		TraditionalAccount other = (TraditionalAccount) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}

}
