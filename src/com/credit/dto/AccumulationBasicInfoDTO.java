package com.credit.dto;

public class AccumulationBasicInfoDTO {

	private int id;//用户公积金ID

	private int destrictId;//地区id
	
	private String account;//用户账号

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDestrictId() {
		return destrictId;
	}

	public void setDestrictId(int destrictId) {
		this.destrictId = destrictId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
}
