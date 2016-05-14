package com.credit.dto;

import java.util.Date;

import com.credit.enums.CredentialType;

/**
 * 公积金概要信息
 * @author hzliyong
 *
 */
public class AccumulationAbstractDTO {

	private CredentialType type;//证件类型
	
	private String credentialNumber;//证件号
	
	private String name;//姓名
	
	private String clientNumber;//客户号

	private String company;//单位
	
	private Double monthAmount;//月缴额
	
	private Double balanceAmount;//余额

	private int state;//状态
	
	private Date dataTime;//数据时间
	
	private Date dataRefreshTime;//数据刷新时间

	public CredentialType getType() {
		return type;
	}

	public void setType(CredentialType type) {
		this.type = type;
	}

	public String getCredentialNumber() {
		return credentialNumber;
	}

	public void setCredentialNumber(String credentialNumber) {
		this.credentialNumber = credentialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getMonthAmount() {
		return monthAmount;
	}

	public void setMonthAmount(Double monthAmount) {
		this.monthAmount = monthAmount;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	public Date getDataRefreshTime() {
		return dataRefreshTime;
	}

	public void setDataRefreshTime(Date dataRefreshTime) {
		this.dataRefreshTime = dataRefreshTime;
	}
	
}
