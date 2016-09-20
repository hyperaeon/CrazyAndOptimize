package com.netease.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 信贷记录
 * @author hzliyong
 *
 */
public class LoanRecordDTO {

	private List<LoanRecordAbstractDTO> loanRecordAbstractDTOList = new ArrayList<LoanRecordAbstractDTO>();//信贷信息概要
	
	private List<LoanDetailDTO> loanDetailDTOList = new ArrayList<LoanDetailDTO>();//信贷记录明细
	
	public List<LoanRecordAbstractDTO> getLoanRecordAbstractDTOList() {
		return loanRecordAbstractDTOList;
	}

	public void setLoanRecordAbstractDTOList(
			List<LoanRecordAbstractDTO> loanRecordAbstractDTOList) {
		this.loanRecordAbstractDTOList = loanRecordAbstractDTOList;
	}

	public List<LoanDetailDTO> getLoanDetailDTOList() {
		return loanDetailDTOList;
	}

	public void setLoanDetailDTOList(List<LoanDetailDTO> loanDetailDTOList) {
		this.loanDetailDTOList = loanDetailDTOList;
	}

}
