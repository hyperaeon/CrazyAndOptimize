package com.crazy.chapter16.duplicate.synchronize;

public class AccountSafe {

	private String accountNo;
	private double balance;

	public AccountSafe() {
	}

	public AccountSafe(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public synchronized void draw(double drawAmount) {
		if (balance >= drawAmount) {
			System.out.println(Thread.currentThread().getName() + "取钱成功！取出钞票："
					+ drawAmount);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= drawAmount;
			System.out.println("\t余额：" + balance);
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
		if (obj != null && obj.getClass() == Account.class) {
			Account account = (Account) obj;
			return account.getAccountNo().equals(accountNo);
		}
		return false;
	}

}
