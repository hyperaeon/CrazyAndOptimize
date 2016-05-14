package com.credit.dto;

import java.util.Date;

import com.credit.enums.AccumulationType;

public class AccumulationDetailDTO {

	private AccumulationType type;//类型
	
	private String companyName;//公司名称
	
	private Date date;//日期
	
	private String businessAbstract;//业务摘要
	
	private String businessMonth;//业务月份
	
	private Double amount;//发生额
	
	private Double balance;//余额

	public AccumulationType getType() {
		return type;
	}

	public void setType(AccumulationType type) {
		this.type = type;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBusinessAbstract() {
		return businessAbstract;
	}

	public void setBusinessAbstract(String businessAbstract) {
		this.businessAbstract = businessAbstract;
	}

	public String getBusinessMonth() {
		return businessMonth;
	}

	public void setBusinessMonth(String businessMonth) {
		this.businessMonth = businessMonth;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
