package com.crazy.chapter16;

public class SyncAccount {

	private String accountNo;

	private double balance;

	public SyncAccount() {
	}

	public SyncAccount(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public synchronized void draw(double drawAmount) {
		if (drawAmount <= balance) {
			System.out.println(Thread.currentThread().getName() + "取钱成功！，取钱金额："
					+ drawAmount);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= drawAmount;
			System.out.println(Thread.currentThread().getName() + "取钱后的余额是："
					+ balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足");
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}

	/* (non-Javadoc)
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
		SyncAccount other = (SyncAccount) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}

}
