package com.credit.enums;

public enum AccountType {

	NULL(0, "NULL"),
	
	CREDIT(1, "信用卡"),
	
	HOUSELOAN(2, "购房贷款"),

	OTHERLOAN(3, "其他贷款");
	
	private int value;
	
	private String desc;
	
	public int getValue() {
		return value;
	}
	
	public String getDesc() {
		return desc;
	}
	
	private AccountType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public AccountType getEnumByIntValue(int intValue) {
		for (AccountType type: AccountType.values()) {
			if (type.getValue() == intValue) {
				return type;
			}
		}
		return NULL;
	}
}
