package com.crontab;

import java.math.BigDecimal;

public class LegacyFxOrder {
	private String ordrId;
	private String productCategoryId;
	private String baseCrncyId;
	private String cntrCrncyId;
	private String custId;
	private BigDecimal baseCrncyAmt;
	private BigDecimal cntrCrncyAmt;
	
	private String isAggregate;
	private String isBackToBack;
	private String ordrTypeId;
	
	private String logNum;

	public String getOrdrId() {
		return ordrId;
	}

	public void setOrdrId(String ordrId) {
		this.ordrId = ordrId;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getBaseCrncyId() {
		return baseCrncyId;
	}

	public void setBaseCrncyId(String baseCrncyId) {
		this.baseCrncyId = baseCrncyId;
	}

	public String getCntrCrncyId() {
		return cntrCrncyId;
	}

	public void setCntrCrncyId(String cntrCrncyId) {
		this.cntrCrncyId = cntrCrncyId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public BigDecimal getBaseCrncyAmt() {
		return baseCrncyAmt;
	}

	public void setBaseCrncyAmt(BigDecimal baseCrncyAmt) {
		this.baseCrncyAmt = baseCrncyAmt;
	}

	public BigDecimal getCntrCrncyAmt() {
		return cntrCrncyAmt;
	}

	public void setCntrCrncyAmt(BigDecimal cntrCrncyAmt) {
		this.cntrCrncyAmt = cntrCrncyAmt;
	}

	public String getIsAggregate() {
		return isAggregate;
	}

	public void setIsAggregate(String isAggregate) {
		this.isAggregate = isAggregate;
	}

	public String getIsBackToBack() {
		return isBackToBack;
	}

	public void setIsBackToBack(String isBackToBack) {
		this.isBackToBack = isBackToBack;
	}

	public String getOrdrTypeId() {
		return ordrTypeId;
	}

	public void setOrdrTypeId(String ordrTypeId) {
		this.ordrTypeId = ordrTypeId;
	}

	public String getLogNum() {
		return logNum;
	}

	public void setLogNum(String logNum) {
		this.logNum = logNum;
	}

}
