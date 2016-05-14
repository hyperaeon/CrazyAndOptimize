package com.credit.dto;

import java.util.List;

/**
 * 信贷记录
 * @author hzliyong
 *
 */
public class LoanRecordDTO {

	private List<LoanRecordAbstractDTO> lanRecordAbstractDTOList;//
	
	private List<String> creditDetail;//从未逾期过的贷记卡及透支未超过60天的准贷记卡账户明细
	
	private List<String> otherLoanOverdueDetail;//其他贷款发生过逾期的账户明细
	
	private List<String> otherLoanUnoverdueDetail;//其他贷款从未逾期过的账户明细

	public List<LoanRecordAbstractDTO> getLanRecordAbstractDTOList() {
		return lanRecordAbstractDTOList;
	}

	public void setLanRecordAbstractDTOList(
			List<LoanRecordAbstractDTO> lanRecordAbstractDTOList) {
		this.lanRecordAbstractDTOList = lanRecordAbstractDTOList;
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
