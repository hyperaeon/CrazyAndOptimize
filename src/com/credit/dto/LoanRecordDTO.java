package com.credit.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 信贷记录
 * @author ly
 *
 */
public class LoanRecordDTO {

	private List<LoanRecordAbstractDTO> loanRecordAbstractDTOList = new ArrayList<LoanRecordAbstractDTO>();//
	
	private List<String> creditDetail = new ArrayList<String>();//从未逾期过的贷记卡及透支未超过60天的准贷记卡账户明细
	
	private List<String> otherLoanOverdueDetail = new ArrayList<String>();//其他贷款发生过逾期的账户明细
	
	private List<String> otherLoanUnoverdueDetail = new ArrayList<String>();//其他贷款从未逾期过的账户明细

	public List<LoanRecordAbstractDTO> getLoanRecordAbstractDTOList() {
		return loanRecordAbstractDTOList;
	}

	public void setLoanRecordAbstractDTOList(
			List<LoanRecordAbstractDTO> loanRecordAbstractDTOList) {
		this.loanRecordAbstractDTOList = loanRecordAbstractDTOList;
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
