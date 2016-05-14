package com.credit.dto;

import java.util.List;

/**
 * 信贷记录
 * @author hzliyong
 *
 */
public class LoanRecordDTO {

	private int creditAccount;//信用卡账户数

	private int houseLoanAccount;//购房贷款账户数

	private int otherLoanAccount;//其他贷款账户数

	private int unpayedCreditAccount;//信用卡未结清/未销户账户数

	private int unpayedHouseLoanAccount;//购房贷款未结清/未销户账户数

	private int unpayedOtherLoanAccount;//其他贷款未结清/未销户账户数

	private int overdueCreditAccount;//信用卡发生过逾期的账户数

	private int overdueHouseLoanAccount;//购房贷款发生过逾期的账户数

	private int overdueOtherLoanAccount;//其他贷款发生过逾期的账户数

	private int overdueNintyCreditAccount;//信用卡发生过90天以上逾期的账户数

	private int overdueNintyHouseLoanAccount;//购房贷款发生过90天以上逾期的账户数

	private int overdueNintyOtherLoanAccount;//其他贷款发生过90天以上逾期的账户数

	private int warrantCreditAmount;//信用卡为他人担保笔数

	private int warrantLoanAmount;//购房贷款为他人担保笔数

	private int warrantOtherLoanAmount;//其他贷款为他人担保笔数

	private List<String> creditDetail;//从未逾期过的贷记卡及透支未超过60天的准贷记卡账户明细
	
	private List<String> otherLoanOverdueDetail;//其他贷款发生过逾期的账户明细
	
	private List<String> otherLoanUnoverdueDetail;//其他贷款从未逾期过的账户明细

	public int getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(int creditAccount) {
		this.creditAccount = creditAccount;
	}

	public int getHouseLoanAccount() {
		return houseLoanAccount;
	}

	public void setHouseLoanAccount(int houseLoanAccount) {
		this.houseLoanAccount = houseLoanAccount;
	}

	public int getOtherLoanAccount() {
		return otherLoanAccount;
	}

	public void setOtherLoanAccount(int otherLoanAccount) {
		this.otherLoanAccount = otherLoanAccount;
	}

	public int getUnpayedCreditAccount() {
		return unpayedCreditAccount;
	}

	public void setUnpayedCreditAccount(int unpayedCreditAccount) {
		this.unpayedCreditAccount = unpayedCreditAccount;
	}

	public int getUnpayedHouseLoanAccount() {
		return unpayedHouseLoanAccount;
	}

	public void setUnpayedHouseLoanAccount(int unpayedHouseLoanAccount) {
		this.unpayedHouseLoanAccount = unpayedHouseLoanAccount;
	}

	public int getUnpayedOtherLoanAccount() {
		return unpayedOtherLoanAccount;
	}

	public void setUnpayedOtherLoanAccount(int unpayedOtherLoanAccount) {
		this.unpayedOtherLoanAccount = unpayedOtherLoanAccount;
	}

	public int getOverdueCreditAccount() {
		return overdueCreditAccount;
	}

	public void setOverdueCreditAccount(int overdueCreditAccount) {
		this.overdueCreditAccount = overdueCreditAccount;
	}

	public int getOverdueHouseLoanAccount() {
		return overdueHouseLoanAccount;
	}

	public void setOverdueHouseLoanAccount(int overdueHouseLoanAccount) {
		this.overdueHouseLoanAccount = overdueHouseLoanAccount;
	}

	public int getOverdueOtherLoanAccount() {
		return overdueOtherLoanAccount;
	}

	public void setOverdueOtherLoanAccount(int overdueOtherLoanAccount) {
		this.overdueOtherLoanAccount = overdueOtherLoanAccount;
	}

	public int getOverdueNintyCreditAccount() {
		return overdueNintyCreditAccount;
	}

	public void setOverdueNintyCreditAccount(int overdueNintyCreditAccount) {
		this.overdueNintyCreditAccount = overdueNintyCreditAccount;
	}

	public int getOverdueNintyHouseLoanAccount() {
		return overdueNintyHouseLoanAccount;
	}

	public void setOverdueNintyHouseLoanAccount(int overdueNintyHouseLoanAccount) {
		this.overdueNintyHouseLoanAccount = overdueNintyHouseLoanAccount;
	}

	public int getOverdueNintyOtherLoanAccount() {
		return overdueNintyOtherLoanAccount;
	}

	public void setOverdueNintyOtherLoanAccount(int overdueNintyOtherLoanAccount) {
		this.overdueNintyOtherLoanAccount = overdueNintyOtherLoanAccount;
	}

	public int getWarrantCreditAmount() {
		return warrantCreditAmount;
	}

	public void setWarrantCreditAmount(int warrantCreditAmount) {
		this.warrantCreditAmount = warrantCreditAmount;
	}

	public int getWarrantLoanAmount() {
		return warrantLoanAmount;
	}

	public void setWarrantLoanAmount(int warrantLoanAmount) {
		this.warrantLoanAmount = warrantLoanAmount;
	}

	public int getWarrantOtherLoanAmount() {
		return warrantOtherLoanAmount;
	}

	public void setWarrantOtherLoanAmount(int warrantOtherLoanAmount) {
		this.warrantOtherLoanAmount = warrantOtherLoanAmount;
	}

	public List<String> getCreditDetail() {
		return creditDetail;
	}

	public void setCreditDetail(List<String> creditDetail) {
		this.creditDetail = creditDetail;
	}

	public List<String> getOtherLoanOverdueDetail() {
		return otherLoanOverdueDetail;
	}

	public void setOtherLoanOverdueDetail(List<String> otherLoanOverdueDetail) {
		this.otherLoanOverdueDetail = otherLoanOverdueDetail;
	}

	public List<String> getOtherLoanUnoverdueDetail() {
		return otherLoanUnoverdueDetail;
	}

	public void setOtherLoanUnoverdueDetail(List<String> otherLoanUnoverdueDetail) {
		this.otherLoanUnoverdueDetail = otherLoanUnoverdueDetail;
	}
	
}
