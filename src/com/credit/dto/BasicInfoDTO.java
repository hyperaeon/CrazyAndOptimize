package com.credit.dto;

import java.util.Date;

import com.credit.enums.CredentialType;

/**
 * 个人基本信息
 * @author hzliyong
 *
 */
public class BasicInfoDTO {

	private String reportNumber;//报告编号
	
	private Date queryTime;//查询时间
	
	private Date reportTime;//报告时间
	
	private String name;//姓名
	
	private CredentialType credentialType;//证件类型
	
	private String credentialNumber;//证件号码
	
	private int isMarried;//是否已婚

	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}

	public Date getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(Date queryTime) {
		this.queryTime = queryTime;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CredentialType getCredentialType() {
		return credentialType;
	}

	public void setCredentialType(CredentialType credentialType) {
		this.credentialType = credentialType;
	}

	public String getCredentialNumber() {
		return credentialNumber;
	}

	public void setCredentialNumber(String credentialNumber) {
		this.credentialNumber = credentialNumber;
	}

	public int getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(int isMarried) {
		this.isMarried = isMarried;
	}
	
	
	
}
