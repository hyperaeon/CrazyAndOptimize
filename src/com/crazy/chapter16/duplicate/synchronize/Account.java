package com.crazy.chapter16.duplicate.synchronize;

public class Account {

	private String accountNo;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
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
		if (obj != null && obj.getClass() == Account.class) {
			Account target = (Account) obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo the accountNo to set
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

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
