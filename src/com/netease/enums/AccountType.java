package com.netease.enums;

/**
 * 账户类型
 * @author ly
 *
 */
public enum AccountType {

	NULL(-1, "NULL"),
	
	CREDIT(0, "信用卡"),
	
	HOUSELOAN(1, "购房贷款"),

	OTHERLOAN(2, "其他贷款"),
	
	WARRANT(3, "为他人担保信");
	
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
		for (AccountType type : AccountType.values()) {
			if (type.getValue() == intValue) {
				return type;
			}
		}
		return NULL;
	}
	
	/**
	 * 根据desc获取枚举类型
	 * @param desc
	 * @return
	 */
	public AccountType getEnumByDesc(String desc) {
		for (AccountType type : AccountType.values()) {
			if (type.getDesc().equals(desc)) {
				return type;
			}
		}
		return NULL;
	}
}
