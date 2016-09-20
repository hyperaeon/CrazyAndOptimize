package com.netease.dto;

import com.netease.enums.AccountType;

/**
 * 信贷信息概要
 * @author hzliyong
 *
 */
public class LoanRecordAbstractDTO {

	private int accountAmount;//账户数

	private int unpayedAccount;//未结清/未销户账户数

	private int overdueAccount;//发生过逾期的账户数

	private int overdueNintyAccount;//发生过90天以上逾期的账户数

	private int warrantAmount;//为他人担保笔数

	private AccountType accountType;//账户类型

	public int getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(int accountAmount) {
		this.accountAmount = accountAmount;
	}

	public int getUnpayedAccount() {
		return unpayedAccount;
	}

	public void setUnpayedAccount(int unpayedAccount) {
		this.unpayedAccount = unpayedAccount;
	}

	public int getOverdueAccount() {
		return overdueAccount;
	}

	public void setOverdueAccount(int overdueAccount) {
		this.overdueAccount = overdueAccount;
	}

	public int getOverdueNintyAccount() {
		return overdueNintyAccount;
	}

	public void setOverdueNintyAccount(int overdueNintyAccount) {
		this.overdueNintyAccount = overdueNintyAccount;
	}

	public int getWarrantAmount() {
		return warrantAmount;
	}

	public void setWarrantAmount(int warrantAmount) {
		this.warrantAmount = warrantAmount;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
}
