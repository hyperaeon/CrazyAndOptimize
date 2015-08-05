package com.crontab;

import com.test.CurrencyPairGroup;


public abstract class AbstractJson {

	protected CurrencyPairGroup currencyPairGroup;

	protected String lastUpdatedById;

	protected Long lastUpdatedDttm;

	public CurrencyPairGroup getCurrencyPairGroup() {
		return currencyPairGroup;
	}

	public void setCurrencyPairGroup(CurrencyPairGroup currencyPairGroup) {
		this.currencyPairGroup = currencyPairGroup;
	}

	public String getLastUpdatedById() {
		return lastUpdatedById;
	}

	public void setLastUpdatedById(String lastUpdatedById) {
		this.lastUpdatedById = lastUpdatedById;
	}

	public Long getLastUpdatedDttm() {
		return lastUpdatedDttm;
	}

	public void setLastUpdatedDttm(Long lastUpdatedDttm) {
		this.lastUpdatedDttm = lastUpdatedDttm;
	}

}
