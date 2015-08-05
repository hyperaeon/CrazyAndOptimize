package com.crontab;

import java.util.Date;


public class OrderSizeTier  {
	private String currency;

	private double factor;

	private String groupId;

	private long maxSize;

	private long minSize;

	private int tierLevel;

	private String updatedBy;

	private Date updatedDatetime;

	public OrderSizeTier() {
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getFactor() {
		return this.factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}



	

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public long getMaxSize() {
		return this.maxSize;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public long getMinSize() {
		return this.minSize;
	}

	public void setMinSize(long minSize) {
		this.minSize = minSize;
	}

	public int getTierLevel() {
		return this.tierLevel;
	}

	public void setTierLevel(int tierLevel) {
		this.tierLevel = tierLevel;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDatetime() {
		return this.updatedDatetime;
	}

	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = (Date) updatedDatetime.clone();
	}

	@Override
	public String toString() {
		return "OrderSizeTier [currency=" + currency + ", factor=" + factor
				+ ", groupId=" + groupId + ", maxSize=" + maxSize
				+ ", minSize=" + minSize + ", tierLevel=" + tierLevel
				+ ", updatedBy=" + updatedBy + ", updatedDatetime="
				+ updatedDatetime + "]";
	}
	

}