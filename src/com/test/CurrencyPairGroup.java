package com.test;

import java.util.Date;



/**
 * The persistent class for the CURRENCY_PAIR_GROUP database table.
 * 
 */
public class CurrencyPairGroup {

	private String groupId;

	private String ccy1;

	private String ccy2;

	private String pricingServiceId;

	private String updatedBy;

	private Date updatedDatetime;
	
	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}



	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}



	public CurrencyPairGroup() {
	}

	

	public String getGroupId() {
		return groupId;
	}



	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}



	public String getCcy1() {
		return this.ccy1;
	}

	public void setCcy1(String ccy1) {
		this.ccy1 = ccy1;
	}

	public String getCcy2() {
		return this.ccy2;
	}

	public void setCcy2(String ccy2) {
		this.ccy2 = ccy2;
	}

	public String getPricingServiceId() {
		return this.pricingServiceId;
	}

	public void setPricingServiceId(String pricingServiceId) {
		this.pricingServiceId = pricingServiceId;
	}



	@Override
	public String toString() {
		return "CurrencyPairGroup [groupId=" + groupId + ", ccy1=" + ccy1
				+ ", ccy2=" + ccy2 + ", pricingServiceId=" + pricingServiceId
				+ ", updatedBy=" + updatedBy + ", updatedDatetime="
				+ updatedDatetime + "]";
	}
	
	

}