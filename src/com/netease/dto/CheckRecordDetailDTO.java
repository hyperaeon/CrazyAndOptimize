package com.netease.dto;

import java.util.Date;

public class CheckRecordDetailDTO {

	private Date checkDate;//查询日期
	
	private String checkOperator;//查询操作员
	
	private String checkReason;//查询原因

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckOperator() {
		return checkOperator;
	}

	public void setCheckOperator(String checkOperator) {
		this.checkOperator = checkOperator;
	}

	public String getCheckReason() {
		return checkReason;
	}

	public void setCheckReason(String checkReason) {
		this.checkReason = checkReason;
	}
	
	
}
