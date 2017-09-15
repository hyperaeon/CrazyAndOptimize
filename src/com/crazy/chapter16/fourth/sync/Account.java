package com.crazy.chapter16.fourth.sync;

public class Account {

	private String accountNO;
	
	private double balance;
	
	public Account() {
		
	}
	
	public Account(String accountNO, double balance) {
		this.accountNO = accountNO;
		this.balance = balance;
	}

	public String getAccountNO() {
		return accountNO;
	}

	public void setAccountNO(String accountNO) {
		this.accountNO = accountNO;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNO == null) ? 0 : accountNO.hashCode());
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
		if (accountNO == null) {
			if (other.accountNO != null)
				return false;
		} else if (!accountNO.equals(other.accountNO))
			return false;
		return true;
	}
	
}
